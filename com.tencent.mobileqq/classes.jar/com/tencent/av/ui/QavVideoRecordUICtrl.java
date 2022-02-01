package com.tencent.av.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funchat.record.FileSwapHelper;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordButtonView.ShowStateChangeListener;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavRecordListener;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.record.QavRecordUtils;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;

@TargetApi(18)
public class QavVideoRecordUICtrl
  implements Handler.Callback, View.OnClickListener, QavRecordButtonView.ShowStateChangeListener, QavRecordListener, SdkAudioFrameCallback
{
  public static String a;
  public static boolean a;
  public static boolean b;
  public int a;
  public long a;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private DoubleVideoCtrlUI jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
  private VideoNetStateBar jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
  private QavRecordButtonView jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
  public QavRecordDpc a;
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
  private File jdField_a_of_type_JavaIoFile = null;
  private WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  public int b;
  public long b;
  private Animator.AnimatorListener jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  private ValueAnimator.AnimatorUpdateListener jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator = null;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  public long c;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int = 1;
  private long jdField_d_of_type_Long = 0L;
  private RelativeLayout.LayoutParams jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private String jdField_d_of_type_JavaLangString = null;
  public boolean d;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private RelativeLayout.LayoutParams jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private long jdField_f_of_type_Long = 0L;
  private boolean jdField_f_of_type_Boolean = true;
  private volatile long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean = false;
  private volatile long jdField_h_of_type_Long;
  private volatile boolean jdField_h_of_type_Boolean = false;
  private volatile boolean i = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append("/qav_record_test_switch.dat");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public QavVideoRecordUICtrl(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout1, VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, RelativeLayout paramRelativeLayout2, VideoControlUI paramVideoControlUI)
  {
    this.jdField_a_of_type_Long = 60000L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout2;
    if ((paramVideoControlUI instanceof DoubleVideoCtrlUI)) {
      paramAVActivity = (DoubleVideoCtrlUI)paramVideoControlUI;
    } else {
      paramAVActivity = null;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI = paramAVActivity;
    paramAVActivity = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
    if (paramAVActivity == null) {
      paramAVActivity = null;
    } else {
      paramAVActivity = paramAVActivity.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = paramAVActivity;
    paramAVActivity = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (paramAVActivity != null) {
      paramAVActivity.e(true);
    }
    a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc = QavRecordDpc.a();
    this.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.h * 60 * 1000L);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().k < 0L) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().k = this.jdField_a_of_type_Long;
    }
    try
    {
      if (f()) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
      }
    }
    catch (OutOfMemoryError paramAVActivity)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
      paramRelativeLayout1 = new StringBuilder();
      paramRelativeLayout1.append("oom ");
      paramRelativeLayout1.append(paramAVActivity);
      QLog.e("QavVideoRecordUICtrl", 1, paramRelativeLayout1.toString(), paramAVActivity);
    }
    paramAVActivity = DeviceInfoUtil.h();
    paramRelativeLayout1 = new StringBuilder();
    paramRelativeLayout1.append("QavVideoRecordUICtrl manufacture=");
    paramRelativeLayout1.append(paramAVActivity);
    QLog.i("QavVideoRecordUICtrl", 1, paramRelativeLayout1.toString());
    if (("OPPO".equalsIgnoreCase(paramAVActivity)) || ("vivo".equalsIgnoreCase(paramAVActivity))) {
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 0) {
      if (!this.jdField_c_of_type_Boolean)
      {
        if (this.jdField_d_of_type_Boolean) {
          return 0;
        }
        DoubleVideoCtrlUI localDoubleVideoCtrlUI = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
        if ((localDoubleVideoCtrlUI == null) || (!localDoubleVideoCtrlUI.i())) {}
      }
      else
      {
        return 0;
      }
    }
    return paramInt;
  }
  
  private void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordEnd time=");
    localStringBuilder.append(paramLong);
    QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvVideoController.a().az = false;
    if ((paramLong <= 1000L) && (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i))
    {
      if (paramLong >= 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QavVideoRecordUICtrl.7(this), 1000L);
        TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695780);
        QavRecordReporter.a("0X8008AB0");
      }
      else if (paramLong < 0L)
      {
        a(3, true);
        TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695755);
        this.jdField_a_of_type_ComTencentAvVideoController.C();
      }
    }
    else
    {
      a(3, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a().ag = 0;
    }
    n();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
  }
  
  public static void a(VideoController paramVideoController)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendSupportMsg, controller=");
      localStringBuilder.append(paramVideoController);
      QLog.d("QavVideoRecordUICtrl", 2, localStringBuilder.toString());
    }
    if ((f()) && (!k()))
    {
      if (paramVideoController != null)
      {
        paramVideoController.a(8, "SUPPORT_TRUE");
        paramVideoController.a(8, "SUPPORT_TRUE");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SUPPORT_TRUE_7.3.5#");
        localStringBuilder.append(QavRecordDpc.a().h);
        paramVideoController.a(8, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SUPPORT_TRUE_7.3.5#");
        localStringBuilder.append(QavRecordDpc.a().h);
        paramVideoController.a(8, localStringBuilder.toString());
      }
      return;
    }
    QLog.d("QavVideoRecordUICtrl", 1, "sendSupportMsg, not support");
  }
  
  private void a(VideoAppInterface paramVideoAppInterface)
  {
    LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2131559783, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380734));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376298));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376297));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378549));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376288));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376285);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376284);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376283);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(1602735851);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2142109487);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setWillNotDraw(false);
    this.jdField_a_of_type_Int = AIOUtils.b(51.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    this.jdField_b_of_type_JavaLangString = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695768);
    this.jdField_c_of_type_JavaLangString = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695764);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131376277));
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131376290));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131376289));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-273627938);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-65281);
    }
  }
  
  private int b(int paramInt)
  {
    return ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDimensionPixelSize(paramInt);
  }
  
  private void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onForceStop time=");
    localStringBuilder.append(paramLong);
    QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().az = false;
    TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695756);
    this.jdField_a_of_type_ComTencentAvVideoController.C();
    n();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
  }
  
  private long c()
  {
    return Math.max(0L, System.currentTimeMillis() - this.jdField_f_of_type_Long);
  }
  
  public static boolean f()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 18) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDeviceSupport, apiSupport=");
      localStringBuilder.append(bool);
      QLog.d("QavVideoRecordUICtrl", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void h(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i) {
        TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695755);
      }
    }
    else if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i)
    {
      if (this.jdField_e_of_type_Boolean) {
        paramInt = 2131695770;
      } else {
        paramInt = 2131695769;
      }
      QQToast.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(paramInt), 0).a();
    }
  }
  
  public static boolean k()
  {
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
    int j;
    if ((localEffectFaceDeviceConfig != null) && (!localEffectFaceDeviceConfig.b())) {
      j = 0;
    } else {
      j = 1;
    }
    if (j == 0) {
      QLog.d("QavVideoRecordUICtrl", 1, "isInBlackList device not support");
    }
    return j ^ 0x1;
  }
  
  private void p()
  {
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    a(false);
    c(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null)
    {
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) {
        return;
      }
      if (b())
      {
        if (c())
        {
          if (d())
          {
            this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
            return;
          }
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(false);
          return;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
      }
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "doExpandAnim");
    }
    this.jdField_h_of_type_Boolean = true;
    AIOUtils.b(7.5F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    AIOUtils.b(64.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    b(2131297942);
    b(2131297939);
    b(2131297939);
    b(2131297941);
    b(2131297946);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener == null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new QavVideoRecordUICtrl.5(this);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new QavVideoRecordUICtrl.6(this);
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 260 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(260L);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  /* Error */
  private void s()
  {
    // Byte code:
    //   0: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +55 -> 58
    //   6: new 53	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc_w 598
    //   18: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 140	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_h_of_type_Boolean	Z
    //   27: invokevirtual 502	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_1
    //   32: ldc_w 600
    //   35: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: aload_0
    //   41: getfield 148	com/tencent/av/ui/QavVideoRecordUICtrl:i	Z
    //   44: invokevirtual 502	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: ldc 214
    //   50: iconst_1
    //   51: aload_1
    //   52: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 140	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_h_of_type_Boolean	Z
    //   62: ifeq +111 -> 173
    //   65: aload_0
    //   66: getfield 134	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +102 -> 173
    //   74: aload_1
    //   75: invokevirtual 587	android/animation/ValueAnimator:isRunning	()Z
    //   78: ifeq +95 -> 173
    //   81: aload_0
    //   82: getfield 134	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   85: invokevirtual 576	android/animation/ValueAnimator:removeAllUpdateListeners	()V
    //   88: aload_0
    //   89: getfield 134	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   92: invokevirtual 573	android/animation/ValueAnimator:removeAllListeners	()V
    //   95: aload_0
    //   96: getfield 134	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_a_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   99: invokevirtual 590	android/animation/ValueAnimator:cancel	()V
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield 140	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_h_of_type_Boolean	Z
    //   107: aload_0
    //   108: iconst_3
    //   109: iconst_0
    //   110: invokevirtual 602	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   113: return
    //   114: astore_1
    //   115: goto +45 -> 160
    //   118: astore_1
    //   119: new 53	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   126: astore_2
    //   127: aload_2
    //   128: ldc_w 604
    //   131: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_2
    //   136: aload_1
    //   137: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 214
    //   143: iconst_1
    //   144: aload_2
    //   145: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: aload_1
    //   149: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload_0
    //   153: iconst_0
    //   154: putfield 140	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_h_of_type_Boolean	Z
    //   157: goto -55 -> 102
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 140	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_h_of_type_Boolean	Z
    //   165: aload_0
    //   166: iconst_3
    //   167: iconst_0
    //   168: invokevirtual 602	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   171: aload_1
    //   172: athrow
    //   173: aload_0
    //   174: getfield 148	com/tencent/av/ui/QavVideoRecordUICtrl:i	Z
    //   177: ifeq +106 -> 283
    //   180: aload_0
    //   181: getfield 142	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_b_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +97 -> 283
    //   189: aload_1
    //   190: invokevirtual 587	android/animation/ValueAnimator:isRunning	()Z
    //   193: ifeq +90 -> 283
    //   196: aload_0
    //   197: getfield 142	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_b_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   200: invokevirtual 576	android/animation/ValueAnimator:removeAllUpdateListeners	()V
    //   203: aload_0
    //   204: getfield 142	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_b_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   207: invokevirtual 573	android/animation/ValueAnimator:removeAllListeners	()V
    //   210: aload_0
    //   211: getfield 142	com/tencent/av/ui/QavVideoRecordUICtrl:jdField_b_of_type_AndroidAnimationValueAnimator	Landroid/animation/ValueAnimator;
    //   214: invokevirtual 590	android/animation/ValueAnimator:cancel	()V
    //   217: aload_0
    //   218: iconst_0
    //   219: putfield 148	com/tencent/av/ui/QavVideoRecordUICtrl:i	Z
    //   222: aload_0
    //   223: iconst_3
    //   224: iconst_0
    //   225: invokevirtual 602	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   228: return
    //   229: astore_1
    //   230: goto +40 -> 270
    //   233: astore_1
    //   234: new 53	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   241: astore_2
    //   242: aload_2
    //   243: ldc_w 604
    //   246: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: aload_1
    //   252: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 214
    //   258: iconst_1
    //   259: aload_2
    //   260: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aload_1
    //   264: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: goto -50 -> 217
    //   270: aload_0
    //   271: iconst_0
    //   272: putfield 148	com/tencent/av/ui/QavVideoRecordUICtrl:i	Z
    //   275: aload_0
    //   276: iconst_3
    //   277: iconst_0
    //   278: invokevirtual 602	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   281: aload_1
    //   282: athrow
    //   283: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	QavVideoRecordUICtrl
    //   13	62	1	localObject1	Object
    //   114	1	1	localObject2	Object
    //   118	54	1	localException1	Exception
    //   184	6	1	localValueAnimator	ValueAnimator
    //   229	1	1	localObject3	Object
    //   233	49	1	localException2	Exception
    //   126	134	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   81	102	114	finally
    //   119	157	114	finally
    //   81	102	118	java/lang/Exception
    //   196	217	229	finally
    //   234	267	229	finally
    //   196	217	233	java/lang/Exception
  }
  
  private void t()
  {
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_f_of_type_Int = 0;
    QLog.d("QavVideoRecordUICtrl", 1, "onRecordBegin");
    this.jdField_a_of_type_ComTencentAvVideoController.a().az = true;
    a(1, true);
    n();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(0L, this.jdField_a_of_type_Long);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(0L));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
  }
  
  private void u()
  {
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity == null) {
      return;
    }
    if ((localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      QavRecordReporter.a("0X8008AAE");
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().w)
      {
        localAVActivity.jdField_a_of_type_ComTencentAvUiControlUIObserver.c(2);
        QLog.d("QavVideoRecordUICtrl", 1, "start record, child lock");
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().az)
      {
        c();
        long l = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;
        ReportController.b(null, "CliOper", "", "", "0X800863B", "0X800863B", 0, 0, String.valueOf(l), "", "", "");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "av_record_click_end", true, l, 0L, null, "", false);
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a.clear();
      boolean bool1 = f();
      int m = 0;
      int k;
      Object localObject;
      if (!bool1)
      {
        if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695750);
        }
        QLog.d("QavVideoRecordUICtrl", 1, "start record, api not support");
        k = m;
      }
      else
      {
        int j;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ay)
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, friend not support");
          localObject = this.jdField_a_of_type_ComTencentAvVideoController;
          if (((VideoController)localObject).b(((VideoController)localObject).a().jdField_c_of_type_JavaLangString) == 5)
          {
            QavRecordReporter.a("0X8008AB6");
            j = 2131695758;
          }
          else
          {
            QavRecordReporter.a("0X8008AB5");
            j = 2131695757;
          }
          k = m;
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
          {
            TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, j);
            k = m;
          }
        }
        else if (!i())
        {
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
            TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695763);
          }
          QLog.d("QavVideoRecordUICtrl", 1, "start record, isPerformanceSupport==false");
          QavRecordReporter.a("0X8008AB4");
          k = m;
        }
        else if ((this.jdField_a_of_type_ComTencentAvVideoController.a().aA) && (this.jdField_a_of_type_ComTencentAvVideoController.a().af < 735))
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, friend's old version not support record in same time");
          TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695761);
          k = m;
        }
        else if (!e())
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, last encode not stop");
          k = m;
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
          {
            TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695759);
            k = m;
          }
        }
        else
        {
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
          {
            localObject = (EffectFaceManager)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
            FaceItem localFaceItem = (FaceItem)((EffectFaceManager)localObject).a();
            if (localFaceItem != null)
            {
              bool1 = ((EffectFaceManager)localObject).b();
              boolean bool2 = localFaceItem.isSameType("pendant");
              boolean bool3 = localFaceItem.isSameType("face");
              boolean bool4 = localFaceItem.isSameType("voicesticker");
              if ((bool1) && ((bool3) || (bool4))) {
                j = 1;
              } else {
                j = 0;
              }
              if (j != 0)
              {
                localObject = localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
                if (bool4) {
                  j = 2131695783;
                } else {
                  j = 2131695782;
                }
                TipsUtil.a((VideoAppInterface)localObject, 1022, j);
                QLog.d("QavVideoRecordUICtrl", 1, "start record, isDoubleScreen");
                if (bool4)
                {
                  QavRecordReporter.a("0X8009852");
                  k = m;
                  break label949;
                }
                QavRecordReporter.a("0X8008AC3");
                k = m;
                break label949;
              }
              if (bool2) {
                QavRecordReporter.a("0X8008ABE");
              }
            }
          }
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
          {
            localObject = (EffectZimuManager)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
            if (localObject != null)
            {
              localObject = (ZimuItem)((EffectZimuManager)localObject).a();
              if ((localObject != null) && ((TextUtils.isEmpty(((ZimuItem)localObject).getId()) ^ true)))
              {
                TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695784);
                QLog.d("QavVideoRecordUICtrl", 1, "start record, usingZimu");
                QavRecordReporter.a("0X8008AD2");
                k = m;
                break label949;
              }
            }
          }
          if ((localAVActivity.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) && (localAVActivity.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a()))
          {
            TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695781);
            k = m;
          }
          else if (FileSwapHelper.a() < 31457280L)
          {
            if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695775);
            }
            QLog.d("QavVideoRecordUICtrl", 1, "start record, STORAGE_LEFT_MIN_SIZE not enough");
            k = m;
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().ad != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(0));
              QavRecordReporter.a("0X8008AC1");
            }
            if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2))
            {
              localObject = (EffectPendantTools)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
              if ((localObject != null) && (((EffectPendantTools)localObject).a() != null))
              {
                this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(6));
                QavRecordReporter.a("0X8008ABC");
              }
            }
            k = 1;
          }
        }
      }
      label949:
      if (k != 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().aF = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().aG = b();
        b();
        if ((j()) && (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)))
        {
          localObject = (EffectFaceManager)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
          if (((FaceItem)((EffectFaceManager)localObject).a() != null) && (((EffectFaceManager)localObject).b()) && (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
            TipsUtil.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695760);
          }
        }
        QavRecordReporter.a("0X800863A");
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().aA) {
          QavRecordReporter.a("0X8008ACC");
        }
        if (b()) {
          QavRecordReporter.a("0X8008AB9");
        } else {
          QavRecordReporter.a("0X8008AB8");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().a.size() == 0) {
          QavRecordReporter.a("0X8008ABB");
        }
      }
      else
      {
        QavRecordReporter.a("0X8008AAF");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "record activity.mApp == null  || mVideoController == null");
    }
  }
  
  private void v()
  {
    DoubleVideoCtrlUI localDoubleVideoCtrlUI = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
    if (localDoubleVideoCtrlUI == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      if (localDoubleVideoCtrlUI.i())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      if (d())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() != 3) && (!c()))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() == 3) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (c())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void w()
  {
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar == null) {
      return;
    }
    localVideoNetStateBar.e(this.jdField_c_of_type_Int);
    int j = this.jdField_c_of_type_Int;
    if ((j != 90) && (j != 270) && (c()))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(b() + b(2131297901));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(b(2131297901));
  }
  
  private void x()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  }
  
  int a()
  {
    boolean bool = LiuHaiUtils.b();
    if (c())
    {
      if (bool) {
        return LiuHaiUtils.b((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      return this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d();
    }
    return 0;
  }
  
  public long a()
  {
    long l;
    try
    {
      if (this.jdField_a_of_type_JavaIoFile == null) {
        l = this.jdField_g_of_type_Long;
      } else {
        l = FileSwapHelper.a(this.jdField_a_of_type_JavaIoFile);
      }
    }
    catch (Exception localException)
    {
      l = this.jdField_g_of_type_Long;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getCurrentRecordSize Exception=");
      localStringBuilder2.append(localException.getMessage());
      QLog.d("QavVideoRecordUICtrl", 2, localStringBuilder2.toString());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getCurrentRecordSize=");
      localStringBuilder1.append(l);
      QLog.d("QavVideoRecordUICtrl", 2, localStringBuilder1.toString());
    }
    return l;
  }
  
  public String a(long paramLong)
  {
    if (paramLong == 0L) {
      return this.jdField_c_of_type_JavaLangString;
    }
    int j = (int)(paramLong / 1000L);
    int k = j / 60;
    return String.format(Locale.getDefault(), "%s (%02d:%02d)", new Object[] { this.jdField_b_of_type_JavaLangString, Integer.valueOf(k), Integer.valueOf(j - k * 60) });
  }
  
  public void a()
  {
    b(2);
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeTimeoutMsg");
    localStringBuilder.append(paramInt);
    QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
    }
    QavRecordReporter.b();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeError ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", e=");
    localStringBuilder.append(paramThrowable);
    QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      paramThrowable.printStackTrace();
      QLog.e("QavVideoRecordUICtrl", 1, "onEncodeError ", paramThrowable);
    }
    QavRecordReporter.a(paramInt, paramThrowable);
    this.jdField_f_of_type_Boolean = true;
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 5))
    {
      if (paramInt == 4)
      {
        this.jdField_g_of_type_Boolean = true;
        if (b() >= 1000L) {
          this.jdField_a_of_type_AndroidOsHandler.post(new QavVideoRecordUICtrl.4(this));
        }
      }
    }
    else {
      this.jdField_a_of_type_AndroidOsHandler.post(new QavVideoRecordUICtrl.3(this));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 3);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendRecordMsg ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(paramInt1));
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(paramInt1, paramInt2, 0), 3000L);
    }
  }
  
  public void a(VideoControlUI paramVideoControlUI, int paramInt)
  {
    if (paramVideoControlUI != null)
    {
      if (!(paramVideoControlUI instanceof DoubleVideoCtrlUI)) {
        return;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if ((paramInt != 0) && (this.jdField_d_of_type_Int != 1)) {
        b(2131297949);
      }
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeFinish, filePath[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mDeleteThisVideo[");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    QavRecordReporter.d();
    if (this.jdField_g_of_type_Boolean)
    {
      boolean bool2 = false;
      this.jdField_g_of_type_Boolean = false;
      boolean bool1;
      try
      {
        bool1 = new File(paramString).delete();
      }
      catch (Exception paramString)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("QavVideoRecordUICtrl", 2, "onEncodeFinish", paramString);
          bool1 = bool2;
        }
      }
      paramString = new StringBuilder();
      paramString.append("onEncodeFinish delete=");
      paramString.append(bool1);
      QLog.d("QavVideoRecordUICtrl", 1, paramString.toString());
    }
    else
    {
      FileSwapHelper.a(paramString, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      this.jdField_a_of_type_AndroidOsHandler.post(new QavVideoRecordUICtrl.2(this));
    }
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(String paramString1, String paramString2)
  {
    long l = AudioHelper.b();
    boolean bool = QLog.isColorLevel();
    int k = 1;
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onReceiveRecordMsg, fromUin[");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append("], data[");
      localStringBuilder1.append(paramString2);
      localStringBuilder1.append("], seq[");
      localStringBuilder1.append(l);
      localStringBuilder1.append("]");
      QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder1.toString());
    }
    int j;
    try
    {
      j = Integer.parseInt(paramString2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Qav.Record, onChangeUi_ReceiveRecordMsg, ");
      localStringBuilder2.append(localNumberFormatException.getMessage());
      QLog.i("QavVideoRecordUICtrl", 1, localStringBuilder2.toString());
      j = -1;
    }
    if (j == -1)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=");
      paramString1.append(paramString2);
      QLog.i("QavVideoRecordUICtrl", 1, paramString1.toString());
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if ("SUPPORT_TRUE".equals(paramString2))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().ay = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().af = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.a().af, 730);
        n();
        return;
      }
      if (paramString2.startsWith("SUPPORT_TRUE_7.3.5"))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().ay = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().af = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.a().af, 735);
        j = QavRecordUtils.a(paramString2, this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.h);
        paramString1 = new StringBuilder();
        paramString1.append("onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=");
        paramString1.append(j);
        QLog.i("QavVideoRecordUICtrl", 1, paramString1.toString());
        this.jdField_a_of_type_ComTencentAvVideoController.a().k = (j * 60 * 1000L);
        n();
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      int m = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onChangeUi_ReceiveRecordMsg, session type=");
        paramString2.append(m);
        QLog.i("QavVideoRecordUICtrl", 2, paramString2.toString());
      }
      if ((m != 2) && (m != 1)) {
        return;
      }
      switch (j)
      {
      default: 
        return;
      case 9: 
        a(8);
        return;
      case 6: 
      case 7: 
        a(5);
        return;
      case 5: 
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().az)
        {
          a();
          j = k;
        }
        else
        {
          j = 0;
        }
        if (j != 0) {
          j = 6;
        } else {
          j = 7;
        }
        a(j, false);
        return;
      case 4: 
        a(3);
        return;
      case 3: 
      case 8: 
        this.jdField_a_of_type_ComTencentAvVideoController.a().aA = false;
        if (j == 3)
        {
          a(4, false);
          TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695754);
        }
        else
        {
          a(9, false);
          TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695753);
        }
        m();
        return;
      case 2: 
        a(1);
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().aA = true;
      c(3);
      n();
      b(b());
      a(b(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, true);
      a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      c(true);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(l);
      if (!"self".equalsIgnoreCase(paramString1))
      {
        a(2, false);
        if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isResume()) {
          this.jdField_a_of_type_ComTencentAvVideoController.C();
        } else {
          this.jdField_a_of_type_ComTencentAvVideoController.B();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ad != 0) {
        QavRecordReporter.a("0X8008AC2");
      }
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2))
      {
        paramString1 = (EffectPendantTools)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
        if ((paramString1 != null) && (paramString1.a() != null)) {
          QavRecordReporter.a("0X8008ABC");
        }
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
      return;
    }
    QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, mVideoController == null || mActivity.get().mApp == null");
  }
  
  public void a(boolean paramBoolean)
  {
    f();
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    int j = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    DoubleVideoCtrlUI localDoubleVideoCtrlUI;
    if ((j == 0) && (!b()) && (!LiuHaiUtils.b()))
    {
      localDoubleVideoCtrlUI = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
      j = c();
      int k = a();
      if (paramBoolean)
      {
        paramBoolean = bool1;
        if (!b()) {}
      }
      else
      {
        paramBoolean = true;
      }
      localDoubleVideoCtrlUI.a(j + k, paramBoolean);
    }
    else
    {
      localDoubleVideoCtrlUI = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
      j = c();
      if (paramBoolean)
      {
        paramBoolean = bool2;
        if (!b()) {}
      }
      else
      {
        paramBoolean = true;
      }
      localDoubleVideoCtrlUI.a(j, paramBoolean);
    }
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(-1034L);
    w();
  }
  
  public void a(boolean paramBoolean1, VideoControlUI paramVideoControlUI, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDoubleScreenStatusBar doubleScreen=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", controlUI=");
      localStringBuilder.append(paramVideoControlUI);
      localStringBuilder.append(", showBar=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("QavVideoRecordUICtrl", 2, localStringBuilder.toString());
    }
    q();
  }
  
  public boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  @TargetApi(17)
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = paramInt1;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null) {
      try
      {
        if (f()) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("oom ");
        ((StringBuilder)localObject2).append(localOutOfMemoryError);
        QLog.e("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject2).toString(), localOutOfMemoryError);
      }
    }
    if (paramBoolean) {
      paramInt1 = ScreenLayoutDoubleScreen.b(paramInt1);
    } else {
      paramInt1 = paramInt2;
    }
    this.jdField_d_of_type_JavaLangString = FileSwapHelper.a();
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_d_of_type_JavaLangString);
    this.jdField_g_of_type_Long = 0L;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doNeedStartRecord path=");
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(", w=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", h=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", rh=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject1).toString());
    }
    int m = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_f_of_type_Int;
    paramInt2 = paramInt1;
    int k = j;
    if (j > m)
    {
      float f1 = m * 1.0F / j;
      paramInt2 = (int)(paramInt1 * f1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doNeedStartRecord calc size, maxWidth=");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(", realWidth=");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(", realHeight=");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject1).toString());
      }
      k = m;
    }
    paramInt1 = paramInt2;
    if (paramInt2 % 2 == 1)
    {
      paramInt1 = paramInt2 + 1;
      QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord height+1");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doNeedStartRecord rW=");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append(", rH=");
    ((StringBuilder)localObject1).append(paramInt1);
    QLog.d("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new EncodeConfig(this.jdField_d_of_type_JavaLangString, k, paramInt1, 5120000, 1, false, 0);
    ((EncodeConfig)localObject1).a(EGL14.eglGetCurrentContext());
    Object localObject2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localObject2 != null)
    {
      ((QavVideoAudioRecorder)localObject2).a((EncodeConfig)localObject1, this);
      QavRecordReporter.a();
    }
    else
    {
      a(5, null);
    }
    return new int[] { k, paramInt1 };
  }
  
  int b()
  {
    if (c()) {
      return a() + c();
    }
    return 0;
  }
  
  public long b()
  {
    long l = this.jdField_e_of_type_Long - this.jdField_f_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRealDuration, dur[");
    localStringBuilder.append(l);
    localStringBuilder.append("], UITime[");
    localStringBuilder.append(this.jdField_e_of_type_Long - this.jdField_d_of_type_Long);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    return Math.max(0L, l);
  }
  
  public void b()
  {
    jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Long = (System.currentTimeMillis() - 200L);
    this.jdField_f_of_type_Long = (this.jdField_d_of_type_Long + 99999999L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRecord, mStartTime[");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append("], mRealStartTime[");
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 31457380L;
    t();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 500L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(11, 500L);
    this.jdField_a_of_type_ComTencentAvVideoController.a(0, this);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.a(2, true);
    int k = this.jdField_a_of_type_ComTencentAvVideoController.a(4, true);
    int m = this.jdField_a_of_type_ComTencentAvVideoController.a(2, 48000, 1, 16);
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a(4, 48000, 1, 16);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRecord, after registerAudioDataCallback, ret2=");
    localStringBuilder.append(j);
    localStringBuilder.append(", ret4=");
    localStringBuilder.append(k);
    localStringBuilder.append(", set2=");
    localStringBuilder.append(m);
    localStringBuilder.append(", set4=");
    localStringBuilder.append(n);
    QLog.i("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().aD)
    {
      j = this.jdField_a_of_type_ComTencentAvVideoController.a(3, true);
      k = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecord, registerAudioDataCallback, mix = true, ret3=");
      localStringBuilder.append(j);
      localStringBuilder.append(", set3=");
      localStringBuilder.append(k);
      QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvVideoController.a().aB = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().aC = true;
    }
  }
  
  public void b(int paramInt)
  {
    jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endRecord, stopType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], mStartTime[");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
    ((StringBuilder)localObject).append("], mRealStartTime[");
    ((StringBuilder)localObject).append(this.jdField_f_of_type_Long);
    ((StringBuilder)localObject).append("], mEndTime[");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Long);
    ((StringBuilder)localObject).append("]");
    QLog.w("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
    if (paramInt == 1) {
      a(b());
    } else if (paramInt == 2) {
      b(b());
    } else {
      a(-1L);
    }
    boolean bool;
    if ((b() >= 1000L) && (paramInt == 1)) {
      bool = false;
    } else {
      bool = true;
    }
    this.jdField_g_of_type_Boolean = bool;
    localObject = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localObject != null) {
      ((QavVideoAudioRecorder)localObject).a();
    }
    this.jdField_a_of_type_JavaIoFile = null;
    this.jdField_a_of_type_ComTencentAvVideoController.a(0, null);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.b(2, true);
    int k = this.jdField_a_of_type_ComTencentAvVideoController.b(4, true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endRecord, after unregisterAudioDataCallbackAll, ret2=");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(", ret4=");
    ((StringBuilder)localObject).append(k);
    QLog.i("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().aD)
    {
      j = this.jdField_a_of_type_ComTencentAvVideoController.a(3, false);
      k = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
      this.jdField_a_of_type_ComTencentAvVideoController.a().aB = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().aC = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endRecord, registerAudioDataCallback, mix = true, ret3=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", set3=");
      ((StringBuilder)localObject).append(k);
      QLog.i("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    }
    QavRecordReporter.a(this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r, this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.s, paramInt, b());
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setShowState=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 3)
    {
      p();
      v();
      return;
    }
    this.jdField_d_of_type_Int = 3;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageButton.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(b(2131297942), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    RelativeLayout localRelativeLayout = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).requestLayout();
    }
    if (paramBoolean) {
      d();
    } else {
      v();
    }
    q();
    a(c());
  }
  
  public void b(boolean paramBoolean)
  {
    DoubleVideoCtrlUI localDoubleVideoCtrlUI = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
    if (localDoubleVideoCtrlUI == null) {
      return;
    }
    localDoubleVideoCtrlUI.o(paramBoolean);
  }
  
  public boolean b()
  {
    return (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.i());
  }
  
  public int c()
  {
    return b(2131297949);
  }
  
  public void c()
  {
    b(1);
  }
  
  public void c(int paramInt)
  {
    b(paramInt, true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, this.jdField_a_of_type_ComTencentAvVideoController.a().k);
    }
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Int == 3;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
    if (localObject != null)
    {
      if (((DoubleVideoCtrlUI)localObject).h()) {
        return;
      }
      this.jdField_c_of_type_Int = a(this.jdField_c_of_type_Int);
      f(this.jdField_c_of_type_Int);
      v();
      w();
      if (!c()) {
        return;
      }
      int j = this.jdField_c_of_type_Int;
      if ((j != 90) && (j != 270)) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
        if ((localObject != null) && (!((DoubleVideoCtrlUI)localObject).i()))
        {
          if (d() == 3) {
            j = b(2131297938);
          } else {
            j = b(2131297944);
          }
          localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
          ((RelativeLayout.LayoutParams)localObject).height = j;
          ((RelativeLayout.LayoutParams)localObject).width = j;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(15.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
          localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
          if (localObject != null) {
            ((RelativeLayout)localObject).setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
          }
          if (this.jdField_c_of_type_Int == 90)
          {
            localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
            if (localObject != null) {
              ((RelativeLayout)localObject).setRotation(-90.0F);
            }
            localObject = this.jdField_e_of_type_AndroidWidgetRelativeLayout;
            if (localObject == null) {
              break label354;
            }
            ((RelativeLayout)localObject).setScaleX(1.0F);
            this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
            break label354;
          }
          localObject = this.jdField_e_of_type_AndroidWidgetRelativeLayout;
          if (localObject != null)
          {
            ((RelativeLayout)localObject).setScaleX(-1.0F);
            this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(-1.0F);
          }
          localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
          if (localObject == null) {
            break label354;
          }
          ((RelativeLayout)localObject).setRotation(-90.0F);
          break label354;
        }
      }
      localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      RelativeLayout localRelativeLayout = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null) {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_e_of_type_AndroidWidgetRelativeLayout;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).setScaleX(1.0F);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
      }
      localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (localObject != null) {
        ((RelativeLayout)localObject).setRotation(this.jdField_c_of_type_Int);
      }
      label354:
      q();
      a(c());
    }
  }
  
  public void d(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      a(c());
      s();
    }
  }
  
  public boolean d()
  {
    int j = this.jdField_c_of_type_Int;
    return (j == 90) || (j == 270);
  }
  
  public void e()
  {
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.b();
    }
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  public void e(int paramInt)
  {
    v();
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null)
    {
      if (!c()) {
        return;
      }
      int j = a();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.topMargin = j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("iveswu statusBar:density=");
      localStringBuilder.append(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDisplayMetrics().density);
      QLog.i("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void f(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 90)
      {
        if (paramInt == 180) {
          break label175;
        }
        if (paramInt != 270) {
          return;
        }
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.setMargins(AIOUtils.b(-12.5F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources()), 0, 0, AIOUtils.b(32.5F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources()));
      localLayoutParams.addRule(2, 2131376277);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(6, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      if (paramInt == 90)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(19);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(270.0F);
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(270.0F);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(21);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(90.0F);
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(90.0F);
      return;
    }
    label175:
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.setMargins(AIOUtils.b(10.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources()), 0, 0, 0);
    localLayoutParams.addRule(2, 0);
    localLayoutParams.addRule(1, 2131376277);
    localLayoutParams.addRule(6, 2131376277);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(19);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(21);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(180.0F);
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(paramInt);
  }
  
  public void g()
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeStart");
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void g(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().az;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChangeUI_RecordReceiveEffect ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", recording=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        return;
      }
      int j = 1;
      int k = 1 << paramInt - 1;
      int m = this.jdField_f_of_type_Int;
      if ((m & k) == k)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onChangeUI_RecordReceiveEffect return, type=");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      this.jdField_f_of_type_Int = (k | m);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 2000L);
          QavRecordReporter.a("0X8008ACA");
          return;
        }
        TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695765);
        QavRecordReporter.a("0X8008AC9");
        return;
      }
      localObject = (FaceItem)((EffectFaceManager)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localObject != null) && (((FaceItem)localObject).getId().equalsIgnoreCase("daquan"))) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QavVideoRecordUICtrl.8(this), 2000L);
      } else {
        TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695766);
      }
      QavRecordReporter.a("0X8008AC8");
    }
  }
  
  public boolean g()
  {
    boolean bool;
    if ((!k()) && (f()) && (i()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ay)) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSupportRecord. isSupport = ");
    localStringBuilder.append(bool);
    QLog.i("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void h() {}
  
  public boolean h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((localObject != null) && (((VideoController)localObject).a() != null))
    {
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        return false;
      }
      boolean bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().az;
      boolean bool6 = this.jdField_a_of_type_ComTencentAvVideoController.a().aA;
      boolean bool7 = this.jdField_a_of_type_ComTencentAvVideoController.a().w;
      if (g())
      {
        if (bool1) {
          return true;
        }
        if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
        {
          localObject = (EffectFaceManager)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
          FaceItem localFaceItem = (FaceItem)((EffectFaceManager)localObject).a();
          if (localFaceItem != null)
          {
            bool2 = ((EffectFaceManager)localObject).b();
            bool3 = localFaceItem.isSameType("face");
            bool4 = localFaceItem.isSameType("voicesticker");
            bool1 = true;
            break label181;
          }
        }
        bool1 = false;
        boolean bool2 = false;
        boolean bool3 = false;
        boolean bool4 = false;
        label181:
        if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
        {
          localObject = (EffectZimuManager)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
          if (localObject != null)
          {
            localObject = (ZimuItem)((EffectZimuManager)localObject).a();
            if (localObject != null)
            {
              bool5 = TextUtils.isEmpty(((ZimuItem)localObject).getId()) ^ true;
              break label261;
            }
          }
        }
        boolean bool5 = false;
        label261:
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isEnableRecord. isPlayingMagicFace ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(", isUsingZimu=");
        ((StringBuilder)localObject).append(bool5);
        ((StringBuilder)localObject).append(", isSender=");
        ((StringBuilder)localObject).append(bool2);
        QLog.i("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
        if ((!bool7) && (!bool5) && ((!bool1) || (!bool2) || ((!bool3) && (!bool4)))) {
          return (!bool6) || (this.jdField_a_of_type_ComTencentAvVideoController.a().af >= 735);
        }
      }
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if ((j != 1) && (j != 3) && (j != 5) && (j != 8)) {
      if (j != 14) {
        if (j == 15) {}
      }
    }
    switch (j)
    {
    default: 
      return true;
    case 10: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      if (!jdField_b_of_type_Boolean) {
        return true;
      }
      long l1 = c();
      long l2 = this.jdField_a_of_type_Long;
      if (l1 > l2)
      {
        c();
        l1 = this.jdField_a_of_type_Long / 1000L;
        ReportController.b(null, "CliOper", "", "", "0X800863C", "0X800863C", 0, 0, String.valueOf(l1), "", "", "");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_timeout", true, l1, 0L, null, "", false);
        return true;
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(l1, l2);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(l1));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 500L);
    case 11: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
      if (!jdField_b_of_type_Boolean) {
        return true;
      }
      ThreadManager.postImmediately(new QavVideoRecordUICtrl.1(this), null, false);
      return true;
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695767);
        return true;
        if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i)
        {
          m();
          return true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("on msg time, msg=");
          localStringBuilder.append(paramMessage.what);
          QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
          a(paramMessage.what, false, paramMessage.arg1 - 1);
        }
      }
      break;
    }
    return true;
  }
  
  public void i() {}
  
  public boolean i()
  {
    int j = this.jdField_b_of_type_Int;
    boolean bool2 = true;
    if (j == 0)
    {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r > this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_d_of_type_Int) {
        this.jdField_b_of_type_Int = 2;
      } else if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_d_of_type_Int) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.s >= this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_e_of_type_Int)) {
        this.jdField_b_of_type_Int = 2;
      } else if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r > this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = 1;
      } else if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.s >= this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_c_of_type_Int)) {
        this.jdField_b_of_type_Int = 1;
      } else {
        this.jdField_b_of_type_Int = 3;
      }
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_a_of_type_Int != 1) {
        this.jdField_b_of_type_Int = 4;
      }
      if (jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int = 5;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPerformanceSupport=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    }
    j = this.jdField_b_of_type_Int;
    boolean bool1 = bool2;
    if (j != 2)
    {
      bool1 = bool2;
      if (j != 1)
      {
        if (j == 5) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void j()
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeRealStart, mRealStartTime[");
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append("], StartOffset[");
    localStringBuilder.append(this.jdField_f_of_type_Long - this.jdField_d_of_type_Long);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
  }
  
  public boolean j()
  {
    if (this.jdField_b_of_type_Int == 0) {
      i();
    }
    return this.jdField_b_of_type_Int == 1;
  }
  
  public void k()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("animExpandBar, cur=");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      ((StringBuilder)localObject).append(", mAnimExpanding=");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Boolean);
      QLog.i("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, isRunning");
      }
      return;
    }
    r();
  }
  
  public void l()
  {
    a(5, true);
    a(b(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
    b(true);
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      TipsUtil.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695786);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().aA = false;
    n();
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
    long l = (System.currentTimeMillis() - this.jdField_c_of_type_Long) / 1000L;
    ReportController.b(null, "CliOper", "", "", "0X800863E", "0X800863E", 0, 0, "", String.valueOf(l), "", "");
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "av_record_cancel", true, l, 0L, null, "", false);
    c(1);
  }
  
  public void m()
  {
    long l = AudioHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endBeenRecordedState, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((localObject != null) && (((VideoController)localObject).a() != null) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().aA = false;
      c(1);
      a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_c_of_type_Int);
      b(true);
      a(b(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
      c(false);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endBeenRecordedState something is null: mControlUI=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI);
      QLog.i("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject).toString());
    }
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(l);
    n();
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
    }
    x();
  }
  
  public void n()
  {
    long l = AudioHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateRecordButton, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((localObject != null) && (((VideoController)localObject).a() != null) && (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null) {
        return;
      }
      if (h())
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().az) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(3, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.e());
        } else {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(2, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.e());
        }
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l, 16777215);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(1, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.e());
    }
  }
  
  public void o() {}
  
  public void onClick(View paramView)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onClick");
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton) {
      l();
    } else if (paramView == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView) {
      u();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (jdField_b_of_type_Boolean)
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
      if ((localQavVideoAudioRecorder != null) && (paramInt1 == 100)) {
        localQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl
 * JD-Core Version:    0.7.0.1
 */