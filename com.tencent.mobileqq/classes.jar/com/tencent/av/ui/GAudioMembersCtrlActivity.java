package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import jux;
import juy;
import juz;
import jva;
import jvf;
import jvg;
import jvh;

public class GAudioMembersCtrlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoController a;
  private GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jva(this);
  public VideoAppInterface a;
  public GAudioMemberListCtrl a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private TextView b;
  private TextView c;
  
  public GAudioMembersCtrlActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl != null) {
      this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a(paramLong, paramBoolean);
    }
  }
  
  @TargetApi(14)
  private void d()
  {
    Object localObject = (RelativeLayout)super.findViewById(2131362822);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
      }
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363363));
    this.b = ((TextView)super.findViewById(2131363227));
    this.c = ((TextView)super.findViewById(2131363410));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131365951));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365952));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localObject = super.getLayoutInflater().inflate(2130969292, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("发言管理");
    this.c.setText("关闭");
    this.c.setOnClickListener(new jux(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "showMenuMuteAll");
    }
    b();
    ActionSheet localActionSheet = ActionSheet.c(this);
    View localView = super.getLayoutInflater().inflate(2130969288, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131365949);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localActionSheet.a(localView);
    localView = super.getLayoutInflater().inflate(2130968600, null);
    TextView localTextView2 = (TextView)localView.findViewById(2131362793);
    localView.setId(0);
    localView.setBackgroundDrawable(super.getResources().getDrawable(2130837531));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().V)
    {
      localTextView2.setText(super.getString(2131429151));
      localTextView2.setTextColor(super.getResources().getColor(2131493054));
      localTextView1.setText(super.getString(2131429153));
    }
    for (;;)
    {
      localActionSheet.a(localView);
      localActionSheet.d(super.getResources().getString(2131433682));
      localView.setOnClickListener(new juy(this, localActionSheet));
      localActionSheet.setOnDismissListener(new juz(this));
      localActionSheet.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Exception localException) {}
      localTextView2.setText(super.getString(2131429150));
      localTextView2.setTextColor(super.getResources().getColor(2131493055));
      localTextView1.setText(super.getString(2131429152));
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshGAFList");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentAvVideoController.a().clone());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("GAudioMembersCtrlActivity", 2, "refreshGAFList-->mVideoContrl is null");
  }
  
  public void a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo != null)
    {
      if (localSessionInfo.V) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(super.getString(2131429151));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(super.getString(2131429150));
  }
  
  @TargetApi(11)
  public void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
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
    super.runOnUiThread(new jvg(this, paramInt1, paramLong, paramBoolean, paramInt2));
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
  
  public void c()
  {
    f();
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl != null) {
      this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
    }
    super.setTheme(2131624736);
    super.doOnCreate(paramBundle);
    super.setContentView(2130969290);
    if (TextUtils.isEmpty(super.getIntent().getStringExtra("discussUin")))
    {
      finish();
      return false;
    }
    d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().f;
    f();
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl = new GAudioMemberListCtrl(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentAvVideoController.a().f, this.jdField_a_of_type_ComTencentAvVideoController.a().F);
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a(this.jdField_a_of_type_JavaUtilArrayList);
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new jvh(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate end , cost time : " + (System.currentTimeMillis() - l) + "ms");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.b();
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl = null;
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
      this.b = null;
      this.c = null;
      this.jdField_a_of_type_AndroidWidgetButton = null;
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
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new jvf(this, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
    a();
  }
  
  public void finish()
  {
    super.finish();
    super.overridePendingTransition(0, 2131034122);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365952) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity
 * JD-Core Version:    0.7.0.1
 */