package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.core.JniSimpleInfoMng;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.screenshare.ScreenShareDialogUtil;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockSign;
import com.tencent.av.wtogether.DavWTogetherObserver;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.data.WTogetherRoom;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTEntranceHelper;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  private int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  final QavUpdateAvatarViewHelper jdField_a_of_type_ComTencentAvAvatarQavUpdateAvatarViewHelper = new QavUpdateAvatarViewHelper();
  DoubleVideoCtrlUI.RecordInfo jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$RecordInfo = new DoubleVideoCtrlUI.RecordInfo(null);
  DoubleVideoCtrlUI.StartTimerRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable = new DoubleVideoCtrlUI.StartTimerRunnable(this);
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  DavWTogetherObserver jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.1(this);
  Timer jdField_a_of_type_JavaUtilTimer = null;
  public boolean a;
  private long jdField_b_of_type_Long = -1L;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.2(this);
  boolean jdField_b_of_type_Boolean = false;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.3(this);
  boolean jdField_c_of_type_Boolean = false;
  Runnable jdField_d_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.4(this);
  boolean jdField_d_of_type_Boolean = false;
  Runnable jdField_e_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.5(this);
  boolean jdField_e_of_type_Boolean = false;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private ChildLockSign a()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      Object localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131373366);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ChildLockSign((Context)localObject3);
        localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365817);
        Resources localResources = ((ViewGroup)localObject2).getResources();
        int i = localResources.getDimensionPixelOffset(2131297714);
        int j = localResources.getDimensionPixelOffset(2131297711);
        int k = ImmersiveUtils.getStatusBarHeight((Context)localObject3);
        int m = localResources.getDimensionPixelOffset(2131297712);
        localObject3 = new RelativeLayout.LayoutParams(i, j);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, m, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((RelativeLayout.LayoutParams)localObject3).addRule(11);
        ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        ((ChildLockSign)localObject1).setVisibility(8);
        return localObject1;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  private void a(long paramLong, SessionInfo paramSessionInfo)
  {
    if (h()) {
      return;
    }
    Object localObject;
    boolean bool;
    if (paramSessionInfo.r())
    {
      localObject = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
      if (localObject != null) {
        ((WTogetherMng)localObject).d(paramSessionInfo);
      }
      AVUtil.a("0X800B632", 0, 0, "", "", "", "");
      bool = false;
    }
    else
    {
      bool = true;
      WTEntranceHelper.a(a(), 2, paramSessionInfo.jdField_k_of_type_Int, paramSessionInfo.jdField_c_of_type_JavaLangString);
      AVUtil.a("0X800B61C", 0, 1, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    if (QLog.isDevelopLevel())
    {
      paramSessionInfo = this.jdField_d_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick_WatchTogether, open[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramSessionInfo, 4, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel.a()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a("doMute", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean ^ true);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int;
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().c("doMute", 1);
      i = 1;
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().c("doMute", 0);
      i = 0;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoCtrl.doMute", j, i, false);
    t(true);
    DataReport.c(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    Object localObject = paramVideoAppInterface.a();
    SessionInfo localSessionInfo = ((VideoController)localObject).a();
    String str = localSessionInfo.jdField_c_of_type_JavaLangString;
    int i;
    if (paramBoolean ? ((VideoController)localObject).a(localSessionInfo) : ((VideoController)localObject).b(localSessionInfo)) {
      i = 1;
    } else {
      i = 3000;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendAddMemberBroadcast, peerUin[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("], supportUinType[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], fromDoubleMeeting[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], activity[");
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
    }
    int j;
    if (i == 1) {
      j = 1;
    } else {
      j = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", j, 0, "", "", "", "");
    if ((i == 3000) && (paramActivity != null) && (QAVConfigUtils.f()))
    {
      paramVideoAppInterface = QAVConfigUtils.a();
      DialogUtil.a(paramActivity, 230, null, paramVideoAppInterface, "", HardCodeUtil.a(2131703598), new DoubleVideoCtrlUI.6(), null).show();
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("sendAddMemberBroadcast tip[");
        paramActivity.append(paramVideoAppInterface);
        paramActivity.append("]");
        QLog.i("double_2_multi", 2, paramActivity.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
      return;
    }
    paramActivity = new Intent();
    paramActivity.setAction("tencent.video.v2q.AddContactsFromC2C");
    paramActivity.putExtra("peerUin", str);
    paramActivity.putExtra("supportUinType", i);
    paramActivity.setPackage(paramVideoAppInterface.getApp().getPackageName());
    paramVideoAppInterface.getApp().sendBroadcast(paramActivity);
  }
  
  static void a(VideoAppInterface paramVideoAppInterface)
  {
    VideoController localVideoController = paramVideoAppInterface.a();
    String str = localVideoController.a().jdField_c_of_type_JavaLangString;
    int j = localVideoController.b(str);
    int k = localVideoController.c(str);
    int m = localVideoController.a().jdField_k_of_type_Int;
    int i = 2131695419;
    if (m == 1011)
    {
      if (k < 45) {
        break label128;
      }
    }
    else if (!VcSystemInfo.isNormalSharp()) {
      i = 2131720276;
    } else if (Utils.a(localVideoController.a()) == 1) {
      i = 2131720206;
    } else if (k < 16) {
      i = 2131695420;
    } else if ((j != 4) && (j != 2) && (j != 3)) {}
    i = 0;
    label128:
    if (i != 0)
    {
      TipsUtil.a(paramVideoAppInterface, 1012, i);
      return;
    }
    TipsUtil.a(paramVideoAppInterface, 1012);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramInt = 0;
        } else {
          paramInt = 2131695947;
        }
      }
      else {
        paramInt = 2131695949;
      }
    }
    else {
      paramInt = 2131695952;
    }
    if (paramInt > 0)
    {
      TipsUtil.a(paramVideoAppInterface, 1048, paramInt);
      return;
    }
    TipsUtil.a(paramVideoAppInterface, 1048);
  }
  
  private boolean c()
  {
    long l = System.currentTimeMillis();
    if (l > this.jdField_b_of_type_Long + 200L)
    {
      this.jdField_b_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    Object localObject = SessionMgr.a().a();
    boolean bool = true;
    if (localObject != null)
    {
      if (!((SessionInfo)localObject).r()) {
        return true;
      }
      localObject = a();
      if (localObject == null) {
        return true;
      }
      localObject = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (localObject == null) {
        return true;
      }
      if (((VideoLayerUI)localObject).g() == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void f(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject1 != null)
    {
      ((Timer)localObject1).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "StartGlassCheck, cancel old Timer");
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    localObject1 = new DoubleVideoCtrlUI.8(this, paramBoolean);
    Object localObject2 = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartGlassCheck, begin Timer, bCheck[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    localObject2 = this.jdField_a_of_type_JavaUtilTimer;
    long l;
    if (paramBoolean) {
      l = 1000L;
    } else {
      l = 10000L;
    }
    ((Timer)localObject2).schedule((TimerTask)localObject1, l);
  }
  
  private void l(long paramLong, View paramView)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity != null) && (!localAVActivity.isFinishing()))
    {
      if (localAVActivity.isDestroyed()) {
        return;
      }
      String str1 = localAVActivity.getString(2131718564);
      String str2 = localAVActivity.getString(2131718563);
      String str3 = localAVActivity.getString(2131695618);
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      if (!localSharedPreferences.contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
      {
        ScreenShareDialogUtil.a(localAVActivity, str1, str2, str3, null, true, 10, new DoubleVideoCtrlUI.17(this, paramLong, paramView), null).show();
        localSharedPreferences.edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
        return;
      }
      DialogUtil.a(localAVActivity, 230, str1, str2, null, str3, new DoubleVideoCtrlUI.18(this, paramLong, paramView), null).show();
    }
  }
  
  private void m(long paramLong, View paramView)
  {
    Object localObject = a();
    if ((localObject != null) && (!((AVActivity)localObject).isFinishing()))
    {
      if (((AVActivity)localObject).isDestroyed()) {
        return;
      }
      localObject = ActionSheet.create((Context)localObject);
      ((ActionSheet)localObject).addButton(2131718551, 0);
      if (QAVConfigUtils.l())
      {
        ((ActionSheet)localObject).addButton(2131718550, 0);
        ((ActionSheet)localObject).addCancelButton(2131690728);
        ((ActionSheet)localObject).setOnButtonClickListener(new DoubleVideoCtrlUI.19(this, paramLong, paramView, (ActionSheet)localObject));
        ((ActionSheet)localObject).setOnBottomCancelListener(new DoubleVideoCtrlUI.20(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        ScreenShareReportHelper.a("0X800B8A1");
        return;
      }
      f(paramLong, paramView);
      ScreenShareReportHelper.a("0X800AD8E", 1);
    }
  }
  
  private void n(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    paramView.a(paramLong, "onClick_InviteMember");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9000), paramView });
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick_InviteMember block[");
      ((StringBuilder)localObject).append(paramView.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
    }
    if (paramView.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_InviteMember, mBlockName[");
      localStringBuilder.append(paramView.b);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    else
    {
      DataReport.g(this.jdField_a_of_type_ComTencentAvVideoController);
      a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if ((SmallScreenUtils.f()) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
      {
        paramView = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView != null)
        {
          paramView = paramView.a();
          if (paramView != null) {
            paramView.c();
          }
        }
      }
    }
    l(paramLong, 2131695337);
  }
  
  private void t(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      AVVoiceRecog.a().a(32);
      super.k(2131373351);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690203));
    }
    else
    {
      AVVoiceRecog.a().b(32);
      super.l(2131373351);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690190));
    }
    r(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean ^ true);
  }
  
  private void v()
  {
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setForground, mRequestPermissionIng[");
    localStringBuilder.append(this.jdField_p_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.jdField_p_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_b_of_type_Boolean) && (!SessionMgr.a().a())) {
      this.jdField_a_of_type_ComTencentAvVideoController.d();
    }
  }
  
  private void w()
  {
    Object localObject = a();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localWatchTogetherMediaPlayCtrl != null) && (localObject != null) && (localSessionInfo != null) && (localSessionInfo.r()))
    {
      localObject = ((AVActivity)localObject).a(localWatchTogetherMediaPlayCtrl.i());
      localSessionInfo.c(this.jdField_h_of_type_Boolean ^ true);
      ((WatchTogetherUIProxy)localObject).setImmersiveStatus(this.jdField_h_of_type_Boolean ^ true);
    }
  }
  
  protected int a()
  {
    return 2131559690;
  }
  
  public int a(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  ChildLockCircle a()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      Object localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131373363);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ChildLockCircle((Context)localObject3);
        localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365817);
        localObject3 = ((ViewGroup)localObject2).getResources();
        int i = ((Resources)localObject3).getDimensionPixelOffset(2131297710);
        int j = ((Resources)localObject3).getDimensionPixelOffset(2131297709);
        int k = ((Resources)localObject3).getDimensionPixelOffset(2131297916);
        localObject3 = new RelativeLayout.LayoutParams(i, j);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, 0, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((RelativeLayout.LayoutParams)localObject3).addRule(14);
        ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        ((ChildLockCircle)localObject1).a();
        return localObject1;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  public void a() {}
  
  void a(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onTerSwitchSyncStatus, cameraStatus[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], micStatus[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (h()) {
      return;
    }
    if (paramInt1 == 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      k(l);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
    }
    else
    {
      j(l);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l) });
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramInt1 == 0) && (!((SessionInfo)localObject1).jdField_k_of_type_Boolean))
    {
      if (((SessionInfo)localObject1).jdField_d_of_type_Int == 2)
      {
        ((SessionInfo)localObject1).a(l, "onTerSwitchSyncStatus.2", 1);
        a("onTerSwitchSyncStatus.2", ((SessionInfo)localObject1).jdField_d_of_type_Int);
      }
    }
    else if (((SessionInfo)localObject1).jdField_d_of_type_Int == 1)
    {
      ((SessionInfo)localObject1).a(l, "onTerSwitchSyncStatus.1", 2);
      a("onTerSwitchSyncStatus.1", ((SessionInfo)localObject1).jdField_d_of_type_Int);
    }
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((SessionInfo)localObject1).a("onTerSwitchSyncStatus", bool);
    if (paramInt2 == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    ((SessionInfo)localObject1).c("onTerSwitchSyncStatus", paramInt1);
    Object localObject2 = ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString;
    if (((SessionInfo)localObject1).jdField_g_of_type_Boolean)
    {
      super.k(2131373351);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject2);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690203));
      }
    }
    else
    {
      super.l(2131373351);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject2);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690190));
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      View localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373632);
      View localView2 = this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373633);
      if (AudioHelper.a(0) == 1)
      {
        localView1.setBackgroundColor(2147460352);
        localView2.setBackgroundColor(2147460352);
      }
      if (localView1 != null)
      {
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
        if (localLayoutParams1 != null)
        {
          if (!paramBoolean)
          {
            localLayoutParams1.topMargin = (paramInt - d() + AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentResResources));
            if (LiuHaiUtils.b()) {
              localLayoutParams1.topMargin += LiuHaiUtils.b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
          }
          else
          {
            localLayoutParams1.topMargin = AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentResResources);
          }
          localLayoutParams2.topMargin = localLayoutParams1.topMargin;
          localView1.setLayoutParams(localLayoutParams1);
          localView2.setLayoutParams(localLayoutParams2);
        }
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131373353) || (paramInt1 == 2131373354)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373353, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373353, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
      {
        if (AVReport.a().jdField_a_of_type_Boolean)
        {
          VideoNodeManager.a(29);
          AVReport.a().j = SystemClock.elapsedRealtime();
        }
        else
        {
          AVReport.a().y = SystemClock.elapsedRealtime();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Int >= 0)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1011)
          {
            a_(-1015L, 2131695430);
            if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null) {
              this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
            }
          }
          else
          {
            a_(-1015L, 2131695367);
            long l = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long;
            Object localObject = ColorRingManager.a(l, 3);
            if (new File((String)localObject).exists())
            {
              if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
                TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
              }
              i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_r_of_type_Int;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("");
              ((StringBuilder)localObject).append(i);
              localObject = ((StringBuilder)localObject).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(l);
              localStringBuilder.append("");
              ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
            }
            else if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
            {
              TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230747, null, -1, null);
            }
            if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
            {
              this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
              this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null) {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if ((i != 1) && (i != 3) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean = false;
          e(false);
          return;
        }
        s();
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClose, type[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    s();
    super.a(paramLong, paramInt);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int k = ((SessionInfo)localObject1).jdField_k_of_type_Int;
    int i;
    if (((SessionInfo)localObject1).jdField_c_of_type_Long == 2L) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramInt == 12) {
      j = 1;
    } else {
      j = 0;
    }
    if (((((SessionInfo)localObject1).m()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((((SessionInfo)localObject1).n()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26) || (k == 1044))))
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        DataReport.p(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new DoubleVideoCtrlUI.13(this, paramLong));
        Q();
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString;
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject3 = this.jdField_d_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClose phoneNumber is ");
          localStringBuilder.append((String)localObject2);
          QLog.w((String)localObject3, 1, localStringBuilder.toString());
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (paramInt != 3))
        {
          ReportController.b(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373337, true);
        }
        else if (Build.VERSION.SDK_INT >= 17)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373337, 8);
          localObject2 = (Button)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373350);
          localObject3 = (RelativeLayout.LayoutParams)((Button)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject3).removeRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373337, false);
        }
        if (paramInt == 3) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373640, false);
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373350, true);
      }
      localObject2 = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localObject2 != null) {
        ((EffectOperateManager)localObject2).b(false);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.a();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
    }
    this.jdField_b_of_type_Boolean = true;
    if ((((SessionInfo)localObject1).j()) && (((SessionInfo)localObject1).jdField_d_of_type_Int == 2) && (!((SessionInfo)localObject1).j)) {
      DataReport.e();
    }
    ((SessionInfo)localObject1).a("onClose", false);
    ((SessionInfo)localObject1).c("onClose", 0);
    if (paramInt == 24)
    {
      this.i = true;
      a_(paramLong, 2131695821);
    }
    if (paramInt == 42) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick mVideoController == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick mQavPanel == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean)
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick isChildLock");
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      if (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)) {
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      Object localObject2 = a();
      int i;
      switch (paramView.getId())
      {
      default: 
      case 2131695347: 
        c(paramLong, paramView);
        return;
      case 2131695346: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Voice");
        i(paramLong, paramView);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView != null) && (paramView.jdField_k_of_type_Int == 1044))
        {
          ReportController.b(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131695345: 
        k(paramLong, paramView);
        return;
      case 2131695343: 
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
          i = 1;
        } else {
          i = 2;
        }
        int j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) {
          j = 1;
        } else {
          j = 3;
        }
        ReportController.b(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i, j, "", "", "", "");
        paramView = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://zb.vip.qq.com/v2/pages/funcallMall");
        ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
        l(paramLong, 2131695343);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView != null) && (paramView.jdField_k_of_type_Int == 1044))
        {
          ReportController.b(null, "dc00898", "", "", "0X800AD96", "0X800AD96", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131695341: 
        h(paramLong, paramView);
        return;
      case 2131695339: 
        l(paramLong, paramView);
        return;
      case 2131695338: 
        g(paramLong);
        return;
      case 2131695337: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
        n(paramLong, paramView);
        return;
      case 2131695336: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Effect");
        j(paramLong, paramView);
        return;
      case 2131695334: 
        b(paramLong, paramView);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView != null) && (paramView.jdField_k_of_type_Int == 1044))
        {
          ReportController.b(null, "dc00898", "", "", "0X800AD95", "0X800AD95", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131695333: 
        e(paramLong, paramView);
        return;
      case 2131373640: 
        paramView = this.jdField_d_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onClick, switch_camera, seq[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]");
        QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
        AVTraceUtil.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean ^= true;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
          i = 2131692842;
        }
        else
        {
          ReportController.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
          i = 2131692841;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373640, this.jdField_a_of_type_AndroidContentResResources.getString(i));
          return;
        }
        break;
      case 2131373637: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick qav_titlebar_quit_double_screen ");
        paramView = new StringBuilder();
        paramView.append(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString));
        paramView.append("");
        MagicDataReport.f(paramView.toString());
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(134) });
        return;
      case 2131373636: 
        g(paramLong, paramView);
        return;
      case 2131373634: 
      case 2131695342: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
        ReportController.b(null, "CliOper", "", "", "0X800A343", "0X800A343", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Int + 1, 0, "", "", "", "");
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.g("Sharpness");
        if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() == 1) {
          ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramLong);
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.b();
        return;
      case 2131373353: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.OPEN_LOCK");
        this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 1, 5, 1);
        a(2131695908, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
        return;
      case 2131373351: 
        d(paramLong, paramView);
        return;
      case 2131373350: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          TraeHelper.a().b(paramLong);
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int;
          paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject2, str, true);
        }
        DataReport.q(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvVideoController.b((String)localObject1, this.jdField_a_of_type_ComTencentAvVideoController.a().z);
        return;
      case 2131373348: 
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView != null) && (paramView.jdField_k_of_type_Int == 1044)) {
          ReportController.b(null, "dc00898", "", "", "0X800AD98", "0X800AD98", 0, 0, "", "", "", "");
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick HIDE ");
        this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
        com.tencent.av.VideoConstants.ProcessInfo.a = "3";
        a();
        DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
      case 2131373345: 
      case 2131373346: 
      case 2131373347: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick Hangup ");
        a(paramView);
        return;
      case 2131373343: 
        boolean bool = c();
        paramView = this.jdField_d_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onClick QavPanel.ViewID.HAND_FREE canClick:=");
        ((StringBuilder)localObject1).append(bool);
        QLog.d(paramView, 1, ((StringBuilder)localObject1).toString());
        if (bool)
        {
          bool = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Boolean;
          DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController, bool ^ true);
          if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null)
          {
            this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(TraeHelper.c);
            return;
          }
        }
        break;
      case 2131373335: 
      case 2131373337: 
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        DataReport.a(paramView.getId(), i);
        a((AVActivity)localObject2, (String)localObject1);
        return;
      case 2131364477: 
      case 2131365542: 
      case 2131373635: 
        S();
      }
    }
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTitleText, mRingAnimator[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.jdField_a_of_type_Boolean);
      localStringBuilder.append("], startRingAnimator[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString)) {
      d(paramLong, paramString);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null))
    {
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    i(paramLong, 16777215);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((i == 2) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) && (paramBoolean) && (localSessionInfo.j()))
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      ReportController.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
    }
    e();
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (h()) {
      return;
    }
    Object localObject = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    boolean bool;
    if ((localObject != null) && (((AVActivity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterOpenCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], preSessionType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], isConnected[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
    localStringBuilder.append("], mCameraNum[");
    localStringBuilder.append(this.jdField_q_of_type_Int);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean);
    localStringBuilder.append("], checkCameraResult[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373636, 0);
      localObject = a();
      if (localObject != null) {
        ((AVActivity)localObject).a(true);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = true;
      DataReport.c();
      DataReport.m(this.jdField_a_of_type_ComTencentAvVideoController);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j())) {
        a("onAfterOpenCamera", 2);
      }
      C(paramLong);
    }
    i(paramLong, 16777215);
  }
  
  void a(View paramView)
  {
    long l = AudioHelper.b();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Hangup, seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    int i = paramView.getId();
    if ((i != 2131373345) && (i != 2131373346))
    {
      if (i == 2131373347) {
        AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup no answer");
      }
    }
    else {
      AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup");
    }
    str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9002), paramView });
    if (paramView.jdField_a_of_type_Boolean)
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Hangup, mBlockName[");
      localStringBuilder.append(paramView.b);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return;
    }
    h(true);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new DoubleVideoCtrlUI.25(this, l, str));
  }
  
  void a(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    Object localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick QavPanel.ViewID.CALL_PHONE, type[");
    localStringBuilder.append(i);
    localStringBuilder.append("], PhoneNum[");
    localStringBuilder.append(AudioHelper.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString));
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tel:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString);
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(((StringBuilder)localObject).toString())));
    ReportController.b(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(paramString, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 25)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setQCallNickName");
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
    super.a(paramString);
  }
  
  void a(String paramString, int paramInt)
  {
    long l = AudioHelper.b();
    Object localObject1 = this.jdField_d_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avSwitch[");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("], sessionType[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("]");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool2 = true;
    QLog.w((String)localObject1, 1, (String)localObject2);
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    if (paramInt == 1)
    {
      o();
      d(l, false);
      i(l, 16777215);
      e(0);
      new ControlUIObserver.ZimuRequest(l, "avSwitch", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    else if (paramInt == 2)
    {
      d(l, true);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((SensorHelper)localObject1).c(bool1);
    localObject1 = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((SensorHelper)localObject1).b(bool1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("_avSwitch");
    c(l, ((StringBuilder)localObject1).toString());
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject).jdField_k_of_type_Int == 25)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setQCallHead uin = ");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      localObject = new AvatarParam(((SessionInfo)localObject).jdField_k_of_type_Int, paramString, ((SessionInfo)localObject).jdField_e_of_type_JavaLangString, true);
      this.jdField_a_of_type_ComTencentAvAvatarQavUpdateAvatarViewHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, (AvatarParam)localObject, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInviteReached, peerUin[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], showMsg[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], remotePhoneState[");
    localStringBuilder.append(localSessionInfo.jdField_q_of_type_Int);
    localStringBuilder.append("], remoteTerminal[");
    localStringBuilder.append(localSessionInfo.jdField_n_of_type_Int);
    localStringBuilder.append("], phoneOnLine[");
    localStringBuilder.append(localSessionInfo.jdField_p_of_type_Int);
    localStringBuilder.append("], pcOnLine[");
    localStringBuilder.append(localSessionInfo.jdField_o_of_type_Int);
    localStringBuilder.append("], subState[");
    localStringBuilder.append(localSessionInfo.jdField_c_of_type_Long);
    localStringBuilder.append("], isPeerNetworkWell[");
    localStringBuilder.append(localSessionInfo.jdField_q_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((localSessionInfo.f()) && (!localSessionInfo.Y))
    {
      if (localSessionInfo.jdField_k_of_type_Int == 1011) {
        return;
      }
      if (localSessionInfo.jdField_c_of_type_JavaLangString.contains(paramString1))
      {
        int i = localSessionInfo.jdField_q_of_type_Int;
        if (i >= 0) {
          if (TextUtils.isEmpty(paramString2)) {
            a_(l, 2131695367);
          } else {
            d(l, paramString2);
          }
        }
        if ((localSessionInfo.jdField_c_of_type_Long != 0L) && (localSessionInfo.jdField_c_of_type_Long == 2L))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.onCloseVideo(localSessionInfo.jdField_c_of_type_JavaLangString, 8, 0L);
          if (!TextUtils.isEmpty(localSessionInfo.jdField_n_of_type_JavaLangString)) {
            TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3008, localSessionInfo.jdField_n_of_type_JavaLangString);
          }
          ReportController.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        }
        if ((i > 0) && (i != 3))
        {
          a(i);
          DataReport.e(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
        }
        if (i == 4)
        {
          if ((localSessionInfo.jdField_o_of_type_Int == 1) && (localSessionInfo.jdField_p_of_type_Int == 0)) {
            a(i);
          }
        }
        else if ((i == 0) && (localSessionInfo.jdField_q_of_type_Boolean) && (localSessionInfo.jdField_n_of_type_Int != 2) && (localSessionInfo.jdField_d_of_type_Int == 1)) {
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPeerSwitchTerminal, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], bStartSwitch[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
    }
    else
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.g()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onPeerSwitchTerminal, local close camera");
        }
        k(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1021);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      this.jdField_a_of_type_ComTencentAvVideoController.z();
    }
    i(l, 16777215);
    paramString = DoodleLogic.a();
    if (paramBoolean)
    {
      paramString.jdField_b_of_type_Boolean = false;
      paramString.jdField_e_of_type_Int = 0;
      if (QLog.isColorLevel())
      {
        str = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WL_DEBUG onPeerSwitchTerminal mPeerVersion = ");
        localStringBuilder.append(paramString.jdField_e_of_type_Int);
        localStringBuilder.append(", mIsPeerSupport = ");
        localStringBuilder.append(paramString.jdField_b_of_type_Boolean);
        QLog.e(str, 2, localStringBuilder.toString());
      }
      SmallScreenUtils.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363751);
      if (localView != null)
      {
        if ((paramBoolean) && (localView.getVisibility() != 0))
        {
          localView.setVisibility(0);
          return;
        }
        if ((!paramBoolean) && (localView.getVisibility() != 8)) {
          localView.setVisibility(8);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt, false);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    int j = 0;
    int i;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (paramBoolean1) {
      i = j;
    } else {
      i = 8;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramBoolean2))
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.d(paramBoolean1 ^ true);
      }
      new VideoControlUI.QavStatusBar(this.jdField_a_of_type_AndroidViewViewGroup).a(paramBoolean1);
    }
    c(-1035L, "changeToDoubleScreen");
  }
  
  public boolean a()
  {
    long l = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject2 = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackPressed, seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("], isChildLock[");
    localStringBuilder.append(((SessionInfo)localObject1).jdField_w_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    if (((SessionInfo)localObject1).jdField_w_of_type_Boolean) {
      return true;
    }
    if (super.a())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onBackPressed called return 2, seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return true;
    }
    v();
    localObject2 = ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject2, Boolean.valueOf(false) });
    if ((!SmallScreenUtils.f()) && (((SessionInfo)localObject1).jdField_d_of_type_Int == 2) && (((SessionInfo)localObject1).j)) {
      a(2131695493, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
    }
    if ((((SessionInfo)localObject1).m()) || (((SessionInfo)localObject1).n()))
    {
      j(((SessionInfo)localObject1).z);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.16(this, l), 150L);
    }
    if (SmallScreenUtils.f())
    {
      localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 != null) && ((localObject1 instanceof AVActivity)))
      {
        localObject1 = (AVActivity)localObject1;
        if (localObject1 != null)
        {
          localObject1 = ((AVActivity)localObject1).a();
          if (localObject1 != null) {
            ((SmallScreenActivityPlugin)localObject1).a();
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject1 == null) {
      return false;
    }
    if (!((SessionInfo)localObject1).ap) {
      return false;
    }
    Object localObject2;
    if (!((SessionInfo)localObject1).jdField_k_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setGlassSwitch, Remote not has video, GlassSwitch[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((SessionInfo)localObject1).P != paramInt))
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlassSwitch, GlassSwitch[");
      localStringBuilder.append(((SessionInfo)localObject1).P);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    if (((SessionInfo)localObject1).P == paramInt) {
      return false;
    }
    ((SessionInfo)localObject1).P = paramInt;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        return false;
      }
      localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null)
      {
        if (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) {
          return false;
        }
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return true;
              }
              ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
              TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1039);
              return true;
            }
            ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
            TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
            return true;
          }
          ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
          return true;
        }
        ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 24) && (paramInt != 25)) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void b()
  {
    super.b();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localQavPanel.a(2131559739, bool, BeautyToolbar.checkShowBeauty(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1044) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setNoVideoAndShareBtnMode();
      }
    }
    d(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373637));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373381));
    if (AudioHelper.a(0) == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147483392);
    }
    if (Build.VERSION.SDK_INT <= 20)
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "need reset quit double screen listener");
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new DoubleVideoCtrlUI.7(this));
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373373));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373345, this.jdField_a_of_type_AndroidContentResResources.getString(2131690201));
      }
      d(l, false);
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373345, this.jdField_a_of_type_AndroidContentResResources.getString(2131720220));
      }
      d(l, true);
    }
    if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373351, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373351, false);
    }
    c(l, "initUI");
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373391), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373523), null);
    GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 0))) {
      ReportController.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
    }
  }
  
  void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1011) && (paramInt != 2131695430) && (paramInt != 2131720213)) {
      return;
    }
    if (paramInt > 0) {
      a_(-1016L, paramInt);
    }
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool1 = ((SessionInfo)localObject1).j();
    boolean bool2 = false;
    if (bool1)
    {
      if (((SessionInfo)localObject1).jdField_c_of_type_Long != 1L) {
        super.A(paramLong);
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (((SessionInfo)localObject1).jdField_d_of_type_Int == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SensorHelper)localObject2).b(bool1);
    }
    o();
    DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
    this.jdField_e_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (((SessionInfo)localObject1).ap))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.12(this), 200L);
      return;
    }
    localObject1 = this.jdField_d_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onResume, AsyncReadDoubleGlassConfig, mVideoController[");
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      bool1 = true;
    }
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    c();
  }
  
  @TargetApi(11)
  public void b(long paramLong, int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean)) {
      a(paramLong, 0.0F);
    } else {
      a(paramLong, 360 - paramInt);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373363);
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).setRotation(360 - paramInt);
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    paramView = a();
    if (paramView != null) {
      if (paramView.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a()) {
        paramView.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(3);
      } else {
        paramView.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a(0);
      }
    }
    ChatRoomUtil.a("0X800A8D0");
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
      i(paramLong, 16777215);
    }
  }
  
  public void b(String paramString) {}
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramBoolean);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    int i = 2;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_o_of_type_Boolean))
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
            paramBoolean = bool1;
          } else {
            paramBoolean = false;
          }
          ((QavPanel)localObject).a(paramBoolean, 0, false);
        }
        else
        {
          paramBoolean = bool2;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
            paramBoolean = true;
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
          if (!paramBoolean) {
            i = 1;
          }
          ((QavPanel)localObject).a(paramBoolean, i, true);
        }
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131166062));
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_o_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
          paramBoolean = bool3;
        } else {
          paramBoolean = false;
        }
        ((QavPanel)localObject).a(paramBoolean, 0, false);
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (!paramBoolean) {
        i = 1;
      }
      ((QavPanel)localObject).a(paramBoolean, i, false);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPhoneCalling, isSelf[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
        return;
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1018);
        ReportController.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
        localObject = (ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class);
        ((ITraeMediaPlayerApi)localObject).init((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
        if (GAudioSoundUtil.a("qav_peer_phone_calling.mp3"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(GAudioSoundUtil.a());
          localStringBuilder.append("qav_peer_phone_calling.mp3");
          ((ITraeMediaPlayerApi)localObject).playRing(l, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
        }
        else
        {
          ((ITraeMediaPlayerApi)localObject).playRing(l, 0, 2131230741, null, null, false, 1, false, true, 0);
          GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().H)
        {
          ReportController.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
        return;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject);
      }
    }
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a().j();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.9(this), 100L);
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()))
    {
      if (!this.jdField_h_of_type_Boolean) {
        e(paramInt);
      }
      return;
    }
    e(paramInt);
    C(l);
  }
  
  public void c(long paramLong)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_p_of_type_Boolean))
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop, mRequestPermissionIng[");
      localStringBuilder.append(this.jdField_p_of_type_Boolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.c(paramLong);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j())) {
      super.B(paramLong);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j)
      {
        k(paramLong);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (QLog.isColorLevel())
        {
          String str = this.jdField_d_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDetectNoDevicePermission local close camera, remote[");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString());
        }
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission, set cameraPermission = false");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = false;
      i(paramLong, 16777215);
    }
    super.c(paramLong, paramInt);
  }
  
  protected void c(long paramLong, View paramView)
  {
    paramView = SessionMgr.a().a();
    if (!WTogetherUtil.a(paramView.jdField_c_of_type_JavaLangString))
    {
      a(2131696005, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
      AVUtil.a("0X800B61C", 0, 0, "", "", "", "");
      return;
    }
    WTogetherRealNameVideoProcessHelper localWTogetherRealNameVideoProcessHelper = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    localWTogetherRealNameVideoProcessHelper.b(new DoubleVideoCtrlUI.21(this, paramLong, paramView, localWTogetherRealNameVideoProcessHelper));
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAfterCloseCamera, success[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    i(paramLong, 16777215);
    if (paramBoolean)
    {
      i(true);
      DataReport.d();
      DataReport.n(this.jdField_a_of_type_ComTencentAvVideoController);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) {
        a("onAfterCloseCamera", 1);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) {
        a(paramLong, 0.0F);
      }
    }
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
    s();
  }
  
  public void c(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotRecvAudioData, bNotRecv[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.jdField_r_of_type_Int = 1;
    } else {
      this.jdField_r_of_type_Int = 2;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) == 5) {
        return;
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) != 5) {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
      super.A(l);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    t(paramBoolean2);
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject2 = this.jdField_d_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("avideo onCreate, state[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_f_of_type_Int);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(l);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    if (((SessionInfo)localObject1).jdField_E_of_type_Int == 0) {
      ((SessionInfo)localObject1).jdField_E_of_type_Int = 3;
    }
    if ((!((SessionInfo)localObject1).e()) && (!((SessionInfo)localObject1).h())) {
      break label532;
    }
    int k = ((SessionInfo)localObject1).H ^ true;
    int i;
    if (!((SessionInfo)localObject1).C) {
      i = 4;
    } else {
      i = 1;
    }
    if (1008 == ((SessionInfo)localObject1).jdField_k_of_type_Int) {}
    while (1044 == ((SessionInfo)localObject1).jdField_k_of_type_Int)
    {
      i = 4;
      break;
    }
    if (((SessionInfo)localObject1).jdField_e_of_type_Boolean)
    {
      i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, k, i);
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localObject2 != null)
      {
        int j;
        if (i == 1) {
          j = 3;
        } else {
          j = 0;
        }
        localObject3 = ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString;
        if (((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(j, (String)localObject3)) {
          ((JniSimpleInfoMng)localObject2).a((String)localObject3, 1, false);
        } else {
          ((JniSimpleInfoMng)localObject2).a((String)localObject3, 0, false);
        }
      }
      i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, k, i, ((SessionInfo)localObject1).jdField_h_of_type_JavaLangString, ((SessionInfo)localObject1).i, ((SessionInfo)localObject1).jdField_g_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_k_of_type_Int, ((SessionInfo)localObject1).jdField_e_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_f_of_type_JavaLangString, ((SessionInfo)localObject1).a, null, null, 0, 0, null, null);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("result = ");
      ((StringBuilder)localObject3).append(i);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if (i != 0)
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Video connect fail:");
      ((StringBuilder)localObject3).append(i);
      AVLog.printAllUserLog((String)localObject2, ((StringBuilder)localObject3).toString());
      if (i == -2)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, 238);
        this.jdField_a_of_type_ComTencentAvVideoController.b(238);
        this.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, 9);
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject1 != null) {
          ((Activity)localObject1).finish();
        }
      }
      return;
    }
    label532:
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onCreate, ofter Request, state[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_f_of_type_Int);
      ((StringBuilder)localObject3).append("], SessionType[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_d_of_type_Int);
      ((StringBuilder)localObject3).append("], deviceName[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_p_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("], seq[");
      ((StringBuilder)localObject3).append(l);
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    if (((SessionInfo)localObject1).f())
    {
      if (((SessionInfo)localObject1).jdField_d_of_type_Int == 1) {
        this.jdField_e_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
      } else {
        this.jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
    }
    if (((SessionInfo)localObject1).j())
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.h()) && (this.jdField_a_of_type_ComTencentAvVideoController.a() >= 2L) && (!((SessionInfo)localObject1).jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString) == 5)) {
        DataReport.f(this.jdField_a_of_type_ComTencentAvVideoController);
      }
      if (((SessionInfo)localObject1).jdField_d_of_type_Int == 2) {
        d(l, true);
      }
      i = ((SessionInfo)localObject1).jdField_k_of_type_Int;
      localObject2 = ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject2);
    }
    else if (((SessionInfo)localObject1).i())
    {
      if (((SessionInfo)localObject1).H) {
        i = 2131695503;
      } else {
        i = 2131720285;
      }
      b(i);
    }
    else if (((SessionInfo)localObject1).f())
    {
      i = 2131695857;
      if (((SessionInfo)localObject1).Y) {
        i = 2131695858;
      }
      if (((SessionInfo)localObject1).jdField_k_of_type_Int == 1011) {
        i = 2131695430;
      }
      if (((SessionInfo)localObject1).H)
      {
        localObject2 = this.jdField_d_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Inviting, remotePhoneState[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_q_of_type_Int);
        ((StringBuilder)localObject3).append("], isPeerNetworkWell[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_q_of_type_Boolean);
        ((StringBuilder)localObject3).append("], remoteOnline[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_r_of_type_Boolean);
        ((StringBuilder)localObject3).append("], remoteTerminal[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_n_of_type_Int);
        ((StringBuilder)localObject3).append("]");
        QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        if ((((SessionInfo)localObject1).jdField_q_of_type_Int == 0) && (((SessionInfo)localObject1).jdField_q_of_type_Boolean) && (((SessionInfo)localObject1).jdField_n_of_type_Int != 2) && (((SessionInfo)localObject1).jdField_d_of_type_Int == 1)) {
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
        }
      }
      b(i);
      i = ((SessionInfo)localObject1).jdField_k_of_type_Int;
      localObject2 = ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject2);
      i = ((SessionInfo)localObject1).jdField_q_of_type_Int;
      if ((i == 4) && (((SessionInfo)localObject1).jdField_o_of_type_Int == 1) && (((SessionInfo)localObject1).jdField_p_of_type_Int == 0)) {
        a(i);
      }
      if ((i > 0) && (i != 3))
      {
        a(i);
        DataReport.e(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else if (((SessionInfo)localObject1).h())
    {
      b(2131695697);
    }
    else if ((((SessionInfo)localObject1).m()) || (((SessionInfo)localObject1).n()))
    {
      j(((SessionInfo)localObject1).z);
      if (((SessionInfo)localObject1).jdField_k_of_type_Int == 1011) {
        b(2131695828);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.10(this, l), 150L);
    }
    if (this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver = new DavWTogetherObserver(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver);
    }
    if (((SessionInfo)localObject1).jdField_n_of_type_Boolean) {
      o();
    }
    if (((SessionInfo)localObject1).H)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    }
    if (((SessionInfo)localObject1).jdField_g_of_type_Boolean)
    {
      super.k(2131373351);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690203));
      }
    }
    else
    {
      super.l(2131373351);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690190));
      }
    }
    a(l, false);
    this.jdField_a_of_type_AndroidViewViewGroup.post(new DoubleVideoCtrlUI.11(this));
    localObject1 = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localObject1 != null) {
      ((QavInOutAnimation)localObject1).a();
    }
  }
  
  public void d(int paramInt)
  {
    if (1 == paramInt)
    {
      if (!this.jdField_e_of_type_Boolean)
      {
        p();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
    }
    else
    {
      if (paramInt == 0)
      {
        q();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        return;
      }
      if (2 == paramInt) {
        return;
      }
      Object localObject;
      if (3 == paramInt)
      {
        localObject = a();
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().v == 2) && (localObject != null) && (((ChildLockSign)localObject).isEnabled()))
        {
          if (((ChildLockSign)localObject).getVisibility() != 0)
          {
            ((ChildLockSign)localObject).setLocked(true);
            ((ChildLockSign)localObject).setVisibility(0);
            r();
            return;
          }
          ((ChildLockSign)localObject).setVisibility(8);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        }
      }
      else if ((4 == paramInt) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        localObject = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373363);
      }
    }
  }
  
  public void d(long paramLong)
  {
    Object localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver);
        this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver = null;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("DoubleVideoCtrlUI");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(paramLong);
      p(true);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365817);
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    localObject = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373392));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373393));
    i(paramLong, 16777215);
    e();
  }
  
  void d(long paramLong, View paramView)
  {
    boolean bool = c();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Mute, micPermission[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean);
    localStringBuilder.append("], localMute[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], canClick[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((a(paramLong, "android.permission.RECORD_AUDIO", paramView)) && (bool)) {
      a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    }
    super.C(paramLong);
  }
  
  void d(long paramLong, boolean paramBoolean)
  {
    boolean bool = SessionMgr.a().a().r();
    int i;
    if (paramBoolean)
    {
      if (bool) {
        i = 4;
      } else {
        i = 2;
      }
    }
    else if (bool) {
      i = 3;
    } else {
      i = 1;
    }
    e(paramLong, i);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyAIDenoiseTips, isFromlocal[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (a() != null)
    {
      if (paramBoolean)
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3016);
        return;
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3014);
    }
  }
  
  void e()
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1011)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373636, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373640, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373634, 8);
      AVActivity localAVActivity = a();
      if (localAVActivity != null) {
        localAVActivity.a(false);
      }
    }
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
  }
  
  public void e(long paramLong)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.jdField_c_of_type_JavaLangString);
    Object localObject1 = this.jdField_d_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onConnected, roomid[");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("], mNeedRemoveAudioCallback[");
    ((StringBuilder)localObject2).append(this.jdField_d_of_type_Boolean);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    super.e(paramLong);
    l(paramLong);
    if (l > 0L) {
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(l, 26, l);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = localSessionInfo.jdField_d_of_type_Int;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject2).toString());
    if (localSessionInfo.jdField_h_of_type_Int != 4) {
      a_(paramLong, 2131695492);
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1049);
    if (!localSessionInfo.jdField_e_of_type_Boolean)
    {
      if (localSessionInfo.jdField_E_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      }
      if (localSessionInfo.jdField_g_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      }
      DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    if (localSessionInfo.jdField_d_of_type_Int == 2) {
      d(paramLong, true);
    } else {
      i(true);
    }
    a(paramLong, true);
    localObject1 = localSessionInfo.jdField_c_of_type_JavaLangString;
    i = this.jdField_a_of_type_ComTencentAvVideoController.b((String)localObject1);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c((String)localObject1);
    if (i == 5)
    {
      if (localSessionInfo.ac) {
        super.A(paramLong);
      } else {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      }
    }
    else if (!this.jdField_a_of_type_ComTencentAvVideoController.f())
    {
      if (localSessionInfo.ac) {
        super.A(paramLong);
      } else {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      }
    }
    else if (!localSessionInfo.j()) {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
    } else if (j > 18)
    {
      if ((localSessionInfo.ac) && (localSessionInfo.ad)) {
        super.A(paramLong);
      } else {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      }
    }
    else if (localSessionInfo.ac) {
      super.A(paramLong);
    } else {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
    }
    localObject2 = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    boolean bool;
    if (localSessionInfo.jdField_d_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((SensorHelper)localObject2).b(bool);
    i = localSessionInfo.jdField_k_of_type_Int;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject1);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
    if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.a();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
    }
    if (localSessionInfo.jdField_n_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    }
    if (localSessionInfo.jdField_d_of_type_Int == 2)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onConnected, CheckRemoteCameraRunnable");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
    }
    if ((localSessionInfo.jdField_n_of_type_Boolean) && (!localSessionInfo.jdField_k_of_type_Boolean)) {
      a("onConnected", 1);
    }
  }
  
  public void e(long paramLong, int paramInt)
  {
    if (h()) {
      return;
    }
    boolean bool = AVUtil.c(paramInt);
    Object localObject;
    if (this.jdField_a_of_type_Int != paramInt)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("changeUIMode, [");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("-->");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], isVideo[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("]");
        QLog.i("WTogether", 4, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_o_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(bool, 0, false);
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      }
    }
    else
    {
      i(-1014L, 16777215);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))
    {
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      ((AVActivity)localObject).b(bool ^ true);
      ((AVActivity)localObject).e(bool ^ true);
      ((AVActivity)localObject).c(bool);
    }
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4))
    {
      if (paramInt == 1)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(0);
        }
        j(paramLong, 0);
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(8);
      }
      j(paramLong, 8);
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramInt == 2)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    a(Boolean.valueOf(bool));
  }
  
  void e(long paramLong, View paramView)
  {
    Object localObject1 = new ControlUIObserver.CPreEventInfo(paramView);
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9001), localObject1 });
    }
    Object localObject2;
    if (((ControlUIObserver.CPreEventInfo)localObject1).jdField_a_of_type_Boolean)
    {
      paramView = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick_Camera, mBlockName[");
      ((StringBuilder)localObject2).append(((ControlUIObserver.CPreEventInfo)localObject1).b);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w(paramView, 1, ((StringBuilder)localObject2).toString());
    }
    else if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      DataReport.h(this.jdField_a_of_type_ComTencentAvVideoController);
      if (((SessionInfo)localObject2).jdField_d_of_type_Int == 1)
      {
        VideoViewInfo localVideoViewInfo = new VideoViewInfo();
        localObject1 = ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString;
        paramView = (View)localObject1;
        if (((String)localObject1).startsWith("+")) {
          paramView = ((String)localObject1).substring(1);
        }
        localVideoViewInfo.jdField_a_of_type_Long = CharacterUtil.a(paramView);
        localVideoViewInfo.jdField_a_of_type_Int = 1;
        paramView = new ArrayList();
        paramView.add(localVideoViewInfo);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramView });
        j(paramLong);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), localBoolean, Long.valueOf(paramLong) });
        if (QLog.isColorLevel())
        {
          paramView = this.jdField_d_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onClick_Camera, open1, seq[");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("]");
          QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
        }
        ReportController.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
        if (((SessionInfo)localObject2).x) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.22(this), 500L);
        }
        if (((SessionInfo)localObject2).r()) {
          AVUtil.a("0X800B637", 0, 0, "", "", "", "");
        }
      }
      else if (((SessionInfo)localObject2).jdField_d_of_type_Int == 2)
      {
        if (((SessionInfo)localObject2).j)
        {
          k(paramLong);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
          if (QLog.isColorLevel())
          {
            paramView = this.jdField_d_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onClick_Camera, close, seq[");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append("]");
            QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
          }
          if (((SessionInfo)localObject2).r()) {
            AVUtil.a("0X800B638", 0, 0, "", "", "", "");
          }
        }
        else
        {
          j(paramLong);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), localBoolean, Long.valueOf(paramLong) });
          if (QLog.isColorLevel())
          {
            paramView = this.jdField_d_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onClick_Camera, open2, seq[");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append("]");
            QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
          }
          if (((SessionInfo)localObject2).r()) {
            AVUtil.a("0X800B637", 0, 0, "", "", "", "");
          }
        }
      }
    }
    l(paramLong, 2131695333);
  }
  
  public void e(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean = true;
      if (this.jdField_h_of_type_Boolean)
      {
        e(0);
        w();
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_e_of_type_Boolean = true;
    v();
    q();
  }
  
  public void f(int paramInt)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramInt != localSessionInfo.Q)
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlassWaitTime, WaitTime[");
      localStringBuilder.append(localSessionInfo.Q);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    localSessionInfo.Q = paramInt;
  }
  
  public void f(long paramLong)
  {
    Object localObject2 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    OperationBtnItem localOperationBtnItem = a(2131695347, paramLong);
    if (localOperationBtnItem != null)
    {
      if (localObject2 == null) {
        return;
      }
      Object localObject1 = SessionMgr.a().a();
      if (!((SessionInfo)localObject1).j())
      {
        localOperationBtnItem.c(false);
        return;
      }
      boolean bool1 = QAVConfigUtils.j();
      localOperationBtnItem.c(bool1);
      if (bool1)
      {
        localObject1 = ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).b((SessionInfo)localObject1);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((WatchTogetherInfo)localObject1).a;
        }
        boolean bool3 = true;
        if ((localObject1 != null) && (((WTogetherRoom)localObject1).a() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = bool3;
        if (bool1) {
          if (((WTogetherRoom)localObject1).e()) {
            bool2 = bool3;
          } else {
            bool2 = false;
          }
        }
        if (bool1) {
          localOperationBtnItem.a(((Context)localObject2).getResources().getString(2131695348));
        } else {
          localOperationBtnItem.a(((Context)localObject2).getResources().getString(2131695347));
        }
        localOperationBtnItem.a(bool2);
        localOperationBtnItem.b(bool2 ^ true);
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_d_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateBtn_WatchTogether, watching[");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append("], enable[");
          ((StringBuilder)localObject2).append(bool2);
          ((StringBuilder)localObject2).append("]");
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_WatchTogether, entry close.");
      }
    }
  }
  
  public void f(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) < 1000L) {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (paramView == null) {
        return;
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      l(paramLong, 2131695339);
      paramView.a(paramLong);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
    }
  }
  
  protected void g(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$RecordInfo.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
      i(paramLong, 16777215);
      l(paramLong, 2131695338);
    }
  }
  
  @TargetApi(11)
  public void h()
  {
    long l = AudioHelper.b();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPauseVideo, seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j)
    {
      a("onPauseVideo", 1);
      s();
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().P = 0;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onResumeVideo setRotation");
      }
      a(l, 0.0F);
    }
  }
  
  public void h(long paramLong)
  {
    if (h()) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373634);
    boolean bool = localSessionInfo.r();
    int k = 0;
    if (bool) {}
    int j;
    for (;;)
    {
      j = 0;
      break;
      if ((QAVConfigUtils.d()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean))
      {
        j = 1;
        break;
      }
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_Sharpness. no show. isDoubleVideoSharpnessEnable = ");
      localStringBuilder.append(QAVConfigUtils.d());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (localImageButton != null)
    {
      int m = localSessionInfo.jdField_w_of_type_Int;
      int i = 2130842365;
      if (m != 0) {
        if (localSessionInfo.jdField_w_of_type_Int == 1) {
          i = 2130842366;
        } else if (localSessionInfo.jdField_w_of_type_Int == 2) {
          i = 2130842368;
        } else if (localSessionInfo.jdField_w_of_type_Int == 3) {
          i = 2130842367;
        }
      }
      QavPanel.setBtnTopDrawable(localImageButton, i);
      if (j != 0) {
        i = k;
      } else {
        i = 8;
      }
      localImageButton.setVisibility(i);
      if (j == 0) {
        ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373442)).setVisibility(4);
      }
    }
  }
  
  public void i()
  {
    long l = AudioHelper.b();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeVideo, SessionType[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131720255));
      ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onResumeVideo", 2);
      a("onResumeVideo", 2);
      ThreadManager.excute(new DoubleVideoCtrlUI.14(this, l), 16, null, false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().x) {
        e(true);
      }
    }
    else
    {
      i(l, 16777215);
    }
    C(l);
  }
  
  public void i(long paramLong)
  {
    if (h()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695338);
    if (localObject1 == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_Record, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i = ((SessionInfo)localObject2).jdField_d_of_type_Int;
    boolean bool2 = false;
    Object localObject3;
    boolean bool1;
    if ((i != 3) && (((SessionInfo)localObject2).jdField_d_of_type_Int != 4) && (((SessionInfo)localObject2).jdField_d_of_type_Int != 1))
    {
      localObject3 = a();
      if (((AVActivity)localObject3).jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl == null)
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          localObject2 = this.jdField_d_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateBtn_Record, !mRecordUiCtrl, seq[");
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append("]");
          QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          bool1 = bool2;
        }
      }
      else if (!((AVActivity)localObject3).jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.h())
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          localObject2 = this.jdField_d_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateBtn_Record, !isEnableRecord, seq[");
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append("]");
          QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          bool1 = bool2;
        }
      }
      else if ((((SessionInfo)localObject2).j) && (((SessionInfo)localObject2).jdField_k_of_type_Boolean))
      {
        if (((SessionInfo)localObject2).r())
        {
          bool1 = bool2;
          if (jdField_o_of_type_Boolean)
          {
            QLog.w(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_Record, in watch together mode.");
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = true;
        }
      }
      else
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          localObject3 = this.jdField_d_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateBtn_Record, sessionInfo.localHasVideo, seq[");
          localStringBuilder.append(((SessionInfo)localObject2).j);
          localStringBuilder.append("][sessionInfo.remoteHasVideo=");
          localStringBuilder.append(((SessionInfo)localObject2).jdField_k_of_type_Boolean);
          localStringBuilder.append("]");
          QLog.w((String)localObject3, 1, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (jdField_o_of_type_Boolean)
      {
        localObject2 = this.jdField_d_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateBtn_Record, 场景不支持, seq[");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append("]");
        QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        bool1 = bool2;
      }
    }
    ((OperationBtnItem)localObject1).a(DoubleVideoCtrlUI.RecordInfo.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$RecordInfo));
    ((OperationBtnItem)localObject1).c(bool1);
  }
  
  public void j() {}
  
  public void j(long paramLong)
  {
    i(paramLong, 16777215);
  }
  
  public void k()
  {
    if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    long l = AudioHelper.b();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean);
    localStringBuilder.append(", seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean)
    {
      a("onNeedShowPeerVideo.1", 2);
      i(l, 16777215);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "onNeedShowPeerVideo.2", 2);
      a("onNeedShowPeerVideo.2", 2);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void k(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeCloseCamera, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    i(paramLong, 16777215);
  }
  
  void l()
  {
    J();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation);
  }
  
  public void l(long paramLong)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j())
    {
      OperationBtnItem localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695339);
      if (localOperationBtnItem != null) {
        localOperationBtnItem.c(false);
      }
      return;
    }
    super.l(paramLong);
  }
  
  void m()
  {
    h(true);
    QavInOutAnimation localQavInOutAnimation = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localQavInOutAnimation != null) {
      localQavInOutAnimation.a(new DoubleVideoCtrlUI.15(this));
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$RecordInfo.a();
    i(-1027L, 16777215);
  }
  
  public void o()
  {
    if (h()) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, SessionType[");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject3).jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    int i = ((SessionInfo)localObject3).jdField_k_of_type_Int;
    String str1 = ((SessionInfo)localObject3).jdField_c_of_type_JavaLangString;
    String str2 = ((SessionInfo)localObject3).jdField_e_of_type_JavaLangString;
    Object localObject2 = ((SessionInfo)localObject3).jdField_d_of_type_JavaLangString;
    if (((SessionInfo)localObject3).jdField_e_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, str2);
      ((SessionInfo)localObject3).jdField_d_of_type_JavaLangString = ((String)localObject2);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373392));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373393));
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371697));
      if (((SessionInfo)localObject3).jdField_d_of_type_Int == 2) {
        d(l, true);
      } else {
        d(l, false);
      }
    }
    if (((SessionInfo)localObject3).jdField_d_of_type_Int == 2) {
      d(l, true);
    } else if (((SessionInfo)localObject3).jdField_d_of_type_Int == 1) {
      b(false);
    }
    Bitmap localBitmap = null;
    if (((SessionInfo)localObject3).jdField_k_of_type_Int == 25)
    {
      localObject1 = ((SessionInfo)localObject3).jdField_g_of_type_JavaLangString;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((SessionInfo)localObject3).jdField_e_of_type_JavaLangString;
      }
      String str3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, (String)localObject2);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, (String)localObject2, true, true);
      if ((str3.equals(((SessionInfo)localObject3).jdField_c_of_type_JavaLangString)) && (localObject2 != null))
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)localObject2);
        }
        localObject3 = this.jdField_c_of_type_AndroidWidgetTextView;
        localObject1 = localBitmap;
        if (localObject3 != null)
        {
          ((TextView)localObject3).setText((CharSequence)localObject2);
          localObject1 = localBitmap;
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(str3);
        }
        localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
        localObject1 = localBitmap;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(str3);
          localObject1 = localBitmap;
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      localObject3 = this.jdField_c_of_type_AndroidWidgetTextView;
      localObject1 = localBitmap;
      if (localObject3 != null)
      {
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject1 = localBitmap;
      }
    }
    localObject2 = new AvatarParam(i, str1, str2, true);
    this.jdField_a_of_type_ComTencentAvAvatarQavUpdateAvatarViewHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, (AvatarParam)localObject2, (Bitmap)localObject1);
    i(l, 16777215);
  }
  
  void p()
  {
    ChildLockCircle localChildLockCircle = a();
    if (localChildLockCircle != null)
    {
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean)) {
        bool = false;
      } else {
        bool = true;
      }
      localChildLockCircle.a(bool);
    }
  }
  
  void q()
  {
    ChildLockCircle localChildLockCircle;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      localChildLockCircle = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373363);
    } else {
      localChildLockCircle = null;
    }
    if (localChildLockCircle != null) {
      localChildLockCircle.b();
    }
  }
  
  void r()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
  }
  
  public void s()
  {
    long l = AudioHelper.b();
    q();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.23(this, l), 300L);
    }
  }
  
  public void t()
  {
    long l = AudioHelper.b();
    if (AudioHelper.b())
    {
      str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfAudioEngineReady, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i != 5) && (i != 0))
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.f())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
          super.A(l);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
          return;
        }
        if (j > 18)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().ad)
          {
            this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
              super.A(l);
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
            super.A(l);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
        super.A(l);
      }
    }
  }
  
  public void u()
  {
    long l = AudioHelper.b();
    if (AudioHelper.b())
    {
      str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOppositeAudioEngineReady, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i != 5)
    {
      if (i == 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.f())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
          return;
        }
        if ((j > 18) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ac))
        {
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
          super.A(l);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */