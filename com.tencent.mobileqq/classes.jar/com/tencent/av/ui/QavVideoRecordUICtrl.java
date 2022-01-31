package com.tencent.av.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
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
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.funchat.record.FileSwapHelper;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordButtonView.ShowStateChangeListener;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavRecordListener;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.record.QavRecordUtils;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import kbt;
import kbv;
import kbw;
import kbx;
import kby;
import kbz;
import kca;
import kcb;
import kcc;
import kcd;
import kce;

@TargetApi(18)
public class QavVideoRecordUICtrl
  implements Handler.Callback, View.OnClickListener, QavRecordButtonView.ShowStateChangeListener, QavRecordListener, SdkAudioFrameCallback
{
  public static String a;
  public static boolean a;
  public static boolean b;
  public int a;
  public long a;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private DoubleVideoCtrlUI jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
  private VideoLayerUI jdField_a_of_type_ComTencentAvUiVideoLayerUI;
  private VideoNetStateBar jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
  private QavRecordButtonView jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
  public QavRecordDpc a;
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
  private File jdField_a_of_type_JavaIoFile;
  public int b;
  public long b;
  private Animator.AnimatorListener jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener;
  private ValueAnimator.AnimatorUpdateListener jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  public long c;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int = 1;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private RelativeLayout.LayoutParams jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private boolean jdField_f_of_type_Boolean = true;
  private volatile long jdField_g_of_type_Long;
  private RelativeLayout.LayoutParams jdField_g_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private boolean jdField_g_of_type_Boolean;
  private volatile long jdField_h_of_type_Long;
  private RelativeLayout.LayoutParams jdField_h_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private volatile boolean jdField_h_of_type_Boolean;
  private volatile boolean i;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + "/qav_record_test_switch.dat";
  }
  
  public QavVideoRecordUICtrl(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout1, VideoController paramVideoController, VideoLayerUI paramVideoLayerUI, VideoAppInterface paramVideoAppInterface, RelativeLayout paramRelativeLayout2, VideoControlUI paramVideoControlUI)
  {
    this.jdField_a_of_type_Long = 60000L;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = paramVideoLayerUI;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout2;
    if ((paramVideoControlUI instanceof DoubleVideoCtrlUI)) {
      paramAVActivity = (DoubleVideoCtrlUI)paramVideoControlUI;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI = paramAVActivity;
      if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null)
      {
        paramAVActivity = null;
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = paramAVActivity;
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e(true);
        }
        a(paramVideoAppInterface);
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc = QavRecordDpc.a();
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.h * 60 * 1000L);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long < 0L) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        }
      }
      try
      {
        if (f()) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
        }
        paramAVActivity = DeviceInfoUtil.i();
        QLog.i("QavVideoRecordUICtrl", 1, "QavVideoRecordUICtrl manufacture=" + paramAVActivity);
        if (("OPPO".equalsIgnoreCase(paramAVActivity)) || ("vivo".equalsIgnoreCase(paramAVActivity))) {
          this.jdField_e_of_type_Boolean = true;
        }
        return;
        paramAVActivity = null;
        continue;
        paramAVActivity = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
      }
      catch (OutOfMemoryError paramAVActivity)
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
          QLog.e("QavVideoRecordUICtrl", 1, "oom " + paramAVActivity, paramAVActivity);
        }
      }
    }
  }
  
  private int a(int paramInt)
  {
    int j = paramInt;
    if (paramInt != 0)
    {
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break label24;
      }
      j = 0;
    }
    label24:
    do
    {
      do
      {
        return j;
        j = paramInt;
      } while (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null);
      j = paramInt;
    } while (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g());
    return 0;
  }
  
  private void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(paramInt1, paramString, paramLong, paramInt2);
  }
  
  private void a(long paramLong)
  {
    QLog.d("QavVideoRecordUICtrl.Listener", 1, "onRecordEnd time=" + paramLong);
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvVideoController.a().y = false;
    if ((paramLong > 1000L) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.i))
    {
      a(3, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a().t = 0;
    }
    for (;;)
    {
      n();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
      return;
      if (paramLong >= 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kbv(this), 1000L);
        a(1003, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429646), 3000L, 1);
        QavRecordReporter.a("0X8008AB0");
      }
      else if (paramLong < 0L)
      {
        a(3, true);
        a(1003, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429651), 3000L, 1);
        this.jdField_a_of_type_ComTencentAvVideoController.P();
      }
    }
  }
  
  public static void a(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "sendSupportMsg, controller=" + paramVideoController);
    }
    if ((!f()) || (i())) {
      QLog.d("QavVideoRecordUICtrl", 1, "sendSupportMsg, not support");
    }
    while (paramVideoController == null) {
      return;
    }
    paramVideoController.a(8, "SUPPORT_TRUE");
    paramVideoController.a(8, "SUPPORT_TRUE");
    paramVideoController.a(8, "SUPPORT_TRUE_7.3.5#" + QavRecordDpc.a().h);
    paramVideoController.a(8, "SUPPORT_TRUE_7.3.5#" + QavRecordDpc.a().h);
  }
  
  private void a(VideoAppInterface paramVideoAppInterface)
  {
    LayoutInflater.from(this.jdField_a_of_type_ComTencentAvUiAVActivity).inflate(2130969371, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366314));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366315));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366316));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366320));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366319));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366321));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366318);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366317));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363276);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365838);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365840);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365839);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    this.jdField_g_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    this.jdField_h_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setWillNotDraw(false);
    this.jdField_a_of_type_Int = AIOUtils.a(51.0F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources());
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvUiAVActivity.getString(2131429625);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(new kbx(this));
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131365847));
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131365848));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (paramVideoAppInterface.f()) {
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429654));
    }
  }
  
  private int b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getDimensionPixelSize(paramInt);
  }
  
  private void b(long paramLong)
  {
    QLog.d("QavVideoRecordUICtrl.Listener", 1, "onForceStop time=" + paramLong);
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().y = false;
    a(1003, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429630), 3000L, 1);
    this.jdField_a_of_type_ComTencentAvVideoController.P();
    n();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
  }
  
  private long c()
  {
    return System.currentTimeMillis() - this.jdField_d_of_type_Long;
  }
  
  public static boolean f()
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoRecordUICtrl", 2, "isDeviceSupport, apiSupport=" + bool);
      }
      return bool;
    }
  }
  
  private void h(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentAvUiAVActivity.i);
      if (this.jdField_e_of_type_Boolean) {}
      for (paramInt = 2131429648;; paramInt = 2131429647)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 2, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(paramInt), 0).a();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiAVActivity.i);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(1003, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429651), 3000L, 1);
  }
  
  public static boolean i()
  {
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
    if ((localEffectFaceDeviceConfig == null) || (localEffectFaceDeviceConfig.d())) {}
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        QLog.d("QavVideoRecordUICtrl", 1, "isInBlackList device not support");
      }
      if (j != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
    b(false);
    d(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(false);
    this.jdField_d_of_type_Int = 1;
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d())
    {
      if (c())
      {
        if (d())
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
          return;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(false);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
      return;
    }
    if (c())
    {
      if (d())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, cur=" + this.jdField_d_of_type_Int);
    }
    if (this.jdField_d_of_type_Int != 3) {
      QLog.i("QavVideoRecordUICtrl", 1, "animExpandBar, show state not expand");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g()))
      {
        QLog.i("QavVideoRecordUICtrl", 1, "animExpandBar, controlUI is null or toolbar showing");
        return;
      }
      if ((this.jdField_b_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, isRunning");
    return;
    r();
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "doFoldAnim");
    }
    this.i = true;
    int j = AIOUtils.a(7.5F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources());
    int k = AIOUtils.a(64.0F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources());
    int m = b(2131560119);
    int n = b(2131560116);
    int i1 = b(2131560116);
    int i2 = b(2131560114);
    int i3 = b(2131560112);
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener == null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new kcb(this, j, m, n, k, i1, i2, i3);
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener == null) {
      this.jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener = new kcc(this);
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 260 });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(260L);
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "doExpandAnim");
    }
    this.jdField_h_of_type_Boolean = true;
    int j = AIOUtils.a(7.5F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources());
    int k = AIOUtils.a(64.0F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources());
    int m = b(2131560119);
    int n = b(2131560116);
    int i1 = b(2131560116);
    int i2 = b(2131560114);
    int i3 = b(2131560112);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener == null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new kcd(this, j, m + j, n - k, k, i1, i3, i2);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new kce(this);
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
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 1, "clearAnim mAnimExpanding=" + this.jdField_h_of_type_Boolean + ", mAnimFolding=" + this.i);
    }
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    while ((!this.i) || (this.jdField_b_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      try
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + localException1, localException1);
        this.jdField_h_of_type_Boolean = false;
        return;
      }
      finally
      {
        this.jdField_h_of_type_Boolean = false;
        b(3, false);
      }
    }
    try
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + localException2, localException2);
      return;
    }
    finally
    {
      this.i = false;
      b(4, false);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvVideoController.a().y = true;
    a(1, true);
    n();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(0L, this.jdField_a_of_type_Long);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(a(0L));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoRecordUICtrl", 2, "record mActivity.mApp == null  || mVideoController == null");
      }
    }
    label796:
    label998:
    label1255:
    for (;;)
    {
      return;
      QavRecordReporter.a("0X8008AAE");
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().u)
      {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiControlUIObserver.c(2);
        QLog.d("QavVideoRecordUICtrl", 1, "start record, child lock");
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().y)
      {
        c();
        long l = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;
        ReportController.b(null, "CliOper", "", "", "0X800863B", "0X800863B", 0, 0, String.valueOf(l), "", "", "");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "av_record_click_end", true, l, 0L, null, "", false);
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a.clear();
      int j;
      Object localObject;
      if (!f())
      {
        a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429633), 3000L, 1);
        j = 0;
        QLog.d("QavVideoRecordUICtrl", 1, "start record, api not support");
        if (j == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity.g(false);
        this.jdField_a_of_type_ComTencentAvVideoController.a().E = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().F = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d();
        b();
        if ((h()) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)))
        {
          localObject = (EffectFaceManager)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
          if (((FaceItem)((EffectFaceManager)localObject).a() != null) && (((EffectFaceManager)localObject).a())) {
            a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429640), 3000L, 1);
          }
        }
        QavRecordReporter.a("0X800863A");
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().z) {
          QavRecordReporter.a("0X8008ACC");
        }
        if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d()) {
          break label1248;
        }
        QavRecordReporter.a("0X8008AB9");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().a.size() != 0) {
          break label1255;
        }
        QavRecordReporter.a("0X8008ABB");
        return;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().x)
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, friend not support");
          if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) == 5) {
            QavRecordReporter.a("0X8008AB6");
          }
          for (j = 2131429632;; j = 2131429631)
          {
            a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(j), 3000L, 1);
            j = 0;
            break;
            QavRecordReporter.a("0X8008AB5");
          }
        }
        if (!g())
        {
          a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429639), 3000L, 1);
          j = 0;
          QLog.d("QavVideoRecordUICtrl", 1, "start record, isPerformanceSupport==false");
          QavRecordReporter.a("0X8008AB4");
          break;
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().z) && (this.jdField_a_of_type_ComTencentAvVideoController.a().s < 735))
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, friend's old version not support record in same time");
          a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429669), 3000L, 0);
          j = 0;
          break;
        }
        if (!e())
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, last encode not stop");
          a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429641), 3000L, 0);
          j = 0;
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
        {
          localObject = (EffectFaceManager)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
          FaceItem localFaceItem = (FaceItem)((EffectFaceManager)localObject).a();
          if (localFaceItem != null)
          {
            boolean bool1 = ((EffectFaceManager)localObject).a();
            boolean bool2 = "face".equalsIgnoreCase(localFaceItem.getType());
            if ((bool1) && (bool2)) {}
            for (j = 1;; j = 0)
            {
              if (j == 0) {
                break label796;
              }
              a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429636), 3000L, 1);
              j = 0;
              QLog.d("QavVideoRecordUICtrl", 1, "start record, isDoubleScreen");
              QavRecordReporter.a("0X8008AC3");
              break;
            }
            if (!bool2) {
              QavRecordReporter.a("0X8008ABE");
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown()) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a() == 3))
        {
          a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429637), 3000L, 1);
          j = 0;
          QLog.d("QavVideoRecordUICtrl", 1, "start record, using doodle");
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
        {
          localObject = (EffectZimuManager)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
          if (localObject != null)
          {
            localObject = (ZimuItem)((EffectZimuManager)localObject).a();
            if (localObject != null)
            {
              if (!TextUtils.isEmpty(((ZimuItem)localObject).getId())) {}
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label998;
                }
                a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429638), 3000L, 1);
                j = 0;
                QLog.d("QavVideoRecordUICtrl", 1, "start record, usingZimu");
                QavRecordReporter.a("0X8008AD2");
                break;
              }
            }
          }
        }
        if (FileSwapHelper.a() < 31457280L)
        {
          a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429650), 3000L, 1);
          j = 0;
          QLog.d("QavVideoRecordUICtrl", 1, "start record, STORAGE_LEFT_MIN_SIZE not enough");
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().S != 0)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(0));
          QavRecordReporter.a("0X8008AC1");
        }
        if ((RedBagUtil.a()) && (RedBagUtil.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface).c()))
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, redbag PeerInSendMode");
          this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(2));
          QavRecordReporter.a("0X8008AC0");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().p)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(3));
          QavRecordReporter.a("0X8008ABF");
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2))
        {
          localObject = (EffectPendantTools)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
          if ((localObject != null) && (((EffectPendantTools)localObject).a() != null))
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(6));
            QavRecordReporter.a("0X8008ABC");
          }
        }
        j = 1;
        break;
        QavRecordReporter.a("0X8008AB8");
      }
    }
    label1248:
    QavRecordReporter.a("0X8008AAF");
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g())
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (d())
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() == 3) || (c()))
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() == 3) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
    while (c())
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(this.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Int != 90) && (this.jdField_c_of_type_Int != 270) && (c()))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(b(2131560109) + AIOUtils.a(15.0F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources()));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(AIOUtils.a(15.0F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources()));
  }
  
  private void y()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int a(VideoLayerUI paramVideoLayerUI)
  {
    int j = 0;
    if (paramVideoLayerUI == null) {
      return 0;
    }
    if (this.jdField_d_of_type_Int != 1) {
      j = b(2131560109);
    }
    if (j == 0) {}
    for (int k = -1;; k = j)
    {
      paramVideoLayerUI.jdField_a_of_type_Int = k;
      return j;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    int k = 0;
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!b())
      {
        j = k;
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getRotation() == 0.0F) {
          j = b(2131560109);
        }
      }
    }
    return j;
  }
  
  public long a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile == null) {}
      for (l = this.jdField_g_of_type_Long;; l = FileSwapHelper.a(this.jdField_a_of_type_JavaIoFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize=" + l);
        }
        return l;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = this.jdField_g_of_type_Long;
        QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize Exception=" + localException.getMessage());
      }
    }
  }
  
  public String a(long paramLong)
  {
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
    QLog.d("QavVideoRecordUICtrl", 1, "removeTimeoutMsg" + paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
    }
    QavRecordReporter.b();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeError " + paramInt + ", e=" + paramThrowable);
    if (QLog.isColorLevel())
    {
      paramThrowable.printStackTrace();
      QLog.e("QavVideoRecordUICtrl", 1, "onEncodeError ", paramThrowable);
    }
    QavRecordReporter.a(paramInt, paramThrowable);
    this.jdField_f_of_type_Boolean = true;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 5)) {}
    do
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new kbz(this));
      do
      {
        return;
      } while (paramInt != 4);
      this.jdField_g_of_type_Boolean = true;
    } while (b() < 1000L);
    this.jdField_a_of_type_AndroidOsHandler.post(new kca(this));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 3);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "sendRecordMsg " + paramInt1 + ", " + paramBoolean + ", " + paramInt2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(paramInt1));
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0), 3000L);
    }
  }
  
  public void a(VideoControlUI paramVideoControlUI)
  {
    Object localObject = null;
    QLog.i("QavVideoRecordUICtrl", 1, "resetControlUI, ctrlUI=" + paramVideoControlUI);
    if (paramVideoControlUI == null) {
      return;
    }
    if ((paramVideoControlUI instanceof DoubleVideoCtrlUI))
    {
      paramVideoControlUI = (DoubleVideoCtrlUI)paramVideoControlUI;
      label45:
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI = paramVideoControlUI;
      if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null) {
        break label85;
      }
    }
    label85:
    for (paramVideoControlUI = localObject;; paramVideoControlUI = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvUiVideoNetStateBar)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = paramVideoControlUI;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e(true);
      return;
      paramVideoControlUI = null;
      break label45;
    }
  }
  
  public void a(VideoControlUI paramVideoControlUI, int paramInt)
  {
    boolean bool = false;
    if ((paramVideoControlUI == null) || (!(paramVideoControlUI instanceof DoubleVideoCtrlUI))) {
      return;
    }
    if ((paramInt == 90) || (paramInt == 270))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label81;
      }
      if (this.jdField_d_of_type_Int == 1) {
        break label76;
      }
      paramInt = b(2131560109);
    }
    for (;;)
    {
      paramVideoControlUI = (DoubleVideoCtrlUI)paramVideoControlUI;
      if (this.jdField_d_of_type_Int != 1) {
        bool = true;
      }
      paramVideoControlUI.a(bool, paramInt);
      return;
      paramInt = 0;
      break;
      label76:
      paramInt = 0;
      continue;
      label81:
      paramInt = 0;
    }
  }
  
  public void a(String paramString)
  {
    boolean bool2 = false;
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeFinish filePath=" + paramString + ", delete=" + this.jdField_g_of_type_Boolean);
    QavRecordReporter.d();
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_g_of_type_Boolean = false;
    }
    for (;;)
    {
      try
      {
        bool1 = new File(paramString).delete();
        QLog.d("QavVideoRecordUICtrl", 1, "onEncodeFinish delete=" + bool1);
        this.jdField_f_of_type_Boolean = true;
        return;
      }
      catch (Exception paramString)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QavVideoRecordUICtrl", 2, "onEncodeFinish", paramString);
        bool1 = bool2;
        continue;
      }
      FileSwapHelper.a(paramString, this.jdField_a_of_type_ComTencentAvUiAVActivity);
      this.jdField_a_of_type_AndroidOsHandler.post(new kby(this));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "Qav.Record, onChangeUi_ReceiveRecordMsg, from=" + paramString1 + ", data=" + paramString2);
    }
    int k;
    do
    {
      try
      {
        j = Integer.parseInt(paramString2);
        if (j == -1)
        {
          QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=" + paramString2);
          if (TextUtils.isEmpty(paramString2)) {
            return;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        do
        {
          for (;;)
          {
            QLog.i("QavVideoRecordUICtrl", 1, "Qav.Record, onChangeUi_ReceiveRecordMsg, " + localNumberFormatException.getMessage());
            j = -1;
          }
          if ("SUPPORT_TRUE".equals(paramString2))
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().x = true;
            this.jdField_a_of_type_ComTencentAvVideoController.a().s = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.a().s, 730);
            n();
            return;
          }
        } while (!paramString2.startsWith("SUPPORT_TRUE_7.3.5"));
        this.jdField_a_of_type_ComTencentAvVideoController.a().x = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().s = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.a().s, 735);
        j = QavRecordUtils.a(paramString2, this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.h);
        QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + j);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long = (j * 60 * 1000L);
        n();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null))
      {
        QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, mVideoController == null || mActivity.mApp == null");
        return;
      }
      k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "onChangeUi_ReceiveRecordMsg, session type=" + k);
      }
    } while ((k != 2) && (k != 1));
    switch (j)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentAvVideoController.a().z = true;
      c(3);
      n();
      c(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d());
      a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, true);
      a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      d(true);
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null) && (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g())) {
        a(true, 5000L);
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.m();
      if (!"self".equalsIgnoreCase(paramString1))
      {
        a(2, false);
        if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.isResume()) {
          break label646;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.P();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().S != 0) {
          QavRecordReporter.a("0X8008AC2");
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2))
        {
          paramString1 = (EffectPendantTools)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
          if ((paramString1 != null) && (paramString1.a() != null)) {
            QavRecordReporter.a("0X8008ABC");
          }
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.O();
      }
    case 2: 
      a(1);
      return;
    case 3: 
    case 8: 
      this.jdField_a_of_type_ComTencentAvVideoController.a().z = false;
      if (j == 3)
      {
        a(4, false);
        a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429652), 3000L, 0);
      }
      for (;;)
      {
        m();
        return;
        a(9, false);
        a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429653), 3000L, 0);
      }
    case 4: 
      a(3);
      return;
    case 5: 
      label646:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().y) {
        a();
      }
      break;
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (j = 6;; j = 7)
      {
        a(j, false);
        return;
      }
      a(5);
      return;
      a(8);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 500L);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "autoFold USE_FOLD_ANIM=true");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
    if ((paramBoolean) && (this.jdField_d_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null) && (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g()))
    {
      if (paramLong == 0L) {
        q();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(13, paramLong);
  }
  
  public void a(boolean paramBoolean1, VideoControlUI paramVideoControlUI, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "setDoubleScreenStatusBar doubleScreen=" + paramBoolean1 + ", controlUI=" + paramVideoControlUI + ", showBar=" + paramBoolean2);
    }
    p();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) && (paramInt1 == 100)) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  @TargetApi(17)
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null) {}
    try
    {
      if (f()) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
      }
      if (paramBoolean)
      {
        j = ScreenLayoutDoubleScreen.b(paramInt1);
        this.jdField_c_of_type_JavaLangString = FileSwapHelper.a();
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_c_of_type_JavaLangString);
        this.jdField_g_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord path=" + this.jdField_c_of_type_JavaLangString + ", w=" + paramInt1 + ", h=" + paramInt2 + ", rh=" + j);
        }
        paramInt2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_f_of_type_Int;
        if (paramInt1 > paramInt2)
        {
          float f1 = 1.0F * paramInt2 / paramInt1;
          int k = (int)(j * f1);
          j = k;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord calc size, maxWidth=" + paramInt2 + ", realWidth=" + paramInt2 + ", realHeight=" + k);
            paramInt1 = paramInt2;
            j = k;
          }
          if (j % 2 == 1)
          {
            paramInt2 = j + 1;
            QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord height+1");
            QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord rW=" + paramInt1 + ", rH=" + paramInt2);
            EncodeConfig localEncodeConfig = new EncodeConfig(this.jdField_c_of_type_JavaLangString, paramInt1, paramInt2, 5120000, 1, false, 0);
            localEncodeConfig.a(EGL14.eglGetCurrentContext());
            if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null)
            {
              this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(localEncodeConfig, this);
              QavRecordReporter.a();
              return new int[] { paramInt1, paramInt2 };
            }
          }
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
        QLog.e("QavVideoRecordUICtrl", 1, "oom " + localOutOfMemoryError, localOutOfMemoryError);
        continue;
        a(5, null);
        continue;
        paramInt2 = j;
        continue;
        continue;
        int j = paramInt2;
      }
    }
  }
  
  public int b()
  {
    return a(c());
  }
  
  public long b()
  {
    long l = this.jdField_e_of_type_Long - this.jdField_f_of_type_Long;
    QLog.d("QavVideoRecordUICtrl", 2, "getRealDuration=" + l);
    return Math.max(0L, l);
  }
  
  public void b()
  {
    QLog.d("QavVideoRecordUICtrl", 1, "startRecord");
    jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Long = (System.currentTimeMillis() - 200L);
    this.jdField_f_of_type_Long = (this.jdField_d_of_type_Long + 99999999L);
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 31457380L;
    u();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 500L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(11, 500L);
    this.jdField_a_of_type_ComTencentAvVideoController.a(0, this);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.a(2, true);
    int k = this.jdField_a_of_type_ComTencentAvVideoController.a(4, true);
    int m = this.jdField_a_of_type_ComTencentAvVideoController.a(2, 48000, 1, 16);
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a(4, 48000, 1, 16);
    QLog.i("QavVideoRecordUICtrl", 1, "startRecord, after registerDAudioDataCallback, ret2=" + j + ", ret4=" + k + ", set2=" + m + ", set4=" + n);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().C)
    {
      j = this.jdField_a_of_type_ComTencentAvVideoController.a(3, true);
      k = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
      QLog.d("QavVideoRecordUICtrl", 1, "startRecord, registerDAudioDataCallback, mix = true, ret3=" + j + ", set3=" + k);
      this.jdField_a_of_type_ComTencentAvVideoController.a().A = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().B = true;
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "endRecord");
    jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
    if (paramInt == 1)
    {
      a(b());
      if ((b() >= 1000L) && (paramInt == 1)) {
        break label314;
      }
    }
    label314:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a();
      }
      this.jdField_a_of_type_JavaIoFile = null;
      this.jdField_a_of_type_ComTencentAvVideoController.a(0, null);
      int j = this.jdField_a_of_type_ComTencentAvVideoController.b(2, true);
      int k = this.jdField_a_of_type_ComTencentAvVideoController.b(4, true);
      QLog.i("QavVideoRecordUICtrl", 1, "endRecord, after unregisterDAudioDataCallbackAll, ret2=" + j + ", ret4=" + k);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().C)
      {
        j = this.jdField_a_of_type_ComTencentAvVideoController.a(3, false);
        k = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
        this.jdField_a_of_type_ComTencentAvVideoController.a().A = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().B = false;
        QLog.i("QavVideoRecordUICtrl", 1, "endRecord, registerDAudioDataCallback, mix = true, ret3=" + j + ", set3=" + k);
      }
      QavRecordReporter.a(this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.l, this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.m, paramInt, b());
      return;
      if (paramInt == 2)
      {
        b(b());
        break;
      }
      a(-1L);
      break;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "setShowState=" + paramInt);
    switch (paramInt)
    {
    default: 
      o();
      w();
      return;
    case 3: 
      this.jdField_d_of_type_Int = 3;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(b(2131560117), 0, 0, 0);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(b(2131560119), 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      paramInt = b(2131560116);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = b(2131560114);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(paramInt, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(paramInt, 0, 0, 0);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = b(2131560114);
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = -2;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = -2;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      a(true);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.requestLayout();
      if (paramBoolean) {
        d();
      }
      for (;;)
      {
        p();
        b(c());
        return;
        w();
      }
    }
    this.jdField_d_of_type_Int = 4;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(b(2131560118), 0, 0, 0);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(0, 0, 0, 0);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = b(2131560112);
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = -2;
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = -2;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    a(true);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.requestLayout();
    if (paramBoolean) {
      d();
    }
    for (;;)
    {
      p();
      b(c());
      return;
      w();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
    if ((!paramBoolean) || (b())) {}
    for (boolean bool = true;; bool = false)
    {
      ((DoubleVideoCtrlUI)localObject).k(bool);
      localObject = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131362541);
      if (localObject != null) {
        ((RedPacketGameView)localObject).setScoreMarginTop(a(paramBoolean));
      }
      x();
      f();
      return;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d());
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
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.r(paramBoolean);
  }
  
  public boolean c()
  {
    return (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "updateBarRotation mCurRotate=" + this.jdField_c_of_type_Int + ", showState=" + this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {}
    do
    {
      return;
      this.jdField_c_of_type_Int = a(this.jdField_c_of_type_Int);
      f(this.jdField_c_of_type_Int);
      w();
      x();
    } while (!c());
    int j;
    if ((this.jdField_c_of_type_Int == 90) || (this.jdField_c_of_type_Int == 270))
    {
      j = 1;
      if ((j == 0) || (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g())) {
        break label301;
      }
      if (a() != 3) {
        break label257;
      }
      j = b(2131560120);
      label149:
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = j;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = j;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = AIOUtils.a(15.0F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources());
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      if (this.jdField_c_of_type_Int != 90) {
        break label268;
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setRotation(-90.0F);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
    }
    for (;;)
    {
      p();
      b(c());
      a(true, 50L);
      return;
      j = 0;
      break;
      label257:
      j = b(2131560121);
      break label149;
      label268:
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleX(-1.0F);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(-1.0F);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setRotation(-90.0F);
      continue;
      label301:
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = -2;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = -2;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = 0;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setRotation(this.jdField_c_of_type_Int);
    }
  }
  
  public void d(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      b(c());
      t();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
    } while (!paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long);
  }
  
  public boolean d()
  {
    return (this.jdField_c_of_type_Int == 90) || (this.jdField_c_of_type_Int == 270);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.b();
    }
  }
  
  public void e(int paramInt)
  {
    w();
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (!c())) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if ((b()) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g())) {}
    for (localLayoutParams.topMargin = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.b();; localLayoutParams.topMargin = 0)
    {
      QLog.i("QavVideoRecordUICtrl", 1, "iveswu statusBar:density=" + this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getDisplayMetrics().density);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl.Listener", 2, "onSetRotation r=" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 180: 
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.setMargins(AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources()), 0, 0, 0);
      localLayoutParams.addRule(2, 0);
      localLayoutParams.addRule(1, 2131365847);
      localLayoutParams.addRule(6, 2131365847);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(19);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(paramInt);
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(21);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(180.0F);
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.setMargins(AIOUtils.a(-12.5F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources()), 0, 0, AIOUtils.a(32.5F, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources()));
    localLayoutParams.addRule(2, 2131365847);
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
  }
  
  public void g()
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeStart");
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void g(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {}
    int j;
    do
    {
      boolean bool;
      do
      {
        return;
        bool = this.jdField_a_of_type_ComTencentAvVideoController.a().y;
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect " + paramInt + ", recording=" + bool);
        }
      } while ((!bool) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
      j = 1 << paramInt - 1;
      if ((this.jdField_f_of_type_Int & j) != j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect return, type=" + paramInt);
    return;
    this.jdField_f_of_type_Int = (j | this.jdField_f_of_type_Int);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      FaceItem localFaceItem = (FaceItem)((EffectFaceManager)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.getId().equalsIgnoreCase("daquan"))) {
        break;
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kbw(this), 2000L);
      }
      for (;;)
      {
        QavRecordReporter.a("0X8008AC8");
        return;
        a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429644), 2000L, 0);
      }
      a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429642), 3000L, 0);
      QavRecordReporter.a("0X8008AC9");
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 2000L);
      QavRecordReporter.a("0X8008ACA");
      return;
    }
  }
  
  public boolean g()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.l <= this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_d_of_type_Int) {
        break label111;
      }
      this.jdField_b_of_type_Int = 2;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_a_of_type_Int != 1) {
        this.jdField_b_of_type_Int = 4;
      }
      if (jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int = 5;
      }
      QLog.d("QavVideoRecordUICtrl", 1, "isPerformanceSupport=" + this.jdField_b_of_type_Int);
      if ((this.jdField_b_of_type_Int != 2) && (this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 5)) {
        break;
      }
      return true;
      label111:
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.l == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_d_of_type_Int) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.m >= this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_e_of_type_Int)) {
        this.jdField_b_of_type_Int = 2;
      } else if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.l > this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = 1;
      } else if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.l == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.m >= this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_c_of_type_Int)) {
        this.jdField_b_of_type_Int = 1;
      } else {
        this.jdField_b_of_type_Int = 3;
      }
    }
    return false;
  }
  
  public void h() {}
  
  public boolean h()
  {
    if (this.jdField_b_of_type_Int == 0) {
      g();
    }
    return this.jdField_b_of_type_Int == 1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      if (!jdField_b_of_type_Boolean) {
        return true;
      }
      long l = c();
      if (l > this.jdField_a_of_type_Long)
      {
        c();
        l = this.jdField_a_of_type_Long / 1000L;
        ReportController.b(null, "CliOper", "", "", "0X800863C", "0X800863C", 0, 0, String.valueOf(l), "", "", "");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "av_record_timeout", true, l, 0L, null, "", false);
        return true;
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(l, this.jdField_a_of_type_Long);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(a(l));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 500L);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
      if (!jdField_b_of_type_Boolean) {
        return true;
      }
      ThreadManager.postImmediately(new kbt(this), null, false);
      continue;
      QLog.d("QavVideoRecordUICtrl", 1, "on msg time, msg=" + paramMessage.what);
      a(paramMessage.what, false, paramMessage.arg1 - 1);
      continue;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
      if (this.jdField_d_of_type_Int != 1)
      {
        this.jdField_e_of_type_Int += 1;
        if (this.jdField_e_of_type_Int % 2 == 1) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 500L);
          break;
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        q();
        continue;
        if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.i)
        {
          m();
          continue;
          a(1004, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429643), 3000L, 0);
        }
      }
    }
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, cur=" + this.jdField_d_of_type_Int + ", mAnimExpanding=" + this.jdField_h_of_type_Boolean);
    }
    a(false, 0L);
    if ((this.jdField_d_of_type_Int != 4) || (this.jdField_h_of_type_Boolean)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, isRunning");
    return;
    s();
  }
  
  public void l()
  {
    a(5, true);
    a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
    c(true);
    a(1003, this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getString(2131429628), 3000L, 0);
    this.jdField_a_of_type_ComTencentAvVideoController.a().z = false;
    n();
    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
    long l = (System.currentTimeMillis() - this.jdField_c_of_type_Long) / 1000L;
    ReportController.b(null, "CliOper", "", "", "0X800863E", "0X800863E", 0, 0, "", String.valueOf(l), "", "");
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "av_record_cancel", true, l, 0L, null, "", false);
    c(1);
  }
  
  public void m()
  {
    QLog.i("QavVideoRecordUICtrl", 1, "endBeenRecordedState");
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().z = false;
      c(1);
      a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_c_of_type_Int);
      c(true);
      a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
      d(false);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.m();
      n();
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
      }
      y();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "endBeenRecordedState something is null: mControlUI=" + this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI);
      }
    }
  }
  
  public void n()
  {
    QLog.i("QavVideoRecordUICtrl", 1, "updateRecordButton");
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().x;
    boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().y;
    boolean bool4 = this.jdField_a_of_type_ComTencentAvVideoController.a().z;
    boolean bool3 = g();
    boolean bool6 = f();
    boolean bool5 = this.jdField_a_of_type_ComTencentAvVideoController.a().u;
    label130:
    Object localObject;
    if ((bool1) && (bool6) && (bool3))
    {
      if (bool2)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(3, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f());
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() != 1) {
          break label431;
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity.g(false);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)) {
        break label438;
      }
      localObject = (EffectFaceManager)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
      FaceItem localFaceItem = (FaceItem)((EffectFaceManager)localObject).a();
      if (localFaceItem == null) {
        break label438;
      }
      bool2 = ((EffectFaceManager)localObject).a();
      bool1 = "face".equalsIgnoreCase(localFaceItem.getType());
    }
    for (bool3 = true;; bool3 = false)
    {
      int j;
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
      {
        localObject = (EffectZimuManager)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
        if (localObject != null)
        {
          localObject = (ZimuItem)((EffectZimuManager)localObject).a();
          if (localObject != null) {
            if (!TextUtils.isEmpty(((ZimuItem)localObject).getId())) {
              j = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "updateRecordButton isPlayingMagicFace " + bool3 + ", isSender=" + bool2);
        }
        if ((bool5) || (j != 0) || ((bool3) && (bool2) && (bool1)) || ((bool4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().s < 735)))
        {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(1, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f());
          break label130;
          j = 0;
          continue;
        }
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(2, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f());
        break label130;
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(1, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f());
        break label130;
        label431:
        break;
        j = 0;
      }
      label438:
      bool1 = false;
      bool2 = false;
    }
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onClick");
    if (paramView == this.jdField_d_of_type_AndroidWidgetTextView) {
      l();
    }
    while (paramView != this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView) {
      return;
    }
    v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl
 * JD-Core Version:    0.7.0.1
 */