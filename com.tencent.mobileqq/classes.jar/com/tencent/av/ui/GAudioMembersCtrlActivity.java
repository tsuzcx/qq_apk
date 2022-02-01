package com.tencent.av.ui;

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
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class GAudioMembersCtrlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new GAudioMembersCtrlActivity.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  private GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new GAudioMembersCtrlActivity.7(this);
  private InviteMemberObserver jdField_a_of_type_ComTencentAvAppInviteMemberObserver = new GAudioMembersCtrlActivity.2(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  GAudioMemberListCtrl jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private ArrayList<VideoController.GAudioFriends> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = true;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 2131705253;
      } else {
        i = 2131705252;
      }
      String str = HardCodeUtil.a(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(str, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    GAudioMemberListCtrl localGAudioMemberListCtrl = this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl;
    if (localGAudioMemberListCtrl != null) {
      localGAudioMemberListCtrl.a(paramLong, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  @TargetApi(14)
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131376809);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      localRelativeLayout.setFitsSystemWindows(true);
    }
    boolean bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131369209);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131379297));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373514));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (bool1)
    {
      localRelativeLayout.setBackgroundColor(Color.parseColor("#000000"));
      super.findViewById(2131378803).setBackgroundColor(-16777216);
      super.findViewById(2131372804).setBackgroundColor(Color.parseColor("#000000"));
      ((TextView)super.findViewById(2131369202)).setBackgroundDrawable(getResources().getDrawable(2130850441));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    Object localObject = "#080808";
    if (bool2)
    {
      localObject = super.getLayoutInflater().inflate(2131559702, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      if (bool1)
      {
        ((View)localObject).findViewById(2131376809).setBackgroundColor(Color.parseColor("#080808"));
        ((TextView)((View)localObject).findViewById(2131378476)).setTextColor(Color.parseColor("#757575"));
      }
    }
    else
    {
      View localView = new View(localRelativeLayout.getContext());
      if (!bool1) {
        localObject = "#F5F6FA";
      }
      localView.setBackgroundColor(Color.parseColor((String)localObject));
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(12.0F, localRelativeLayout.getResources())));
      localObject = localView;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new GAudioMembersCtrlActivity.3(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new GAudioMembersCtrlActivity.4(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "showMenuMuteAll");
    }
    b();
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this);
    View localView = super.getLayoutInflater().inflate(2131559698, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131373397);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localActionSheet.addView(localView);
    localView = new View(this);
    localView.setBackgroundColor(Color.parseColor("#E5E6E7"));
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, AIOUtils.b(1.0F, getResources())));
    localActionSheet.addView(localView);
    localView = super.getLayoutInflater().inflate(2131558468, null);
    TextView localTextView2 = (TextView)localView.findViewById(2131361989);
    localView.setId(0);
    localView.setBackgroundDrawable(super.getResources().getDrawable(2130837658));
    boolean bool = QAVConfigUtils.i();
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().M)
    {
      localTextView2.setText(super.getString(2131695524));
      localTextView2.setTextColor(super.getResources().getColor(2131165230));
      if (bool) {
        i = 2131695525;
      } else {
        i = 2131695526;
      }
      localTextView1.setText(super.getString(i));
    }
    else
    {
      localTextView2.setText(super.getString(2131695527));
      localTextView2.setTextColor(super.getResources().getColor(2131165227));
      if (bool) {
        i = 2131695528;
      } else {
        i = 2131695529;
      }
      localTextView1.setText(super.getString(i));
    }
    localActionSheet.addView(localView);
    localActionSheet.addCancelButton(super.getResources().getString(2131690707));
    localView.setOnClickListener(new GAudioMembersCtrlActivity.5(this, localActionSheet));
    localActionSheet.setOnDismissListener(new GAudioMembersCtrlActivity.6(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshGAFList");
    }
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localVideoController != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        int i = localVideoController.c().size();
        localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
        this.jdField_a_of_type_JavaUtilArrayList = localVideoController.a(i, localVideoController.a());
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localVideoController.e().clone());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "refreshGAFList-->mVideoContrl is null");
    }
    a(this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  void a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo != null)
    {
      if (localSessionInfo.M)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131695524));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131695527));
    }
  }
  
  @TargetApi(11)
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("drawUI-->type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" fresh=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" originalType=");
      localStringBuilder.append(paramInt2);
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if ((paramInt1 == 0) || (paramInt1 == 1)) {
      c();
    }
    if (paramInt2 == 42)
    {
      a(paramLong, true);
      return;
    }
    if (paramInt2 == 43) {
      a(paramLong, false);
    }
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshUI-->uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" isRefreshTitle=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" originalType=");
      localStringBuilder.append(paramInt2);
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
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
  
  void b()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label23:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  void c()
  {
    f();
    GAudioMemberListCtrl localGAudioMemberListCtrl = this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl;
    if (localGAudioMemberListCtrl != null) {
      localGAudioMemberListCtrl.a(this.jdField_a_of_type_JavaUtilArrayList);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
    }
    super.setTheme(2131755317);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559700);
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
    ImmersiveUtils.setStatusTextColor(ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) ^ true, getWindow());
    d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = paramBundle.a();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().f;
    f();
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl = new GAudioMemberListCtrl(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentAvVideoController.a().f, this.jdField_a_of_type_ComTencentAvVideoController.a().E, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a(this.jdField_a_of_type_JavaUtilArrayList);
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserver);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new GAudioMembersCtrlActivity.VideoMsgReceiver(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("GAudioMembersCtrlActivity doOnCreate end , cost time : ");
      paramBundle.append(System.currentTimeMillis() - l);
      paramBundle.append("ms");
      QLog.i("GAudioMembersCtrlActivity", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserver);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.b();
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl = null;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
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
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "", localException);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "doOnDestroy");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    a(false);
  }
  
  protected void doOnResume()
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
    super.overridePendingTransition(0, 2130771992);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373514) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity
 * JD-Core Version:    0.7.0.1
 */