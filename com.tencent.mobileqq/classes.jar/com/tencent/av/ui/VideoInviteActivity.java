package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoConstants.ProcessInfo;
import com.tencent.av.VideoController;
import com.tencent.av.VideoRecoveryReporter;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.business.manager.report.VideoBeaconReporter;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.compat.AVCallCompactJob;
import com.tencent.av.core.JniSimpleInfoMng;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.AvTipsView;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.ui.funcall.FunCallUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.QAVNotificationUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoWifiLock;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;

public class VideoInviteActivity
  extends BaseActivity
{
  public static int b = 60000;
  public static int c = 50000;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new VideoInviteActivity.10(this);
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new VideoInviteActivity.9(this);
  final QavUpdateAvatarViewHelper jdField_a_of_type_ComTencentAvAvatarQavUpdateAvatarViewHelper = new QavUpdateAvatarViewHelper();
  private AVCallCompactJob jdField_a_of_type_ComTencentAvCompatAVCallCompactJob = new AVCallCompactJob();
  AvTipsView jdField_a_of_type_ComTencentAvTipsAvTipsView;
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  VideoInviteUIBase jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  VideoWifiLock jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
  VipFullScreenVideoView jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView;
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoInviteActivity.7(this);
  final String jdField_a_of_type_JavaLangString;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  long jdField_b_of_type_Long = -1L;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoInviteActivity.8(this);
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long = -1L;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString = null;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int = 0;
  boolean jdField_g_of_type_Boolean = true;
  int jdField_h_of_type_Int = 0;
  boolean jdField_h_of_type_Boolean = false;
  int jdField_i_of_type_Int = 0;
  boolean jdField_i_of_type_Boolean = false;
  int jdField_j_of_type_Int = 0;
  boolean jdField_j_of_type_Boolean = false;
  final int jdField_k_of_type_Int = 0;
  boolean jdField_k_of_type_Boolean = false;
  final int jdField_l_of_type_Int = 1;
  boolean jdField_l_of_type_Boolean = false;
  boolean m = false;
  boolean n = false;
  
  public VideoInviteActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    long l1 = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_d_of_type_Long = l1;
    b("VideoInviteActivity");
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (VipFunCallUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView, paramString, paramInt1, null, paramInt2, false))
    {
      a(true);
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    boolean bool = true;
    if (AVUtil.b()) {
      bool = paramBoolean;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateInviteNotification show[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], mIsAudioMode[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append("], isOnlyAudio[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.H);
      ((StringBuilder)localObject).append("], session[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvAppSessionInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("QAVNotification", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, true);
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.H)
      {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(true, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, (Bitmap)localObject, null, 45, this.jdField_e_of_type_Int, 1);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(true, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, (Bitmap)localObject, null, 40, this.jdField_e_of_type_Int, 2);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
  }
  
  public void BtnOnClick(View paramView)
  {
    VideoInviteUIBase localVideoInviteUIBase = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.BtnOnClick(paramView);
    }
  }
  
  VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  ActionSheet a(Context paramContext)
  {
    paramContext = new VideoInviteActivity.LockScreenActionSheet(this, paramContext);
    paramContext.getWindow().setWindowAnimations(2131755398);
    return paramContext;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      if (this.m) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      String str = this.jdField_c_of_type_JavaLangString;
      boolean bool = this.jdField_b_of_type_Boolean;
      int i1 = 0;
      int i2 = FunCallUtil.a((AppRuntime)localObject, str, false, bool);
      if (i2 != 0)
      {
        int i3 = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
        if ((i3 == 4) || (i3 == 1)) {
          i1 = 1;
        }
        i3 = VipFunCallUtil.a();
        localObject = VipFunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2, VipFunCallUtil.a(), null);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = VipFunCallManager.a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
        if (new File((String)localObject).exists())
        {
          a((String)localObject, i3, i2);
          return;
        }
        if (i1 != 0)
        {
          this.jdField_j_of_type_Int = i2;
          FunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2);
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131695947);
        }
      }
      else {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131695949);
      }
    }
    else {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131695952);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopRing, mLastPlayRingTime[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("->");
    localStringBuilder.append(0);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_Long = 0L;
    if (TraeHelper.a() != null) {
      TraeHelper.a().b(paramLong);
    }
  }
  
  void a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramContext = a(paramContext);
    } else {
      paramContext = ActionSheet.create(paramContext);
    }
    paramContext.addButton(2131695661);
    paramContext.addButton(2131695663);
    paramContext.addButton(2131695662);
    if (d()) {
      paramContext.addButton(2131695660);
    }
    paramContext.addCancelButton(2131690728);
    paramContext.setOnDismissListener(new VideoInviteActivity.2(this, paramBoolean));
    paramContext.setOnButtonClickListener(new VideoInviteActivity.3(this, paramContext, paramBoolean, paramLong));
    paramContext.show();
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "refuseVideoRequest", new Throwable("refuseVideoRequest"));
    }
    this.jdField_d_of_type_Boolean = false;
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (this.jdField_l_of_type_Boolean)
    {
      QavInOutAnimation localQavInOutAnimation = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
      if ((localQavInOutAnimation != null) && (!this.jdField_j_of_type_Boolean))
      {
        localQavInOutAnimation.a(new VideoInviteActivity.4(this, paramLong, paramBoolean));
        return;
      }
    }
    if (this.jdField_i_of_type_Boolean)
    {
      a().a(paramLong, this.jdField_c_of_type_JavaLangString, 1, true);
      long l1 = CharacterUtil.a(this.jdField_c_of_type_JavaLangString);
      a().a(paramLong, 3, l1);
      this.jdField_h_of_type_Boolean = true;
      a().a(paramLong, l1, 1);
      this.jdField_e_of_type_Boolean = true;
      super.finish();
      return;
    }
    a().a(paramLong, this.jdField_c_of_type_JavaLangString, 1, false);
    a().a(this.jdField_c_of_type_JavaLangString, 249);
    a().b(249);
    if (paramBoolean) {
      a().b(this.jdField_c_of_type_JavaLangString, 1);
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (QAVNotificationUtil.a(paramIntent)) {
      ReportController.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
    }
    long l1 = AudioHelper.b();
    String str1 = paramIntent.getAction();
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      localObject = paramIntent.getStringExtra("session_id");
      paramIntent = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      if (paramIntent == null) {
        paramIntent = null;
      } else {
        paramIntent = paramIntent.jdField_b_of_type_JavaLangString;
      }
      if (TextUtils.equals((CharSequence)localObject, paramIntent))
      {
        c(l1);
      }
      else if (QLog.isColorLevel())
      {
        String str2 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkParamAndDoAction not same , coming[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append("]");
        QLog.i(str2, 2, localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
    }
    else if ("com.tencent.qav.notify.refuse".equals(str1))
    {
      a(l1, true);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParamAndDoAction action[");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = VideoController.a(this);
    int i1;
    if (bool) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndSwitchMode isLocked[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], mode[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], cur[");
      Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(((VideoInviteUIBase)localObject).a());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("], destroy[");
      localStringBuilder.append(this.m);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    b("checkAndSwitchMode");
    if (this.m) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (paramString == null)
    {
      b(bool);
      return;
    }
    if (i1 != paramString.a())
    {
      paramString = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
      paramString.j();
      b(bool);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase.a(paramString);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase.d();
        this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase.a();
      }
      if (this.jdField_l_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase.g();
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
      localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
      if (localObject != null)
      {
        ((AvTipsView)localObject).a(super.getResources().getColor(2131166062));
        this.jdField_a_of_type_ComTencentAvTipsAvTipsView.b(-1291845633);
      }
    }
    else
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-11113603);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#566B7D"));
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#566B7D"));
      }
      localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
      if (localObject != null)
      {
        ((AvTipsView)localObject).a(-11113603);
        this.jdField_a_of_type_ComTencentAvTipsAvTipsView.b(-11113603);
      }
    }
  }
  
  boolean a()
  {
    Object localObject = super.getIntent();
    boolean bool2 = true;
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    if ((localObject != null) && (!QAVNotificationUtil.a((Intent)localObject)))
    {
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("peerUin");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "initVideoParam uin is empty!");
        }
        bool1 = false;
      }
      else
      {
        this.jdField_e_of_type_Int = ((Intent)localObject).getIntExtra("uinType", 0);
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extraUin");
        this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("curUserStatus", 0);
        this.jdField_b_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isAudioMode", false);
        this.jdField_c_of_type_Boolean = ((Intent)localObject).getBooleanExtra("powerKey", false);
        this.jdField_g_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isPlayRing", true);
        this.jdField_i_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isDoubleVideoMeeting", false);
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initVideoParam fromIntent peer[");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("], uinType[");
        localStringBuilder.append(this.jdField_e_of_type_Int);
        localStringBuilder.append("], audioMode[");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        localStringBuilder.append("], ret[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
        return bool1;
      }
    }
    else
    {
      localObject = SessionMgr.a().a();
      if (localObject != null)
      {
        this.jdField_e_of_type_Int = ((SessionInfo)localObject).jdField_k_of_type_Int;
        this.jdField_c_of_type_JavaLangString = ((SessionInfo)localObject).jdField_c_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "initVideoParam uin is empty!");
          }
        }
        else
        {
          this.jdField_e_of_type_Int = ((SessionInfo)localObject).jdField_k_of_type_Int;
          this.jdField_e_of_type_JavaLangString = ((SessionInfo)localObject).jdField_e_of_type_JavaLangString;
          this.jdField_d_of_type_Int = a().a();
          this.jdField_b_of_type_Boolean = ((SessionInfo)localObject).H;
          this.jdField_i_of_type_Boolean = ((SessionInfo)localObject).y;
          bool1 = bool2;
          break label369;
        }
      }
      bool1 = false;
      label369:
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initVideoParam from Session peer[");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("], uinType[");
        localStringBuilder.append(this.jdField_e_of_type_Int);
        localStringBuilder.append("], audioMode[");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        localStringBuilder.append("], ret[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  protected void b()
  {
    k();
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView = new AvTipsView();
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = 1;
    if ((!NetworkUtil.isWifiConnected(super.getApplicationContext())) && (!NetworkUtil.isBluetoothSharedNetwork(super.getApplicationContext()))) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363131));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363121));
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      UITools.a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_JavaLangString);
      if (this.jdField_i_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((VideoAppInterface)localObject).getCurrentAccountUin();
    }
    boolean bool = AVUtil.b((String)localObject);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRing avCallBtnState[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (!bool) {
      return;
    }
    if (PhoneStatusTools.c(this))
    {
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
      {
        long l1 = System.currentTimeMillis();
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("playRing, mIsRingPlaying[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("->");
        localStringBuilder.append(l1);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        if (this.jdField_a_of_type_Long != 0L) {
          return;
        }
        this.jdField_a_of_type_Long = l1;
        TraeHelper.a().b(paramLong);
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if ((localObject != null) && (((VideoAppInterface)localObject).getApp() != null))
        {
          localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          this.jdField_b_of_type_Long = VipFunCallUtil.a((AppRuntime)localObject, ((VideoAppInterface)localObject).getAccount(), 3, false, this.jdField_c_of_type_JavaLangString);
        }
        else
        {
          this.jdField_b_of_type_Long = 0L;
        }
        l1 = this.jdField_b_of_type_Long;
        if (l1 == 0L)
        {
          TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230746, -1, null);
        }
        else
        {
          localObject = ColorRingManager.a(l1, 3);
          if (new File((String)localObject).exists())
          {
            TraeHelper.a().b(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
            ((StringBuilder)localObject).append("");
            ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
          }
          else
          {
            TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230746, -1, null);
            localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
            if ((localObject != null) && (((VideoAppInterface)localObject).getApp() != null))
            {
              localObject = new Intent();
              ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
              ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
              ((Intent)localObject).putExtra("comming_ring_down_key", this.jdField_b_of_type_Long);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
            }
          }
        }
      }
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
      return;
    }
    if (PhoneStatusTools.b(this)) {
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("traceLog from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.jdField_d_of_type_Long);
      localStringBuilder.append("], mode[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase);
      localStringBuilder.append("]");
      QLog.i("TraceLogForAV", 2, localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase = new VideoInviteUILock(this);
    } else {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase = new VideoInviteUIFull(this);
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initVideoInviteUI isLocked[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
  }
  
  boolean b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
      return true;
    }
    return false;
  }
  
  @TargetApi(16)
  void c()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public void c(long paramLong)
  {
    if (!c()) {
      return;
    }
    boolean bool;
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      bool = false;
    } else {
      bool = true;
    }
    if (!ChatActivityUtils.a(this, bool, new VideoInviteActivity.5(this, paramLong, bool))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "acceptVideoRequest");
    }
    d();
    sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
    if (a().jdField_d_of_type_Boolean) {
      i();
    } else {
      e();
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(paramLong);
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock == null) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
    }
    if (PhoneStatusTools.f(super.getApplicationContext()))
    {
      VideoWifiLock localVideoWifiLock = this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
      if (localVideoWifiLock != null) {
        localVideoWifiLock.a();
      }
    }
    return true;
  }
  
  public void d()
  {
    sendBroadcast(new Intent("tencent.video.v2nearbyV.exit"));
    if (QLog.isColorLevel()) {
      QLog.d("nearby.video.multiMsg", 2, "exitNearbyVideo");
    }
  }
  
  boolean d()
  {
    if (QQUtils.a(super.getApplicationContext())) {
      return Build.VERSION.SDK_INT >= 16;
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity");
    }
    TraeHelper.a().a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (a().jdField_l_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    String str;
    if (this.jdField_i_of_type_Boolean)
    {
      str = this.jdField_c_of_type_JavaLangString;
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", str);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.jdField_d_of_type_JavaLangString);
    }
    else
    {
      localIntent.putExtra("uinType", this.jdField_e_of_type_Int);
      localIntent.putExtra("bindType", this.jdField_f_of_type_Int);
      localIntent.putExtra("bindId", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("name", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", this.jdField_b_of_type_Boolean);
      localIntent.putExtra("sig", this.jdField_a_of_type_ArrayOfByte);
      localIntent.putExtra("subServiceType", this.jdField_g_of_type_Int);
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startVideoChatActivity: mBindType = ");
        localStringBuilder.append(this.jdField_f_of_type_Int);
        localStringBuilder.append(",mBindId = ");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(",BindType = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.A);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (this.jdField_e_of_type_Int == 0) {
        localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
      }
      if (this.jdField_b_of_type_Boolean) {
        localIntent.putExtra("sessionType", 1);
      } else {
        localIntent.putExtra("sessionType", 2);
      }
      localIntent.putExtra("shutCamera", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("isSender", false);
    }
    super.startActivity(localIntent);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    super.finish();
    super.overridePendingTransition(2130772220, 2130772219);
  }
  
  protected boolean e()
  {
    return a().c(this.jdField_c_of_type_JavaLangString);
  }
  
  void f()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoRequestTimeout, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], state[");
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      int i1;
      if (localSessionInfo == null) {
        i1 = -1;
      } else {
        i1 = localSessionInfo.jdField_f_of_type_Int;
      }
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
    if ((localObject != null) && ((((SessionInfo)localObject).i()) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.j())))
    {
      localObject = this.jdField_c_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString)))
      {
        finish();
        return;
      }
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(l1);
    if (this.jdField_l_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
      if (localObject != null)
      {
        ((QavInOutAnimation)localObject).a(new VideoInviteActivity.6(this, l1));
        return;
      }
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_i_of_type_Boolean)
    {
      long l2 = CharacterUtil.a(this.jdField_c_of_type_JavaLangString);
      a().a(l1, 3, l2);
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_h_of_type_Boolean = true;
        a().a(l1, l2, 2);
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    a().a(this.jdField_c_of_type_JavaLangString, 247);
    a().b(247);
    a().b(this.jdField_c_of_type_JavaLangString, 0);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase instanceof VideoInviteUILock;
  }
  
  public void finish()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "finish", new Throwable());
    super.finish();
  }
  
  protected void g()
  {
    VideoInviteUIBase localVideoInviteUIBase = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.b();
    }
  }
  
  void h()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
    if (localObject3 == null) {
      return;
    }
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    int i2 = this.jdField_e_of_type_Int;
    Object localObject1 = localObject2;
    int i1 = i2;
    if (((SessionInfo)localObject3).A == 1)
    {
      localObject1 = localObject2;
      i1 = i2;
      if (this.jdField_e_of_type_Int == 9500)
      {
        localObject1 = localObject2;
        i1 = i2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.o))
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.o;
          i1 = 0;
        }
      }
    }
    localObject2 = new AvatarParam(i1, (String)localObject1, this.jdField_e_of_type_JavaLangString, true);
    this.jdField_a_of_type_ComTencentAvAvatarQavUpdateAvatarViewHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, (AvatarParam)localObject2, null);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject2 = UITools.a(super.getApplicationContext(), 2130842183);
      if (localObject2 != null)
      {
        long l1 = System.currentTimeMillis();
        localObject2 = new BitmapDrawable((Bitmap)localObject2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = this.jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("blur time = ");
          ((StringBuilder)localObject3).append(System.currentTimeMillis() - l1);
          ((StringBuilder)localObject3).append("ms");
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        localObject2 = BitmapTools.a(super.getApplicationContext(), 2130842183);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
        } else {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842183);
        }
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, (String)localObject1, this.jdField_e_of_type_JavaLangString);
      if ((this.jdField_e_of_type_Int == 25) && (this.jdField_d_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.g;
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mPeerName = ");
          ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showGAudioDialog");
    }
    VideoInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener1 = new VideoInviteActivity.DialogInterfaceOnClickListener(this, 0);
    VideoInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener2 = new VideoInviteActivity.DialogInterfaceOnClickListener(this, 1);
    DialogUtil.a(this, 230, null, super.getString(2131695517), 2131720199, 2131695433, localDialogInterfaceOnClickListener1, localDialogInterfaceOnClickListener2).show();
  }
  
  void j()
  {
    int i1;
    if (a() != null)
    {
      i1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_k_of_type_Int;
      str = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_JavaLangString;
    }
    else
    {
      str = null;
      i1 = 0;
    }
    if (i1 != 0)
    {
      StringBuilder localStringBuilder;
      if (i1 != 1004)
      {
        if (i1 != 1006)
        {
          if (i1 != 1010)
          {
            if (i1 != 1021)
            {
              if (i1 != 10002)
              {
                if (i1 != 1000)
                {
                  if (i1 != 1001)
                  {
                    this.jdField_i_of_type_Int = 99;
                  }
                  else
                  {
                    str = super.getString(2131695653);
                    this.jdField_i_of_type_Int = 5;
                    break label319;
                  }
                }
                else
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(super.getString(2131695652));
                  localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, str, null));
                  str = localStringBuilder.toString();
                  this.jdField_i_of_type_Int = 1;
                  break label319;
                }
              }
              else
              {
                str = super.getString(2131694305);
                this.jdField_i_of_type_Int = 7;
                break label319;
              }
            }
            else
            {
              str = super.getString(2131695648);
              this.jdField_i_of_type_Int = 4;
              break label319;
            }
          }
          else
          {
            str = super.getString(2131695650);
            this.jdField_i_of_type_Int = 6;
            break label319;
          }
        }
        else
        {
          str = super.getString(2131695649);
          this.jdField_i_of_type_Int = 3;
          break label319;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.getString(2131695652));
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, str, null));
        str = localStringBuilder.toString();
        this.jdField_i_of_type_Int = 2;
        break label319;
      }
    }
    else
    {
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_Int = 7;
        str = super.getString(2131695651);
        ScreenShareReportHelper.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, 1, "getComeFromInfo");
        break label319;
      }
      this.jdField_i_of_type_Int = 0;
    }
    String str = "";
    label319:
    this.jdField_f_of_type_JavaLangString = str;
  }
  
  void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376818));
    Drawable localDrawable = BitmapTools.a(super.getApplicationContext(), 2130842183);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localDrawable);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842183);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    LiuHaiUtils.a(this);
    if ((LiuHaiUtils.b()) && (LiuHaiUtils.enableNotch(this)) && (QLog.isDevelopLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onAttachedToWindow");
    }
  }
  
  public void onBackPressed()
  {
    VideoInviteUIBase localVideoInviteUIBase = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.c();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    long l4 = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo onCreate, seq[");
    ((StringBuilder)localObject2).append(l4);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    b("onCreate");
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase == null) {
      b(VideoController.a(getApplicationContext()));
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localObject1 != null) {
      ((VideoInviteUIBase)localObject1).a(true);
    }
    VideoNodeManager.a(29);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    super.onCreate(paramBundle);
    super.overridePendingTransition(2130772220, 0);
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    AVActivity.a(super.getWindow());
    if ((b()) && (a()))
    {
      paramBundle = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_i_of_type_Boolean) {
        paramBundle = SessionMgr.a(100, paramBundle, new int[0]);
      } else {
        paramBundle = SessionMgr.a(3, paramBundle, new int[0]);
      }
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramBundle);
      paramBundle = a();
      localObject1 = null;
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.a();
      }
      if (paramBundle != null) {
        paramBundle.a(getClass().getName(), getIntent());
      }
      paramBundle = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      Object localObject3;
      if ((paramBundle == null) || (!paramBundle.h()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("session state error! ");
          localObject3 = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
          if (localObject3 != null) {
            i1 = ((SessionInfo)localObject3).jdField_f_of_type_Int;
          } else {
            i1 = -1;
          }
          ((StringBuilder)localObject2).append(i1);
          QLog.w(paramBundle, 2, ((StringBuilder)localObject2).toString());
        }
        paramBundle = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
        if ((paramBundle != null) && (paramBundle.f()))
        {
          paramBundle = this.jdField_c_of_type_JavaLangString;
          if ((paramBundle != null) && (paramBundle.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString)))
          {
            if (!QLog.isColorLevel()) {
              break label605;
            }
            paramBundle = this.jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onCreate state[");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int);
            ((StringBuilder)localObject2).append("], peerUin[");
            ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("]");
            QLog.w(paramBundle, 2, ((StringBuilder)localObject2).toString());
            break label605;
          }
        }
        paramBundle = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
        if ((paramBundle == null) || ((!paramBundle.i()) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.j()))) {
          break label1317;
        }
        paramBundle = this.jdField_c_of_type_JavaLangString;
        if ((paramBundle == null) || (!paramBundle.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString))) {
          break label1317;
        }
        if (QLog.isColorLevel())
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onCreate state[");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int);
          ((StringBuilder)localObject2).append("], peerUin[");
          ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("]");
          QLog.w(paramBundle, 2, ((StringBuilder)localObject2).toString());
        }
        finish();
      }
      label605:
      a(getIntent());
      if (a().jdField_d_of_type_Boolean != true)
      {
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), a());
        a(l4);
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 1) {
          TraeHelper.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        } else {
          TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        }
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      long l3 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.j;
      if (l2 > 0L)
      {
        long l5 = l3 - l2;
        if (l5 < jdField_b_of_type_Int)
        {
          l1 = l2;
          if (l5 < jdField_c_of_type_Int) {
            break label766;
          }
          i1 = 1;
          l1 = l2;
          break label768;
        }
      }
      long l1 = l3;
      label766:
      int i1 = 0;
      label768:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_b_of_type_Int + l1 - l3);
      if (i1 != 0) {
        g();
      } else {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, l1 + jdField_c_of_type_Int - l3);
      }
      if (a().d() > 0) {
        a().a(203, this.jdField_c_of_type_JavaLangString);
      } else {
        a().a(202, this.jdField_c_of_type_JavaLangString);
      }
      this.jdField_h_of_type_Int = PhoneStatusTools.a(this);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.o;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvAppSessionInfo.A;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte;
      this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentAvAppSessionInfo.s;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      paramBundle.addAction("tencent.video.q2v.sdk.onRequestVideo");
      paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      paramBundle.addAction("android.intent.action.USER_PRESENT");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new VideoInviteActivity.MyBroadCastReceiver(this);
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      j();
      if (this.jdField_e_of_type_Int == 25)
      {
        localObject2 = (IPhoneContactService)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getRuntimeService(IPhoneContactService.class, "");
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          localObject3 = this.jdField_e_of_type_JavaLangString;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((IPhoneContactService)localObject2).queryContactByCodeNumber((String)localObject3);
          }
        }
        if (paramBundle != null)
        {
          paramBundle = ((IPhoneContactService)localObject2).getUinByPhoneNum(this.jdField_e_of_type_JavaLangString);
          if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBundle))) {
            ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
          }
        }
        else
        {
          ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
        }
      }
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.h())) {
        d(false);
      }
      paramBundle = getIntent();
      if ((paramBundle != null) && (paramBundle.getBooleanExtra("fullscreen", false))) {
        VideoRecoveryReporter.b();
      }
      paramBundle = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
      if (paramBundle != null) {
        paramBundle.d();
      }
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_k_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_k_of_type_Int == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        c(l4);
        paramBundle = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
        if (paramBundle != null) {
          paramBundle.a();
        }
      }
      paramBundle = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
      if (paramBundle != null) {
        paramBundle.a();
      }
      this.jdField_k_of_type_Boolean = true;
      return;
      label1317:
      a().a(this.jdField_c_of_type_JavaLangString, 245);
      a().b(245);
      a().b(this.jdField_c_of_type_JavaLangString, 2);
      this.jdField_e_of_type_Boolean = true;
      super.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "init param failure.");
    }
    this.jdField_e_of_type_Boolean = true;
    super.finish();
  }
  
  protected void onDestroy()
  {
    long l1 = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onDestroy, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    super.onDestroy();
    localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
    if (localObject != null) {
      ((AvTipsView)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    VideoBeaconReporter.a(this.jdField_c_of_type_Long);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    localObject = this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
    if (localObject != null)
    {
      ((VideoWifiLock)localObject).a();
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null)
    {
      super.unregisterReceiver((BroadcastReceiver)localObject);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    a(l1);
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).j();
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView == null) {
        break label332;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView.stopPlayback();
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = null;
    }
    catch (Throwable localThrowable)
    {
      label296:
      break label296;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView;
    if (localObject != null)
    {
      ((VipFullScreenVideoView)localObject).suspend();
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = null;
    }
    label332:
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    this.m = true;
    AVUtil.a(this);
    AVUtil.a(this);
    b("onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).a(paramInt, paramKeyEvent);
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      long l1 = AudioHelper.b();
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKeyDown, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      if ((paramInt != 25) && (paramInt != 24))
      {
        if (paramInt == 26) {
          a(l1);
        }
      }
      else
      {
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        a(l1);
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onNewIntent()");
    b("onNewIntent");
    a(paramIntent);
  }
  
  protected void onPause()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onPause");
    super.onPause();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    c(false);
    a().a("state", "0");
    if ("0".equals(VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString)) {
      a().a("backgroundReason", "5");
    }
    if (!this.jdField_f_of_type_Boolean) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 50, 1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
    if (localObject != null) {
      ((AvTipsView)localObject).b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).h();
    }
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvCompatAVCallCompactJob.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
  }
  
  protected void onRestart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onRestart");
    super.onRestart();
    VideoInviteUIBase localVideoInviteUIBase = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.f();
    }
  }
  
  protected void onResume()
  {
    a("onResume");
    long l1 = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onResume, mCheckQAVPermission[");
    ((StringBuilder)localObject2).append(this.n);
    ((StringBuilder)localObject2).append("], isInLockMode[");
    ((StringBuilder)localObject2).append(f());
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    super.onResume();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 50, 1);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 2);
    e();
    this.jdField_c_of_type_Boolean = false;
    c(true);
    localObject1 = SessionMgr.a().a();
    localObject2 = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if ((localObject2 != null) && (localObject1 != null))
    {
      long l2 = System.currentTimeMillis();
      long l3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_a_of_type_Long;
      ((VideoNodeReporter)localObject2).a(((SessionInfo)localObject1).b(), 24, l2 - l3);
    }
    a().a(VideoInviteActivity.class);
    a().a("state", "1");
    VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "0";
    localObject2 = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
    if (localObject2 != null) {
      ((AvTipsView)localObject2).c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (!this.n)
    {
      this.n = true;
      ChatActivityUtils.a(this, true, new VideoInviteActivity.1(this, l1));
    }
    localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localObject2 != null) {
      ((VideoInviteUIBase)localObject2).g();
    }
    if (!f()) {
      b(l1);
    }
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvCompatAVCallCompactJob.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
    localObject2 = a().a();
    if ((localObject2 != null) && (localObject1 != null) && (((JniSimpleInfoMng)localObject2).a(AVUtil.a(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString), false, true) == 1) && (WTogetherUtil.b()))
    {
      localObject1 = ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a((SessionInfo)localObject1);
      if (!((WatchTogetherInfo)localObject1).jdField_a_of_type_Boolean)
      {
        ((WatchTogetherInfo)localObject1).jdField_a_of_type_Boolean = true;
        WTogetherUtil.a(this, getString(2131695998));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, "showNetTip, have shown. 1");
      }
    }
  }
  
  protected void onStart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onStart");
    super.onStart();
    VideoInviteUIBase localVideoInviteUIBase = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.e();
    }
    if (f())
    {
      long l1 = AudioHelper.b();
      if (VideoController.b(this)) {
        b(l1);
      }
    }
  }
  
  protected void onStop()
  {
    long l1 = AudioHelper.b();
    boolean bool = PhoneStatusTools.c(this);
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onStop, isRingerNormal[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], mIsAccepted[");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    super.onStop();
    if ((bool) && (!this.jdField_d_of_type_Boolean)) {
      a(l1);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onStop mSessionInfo is null ");
      }
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).i();
    }
    this.jdField_l_of_type_Boolean = false;
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.h())) {
      d(true);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    VideoInviteUIBase localVideoInviteUIBase = this.jdField_a_of_type_ComTencentAvUiVideoInviteUIBase;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */