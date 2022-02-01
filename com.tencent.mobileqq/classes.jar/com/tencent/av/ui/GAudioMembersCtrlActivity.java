package com.tencent.av.ui;

import Override;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import bkzi;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import lcu;
import lee;
import les;
import lfe;
import lzr;
import meg;
import mem;
import men;
import meo;
import mep;
import meq;
import mer;
import mes;
import met;
import mtr;

public class GAudioMembersCtrlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mem(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoController a;
  public VideoAppInterface a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<lcu> jdField_a_of_type_JavaUtilArrayList;
  private lee jdField_a_of_type_Lee = new mes(this);
  private les jdField_a_of_type_Les = new men(this);
  public meg a;
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
    for (String str = anvx.a(2131704626);; str = anvx.a(2131704625))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(str, new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Meg != null) {
      this.jdField_a_of_type_Meg.a(paramLong, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    lzr.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  @TargetApi(14)
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131376947);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      localRelativeLayout.setFitsSystemWindows(true);
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369278));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131369238);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131379545));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373628));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (bool)
    {
      localRelativeLayout.setBackgroundColor(Color.parseColor("#000000"));
      super.findViewById(2131379020).setBackgroundColor(-16777216);
      super.findViewById(2131372899).setBackgroundColor(Color.parseColor("#000000"));
      ((TextView)super.findViewById(2131369231)).setBackgroundDrawable(getResources().getDrawable(2130850117));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = super.getLayoutInflater().inflate(2131559750, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      if (!bool) {
        break label383;
      }
      ((View)localObject).findViewById(2131376947).setBackgroundColor(Color.parseColor("#080808"));
      ((TextView)((View)localObject).findViewById(2131378673)).setTextColor(Color.parseColor("#757575"));
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
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new meo(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new mep(this));
      return;
      View localView = new View(localRelativeLayout.getContext());
      if (bool) {}
      for (localObject = "#080808";; localObject = "#F5F6FA")
      {
        localView.setBackgroundColor(Color.parseColor((String)localObject));
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(12.0F, localRelativeLayout.getResources())));
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
    bkzi localbkzi = bkzi.c(this);
    View localView = super.getLayoutInflater().inflate(2131559746, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131373511);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localbkzi.a(localView);
    localView = new View(this);
    localView.setBackgroundColor(Color.parseColor("#E5E6E7"));
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, AIOUtils.dp2px(1.0F, getResources())));
    localbkzi.a(localView);
    localView = super.getLayoutInflater().inflate(2131558440, null);
    TextView localTextView2 = (TextView)localView.findViewById(2131361971);
    localView.setId(0);
    localView.setBackgroundDrawable(super.getResources().getDrawable(2130837571));
    boolean bool = mtr.i();
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().W)
    {
      localTextView2.setText(super.getString(2131695273));
      localTextView2.setTextColor(super.getResources().getColor(2131165204));
      if (bool) {}
      for (i = 2131695274;; i = 2131695275)
      {
        localTextView1.setText(super.getString(i));
        localbkzi.a(localView);
        localbkzi.d(super.getResources().getString(2131690677));
        localView.setOnClickListener(new meq(this, localbkzi));
        localbkzi.setOnDismissListener(new mer(this));
        localbkzi.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_AndroidAppDialog = localbkzi;
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
      localTextView2.setText(super.getString(2131695276));
      localTextView2.setTextColor(super.getResources().getColor(2131165201));
      if (bool) {}
      for (i = 2131695277;; i = 2131695278)
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
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (locallfe != null)
    {
      if (locallfe.W) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131695273));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131695276));
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
    if (this.jdField_a_of_type_Meg != null) {
      this.jdField_a_of_type_Meg.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
    }
    super.setTheme(2131755153);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559748);
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
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      ImmersiveUtils.a(bool, getWindow());
      d();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break;
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
    f();
    this.jdField_a_of_type_Meg = new meg(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentAvVideoController.a().g, this.jdField_a_of_type_ComTencentAvVideoController.a().F, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Meg.a(this.jdField_a_of_type_JavaUtilArrayList);
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lee);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Les);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new met(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate end , cost time : " + (System.currentTimeMillis() - l) + "ms");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lee);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Les);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Meg.b();
    this.jdField_a_of_type_Meg = null;
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
    if (paramView.getId() == 2131373628) {
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity
 * JD-Core Version:    0.7.0.1
 */