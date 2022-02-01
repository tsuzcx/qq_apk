package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import com.tencent.av.AVLog;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoCameraListener;
import com.tencent.av.VideoConstants.ProcessInfo;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.panorama.PanoramaSensorManager;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.business.manager.zimu.SpitZimuTask.IMouthDetector;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.compat.AVCallCompactJob;
import com.tencent.av.core.AVSoProxyImpl;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.recog.AVVoiceRecog.AVVoiceRecogCallback;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.VideoConnRateReport;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funcall.FunCallUtil;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVConfigUtils.MoreBtnTips;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.media.WatchTogetherAudioDecodeHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.view.WatchTogetherAdminControlView;
import com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.debug.qav.QavTest;
import com.tencent.mobileqq.debug.qav.QavTestUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, SpitZimuTask.IMouthDetector, AVVoiceRecog.AVVoiceRecogCallback
{
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new AVActivity.20(this);
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new AVActivity.1(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new AVActivity.22(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new AVActivity.MyVideoObserver(this);
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new AVActivity.2(this);
  CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  private AVCallCompactJob jdField_a_of_type_ComTencentAvCompatAVCallCompactJob = new AVCallCompactJob();
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = null;
  private AVActivity.AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
  AVActivity.VideoOrientationEventListener jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener = null;
  ChildGuideUi jdField_a_of_type_ComTencentAvUiChildGuideUi;
  private ConfigInfoTips jdField_a_of_type_ComTencentAvUiConfigInfoTips = null;
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver = new AVActivity.MyControlUIObserver(this);
  public QavDoubleVideoSharpnessMangaer a;
  public QavVideoRecordUICtrl a;
  public ScreenRecordHelper a;
  public VideoControlUI a;
  public VideoLayerUI a;
  VoiceChangeChooseDialog jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog = null;
  public VideoChatRoomUIContoller a;
  public EffectFilterPanel a;
  QavRecordButtonView jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
  public GuideHelper a;
  private QAVConfigUtils.MoreBtnTips jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  private WatchTogetherUIProxy jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  public RedTouch a;
  VipFullScreenVideoView jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView;
  VipFunCallMediaListener jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener = new AVActivity.11(this);
  public Integer a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  private WatchTogetherUIProxy jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
  public Integer b;
  Runnable jdField_b_of_type_JavaLangRunnable = new AVActivity.3(this);
  final String jdField_b_of_type_JavaLangString = "AVActivity_" + AudioHelper.b();
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int = 0;
  public Integer c;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = -1;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString = null;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString = null;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int = 0;
  String jdField_g_of_type_JavaLangString = null;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  String jdField_h_of_type_JavaLangString = null;
  boolean jdField_h_of_type_Boolean = false;
  String i;
  public boolean i;
  String jdField_j_of_type_JavaLangString = null;
  boolean jdField_j_of_type_Boolean = true;
  String jdField_k_of_type_JavaLangString = null;
  boolean jdField_k_of_type_Boolean = false;
  String jdField_l_of_type_JavaLangString = null;
  boolean jdField_l_of_type_Boolean = false;
  String jdField_m_of_type_JavaLangString = null;
  boolean jdField_m_of_type_Boolean = false;
  private boolean n = false;
  private boolean o = false;
  
  public AVActivity()
  {
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = null;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
    this.mIsShadow = false;
  }
  
  private String a(Intent paramIntent)
  {
    int i2 = paramIntent.getIntExtra("uinType", -1);
    int i3 = UITools.b(i2);
    int i1 = i3;
    if (i3 == 0) {
      i1 = 3;
    }
    String str1;
    if (i2 == 1006)
    {
      str1 = paramIntent.getStringExtra("toMobile");
      if (!paramIntent.getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label285;
      }
      str1 = paramIntent.getStringExtra("GroupId");
      i2 = 0;
      i1 = 100;
    }
    label285:
    for (;;)
    {
      String str3 = paramIntent.getStringExtra("Fromwhere");
      i3 = i1;
      String str2 = str1;
      if (i1 == 3)
      {
        i3 = i1;
        str2 = str1;
        if (TextUtils.equals("AIOShareScreen", str3))
        {
          str2 = paramIntent.getStringExtra("uin");
          i3 = 100;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "genSessionIdFromIntent, [" + i2 + "," + i3 + "," + str2 + "]");
      }
      if ((i2 == -1) || (TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "genSessionIdFromIntent error: uinType " + i2 + ", relationId " + str2);
        }
        return null;
        if ((i1 == 1) || (i1 == 2))
        {
          str1 = paramIntent.getStringExtra("GroupId");
          break;
        }
        str1 = paramIntent.getStringExtra("uin");
        break;
      }
      return SessionMgr.a(i3, str2, new int[0]);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent.setExtrasClassLoader(ChooseFileInfo.class.getClassLoader());
      paramIntent = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
    } while ((paramIntent == null) || (this.jdField_d_of_type_Int != 0));
    ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, this.jdField_c_of_type_JavaLangString, paramIntent, null);
  }
  
  public static void a(Window paramWindow)
  {
    try
    {
      paramWindow.addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      return;
    }
    catch (IllegalAccessException paramWindow)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("set_FLAG_NEEDS_MENU_KEY", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramWindow);
      return;
    }
    catch (NoSuchFieldException paramWindow) {}
  }
  
  static boolean a(Activity paramActivity)
  {
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.b(paramActivity);
      int i2 = ImmersiveUtils.getStatusBarHeight(paramActivity);
      QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + i1 + "], statusBarHeight[" + i2 + "]");
      if (LiuHaiUtils.enableNotch(paramActivity))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, enableNotch");
        }
        return true;
      }
      if (("" + Build.MANUFACTURER).equalsIgnoreCase("Lenovo")) {
        VideoControlUI.n = true;
      }
    }
    return false;
  }
  
  private boolean a(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    boolean bool = false;
    int i1 = ImmersiveUtils.isSupporImmersive();
    if (i1 == 1) {
      if (paramBoolean)
      {
        int i2 = paramWindow.getDecorView().getSystemUiVisibility();
        paramWindow.getDecorView().setSystemUiVisibility(i2 | 0x100 | 0x400);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramWindow.addFlags(-2147483648);
          paramWindow.clearFlags(67108864);
          paramWindow.setStatusBarColor(0);
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(ImmersiveUtils.TAG, 1, "setImmersive, result[" + paramBoolean + "], isSupporImmersive[" + i1 + "], SystemUiVisibility[0x" + Integer.toHexString(paramWindow.getDecorView().getSystemUiVisibility()) + "], flags[0x" + Integer.toHexString(paramWindow.getAttributes().flags) + "]");
      }
      return paramBoolean;
      if (Build.VERSION.SDK_INT < 19) {
        break;
      }
      paramWindow.addFlags(67108864);
      break;
      paramWindow.clearFlags(67108864);
      break;
      paramBoolean = bool;
      if (AudioHelper.a(25) == 1)
      {
        AudioHelper.a("使用了index_disable_immersive");
        paramBoolean = bool;
      }
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = SessionMgr.a().a();
    if ((localObject == null) || (!((SessionInfo)localObject).A())) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while ((localObject == null) || (((WatchTogetherMediaPlayCtrl)localObject).a() == paramInt));
    ((WatchTogetherMediaPlayCtrl)localObject).a(paramInt);
    if (((WatchTogetherMediaPlayCtrl)localObject).j()) {
      ((WatchTogetherMediaPlayCtrl)localObject).a(false);
    }
    m();
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (AudioHelper.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  private void h(long paramLong)
  {
    boolean bool2 = true;
    if (isDestroyed()) {}
    label10:
    label324:
    do
    {
      do
      {
        Object localObject;
        do
        {
          int i1;
          do
          {
            do
            {
              do
              {
                do
                {
                  break label10;
                  break label10;
                  break label10;
                  break label10;
                  break label10;
                  do
                  {
                    return;
                  } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()));
                  localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
                  i1 = ((SessionInfo)localObject).jdField_d_of_type_Int;
                  bool1 = ((SessionInfo)localObject).A();
                  if (QLog.isDevelopLevel()) {
                    QLog.w(this.jdField_b_of_type_JavaLangString, 4, "switchToolbar, sessionType[" + i1 + "], isInviting[" + ((SessionInfo)localObject).h() + "], isToolBarDisplay[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i() + "|" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean + "], watch[" + bool1 + "], curMenu[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b() + "], seq[" + paramLong + "]");
                  }
                  if (!bool1) {
                    break label324;
                  }
                  if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_p_of_type_Int != 2)) {
                    break;
                  }
                  if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {
                    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("switchToolbar");
                  }
                  i1 = 1;
                  bool1 = false;
                  localObject = VideoController.a().a();
                } while (localObject == null);
                localObject = a(((WatchTogetherMediaPlayCtrl)localObject).i());
              } while (i1 != 0);
              if (!bool1) {}
              for (boolean bool1 = bool2;; bool1 = false)
              {
                ((WatchTogetherUIProxy)localObject).setImmersiveStatus(bool1);
                return;
                this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
                boolean bool3 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean;
                if (!bool3) {}
                for (bool1 = true;; bool1 = false)
                {
                  ((SessionInfo)localObject).c(bool1);
                  i1 = 0;
                  bool1 = bool3;
                  break;
                }
              }
              if ((i1 != 1) && (i1 != 3)) {
                break;
              }
              if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))) {
                this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
              }
            } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()));
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
            return;
            if (!((SessionInfo)localObject).h()) {
              break;
            }
          } while ((i1 != 2) || ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))));
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
          return;
        } while ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a()));
        if ((!((SessionInfo)localObject).jdField_B_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695738);
      return;
      if (!a())
      {
        if ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)))) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, false);
        }
        b(paramLong, "switchToolbar", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
    b(paramLong, "SwitchToolbar2", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
  }
  
  private void i(long paramLong)
  {
    if (this.o) {}
    do
    {
      return;
      this.o = true;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130842125);
    }
  }
  
  private void l()
  {
    View localView = findViewById(2131374081);
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) && (!isDestroyed())) {
      runOnUiThread(new AVActivity.10(this, localView));
    }
  }
  
  private void m()
  {
    if ((this.jdField_h_of_type_Int == 0) || (this.jdField_h_of_type_Int == 180))
    {
      setRequestedOrientation(1);
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
      return;
    }
    if (this.jdField_h_of_type_Int == 90)
    {
      setRequestedOrientation(8);
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE]");
      return;
    }
    setRequestedOrientation(0);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    do
    {
      return;
      View localView = super.findViewById(2131363187);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, localView);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(a());
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new AVActivity.21(this));
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick, id[" + LayoutDef.a(paramView.getId()) + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_j_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((paramView.getId() == 2131373773) || (paramView.getId() == 2131373774)) {
        b(true);
      }
      if ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) {
        this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a(paramView);
      }
      while ((paramView.getId() == 2131374081) && (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null))
      {
        AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, 1);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.D(l1);
          DataReport.c(paramView.getId());
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1, paramView);
          e(l1);
        }
      }
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    PopupMenu localPopupMenu = new PopupMenu(this, paramView);
    RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(localPopupMenu);
    if (AudioHelper.d()) {}
    try
    {
      QavTestUtil.addMenuInVideoView(paramView, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localPopupMenu);
      localPopupMenu.show();
      return;
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, "addMenuInVideoView", paramView);
      }
    }
  }
  
  int a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.a(getApplicationContext());
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("showRecordTip" + String.valueOf(str), 0);
  }
  
  View a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips == null) || (!this.n))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, 没有tips需要显示或者已经显示过, seq[" + paramLong + "]");
      }
      return null;
    }
    if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, 工具栏没显示, seq[" + paramLong + "]");
      }
      return null;
    }
    Object localObject = findViewById(2131374081);
    if (localObject == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, !MORE, seq[" + paramLong + "]");
      }
      return null;
    }
    if (((View)localObject).getVisibility() != 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, more按钮没显示出来, seq[" + paramLong + "]");
      }
      return null;
    }
    ImageView localImageView = (ImageView)findViewById(2131373952);
    if (localImageView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, !qav_more_tips, seq[" + paramLong + "]");
      }
      return null;
    }
    if (localImageView.getVisibility() == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, qav_more_tips已经在显示中了, seq[" + paramLong + "]");
      }
      return null;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    int i1 = AIOUtils.a(10.0F, getResources());
    int i2 = (int)(25 * getResources().getDisplayMetrics().density / 1.5D);
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationInWindow(arrayOfInt);
    int i3 = ((View)localObject).getWidth();
    int i4 = ((View)localObject).getHeight();
    int i5 = arrayOfInt[0];
    i5 = i3 / 2 + i5;
    int i6 = arrayOfInt[1] + i4 + i1;
    int i7 = (int)(this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth() / 1.5D);
    int i8 = (int)(this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight() / 1.5D);
    int i9 = i5 - i7 + i2;
    localObject = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = i6;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i9;
    ((RelativeLayout.LayoutParams)localObject).width = i7;
    ((RelativeLayout.LayoutParams)localObject).height = i8;
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. offset[" + i1 + "], left_more[" + arrayOfInt[0] + "], top_more[" + arrayOfInt[1] + "], width_more[" + i3 + "], height_more[" + i4 + "], width_tips[" + i7 + "], height_tips[" + i8 + "], arrow[" + i2 + "], dockLeft[" + i5 + "], dockTop[" + i6 + "], tipsTop[" + i6 + "], tipsLeft[" + i9 + "], seq[" + paramLong + "]");
    return localImageView;
  }
  
  public VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public SmallScreenActivityPlugin a()
  {
    return this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  }
  
  public AVActivity.AnimationTrigger a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger == null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = new AVActivity.AnimationTrigger(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
  }
  
  @TargetApi(21)
  @Nullable
  public ScreenRecordHelper a()
  {
    if ((Build.VERSION.SDK_INT < 21) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return null;
    }
    this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper.a(this);
    return this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
  }
  
  public WatchTogetherUIProxy a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy == null)
      {
        ((ViewStub)findViewById(2131374102)).inflate();
        this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy = ((WatchTogetherAdminControlView)findViewById(2131374101));
      }
      return this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
    }
    if (this.jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy == null)
    {
      ((ViewStub)findViewById(2131374104)).inflate();
      this.jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy = ((WatchTogetherOrdinaryControlView)findViewById(2131374103));
    }
    return this.jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener == null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener = new AVActivity.VideoOrientationEventListener(this, super.getApplicationContext(), 2);
    }
  }
  
  void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a() != null)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("changeVideoLayoutMode, mode[").append(paramInt).append("], ctrlUI[").append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI).append("], curMode[");
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)
      {
        localObject = "null";
        QLog.i("WTogether", 4, localObject + "]");
      }
    }
    else
    {
      if (!isDestroyed()) {
        break label102;
      }
    }
    label102:
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) || (paramInt == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f()))
    {
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f());
      break;
    }
    long l1 = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramInt);
    if (((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && ((paramInt == 2) || (paramInt == 1)))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(l1);
      ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), c());
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.D(l1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l1, 16777215);
    if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c());
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c());
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().I)) {
      QavRecordReporter.a("0X8008ABA");
    }
    if ((this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(paramInt);
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        if (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(paramLong)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, false);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
      }
      if (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(paramLong))
      {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "requestCloseCamera, 摄像头本来没打开, seq[" + paramLong + "]");
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, true);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().r()) {}
      while (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
        return;
        a(1, false);
      }
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (isDestroyed()) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
      return;
    }
    int i5 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
    int i6 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
    {
      localObject = findViewById(2131374077);
      if ((localObject == null) || (!(((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        break label522;
      }
    }
    label516:
    label522:
    for (int i1 = ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin;; i1 = 0)
    {
      int i2 = 0;
      int i3 = 0;
      int i7 = i5 + i3;
      int i4;
      label121:
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null)
      {
        i4 = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
        if (QLog.isColorLevel()) {
          QLog.w("ChatRoomUtil", 1, "calcControlUIOffset, topOffset[" + i7 + "], topToolbarHeight[" + i5 + "], topToolbarTop[" + i1 + "], bottomToolbarHeight[" + i6 + "], chatRoomInputPanelHeight[" + i4 + "], recordBarHeight[" + i2 + "], systemBarHeight[" + i3 + "], from[" + paramInt + "], seq[" + paramLong + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          if ((c() != 1) || (i4 <= i6)) {
            break label453;
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean)
          {
            bool = true;
            label288:
            ((VideoLayerUI)localObject).a(paramLong, i7, i4, bool);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.R();
          if ((this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller == null) || (paramInt == 1)) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.b(i6);
          return;
          if ((i5 != 0) || (!LiuHaiUtils.b())) {
            break label516;
          }
        }
      }
      for (i1 = LiuHaiUtils.b(this);; i1 = 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((((SessionInfo)localObject).x()) && ((((SessionInfo)localObject).jdField_B_of_type_Boolean) || (((SessionInfo)localObject).C)) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (!this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d()))
        {
          i2 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (i2 == 0) {}
          for (i3 = -1;; i3 = i2)
          {
            ((VideoLayerUI)localObject).k = i3;
            i4 = 0;
            i3 = i1;
            i1 = i4;
            break;
          }
          bool = false;
          break label288;
          label453:
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean) {}
          for (bool = true;; bool = false)
          {
            ((VideoLayerUI)localObject).a(paramLong, i7, i6, bool);
            break;
          }
          i4 = 0;
          break label121;
        }
        i2 = 0;
        i4 = 0;
        i3 = i1;
        i1 = i4;
        break;
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 2131374081) && (paramInt3 == 0))
    {
      a(paramLong, 2000L);
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this, 1, 0);
    }
  }
  
  void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {}
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramInt);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramInt, false);
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramInt);
    this.jdField_h_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(paramInt);
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_h_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().C)) {
      g(paramLong);
    }
    c(paramInt);
  }
  
  void a(long paramLong1, long paramLong2)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. tryShow_qav_more_tips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips + ", delayMillis = " + paramLong2);
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramLong2);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "enterChatWin, uin[" + paramString1 + "], type[" + paramInt + "], seq[" + paramLong + "]");
    this.jdField_e_of_type_Boolean = false;
    finish();
    paramInt = 2130772163;
    paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramString1 != null) {
      paramInt = SmallScreenUtils.a(paramString1.L);
    }
    overridePendingTransition(0, paramInt);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) {
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (int i1 = 0;; i1 = 8)
    {
      int i2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility();
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(i1);
      if ((i2 != i1) && (AudioHelper.e())) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "ShowRecordBtn, from[" + paramString + "], bShown[" + paramBoolean + "], seq[" + paramLong + "]");
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().G))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().G = false;
        paramBoolean = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.i();
        boolean bool = QavVideoRecordUICtrl.f();
        if ((!paramBoolean) || (!bool)) {
          break;
        }
        QavRecordReporter.a("0X8008AB2");
      }
      return;
    }
    QavRecordReporter.a("0X8008AB1");
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo onCreateUI, SessionType[" + ((SessionInfo)localObject1).jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131373800));
    }
    this.jdField_a_of_type_JavaLangRunnable = new AVActivity.5(this);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvVideoCameraListener);
    }
    Object localObject2 = super.findViewById(2131363187).findViewById(2131363184);
    try
    {
      ((View)localObject2).setBackgroundResource(2130842285);
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) {
        n();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c();
      }
      c(false);
      if (this.jdField_b_of_type_Int == 0)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onCreateUI, SessionType[" + this.jdField_b_of_type_Int + "], isDoubleMeeting[" + this.jdField_g_of_type_Boolean + "]");
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_b_of_type_Int = 1;
        }
      }
      if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 4)) {
        ThreadManager.excute(new AVActivity.6(this), 16, null, true);
      }
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        int i2 = this.jdField_b_of_type_Int;
        int i1 = i2;
        if (this.jdField_b_of_type_Int == 3)
        {
          i1 = i2;
          if (getIntent() != null)
          {
            i1 = i2;
            if (getIntent().getBooleanExtra("isVideo", false)) {
              i1 = 4;
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips = QAVConfigUtils.a(i1);
        if ((this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips.jdField_a_of_type_JavaLangString)))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          this.n = false;
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new AVActivity.7(this));
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          if (1 == this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus())
          {
            paramBoolean = true;
            this.n = paramBoolean;
            ReportController.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips.jdField_a_of_type_Int, "", "", "", "");
            QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. getDrawableAndToDownloadImage. mMoreBtnTipsImageDownloaded = " + this.n);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
            if ((this.jdField_d_of_type_Int == 9500) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
            {
              localObject2 = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
              ((DoubleVideoCtrlUI)localObject2).a(2131373782, this.jdField_a_of_type_ComTencentAvVideoController.n, 2130842183);
              if (!this.jdField_a_of_type_ComTencentAvVideoController.p) {
                ((DoubleVideoCtrlUI)localObject2).a.a(true, 0, false);
              }
            }
          }
          if ((((SessionInfo)localObject1).jdField_g_of_type_Int != 4) && (((SessionInfo)localObject1).x()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) && (!isDestroyed()))
          {
            i1 = FunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString, true, true);
            if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
            }
            i2 = VipFunCallManager.a();
            localObject1 = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
            if (localObject1 != null)
            {
              localObject2 = new File((String)localObject1);
              if ((localObject2 == null) || (!((File)localObject2).exists())) {
                break label1343;
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.8(this, (String)localObject1, i2, i1), 1000L);
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131376780));
          a(paramLong, "onCreateUI", false);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l(0);
          }
          localObject1 = (RelativeLayout)findViewById(2131381482);
          if ((localObject1 != null) && (QavVideoRecordUICtrl.f()))
          {
            this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = new QavVideoRecordUICtrl(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
            this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c(1);
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl);
            }
          }
          l();
          AVVoiceRecog.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
          localObject1 = new AVActivity.9(this);
          new Handler().post((Runnable)localObject1);
          return;
        }
        break;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreateUI OutOfMemoryError", localOutOfMemoryError);
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
        {
          if (!this.jdField_g_of_type_Boolean) {
            break label1046;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          this.jdField_b_of_type_Int = ((SessionInfo)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label1046:
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        }
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          this.jdField_b_of_type_Int = ((SessionInfo)localObject1).jdField_d_of_type_Int;
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          continue;
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
          {
            if (!this.jdField_g_of_type_Boolean) {
              break label1221;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            this.jdField_b_of_type_Int = ((SessionInfo)localObject1).jdField_d_of_type_Int;
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            break;
            label1221:
            if (((SessionInfo)localObject1).D == 1)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
            else if (((SessionInfo)localObject1).D == 10)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnCreateUI --> Not Set MultiAVType");
              }
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
          }
          paramBoolean = false;
          continue;
          label1343:
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "funcall --> !file.exists() + path:" + (String)localObject1);
        }
      }
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.printColorLog(this.jdField_b_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    EffectFaceManager localEffectFaceManager = (EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
    FaceItem localFaceItem = localEffectFaceManager.a(paramString);
    if (localFaceItem != null)
    {
      long l1 = AudioHelper.b();
      if ((localFaceItem.isUsable()) || (TextUtils.isEmpty(localFaceItem.getResurl()))) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete, recogResult[" + paramString + "], isResReady[" + bool + "], seq[" + l1 + "]");
        if (!bool) {
          break;
        }
        new ControlUIObserver.RequestPlayMagicFace(l1, localFaceItem.getId(), true, 2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        VoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
        ReportController.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", localFaceItem.getId());
        return;
      }
      localEffectFaceManager.a(l1, localFaceItem);
      return;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete. recogResult = " + paramString + ", paly voice sticker falied. voiceStickerItem == null.");
  }
  
  void a(String paramString, long paramLong)
  {
    View localView = findViewById(2131373952);
    if (localView == null) {}
    do
    {
      do
      {
        return;
      } while (localView.getVisibility() != 0);
      localView.setVisibility(4);
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. hide_qav_more_tips. from[" + paramString + "], seq[" + paramLong + "]");
    } while (this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips == null);
    QAVConfigUtils.a(this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.n = false;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateDoubleMeeting, from[" + paramString + "], [" + this.jdField_g_of_type_Boolean + "-->" + paramBoolean);
    }
    if (this.jdField_g_of_type_Boolean != paramBoolean) {
      this.jdField_g_of_type_Boolean = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RedTouch localRedTouch;
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      localRedTouch = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localRedTouch.setVisibility(i1);
      return;
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {}
    while (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(4)) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener.enable();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      c();
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a()))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
            int i1 = 0;
            if (i1 < localArrayList.size())
            {
              VideoViewInfo localVideoViewInfo = (VideoViewInfo)localArrayList.get(i1);
              String str = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
              int i2 = localVideoViewInfo.jdField_a_of_type_Int;
              if ((localVideoViewInfo.jdField_b_of_type_Long == 5L) || (localVideoViewInfo.jdField_b_of_type_Long == 14L)) {}
              for (boolean bool = true;; bool = false)
              {
                if (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, i2, false, false, bool);
                }
                i1 += 1;
                break;
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, false);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.x();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.n(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
        this.jdField_a_of_type_ComTencentAvUiChildGuideUi.d();
      }
      f();
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ComTencentAvVideoController.f(false);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(paramLong, this.jdField_e_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller == null);
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
  }
  
  void b(long paramLong, String paramString, boolean paramBoolean)
  {
    int i2 = 1;
    int i1;
    if (QLog.isColorLevel())
    {
      i1 = -1;
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null)
      {
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) {
          i1 = 1;
        }
      }
      else {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "tryShowRecordBtn[" + paramString + "], bShown[" + paramBoolean + "], visibility[" + i1 + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((!QavVideoRecordUICtrl.k()) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (!paramString.A())) {
        break label161;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(8);
      }
    }
    label161:
    do
    {
      do
      {
        return;
        i1 = 0;
        break;
        int i3 = paramString.jdField_d_of_type_Int;
        i1 = i2;
        if (i3 != 1)
        {
          if (i3 != 2) {
            break label264;
          }
          i1 = i2;
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if ((i1 != 0) && (paramString.C))
            {
              this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(this.jdField_h_of_type_Int);
              this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
            }
            if (i1 == 0)
            {
              if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 0)) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
              a(paramLong, "tryShowRecordBtn.1", false);
              return;
              i1 = 0;
              continue;
            }
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
            paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(272);
            paramString.obj = Long.valueOf(paramLong);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 50L);
            return;
          }
        }
      } while (i1 == 0);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().C)
      {
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(0);
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.k();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
      a(paramLong, "tryShowRecordBtn.2", false);
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    label264:
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l(0);
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i())) {
      return;
    }
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onNeedChangeDoubleScreenMode, id[" + paramString + "], seq[" + l1 + "], hasChangeDoubleScreen[" + this.jdField_a_of_type_ComTencentAvVideoController.a().U + "]");
    getResources();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().U)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      a(2, false);
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1043);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new AVActivity.19(this, paramString, l1);
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044, null, this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131363187), paramBoolean);
  }
  
  boolean b()
  {
    if (isDestroyed()) {}
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()));
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))) {
        return true;
      }
    } while ((!a()) && (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i()));
    return true;
  }
  
  public int c()
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      i1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f();
    }
    return i1;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener.disable();
    }
  }
  
  void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 2, "processExtraData, seq[" + paramLong + "]");
    }
    Intent localIntent = super.getIntent();
    if (localIntent == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processExtraData-->can not get intent");
      return;
    }
    AudioHelper.a("AVActivity.processExtraData", localIntent.getExtras());
    int i4 = localIntent.getIntExtra("sessionType", 0);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2 = localSessionInfo.jdField_d_of_type_Int;
    Object localObject1 = localIntent.getStringExtra("Fromwhere");
    boolean bool = localIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    a("processExtraData", bool);
    if ("AVNotification".equals(localObject1))
    {
      if (((localSessionInfo.jdField_g_of_type_Int == 2) || (localSessionInfo.jdField_g_of_type_Int == 13)) && (i4 != 1) && (i4 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (localSessionInfo.J) {
          break label390;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localSessionInfo.jdField_d_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.jdField_d_of_type_JavaLangString, 230);
        this.jdField_a_of_type_ComTencentAvVideoController.b(230);
      }
      if (localSessionInfo.jdField_j_of_type_Int == 1)
      {
        if (localSessionInfo.D != 10) {
          break label428;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label390:
    long l1;
    for (;;)
    {
      if (bool) {
        ReportController.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (i4 != 0) {
        break label464;
      }
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(localSessionInfo.jdField_d_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
      break;
      label428:
      ReportController.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
    }
    label464:
    String str1 = null;
    if ((i4 == 1) || (i4 == 2))
    {
      str1 = localIntent.getStringExtra("uin");
      label489:
      if (!"AVNotification".equals(localObject1)) {
        break label2382;
      }
      if ((i4 != 1) && (i4 != 2)) {
        break label639;
      }
      str1 = localSessionInfo.jdField_d_of_type_JavaLangString;
    }
    label1538:
    label1805:
    label1817:
    label2379:
    label2382:
    for (;;)
    {
      int i1;
      int i3;
      int i5;
      if (str1 == null)
      {
        AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
        finish();
        return;
        if ((i4 != 3) && (i4 != 4)) {
          break label489;
        }
        str1 = localIntent.getStringExtra("GroupId");
        i1 = localIntent.getIntExtra("MeetingConfID", 0);
        i3 = localIntent.getIntExtra("ConfAppID", 0);
        i5 = localIntent.getIntExtra("MeetingStasks", -1);
        localSessionInfo.O = i1;
        localSessionInfo.P = i3;
        localSessionInfo.Q = i5;
        break label489;
        label639:
        if ((i4 != 3) && (i4 != 4)) {
          break label2382;
        }
        if (bool)
        {
          str1 = localSessionInfo.jdField_d_of_type_JavaLangString;
          continue;
        }
        str1 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      Object localObject2;
      if ((i2 == 1) || (i2 == 2))
      {
        localObject2 = localSessionInfo.jdField_d_of_type_JavaLangString;
        i1 = UITools.b(localSessionInfo.jdField_j_of_type_Int);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
          ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
          finish();
        }
      }
      else if ((i2 == 3) || (i2 == 4))
      {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        i1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_b_of_type_Int;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
          finish();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "original session type is none");
        }
        i1 = 0;
        localObject1 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->IntentSessionType=" + i4 + ", OriginalSessionType=" + i2 + ", IntentUin=" + str1);
      }
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->OriginalUin=" + (String)localObject1 + ", originalRelationType=" + i1);
      }
      if ((i2 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        d(paramLong);
        label984:
        if ("AIOQAVWatchTogether".equals(this.jdField_j_of_type_JavaLangString)) {
          a(localIntent);
        }
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processExtraData, mSessionType[" + this.jdField_b_of_type_Int + "], mUinType[" + this.jdField_d_of_type_Int + "], mPeerUin[" + this.jdField_c_of_type_JavaLangString + "], mPeerName[" + this.jdField_e_of_type_JavaLangString + "], mPhoneNum[" + this.jdField_f_of_type_JavaLangString + "], mSelfNation[" + this.jdField_g_of_type_JavaLangString + "], mSelfMobile[" + this.jdField_h_of_type_JavaLangString + "], mIsReceiver[" + this.jdField_a_of_type_Boolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], mExtraUin[" + this.jdField_i_of_type_JavaLangString + "], mIsPeerNetworkWell[" + this.jdField_c_of_type_Boolean + "], mIsFriend[" + this.jdField_d_of_type_Boolean + "], mFromWhere[" + this.jdField_j_of_type_JavaLangString + "], intentUinStr[" + str1 + "], \nsession[" + localSessionInfo + "]");
        HexUtil.printHexString(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      if ((i2 == 3) || (i2 == 4) || (this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        if ((i2 != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.l())) {
          break label2379;
        }
        localObject1 = "";
      }
      for (;;)
      {
        if ((i4 == 1) || (i4 == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l()) {
            this.jdField_a_of_type_ComTencentAvVideoController.e(true);
          }
          for (;;)
          {
            d(paramLong);
            str1 = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            if (SessionMgr.a().a(str1)) {
              break;
            }
            localObject1 = SessionMgr.a().a(str1, false);
            ((SessionInfo)localObject1).jdField_e_of_type_Boolean = false;
            ((SessionInfo)localObject1).a("processExtraData", 0);
            ((SessionInfo)localObject1).ai = false;
            if (!str1.equals(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_JavaLangString = str1;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "mutivideo to doublevideo bug fix call");
            return;
            this.jdField_a_of_type_ComTencentAvVideoController.a(i1, Long.valueOf((String)localObject1).longValue(), 97);
          }
        }
        if ((i4 != 3) && (i4 != 4)) {
          break label984;
        }
        l1 = Long.valueOf(str1).longValue();
        i3 = 0;
        i5 = localIntent.getIntExtra("MultiAVType", 0);
        localSessionInfo.aw = localIntent.getBooleanExtra("disableInvite", false);
        i2 = i3;
        if (localSessionInfo.D != 0)
        {
          i2 = i3;
          if (i5 != localSessionInfo.D)
          {
            i2 = i3;
            if (i5 != 0) {
              i2 = 1;
            }
          }
        }
        localSessionInfo.a(i5);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.e(true);
            if (i2 != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 99);
              localSessionInfo.a(i5);
              localSessionInfo.a(paramLong, "processExtraData.1", 3);
            }
            localSessionInfo.c("processExtraData.1", localIntent.getIntExtra("Type", -1));
            localSessionInfo.jdField_g_of_type_Long = l1;
            this.jdField_d_of_type_JavaLangString = str1;
            if (str1.compareTo((String)localObject1) != 0) {
              break label1817;
            }
            if (i2 == 0) {
              break label1805;
            }
            this.jdField_b_of_type_Int = i4;
            i1 = localIntent.getIntExtra("uinType", -1);
            localSessionInfo.jdField_j_of_type_Int = i1;
            this.jdField_d_of_type_Int = i1;
            this.jdField_i_of_type_JavaLangString = localSessionInfo.jdField_f_of_type_JavaLangString;
            if (localSessionInfo.E == -1) {
              localSessionInfo.c("processExtraData.2", 0);
            }
            this.jdField_c_of_type_Boolean = localSessionInfo.r;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData multiAVType: " + localSessionInfo.D);
            }
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label1901;
          }
          this.jdField_d_of_type_Int = localSessionInfo.jdField_j_of_type_Int;
          this.jdField_i_of_type_JavaLangString = localSessionInfo.jdField_f_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = localSessionInfo.r;
          break;
          if ((str1.compareTo((String)localObject1) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)) {
            break label1538;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 98);
          localSessionInfo.a(i5);
          break label1538;
          this.jdField_b_of_type_Int = localSessionInfo.jdField_d_of_type_Int;
          continue;
          localSessionInfo.a(paramLong, "processExtraData.2", i4);
          localSessionInfo.jdField_j_of_type_Int = localIntent.getIntExtra("uinType", -1);
          if ((localSessionInfo.E == 0) || (localSessionInfo.E == 1)) {
            localSessionInfo.jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
          }
          this.jdField_b_of_type_Int = i4;
          continue;
          localSessionInfo.jdField_d_of_type_JavaLangString = str1;
          this.jdField_b_of_type_Int = i4;
          this.jdField_c_of_type_JavaLangString = str1;
        }
        label1901:
        break label984;
        if (((i2 != 1) && (i2 != 2)) || ((i4 != 1) && (i4 != 2))) {
          break label984;
        }
        i1 = localIntent.getIntExtra("uinType", -1);
        if ((i1 != -1) && (i1 != localSessionInfo.jdField_j_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { localSessionInfo.D });
          this.jdField_a_of_type_ComTencentAvVideoController.b(203);
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          localObject1 = localSessionInfo.jdField_d_of_type_JavaLangString;
          localObject2 = SessionMgr.a(3, (String)localObject1, new int[0]);
          Object localObject3 = SessionMgr.a().c((String)localObject2);
          if (localObject3 == null)
          {
            AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          String str2 = ((SessionInfo)localObject3).jdField_f_of_type_JavaLangString;
          i1 = localSessionInfo.jdField_j_of_type_Int;
          localObject3 = ((SessionInfo)localObject3).jdField_s_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 231);
          this.jdField_a_of_type_ComTencentAvVideoController.b(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject1, str2, 0, (String)localObject3, false, true);
          d(paramLong);
          localObject1 = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
          localObject2 = SessionMgr.a().a((String)localObject1, false);
          ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
          ((SessionInfo)localObject2).a("processExtraData", 2);
          ((SessionInfo)localObject2).ai = false;
          if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
            break label984;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          break label984;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.jdField_b_of_type_Int = localSessionInfo.jdField_d_of_type_Int;
        a("processExtraData", localSessionInfo.J);
        this.jdField_d_of_type_Int = localSessionInfo.jdField_j_of_type_Int;
        this.jdField_c_of_type_JavaLangString = localSessionInfo.jdField_d_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = localSessionInfo.jdField_e_of_type_JavaLangString;
        this.jdField_l_of_type_JavaLangString = localSessionInfo.jdField_k_of_type_JavaLangString;
        this.jdField_e_of_type_Int = localSessionInfo.A;
        this.jdField_m_of_type_JavaLangString = localSessionInfo.jdField_p_of_type_JavaLangString;
        this.jdField_f_of_type_Int = localSessionInfo.jdField_B_of_type_Int;
        this.jdField_i_of_type_JavaLangString = localSessionInfo.jdField_f_of_type_JavaLangString;
        this.jdField_f_of_type_JavaLangString = localSessionInfo.a();
        this.jdField_a_of_type_Boolean = localSessionInfo.jdField_e_of_type_Boolean;
        this.jdField_b_of_type_Boolean = localSessionInfo.S;
        this.jdField_c_of_type_Boolean = localSessionInfo.r;
        this.jdField_d_of_type_Boolean = localSessionInfo.jdField_N_of_type_Boolean;
        break label984;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) && (this.jdField_a_of_type_AndroidHardwareSensor == null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    }
  }
  
  void d(long paramLong)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean + "], isMsfRecv[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean + "], seq[" + paramLong + "], \nSessionInfo[" + localSessionInfo + "]");
    Intent localIntent;
    boolean bool1;
    String str1;
    label343:
    Object localObject;
    String str2;
    long l1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean = false;
      VideoNodeManager.a(26);
      localIntent = super.getIntent();
      AudioHelper.a(this.jdField_b_of_type_JavaLangString + "_processIntentData", localIntent.getExtras());
      this.jdField_b_of_type_Int = localIntent.getIntExtra("sessionType", 0);
      this.jdField_d_of_type_Int = localIntent.getIntExtra("uinType", -1);
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("uin");
      this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("dstClient");
      bool1 = localIntent.getBooleanExtra("isDoubleVideoMeeting", false);
      boolean bool2 = bool1;
      if ("AIOShareScreen".equals(localIntent.getStringExtra("Fromwhere")))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "processIntentData, from share screen. uinType[" + this.jdField_d_of_type_Int + "]");
        }
        if (this.jdField_d_of_type_Int == 0) {
          bool1 = true;
        }
        localSessionInfo.ad = 4;
        if (!bool1) {
          break label895;
        }
        str1 = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
        ScreenShareReportHelper.a(str1, 1, "processIntentData");
        bool2 = bool1;
      }
      a("processIntentData", bool2);
      this.jdField_m_of_type_JavaLangString = localIntent.getStringExtra("bindId");
      this.jdField_e_of_type_Int = localIntent.getIntExtra("bindType", 0);
      this.jdField_c_of_type_Int = localIntent.getIntExtra("subServiceType", 0);
      this.jdField_f_of_type_Int = localIntent.getIntExtra("extraType", 0);
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("name");
      this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("selfNation");
      this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("selfMobile");
      this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("toMobile");
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("receive", false);
      this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("isAudioMode", true);
      this.jdField_a_of_type_Long = localIntent.getLongExtra("main_timestamp", 0L);
      this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("extraUin");
      str1 = localIntent.getStringExtra("extraCode");
      localObject = localIntent.getByteArrayExtra("sig");
      this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("isPeerNetworkWell", false);
      this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("isFriend", false);
      this.jdField_j_of_type_JavaLangString = localIntent.getStringExtra("from");
      this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("shutCamera", false);
      str2 = localIntent.getStringExtra("headUrl");
      this.jdField_b_of_type_Long = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
      this.jdField_g_of_type_Int = localIntent.getIntExtra("vipType", 0);
      AVLog.printInfoLog("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.jdField_b_of_type_Int + "  mIsAudioMode = " + this.jdField_b_of_type_Boolean);
      VideoNodeManager.b(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label915;
      }
      l1 = 1L;
      label687:
      VideoNodeManager.a(13, l1);
      if ((this.jdField_d_of_type_Int == 0) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_d_of_type_Int != 1008) {
        break label951;
      }
      if (localObject == null) {
        break label923;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[localObject.length + 3];
      this.jdField_a_of_type_ArrayOfByte[0] = 1;
      this.jdField_a_of_type_ArrayOfByte[1] = 1;
      this.jdField_a_of_type_ArrayOfByte[2] = -116;
      System.arraycopy(localObject, 0, this.jdField_a_of_type_ArrayOfByte, 3, localObject.length);
    }
    for (;;)
    {
      AVReport.a().jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)) {
        break label1227;
      }
      localSessionInfo.c("processIntentData", localIntent.getIntExtra("Type", -1));
      localObject = localIntent.getStringExtra("GroupId");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label1053;
      }
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
      this.jdField_e_of_type_Boolean = true;
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
      finish();
      return;
      VideoNodeManager.a();
      break;
      label895:
      str1 = SessionMgr.a(1, localIntent.getStringExtra("GroupId"), new int[0]);
      break label343;
      label915:
      l1 = 2L;
      break label687;
      label923:
      this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      continue;
      label951:
      if (this.jdField_d_of_type_Int == 1011)
      {
        if (localObject != null)
        {
          this.jdField_a_of_type_ArrayOfByte = new byte[localObject.length + 3];
          this.jdField_a_of_type_ArrayOfByte[0] = 1;
          this.jdField_a_of_type_ArrayOfByte[1] = 1;
          this.jdField_a_of_type_ArrayOfByte[2] = -118;
          System.arraycopy(localObject, 0, this.jdField_a_of_type_ArrayOfByte, 3, localObject.length);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
        }
      }
      else {
        this.jdField_a_of_type_ArrayOfByte = ((byte[])localObject);
      }
    }
    label1053:
    int i2 = localIntent.getIntExtra("MultiAVType", 0);
    int i1 = i2;
    if (i2 == 0)
    {
      i2 = localSessionInfo.D;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    localSessionInfo.a(i1);
    if (localObject != null)
    {
      localSessionInfo.jdField_g_of_type_Long = Long.valueOf((String)localObject).longValue();
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
    }
    localSessionInfo.jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
    localSessionInfo.aw = localIntent.getBooleanExtra("disableInvite", false);
    while (this.jdField_b_of_type_Int == 0)
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1015L);
      finish();
      return;
      label1227:
      localSessionInfo.ak = localIntent.getBooleanExtra("isOtherTerminalOnChating", false);
      if (localSessionInfo.ak)
      {
        localSessionInfo.jdField_i_of_type_Long = localIntent.getLongExtra("otherTerminalChatingRoomId", 0L);
        localSessionInfo.am = localIntent.getBooleanExtra("startfromVideoEntry", false);
      }
    }
    i1 = localIntent.getIntExtra("remoteStatus", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      if ((this.jdField_d_of_type_Int != 1011) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.jdField_d_of_type_JavaLangString, 232);
        this.jdField_a_of_type_ComTencentAvVideoController.b(232);
      }
      localSessionInfo.a(paramLong, "processIntentData", this.jdField_b_of_type_Int);
      localSessionInfo.jdField_j_of_type_Int = this.jdField_d_of_type_Int;
      localSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localSessionInfo.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localSessionInfo.jdField_f_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localSessionInfo.jdField_g_of_type_JavaLangString = str1;
      localSessionInfo.a(this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      localSessionInfo.jdField_e_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localSessionInfo.S = this.jdField_b_of_type_Boolean;
      localSessionInfo.r = this.jdField_c_of_type_Boolean;
      localSessionInfo.jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      localSessionInfo.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localSessionInfo.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      localSessionInfo.jdField_p_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
      localSessionInfo.A = this.jdField_e_of_type_Int;
      localSessionInfo.jdField_B_of_type_Int = this.jdField_f_of_type_Int;
      localSessionInfo.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localSessionInfo.jdField_N_of_type_Boolean = this.jdField_d_of_type_Boolean;
      localSessionInfo.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
      localSessionInfo.n = this.jdField_f_of_type_Boolean;
      localSessionInfo.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localSessionInfo.jdField_p_of_type_Int = this.jdField_g_of_type_Int;
      if (i1 != 4) {
        break label2143;
      }
      bool1 = true;
      label1642:
      localSessionInfo.jdField_s_of_type_Boolean = bool1;
      localSessionInfo.jdField_l_of_type_Int = localIntent.getIntExtra("friendTerminal", 3);
      localSessionInfo.e("processIntentData", this.jdField_g_of_type_Boolean);
      localSessionInfo.q = this.jdField_c_of_type_Int;
      localSessionInfo.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("actId");
      localSessionInfo.jdField_m_of_type_JavaLangString = localIntent.getStringExtra("mp_ext_params");
      localSessionInfo.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_d_of_type_Int != 21)) {
        break label2179;
      }
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = str2;
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("name");
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {
        break label2149;
      }
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = true;
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!FileUtil.a(str1)) {}
    }
    for (;;)
    {
      try
      {
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(str1);
        QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.jdField_d_of_type_JavaLangString + "], bStartByTerminalSwitch[" + localSessionInfo.ak + "], terSwitchStartFromVideoEntry[" + localSessionInfo.am + "], \nSessionInfo[" + localSessionInfo + "]");
        return;
        if (this.jdField_d_of_type_Int == 1006)
        {
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
            this.jdField_e_of_type_Boolean = true;
            ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
            finish();
            return;
          }
          this.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            break;
          }
          this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
          break;
        }
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
          this.jdField_e_of_type_Boolean = true;
          ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
          finish();
          return;
        }
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break;
        }
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        break;
        label2143:
        bool1 = false;
        break label1642;
        label2149:
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        continue;
      }
      label2179:
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onZimuModeChange, inZimu[" + paramBoolean + "]");
    QavVideoRecordUICtrl localQavVideoRecordUICtrl;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.jdField_d_of_type_Boolean = paramBoolean;
      localQavVideoRecordUICtrl = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      localQavVideoRecordUICtrl.d(i1);
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
      return;
    }
  }
  
  boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      return this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i();
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      a("dispatchTouchEvent up", AudioHelper.b());
    }
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
  }
  
  void e(long paramLong)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    boolean bool;
    if (localInputMethodManager.isActive())
    {
      if ((getCurrentFocus() == null) || (getCurrentFocus().getWindowToken() == null)) {
        break label110;
      }
      bool = localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    for (int i1 = 1;; i1 = 2)
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "closeIME , InputMethodManager, result[" + bool + "], step[" + i1 + "], seq[" + paramLong + "]");
      return;
      label110:
      bool = localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    int i2 = 0;
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onRedBagGameModeChange, inGame[" + paramBoolean + "], seq[" + l1 + "]");
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.R();
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
      {
        localObject = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
        if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl == null) {
          break label219;
        }
        i1 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
        ((DoubleVideoCtrlUI)localObject).e_(i1);
        g(l1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().C) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
        if (!paramBoolean) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (int i1 = i2;; i1 = this.jdField_h_of_type_Int)
    {
      ((QavVideoRecordUICtrl)localObject).d(i1);
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
      localObject = findViewById(2131363187);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label232;
        }
        ((View)localObject).setBackgroundColor(-16777216);
      }
      return;
      i1 = 0;
      break;
    }
    label232:
    ((View)localObject).setBackgroundDrawable(null);
  }
  
  public boolean e()
  {
    switch (b())
    {
    case -1: 
    case 0: 
    case 1: 
    case 4: 
    case 5: 
    default: 
      return false;
    }
    return true;
  }
  
  void f()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
  }
  
  void f(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) || (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(paramLong))) {
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "showRotateMenu, seq[" + paramLong + "]");
    i();
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this);
    localActionSheet.getWindow().addFlags(524288);
    localActionSheet.getWindow().addFlags(2097152);
    localActionSheet.getWindow().addFlags(128);
    localActionSheet.addButton(2131720559);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new AVActivity.17(this));
    localActionSheet.setOnDismissListener(new AVActivity.18(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.setAnimationTime(150);
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_l_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    ImmersiveUtils.setStatusTextColor(false, getWindow());
  }
  
  public void finish()
  {
    int i1 = 1;
    if ((!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) && (this.jdField_j_of_type_JavaLangString.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "avideo life_finish, FromWhere[" + this.jdField_j_of_type_JavaLangString + "]");
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if ((localSessionInfo.jdField_B_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b() < 1000L) {
        break label311;
      }
    }
    for (;;)
    {
      localSessionInfo.v = i1;
      ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      if ((this.jdField_e_of_type_Boolean) && (localSessionInfo.aH) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        String str1 = String.valueOf(localSessionInfo.jdField_g_of_type_Long);
        String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, str1, localSessionInfo.jdField_f_of_type_JavaLangString);
        Intent localIntent = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
        localIntent.putExtra("uin", str1);
        localIntent.putExtra("uintype", localSessionInfo.jdField_j_of_type_Int);
        localIntent.putExtra("uinname", str2);
        startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + localSessionInfo.aH + "], session[" + localSessionInfo + "]");
      }
      super.finish();
      return;
      label311:
      i1 = 2;
    }
  }
  
  void g()
  {
    int i1 = -1;
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131363187);
    float f1 = getResources().getDimension(2131297771);
    float f2 = getResources().getDimension(2131297774);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131374105);
    if (localObject != null) {
      i1 = localViewGroup.indexOfChild((View)localObject);
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel, i1);
  }
  
  void g(long paramLong)
  {
    a(paramLong, 0);
  }
  
  public void g(boolean paramBoolean)
  {
    if (a(getWindow(), paramBoolean)) {
      this.jdField_m_of_type_Boolean = paramBoolean;
    }
  }
  
  public int getRequestedOrientation()
  {
    return super.getRequestedOrientation();
  }
  
  void h()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null)
    {
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131363187);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setVisibility(8);
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = null;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (VideoLayerUIBase.b(this.jdField_a_of_type_ComTencentAvVideoController.a())))
    {
      bool1 = true;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "quitDoubleScreenStatus, exit[" + paramBoolean + "],[needIntercept:=" + bool1 + "]");
      if (!bool1) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool1 = false;
      break;
      a(1, false);
      if ((a()) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_quitDoubleScreenStatus");
      }
      if (paramBoolean) {
        a(2);
      }
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
    FaceItem localFaceItem = (FaceItem)((EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
    if ((localFaceItem != null) && (localFaceItem.isInteract()) && (localFaceItem.isSameType("face"))) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      AVLog.printColorLog(this.jdField_b_of_type_JavaLangString, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + paramBoolean);
      if (!paramBoolean) {
        break;
      }
      a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      return;
    }
  }
  
  void i()
  {
    if ((!this.jdField_l_of_type_Boolean) || ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label31:
      this.jdField_l_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateNotificationFlag resume[" + paramBoolean + "]");
    }
    QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localQAVNotification != null)
    {
      if (paramBoolean) {
        i1 = 1;
      }
      localQAVNotification.a(i1);
    }
  }
  
  public boolean isDestroyed()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return super.isDestroyed();
    }
    return this.jdField_a_of_type_Int == 5;
  }
  
  @TargetApi(21)
  public void j() {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "life_onActivityResult, requestCode[" + paramInt1 + "], resultCode[" + paramInt2 + "]");
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 801) {
      RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
    }
    do
    {
      WTogetherMng localWTogetherMng;
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 == 802)
            {
              RedBagUtil.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
              return;
            }
            if (paramInt1 != 1002) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer == null);
          this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.f();
          return;
          if ((Build.VERSION.SDK_INT < 21) || (paramInt1 != 8080)) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper == null);
        if (paramInt2 == -1)
        {
          this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper.a(paramIntent);
          this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper.a();
          return;
        }
        this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper.b();
        return;
        if (paramInt1 != 2020) {
          break;
        }
        localWTogetherMng = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      } while (localWTogetherMng == null);
      localWTogetherMng.a(SessionMgr.a().a(), paramInt2, paramIntent);
      return;
    } while (paramInt1 != 21001);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt2, paramIntent);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_k_of_type_Boolean == true)
    {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, onSaveInstanceState, return");
      return;
    }
    ControlUIObserver.CPreEventInfo localCPreEventInfo = new ControlUIObserver.CPreEventInfo(null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7002), localCPreEventInfo });
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, BlockSystemBack[" + localCPreEventInfo.jdField_b_of_type_Boolean + "], BlockName[" + localCPreEventInfo.jdField_b_of_type_JavaLangString + "]");
    boolean bool1 = localCPreEventInfo.jdField_b_of_type_Boolean;
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        bool2 = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi == null) || (!this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) {
        break label221;
      }
      bool1 = this.jdField_a_of_type_ComTencentAvUiChildGuideUi.b();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a())
        {
          this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.c();
          bool2 = true;
        }
      }
      if (!bool2) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "2";
      return;
      label221:
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        bool1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if ((localSessionInfo == null) || (!localSessionInfo.A())) {}
    label191:
    label224:
    for (;;)
    {
      EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
      return;
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localWatchTogetherMediaPlayCtrl != null)
      {
        localWatchTogetherMediaPlayCtrl.e();
        if (QLog.isDebugVersion())
        {
          int i1 = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onConfigurationChanged, displayRotation[" + i1 + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.j(paramConfiguration.orientation);
        }
        if (paramConfiguration.orientation == 1)
        {
          if (!localSessionInfo.B()) {
            break label191;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
        }
        for (;;)
        {
          if ((paramConfiguration.orientation == 1) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())) {
            break label224;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
          break;
          if (localSessionInfo.x)
          {
            localSessionInfo.c(true);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.N();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.begin");
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "avideo life_onCreate, seq[" + l1 + "], IS_CPU_64_BIT = " + false);
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559803);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    g(true);
    a(super.getWindow());
    Object localObject1 = super.getAppRuntime();
    paramBundle = (Bundle)localObject1;
    Object localObject2;
    boolean bool;
    if (localObject1 == null)
    {
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null) {
        break label326;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, 尝试同步获取AppRuntime");
      paramBundle = paramBundle.getRuntime();
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
      if (paramBundle == null) {
        break label320;
      }
      bool = true;
      QLog.d((String)localObject1, 1, bool);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label343;
      }
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131720499) + " 0x05";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      label320:
      bool = false;
      break;
      label326:
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, BaseApplicationImpl.getApplication is null");
      paramBundle = (Bundle)localObject1;
    }
    label343:
    if ((paramBundle instanceof VideoAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramBundle); this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null; this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null)
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
      paramBundle = super.getString(2131720499) + " 0x06";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    f(true);
    paramBundle = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    localObject1 = SessionMgr.a().a();
    if (localObject1 != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate roomId = " + ((SessionInfo)localObject1).b() + ",isReceiver = " + ((SessionInfo)localObject1).jdField_e_of_type_Boolean);
      if (((SessionInfo)localObject1).jdField_e_of_type_Boolean) {
        paramBundle.a(((SessionInfo)localObject1).b(), 7, 1L);
      }
    }
    for (;;)
    {
      bool = getIntent().getBooleanExtra("isMakingAcall", false);
      if (bool) {
        paramBundle.a(-1L, 1, 1L);
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate  isMakingAcall =  " + bool);
      AVReport.a().a(getIntent(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      PanoramaSensorManager.a().a(this);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = super.getString(2131720499) + " 0x07";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.c())
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = super.getString(2131720499) + " 0x08";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.l(SDKConfigInfo.getDeviceInfo(new AVSoProxyImpl(getApplicationContext())));
    paramBundle = super.getIntent();
    int i1;
    if (paramBundle != null)
    {
      i1 = paramBundle.getIntExtra("uinType", -1);
      localObject1 = paramBundle.getStringExtra("uin");
      if (i1 == 1008)
      {
        localObject2 = SessionMgr.a(3, (String)localObject1, new int[0]);
        localObject2 = SessionMgr.a().c((String)localObject2);
        if ((localObject2 == null) || (((SessionInfo)localObject2).jdField_j_of_type_Int == -1))
        {
          localObject2 = SessionMgr.a().a();
          if ((((SessionInfo)localObject2).jdField_j_of_type_Int != -1) && ((((SessionInfo)localObject2).h()) || (((SessionInfo)localObject2).j())))
          {
            paramBundle = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            paramBundle.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            paramBundle.putExtra("uin", (String)localObject1);
            paramBundle.putExtra("uinType", i1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramBundle);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + (String)localObject1);
            finish();
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("onCreate, from[");
      if (paramBundle == null)
      {
        paramBundle = "null";
        QLog.i((String)localObject1, 2, paramBundle);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.sendGetGatewayMsg();
      a();
      d();
      this.jdField_a_of_type_JavaLangString = a(getIntent());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (a(getIntent())) || (SessionMgr.a().a(this.jdField_a_of_type_JavaLangString))) {
        break label1705;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 204, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      SessionMgr.a().a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onCreate, sessionId[" + this.jdField_a_of_type_JavaLangString + "]");
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().a()) {
        c(l1);
      }
      GraphicRenderMgr.getInstance();
      ThreadManager.post(new AVActivity.4(this), 5, null, false);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      b(0);
      a(l1, false);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        VideoConnRateReport.a().a();
      }
      if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
      {
        this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = new ConfigInfoTips(this);
        this.jdField_a_of_type_ComTencentAvUiConfigInfoTips.a();
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = SmallScreenActivityPlugin.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_N_of_type_Int;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "onCreate changeVideoLayoutMode Style=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_N_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.g());
      }
      a(i1, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      paramBundle = (ViewStub)findViewById(2131373808);
      this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer = new QavDoubleVideoSharpnessMangaer(findViewById(2131373749), paramBundle, 2131374043, this.jdField_a_of_type_ComTencentAvVideoController, this);
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller = new VideoChatRoomUIContoller(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        findViewById(2131373979).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this);
      ((ScreenShareManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(this);
      AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.end");
      return;
      paramBundle = paramBundle.getStringExtra("Fromwhere");
      break;
      label1705:
      this.jdField_a_of_type_JavaLangString = SessionMgr.a().a().jdField_c_of_type_JavaLangString;
    }
  }
  
  public void onDestroy()
  {
    this.mIsShadow = false;
    super.onDestroy();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onDestroy, mActivityState[" + this.jdField_a_of_type_Int + "->" + 5 + "], seq[" + l1 + "], isQuit[" + this.jdField_e_of_type_Boolean + "], session[" + this.jdField_a_of_type_JavaLangString + "]");
    a("onDestroy", l1);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l1);
    b(5);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
    }
    j();
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null)
    {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller = null;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.e();
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.p();
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null)
    {
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi.b();
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.stopPlayback();
        localObject = this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeAllViews();
        }
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
      }
    }
    catch (Throwable localThrowable2)
    {
      Object localObject;
      label359:
      int i1;
      break label359;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ChatRoomMng)localObject).a();
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      DoodleLogic.a().a();
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy isQuit[" + this.jdField_e_of_type_Boolean + "], session[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d("AVActivity.onDestroy", 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    if (this.jdField_a_of_type_ComTencentAvUiConfigInfoTips != null)
    {
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips.b();
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = null;
    }
    PanoramaSensorManager.a().a(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    AVVoiceRecog.a().a();
    AVVoiceRecog.a().a(null, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null)
    {
      i1 = this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a();
      if (i1 > 0) {
        ReportController.b(null, "CliOper", "", "", "0X800A345", "0X800A345", i1, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.g();
    }
    this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer = null;
    if (AudioHelper.d()) {}
    try
    {
      if (QavTest.getInstance().isQosTimerRun()) {
        QavTest.getInstance().stopQosTimer();
      }
      AVUtil.a(this);
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy", localThrowable1);
      }
    }
  }
  
  @RequiresApi(api=16)
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      bool = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramKeyEvent);
    }
    if (bool) {
      return true;
    }
    switch (paramInt)
    {
    default: 
    case 84: 
    case 24: 
    case 25: 
      for (;;)
      {
        return super.onKeyDown(paramInt, paramKeyEvent);
        return true;
        try
        {
          if ((AudioProcess.a()) && (AudioProcess.a().b()))
          {
            if (paramInt == 25) {}
            for (int i1 = -1;; i1 = 1)
            {
              Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
              int i2 = ((AudioManager)localObject).getStreamVolume(0);
              if (this.jdField_a_of_type_JavaLangInteger == null) {
                this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i2);
              }
              int i3 = ((AudioManager)localObject).getStreamMaxVolume(0);
              if (this.jdField_c_of_type_JavaLangInteger == null) {
                this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(i3);
              }
              ((AudioManager)localObject).adjustStreamVolume(0, i1, 1);
              i1 = ((AudioManager)localObject).getStreamVolume(0);
              this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(i1);
              localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
              if (localObject != null) {
                ((WatchTogetherMediaPlayCtrl)localObject).a().a(this.jdField_c_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
              }
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "adjustStreamVolume. streamType = " + 0 + ", maxVolume = " + i3 + ", oldVolume = " + i2 + ", newVolume = " + i1);
              }
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "adjustStreamVolume fail.", localException);
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null))
    {
      paramKeyEvent = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (((paramKeyEvent.jdField_d_of_type_Int == 2) && (paramKeyEvent.l())) || ((paramKeyEvent.jdField_d_of_type_Int == 4) && (paramKeyEvent.jdField_g_of_type_Int >= 9)))
      {
        long l1 = AudioHelper.b();
        if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(l1)) {
          f(l1);
        }
      }
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "life_onNewIntent, seq[" + l1 + "]");
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    setIntent(paramIntent);
    int i1 = paramIntent.getIntExtra("sessionType", 0);
    int i2 = paramIntent.getIntExtra("MultiAVType", 0);
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)) {
      if ((i1 == 3) || (i1 == 4))
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        c(l1);
        b(0);
        a(l1, false);
      }
    }
    label164:
    do
    {
      do
      {
        do
        {
          break label164;
          do
          {
            return;
          } while ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4));
          if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
            break label290;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != i2) {
            break;
          }
          c(l1);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.x();
          }
        } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramIntent);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        c(l1);
        b(0);
        a(l1, false);
        return;
        if ((i1 != 3) && (i1 != 4)) {
          break;
        }
        c(l1);
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.x();
        }
      } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramIntent);
      return;
    } while ((i1 != 1) && (i1 != 2));
    label290:
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    c(l1);
    b(0);
    a(l1, false);
  }
  
  public void onPause()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause, seq[" + l1 + "]");
    ColorNoteSmallScreenUtil.a(this, 2, true);
    AVVoiceRecog.a().a(16);
    i(false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 50, 1);
    this.jdField_i_of_type_Boolean = true;
    try
    {
      this.mIsShadow = false;
      super.onPause();
      b(3);
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a("state", "0");
        if ("0".equals(VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      if (this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.c();
        this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.f();
      }
      this.jdField_a_of_type_ComTencentAvCompatAVCallCompactJob.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
      return;
    }
    catch (Exception localException)
    {
      super.finish();
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "life_onPause, exit when onPause Exception, seq[" + l1 + "]", localException);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1, 1007);
    }
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokevirtual 2811	com/tencent/av/ui/AVActivity:i	(Z)V
    //   5: invokestatic 265	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   8: lstore 10
    //   10: aload_0
    //   11: iconst_2
    //   12: iconst_0
    //   13: invokestatic 2808	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenUtil:a	(Landroid/content/Context;IZ)V
    //   16: ldc_w 2813
    //   19: invokestatic 2818	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   22: checkcast 2813	com/tencent/mobileqq/qqfloatingwindow/IQQFloatingWindowBroadcast
    //   25: invokestatic 2821	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: bipush 50
    //   30: iconst_0
    //   31: invokeinterface 2851 4 0
    //   36: ldc_w 2813
    //   39: invokestatic 2818	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   42: checkcast 2813	com/tencent/mobileqq/qqfloatingwindow/IQQFloatingWindowBroadcast
    //   45: invokestatic 2821	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   48: iconst_0
    //   49: bipush 50
    //   51: iconst_1
    //   52: invokeinterface 2825 5 0
    //   57: ldc_w 2813
    //   60: invokestatic 2818	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   63: checkcast 2813	com/tencent/mobileqq/qqfloatingwindow/IQQFloatingWindowBroadcast
    //   66: invokestatic 2821	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   69: bipush 50
    //   71: iconst_2
    //   72: invokeinterface 2851 4 0
    //   77: new 253	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   84: aload_0
    //   85: getfield 274	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   88: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 2853
    //   94: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 2433	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 251	com/tencent/av/ui/AVActivity:mIsShadow	Z
    //   108: aload_0
    //   109: invokespecial 2855	mqq/app/BaseActivity:onResume	()V
    //   112: invokestatic 551	com/tencent/av/SessionMgr:a	()Lcom/tencent/av/SessionMgr;
    //   115: invokevirtual 554	com/tencent/av/SessionMgr:a	()Lcom/tencent/av/app/SessionInfo;
    //   118: astore 22
    //   120: aload_0
    //   121: getfield 274	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   124: iconst_1
    //   125: new 253	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 2857
    //   135: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: getfield 223	com/tencent/av/ui/AVActivity:o	Z
    //   142: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: ldc_w 613
    //   148: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 10
    //   153: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: ldc_w 2859
    //   159: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 22
    //   164: invokevirtual 830	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: ldc_w 336
    //   170: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 455	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 184	com/tencent/av/ui/AVActivity:jdField_i_of_type_Boolean	Z
    //   184: invokestatic 2862	com/tencent/av/opengl/effects/RenderUtil:a	()V
    //   187: aload_0
    //   188: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   191: iconst_4
    //   192: invokevirtual 378	com/tencent/av/app/VideoAppInterface:a	(I)Lcom/tencent/av/business/manager/BusinessManager;
    //   195: checkcast 1633	com/tencent/av/business/manager/report/VideoNodeReporter
    //   198: astore 23
    //   200: aload 22
    //   202: getfield 1018	com/tencent/av/app/SessionInfo:jdField_e_of_type_Boolean	Z
    //   205: ifeq +16 -> 221
    //   208: aload 23
    //   210: aload 22
    //   212: invokevirtual 1634	com/tencent/av/app/SessionInfo:b	()J
    //   215: bipush 8
    //   217: lconst_1
    //   218: invokevirtual 1639	com/tencent/av/business/manager/report/VideoNodeReporter:a	(JIJ)V
    //   221: aload_0
    //   222: invokevirtual 1260	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   225: ldc_w 2513
    //   228: iconst_0
    //   229: invokevirtual 307	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   232: ifeq +13 -> 245
    //   235: aload 23
    //   237: ldc2_w 2514
    //   240: iconst_3
    //   241: lconst_1
    //   242: invokevirtual 1639	com/tencent/av/business/manager/report/VideoNodeReporter:a	(JIJ)V
    //   245: aload_0
    //   246: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   249: invokevirtual 2863	com/tencent/av/app/VideoAppInterface:k	()Z
    //   252: ifne +10 -> 262
    //   255: aload_0
    //   256: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   259: invokevirtual 2864	com/tencent/av/app/VideoAppInterface:c	()V
    //   262: aload_0
    //   263: iconst_0
    //   264: putfield 223	com/tencent/av/ui/AVActivity:o	Z
    //   267: aload_0
    //   268: invokevirtual 2137	com/tencent/av/ui/AVActivity:b	()I
    //   271: istore 4
    //   273: aload_0
    //   274: iconst_0
    //   275: putfield 225	com/tencent/av/ui/AVActivity:jdField_k_of_type_Boolean	Z
    //   278: aload_0
    //   279: iconst_2
    //   280: invokevirtual 2600	com/tencent/av/ui/AVActivity:b	(I)V
    //   283: aload_0
    //   284: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   287: iconst_1
    //   288: invokevirtual 1526	com/tencent/av/VideoController:f	(Z)V
    //   291: aload_0
    //   292: getfield 175	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin	Lcom/tencent/av/smallscreen/SmallScreenActivityPlugin;
    //   295: ifnull +10 -> 305
    //   298: aload_0
    //   299: getfield 175	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin	Lcom/tencent/av/smallscreen/SmallScreenActivityPlugin;
    //   302: invokevirtual 2795	com/tencent/av/smallscreen/SmallScreenActivityPlugin:b	()V
    //   305: getstatic 507	android/os/Build$VERSION:SDK_INT	I
    //   308: bipush 21
    //   310: if_icmplt +47 -> 357
    //   313: aload_0
    //   314: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   317: invokevirtual 931	com/tencent/av/VideoController:a	()Lcom/tencent/av/ui/ScreenRecordHelper;
    //   320: astore 20
    //   322: aload 20
    //   324: ifnull +33 -> 357
    //   327: aload 20
    //   329: invokevirtual 2865	com/tencent/av/ui/ScreenRecordHelper:c	()Z
    //   332: ifeq +25 -> 357
    //   335: aload_0
    //   336: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   339: invokevirtual 1131	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   342: new 2867	com/tencent/av/ui/AVActivity$12
    //   345: dup
    //   346: aload_0
    //   347: invokespecial 2868	com/tencent/av/ui/AVActivity$12:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   350: ldc2_w 2869
    //   353: invokevirtual 1140	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   356: pop
    //   357: aload_0
    //   358: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   361: invokevirtual 1131	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   364: new 2872	com/tencent/av/ui/AVActivity$13
    //   367: dup
    //   368: aload_0
    //   369: lload 10
    //   371: invokespecial 2874	com/tencent/av/ui/AVActivity$13:<init>	(Lcom/tencent/av/ui/AVActivity;J)V
    //   374: ldc2_w 2875
    //   377: invokevirtual 1140	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   380: pop
    //   381: aload 22
    //   383: getfield 588	com/tencent/av/app/SessionInfo:jdField_d_of_type_Int	I
    //   386: iconst_2
    //   387: if_icmpne +1097 -> 1484
    //   390: aload 22
    //   392: invokevirtual 2788	com/tencent/av/app/SessionInfo:l	()Z
    //   395: ifeq +1035 -> 1430
    //   398: aload 22
    //   400: getfield 1324	com/tencent/av/app/SessionInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   403: astore 20
    //   405: aload 22
    //   407: getfield 2877	com/tencent/av/app/SessionInfo:jdField_k_of_type_Boolean	Z
    //   410: istore 16
    //   412: aload_0
    //   413: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   416: aload_0
    //   417: getfield 95	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   420: invokevirtual 2879	com/tencent/av/VideoController:b	(Ljava/lang/String;)Z
    //   423: istore 17
    //   425: aload 22
    //   427: getfield 2880	com/tencent/av/app/SessionInfo:jdField_i_of_type_Boolean	Z
    //   430: istore 18
    //   432: aload 22
    //   434: getfield 2881	com/tencent/av/app/SessionInfo:jdField_j_of_type_Boolean	Z
    //   437: istore 19
    //   439: iload 19
    //   441: ifeq +41 -> 482
    //   444: invokestatic 2885	com/tencent/mobileqq/utils/DeviceInfoUtil:d	()Ljava/lang/String;
    //   447: astore 21
    //   449: aload_0
    //   450: getfield 1024	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   453: lload 10
    //   455: invokevirtual 2887	com/tencent/av/camera/CameraUtils:a	(J)Z
    //   458: ifne +859 -> 1317
    //   461: aload_0
    //   462: getfield 1024	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   465: lload 10
    //   467: invokevirtual 1032	com/tencent/av/camera/CameraUtils:b	(J)Z
    //   470: ifne +847 -> 1317
    //   473: aload_0
    //   474: getfield 1024	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   477: lload 10
    //   479: invokevirtual 2888	com/tencent/av/camera/CameraUtils:a	(J)V
    //   482: aload_0
    //   483: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   486: ifnull +59 -> 545
    //   489: iload 19
    //   491: ifeq +895 -> 1386
    //   494: iload 16
    //   496: ifeq +890 -> 1386
    //   499: iload 18
    //   501: ifeq +854 -> 1355
    //   504: aload_0
    //   505: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   508: lload 10
    //   510: aload 20
    //   512: iconst_1
    //   513: iconst_1
    //   514: iconst_0
    //   515: iload 17
    //   517: invokevirtual 1514	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   520: aload_0
    //   521: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   524: ldc_w 2889
    //   527: invokestatic 2892	com/tencent/av/ui/redbag/RedBagUtil:a	(Lcom/tencent/av/app/VideoAppInterface;Ljava/lang/String;)Z
    //   530: istore 16
    //   532: aload_0
    //   533: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   536: lload 10
    //   538: iconst_1
    //   539: iload 16
    //   541: invokevirtual 1027	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   544: pop
    //   545: aload_0
    //   546: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   549: ifnull +10 -> 559
    //   552: aload_0
    //   553: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   556: invokevirtual 2894	com/tencent/av/ui/VideoLayerUI:q	()V
    //   559: aload_0
    //   560: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   563: ifnull +12 -> 575
    //   566: aload_0
    //   567: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   570: lload 10
    //   572: invokevirtual 2896	com/tencent/av/ui/VideoControlUI:b	(J)V
    //   575: aload_0
    //   576: getfield 648	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiChildGuideUi	Lcom/tencent/av/ui/ChildGuideUi;
    //   579: ifnull +10 -> 589
    //   582: aload_0
    //   583: getfield 648	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiChildGuideUi	Lcom/tencent/av/ui/ChildGuideUi;
    //   586: invokevirtual 2897	com/tencent/av/ui/ChildGuideUi:c	()V
    //   589: aload_0
    //   590: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   593: iconst_0
    //   594: invokevirtual 1524	com/tencent/av/VideoController:a	(Z)I
    //   597: pop
    //   598: aload_0
    //   599: invokevirtual 2898	com/tencent/av/ui/AVActivity:b	()V
    //   602: aload_0
    //   603: invokevirtual 2899	com/tencent/av/ui/AVActivity:e	()V
    //   606: aload_0
    //   607: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   610: invokevirtual 2535	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   613: new 286	android/content/Intent
    //   616: dup
    //   617: ldc_w 2487
    //   620: invokespecial 2488	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   623: invokevirtual 2538	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   626: aload_0
    //   627: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   630: ifnull +20 -> 650
    //   633: aload_0
    //   634: invokevirtual 662	com/tencent/av/ui/AVActivity:a	()Z
    //   637: ifeq +13 -> 650
    //   640: aload_0
    //   641: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   644: ldc_w 2889
    //   647: invokevirtual 2276	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;)V
    //   650: aload 22
    //   652: getfield 588	com/tencent/av/app/SessionInfo:jdField_d_of_type_Int	I
    //   655: iconst_2
    //   656: if_icmpeq +12 -> 668
    //   659: aload 22
    //   661: getfield 588	com/tencent/av/app/SessionInfo:jdField_d_of_type_Int	I
    //   664: iconst_1
    //   665: if_icmpne +45 -> 710
    //   668: aload_0
    //   669: getfield 182	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl	Lcom/tencent/av/ui/QavVideoRecordUICtrl;
    //   672: ifnull +38 -> 710
    //   675: aload_0
    //   676: getfield 182	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl	Lcom/tencent/av/ui/QavVideoRecordUICtrl;
    //   679: invokevirtual 2901	com/tencent/av/ui/QavVideoRecordUICtrl:d	()I
    //   682: iconst_1
    //   683: if_icmpne +27 -> 710
    //   686: aload 22
    //   688: getfield 1097	com/tencent/av/app/SessionInfo:C	Z
    //   691: ifeq +19 -> 710
    //   694: aload_0
    //   695: getfield 243	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   698: new 2903	com/tencent/av/ui/AVActivity$15
    //   701: dup
    //   702: aload_0
    //   703: invokespecial 2904	com/tencent/av/ui/AVActivity$15:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   706: invokevirtual 1382	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   709: pop
    //   710: aload 22
    //   712: getfield 2907	com/tencent/av/app/SessionInfo:X	I
    //   715: iconst_m1
    //   716: if_icmpne +12 -> 728
    //   719: aload 22
    //   721: aload_0
    //   722: invokevirtual 2908	com/tencent/av/ui/AVActivity:a	()I
    //   725: putfield 2907	com/tencent/av/app/SessionInfo:X	I
    //   728: aload 22
    //   730: getfield 2911	com/tencent/av/app/SessionInfo:W	I
    //   733: iconst_m1
    //   734: if_icmpne +105 -> 839
    //   737: aload_0
    //   738: invokevirtual 673	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   741: invokestatic 790	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   744: astore 20
    //   746: aload 22
    //   748: aload 20
    //   750: new 253	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   757: ldc_w 2913
    //   760: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload_0
    //   764: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   767: invokevirtual 793	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   770: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: iconst_1
    //   777: invokeinterface 803 3 0
    //   782: putfield 2911	com/tencent/av/app/SessionInfo:W	I
    //   785: aload 22
    //   787: getfield 2911	com/tencent/av/app/SessionInfo:W	I
    //   790: iconst_1
    //   791: if_icmpne +48 -> 839
    //   794: aload 20
    //   796: invokeinterface 2917 1 0
    //   801: new 253	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   808: ldc_w 2913
    //   811: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload_0
    //   815: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   818: invokevirtual 793	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   821: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: iconst_0
    //   828: invokeinterface 2923 3 0
    //   833: invokeinterface 2926 1 0
    //   838: pop
    //   839: aload 22
    //   841: getfield 2204	com/tencent/av/app/SessionInfo:v	I
    //   844: ifeq +38 -> 882
    //   847: aload 22
    //   849: getfield 2204	com/tencent/av/app/SessionInfo:v	I
    //   852: iconst_1
    //   853: if_icmpne +1323 -> 2176
    //   856: aload_0
    //   857: iconst_2
    //   858: aload_0
    //   859: invokevirtual 839	com/tencent/av/ui/AVActivity:getResources	()Landroid/content/res/Resources;
    //   862: ldc_w 2927
    //   865: invokevirtual 2928	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   868: iconst_0
    //   869: invokestatic 2933	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   872: invokevirtual 2936	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   875: pop
    //   876: aload 22
    //   878: iconst_0
    //   879: putfield 2204	com/tencent/av/app/SessionInfo:v	I
    //   882: aload_0
    //   883: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   886: iconst_2
    //   887: anewarray 1416	java/lang/Object
    //   890: dup
    //   891: iconst_0
    //   892: sipush 7000
    //   895: invokestatic 984	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   898: aastore
    //   899: dup
    //   900: iconst_1
    //   901: aload_0
    //   902: getfield 95	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   905: aastore
    //   906: invokevirtual 1419	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   909: invokestatic 773	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   912: ifeq +10 -> 922
    //   915: aload_0
    //   916: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   919: invokestatic 2939	com/tencent/mobileqq/debug/qav/QavTestUtil:showTestBtn	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   922: invokestatic 1371	com/tencent/av/recog/AVVoiceRecog:a	()Lcom/tencent/av/recog/AVVoiceRecog;
    //   925: bipush 16
    //   927: invokevirtual 2940	com/tencent/av/recog/AVVoiceRecog:b	(I)V
    //   930: aload 22
    //   932: getfield 2881	com/tencent/av/app/SessionInfo:jdField_j_of_type_Boolean	Z
    //   935: istore 16
    //   937: aload 22
    //   939: getfield 2877	com/tencent/av/app/SessionInfo:jdField_k_of_type_Boolean	Z
    //   942: istore 17
    //   944: iload 16
    //   946: ifeq +8 -> 954
    //   949: iload 17
    //   951: ifne +1266 -> 2217
    //   954: invokestatic 1371	com/tencent/av/recog/AVVoiceRecog:a	()Lcom/tencent/av/recog/AVVoiceRecog;
    //   957: iconst_1
    //   958: invokevirtual 2809	com/tencent/av/recog/AVVoiceRecog:a	(I)V
    //   961: invokestatic 2943	java/lang/System:currentTimeMillis	()J
    //   964: lstore 12
    //   966: invokestatic 2606	com/tencent/av/report/VideoConnRateReport:a	()Lcom/tencent/av/report/VideoConnRateReport;
    //   969: getfield 2944	com/tencent/av/report/VideoConnRateReport:jdField_b_of_type_Long	J
    //   972: lstore 14
    //   974: aload 22
    //   976: invokevirtual 1634	com/tencent/av/app/SessionInfo:b	()J
    //   979: lconst_0
    //   980: lcmp
    //   981: ifle +1246 -> 2227
    //   984: aload 22
    //   986: invokevirtual 1634	com/tencent/av/app/SessionInfo:b	()J
    //   989: lstore 8
    //   991: aload 23
    //   993: lload 8
    //   995: bipush 25
    //   997: lload 12
    //   999: lload 14
    //   1001: lsub
    //   1002: invokevirtual 1639	com/tencent/av/business/manager/report/VideoNodeReporter:a	(JIJ)V
    //   1005: aload_0
    //   1006: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1009: ldc_w 2830
    //   1012: ldc_w 2946
    //   1015: invokevirtual 2381	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   1018: pop
    //   1019: ldc_w 2832
    //   1022: putstatic 2384	com/tencent/av/VideoConstants$ProcessInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1025: new 253	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1032: aload_0
    //   1033: getfield 274	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1036: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: ldc_w 2948
    //   1042: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 2433	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   1051: aload_0
    //   1052: invokevirtual 1260	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1055: ldc_w 2950
    //   1058: iconst_0
    //   1059: invokevirtual 290	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1062: ifeq +21 -> 1083
    //   1065: invokestatic 2955	com/tencent/mm/hardcoder/HardCoderManager:a	()Lcom/tencent/mm/hardcoder/HardCoderManager;
    //   1068: aload_0
    //   1069: invokevirtual 1260	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1072: ldc_w 2950
    //   1075: iconst_0
    //   1076: invokevirtual 290	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1079: iconst_1
    //   1080: invokevirtual 2956	com/tencent/mm/hardcoder/HardCoderManager:a	(IZ)V
    //   1083: aload_0
    //   1084: invokevirtual 2957	com/tencent/av/ui/AVActivity:a	()Lcom/tencent/av/VideoController;
    //   1087: invokevirtual 2958	com/tencent/av/VideoController:x	()V
    //   1090: invokestatic 627	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   1093: iconst_0
    //   1094: invokevirtual 2961	com/tencent/av/VideoController:a	(Z)Lcom/tencent/av/opengl/effects/EffectsRenderController;
    //   1097: astore 20
    //   1099: aload 20
    //   1101: ifnull +12 -> 1113
    //   1104: aload 20
    //   1106: lload 10
    //   1108: invokeinterface 2964 3 0
    //   1113: invokestatic 773	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   1116: ifeq +46 -> 1162
    //   1119: aload_0
    //   1120: getfield 274	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1123: iconst_1
    //   1124: new 253	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1131: ldc_w 2966
    //   1134: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: aload_0
    //   1138: invokevirtual 2123	com/tencent/av/ui/AVActivity:getWindow	()Landroid/view/Window;
    //   1141: invokevirtual 494	android/view/Window:getDecorView	()Landroid/view/View;
    //   1144: invokevirtual 499	android/view/View:getSystemUiVisibility	()I
    //   1147: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1150: ldc_w 336
    //   1153: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokestatic 455	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1162: aload_0
    //   1163: getfield 189	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCompatAVCallCompactJob	Lcom/tencent/av/compat/AVCallCompactJob;
    //   1166: aload_0
    //   1167: aload_0
    //   1168: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1171: aload_0
    //   1172: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1175: invokevirtual 2969	com/tencent/av/compat/AVCallCompactJob:a	(Lmqq/app/BaseActivity;Lcom/tencent/av/app/VideoAppInterface;Lcom/tencent/av/VideoController;)V
    //   1178: aload_0
    //   1179: getfield 1047	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller	Lcom/tencent/av/ui/chatroom/VideoChatRoomUIContoller;
    //   1182: ifnull +76 -> 1258
    //   1185: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1188: ifeq +41 -> 1229
    //   1191: aload_0
    //   1192: getfield 274	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1195: iconst_2
    //   1196: new 253	java/lang/StringBuilder
    //   1199: dup
    //   1200: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1203: ldc_w 2971
    //   1206: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: aload 22
    //   1211: getfield 2974	com/tencent/av/app/SessionInfo:aF	Z
    //   1214: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1217: ldc_w 336
    //   1220: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokestatic 339	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1229: aload 22
    //   1231: getfield 2974	com/tencent/av/app/SessionInfo:aF	Z
    //   1234: ifeq +17 -> 1251
    //   1237: aload_0
    //   1238: getfield 1047	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller	Lcom/tencent/av/ui/chatroom/VideoChatRoomUIContoller;
    //   1241: iconst_0
    //   1242: invokevirtual 2975	com/tencent/av/ui/chatroom/VideoChatRoomUIContoller:a	(I)V
    //   1245: aload 22
    //   1247: iconst_0
    //   1248: putfield 2974	com/tencent/av/app/SessionInfo:aF	Z
    //   1251: aload_0
    //   1252: getfield 1047	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller	Lcom/tencent/av/ui/chatroom/VideoChatRoomUIContoller;
    //   1255: invokevirtual 1051	com/tencent/av/ui/chatroom/VideoChatRoomUIContoller:a	()V
    //   1258: aload_0
    //   1259: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1262: invokevirtual 1131	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   1265: new 2977	com/tencent/av/ui/AVActivity$16
    //   1268: dup
    //   1269: aload_0
    //   1270: iload 4
    //   1272: invokespecial 2980	com/tencent/av/ui/AVActivity$16:<init>	(Lcom/tencent/av/ui/AVActivity;I)V
    //   1275: ldc2_w 2869
    //   1278: invokevirtual 1140	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1281: pop
    //   1282: return
    //   1283: astore 20
    //   1285: aload_0
    //   1286: getfield 274	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1289: iconst_1
    //   1290: new 253	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1297: ldc_w 2982
    //   1300: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: aload 20
    //   1305: invokevirtual 830	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1308: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1311: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1314: goto -1202 -> 112
    //   1317: aload 21
    //   1319: ldc_w 2984
    //   1322: invokevirtual 2987	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1325: ifeq -843 -> 482
    //   1328: aload_0
    //   1329: getfield 1024	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1332: invokevirtual 2990	com/tencent/av/camera/CameraUtils:a	()Landroid/hardware/Camera$Parameters;
    //   1335: ifnonnull -853 -> 482
    //   1338: aload_0
    //   1339: getfield 1024	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1342: ldc_w 2992
    //   1345: lload 10
    //   1347: iconst_m1
    //   1348: iconst_m1
    //   1349: invokevirtual 2995	com/tencent/av/camera/CameraUtils:a	(Ljava/lang/String;JII)V
    //   1352: goto -870 -> 482
    //   1355: aload_0
    //   1356: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1359: lload 10
    //   1361: iconst_1
    //   1362: iconst_0
    //   1363: invokevirtual 1027	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1366: pop
    //   1367: aload_0
    //   1368: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1371: lload 10
    //   1373: aload 20
    //   1375: iconst_1
    //   1376: iconst_1
    //   1377: iconst_0
    //   1378: iload 17
    //   1380: invokevirtual 1514	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1383: goto -838 -> 545
    //   1386: iload 19
    //   1388: ifeq +18 -> 1406
    //   1391: aload_0
    //   1392: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1395: lload 10
    //   1397: iconst_1
    //   1398: iconst_0
    //   1399: invokevirtual 1027	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1402: pop
    //   1403: goto -858 -> 545
    //   1406: iload 16
    //   1408: ifeq -863 -> 545
    //   1411: aload_0
    //   1412: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1415: lload 10
    //   1417: aload 20
    //   1419: iconst_1
    //   1420: iconst_1
    //   1421: iconst_0
    //   1422: iload 17
    //   1424: invokevirtual 1514	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1427: goto -882 -> 545
    //   1430: aload 22
    //   1432: getfield 1959	com/tencent/av/app/SessionInfo:ak	Z
    //   1435: ifne -890 -> 545
    //   1438: aload_0
    //   1439: getfield 127	com/tencent/av/ui/AVActivity:jdField_f_of_type_Boolean	Z
    //   1442: ifne -897 -> 545
    //   1445: aload 22
    //   1447: lload 10
    //   1449: iconst_1
    //   1450: invokevirtual 1035	com/tencent/av/app/SessionInfo:a	(JZ)V
    //   1453: aload_0
    //   1454: getfield 1024	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1457: lload 10
    //   1459: invokevirtual 2888	com/tencent/av/camera/CameraUtils:a	(J)V
    //   1462: aload_0
    //   1463: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1466: ifnull -921 -> 545
    //   1469: aload_0
    //   1470: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1473: lload 10
    //   1475: iconst_1
    //   1476: iconst_0
    //   1477: invokevirtual 1027	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1480: pop
    //   1481: goto -936 -> 545
    //   1484: aload 22
    //   1486: getfield 588	com/tencent/av/app/SessionInfo:jdField_d_of_type_Int	I
    //   1489: iconst_4
    //   1490: if_icmpne -945 -> 545
    //   1493: aload 22
    //   1495: getfield 1485	com/tencent/av/app/SessionInfo:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1498: astore 24
    //   1500: aload 24
    //   1502: new 2997	com/tencent/av/ui/AVActivity$14
    //   1505: dup
    //   1506: aload_0
    //   1507: invokespecial 2998	com/tencent/av/ui/AVActivity$14:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   1510: invokestatic 3004	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1513: aload_0
    //   1514: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1517: invokevirtual 2623	com/tencent/av/VideoController:g	()I
    //   1520: istore 5
    //   1522: iconst_0
    //   1523: istore_3
    //   1524: iload_3
    //   1525: aload 24
    //   1527: invokevirtual 1490	java/util/ArrayList:size	()I
    //   1530: if_icmpge -985 -> 545
    //   1533: aload 24
    //   1535: iload_3
    //   1536: invokevirtual 1494	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1539: checkcast 1496	com/tencent/av/gaudio/VideoViewInfo
    //   1542: astore 25
    //   1544: aload 25
    //   1546: getfield 1497	com/tencent/av/gaudio/VideoViewInfo:jdField_a_of_type_Long	J
    //   1549: invokestatic 1502	com/tencent/av/utils/CharacterUtil:a	(J)Ljava/lang/String;
    //   1552: astore 26
    //   1554: aload 25
    //   1556: getfield 1503	com/tencent/av/gaudio/VideoViewInfo:jdField_a_of_type_Int	I
    //   1559: istore 6
    //   1561: aload 25
    //   1563: getfield 3005	com/tencent/av/gaudio/VideoViewInfo:jdField_a_of_type_Boolean	Z
    //   1566: istore 17
    //   1568: aload_0
    //   1569: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1572: ifnull +371 -> 1943
    //   1575: aload_0
    //   1576: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1579: aload 26
    //   1581: iload 6
    //   1583: invokevirtual 3008	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)Z
    //   1586: istore 16
    //   1588: aload_0
    //   1589: getfield 87	com/tencent/av/ui/AVActivity:jdField_d_of_type_Int	I
    //   1592: invokestatic 3009	com/tencent/av/utils/AVUtil:b	(I)I
    //   1595: istore 7
    //   1597: aload_0
    //   1598: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1601: iload 7
    //   1603: aload 26
    //   1605: aload 22
    //   1607: getfield 1769	com/tencent/av/app/SessionInfo:jdField_g_of_type_Long	J
    //   1610: invokestatic 1673	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1613: invokevirtual 2212	com/tencent/av/app/VideoAppInterface:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1616: astore 21
    //   1618: aload 25
    //   1620: getfield 3010	com/tencent/av/gaudio/VideoViewInfo:jdField_b_of_type_Boolean	Z
    //   1623: ifeq +126 -> 1749
    //   1626: aload 26
    //   1628: aload_0
    //   1629: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1632: invokevirtual 793	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1635: invokevirtual 1511	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1638: ifne +111 -> 1749
    //   1641: iload 17
    //   1643: ifeq +106 -> 1749
    //   1646: aload 25
    //   1648: getfield 3011	com/tencent/av/gaudio/VideoViewInfo:jdField_d_of_type_Boolean	Z
    //   1651: ifne +98 -> 1749
    //   1654: aload 21
    //   1656: invokestatic 3013	com/tencent/av/utils/CharacterUtil:a	(Ljava/lang/String;)I
    //   1659: bipush 20
    //   1661: if_icmple +574 -> 2235
    //   1664: new 253	java/lang/StringBuilder
    //   1667: dup
    //   1668: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1671: aload 21
    //   1673: iconst_0
    //   1674: bipush 20
    //   1676: invokestatic 3016	com/tencent/av/utils/CharacterUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   1679: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: ldc_w 3018
    //   1685: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: astore 20
    //   1693: iload 6
    //   1695: iconst_2
    //   1696: if_icmpne +269 -> 1965
    //   1699: aload_0
    //   1700: ldc_w 3019
    //   1703: invokevirtual 3020	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1706: iconst_1
    //   1707: anewarray 1416	java/lang/Object
    //   1710: dup
    //   1711: iconst_0
    //   1712: aload 20
    //   1714: aastore
    //   1715: invokestatic 3024	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1718: astore 20
    //   1720: aload_0
    //   1721: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1724: ifnull +225 -> 1949
    //   1727: aload_0
    //   1728: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1731: instanceof 3026
    //   1734: ifeq +215 -> 1949
    //   1737: aload_0
    //   1738: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1741: sipush 1036
    //   1744: aload 20
    //   1746: invokevirtual 3029	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1749: aload_0
    //   1750: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1753: ifnull +183 -> 1936
    //   1756: aload_0
    //   1757: invokespecial 420	com/tencent/av/ui/AVActivity:k	()V
    //   1760: aload 25
    //   1762: getfield 3010	com/tencent/av/gaudio/VideoViewInfo:jdField_b_of_type_Boolean	Z
    //   1765: ifne +381 -> 2146
    //   1768: aload 25
    //   1770: getfield 3005	com/tencent/av/gaudio/VideoViewInfo:jdField_a_of_type_Boolean	Z
    //   1773: ifne +373 -> 2146
    //   1776: iload 5
    //   1778: iconst_4
    //   1779: if_icmpeq +337 -> 2116
    //   1782: aload 22
    //   1784: getfield 3031	com/tencent/av/app/SessionInfo:F	I
    //   1787: iconst_2
    //   1788: if_icmpne +246 -> 2034
    //   1791: aconst_null
    //   1792: ldc_w 1295
    //   1795: ldc_w 462
    //   1798: ldc_w 462
    //   1801: ldc_w 3033
    //   1804: ldc_w 3033
    //   1807: iconst_0
    //   1808: iconst_0
    //   1809: ldc_w 462
    //   1812: ldc_w 462
    //   1815: ldc_w 462
    //   1818: ldc_w 462
    //   1821: invokestatic 1303	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1824: aload_0
    //   1825: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1828: lload 10
    //   1830: aload 26
    //   1832: iload 6
    //   1834: aload_0
    //   1835: getfield 147	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1838: aload 25
    //   1840: getfield 3010	com/tencent/av/gaudio/VideoViewInfo:jdField_b_of_type_Boolean	Z
    //   1843: aload 25
    //   1845: getfield 3005	com/tencent/av/gaudio/VideoViewInfo:jdField_a_of_type_Boolean	Z
    //   1848: invokevirtual 3036	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1851: iload 16
    //   1853: ifne +83 -> 1936
    //   1856: aload 22
    //   1858: getfield 1613	com/tencent/av/app/SessionInfo:J	Z
    //   1861: ifne +75 -> 1936
    //   1864: ldc_w 3037
    //   1867: fstore_2
    //   1868: fload_2
    //   1869: fstore_1
    //   1870: aload_0
    //   1871: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1874: aload 26
    //   1876: iload 6
    //   1878: invokevirtual 3039	com/tencent/av/ui/VideoLayerUI:b	(Ljava/lang/String;I)Z
    //   1881: ifeq +20 -> 1901
    //   1884: fload_2
    //   1885: fstore_1
    //   1886: aload_0
    //   1887: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1890: invokevirtual 981	com/tencent/av/ui/VideoLayerUI:f	()I
    //   1893: iconst_3
    //   1894: if_icmpeq +7 -> 1901
    //   1897: ldc_w 3040
    //   1900: fstore_1
    //   1901: aload_0
    //   1902: invokevirtual 673	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   1905: fload_1
    //   1906: invokestatic 3043	com/tencent/av/utils/UITools:a	(Landroid/content/Context;F)F
    //   1909: fstore_1
    //   1910: aload_0
    //   1911: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1914: aload 26
    //   1916: iload 6
    //   1918: aload 21
    //   1920: fload_1
    //   1921: iconst_m1
    //   1922: invokevirtual 3046	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;ILjava/lang/String;FI)V
    //   1925: aload_0
    //   1926: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1929: aload 26
    //   1931: iload 6
    //   1933: invokevirtual 3047	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)V
    //   1936: iload_3
    //   1937: iconst_1
    //   1938: iadd
    //   1939: istore_3
    //   1940: goto -416 -> 1524
    //   1943: iconst_0
    //   1944: istore 16
    //   1946: goto -358 -> 1588
    //   1949: aload_0
    //   1950: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1953: sipush 1036
    //   1956: aload 20
    //   1958: invokestatic 3050	com/tencent/av/tips/TipsUtil:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1961: pop
    //   1962: goto -213 -> 1749
    //   1965: aload_0
    //   1966: ldc_w 3051
    //   1969: invokevirtual 3020	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1972: iconst_1
    //   1973: anewarray 1416	java/lang/Object
    //   1976: dup
    //   1977: iconst_0
    //   1978: aload 20
    //   1980: aastore
    //   1981: invokestatic 3024	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1984: astore 20
    //   1986: aload_0
    //   1987: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1990: ifnull +28 -> 2018
    //   1993: aload_0
    //   1994: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1997: instanceof 3026
    //   2000: ifeq +18 -> 2018
    //   2003: aload_0
    //   2004: getfield 585	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   2007: sipush 1037
    //   2010: aload 20
    //   2012: invokevirtual 3029	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   2015: goto -266 -> 1749
    //   2018: aload_0
    //   2019: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2022: sipush 1037
    //   2025: aload 20
    //   2027: invokestatic 3050	com/tencent/av/tips/TipsUtil:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   2030: pop
    //   2031: goto -282 -> 1749
    //   2034: aload 22
    //   2036: getfield 1395	com/tencent/av/app/SessionInfo:D	I
    //   2039: bipush 10
    //   2041: if_icmpne +39 -> 2080
    //   2044: aconst_null
    //   2045: ldc_w 1295
    //   2048: ldc_w 462
    //   2051: ldc_w 462
    //   2054: ldc_w 3053
    //   2057: ldc_w 3053
    //   2060: iconst_0
    //   2061: iconst_0
    //   2062: ldc_w 462
    //   2065: ldc_w 462
    //   2068: ldc_w 462
    //   2071: ldc_w 462
    //   2074: invokestatic 1303	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2077: goto -253 -> 1824
    //   2080: aconst_null
    //   2081: ldc_w 1295
    //   2084: ldc_w 462
    //   2087: ldc_w 462
    //   2090: ldc_w 3055
    //   2093: ldc_w 3055
    //   2096: iconst_0
    //   2097: iconst_0
    //   2098: ldc_w 462
    //   2101: ldc_w 462
    //   2104: ldc_w 462
    //   2107: ldc_w 462
    //   2110: invokestatic 1303	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2113: goto -289 -> 1824
    //   2116: aload_0
    //   2117: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2120: lload 10
    //   2122: aload 26
    //   2124: iload 6
    //   2126: aload_0
    //   2127: getfield 149	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2130: aload 25
    //   2132: getfield 3010	com/tencent/av/gaudio/VideoViewInfo:jdField_b_of_type_Boolean	Z
    //   2135: aload 25
    //   2137: getfield 3005	com/tencent/av/gaudio/VideoViewInfo:jdField_a_of_type_Boolean	Z
    //   2140: invokevirtual 3036	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2143: goto -292 -> 1851
    //   2146: aload_0
    //   2147: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2150: lload 10
    //   2152: aload 26
    //   2154: iload 6
    //   2156: aload_0
    //   2157: getfield 149	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2160: aload 25
    //   2162: getfield 3010	com/tencent/av/gaudio/VideoViewInfo:jdField_b_of_type_Boolean	Z
    //   2165: aload 25
    //   2167: getfield 3005	com/tencent/av/gaudio/VideoViewInfo:jdField_a_of_type_Boolean	Z
    //   2170: invokevirtual 3036	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2173: goto -322 -> 1851
    //   2176: aload_0
    //   2177: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2180: sipush 1023
    //   2183: ldc_w 3056
    //   2186: invokestatic 661	com/tencent/av/tips/TipsUtil:a	(Lcom/tencent/av/app/VideoAppInterface;II)Z
    //   2189: pop
    //   2190: ldc_w 3058
    //   2193: invokestatic 1015	com/tencent/av/ui/funchat/record/QavRecordReporter:a	(Ljava/lang/String;)V
    //   2196: goto -1320 -> 876
    //   2199: astore 20
    //   2201: aload_0
    //   2202: getfield 274	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2205: iconst_1
    //   2206: ldc_w 3060
    //   2209: aload 20
    //   2211: invokestatic 785	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2214: goto -1292 -> 922
    //   2217: invokestatic 1371	com/tencent/av/recog/AVVoiceRecog:a	()Lcom/tencent/av/recog/AVVoiceRecog;
    //   2220: iconst_1
    //   2221: invokevirtual 2940	com/tencent/av/recog/AVVoiceRecog:b	(I)V
    //   2224: goto -1263 -> 961
    //   2227: ldc2_w 2514
    //   2230: lstore 8
    //   2232: goto -1241 -> 991
    //   2235: aload 21
    //   2237: astore 20
    //   2239: goto -546 -> 1693
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2242	0	this	AVActivity
    //   1869	52	1	f1	float
    //   1867	18	2	f2	float
    //   1523	417	3	i1	int
    //   271	1000	4	i2	int
    //   1520	260	5	i3	int
    //   1559	596	6	i4	int
    //   1595	7	7	i5	int
    //   989	1242	8	l1	long
    //   8	2143	10	l2	long
    //   964	34	12	l3	long
    //   972	28	14	l4	long
    //   410	1535	16	bool1	boolean
    //   423	1219	17	bool2	boolean
    //   430	70	18	bool3	boolean
    //   437	950	19	bool4	boolean
    //   320	785	20	localObject1	Object
    //   1283	135	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1691	335	20	str1	String
    //   2199	11	20	localThrowable	Throwable
    //   2237	1	20	localObject2	Object
    //   447	1789	21	str2	String
    //   118	1917	22	localSessionInfo	SessionInfo
    //   198	794	23	localVideoNodeReporter	VideoNodeReporter
    //   1498	36	24	localArrayList	ArrayList
    //   1542	624	25	localVideoViewInfo	VideoViewInfo
    //   1552	601	26	str3	String
    // Exception table:
    //   from	to	target	type
    //   103	112	1283	java/lang/IllegalArgumentException
    //   915	922	2199	java/lang/Throwable
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvVideoCameraListener.a(paramSensorEvent.values);
    }
  }
  
  public void onStart()
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    VideoNodeManager.a(20, 1L);
    if ((localSessionInfo != null) && (localSessionInfo.l())) {
      VideoNodeManager.a(31);
    }
    this.mIsShadow = false;
    super.onStart();
    b(1);
    this.o = false;
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onStart, seq[" + l1 + "]");
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r();
    }
    if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int == 2)) {}
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7003), this.jdField_c_of_type_JavaLangString });
  }
  
  public void onStop()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onStop, seq[" + l1 + "]");
    super.onStop();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l2 = AudioHelper.c();
    this.mIsShadow = false;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b() < 1000L) {
        break label278;
      }
    }
    label278:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = i1;
      ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      b(4);
      if (!this.jdField_h_of_type_Boolean) {
        b(l1);
      }
      i(l1);
      long l3 = AudioHelper.c();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7001), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      e(l1);
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onStop, mIsMultiFinish[" + this.jdField_h_of_type_Boolean + "], seq[" + l1 + "], cost[" + (l3 - l2) + "]");
      return;
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)) {
      return;
    }
    b(4);
    long l1 = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "life_onUserLeaveHint, seq[" + l1 + "]");
    }
    i(l1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "life_onWindowFocusChanged, hasFocus[" + paramBoolean + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean);
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_j_of_type_Boolean = false;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new AVActivity.onWindowFocusChangedRunnable(this), 500L);
    if (AVReport.a().jdField_a_of_type_Boolean)
    {
      AVReport.a().jdField_i_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().x = SystemClock.elapsedRealtime();
  }
  
  public String toString()
  {
    return "TAG[" + this.jdField_b_of_type_JavaLangString + "], ActivityState[" + b() + "], isActivityVisible[" + e() + "], " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */