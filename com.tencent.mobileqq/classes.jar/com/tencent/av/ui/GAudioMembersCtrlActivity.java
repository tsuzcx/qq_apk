package com.tencent.av.ui;

import actn;
import ajyc;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bfol;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import ldw;
import lfg;
import lfu;
import lgf;
import lzj;
import mdq;
import mdw;
import mdx;
import mdy;
import mdz;
import mea;
import meb;
import mec;
import med;
import msq;

public class GAudioMembersCtrlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mdw(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoController a;
  public VideoAppInterface a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<ldw> jdField_a_of_type_JavaUtilArrayList;
  private lfg jdField_a_of_type_Lfg = new mec(this);
  private lfu jdField_a_of_type_Lfu = new mdx(this);
  public mdq a;
  private boolean jdField_a_of_type_Boolean = true;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  
  public GAudioMembersCtrlActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      if (!this.jdField_a_of_type_Boolean) {
        break label43;
      }
    }
    label43:
    for (String str = ajyc.a(2131705148);; str = ajyc.a(2131705147))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(str, new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Mdq != null) {
      this.jdField_a_of_type_Mdq.a(paramLong, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    lzj.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  @TargetApi(14)
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131375491);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      localRelativeLayout.setFitsSystemWindows(true);
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368472));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131368434);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131377850));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372376));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (bool)
    {
      localRelativeLayout.setBackgroundColor(Color.parseColor("#000000"));
      super.findViewById(2131377369).setBackgroundColor(-16777216);
      super.findViewById(2131371719).setBackgroundColor(Color.parseColor("#000000"));
      ((TextView)super.findViewById(2131368429)).setBackgroundDrawable(getResources().getDrawable(2130849034));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = super.getLayoutInflater().inflate(2131559518, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      if (!bool) {
        break label383;
      }
      ((View)localObject).findViewById(2131375491).setBackgroundColor(Color.parseColor("#080808"));
      ((TextView)((View)localObject).findViewById(2131377044)).setTextColor(Color.parseColor("#757575"));
    }
    label383:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new mdy(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new mdz(this));
      return;
      View localView = new View(localRelativeLayout.getContext());
      if (bool) {}
      for (localObject = "#080808";; localObject = "#F5F6FA")
      {
        localView.setBackgroundColor(Color.parseColor((String)localObject));
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, actn.a(12.0F, localRelativeLayout.getResources())));
        localObject = localView;
        break;
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "showMenuMuteAll");
    }
    b();
    bfol localbfol = bfol.c(this);
    View localView = super.getLayoutInflater().inflate(2131559514, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131372260);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localbfol.a(localView);
    localView = new View(this);
    localView.setBackgroundColor(Color.parseColor("#E5E6E7"));
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, actn.a(1.0F, getResources())));
    localbfol.a(localView);
    localView = super.getLayoutInflater().inflate(2131558434, null);
    TextView localTextView2 = (TextView)localView.findViewById(2131361914);
    localView.setId(0);
    localView.setBackgroundDrawable(super.getResources().getDrawable(2130837559));
    boolean bool = msq.h();
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().U)
    {
      localTextView2.setText(super.getString(2131695833));
      localTextView2.setTextColor(super.getResources().getColor(2131165204));
      if (bool) {}
      for (i = 2131695834;; i = 2131695835)
      {
        localTextView1.setText(super.getString(i));
        localbfol.a(localView);
        localbfol.d(super.getResources().getString(2131690573));
        localView.setOnClickListener(new mea(this, localbfol));
        localbfol.setOnDismissListener(new meb(this));
        localbfol.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_AndroidAppDialog = localbfol;
        try
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
        }
        catch (Exception localException) {}
      }
    }
    else
    {
      localTextView2.setText(super.getString(2131695836));
      localTextView2.setTextColor(super.getResources().getColor(2131165201));
      if (bool) {}
      for (i = 2131695837;; i = 2131695838)
      {
        localTextView1.setText(super.getString(i));
        break;
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshGAFList");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_b_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_ComTencentAvVideoController.c().size();
        this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a(i, this.jdField_a_of_type_ComTencentAvVideoController.a());
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentAvVideoController.e().clone());
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "refreshGAFList-->mVideoContrl is null");
      }
    }
  }
  
  public void a()
  {
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (locallgf != null)
    {
      if (locallgf.U) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131695833));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131695836));
  }
  
  @TargetApi(11)
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "drawUI-->type=" + paramInt1 + " uin=" + paramLong + " fresh=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      if ((paramInt1 == 0) || (paramInt1 == 1)) {
        c();
      }
      if (paramInt2 == 42)
      {
        a(paramLong, true);
        return;
      }
    } while (paramInt2 != 43);
    a(paramLong, false);
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshUI-->uin=" + paramLong + " type=" + paramInt1 + " isRefreshTitle=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "refreshUI-->uin == 0");
      }
      return;
    }
    super.runOnUiThread(new GAudioMembersCtrlActivity.RefreshUIRunnable(this, paramInt1, paramLong, paramBoolean, paramInt2));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  void c()
  {
    f();
    if (this.jdField_a_of_type_Mdq != null) {
      this.jdField_a_of_type_Mdq.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
    }
    super.setTheme(2131755147);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559516);
    paramBundle = super.getIntent().getStringExtra("discussUin");
    this.jdField_a_of_type_Boolean = super.getIntent().getBooleanExtra("Owner", true);
    this.jdField_b_of_type_Boolean = super.getIntent().getBooleanExtra("isInRoom", true);
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (TextUtils.isEmpty(paramBundle))
    {
      finish();
      return false;
    }
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.a(true, getWindow());
    d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
    f();
    this.jdField_a_of_type_Mdq = new mdq(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentAvVideoController.a().g, this.jdField_a_of_type_ComTencentAvVideoController.a().E, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Mdq.a(this.jdField_a_of_type_JavaUtilArrayList);
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfg);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfu);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new med(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate end , cost time : " + (System.currentTimeMillis() - l) + "ms");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfg);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfu);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Mdq.b();
    this.jdField_a_of_type_Mdq = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_AndroidWidgetTextView = null;
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "doOnDestroy");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMembersCtrlActivity", 2, "", localException);
        }
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    a(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new GAudioMembersCtrlActivity.RefreshFaceRunnable(this, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
    a();
    a(true);
  }
  
  public void finish()
  {
    super.finish();
    super.overridePendingTransition(0, 2130771978);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131372376) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity
 * JD-Core Version:    0.7.0.1
 */