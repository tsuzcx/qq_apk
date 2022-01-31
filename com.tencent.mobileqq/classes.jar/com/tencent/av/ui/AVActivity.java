package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoConstants.ProcessInfo;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.SpitZimuTask.IMouthDetector;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.redpacket.AVRedPacketGameControl;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.VideoConnRateReport;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.record.QavRecordUtils;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import jpv;
import jpw;
import jpx;
import jpy;
import jpz;
import jqa;
import jqb;
import jqc;
import jqd;
import jqe;
import jqf;
import jqg;
import jqh;
import jqk;
import jql;
import jqm;
import jqo;
import jqt;
import jqu;
import jqv;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, SpitZimuTask.IMouthDetector
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  public BroadcastReceiver a;
  public Bitmap a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new jqb(this);
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  public RelativeLayout a;
  public TextView a;
  public VideoController a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new jqt(this);
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new jpv(this);
  public CameraUtils a;
  AVRedPacketGameControl jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl;
  AVRedPacketManager jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager;
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  public BeautySettingUi a;
  public ChildGuideUi a;
  private ConfigInfoTips jdField_a_of_type_ComTencentAvUiConfigInfoTips;
  public ControlUIObserver a;
  public EffectSettingUi a;
  public QavVideoRecordUICtrl a;
  public VideoControlUI a;
  public VideoLayerUI a;
  public VoiceChangeChooseDialog a;
  public EffectFilterPanel a;
  public QavRecordButtonView a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  public TipsManager a;
  public VipFullScreenVideoView a;
  public VipFunCallMediaListener a;
  public Runnable a;
  String jdField_a_of_type_JavaLangString = null;
  public WeakReference a;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  public int b;
  public Bitmap b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  Runnable jdField_b_of_type_JavaLangRunnable = new jqc(this);
  public final String b;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int = 0;
  public Bitmap c;
  public TextView c;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  String e;
  public boolean e;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString = null;
  public boolean f;
  int jdField_g_of_type_Int = 0;
  String jdField_g_of_type_JavaLangString = null;
  public boolean g;
  public int h;
  public String h;
  boolean h;
  String i;
  public boolean i;
  public String j;
  public boolean j;
  String jdField_k_of_type_JavaLangString = null;
  boolean jdField_k_of_type_Boolean = false;
  public String l;
  boolean l;
  String jdField_m_of_type_JavaLangString = null;
  boolean jdField_m_of_type_Boolean = false;
  private boolean n;
  
  public AVActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new jqo(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener = new jqh(this);
    this.jdField_j_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.mIsShadow = false;
    this.jdField_b_of_type_JavaLangString = ("AVActivity_" + AudioHelper.a());
  }
  
  private String a(Intent paramIntent)
  {
    int i3 = paramIntent.getIntExtra("uinType", -1);
    int i2 = UITools.a(i3);
    int i1 = i2;
    if (i2 == 0) {
      i1 = 3;
    }
    String str;
    if (i3 == 1006)
    {
      str = paramIntent.getStringExtra("toMobile");
      if (!paramIntent.getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label163;
      }
      i1 = 100;
    }
    label163:
    for (paramIntent = paramIntent.getStringExtra("GroupId");; paramIntent = str)
    {
      if ((i3 == -1) || (TextUtils.isEmpty(paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "genSessionIdFromIntent error: uinType " + i3 + ", relationId " + paramIntent);
        }
        return null;
        if ((i1 == 1) || (i1 == 2))
        {
          str = paramIntent.getStringExtra("GroupId");
          break;
        }
        str = paramIntent.getStringExtra("uin");
        break;
      }
      return SessionMgr.a(i1, paramIntent, new int[0]);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramInt);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(), c());
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.ad();
    }
    QavVideoRecordUICtrl localQavVideoRecordUICtrl;
    if ((this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c());
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c());
      localQavVideoRecordUICtrl = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c()) {
        break label213;
      }
    }
    label213:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localQavVideoRecordUICtrl.c(paramBoolean);
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_F_of_type_Boolean)) {
        QavRecordReporter.a("0X8008ABA");
      }
      if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel == null) {
        break;
      }
      paramBoolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(), paramBoolean);
      return;
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a(4, paramString);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = true;
    }
    b(false);
  }
  
  private void c(String paramString)
  {
    String str1;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramString != null))
    {
      str1 = paramString;
      if (AudioHelper.jdField_b_of_type_Boolean)
      {
        str1 = paramString;
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          String str2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a();
          str1 = paramString + "\r\n" + str2;
          QLog.w(this.jdField_b_of_type_JavaLangString, 1, "updateSharpInfo, " + str2);
        }
      }
      paramString = str1;
    }
    try
    {
      str1 = str1 + "\r\n";
      paramString = str1;
      str1 = str1 + SignalStrengthReport.a(VideoController.a().a()).a();
      paramString = str1;
      str1 = str1 + "\r\n";
      paramString = str1;
    }
    catch (Exception localException)
    {
      label169:
      break label169;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void c(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = false;
    }
    m();
  }
  
  private void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean = true;
    }
    super.findViewById(2131365811).setVisibility(0);
    this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a(paramBoolean);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.E();
    }
    String str;
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e();
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString) != 5) {
        break label136;
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, false, false, paramBoolean);
      b(false);
      return;
    }
  }
  
  private void k(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_r_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.dismiss();
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog = null;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog = new VoiceChangeChooseDialog(this, this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.setOnDismissListener(new jpw(this));
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.show();
    }
  }
  
  private void l(boolean paramBoolean)
  {
    AVLog.a(this.jdField_b_of_type_JavaLangString, "enableImmersive|isSupporImmersive = " + ImmersiveUtils.isSupporImmersive());
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_m_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        super.getWindow().addFlags(67108864);
      }
    }
    else
    {
      return;
    }
    super.getWindow().clearFlags(67108864);
  }
  
  private void o()
  {
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((i1 == 1) || (i1 == 3)) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().c()) || ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())));
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(1004, getResources().getString(2131429628), 3000L, 1);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (a()));
    i(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g());
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(0);
  }
  
  private void p()
  {
    if (this.n) {}
    do
    {
      return;
      this.n = true;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.j();
  }
  
  public void BtnOnClick(View paramView)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick, id" + QavPanel.a(paramView.getId()) + ", nfonWindowFocus[" + this.jdField_j_of_type_Boolean + "]");
    if (!this.jdField_j_of_type_Boolean) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) && (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.b()))
      {
        this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a(paramView);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a()))
      {
        this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a(paramView);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramView);
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    paramView = new PopupMenu(this, paramView);
    RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramView);
    paramView.show();
  }
  
  int a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = getApplicationContext().getSharedPreferences("qav_SP", 0);
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("showRecordTip" + String.valueOf(str), 0);
  }
  
  public VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public AVRedPacketManager a()
  {
    return this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager;
  }
  
  public SmallScreenActivityPlugin a()
  {
    return this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  }
  
  public TipsManager a()
  {
    return this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
  }
  
  void a()
  {
    f();
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
            if (localVideoViewInfo.jdField_b_of_type_Long == 5L) {}
            for (boolean bool = true;; bool = false)
            {
              if (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
                this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, i2, false, false, bool);
              }
              i1 += 1;
              break;
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(false);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o();
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h();
    }
    if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.e();
    }
    if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi.d();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(true);
    i();
    this.jdField_a_of_type_ComTencentAvVideoController.i(false);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(this.jdField_e_of_type_Boolean);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = getApplicationContext().getSharedPreferences("qav_SP", 0).edit();
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    localEditor.putInt("showRecordTip" + String.valueOf(str), paramInt);
    localEditor.commit();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doRecordTipsAnimation");
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2);
    localTranslateAnimation1.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation1.setDuration(paramInt1 / 2);
    int i1 = 0 + paramInt1 / 2;
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2);
    localTranslateAnimation2.setDuration(paramInt1 / 2);
    localTranslateAnimation2.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation2.setStartOffset(i1);
    i1 += paramInt1 / 2;
    TranslateAnimation localTranslateAnimation3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt2 * 2 / 3);
    localTranslateAnimation3.setInterpolator(new AccelerateInterpolator());
    localTranslateAnimation3.setDuration(paramInt1 / 2);
    localTranslateAnimation3.setStartOffset(i1);
    i1 += paramInt1 / 2;
    TranslateAnimation localTranslateAnimation4 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - paramInt2 * 2 / 3);
    localTranslateAnimation4.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation4.setDuration(paramInt1 / 2);
    localTranslateAnimation4.setStartOffset(i1);
    paramInt1 /= 2;
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation1);
    localAnimationSet.addAnimation(localTranslateAnimation2);
    localAnimationSet.addAnimation(localTranslateAnimation3);
    localAnimationSet.addAnimation(localTranslateAnimation4);
    this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(paramInt1, paramString, paramLong, paramInt2);
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, View.OnClickListener paramOnClickListener)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(-2147483648);
    localGradientDrawable.setCornerRadius(AIOUtils.a(3.0F, getResources()));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    n();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_b_of_type_AndroidWidgetTextView.setHighlightColor(0);
  }
  
  public void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.c(this.jdField_b_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d()) {
      return;
    }
    Resources localResources = getResources();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().S)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().S = true;
      a(2, false);
      a(localResources.getText(2131429244), 3000, null);
      return;
    }
    SpannableString localSpannableString = new SpannableString(localResources.getText(2131429246));
    localSpannableString.setSpan(new ForegroundColorSpan(localResources.getColor(2131493307)), 9, 14, 33);
    a(localSpannableString, 3000, new jqa(this, paramString));
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    AVLog.d(this.jdField_b_of_type_JavaLangString, "enterChatWin exit");
    this.jdField_e_of_type_Boolean = false;
    finish();
    int i1 = 2131034240;
    paramInt = i1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      paramInt = i1;
      if (paramString1 != null) {
        paramInt = SmallScreenUtils.a(paramString1.jdField_J_of_type_Int);
      }
    }
    overridePendingTransition(0, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo onCreateUI SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    if (this.jdField_d_of_type_Int == 1008) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130840203);
    }
    for (;;)
    {
      label69:
      this.jdField_b_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130840220);
      this.jdField_c_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130840094);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365809));
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)
      {
        localObject1 = (LinearLayout)super.findViewById(2131364220);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (LinearLayout)localObject1);
      }
      ((EffectsRenderController)this.jdField_a_of_type_ComTencentAvVideoController.a(getApplicationContext())).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365799));
      }
      this.jdField_a_of_type_JavaLangRunnable = new jqe(this);
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365814));
      Object localObject1 = super.findViewById(2131365798);
      Object localObject2 = ((View)localObject1).findViewById(2131366230);
      try
      {
        if (this.jdField_d_of_type_Int == 1008) {
          ((View)localObject2).setBackgroundResource(2130840203);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            break label939;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int != 2)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (View)localObject1, this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new jqf(this));
          }
          c(false);
          switch (this.jdField_b_of_type_Int)
          {
          default: 
            if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
              if ((this.jdField_d_of_type_Int == 9500) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
              {
                localObject1 = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
                ((DoubleVideoCtrlUI)localObject1).a(2131365370, this.jdField_a_of_type_ComTencentAvVideoController.jdField_r_of_type_Boolean, 2130840137);
                if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
                  ((DoubleVideoCtrlUI)localObject1).a.setViewEnable(2131365377, false);
                }
                if (!this.jdField_a_of_type_ComTencentAvVideoController.t) {
                  ((DoubleVideoCtrlUI)localObject1).a.a(true, 0, false);
                }
              }
            }
            localObject1 = (RelativeLayout)super.findViewById(2131365811);
            if (localObject1 != null)
            {
              if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi == null) {
                this.jdField_a_of_type_ComTencentAvUiBeautySettingUi = new BeautySettingUi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (ViewGroup)localObject1, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              }
              if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) {
                this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a();
              }
            }
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 4) && (this.jdField_b_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
            {
              int i1 = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 6, true, null);
              VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1);
              if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
                this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
              }
              int i2 = VipFunCallManager.a();
              localObject1 = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
              if (localObject1 != null)
              {
                localObject2 = new File((String)localObject1);
                if ((localObject2 == null) || (!((File)localObject2).exists())) {
                  break label1289;
                }
                if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jqg(this, (String)localObject1, i2, i1), 1000L);
                }
              }
            }
            this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131365815));
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365818));
            h(false);
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(0);
            localObject1 = (RelativeLayout)findViewById(2131365805);
            if ((localObject1 != null) && (QavVideoRecordUICtrl.f()))
            {
              this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = new QavVideoRecordUICtrl(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
              this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c(1);
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl);
            }
            return;
            this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130840094);
            break label69;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int != 2) {
              break label928;
            }
            ((View)localObject2).setBackgroundResource(2130840094);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreateUI OutOfMemoryError", localOutOfMemoryError);
          continue;
          label928:
          localOutOfMemoryError.setBackgroundResource(2130840203);
          continue;
          label939:
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w();
          continue;
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
          {
            if (!this.jdField_g_of_type_Boolean) {
              break label1018;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.u(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            break;
            label1018:
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          }
          if (!this.jdField_h_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.u(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            continue;
            if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
            {
              if (!this.jdField_g_of_type_Boolean) {
                break label1162;
              }
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.u(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
              break;
              label1162:
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int == 1)
              {
                this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              }
              else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int == 10)
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
            label1289:
            QLog.e(this.jdField_b_of_type_JavaLangString, 1, "funcall --> !file.exists() + path:" + (String)localObject1);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean = false;
    }
    AVLog.d(this.jdField_b_of_type_JavaLangString, "hideBeautySetting :." + paramBoolean + "|" + paramInt + "|" + this.jdField_b_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
    SessionMgr.a();
    this.jdField_a_of_type_JavaLangString = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    SessionMgr.a();
    String str = SessionMgr.a(3, "beautySetting", new int[0]);
    SessionMgr.a().a(str, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.g();
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.F();
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramBoolean))
      {
        str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString) != 5) {
          break label230;
        }
        paramBoolean = true;
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, bool, false, paramBoolean);
      }
    }
    label230:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        if (2 != this.jdField_b_of_type_Int) {
          break label431;
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.b(this)))
        {
          AVLog.d(this.jdField_b_of_type_JavaLangString, "chatAbility is invalid ,finish.");
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.b(227);
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 0);
          this.jdField_e_of_type_Boolean = true;
          finish();
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
          return;
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.u(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
          break label416;
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.u();
      } while (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c());
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(true, 0);
      return;
      AVLog.d(this.jdField_b_of_type_JavaLangString, "onCreateUI mControlUI is null ,finish.");
      finish();
      return;
    } while (1 != this.jdField_b_of_type_Int);
    label416:
    label431:
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hideBeautySetting, reason:" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.b(this)))
    {
      AVLog.d(this.jdField_b_of_type_JavaLangString, "chatAbility is invalid ,finish.");
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
      this.jdField_a_of_type_ComTencentAvVideoController.b(228);
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 0);
      this.jdField_e_of_type_Boolean = true;
      finish();
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.u(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
      return;
    }
    AVLog.d(this.jdField_b_of_type_JavaLangString, "mControlUI is null ,finish.");
    finish();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(4));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void b()
  {
    AVLog.b("VideoNodeManager", "==> AVActivity processExtraData()**********************************");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData");
    }
    Object localObject3 = super.getIntent();
    if (localObject3 == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processExtraData-->can not get intent");
      return;
    }
    AudioHelper.a("AVActivity.processExtraData", ((Intent)localObject3).getExtras());
    int i4 = ((Intent)localObject3).getIntExtra("sessionType", 0);
    int i3 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    boolean bool = ((Intent)localObject3).getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_g_of_type_Boolean = bool;
    Object localObject2 = ((Intent)localObject3).getStringExtra("Fromwhere");
    if ((localObject2 != null) && (((String)localObject2).compareTo("AVNotification") == 0))
    {
      if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 13)) && (i4 != 1) && (i4 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().G) {
          break label390;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 0);
        this.jdField_a_of_type_ComTencentAvVideoController.b(230);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int != 10) {
          break label431;
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
        break label467;
      }
      AVLog.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.b(3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 1);
      break;
      label431:
      ReportController.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
    }
    label467:
    Object localObject1 = null;
    String str = null;
    int i2 = 0;
    if ((i4 == 1) || (i4 == 2))
    {
      localObject1 = ((Intent)localObject3).getStringExtra("uin");
      if ((localObject2 == null) || (((String)localObject2).compareTo("AVNotification") != 0)) {
        break label2502;
      }
      if ((i4 != 1) && (i4 != 2)) {
        break label677;
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    }
    label677:
    label1477:
    label2502:
    for (;;)
    {
      int i1;
      int i5;
      if (localObject1 == null)
      {
        AVLog.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1016L);
        finish();
        return;
        if ((i4 != 3) && (i4 != 4)) {
          break;
        }
        localObject1 = ((Intent)localObject3).getStringExtra("GroupId");
        i1 = ((Intent)localObject3).getIntExtra("MeetingConfID", 0);
        i5 = ((Intent)localObject3).getIntExtra("ConfAppID", 0);
        int i6 = ((Intent)localObject3).getIntExtra("MeetingStasks", -1);
        this.jdField_a_of_type_ComTencentAvVideoController.a().M = i1;
        this.jdField_a_of_type_ComTencentAvVideoController.a().N = i5;
        this.jdField_a_of_type_ComTencentAvVideoController.a().O = i6;
        break;
        if ((i4 != 3) && (i4 != 4)) {
          break label2502;
        }
        if (bool)
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          continue;
        }
        localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      if ((i3 == 1) || (i3 == 2))
      {
        str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        i1 = UITools.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int);
        localObject2 = str;
        if (str == null)
        {
          AVLog.d(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
          ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1016L);
          finish();
        }
      }
      else if ((i3 == 3) || (i3 == 4))
      {
        str = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        i1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int;
        localObject2 = str;
        if (str == null)
        {
          AVLog.d(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1016L);
          finish();
        }
      }
      else
      {
        i1 = i2;
        localObject2 = str;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "original session type is none");
          localObject2 = str;
          i1 = i2;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->IntentSessionType=" + i4 + ", OriginalSessionType=" + i3 + ", IntentUin=" + (String)localObject1);
      }
      if ((localObject2 != null) && (QLog.isColorLevel())) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->OriginalUin=" + (String)localObject2 + ", originalRelationType=" + i1);
      }
      if ((i3 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        c();
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processExtraData, mSessionType[" + this.jdField_b_of_type_Int + "], mUinType[" + this.jdField_d_of_type_Int + "], mPeerUin[" + this.jdField_c_of_type_JavaLangString + "], mPeerName[" + this.jdField_d_of_type_JavaLangString + "], mPhoneNum[" + this.jdField_e_of_type_JavaLangString + "], mSelfNation[" + this.jdField_f_of_type_JavaLangString + "], mSelfMobile[" + this.jdField_g_of_type_JavaLangString + "], mIsReceiver[" + this.jdField_a_of_type_Boolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], mExtraUin[" + this.jdField_h_of_type_JavaLangString + "], mIsPeerNetworkWell[" + this.jdField_c_of_type_Boolean + "], mIsFriend[" + this.jdField_d_of_type_Boolean + "], mFromWhere[" + this.jdField_i_of_type_JavaLangString + "]");
        HexUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      if ((i3 == 3) || (i3 == 4) || (this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        if ((i3 != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.l())) {
          break label2499;
        }
        localObject2 = "";
      }
      for (;;)
      {
        if ((i4 == 1) || (i4 == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l()) {
            this.jdField_a_of_type_ComTencentAvVideoController.h(true);
          }
          for (;;)
          {
            c();
            return;
            this.jdField_a_of_type_ComTencentAvVideoController.a(i1, Long.valueOf((String)localObject2).longValue(), 97);
          }
        }
        if ((i4 != 3) && (i4 != 4)) {
          break;
        }
        l1 = Long.valueOf((String)localObject1).longValue();
        i3 = 0;
        i5 = ((Intent)localObject3).getIntExtra("MultiAVType", 0);
        this.jdField_a_of_type_ComTencentAvVideoController.a().aw = ((Intent)localObject3).getBooleanExtra("disableInvite", false);
        i2 = i3;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int != 0)
        {
          i2 = i3;
          if (i5 != this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int)
          {
            i2 = i3;
            if (i5 != 0) {
              i2 = 1;
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(i5);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.h(true);
            if (i2 != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 99);
              this.jdField_a_of_type_ComTencentAvVideoController.a().a(i5);
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = 3;
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().E = ((Intent)localObject3).getIntExtra("Type", -1);
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long = l1;
            this.jdField_a_of_type_ComTencentAvVideoController.a().q = ((String)localObject1);
            if (((String)localObject1).compareTo((String)localObject2) != 0) {
              break label1827;
            }
            if (i2 == 0) {
              break label1810;
            }
            this.jdField_b_of_type_Int = i4;
            localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
            i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
            ((SessionInfo)localObject1).jdField_i_of_type_Int = i1;
            this.jdField_d_of_type_Int = i1;
            this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().E == -1) {
              this.jdField_a_of_type_ComTencentAvVideoController.a().E = 0;
            }
            this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData multiAVType: " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int);
            }
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label1930;
          }
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
          this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean;
          break;
          if ((((String)localObject1).compareTo((String)localObject2) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
            break label1477;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 98);
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(i5);
          break label1477;
          this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
          continue;
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = i4;
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int = ((Intent)localObject3).getIntExtra("uinType", -1);
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().E == 0) || (this.jdField_a_of_type_ComTencentAvVideoController.a().E == 1)) {
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong = ((Intent)localObject3).getLongArrayExtra("DiscussUinList");
          }
          this.jdField_b_of_type_Int = i4;
          continue;
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString = ((String)localObject1);
          this.jdField_b_of_type_Int = i4;
        }
        break;
        if (((i3 != 1) && (i3 != 2)) || ((i4 != 1) && (i4 != 2))) {
          break;
        }
        i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
        if ((i1 != -1) && (i1 != this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int });
          this.jdField_a_of_type_ComTencentAvVideoController.b(203);
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          localObject2 = SessionMgr.a(3, (String)localObject1, new int[0]);
          if (SessionMgr.a().a((String)localObject2) == null)
          {
            AVLog.d(this.jdField_b_of_type_JavaLangString, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          str = SessionMgr.a().a((String)localObject2).jdField_e_of_type_JavaLangString;
          i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
          localObject3 = SessionMgr.a().a((String)localObject2).jdField_r_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.b(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject1, str, 0, (String)localObject3, false, true);
          c();
          localObject1 = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
          localObject2 = SessionMgr.a().a((String)localObject1, false);
          ((SessionInfo)localObject2).jdField_a_of_type_Boolean = true;
          ((SessionInfo)localObject2).a("processExtraData", 2);
          ((SessionInfo)localObject2).ai = false;
          if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().G;
        this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString;
        this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
        this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().n;
        this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().B;
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean;
        this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().Q;
        this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean;
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_J_of_type_Boolean;
        break;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.f(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramBoolean);
    }
  }
  
  boolean b()
  {
    return (a()) || ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d()));
  }
  
  public int c()
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      i1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a();
    }
    return i1;
  }
  
  void c()
  {
    AVLog.b("VideoNodeManager", "==> AVActivity processIntentData()********************************** mApp.isProcessCreate = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean + "  mApp.isMsfRecv = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean);
    Object localObject;
    String str1;
    byte[] arrayOfByte;
    String str2;
    long l1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean = false;
      VideoNodeManager.a(26);
      localObject = super.getIntent();
      this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("sessionType", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("uinType", -1);
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
      this.jdField_k_of_type_JavaLangString = ((Intent)localObject).getStringExtra("dstClient");
      this.jdField_g_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isDoubleVideoMeeting", false);
      this.jdField_l_of_type_JavaLangString = ((Intent)localObject).getStringExtra("bindId");
      this.jdField_e_of_type_Int = ((Intent)localObject).getIntExtra("bindType", 0);
      this.jdField_c_of_type_Int = ((Intent)localObject).getIntExtra("subServiceType", 0);
      this.jdField_f_of_type_Int = ((Intent)localObject).getIntExtra("extraType", 0);
      this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("name");
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("selfNation");
      this.jdField_g_of_type_JavaLangString = ((Intent)localObject).getStringExtra("selfMobile");
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("toMobile");
      this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("receive", false);
      this.jdField_b_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isAudioMode", true);
      this.jdField_h_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extraUin");
      str1 = ((Intent)localObject).getStringExtra("extraCode");
      arrayOfByte = ((Intent)localObject).getByteArrayExtra("sig");
      this.jdField_c_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isPeerNetworkWell", false);
      this.jdField_d_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isFriend", false);
      this.jdField_i_of_type_JavaLangString = ((Intent)localObject).getStringExtra("from");
      this.jdField_f_of_type_Boolean = ((Intent)localObject).getBooleanExtra("shutCamera", false);
      str2 = ((Intent)localObject).getStringExtra("headUrl");
      this.jdField_a_of_type_Long = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
      this.jdField_g_of_type_Int = ((Intent)localObject).getIntExtra("vipType", 0);
      this.jdField_h_of_type_Boolean = ((Intent)localObject).getBooleanExtra("triggerBeauty", false);
      this.jdField_m_of_type_JavaLangString = ((Intent)localObject).getStringExtra("actid");
      AVLog.b("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.jdField_b_of_type_Int + "  mIsAudioMode = " + this.jdField_b_of_type_Boolean);
      VideoNodeManager.b(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label755;
      }
      l1 = 1L;
      label488:
      VideoNodeManager.a(13, l1);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mTriggerBeauty = " + this.jdField_h_of_type_Boolean);
      }
      if ((this.jdField_d_of_type_Int == 0) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_d_of_type_Int != 1008) {
        break label790;
      }
      if (arrayOfByte == null) {
        break label762;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[arrayOfByte.length + 3];
      this.jdField_a_of_type_ArrayOfByte[0] = 1;
      this.jdField_a_of_type_ArrayOfByte[1] = 1;
      this.jdField_a_of_type_ArrayOfByte[2] = -116;
      System.arraycopy(arrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 3, arrayOfByte.length);
    }
    for (;;)
    {
      AVReport.a().jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)) {
        break label1136;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().E = ((Intent)localObject).getIntExtra("Type", -1);
      this.jdField_a_of_type_ComTencentAvVideoController.a().q = ((Intent)localObject).getStringExtra("GroupId");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().q)) {
        break label892;
      }
      AVLog.d(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
      this.jdField_e_of_type_Boolean = true;
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1016L);
      finish();
      return;
      VideoNodeManager.a();
      break;
      label755:
      l1 = 2L;
      break label488;
      label762:
      this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      continue;
      label790:
      if (this.jdField_d_of_type_Int == 1011)
      {
        if (arrayOfByte != null)
        {
          this.jdField_a_of_type_ArrayOfByte = new byte[arrayOfByte.length + 3];
          this.jdField_a_of_type_ArrayOfByte[0] = 1;
          this.jdField_a_of_type_ArrayOfByte[1] = 1;
          this.jdField_a_of_type_ArrayOfByte[2] = -118;
          System.arraycopy(arrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 3, arrayOfByte.length);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
        }
      }
      else {
        this.jdField_a_of_type_ArrayOfByte = arrayOfByte;
      }
    }
    label892:
    int i2 = ((Intent)localObject).getIntExtra("MultiAVType", 0);
    int i1 = i2;
    if (i2 == 0)
    {
      i2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(i1);
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processIntentData :  set Value multiAVType: " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().q != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().q).longValue();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong = ((Intent)localObject).getLongArrayExtra("DiscussUinList");
    this.jdField_a_of_type_ComTencentAvVideoController.a().aw = ((Intent)localObject).getBooleanExtra("disableInvite", false);
    while (this.jdField_b_of_type_Int == 0)
    {
      AVLog.d(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1015L);
      finish();
      return;
      label1136:
      this.jdField_a_of_type_ComTencentAvVideoController.a().ak = ((Intent)localObject).getBooleanExtra("isOtherTerminalOnChating", false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Long = ((Intent)localObject).getLongExtra("otherTerminalChatingRoomId", 0L);
        this.jdField_a_of_type_ComTencentAvVideoController.a().am = ((Intent)localObject).getBooleanExtra("startfromVideoEntry", false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "peerUin : " + this.jdField_c_of_type_JavaLangString + ", bStartByTerminalSwitch : " + this.jdField_a_of_type_ComTencentAvVideoController.a().ak + ", sessionType : " + this.jdField_b_of_type_Int + ",StartFromVideoEntry:" + this.jdField_a_of_type_ComTencentAvVideoController.a().am);
      }
    }
    if ((((Intent)localObject).getIntExtra("istatus", 0) != 11) || (this.jdField_a_of_type_Boolean))
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        AVLog.d(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      label1394:
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 0);
        this.jdField_a_of_type_ComTencentAvVideoController.b(232);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString = str1;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().Q = this.jdField_b_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean = this.jdField_c_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().n = this.jdField_l_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().A = this.jdField_e_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().B = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_J_of_type_Boolean = this.jdField_d_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean = this.jdField_f_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentAvVideoController.a().o = this.jdField_g_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int = ((Intent)localObject).getIntExtra("friendTerminal", -1);
      this.jdField_a_of_type_ComTencentAvVideoController.a().G = this.jdField_g_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().X = ((Intent)localObject).getBooleanExtra("isAVMeeting", false);
      this.jdField_a_of_type_ComTencentAvVideoController.a().Y = ((Intent)localObject).getBooleanExtra("isAVGroupMeeting", false);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_JavaLangString = ((Intent)localObject).getStringExtra("actId");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_JavaLangString = ((Intent)localObject).getStringExtra("mp_ext_params");
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = ((Intent)localObject).getIntExtra("graySwitch", 0);
      this.jdField_a_of_type_ComTencentAvVideoController.a().w = ((Intent)localObject).getIntExtra("ltC2CMembership", 5);
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = ((Intent)localObject).getIntExtra("ltMultiMembership", 5);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Int = ((Intent)localObject).getIntExtra("ipPstnEnterType", 0);
      boolean bool = ((Intent)localObject).getBooleanExtra("pstnC2CSwitchMulti", false);
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Int == 1) && (bool)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a("pstnC2CSwitchMulti", true);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_h_of_type_Int = ((Intent)localObject).getIntExtra("multiPstnMissDelayTime", 20);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Int = ((Intent)localObject).getIntExtra("multiPstnMissShowTime", 60);
      this.jdField_a_of_type_ComTencentAvVideoController.j = ((Intent)localObject).getIntExtra("multiPstnAutoTranTime", 100000);
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_d_of_type_Int != 21)) {
        break label2481;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = str2;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("name");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {
        break label2464;
      }
    }
    label2464:
    for (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false)
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!FileUtil.a((String)localObject)) {
        break;
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        return;
      }
      if (this.jdField_d_of_type_Int == 1006)
      {
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          AVLog.d(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
          this.jdField_e_of_type_Boolean = true;
          ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1016L);
          finish();
          return;
        }
        this.jdField_c_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        }
        if (!QLog.isColorLevel()) {
          break label1394;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mPeerUin: " + this.jdField_c_of_type_JavaLangString);
        break label1394;
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        AVLog.d(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Long, 5, 1016L);
        finish();
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label1394;
      }
      this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      break label1394;
    }
    label2481:
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  void d()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener == null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new jqu(this, super.getApplicationContext(), 2);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())) {
      ImmersiveUtils.a(getWindow(), paramBoolean);
    }
  }
  
  public boolean d()
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
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onZimuModeChange, inZimu=" + paramBoolean);
    QavVideoRecordUICtrl localQavVideoRecordUICtrl;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.jdField_d_of_type_Boolean = paramBoolean;
      localQavVideoRecordUICtrl = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (!paramBoolean) {
        break label81;
      }
    }
    label81:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      localQavVideoRecordUICtrl.d(i1);
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
      return;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      Object localObject = (EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = (ZimuItem)((EffectZimuManager)localObject).a();
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if ((localObject == null) || (!((String)localObject).equals("liveshow"))) {
            break label70;
          }
        }
      }
    }
    label70:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onRedBagGameModeChange, inGame=" + paramBoolean);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.ak();
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).I();
      }
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().z) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
        if (!paramBoolean) {
          break label164;
        }
      }
    }
    label164:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      ((QavVideoRecordUICtrl)localObject).d(i1);
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
      localObject = findViewById(2131365798);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break;
        }
        ((View)localObject).setBackgroundColor(-16777216);
      }
      return;
    }
    ((View)localObject).setBackgroundDrawable(null);
  }
  
  public void finish()
  {
    int i1 = 1;
    if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (this.jdField_i_of_type_JavaLangString.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    AVLog.d(this.jdField_b_of_type_JavaLangString, "avideo life_finish, FromWhere[" + this.jdField_i_of_type_JavaLangString + "]");
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b() < 1000L) {
        break label164;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().t = i1;
      ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      super.finish();
      return;
      label164:
      i1 = 2;
    }
  }
  
  void g()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) && (this.jdField_a_of_type_AndroidHardwareSensor == null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    }
  }
  
  void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.clearAnimation();
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    SessionInfo localSessionInfo;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController != null) {}
        for (localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(); localSessionInfo == null; localSessionInfo = null)
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "showRecordTipGuide sessionInfo == null");
          return;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "showRecordTipGuide bShown=" + paramBoolean + " sessionInfo.mIsFirstEnterVideo=" + localSessionInfo.U + ", sessionInfo.mHasShowRecordGuide" + localSessionInfo.aD + ", sessionInfo.mRecordShownCount" + localSessionInfo.V);
        if (AudioHelper.a(0) == 1)
        {
          localSessionInfo.aD = false;
          localSessionInfo.U = 1;
          localSessionInfo.x = true;
        }
      } while (!localSessionInfo.x);
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() == 1))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "showRecordTipGuide button is null or gray");
        return;
      }
      if (localSessionInfo.aD)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "showRecordTipGuide sessionInfo.mIsFirstEnterVideo == 1 && sessionInfo.mHasShowRecordGuide");
        return;
      }
      if ((localSessionInfo.U == 0) && (localSessionInfo.V >= 3))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "showRecordTipGuide sessionInfo.mRecordShownCount >=3");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a()))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "showRecordTipGuide mApp == null || RedBagUtil.getAVRedBagMgr(mApp).isInGameMode()");
        return;
      }
      if (this.jdField_i_of_type_Boolean)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "showRecordTipGuide mIsPausing");
        return;
      }
    } while (((localSessionInfo.U == 0) && (!QavRecordUtils.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) && (!QavRecordUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 0));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    QavRecordReporter.a("0X8008AB7");
    this.jdField_c_of_type_AndroidWidgetTextView.postDelayed(new jpx(this, localSessionInfo), 500L);
  }
  
  public int getRequestedOrientation()
  {
    return super.getRequestedOrientation();
  }
  
  void h()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null)
    {
      if (paramBoolean)
      {
        i1 = 0;
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(i1);
      }
    }
    else if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Boolean = false;
      boolean bool1 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.g();
      boolean bool2 = QavVideoRecordUICtrl.f();
      if ((!bool1) || (!bool2)) {
        break label96;
      }
      QavRecordReporter.a("0X8008AB2");
    }
    for (;;)
    {
      g(paramBoolean);
      return;
      i1 = 8;
      break;
      label96:
      QavRecordReporter.a("0X8008AB1");
    }
  }
  
  void i()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    int i2 = 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "tryShowRecordBtn " + paramBoolean);
    }
    if ((QavVideoRecordUICtrl.i()) || (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl == null)) {
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(8);
      }
    }
    int i1;
    label225:
    do
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      if ((i1 == 1) || (i1 == 2)) {}
      boolean bool;
      for (i1 = 1;; i1 = 0)
      {
        bool = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_J_of_type_Boolean;
        if (!paramBoolean) {
          break label279;
        }
        if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().z))
        {
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(this.jdField_h_of_type_Int);
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(true, 10L);
        }
        if ((i1 != 0) && ((!e()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean))) {
          break label225;
        }
        if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
        h(false);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(272);
      if (bool) {}
      for (i1 = i2;; i1 = 0)
      {
        localMessage.arg1 = i1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 50L);
        return;
      }
    } while (i1 == 0);
    label279:
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().z)
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(0);
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.k();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
    h(false);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(0);
  }
  
  public void j()
  {
    int i1 = -1;
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131365798);
    float f1 = getResources().getDimension(2131560049);
    float f2 = getResources().getDimension(2131560050);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131362516);
    if (localObject != null) {
      i1 = localViewGroup.indexOfChild((View)localObject);
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel, i1);
  }
  
  void k()
  {
    if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) || (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c())) {
      return;
    }
    l();
    ActionSheet localActionSheet = ActionSheet.c(this);
    localActionSheet.getWindow().addFlags(524288);
    localActionSheet.getWindow().addFlags(2097152);
    localActionSheet.getWindow().addFlags(128);
    localActionSheet.b(2131428787);
    localActionSheet.c(2131432998);
    localActionSheet.a(new jpy(this));
    localActionSheet.setOnDismissListener(new jpz(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.e(150);
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_l_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void l()
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
  
  public void m()
  {
    int i3;
    int i1;
    VideoLayerUI localVideoLayerUI;
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null))
    {
      int i2 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
      i3 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a() != null)
        {
          i1 = i2;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().q()) {
            if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean)
            {
              i1 = i2;
              if (!this.jdField_a_of_type_ComTencentAvVideoController.a().z) {}
            }
            else
            {
              i1 = i2;
              if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
              {
                i1 = i2;
                if (!this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d()) {
                  i1 = i2 + this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI);
                }
              }
            }
          }
        }
      }
      localVideoLayerUI = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_i_of_type_Boolean) {
        break label158;
      }
    }
    label158:
    for (boolean bool = true;; bool = false)
    {
      localVideoLayerUI.a(i1, i3, bool);
      return;
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
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
      return;
      if (paramInt1 == 802)
      {
        RedBagUtil.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramIntent);
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
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, BlockSystemBack[" + localCPreEventInfo.jdField_b_of_type_Boolean + "], BlockName[" + localCPreEventInfo.jdField_a_of_type_JavaLangString + "]");
    boolean bool2 = localCPreEventInfo.jdField_b_of_type_Boolean;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiBeautySettingUi == null) || (!this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.b())) {
        break label168;
      }
      bool1 = this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a();
    }
    for (;;)
    {
      if (!bool1) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "2";
      return;
      label168:
      if ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a()))
      {
        bool1 = this.jdField_a_of_type_ComTencentAvUiChildGuideUi.b();
      }
      else
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          bool1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AVLog.b("VideoNodeManager", "==> AVActivity onCreate()**********************************");
    AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.begin");
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate");
    long l1 = System.currentTimeMillis();
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2130969263);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    l(true);
    try
    {
      super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      localObject = super.getAppRuntime();
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        paramBundle = BaseApplicationImpl.getApplication();
        if (paramBundle == null) {
          break label346;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, 尝试同步获取AppRuntime");
        paramBundle = paramBundle.getRuntime();
        localObject = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
        if (paramBundle != null)
        {
          bool = true;
          QLog.d((String)localObject, 1, bool);
        }
      }
      else
      {
        if (paramBundle != null) {
          break label363;
        }
        AVLog.d(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
        paramBundle = super.getString(2131428790) + " 0x05";
        Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
        this.jdField_e_of_type_Boolean = true;
        sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
        finish();
        return;
      }
    }
    catch (NoSuchFieldException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not exist FLAG_NEEDS_MENU_KEY filed", paramBundle);
        }
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      boolean bool;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Could not access FLAG_NEEDS_MENU_KEY", paramBundle);
          continue;
          bool = false;
          continue;
          label346:
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, BaseApplicationImpl.getApplication is null");
          paramBundle = (Bundle)localObject;
        }
      }
      label363:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramBundle);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
      {
        AVLog.d(this.jdField_b_of_type_JavaLangString, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
        paramBundle = super.getString(2131428790) + " 0x06";
        Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
        this.jdField_e_of_type_Boolean = true;
        sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
        finish();
        return;
      }
      d(true);
      paramBundle = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      Object localObject = SessionMgr.a().a();
      if (localObject != null)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate roomId = " + ((SessionInfo)localObject).jdField_j_of_type_Long + ",isReceiver = " + ((SessionInfo)localObject).jdField_a_of_type_Boolean);
        if (((SessionInfo)localObject).jdField_a_of_type_Boolean) {
          paramBundle.a(((SessionInfo)localObject).jdField_j_of_type_Long, 7, 1L);
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
        this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
          break;
        }
        AVLog.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
        paramBundle = super.getString(2131428790) + " 0x07";
        Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
        finish();
        return;
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
      }
      paramBundle = super.getIntent();
      if (paramBundle != null)
      {
        int i1 = paramBundle.getIntExtra("uinType", -1);
        paramBundle = paramBundle.getStringExtra("uin");
        if (i1 == 1008)
        {
          localObject = SessionMgr.a(3, paramBundle, new int[0]);
          localObject = SessionMgr.a().a((String)localObject);
          if ((localObject == null) || (((SessionInfo)localObject).jdField_i_of_type_Int == -1))
          {
            localObject = SessionMgr.a().a();
            if ((((SessionInfo)localObject).jdField_i_of_type_Int != -1) && ((((SessionInfo)localObject).c()) || (((SessionInfo)localObject).d())))
            {
              localObject = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
              ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
              ((Intent)localObject).putExtra("uin", paramBundle);
              ((Intent)localObject).putExtra("uinType", i1);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
              this.jdField_e_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
              AVLog.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + paramBundle);
              finish();
              return;
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvVideoController.c();
      d();
      g();
      this.jdField_a_of_type_JavaLangString = a(getIntent());
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label1439;
      }
    }
    if ((!a(getIntent())) && (!SessionMgr.a().a(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      SessionMgr.a().a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().T) {
        b();
      }
      GraphicRenderMgr.getInstance();
      ThreadManager.post(new jqd(this), 5, null, false);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      b(0);
      a(false);
      if ((this.jdField_h_of_type_Boolean) && (2 == this.jdField_b_of_type_Int))
      {
        SessionMgr.a();
        paramBundle = SessionMgr.a(3, "beautySetting", new int[0]);
        SessionMgr.a().a(this.jdField_a_of_type_JavaLangString, paramBundle);
        this.jdField_a_of_type_JavaLangString = paramBundle;
        j(false);
      }
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        VideoConnRateReport.a().a();
      }
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = new ConfigInfoTips(this);
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips.a();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = SmallScreenActivityPlugin.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().L, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6));
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl = new AVRedPacketGameControl(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (ViewGroup)findViewById(2131365796));
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl.a();
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_" + this.jdField_b_of_type_JavaLangString, 4, String.format("onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.end");
      return;
      label1439:
      this.jdField_a_of_type_JavaLangString = SessionMgr.a().a().jdField_b_of_type_JavaLangString;
    }
  }
  
  protected void onDestroy()
  {
    this.mIsShadow = false;
    super.onDestroy();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onDestroy, mActivityState[" + this.jdField_a_of_type_Int + "->" + 5 + "]");
    b(5);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
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
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g();
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null)
    {
      this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.c();
      this.jdField_a_of_type_ComTencentAvUiBeautySettingUi = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
    {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.g();
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null)
    {
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi.b();
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    Object localObject;
    if (this.jdField_e_of_type_Boolean)
    {
      DoodleLogic.a().a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (localObject != null) {
          ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GroupInfo.jdField_a_of_type_Int = 0;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().a("AVActivity.onDestroy", false);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    if (this.jdField_a_of_type_ComTencentAvUiConfigInfoTips != null)
    {
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips.b();
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = null;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl.h();
    }
    if ((getIntent() != null) && ("gavideo_avmeeting".equals(getIntent().getStringExtra("jump_from"))))
    {
      localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      ((Intent)localObject).putExtra("uin", this.jdField_c_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 3000);
      startActivity((Intent)localObject);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString });
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      bool = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramKeyEvent);
    }
    if (bool) {}
    do
    {
      return true;
      switch (paramInt)
      {
      case 84: 
      case 24: 
      case 25: 
      default: 
        return super.onKeyDown(paramInt, paramKeyEvent);
      }
    } while ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null) || (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int < 9) || (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) || (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c()))));
    k();
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "life_onNewIntent");
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
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        b();
        b(0);
        a(false);
      }
    }
    label118:
    do
    {
      do
      {
        do
        {
          break label118;
          do
          {
            return;
          } while ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4));
          if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int != 2)) {
            break label229;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int != i2) {
            break;
          }
          b();
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o();
        } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramIntent);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        b();
        b(0);
        a(false);
        return;
        if ((i1 != 3) && (i1 != 4)) {
          break;
        }
        b();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o();
      } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramIntent);
      return;
    } while ((i1 != 1) && (i1 != 2));
    label229:
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    b();
    b(0);
    a(false);
  }
  
  protected void onPause()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause");
    this.jdField_i_of_type_Boolean = true;
    try
    {
      this.mIsShadow = false;
      super.onPause();
      b(3);
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)) {
        this.jdField_a_of_type_ComTencentAvVideoController.n = SmallScreenUtils.c(this);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a("state", "0");
        if ("0".equals(VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      return;
    }
    catch (Exception localException)
    {
      super.finish();
      AVLog.d(this.jdField_b_of_type_JavaLangString, "exit when onPause Exception:" + localException);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(1007);
    }
  }
  
  public void onResume()
  {
    AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onResume.begin");
    long l1;
    label786:
    label937:
    boolean bool2;
    label1046:
    boolean bool1;
    label1115:
    String str1;
    label1237:
    ArrayList localArrayList;
    int i3;
    int i2;
    try
    {
      this.mIsShadow = false;
      super.onResume();
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo onResume, mhasStopped[" + this.n + "]");
      l1 = System.currentTimeMillis();
      this.jdField_i_of_type_Boolean = false;
      VideoNodeReporter localVideoNodeReporter = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if (localSessionInfo != null)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo onResume roomId = " + localSessionInfo.jdField_j_of_type_Long + ",isReceiver = " + localSessionInfo.jdField_a_of_type_Boolean);
        if (localSessionInfo.jdField_a_of_type_Boolean) {
          localVideoNodeReporter.a(localSessionInfo.jdField_j_of_type_Long, 8, 1L);
        }
        if (getIntent().getBooleanExtra("isMakingAcall", false)) {
          localVideoNodeReporter.a(-1L, 3, 1L);
        }
        if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.h()) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
        }
        if ((this.n) && ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)))
        {
          if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
            this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentAvVideoController.x();
        }
        this.n = false;
        this.jdField_k_of_type_Boolean = false;
        b(2);
        this.jdField_a_of_type_ComTencentAvVideoController.i(true);
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jqk(this), 200L);
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean) {
          break label1046;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r_();
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
        }
        if ((this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)) {
          this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.d();
        }
        if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
          this.jdField_a_of_type_ComTencentAvUiChildGuideUi.c();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(false);
        e();
        h();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
        this.jdField_a_of_type_ComTencentAvVideoController.n = true;
        if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (a())) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onResume");
        }
        if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1)) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a() == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().z)) {
          this.jdField_a_of_type_AndroidOsHandler.post(new jqm(this));
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().V == -1) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().V = a();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().U == -1)
        {
          SharedPreferences localSharedPreferences = getApplicationContext().getSharedPreferences("qav_SP", 0);
          this.jdField_a_of_type_ComTencentAvVideoController.a().U = localSharedPreferences.getInt("firstEnter_" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().U == 1) {
            localSharedPreferences.edit().putInt("firstEnter_" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 0).commit();
          }
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().t != 0)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().t != 1) {
            break label2087;
          }
          QQToast.a(this, 2, getResources().getString(2131429641), 0).a();
          this.jdField_a_of_type_ComTencentAvVideoController.a().t = 0;
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
          QLog.d("IVR_TS_" + this.jdField_b_of_type_JavaLangString, 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7000), this.jdField_c_of_type_JavaLangString });
        if (AudioHelper.a(5) == 1) {
          findViewById(2131365819).setVisibility(0);
        }
        l2 = System.currentTimeMillis();
        long l3 = VideoConnRateReport.a().jdField_b_of_type_Long;
        if (localSessionInfo != null)
        {
          if (localSessionInfo.jdField_j_of_type_Long <= 0L) {
            break label2120;
          }
          l1 = localSessionInfo.jdField_j_of_type_Long;
          localVideoNodeReporter.a(l1, 25, l2 - l3);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a("state", "1");
        VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "0";
        AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onResume.end");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      do
      {
        for (;;)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "onResume IllegalArgumentException " + localIllegalArgumentException);
          continue;
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo onResume sessionInfo is null ");
          continue;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
          {
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
            bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
            boolean bool3;
            boolean bool4;
            if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString) == 5)
            {
              bool1 = true;
              bool3 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
              bool4 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean;
              if (bool4)
              {
                str1 = DeviceInfoUtil.e();
                if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b()) || (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c())) {
                  break label1237;
                }
                this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
              }
            }
            for (;;)
            {
              if ((bool4) && (bool2))
              {
                if (bool3)
                {
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, true, false, bool1);
                  bool1 = RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, "onResume");
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, bool1);
                  break;
                  bool1 = false;
                  break label1115;
                  if ((!str1.contains("vivo")) || (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a() != null)) {
                    continue;
                  }
                  this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a("AVonResume", -1, -1);
                  continue;
                }
                this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
                this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, true, false, bool1);
                break;
              }
            }
            if (bool4) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
            } else if (bool2) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, true, false, bool1);
            }
          }
          else if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) && (!this.jdField_f_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
          }
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4);
      localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
      Collections.sort(localArrayList, new jql(this));
      i3 = this.jdField_a_of_type_ComTencentAvVideoController.g();
      i2 = 0;
    }
    label1441:
    VideoViewInfo localVideoViewInfo;
    String str2;
    int i4;
    int i1;
    if (i2 < localArrayList.size())
    {
      localVideoViewInfo = (VideoViewInfo)localArrayList.get(i2);
      str2 = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
      i4 = localVideoViewInfo.jdField_a_of_type_Int;
      bool1 = localVideoViewInfo.jdField_a_of_type_Boolean;
      bool2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4);
      i1 = -1;
      if (this.jdField_d_of_type_Int != 3000) {
        break label1837;
      }
      i1 = 1004;
      label1514:
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i1, str2, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long));
      if ((localVideoViewInfo.jdField_b_of_type_Boolean) && (!str2.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (bool1) && (!localVideoViewInfo.jdField_d_of_type_Boolean)) {
        if (CharacterUtil.a(str1) <= 20) {
          break label2128;
        }
      }
    }
    label1730:
    label1995:
    label2128:
    for (Object localObject = CharacterUtil.a(str1, 0, 20) + "...";; localObject = str1)
    {
      if (i4 == 2)
      {
        localObject = String.format(getString(2131428970), new Object[] { localObject });
        TipsManager.a(106, (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106, (String)localObject, true);
        label1661:
        if ((localVideoViewInfo.jdField_b_of_type_Boolean) || (localVideoViewInfo.jdField_a_of_type_Boolean)) {
          break label2023;
        }
        if (i3 == 4) {
          break label1995;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_F_of_type_Int != 2) {
          break label1908;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_b_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if ((!bool2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().G))
        {
          float f1 = 10.0F;
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str2, i4)) {
            f1 = 14.0F;
          }
          f1 = UITools.a(getApplicationContext(), f1);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, str1, f1, -1);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str2, i4);
        }
        i2 += 1;
        break label1441;
        break;
        if (this.jdField_d_of_type_Int == 1)
        {
          i1 = 1000;
          break label1514;
        }
        if (this.jdField_d_of_type_Int != 0) {
          break label1514;
        }
        i1 = 0;
        break label1514;
        localObject = String.format(getString(2131428969), new Object[] { localObject });
        TipsManager.a(103, (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103, (String)localObject, true);
        break label1661;
        label1908:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
          break label1730;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label1730;
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_c_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        continue;
        label2023:
        if (!localVideoViewInfo.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_c_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_a_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        }
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(1003, getResources().getString(2131429640), 3000L, 1);
      QavRecordReporter.a("0X8008AB0");
      break label786;
      l1 = -1L;
      break label937;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramSensorEvent.values);
    }
  }
  
  protected void onStart()
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    VideoNodeManager.a(20, 1L);
    if ((localSessionInfo != null) && (localSessionInfo.f())) {
      VideoNodeManager.a(31);
    }
    this.mIsShadow = false;
    super.onStart();
    long l1 = System.currentTimeMillis();
    b(1);
    this.n = false;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onStart");
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f();
    }
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.x();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7003), this.jdField_c_of_type_JavaLangString });
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_" + this.jdField_b_of_type_JavaLangString, 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  protected void onStop()
  {
    long l1 = AudioHelper.b();
    this.mIsShadow = false;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_y_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b() < 1000L) {
        break label199;
      }
    }
    label199:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().t = i1;
      ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      super.onStop();
      k(false);
      b(4);
      a();
      p();
      long l2 = AudioHelper.b();
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onStop, cost[" + (l2 - l1));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7001), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      return;
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_D_of_type_Int == 2)) {
      return;
    }
    b(4);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "life_onUserLeaveHint");
    }
    p();
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
    super.getWindow().getDecorView().postDelayed(new jqv(this), 500L);
    if (AVReport.a().jdField_a_of_type_Boolean)
    {
      AVReport.a().i = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().x = SystemClock.elapsedRealtime();
  }
  
  public String toString()
  {
    return "TAG[" + this.jdField_b_of_type_JavaLangString + "], ActivityState[" + b() + "], isActivityVisible[" + d() + "], " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */