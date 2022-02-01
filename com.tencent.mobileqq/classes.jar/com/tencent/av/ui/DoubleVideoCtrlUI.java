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
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
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
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AVUtil;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  private int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131373794);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockSign((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365981);
          Resources localResources = ((ViewGroup)localObject2).getResources();
          int i = localResources.getDimensionPixelOffset(2131297723);
          int j = localResources.getDimensionPixelOffset(2131297720);
          int k = ImmersiveUtils.getStatusBarHeight((Context)localObject3);
          int m = localResources.getDimensionPixelOffset(2131297721);
          localObject3 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, m, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          ((ChildLockSign)localObject1).setVisibility(8);
        }
      }
    }
    return localObject1;
  }
  
  private void a(long paramLong, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if (h()) {
      return;
    }
    if (paramSessionInfo.A())
    {
      WTogetherMng localWTogetherMng = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      if (localWTogetherMng != null) {
        localWTogetherMng.d(paramSessionInfo);
      }
      AVUtil.a("0X800B632", 0, 0, "", "", "", "");
      bool = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(this.jdField_d_of_type_JavaLangString, 4, "onClick_WatchTogether, open[" + bool + "]");
      return;
      WTEntranceHelper.a(a(), 2, paramSessionInfo.jdField_j_of_type_Int, paramSessionInfo.jdField_d_of_type_JavaLangString);
      AVUtil.a("0X800B61C", 0, 1, "", "", "", "");
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.a()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b())) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool;
    int j;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      bool = true;
      paramString.a("doMute", bool);
      j = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label137;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().b("doMute", 1);
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoCtrl.doMute", j, i, false);
      s(true);
      DataReport.c(this.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool = false;
      break;
      label137:
      this.jdField_a_of_type_ComTencentAvVideoController.a().b("doMute", 0);
    }
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    VideoController localVideoController = paramVideoAppInterface.a();
    SessionInfo localSessionInfo = localVideoController.a();
    String str = localSessionInfo.jdField_d_of_type_JavaLangString;
    int i;
    if (paramBoolean) {
      if (localSessionInfo.a(localVideoController)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "sendAddMemberBroadcast, peerUin[" + str + "], supportUinType[" + i + "], fromDoubleMeeting[" + paramBoolean + "], activity[" + paramActivity + "]");
      }
      if (i == 1) {}
      for (int j = 1;; j = 2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", j, 0, "", "", "", "");
        if ((i != 3000) || (paramActivity == null) || (!QAVConfigUtils.f())) {
          break label284;
        }
        paramVideoAppInterface = QAVConfigUtils.a();
        DialogUtil.a(paramActivity, 230, null, paramVideoAppInterface, "", HardCodeUtil.a(2131703467), new DoubleVideoCtrlUI.6(), null).show();
        if (QLog.isColorLevel()) {
          QLog.i("double_2_multi", 2, "sendAddMemberBroadcast tip[" + paramVideoAppInterface + "]");
        }
        ReportController.b(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
        return;
        i = 3000;
        break;
        if (!localSessionInfo.b(localVideoController)) {
          break label340;
        }
        i = 1;
        break;
      }
      label284:
      paramActivity = new Intent();
      paramActivity.setAction("tencent.video.v2q.AddContactsFromC2C");
      paramActivity.putExtra("peerUin", str);
      paramActivity.putExtra("supportUinType", i);
      paramActivity.setPackage(paramVideoAppInterface.getApp().getPackageName());
      paramVideoAppInterface.getApp().sendBroadcast(paramActivity);
      return;
      label340:
      i = 3000;
    }
  }
  
  static void a(VideoAppInterface paramVideoAppInterface)
  {
    int i = 2131695409;
    VideoController localVideoController = paramVideoAppInterface.a();
    String str = localVideoController.a().jdField_d_of_type_JavaLangString;
    int j = localVideoController.b(str);
    int k = localVideoController.c(str);
    if (localVideoController.a().jdField_j_of_type_Int == 1011) {
      if (k >= 45) {
        break label130;
      }
    }
    while (i != 0)
    {
      TipsUtil.a(paramVideoAppInterface, 1012, i);
      return;
      if (!VcSystemInfo.isNormalSharp()) {
        i = 2131720561;
      } else if (Utils.a(localVideoController.a()) == 1) {
        i = 2131720494;
      } else if (k < 16) {
        i = 2131695410;
      } else if ((j == 4) || (j == 2) || (j == 3)) {
        label130:
        i = 0;
      }
    }
    TipsUtil.a(paramVideoAppInterface, 1012);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    int i = 0;
    int j = paramVideoAppInterface.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt > 0)
    {
      TipsUtil.a(paramVideoAppInterface, 1048, paramInt);
      return;
      if ((j == 3) || (j == 1))
      {
        paramInt = 2131695938;
      }
      else
      {
        paramInt = 2131695937;
        continue;
        if ((j == 3) || (j == 1))
        {
          paramInt = 2131695933;
        }
        else
        {
          paramInt = 2131695932;
          continue;
          if ((j == 3) || (j == 1)) {
            paramInt = 2131695935;
          } else {
            paramInt = 2131695934;
          }
        }
      }
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
    if ((localObject == null) || (!((SessionInfo)localObject).A())) {}
    do
    {
      do
      {
        return true;
        localObject = a();
      } while (localObject == null);
      localObject = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    } while ((localObject == null) || (((VideoLayerUI)localObject).g() == 1));
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "StartGlassCheck, cancel old Timer");
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    DoubleVideoCtrlUI.8 local8 = new DoubleVideoCtrlUI.8(this, paramBoolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "StartGlassCheck, begin Timer, bCheck[" + paramBoolean + "]");
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (paramBoolean) {}
    for (long l = 1000L;; l = 10000L)
    {
      localTimer.schedule(local8, l);
      return;
    }
  }
  
  private void l(long paramLong, View paramView)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity == null) || (localAVActivity.isFinishing()) || (localAVActivity.isDestroyed())) {
      return;
    }
    String str1 = localAVActivity.getString(2131718849);
    String str2 = localAVActivity.getString(2131718848);
    String str3 = localAVActivity.getString(2131695607);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (!localSharedPreferences.contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
    {
      ScreenShareDialogUtil.a(localAVActivity, str1, str2, str3, null, true, 10, new DoubleVideoCtrlUI.17(this, paramLong, paramView), null).show();
      localSharedPreferences.edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
      return;
    }
    DialogUtil.a(localAVActivity, 230, str1, str2, null, str3, new DoubleVideoCtrlUI.18(this, paramLong, paramView), null).show();
  }
  
  private void m(long paramLong, View paramView)
  {
    Object localObject = a();
    if ((localObject == null) || (((AVActivity)localObject).isFinishing()) || (((AVActivity)localObject).isDestroyed())) {
      return;
    }
    localObject = ActionSheet.create((Context)localObject);
    ((ActionSheet)localObject).addButton(2131718836, 0);
    if (QAVConfigUtils.l()) {
      ((ActionSheet)localObject).addButton(2131718835, 0);
    }
    ((ActionSheet)localObject).addCancelButton(2131690800);
    ((ActionSheet)localObject).setOnButtonClickListener(new DoubleVideoCtrlUI.19(this, paramLong, paramView, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnBottomCancelListener(new DoubleVideoCtrlUI.20(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    ScreenShareReportHelper.a("0X800B8A1");
  }
  
  private void n(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    paramView.a(paramLong, "onClick_InviteMember");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9000), paramView });
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "onClick_InviteMember block[" + paramView.jdField_b_of_type_Boolean + "]");
    }
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_InviteMember, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695327);
      return;
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
  }
  
  private void s(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      AVVoiceRecog.a().a(32);
      super.k(2131373779);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690285));
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label193;
      }
    }
    label193:
    for (paramBoolean = true;; paramBoolean = false)
    {
      q(paramBoolean);
      return;
      AVVoiceRecog.a().b(32);
      super.l(2131373779);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690272));
      break;
    }
  }
  
  private void v()
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setForground, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "]");
    if (this.jdField_p_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_b_of_type_Boolean) || (SessionMgr.a().a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b();
  }
  
  private void w()
  {
    boolean bool2 = true;
    Object localObject = a();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localWatchTogetherMediaPlayCtrl != null) && (localObject != null) && (localSessionInfo != null) && (localSessionInfo.A()))
    {
      localObject = ((AVActivity)localObject).a(localWatchTogetherMediaPlayCtrl.i());
      if (this.jdField_h_of_type_Boolean) {
        break label90;
      }
      bool1 = true;
      localSessionInfo.c(bool1);
      if (this.jdField_h_of_type_Boolean) {
        break label95;
      }
    }
    label90:
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((WatchTogetherUIProxy)localObject).setImmersiveStatus(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected int a()
  {
    return 2131559813;
  }
  
  public int a(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  ChildLockCircle a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131373791);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockCircle((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131365981);
          localObject3 = ((ViewGroup)localObject2).getResources();
          int i = ((Resources)localObject3).getDimensionPixelOffset(2131297719);
          int j = ((Resources)localObject3).getDimensionPixelOffset(2131297718);
          int k = ((Resources)localObject3).getDimensionPixelOffset(2131297922);
          localObject3 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, 0, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          ((ChildLockCircle)localObject1).a();
        }
      }
    }
    return localObject1;
  }
  
  public void a() {}
  
  void a(int paramInt)
  {
    switch (paramInt)
    {
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onTerSwitchSyncStatus, cameraStatus[" + paramInt1 + "], micStatus[" + paramInt2 + "]");
    }
    if (h()) {
      return;
    }
    if (paramInt1 == 1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      label103:
      SessionInfo localSessionInfo;
      label155:
      boolean bool;
      if (paramInt1 == 0)
      {
        k(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramInt1 == 0) && (!localSessionInfo.k)) {
          break label328;
        }
        if (localSessionInfo.jdField_d_of_type_Int == 1)
        {
          localSessionInfo.a(l, "onTerSwitchSyncStatus.1", 2);
          a("onTerSwitchSyncStatus.1", localSessionInfo.jdField_d_of_type_Int);
        }
        if (paramInt2 != 0) {
          break label362;
        }
        bool = true;
        label162:
        localSessionInfo.a("onTerSwitchSyncStatus", bool);
        if (paramInt2 != 0) {
          break label368;
        }
      }
      String str;
      label328:
      label362:
      label368:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        localSessionInfo.b("onTerSwitchSyncStatus", paramInt1);
        str = localSessionInfo.jdField_d_of_type_JavaLangString;
        if (!localSessionInfo.jdField_g_of_type_Boolean) {
          break label373;
        }
        super.k(2131373779);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690285));
        return;
        j(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l) });
        break label103;
        if (localSessionInfo.jdField_d_of_type_Int != 2) {
          break label155;
        }
        localSessionInfo.a(l, "onTerSwitchSyncStatus.2", 1);
        a("onTerSwitchSyncStatus.2", localSessionInfo.jdField_d_of_type_Int);
        break label155;
        bool = false;
        break label162;
      }
      label373:
      super.l(2131373779);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690272));
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    View localView1;
    View localView2;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374077);
      localView2 = this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131374078);
      if (AudioHelper.a(0) == 1)
      {
        localView1.setBackgroundColor(2147460352);
        localView2.setBackgroundColor(2147460352);
      }
      if (localView1 != null)
      {
        localLayoutParams1 = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
        localLayoutParams2 = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
        if (localLayoutParams1 != null)
        {
          if (!l()) {
            break label173;
          }
          if (paramBoolean) {
            break label145;
          }
          localLayoutParams1.topMargin = (paramInt - d() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
        }
      }
    }
    for (;;)
    {
      localLayoutParams2.topMargin = localLayoutParams1.topMargin;
      localView1.setLayoutParams(localLayoutParams1);
      localView2.setLayoutParams(localLayoutParams2);
      return;
      label145:
      localLayoutParams1.topMargin = (-d() + this.jdField_a_of_type_AndroidViewViewGroup.getWidth() * 106 / 750);
      continue;
      label173:
      if (!paramBoolean)
      {
        localLayoutParams1.topMargin = (paramInt - d() + AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentResResources));
        if (LiuHaiUtils.b())
        {
          paramInt = localLayoutParams1.topMargin;
          localLayoutParams1.topMargin = (LiuHaiUtils.b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()) + paramInt);
        }
      }
      else
      {
        localLayoutParams1.topMargin = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131373781) || (paramInt1 == 2131373782)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373781, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373781, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().h())
      {
        if (!AVReport.a().jdField_a_of_type_Boolean) {
          break label196;
        }
        VideoNodeManager.a(29);
        AVReport.a().j = SystemClock.elapsedRealtime();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int < 0) {
          break label414;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 1011) {
          break label208;
        }
        a_(-1015L, 2131695420);
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null) {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
        }
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
      }
      int i;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if ((i == 1) || (i == 3) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().y)) {
          break label431;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
        d(false);
      }
      return;
      label196:
      AVReport.a().y = SystemClock.elapsedRealtime();
      break;
      label208:
      a_(-1015L, 2131695357);
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long;
      String str = ColorRingManager.a(l, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int;
        ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator == null) {
          break label412;
        }
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
        }
      }
      label412:
      continue;
      label414:
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null) {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
      }
    }
    label431:
    s();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], seq[" + paramLong + "]");
    }
    s();
    super.a(paramLong, paramInt);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int k = localSessionInfo.jdField_j_of_type_Int;
    int i;
    int j;
    label99:
    Object localObject;
    if (localSessionInfo.jdField_d_of_type_Long == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label543;
      }
      j = 1;
      if (((localSessionInfo.o()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((localSessionInfo.p()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26) || (k == 1044)))) {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          DataReport.p(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new DoubleVideoCtrlUI.13(this, paramLong));
          Q();
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose phoneNumber is " + (String)localObject);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 3)) {
            break label563;
          }
          if (Build.VERSION.SDK_INT < 17) {
            break label549;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373765, 8);
          localObject = (Button)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373778);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((Button)localObject).getLayoutParams();
          localLayoutParams.rightMargin = 0;
          localLayoutParams.removeRule(11);
          localLayoutParams.addRule(14);
          ((Button)localObject).setLayoutParams(localLayoutParams);
        }
      }
    }
    for (;;)
    {
      if (paramInt == 3) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131374085, false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373778, true);
      localObject = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
      if (localObject != null) {
        ((EffectOperateManager)localObject).b(false);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.a();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      }
      this.jdField_b_of_type_Boolean = true;
      if ((localSessionInfo.l()) && (localSessionInfo.jdField_d_of_type_Int == 2) && (!localSessionInfo.jdField_j_of_type_Boolean)) {
        DataReport.e();
      }
      localSessionInfo.a("onClose", false);
      localSessionInfo.b("onClose", 0);
      if (paramInt == 24)
      {
        this.i = true;
        a_(paramLong, 2131695807);
      }
      if (paramInt == 42) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      return;
      i = 0;
      break;
      label543:
      j = 0;
      break label99;
      label549:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373765, false);
      continue;
      label563:
      ReportController.b(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373765, true);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick mVideoController == null");
    }
    label809:
    label894:
    do
    {
      String str1;
      int i;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
            {
              QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick mQavPanel == null");
              return;
            }
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().x)
            {
              QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick isChildLock");
              return;
            }
          } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)));
          str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          localObject = a();
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131364590: 
          case 2131365705: 
          case 2131374080: 
            S();
            return;
          case 2131695328: 
            g(paramLong);
            return;
          case 2131374082: 
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick qav_titlebar_quit_double_screen ");
            MagicDataReport.f(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) + "");
            this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(134) });
            return;
          case 2131373773: 
          case 2131373774: 
          case 2131373775: 
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick Hangup ");
            a(paramView);
            return;
          case 2131373771: 
            bool = c();
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE canClick:=" + bool);
          }
        } while (!bool);
        boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().P;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          DataReport.a(paramView, bool);
          if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(TraeHelper.c);
          return;
        }
        d(paramLong, paramView);
        return;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView != null) && (paramView.jdField_j_of_type_Int == 1044)) {
          ReportController.b(null, "dc00898", "", "", "0X800AD98", "0X800AD98", 0, 0, "", "", "", "");
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick HIDE ");
        this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
        com.tencent.av.VideoConstants.ProcessInfo.a = "3";
        a();
        DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        e(paramLong, paramView);
        return;
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        DataReport.a(paramView.getId(), i);
        a((AVActivity)localObject, str1);
        return;
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
        n(paramLong, paramView);
        return;
        g(paramLong, paramView);
        return;
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
        AVTraceUtil.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean)
        {
          bool = true;
          paramView.jdField_m_of_type_Boolean = bool;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean) {
            break label894;
          }
          ReportController.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
        }
        for (i = 2131692888; this.jdField_a_of_type_ComTencentAvUiQavPanel != null; i = 2131692887)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131374085, this.jdField_a_of_type_AndroidContentResResources.getString(i));
          return;
          bool = false;
          break label809;
          ReportController.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          TraeHelper.a().b(paramLong);
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int;
          paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject, str2, true);
        }
        DataReport.q(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvVideoController.b(str1, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_z_of_type_Int);
        return;
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Voice");
        i(paramLong, paramView);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      } while ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044));
      ReportController.b(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
      return;
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.Effect");
      j(paramLong, paramView);
      return;
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.OPEN_LOCK");
      this.jdField_a_of_type_ComTencentAvVideoController.a(str1, 1, 5, 1);
      a(2131695893, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299166));
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 1) {
          break label1343;
        }
      }
      for (int j = 1;; j = 3)
      {
        ReportController.b(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i, j, "", "", "", "");
        paramView = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process&_wwv=4");
        ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
        l(paramLong, 2131695333);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044)) {
          break;
        }
        ReportController.b(null, "dc00898", "", "", "0X800AD96", "0X800AD96", 0, 0, "", "", "", "");
        return;
        i = 2;
        break label1187;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
      ReportController.b(null, "CliOper", "", "", "0X800A343", "0X800A343", this.jdField_a_of_type_ComTencentAvVideoController.a().w + 1, 0, "", "", "", "");
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.g("Sharpness");
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() == 1) {
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramLong);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.b();
      return;
      h(paramLong, paramView);
      return;
      b(paramLong, paramView);
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while ((paramView == null) || (paramView.jdField_j_of_type_Int != 1044));
    label1187:
    label1343:
    ReportController.b(null, "dc00898", "", "", "0X800AD95", "0X800AD95", 0, 0, "", "", "", "");
    return;
    l(paramLong, paramView);
    return;
    k(paramLong, paramView);
    return;
    c(paramLong, paramView);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setTitleText, mRingAnimator[" + this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.jdField_a_of_type_Boolean + "], startRingAnimator[" + paramBoolean + "], seq[" + paramLong + "]");
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
    if ((i == 2) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) && (paramBoolean) && (localSessionInfo.l()))
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
    AVActivity localAVActivity = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    boolean bool;
    if (localAVActivity != null) {
      if (localAVActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], isConnected[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int + "], mCameraNum[" + this.q + "], remoteHasVideo[" + this.jdField_a_of_type_ComTencentAvVideoController.a().k + "], checkCameraResult[" + bool + "], seq[" + paramLong + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374081, 0);
        localAVActivity = a();
        if (localAVActivity != null) {
          localAVActivity.a(true);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = true;
        DataReport.c();
        DataReport.m(this.jdField_a_of_type_ComTencentAvVideoController);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().k) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l())) {
          a("onAfterOpenCamera", 2);
        }
        D(paramLong);
      }
      i(paramLong, 16777215);
      return;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  void a(Bitmap paramBitmap)
  {
    paramBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  void a(View paramView)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Hangup, seq[" + l + "]");
    int i = paramView.getId();
    if ((i == 2131373773) || (i == 2131373774)) {
      AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup");
    }
    String str;
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramView = new ControlUIObserver.CPreEventInfo(paramView);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9002), paramView });
      if (!paramView.jdField_b_of_type_Boolean) {
        break;
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Hangup, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "]");
      return;
      if (i == 2131373775) {
        AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "exit when click bottom bar hangup no answer");
      }
    }
    g(true);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new DoubleVideoCtrlUI.25(this, l, str));
  }
  
  void a(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.CALL_PHONE, type[" + i + "], PhoneNum[" + AudioHelper.a(this.jdField_a_of_type_ComTencentAvVideoController.a().a()) + "]");
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.a().a())));
    ReportController.b(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(236);
    this.jdField_a_of_type_ComTencentAvVideoController.b(paramString, 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 25)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setQCallNickName");
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    super.a(paramString);
  }
  
  void a(String paramString, int paramInt)
  {
    boolean bool2 = true;
    long l = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "avSwitch[" + paramString + "], sessionType[" + paramInt + "], seq[" + l + "]");
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    SensorHelper localSensorHelper;
    if (paramInt == 1)
    {
      o();
      d(l, false);
      i(l, 16777215);
      e(0);
      new ControlUIObserver.ZimuRequest(l, "avSwitch", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label226;
      }
      bool1 = true;
      label149:
      localSensorHelper.c(bool1);
      localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 1) {
        break label231;
      }
    }
    label226:
    label231:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localSensorHelper.b(bool1);
      c(l, paramString + "_avSwitch");
      return;
      if (paramInt != 2) {
        break;
      }
      d(l, true);
      break;
      bool1 = false;
      break label149;
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setQCallHead uin = " + paramString);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
    super.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    SessionInfo localSessionInfo;
    int i;
    label288:
    label372:
    do
    {
      do
      {
        long l;
        do
        {
          return;
          localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
          l = AudioHelper.b();
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onInviteReached, peerUin[" + paramString1 + "], showMsg[" + paramString2 + "], remotePhoneState[" + localSessionInfo.jdField_o_of_type_Int + "], remoteTerminal[" + localSessionInfo.l + "], phoneOnLine[" + localSessionInfo.jdField_n_of_type_Int + "], pcOnLine[" + localSessionInfo.jdField_m_of_type_Int + "], subState[" + localSessionInfo.jdField_d_of_type_Long + "], isPeerNetworkWell[" + localSessionInfo.r + "], seq[" + l + "]");
        } while ((!localSessionInfo.h()) || (localSessionInfo.ak) || (localSessionInfo.jdField_j_of_type_Int == 1011) || (!localSessionInfo.jdField_d_of_type_JavaLangString.contains(paramString1)));
        i = localSessionInfo.jdField_o_of_type_Int;
        if (i >= 0)
        {
          if (TextUtils.isEmpty(paramString2)) {
            a_(l, 2131695357);
          }
        }
        else {
          if (localSessionInfo.jdField_d_of_type_Long != 0L) {
            break label288;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
          {
            this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
            this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
          }
          if ((i <= 0) || (i == 3)) {
            break label372;
          }
          a(i);
          DataReport.e(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
          d(l, paramString2);
          break;
          if (localSessionInfo.jdField_d_of_type_Long == 2L)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.onCloseVideo(localSessionInfo.jdField_d_of_type_JavaLangString, 8, 0L);
            if (!TextUtils.isEmpty(localSessionInfo.jdField_o_of_type_JavaLangString)) {
              TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3008, localSessionInfo.jdField_o_of_type_JavaLangString);
            }
            ReportController.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
          }
        }
        if (i != 4) {
          break;
        }
      } while ((localSessionInfo.jdField_m_of_type_Int != 1) || (localSessionInfo.jdField_n_of_type_Int != 0));
      a(i);
      return;
    } while ((i != 0) || (!localSessionInfo.r) || (localSessionInfo.l == 2) || (localSessionInfo.jdField_d_of_type_Int != 1));
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPeerSwitchTerminal, peerUin[" + paramString + "], bStartSwitch[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
    }
    for (;;)
    {
      i(l, 16777215);
      paramString = DoodleLogic.a();
      if (!paramBoolean) {
        break;
      }
      paramString.jdField_b_of_type_Boolean = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.jdField_b_of_type_Boolean);
      }
      SmallScreenUtils.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1020);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onPeerSwitchTerminal, local close camera");
        }
        k(l);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1021);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      this.jdField_a_of_type_ComTencentAvVideoController.y();
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363823);
      if (localView != null)
      {
        if ((!paramBoolean) || (localView.getVisibility() == 0)) {
          break label39;
        }
        localView.setVisibility(0);
      }
    }
    label39:
    while ((paramBoolean) || (localView.getVisibility() == 8)) {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt, false);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    boolean bool = false;
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      i = j;
      if (paramBoolean1) {
        i = 0;
      }
      ((RelativeLayout)localObject).setVisibility(i);
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramBoolean2))
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
          paramBoolean2 = bool;
          if (!paramBoolean1) {
            paramBoolean2 = true;
          }
          ((QavPanel)localObject).d(paramBoolean2);
        }
        new VideoControlUI.QavStatusBar(this.jdField_a_of_type_AndroidViewViewGroup).a(paramBoolean1);
      }
      c(-1035L, "changeToDoubleScreen");
      return;
    }
  }
  
  public boolean a()
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBackPressed, seq[" + l + "], isChildLock[" + ((SessionInfo)localObject).x + "]");
    if (((SessionInfo)localObject).x) {
      return true;
    }
    if (super.a())
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBackPressed called return 2, seq[" + l + "]");
      return true;
    }
    v();
    String str = ((SessionInfo)localObject).jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    if ((!SmallScreenUtils.f()) && (((SessionInfo)localObject).jdField_d_of_type_Int == 2) && (((SessionInfo)localObject).jdField_j_of_type_Boolean)) {
      a(2131695482, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299166));
    }
    if ((((SessionInfo)localObject).o()) || (((SessionInfo)localObject).p()))
    {
      j(((SessionInfo)localObject).jdField_z_of_type_Int);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.16(this, l), 150L);
    }
    if (SmallScreenUtils.f())
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((SmallScreenActivityPlugin)localObject).a();
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject == null) {
      return false;
    }
    if (!((SessionInfo)localObject).aA) {
      return false;
    }
    if (!((SessionInfo)localObject).k)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassSwitch, Remote not has video, GlassSwitch[" + paramInt + "]");
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((SessionInfo)localObject).R != paramInt)) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassSwitch, GlassSwitch[" + ((SessionInfo)localObject).R + "->" + paramInt + "]");
    }
    if (((SessionInfo)localObject).R == paramInt) {
      return false;
    }
    ((SessionInfo)localObject).R = paramInt;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return false;
    }
    localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject == null) || (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)) {
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.n();
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3011);
      continue;
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1039);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentAvVideoController.a().x;
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
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
        break label468;
      }
      bool = true;
      localQavPanel.a(2131559863, bool, BeautyToolbar.checkShowBeauty(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1044) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setNoVideoAndShareBtnMode();
      }
    }
    d(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372115));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374082));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373809));
    if (AudioHelper.a(0) == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147483392);
    }
    if (Build.VERSION.SDK_INT <= 20)
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "need reset quit double screen listener");
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new DoubleVideoCtrlUI.7(this));
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373801));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373773, this.jdField_a_of_type_AndroidContentResResources.getString(2131690283));
      }
      d(l, false);
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373779, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373779, false);
      }
      c(l, "initUI");
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373819), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373951), null);
      GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 0))) {
        ReportController.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
      }
      return;
      label468:
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373773, this.jdField_a_of_type_AndroidContentResResources.getString(2131720507));
      }
      d(l, true);
    }
  }
  
  void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011) && (paramInt != 2131695420) && (paramInt != 2131720501)) {}
    while (paramInt <= 0) {
      return;
    }
    a_(-1016L, paramInt);
  }
  
  public void b(long paramLong)
  {
    boolean bool2 = false;
    super.b(paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject1).l())
    {
      if (((SessionInfo)localObject1).jdField_d_of_type_Long != 1L) {
        super.B(paramLong);
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (((SessionInfo)localObject1).jdField_d_of_type_Int != 1) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((SensorHelper)localObject2).b(bool1);
      o();
      DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_e_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!((SessionInfo)localObject1).aA)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.12(this), 200L);
      return;
    }
    localObject1 = this.jdField_d_of_type_JavaLangString;
    Object localObject2 = new StringBuilder().append("onResume, AsyncReadDoubleGlassConfig, mVideoController[");
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      bool1 = true;
    }
    QLog.w((String)localObject1, 1, bool1 + "]");
    c();
  }
  
  @TargetApi(11)
  public void b(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k)) {
      a(paramLong, 360 - paramInt);
    }
    for (;;)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373791);
        }
      }
      if (localObject1 != null) {
        ((ChildLockCircle)localObject1).setRotation(360 - paramInt);
      }
      return;
      a(paramLong, 0.0F);
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    paramView = a();
    if (paramView != null)
    {
      if (!paramView.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a()) {
        break label44;
      }
      paramView.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(3);
    }
    for (;;)
    {
      ChatRoomUtil.a("0X800A8D0");
      return;
      label44:
      paramView.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a(0);
    }
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
    int i = 2;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramBoolean);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    QavPanel localQavPanel;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean)) {
          break label135;
        }
        localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
        {
          paramBoolean = bool1;
          localQavPanel.a(paramBoolean, 0, false);
        }
      }
      else if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getColor(2131166051));
      }
    }
    label135:
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      for (;;)
      {
        return;
        paramBoolean = false;
      }
      paramBoolean = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
        paramBoolean = true;
      }
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (paramBoolean) {}
      for (;;)
      {
        localQavPanel.a(paramBoolean, i, true);
        break;
        i = 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean))
    {
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {}
      for (paramBoolean = bool3;; paramBoolean = false)
      {
        localQavPanel.a(paramBoolean, 0, false);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
    {
      paramBoolean = true;
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (!paramBoolean) {
        break label290;
      }
    }
    for (;;)
    {
      localQavPanel.a(paramBoolean, i, false);
      return;
      paramBoolean = false;
      break;
      label290:
      i = 1;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPhoneCalling, isSelf[" + paramBoolean1 + "], seq[" + l + "]");
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        if (paramBoolean2)
        {
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
          return;
        }
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1019);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1018);
      ReportController.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
        localObject = new TraeMediaPlayer((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
        if (GAudioSoundUtil.a("qav_peer_phone_calling.mp3")) {
          ((TraeMediaPlayer)localObject).a(l, 2, 0, null, GAudioSoundUtil.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_S_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
          ((TraeMediaPlayer)localObject).a(l, 0, 2131230737, null, null, false, 1, false, true, 0);
          GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
        }
        ReportController.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean);
    this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject);
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a().l();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.9(this), 100L);
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()))
    {
      if (!this.jdField_h_of_type_Boolean) {
        e(paramInt);
      }
      return;
    }
    e(paramInt);
    D(l);
  }
  
  public void c(long paramLong)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_p_of_type_Boolean)) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onStop, mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "], seq[" + paramLong + "]");
    }
    super.c(paramLong);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l())) {
      super.C(paramLong);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
      {
        k(paramLong);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission local close camera, remote[" + this.jdField_a_of_type_ComTencentAvVideoController.a().k + "]");
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
    if (!WTogetherUtil.a(paramView.jdField_d_of_type_JavaLangString))
    {
      a(2131695990, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299166));
      AVUtil.a("0X800B61C", 0, 0, "", "", "", "");
      return;
    }
    WTogetherRealNameVideoProcessHelper localWTogetherRealNameVideoProcessHelper = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    localWTogetherRealNameVideoProcessHelper.b(new DoubleVideoCtrlUI.21(this, paramLong, paramView, localWTogetherRealNameVideoProcessHelper));
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onAfterCloseCamera, success[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    i(paramLong, 16777215);
    if (paramBoolean)
    {
      h(true);
      DataReport.d();
      DataReport.n(this.jdField_a_of_type_ComTencentAvVideoController);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k) {
        a("onAfterCloseCamera", 1);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k) {
        a(paramLong, 0.0F);
      }
    }
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    this.jdField_a_of_type_ComTencentAvVideoController.a().y = false;
    s();
  }
  
  public void c(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onNotRecvAudioData, bNotRecv[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      this.r = 1;
    }
    while (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) == 5)
      {
        return;
        this.r = 2;
      }
      else
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) == 5) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L) {
        break;
      }
      super.B(l);
      return;
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3005);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    s(paramBoolean2);
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "avideo onCreate, state[" + ((SessionInfo)localObject1).jdField_g_of_type_Int + "], seq[" + l + "]");
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    if (((SessionInfo)localObject1).F == 0) {
      ((SessionInfo)localObject1).F = 3;
    }
    int j;
    int i;
    if ((((SessionInfo)localObject1).f()) || (((SessionInfo)localObject1).j()))
    {
      j = 1;
      if (((SessionInfo)localObject1).jdField_S_of_type_Boolean) {
        j = 0;
      }
      i = 1;
      if (!((SessionInfo)localObject1).N) {
        i = 4;
      }
      if (1008 == ((SessionInfo)localObject1).jdField_j_of_type_Int) {
        i = 4;
      }
    }
    label644:
    label1304:
    for (;;)
    {
      Object localObject2;
      if (((SessionInfo)localObject1).jdField_e_of_type_Boolean)
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString, j, i);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "result = " + i);
        }
        if (i != 0)
        {
          AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "Video connect fail:" + i);
          if (i == -2)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(((SessionInfo)localObject1).jdField_d_of_type_JavaLangString, 238);
            this.jdField_a_of_type_ComTencentAvVideoController.b(238);
            this.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject1).jdField_d_of_type_JavaLangString, 9);
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
          if (1044 != ((SessionInfo)localObject1).jdField_j_of_type_Int) {
            break label1304;
          }
          i = 4;
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
        int k;
        label354:
        String str;
        if (localObject2 != null)
        {
          if (i != 1) {
            break label452;
          }
          k = 3;
          str = ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString;
          if (!((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(k, str)) {
            break label457;
          }
          ((JniSimpleInfoMng)localObject2).a(str, 1, false);
        }
        for (;;)
        {
          i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString, j, i, ((SessionInfo)localObject1).i, ((SessionInfo)localObject1).jdField_j_of_type_JavaLangString, ((SessionInfo)localObject1).a(), ((SessionInfo)localObject1).jdField_j_of_type_Int, ((SessionInfo)localObject1).jdField_f_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_g_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_a_of_type_ArrayOfByte, null, null, 0, 0, null, null);
          break;
          label452:
          k = 0;
          break label354;
          label457:
          ((JniSimpleInfoMng)localObject2).a(str, 0, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, ofter Request, state[" + ((SessionInfo)localObject1).jdField_g_of_type_Int + "], SessionType[" + ((SessionInfo)localObject1).jdField_d_of_type_Int + "], deviceName[" + ((SessionInfo)localObject1).q + "], seq[" + l + "]");
      }
      if (((SessionInfo)localObject1).h())
      {
        if (((SessionInfo)localObject1).jdField_d_of_type_Int == 1)
        {
          this.jdField_e_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          label575:
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
        }
      }
      else
      {
        if (!((SessionInfo)localObject1).l()) {
          break label868;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label820;
        }
        label605:
        if (((SessionInfo)localObject1).jdField_d_of_type_Int == 2) {
          d(l, true);
        }
        i = ((SessionInfo)localObject1).jdField_j_of_type_Int;
        localObject2 = ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject2);
        if (this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver == null)
        {
          this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver = new DavWTogetherObserver(this);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver);
        }
        if (((SessionInfo)localObject1).jdField_n_of_type_Boolean) {
          o();
        }
        if (((SessionInfo)localObject1).jdField_S_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        }
        if (!((SessionInfo)localObject1).jdField_g_of_type_Boolean) {
          break label1247;
        }
        super.k(2131373779);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690285));
        }
      }
      for (;;)
      {
        a(l, false);
        this.jdField_a_of_type_AndroidViewViewGroup.post(new DoubleVideoCtrlUI.11(this));
        if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
        return;
        this.jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break label575;
        label820:
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L) || (((SessionInfo)localObject1).jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject1).jdField_d_of_type_JavaLangString) != 5)) {
          break label605;
        }
        DataReport.f(this.jdField_a_of_type_ComTencentAvVideoController);
        break label605;
        label868:
        if (((SessionInfo)localObject1).k())
        {
          if (((SessionInfo)localObject1).jdField_S_of_type_Boolean) {}
          for (i = 2131695492;; i = 2131720570)
          {
            b(i);
            break;
          }
        }
        if (((SessionInfo)localObject1).h())
        {
          i = 2131695843;
          if (((SessionInfo)localObject1).ak) {
            i = 2131695844;
          }
          if (((SessionInfo)localObject1).jdField_j_of_type_Int == 1011) {
            i = 2131695420;
          }
          if (((SessionInfo)localObject1).jdField_S_of_type_Boolean)
          {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "Inviting, remotePhoneState[" + ((SessionInfo)localObject1).jdField_o_of_type_Int + "], isPeerNetworkWell[" + ((SessionInfo)localObject1).r + "], remoteOnline[" + ((SessionInfo)localObject1).s + "], remoteTerminal[" + ((SessionInfo)localObject1).l + "]");
            if ((((SessionInfo)localObject1).jdField_o_of_type_Int == 0) && (((SessionInfo)localObject1).r) && (((SessionInfo)localObject1).l != 2) && (((SessionInfo)localObject1).jdField_d_of_type_Int == 1)) {
              TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
            }
          }
          b(i);
          i = ((SessionInfo)localObject1).jdField_j_of_type_Int;
          localObject2 = ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject2);
          i = ((SessionInfo)localObject1).jdField_o_of_type_Int;
          if ((i == 4) && (((SessionInfo)localObject1).jdField_m_of_type_Int == 1) && (((SessionInfo)localObject1).jdField_n_of_type_Int == 0)) {
            a(i);
          }
          if ((i <= 0) || (i == 3)) {
            break label644;
          }
          a(i);
          DataReport.e(this.jdField_a_of_type_ComTencentAvVideoController);
          break label644;
        }
        if (((SessionInfo)localObject1).j())
        {
          b(2131695683);
          break label644;
        }
        if ((!((SessionInfo)localObject1).o()) && (!((SessionInfo)localObject1).p())) {
          break label644;
        }
        j(((SessionInfo)localObject1).jdField_z_of_type_Int);
        if (((SessionInfo)localObject1).jdField_j_of_type_Int == 1011) {
          b(2131695814);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.10(this, l), 150L);
        break label644;
        label1247:
        super.l(2131373779);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131690272));
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (1 == paramInt) {
      if (!this.jdField_e_of_type_Boolean)
      {
        p();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt == 0)
            {
              q();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
              return;
            }
          } while (2 == paramInt);
          if (3 != paramInt) {
            break;
          }
          localObject1 = a();
        } while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().t != 2) || (localObject1 == null) || (!((ChildLockSign)localObject1).isEnabled()));
        if (((ChildLockSign)localObject1).getVisibility() != 0)
        {
          ((ChildLockSign)localObject1).setLocked(true);
          ((ChildLockSign)localObject1).setVisibility(0);
          r();
          return;
        }
        ((ChildLockSign)localObject1).setVisibility(8);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        return;
      } while (4 != paramInt);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373791);
        }
      }
    } while (localObject1 == null);
  }
  
  public void d(long paramLong)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver);
        this.jdField_a_of_type_ComTencentAvWtogetherDavWTogetherObserver = null;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("DoubleVideoCtrlUI");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(paramLong);
      o(true);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365981);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
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
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373820));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373821));
    i(paramLong, 16777215);
    e();
  }
  
  void d(long paramLong, View paramView)
  {
    boolean bool = c();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean + "], localMute[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean + "], seq[" + paramLong + "], canClick[" + bool + "]");
    if ((a(paramLong, "android.permission.RECORD_AUDIO", paramView)) && (bool)) {
      a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString);
    }
    super.D(paramLong);
  }
  
  void d(long paramLong, boolean paramBoolean)
  {
    boolean bool = SessionMgr.a().a().A();
    int i;
    if (paramBoolean) {
      if (bool) {
        i = 4;
      }
    }
    for (;;)
    {
      e(paramLong, i);
      return;
      i = 2;
      continue;
      if (bool) {
        i = 3;
      } else {
        i = 1;
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().x)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_z_of_type_Boolean = this.jdField_h_of_type_Boolean;
      if (this.jdField_h_of_type_Boolean)
      {
        e(0);
        w();
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  void e()
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374081, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374085, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374079, 8);
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
    long l = this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.jdField_d_of_type_JavaLangString);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onConnected, roomid[" + l + "], mNeedRemoveAudioCallback[" + this.jdField_d_of_type_Boolean + "], seq[" + paramLong + "]");
    super.e(paramLong);
    l(paramLong);
    if (l > 0L) {
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(l, 26, l);
    }
    String str = l + "";
    VoiceChangeDataReport.a(localSessionInfo.jdField_d_of_type_Int, str + "");
    if (localSessionInfo.jdField_h_of_type_Int != 4) {
      a_(paramLong, 2131695481);
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1038);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1049);
    label294:
    label316:
    int i;
    int j;
    label368:
    SensorHelper localSensorHelper;
    if (!localSessionInfo.jdField_e_of_type_Boolean)
    {
      if (localSessionInfo.P)
      {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!localSessionInfo.jdField_g_of_type_Boolean) {
          break label591;
        }
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (localSessionInfo.jdField_d_of_type_Int != 2) {
        break label622;
      }
      d(paramLong, true);
      a(paramLong, true);
      str = localSessionInfo.jdField_d_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
      j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
      if (i != 5) {
        break label641;
      }
      if (!localSessionInfo.ao) {
        break label630;
      }
      super.B(paramLong);
      localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (localSessionInfo.jdField_d_of_type_Int != 1) {
        break label766;
      }
    }
    label591:
    label622:
    label630:
    label766:
    for (boolean bool = true;; bool = false)
    {
      localSensorHelper.b(bool);
      i = localSessionInfo.jdField_j_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
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
      if ((localSessionInfo.jdField_n_of_type_Boolean) && (!localSessionInfo.k)) {
        a("onConnected", 1);
      }
      return;
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      break label294;
      h(true);
      break label316;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label368;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
      {
        if (localSessionInfo.ao)
        {
          super.B(paramLong);
          break label368;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label368;
      }
      if (!localSessionInfo.l())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label368;
      }
      if (j > 18)
      {
        if ((localSessionInfo.ao) && (localSessionInfo.ap))
        {
          super.B(paramLong);
          break label368;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
        break label368;
      }
      if (localSessionInfo.ao)
      {
        super.B(paramLong);
        break label368;
      }
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.a(paramLong);
      break label368;
    }
  }
  
  public void e(long paramLong, int paramInt)
  {
    if (h()) {
      return;
    }
    boolean bool2 = AVUtil.c(paramInt);
    if (this.jdField_a_of_type_Int != paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether", 4, "changeUIMode, [" + this.jdField_a_of_type_Int + "-->" + paramInt + "], isVideo[" + bool2 + "]");
      }
      this.jdField_a_of_type_Int = paramInt;
    }
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(bool2, 0, false);
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      }
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))
      {
        AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (bool2) {
          break label315;
        }
        bool1 = true;
        label173:
        localAVActivity.b(bool1);
        if (bool2) {
          break label321;
        }
        bool1 = true;
        label188:
        localAVActivity.f(bool1);
        localAVActivity.c(bool2);
      }
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
        break label327;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(8);
      }
      j(paramLong, 8);
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramInt == 2)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      a(Boolean.valueOf(bool2));
      return;
      i(-1014L, 16777215);
      break;
      label315:
      bool1 = false;
      break label173;
      label321:
      bool1 = false;
      break label188;
      label327:
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
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
  }
  
  void e(long paramLong, View paramView)
  {
    Object localObject = new ControlUIObserver.CPreEventInfo(paramView);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9001), localObject });
    }
    if (((ControlUIObserver.CPreEventInfo)localObject).jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, mBlockName[" + ((ControlUIObserver.CPreEventInfo)localObject).jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695323);
      return;
      if (a(paramLong, "android.permission.CAMERA", paramView))
      {
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        DataReport.h(this.jdField_a_of_type_ComTencentAvVideoController);
        if (localSessionInfo.jdField_d_of_type_Int == 1)
        {
          VideoViewInfo localVideoViewInfo = new VideoViewInfo();
          localObject = localSessionInfo.jdField_d_of_type_JavaLangString;
          paramView = (View)localObject;
          if (((String)localObject).startsWith("+")) {
            paramView = ((String)localObject).substring(1);
          }
          localVideoViewInfo.jdField_a_of_type_Long = CharacterUtil.a(paramView);
          localVideoViewInfo.jdField_a_of_type_Int = 1;
          paramView = new ArrayList();
          paramView.add(localVideoViewInfo);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramView });
          j(paramLong);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, open1, seq[" + paramLong + "]");
          }
          ReportController.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
          if (localSessionInfo.y) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.22(this), 500L);
          }
          if (localSessionInfo.A()) {
            AVUtil.a("0X800B637", 0, 0, "", "", "", "");
          }
        }
        else if (localSessionInfo.jdField_d_of_type_Int == 2)
        {
          if (localSessionInfo.jdField_j_of_type_Boolean)
          {
            k(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, close, seq[" + paramLong + "]");
            }
            if (localSessionInfo.A()) {
              AVUtil.a("0X800B638", 0, 0, "", "", "", "");
            }
          }
          else
          {
            j(paramLong);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Camera, open2, seq[" + paramLong + "]");
            }
            if (localSessionInfo.A()) {
              AVUtil.a("0X800B637", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
  
  public void e_(int paramInt)
  {
    a(paramInt, true);
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
    if (paramInt != localSessionInfo.jdField_S_of_type_Int) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setGlassWaitTime, WaitTime[" + localSessionInfo.jdField_S_of_type_Int + "->" + paramInt + "]");
    }
    localSessionInfo.jdField_S_of_type_Int = paramInt;
  }
  
  public void f(long paramLong)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    OperationBtnItem localOperationBtnItem = a(2131695337, paramLong);
    if ((localOperationBtnItem == null) || (localContext == null)) {}
    label97:
    label112:
    label127:
    do
    {
      return;
      Object localObject = SessionMgr.a().a();
      if (!((SessionInfo)localObject).l())
      {
        localOperationBtnItem.c(false);
        return;
      }
      boolean bool1 = QAVConfigUtils.j();
      localOperationBtnItem.c(bool1);
      if (bool1)
      {
        localObject = ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).b((SessionInfo)localObject);
        boolean bool2;
        if (localObject == null)
        {
          localObject = null;
          if ((localObject == null) || (((WTogetherRoom)localObject).a() == 0)) {
            break label230;
          }
          bool1 = true;
          if ((bool1) && (!((WTogetherRoom)localObject).e())) {
            break label235;
          }
          bool2 = true;
          if (!bool1) {
            break label241;
          }
          localOperationBtnItem.a(localContext.getResources().getString(2131695338));
          localOperationBtnItem.a(bool2);
          if (bool2) {
            break label260;
          }
        }
        for (boolean bool3 = true;; bool3 = false)
        {
          localOperationBtnItem.b(bool3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_WatchTogether, watching[" + bool1 + "], enable[" + bool2 + "]");
          return;
          localObject = ((WatchTogetherInfo)localObject).a;
          break label97;
          bool1 = false;
          break label112;
          bool2 = false;
          break label127;
          localOperationBtnItem.a(localContext.getResources().getString(2131695337));
          break label147;
        }
      }
    } while (!QLog.isColorLevel());
    label147:
    label230:
    label235:
    label241:
    QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_WatchTogether, entry close.");
    label260:
  }
  
  public void f(long paramLong, View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) < 1000L)) {}
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (paramView == null);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    l(paramLong, 2131695329);
    paramView.a(paramLong);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h())
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, str);
    }
  }
  
  protected void g(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$RecordInfo.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
      i(paramLong, 16777215);
      l(paramLong, 2131695328);
    }
  }
  
  @TargetApi(11)
  public void h()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPauseVideo, seq[" + l + "]");
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
    {
      a("onPauseVideo", 1);
      s();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onResumeVideo setRotation");
        }
        a(l, 0.0F);
      }
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a().R = 0;
    }
  }
  
  public void h(long paramLong)
  {
    int i = 2130842466;
    if (h()) {}
    label47:
    label60:
    label231:
    label237:
    label241:
    for (;;)
    {
      return;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131374079);
      int j;
      if (localSessionInfo.A()) {
        j = 0;
      }
      for (;;)
      {
        if (localImageButton == null) {
          break label241;
        }
        if (localSessionInfo.w == 0)
        {
          QavPanel.setBtnTopDrawable(localImageButton, i);
          if (j == 0) {
            break label231;
          }
        }
        for (i = 0;; i = 8)
        {
          localImageButton.setVisibility(i);
          if (j != 0) {
            break;
          }
          ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373870)).setVisibility(4);
          return;
          if ((QAVConfigUtils.e()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().k)) {
            break label237;
          }
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_Sharpness. no show. isDoubleVideoSharpnessEnable = " + QAVConfigUtils.e());
          j = 0;
          break label47;
          if (localSessionInfo.w == 1)
          {
            i = 2130842467;
            break label60;
          }
          if (localSessionInfo.w == 2)
          {
            i = 2130842469;
            break label60;
          }
          if (localSessionInfo.w != 3) {
            break label60;
          }
          i = 2130842468;
          break label60;
        }
        j = 1;
      }
    }
  }
  
  public void i()
  {
    long l = AudioHelper.b();
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onResumeVideo, SessionType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "], seq[" + l + "]");
    if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131720540));
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().y) {
        d(true);
      }
    }
    for (;;)
    {
      D(l);
      return;
      i(l, 16777215);
    }
  }
  
  public void i(long paramLong)
  {
    boolean bool2 = false;
    if (h()) {}
    OperationBtnItem localOperationBtnItem;
    do
    {
      return;
      localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695328);
      if (localOperationBtnItem != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, null, seq[" + paramLong + "]");
    return;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool1;
    if ((localSessionInfo.jdField_d_of_type_Int == 3) || (localSessionInfo.jdField_d_of_type_Int == 4) || (localSessionInfo.jdField_d_of_type_Int == 1))
    {
      bool1 = bool2;
      if (jdField_o_of_type_Boolean)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, 场景不支持, seq[" + paramLong + "]");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localOperationBtnItem.a(DoubleVideoCtrlUI.RecordInfo.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$RecordInfo));
      localOperationBtnItem.c(bool1);
      return;
      AVActivity localAVActivity = a();
      if (localAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl == null)
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, !mRecordUiCtrl, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if (!localAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.h())
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, !isEnableRecord, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if ((!localSessionInfo.jdField_j_of_type_Boolean) || (!localSessionInfo.k))
      {
        bool1 = bool2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Record, sessionInfo.localHasVideo, seq[" + localSessionInfo.jdField_j_of_type_Boolean + "][sessionInfo.remoteHasVideo=" + localSessionInfo.k + "]");
          bool1 = bool2;
        }
      }
      else if (localSessionInfo.A())
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
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean + ", seq[" + l + "]");
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
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onBeforeCloseCamera, seq[" + paramLong + "]");
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
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l())
    {
      OperationBtnItem localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695329);
      if (localOperationBtnItem != null) {
        localOperationBtnItem.c(false);
      }
      return;
    }
    super.l(paramLong);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new DoubleVideoCtrlUI.15(this));
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
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshUI, SessionType[" + localSessionInfo.jdField_d_of_type_Int + "], seq[" + l + "]");
    }
    int i = localSessionInfo.jdField_j_of_type_Int;
    String str = localSessionInfo.jdField_d_of_type_JavaLangString;
    Object localObject3 = localSessionInfo.jdField_f_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3, true, true);
    Object localObject1 = localSessionInfo.jdField_e_of_type_JavaLangString;
    if (localSessionInfo.jdField_e_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3);
      localSessionInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373820));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373821));
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372115));
      if (localSessionInfo.jdField_d_of_type_Int == 2) {
        d(l, true);
      }
    }
    else
    {
      if (localSessionInfo.jdField_d_of_type_Int != 2) {
        break label483;
      }
      d(l, true);
      label248:
      if (localSessionInfo.jdField_j_of_type_Int == 1011)
      {
        if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label500;
        }
        a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString);
        }
      }
      label282:
      if (localSessionInfo.jdField_j_of_type_Int != 25) {
        break label555;
      }
      localObject2 = localSessionInfo.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localSessionInfo.jdField_f_of_type_JavaLangString;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1);
      localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1, true, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(str);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
      }
      if ((!((String)localObject2).equals(localSessionInfo.jdField_d_of_type_JavaLangString)) || (localObject1 == null)) {
        break label520;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    for (;;)
    {
      i(l, 16777215);
      return;
      d(l, false);
      break;
      label483:
      if (localSessionInfo.jdField_d_of_type_Int != 1) {
        break label248;
      }
      b(false);
      break label248;
      label500:
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label282;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.c());
      break label282;
      label520:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        continue;
        label555:
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
      }
    }
  }
  
  void p()
  {
    ChildLockCircle localChildLockCircle = a();
    if (localChildLockCircle != null) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x)) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localChildLockCircle.a(bool);
      return;
    }
  }
  
  void q()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373791);
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).b();
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
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().x)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoCtrlUI.23(this, l), 300L);
    }
  }
  
  public void t()
  {
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onSelfAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L) {
        super.B(l);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.e()) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
            super.B(l);
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().l());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().ap);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
      super.B(l);
      return;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    super.B(l);
  }
  
  public void u()
  {
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onOppositeAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.e()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.b(l);
    super.B(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */