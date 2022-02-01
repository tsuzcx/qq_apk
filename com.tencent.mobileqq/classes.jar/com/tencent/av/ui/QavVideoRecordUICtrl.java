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
  public static boolean b = false;
  public static boolean d = false;
  private RelativeLayout.LayoutParams A;
  private RelativeLayout.LayoutParams B;
  private QavRecordButtonView C;
  private TextView D;
  private LinearLayout E;
  private boolean F = true;
  private int G = 0;
  private long H = 0L;
  private long I = 0L;
  private long J = 0L;
  private int K = 1;
  private Handler L;
  private String M;
  private String N;
  private volatile long O;
  private volatile long P;
  private QavVideoAudioRecorder Q = null;
  private String R = null;
  private File S = null;
  private boolean T = false;
  private int U = 0;
  private VideoController V;
  private DoubleVideoCtrlUI W;
  private VideoNetStateBar X;
  private int Y = 0;
  private ValueAnimator Z = null;
  private ValueAnimator.AnimatorUpdateListener aa = null;
  private Animator.AnimatorListener ab = null;
  private volatile boolean ac = false;
  private ValueAnimator ad = null;
  private ValueAnimator.AnimatorUpdateListener ae = null;
  private Animator.AnimatorListener af = null;
  private volatile boolean ag = false;
  public long c = 60000L;
  public int e = 0;
  public long f = 0L;
  public long g = 0L;
  public boolean h = false;
  public boolean i = false;
  public QavRecordDpc j;
  public int k = 0;
  private boolean l = false;
  private WeakReference<AVActivity> m;
  private RelativeLayout n;
  private RelativeLayout o;
  private RelativeLayout p;
  private RelativeLayout q;
  private RelativeLayout r;
  private TextView s;
  private ImageButton t;
  private View u;
  private View v;
  private View w;
  private RelativeLayout.LayoutParams x;
  private RelativeLayout.LayoutParams y;
  private RelativeLayout.LayoutParams z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append("/qav_record_test_switch.dat");
    a = localStringBuilder.toString();
  }
  
  public QavVideoRecordUICtrl(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout1, VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, RelativeLayout paramRelativeLayout2, VideoControlUI paramVideoControlUI)
  {
    this.m = new WeakReference(paramAVActivity);
    this.n = paramRelativeLayout1;
    this.L = new Handler(this);
    this.V = paramVideoController;
    this.o = paramRelativeLayout2;
    if ((paramVideoControlUI instanceof DoubleVideoCtrlUI)) {
      paramAVActivity = (DoubleVideoCtrlUI)paramVideoControlUI;
    } else {
      paramAVActivity = null;
    }
    this.W = paramAVActivity;
    paramAVActivity = this.W;
    if (paramAVActivity == null) {
      paramAVActivity = null;
    } else {
      paramAVActivity = paramAVActivity.aE;
    }
    this.X = paramAVActivity;
    paramAVActivity = this.X;
    if (paramAVActivity != null) {
      paramAVActivity.e(true);
    }
    a(paramVideoAppInterface);
    this.j = QavRecordDpc.a();
    this.c = (this.j.i * 60 * 1000L);
    if (this.V.k().cC < 0L) {
      this.V.k().cC = this.c;
    }
    try
    {
      if (v()) {
        this.Q = new QavVideoAudioRecorder();
      }
    }
    catch (OutOfMemoryError paramAVActivity)
    {
      this.Q = null;
      paramRelativeLayout1 = new StringBuilder();
      paramRelativeLayout1.append("oom ");
      paramRelativeLayout1.append(paramAVActivity);
      QLog.e("QavVideoRecordUICtrl", 1, paramRelativeLayout1.toString(), paramAVActivity);
    }
    paramAVActivity = DeviceInfoUtil.t();
    paramRelativeLayout1 = new StringBuilder();
    paramRelativeLayout1.append("QavVideoRecordUICtrl manufacture=");
    paramRelativeLayout1.append(paramAVActivity);
    QLog.i("QavVideoRecordUICtrl", 1, paramRelativeLayout1.toString());
    if (("OPPO".equalsIgnoreCase(paramAVActivity)) || ("vivo".equalsIgnoreCase(paramAVActivity))) {
      this.l = true;
    }
  }
  
  public static boolean A()
  {
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.g();
    int i1;
    if ((localEffectFaceDeviceConfig != null) && (!localEffectFaceDeviceConfig.b())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0) {
      QLog.d("QavVideoRecordUICtrl", 1, "isInBlackList device not support");
    }
    return i1 ^ 0x1;
  }
  
  private long G()
  {
    return Math.max(0L, System.currentTimeMillis() - this.J);
  }
  
  private void H()
  {
    this.K = 1;
    this.L.removeMessages(1);
    a(false);
    c(false);
    this.p.setVisibility(8);
  }
  
  private void I()
  {
    if (this.W != null)
    {
      if (((AVActivity)this.m.get()).L == null) {
        return;
      }
      if (d())
      {
        if (i())
        {
          if (p())
          {
            this.W.a(true);
            return;
          }
          this.W.a(false);
          return;
        }
        this.W.a(true);
      }
    }
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "doExpandAnim");
    }
    this.ac = true;
    AIOUtils.b(7.5F, ((AVActivity)this.m.get()).getResources());
    AIOUtils.b(64.0F, ((AVActivity)this.m.get()).getResources());
    i(2131298612);
    i(2131298609);
    i(2131298609);
    i(2131298611);
    i(2131298616);
    if (this.aa == null) {
      this.aa = new QavVideoRecordUICtrl.5(this);
    }
    if (this.ab == null) {
      this.ab = new QavVideoRecordUICtrl.6(this);
    }
    if (this.Z == null)
    {
      this.Z = ValueAnimator.ofInt(new int[] { 0, 260 });
      this.Z.setDuration(260L);
    }
    this.Z.removeAllListeners();
    this.Z.removeAllUpdateListeners();
    this.Z.addUpdateListener(this.aa);
    this.Z.addListener(this.ab);
    if (this.Z.isRunning()) {
      this.Z.cancel();
    }
    this.Z.start();
  }
  
  /* Error */
  private void K()
  {
    // Byte code:
    //   0: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +56 -> 59
    //   6: new 100	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc_w 411
    //   18: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 187	com/tencent/av/ui/QavVideoRecordUICtrl:ac	Z
    //   27: invokevirtual 414	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_1
    //   32: ldc_w 416
    //   35: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: aload_0
    //   41: getfield 195	com/tencent/av/ui/QavVideoRecordUICtrl:ag	Z
    //   44: invokevirtual 414	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: ldc_w 263
    //   51: iconst_1
    //   52: aload_1
    //   53: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 187	com/tencent/av/ui/QavVideoRecordUICtrl:ac	Z
    //   63: ifeq +112 -> 175
    //   66: aload_0
    //   67: getfield 181	com/tencent/av/ui/QavVideoRecordUICtrl:Z	Landroid/animation/ValueAnimator;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +103 -> 175
    //   75: aload_1
    //   76: invokevirtual 401	android/animation/ValueAnimator:isRunning	()Z
    //   79: ifeq +96 -> 175
    //   82: aload_0
    //   83: getfield 181	com/tencent/av/ui/QavVideoRecordUICtrl:Z	Landroid/animation/ValueAnimator;
    //   86: invokevirtual 390	android/animation/ValueAnimator:removeAllUpdateListeners	()V
    //   89: aload_0
    //   90: getfield 181	com/tencent/av/ui/QavVideoRecordUICtrl:Z	Landroid/animation/ValueAnimator;
    //   93: invokevirtual 387	android/animation/ValueAnimator:removeAllListeners	()V
    //   96: aload_0
    //   97: getfield 181	com/tencent/av/ui/QavVideoRecordUICtrl:Z	Landroid/animation/ValueAnimator;
    //   100: invokevirtual 404	android/animation/ValueAnimator:cancel	()V
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 187	com/tencent/av/ui/QavVideoRecordUICtrl:ac	Z
    //   108: aload_0
    //   109: iconst_3
    //   110: iconst_0
    //   111: invokevirtual 419	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   114: return
    //   115: astore_1
    //   116: goto +46 -> 162
    //   119: astore_1
    //   120: new 100	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   127: astore_2
    //   128: aload_2
    //   129: ldc_w 421
    //   132: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: aload_1
    //   138: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc_w 263
    //   145: iconst_1
    //   146: aload_2
    //   147: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: aload_1
    //   151: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 187	com/tencent/av/ui/QavVideoRecordUICtrl:ac	Z
    //   159: goto -56 -> 103
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 187	com/tencent/av/ui/QavVideoRecordUICtrl:ac	Z
    //   167: aload_0
    //   168: iconst_3
    //   169: iconst_0
    //   170: invokevirtual 419	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   173: aload_1
    //   174: athrow
    //   175: aload_0
    //   176: getfield 195	com/tencent/av/ui/QavVideoRecordUICtrl:ag	Z
    //   179: ifeq +107 -> 286
    //   182: aload_0
    //   183: getfield 189	com/tencent/av/ui/QavVideoRecordUICtrl:ad	Landroid/animation/ValueAnimator;
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +98 -> 286
    //   191: aload_1
    //   192: invokevirtual 401	android/animation/ValueAnimator:isRunning	()Z
    //   195: ifeq +91 -> 286
    //   198: aload_0
    //   199: getfield 189	com/tencent/av/ui/QavVideoRecordUICtrl:ad	Landroid/animation/ValueAnimator;
    //   202: invokevirtual 390	android/animation/ValueAnimator:removeAllUpdateListeners	()V
    //   205: aload_0
    //   206: getfield 189	com/tencent/av/ui/QavVideoRecordUICtrl:ad	Landroid/animation/ValueAnimator;
    //   209: invokevirtual 387	android/animation/ValueAnimator:removeAllListeners	()V
    //   212: aload_0
    //   213: getfield 189	com/tencent/av/ui/QavVideoRecordUICtrl:ad	Landroid/animation/ValueAnimator;
    //   216: invokevirtual 404	android/animation/ValueAnimator:cancel	()V
    //   219: aload_0
    //   220: iconst_0
    //   221: putfield 195	com/tencent/av/ui/QavVideoRecordUICtrl:ag	Z
    //   224: aload_0
    //   225: iconst_3
    //   226: iconst_0
    //   227: invokevirtual 419	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   230: return
    //   231: astore_1
    //   232: goto +41 -> 273
    //   235: astore_1
    //   236: new 100	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   243: astore_2
    //   244: aload_2
    //   245: ldc_w 421
    //   248: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_2
    //   253: aload_1
    //   254: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc_w 263
    //   261: iconst_1
    //   262: aload_2
    //   263: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: aload_1
    //   267: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -51 -> 219
    //   273: aload_0
    //   274: iconst_0
    //   275: putfield 195	com/tencent/av/ui/QavVideoRecordUICtrl:ag	Z
    //   278: aload_0
    //   279: iconst_3
    //   280: iconst_0
    //   281: invokevirtual 419	com/tencent/av/ui/QavVideoRecordUICtrl:b	(IZ)V
    //   284: aload_1
    //   285: athrow
    //   286: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	QavVideoRecordUICtrl
    //   13	63	1	localObject1	Object
    //   115	1	1	localObject2	Object
    //   119	55	1	localException1	Exception
    //   186	6	1	localValueAnimator	ValueAnimator
    //   231	1	1	localObject3	Object
    //   235	50	1	localException2	Exception
    //   127	136	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   82	103	115	finally
    //   120	159	115	finally
    //   82	103	119	java/lang/Exception
    //   198	219	231	finally
    //   236	270	231	finally
    //   198	219	235	java/lang/Exception
  }
  
  private void L()
  {
    if (((AVActivity)this.m.get()).H == null) {
      return;
    }
    this.Y = 0;
    QLog.d("QavVideoRecordUICtrl", 1, "onRecordBegin");
    this.V.k().cB = true;
    a(1, true);
    E();
    this.C.setProgress(0L, this.c);
    this.D.setText(a(0L));
    this.E.setVisibility(0);
    ((AVActivity)this.m.get()).H.a(new Object[] { Integer.valueOf(163) });
  }
  
  private void M()
  {
    AVActivity localAVActivity = (AVActivity)this.m.get();
    if (localAVActivity == null) {
      return;
    }
    if ((localAVActivity.H != null) && (this.V != null))
    {
      QavRecordReporter.a("0X8008AAE");
      if (this.V.k().af)
      {
        localAVActivity.X.c(2);
        QLog.d("QavVideoRecordUICtrl", 1, "start record, child lock");
        return;
      }
      if (this.V.k().cB)
      {
        e();
        long l1 = (System.currentTimeMillis() - this.f) / 1000L;
        ReportController.b(null, "CliOper", "", "", "0X800863B", "0X800863B", 0, 0, String.valueOf(l1), "", "", "");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(localAVActivity.H.getCurrentAccountUin(), "av_record_click_end", true, l1, 0L, null, "", false);
        return;
      }
      this.V.k().cL.clear();
      boolean bool1 = v();
      int i3 = 0;
      int i2;
      Object localObject;
      if (!bool1)
      {
        if (localAVActivity.H != null) {
          TipsUtil.a(localAVActivity.H, 1022, 2131893509);
        }
        QLog.d("QavVideoRecordUICtrl", 1, "start record, api not support");
        i2 = i3;
      }
      else
      {
        int i1;
        if (!this.V.k().cA)
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, friend not support");
          localObject = this.V;
          if (((VideoController)localObject).g(((VideoController)localObject).k().s) == 5)
          {
            QavRecordReporter.a("0X8008AB6");
            i1 = 2131893517;
          }
          else
          {
            QavRecordReporter.a("0X8008AB5");
            i1 = 2131893516;
          }
          i2 = i3;
          if (localAVActivity.H != null)
          {
            TipsUtil.a(localAVActivity.H, 1022, i1);
            i2 = i3;
          }
        }
        else if (!y())
        {
          if (localAVActivity.H != null) {
            TipsUtil.a(localAVActivity.H, 1022, 2131893522);
          }
          QLog.d("QavVideoRecordUICtrl", 1, "start record, isPerformanceSupport==false");
          QavRecordReporter.a("0X8008AB4");
          i2 = i3;
        }
        else if ((this.V.k().cD) && (this.V.k().cz < 735))
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, friend's old version not support record in same time");
          TipsUtil.a(localAVActivity.H, 1022, 2131893520);
          i2 = i3;
        }
        else if (!u())
        {
          QLog.d("QavVideoRecordUICtrl", 1, "start record, last encode not stop");
          i2 = i3;
          if (localAVActivity.H != null)
          {
            TipsUtil.a(localAVActivity.H, 1022, 2131893518);
            i2 = i3;
          }
        }
        else
        {
          if (localAVActivity.H.d(3))
          {
            localObject = (EffectFaceManager)localAVActivity.H.c(3);
            FaceItem localFaceItem = (FaceItem)((EffectFaceManager)localObject).c();
            if (localFaceItem != null)
            {
              bool1 = ((EffectFaceManager)localObject).k();
              boolean bool2 = localFaceItem.isSameType("pendant");
              boolean bool3 = localFaceItem.isSameType("face");
              boolean bool4 = localFaceItem.isSameType("voicesticker");
              if ((bool1) && ((bool3) || (bool4))) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (i1 != 0)
              {
                localObject = localAVActivity.H;
                if (bool4) {
                  i1 = 2131893542;
                } else {
                  i1 = 2131893541;
                }
                TipsUtil.a((VideoAppInterface)localObject, 1022, i1);
                QLog.d("QavVideoRecordUICtrl", 1, "start record, isDoubleScreen");
                if (bool4)
                {
                  QavRecordReporter.a("0X8009852");
                  i2 = i3;
                  break label958;
                }
                QavRecordReporter.a("0X8008AC3");
                i2 = i3;
                break label958;
              }
              if (bool2) {
                QavRecordReporter.a("0X8008ABE");
              }
            }
          }
          if (localAVActivity.H.d(0))
          {
            localObject = (EffectZimuManager)localAVActivity.H.c(0);
            if (localObject != null)
            {
              localObject = (ZimuItem)((EffectZimuManager)localObject).c();
              if ((localObject != null) && ((TextUtils.isEmpty(((ZimuItem)localObject).getId()) ^ true)))
              {
                TipsUtil.a(localAVActivity.H, 1022, 2131893543);
                QLog.d("QavVideoRecordUICtrl", 1, "start record, usingZimu");
                QavRecordReporter.a("0X8008AD2");
                i2 = i3;
                break label958;
              }
            }
          }
          if ((localAVActivity.ai != null) && (localAVActivity.ai.b()))
          {
            TipsUtil.a(localAVActivity.H, 1022, 2131893540);
            i2 = i3;
          }
          else if (FileSwapHelper.a() < 31457280L)
          {
            if (localAVActivity.H != null) {
              TipsUtil.a(localAVActivity.H, 1022, 2131893534);
            }
            QLog.d("QavVideoRecordUICtrl", 1, "start record, STORAGE_LEFT_MIN_SIZE not enough");
            i2 = i3;
          }
          else
          {
            if (this.V.k().cr != 0)
            {
              this.V.k().cL.add(Integer.valueOf(0));
              QavRecordReporter.a("0X8008AC1");
            }
            if (localAVActivity.H.d(2))
            {
              localObject = (EffectPendantTools)localAVActivity.H.c(2);
              if ((localObject != null) && (((EffectPendantTools)localObject).c() != null))
              {
                this.V.k().cL.add(Integer.valueOf(6));
                QavRecordReporter.a("0X8008ABC");
              }
            }
            i2 = 1;
          }
        }
      }
      label958:
      if (i2 != 0)
      {
        this.V.k().cJ = true;
        this.V.k().cK = d();
        b();
        if ((z()) && (localAVActivity.H.d(3)))
        {
          localObject = (EffectFaceManager)localAVActivity.H.c(3);
          if (((FaceItem)((EffectFaceManager)localObject).c() != null) && (((EffectFaceManager)localObject).k()) && (localAVActivity.H != null)) {
            TipsUtil.a(localAVActivity.H, 1022, 2131893519);
          }
        }
        QavRecordReporter.a("0X800863A");
        if (this.V.k().cD) {
          QavRecordReporter.a("0X8008ACC");
        }
        if (d()) {
          QavRecordReporter.a("0X8008AB9");
        } else {
          QavRecordReporter.a("0X8008AB8");
        }
        if (this.V.k().cL.size() == 0) {
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
  
  private void N()
  {
    DoubleVideoCtrlUI localDoubleVideoCtrlUI = this.W;
    if (localDoubleVideoCtrlUI == null) {
      return;
    }
    if ((this.u != null) && (this.v != null) && (this.w != null))
    {
      if (localDoubleVideoCtrlUI.ab())
      {
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        this.w.setVisibility(8);
        return;
      }
      if (p())
      {
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        if ((this.C.getShowState() != 3) && (!i()))
        {
          this.u.setVisibility(8);
          return;
        }
        this.u.setVisibility(0);
        return;
      }
      this.u.setVisibility(8);
      if (this.C.getShowState() == 3) {
        this.w.setVisibility(0);
      } else {
        this.w.setVisibility(8);
      }
      if (i())
      {
        this.v.setVisibility(0);
        return;
      }
      this.v.setVisibility(8);
    }
  }
  
  private void O()
  {
    VideoNetStateBar localVideoNetStateBar = this.X;
    if (localVideoNetStateBar == null) {
      return;
    }
    localVideoNetStateBar.e(this.G);
    int i1 = this.G;
    if ((i1 != 90) && (i1 != 270) && (i()))
    {
      this.X.d(l() + i(2131298571));
      return;
    }
    this.X.d(i(2131298571));
  }
  
  private void P()
  {
    this.ae = null;
    this.ad = null;
    this.af = null;
    this.Z = null;
    this.aa = null;
    this.ab = null;
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
    if ((v()) && (!A()))
    {
      if (paramVideoController != null)
      {
        paramVideoController.e(8, "SUPPORT_TRUE");
        paramVideoController.e(8, "SUPPORT_TRUE");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SUPPORT_TRUE_7.3.5#");
        localStringBuilder.append(QavRecordDpc.a().i);
        paramVideoController.e(8, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SUPPORT_TRUE_7.3.5#");
        localStringBuilder.append(QavRecordDpc.a().i);
        paramVideoController.e(8, localStringBuilder.toString());
      }
      return;
    }
    QLog.d("QavVideoRecordUICtrl", 1, "sendSupportMsg, not support");
  }
  
  private void a(VideoAppInterface paramVideoAppInterface)
  {
    LayoutInflater.from((Context)this.m.get()).inflate(2131625825, this.n);
    this.p = ((RelativeLayout)this.n.findViewById(2131449701));
    this.q = ((RelativeLayout)this.n.findViewById(2131444507));
    this.r = ((RelativeLayout)this.n.findViewById(2131444506));
    this.s = ((TextView)this.n.findViewById(2131447173));
    this.t = ((ImageButton)this.n.findViewById(2131444497));
    this.v = this.n.findViewById(2131444494);
    this.u = this.n.findViewById(2131444493);
    this.w = this.n.findViewById(2131444492);
    this.x = ((RelativeLayout.LayoutParams)this.s.getLayoutParams());
    this.y = ((RelativeLayout.LayoutParams)this.t.getLayoutParams());
    this.t.setOnClickListener(this);
    this.z = ((RelativeLayout.LayoutParams)this.q.getLayoutParams());
    this.A = ((RelativeLayout.LayoutParams)this.r.getLayoutParams());
    this.B = ((RelativeLayout.LayoutParams)this.p.getLayoutParams());
    if (AudioHelper.a(0) == 1)
    {
      this.p.setBackgroundColor(1602735851);
      this.q.setBackgroundColor(2142109487);
    }
    this.p.setWillNotDraw(false);
    this.e = AIOUtils.b(51.0F, ((AVActivity)this.m.get()).getResources());
    this.M = ((AVActivity)this.m.get()).getString(2131893527);
    this.N = ((AVActivity)this.m.get()).getString(2131893523);
    this.C = ((QavRecordButtonView)((AVActivity)this.m.get()).findViewById(2131444486));
    this.C.setOnClickListener(this);
    this.C.setListener(this);
    this.E = ((LinearLayout)((AVActivity)this.m.get()).findViewById(2131444499));
    this.D = ((TextView)((AVActivity)this.m.get()).findViewById(2131444498));
    this.E.setVisibility(8);
    if (AudioHelper.a(0) == 1)
    {
      this.E.setBackgroundColor(-273627938);
      this.D.setBackgroundColor(-65281);
    }
  }
  
  private void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordEnd time=");
    localStringBuilder.append(paramLong);
    QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    if (((AVActivity)this.m.get()).H == null) {
      return;
    }
    this.Y = 0;
    this.V.k().cB = false;
    if ((paramLong <= 1000L) && (!((AVActivity)this.m.get()).ae))
    {
      if (paramLong >= 0L)
      {
        this.L.postDelayed(new QavVideoRecordUICtrl.7(this), 1000L);
        TipsUtil.a(((AVActivity)this.m.get()).H, 1023, 2131893539);
        QavRecordReporter.a("0X8008AB0");
      }
      else if (paramLong < 0L)
      {
        a(3, true);
        TipsUtil.a(((AVActivity)this.m.get()).H, 1023, 2131893514);
        this.V.au();
      }
    }
    else
    {
      a(3, true);
      this.V.k().cE = 0;
    }
    E();
    this.E.setVisibility(8);
    ((AVActivity)this.m.get()).H.a(new Object[] { Integer.valueOf(163) });
  }
  
  private void c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onForceStop time=");
    localStringBuilder.append(paramLong);
    QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    if (((AVActivity)this.m.get()).H == null) {
      return;
    }
    this.V.k().cB = false;
    TipsUtil.a(((AVActivity)this.m.get()).H, 1023, 2131893515);
    this.V.au();
    E();
    this.E.setVisibility(8);
    ((AVActivity)this.m.get()).H.a(new Object[] { Integer.valueOf(163) });
  }
  
  private int h(int paramInt)
  {
    if (paramInt != 0) {
      if (!this.h)
      {
        if (this.i) {
          return 0;
        }
        DoubleVideoCtrlUI localDoubleVideoCtrlUI = this.W;
        if ((localDoubleVideoCtrlUI == null) || (!localDoubleVideoCtrlUI.ab())) {}
      }
      else
      {
        return 0;
      }
    }
    return paramInt;
  }
  
  private int i(int paramInt)
  {
    return ((AVActivity)this.m.get()).getResources().getDimensionPixelSize(paramInt);
  }
  
  private void j(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (!((AVActivity)this.m.get()).ae) {
        TipsUtil.a(((AVActivity)this.m.get()).H, 1023, 2131893514);
      }
    }
    else if (!((AVActivity)this.m.get()).ae)
    {
      if (this.l) {
        paramInt = 2131893529;
      } else {
        paramInt = 2131893528;
      }
      QQToast.makeText((Context)this.m.get(), 2, ((AVActivity)this.m.get()).getResources().getString(paramInt), 0).show();
    }
  }
  
  public static boolean v()
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
  
  public void B()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("animExpandBar, cur=");
      ((StringBuilder)localObject).append(this.K);
      ((StringBuilder)localObject).append(", mAnimExpanding=");
      ((StringBuilder)localObject).append(this.ac);
      QLog.i("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.Z;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, isRunning");
      }
      return;
    }
    J();
  }
  
  public void C()
  {
    a(5, true);
    a(d(), this.W, false);
    b(true);
    if (((AVActivity)this.m.get()).H != null) {
      TipsUtil.a(((AVActivity)this.m.get()).H, 1023, 2131893545);
    }
    this.V.k().cD = false;
    E();
    ((AVActivity)this.m.get()).H.a(new Object[] { Integer.valueOf(163) });
    long l1 = (System.currentTimeMillis() - this.g) / 1000L;
    ReportController.b(null, "CliOper", "", "", "0X800863E", "0X800863E", 0, 0, "", String.valueOf(l1), "", "");
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(((AVActivity)this.m.get()).H.getCurrentAccountUin(), "av_record_cancel", true, l1, 0L, null, "", false);
    c(1);
  }
  
  public void D()
  {
    long l1 = AudioHelper.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endBeenRecordedState, seq[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("]");
    QLog.w("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    localObject = this.V;
    if ((localObject != null) && (((VideoController)localObject).k() != null) && (this.W != null))
    {
      this.V.k().cD = false;
      c(1);
      a(this.W, this.G);
      b(true);
      a(d(), this.W, false);
      c(false);
      this.W.a(true);
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endBeenRecordedState something is null: mControlUI=");
      ((StringBuilder)localObject).append(this.W);
      QLog.i("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject).toString());
    }
    ((AVActivity)this.m.get()).h(l1);
    E();
    if (((AVActivity)this.m.get()).H != null) {
      ((AVActivity)this.m.get()).H.a(new Object[] { Integer.valueOf(163) });
    }
    P();
  }
  
  public void E()
  {
    long l1 = AudioHelper.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateRecordButton, seq[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("]");
    QLog.w("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    localObject = this.V;
    if ((localObject != null) && (((VideoController)localObject).k() != null) && (((AVActivity)this.m.get()).H != null))
    {
      if (this.C == null) {
        return;
      }
      if (x())
      {
        if (this.V.k().cB) {
          this.C.setShowState(3, ((AVActivity)this.m.get()).H.p());
        } else {
          this.C.setShowState(2, ((AVActivity)this.m.get()).H.p());
        }
        ((AVActivity)this.m.get()).K.f(l1, 16777215);
        return;
      }
      this.C.setShowState(1, ((AVActivity)this.m.get()).H.p());
    }
  }
  
  public void F() {}
  
  public String a(long paramLong)
  {
    if (paramLong == 0L) {
      return this.N;
    }
    int i1 = (int)(paramLong / 1000L);
    int i2 = i1 / 60;
    return String.format(Locale.getDefault(), "%s (%02d:%02d)", new Object[] { this.M, Integer.valueOf(i2), Integer.valueOf(i1 - i2 * 60) });
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
    this.L.removeMessages(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.Q;
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
    this.F = true;
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 5))
    {
      if (paramInt == 4)
      {
        this.T = true;
        if (g() >= 1000L) {
          this.L.post(new QavVideoRecordUICtrl.4(this));
        }
      }
    }
    else {
      this.L.post(new QavVideoRecordUICtrl.3(this));
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
    this.V.e(8, String.valueOf(paramInt1));
    if (paramBoolean)
    {
      this.L.removeMessages(paramInt1);
      localObject = this.L;
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
      if ((paramInt != 0) && (this.K != 1)) {
        i(2131298619);
      }
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeFinish, filePath[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mDeleteThisVideo[");
    localStringBuilder.append(this.T);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    QavRecordReporter.d();
    if (this.T)
    {
      boolean bool2 = false;
      this.T = false;
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
      FileSwapHelper.a(paramString, (Context)this.m.get());
      this.L.post(new QavVideoRecordUICtrl.2(this));
    }
    this.F = true;
  }
  
  public void a(String paramString1, String paramString2)
  {
    long l1 = AudioHelper.c();
    boolean bool = QLog.isColorLevel();
    int i2 = 1;
    if (bool)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onReceiveRecordMsg, fromUin[");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append("], data[");
      localStringBuilder1.append(paramString2);
      localStringBuilder1.append("], seq[");
      localStringBuilder1.append(l1);
      localStringBuilder1.append("]");
      QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder1.toString());
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Qav.Record, onChangeUi_ReceiveRecordMsg, ");
      localStringBuilder2.append(localNumberFormatException.getMessage());
      QLog.i("QavVideoRecordUICtrl", 1, localStringBuilder2.toString());
      i1 = -1;
    }
    if (i1 == -1)
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
        this.V.k().cA = true;
        this.V.k().cz = Math.max(this.V.k().cz, 730);
        E();
        return;
      }
      if (paramString2.startsWith("SUPPORT_TRUE_7.3.5"))
      {
        this.V.k().cA = true;
        this.V.k().cz = Math.max(this.V.k().cz, 735);
        i1 = QavRecordUtils.a(paramString2, this.j.i);
        paramString1 = new StringBuilder();
        paramString1.append("onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=");
        paramString1.append(i1);
        QLog.i("QavVideoRecordUICtrl", 1, paramString1.toString());
        this.V.k().cC = (i1 * 60 * 1000L);
        E();
      }
      return;
    }
    if ((this.V != null) && (((AVActivity)this.m.get()).H != null))
    {
      int i3 = this.V.k().g;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onChangeUi_ReceiveRecordMsg, session type=");
        paramString2.append(i3);
        QLog.i("QavVideoRecordUICtrl", 2, paramString2.toString());
      }
      if ((i3 != 2) && (i3 != 1)) {
        return;
      }
      switch (i1)
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
        if (this.V.k().cB)
        {
          a();
          i1 = i2;
        }
        else
        {
          i1 = 0;
        }
        if (i1 != 0) {
          i1 = 6;
        } else {
          i1 = 7;
        }
        a(i1, false);
        return;
      case 4: 
        a(3);
        return;
      case 3: 
      case 8: 
        this.V.k().cD = false;
        if (i1 == 3)
        {
          a(4, false);
          TipsUtil.a(((AVActivity)this.m.get()).H, 1022, 2131893513);
        }
        else
        {
          a(9, false);
          TipsUtil.a(((AVActivity)this.m.get()).H, 1022, 2131893512);
        }
        D();
        return;
      case 2: 
        a(1);
        return;
      }
      this.V.k().cD = true;
      c(3);
      E();
      b(d());
      a(d(), this.W, true);
      a(this.W, this.G);
      this.g = System.currentTimeMillis();
      c(true);
      ((AVActivity)this.m.get()).h(l1);
      if (!"self".equalsIgnoreCase(paramString1))
      {
        a(2, false);
        if (((AVActivity)this.m.get()).isResume()) {
          this.V.au();
        } else {
          this.V.at();
        }
      }
      if (this.V.k().cr != 0) {
        QavRecordReporter.a("0X8008AC2");
      }
      if (((AVActivity)this.m.get()).H.d(2))
      {
        paramString1 = (EffectPendantTools)((AVActivity)this.m.get()).H.c(2);
        if ((paramString1 != null) && (paramString1.c() != null)) {
          QavRecordReporter.a("0X8008ABC");
        }
      }
      ((AVActivity)this.m.get()).H.a(new Object[] { Integer.valueOf(163) });
      return;
    }
    QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, mVideoController == null || mActivity.get().mApp == null");
  }
  
  public void a(boolean paramBoolean)
  {
    m();
    if (this.W == null) {
      return;
    }
    int i1 = this.p.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    DoubleVideoCtrlUI localDoubleVideoCtrlUI;
    if ((i1 == 0) && (!d()) && (!LiuHaiUtils.b()))
    {
      localDoubleVideoCtrlUI = this.W;
      i1 = n();
      int i2 = k();
      if (paramBoolean)
      {
        paramBoolean = bool1;
        if (!d()) {}
      }
      else
      {
        paramBoolean = true;
      }
      localDoubleVideoCtrlUI.a(i1 + i2, paramBoolean);
    }
    else
    {
      localDoubleVideoCtrlUI = this.W;
      i1 = n();
      if (paramBoolean)
      {
        paramBoolean = bool2;
        if (!d()) {}
      }
      else
      {
        paramBoolean = true;
      }
      localDoubleVideoCtrlUI.a(i1, paramBoolean);
    }
    ((AVActivity)this.m.get()).h(-1034L);
    O();
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
    I();
  }
  
  @TargetApi(17)
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = paramInt1;
    if (this.Q == null) {
      try
      {
        if (v()) {
          this.Q = new QavVideoAudioRecorder();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.Q = null;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("oom ");
        ((StringBuilder)localObject2).append(localOutOfMemoryError);
        QLog.e("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject2).toString(), localOutOfMemoryError);
      }
    }
    if (paramBoolean) {
      paramInt1 = ScreenLayoutDoubleScreen.c(paramInt1);
    } else {
      paramInt1 = paramInt2;
    }
    this.R = FileSwapHelper.b();
    this.S = new File(this.R);
    this.O = 0L;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doNeedStartRecord path=");
      ((StringBuilder)localObject1).append(this.R);
      ((StringBuilder)localObject1).append(", w=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", h=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", rh=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject1).toString());
    }
    int i3 = this.j.g;
    paramInt2 = paramInt1;
    int i2 = i1;
    if (i1 > i3)
    {
      float f1 = i3 * 1.0F / i1;
      paramInt2 = (int)(paramInt1 * f1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doNeedStartRecord calc size, maxWidth=");
        ((StringBuilder)localObject1).append(i3);
        ((StringBuilder)localObject1).append(", realWidth=");
        ((StringBuilder)localObject1).append(i3);
        ((StringBuilder)localObject1).append(", realHeight=");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d("QavVideoRecordUICtrl", 2, ((StringBuilder)localObject1).toString());
      }
      i2 = i3;
    }
    paramInt1 = paramInt2;
    if (paramInt2 % 2 == 1)
    {
      paramInt1 = paramInt2 + 1;
      QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord height+1");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doNeedStartRecord rW=");
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append(", rH=");
    ((StringBuilder)localObject1).append(paramInt1);
    QLog.d("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new EncodeConfig(this.R, i2, paramInt1, 5120000, 1, false, 0);
    ((EncodeConfig)localObject1).a(EGL14.eglGetCurrentContext());
    Object localObject2 = this.Q;
    if (localObject2 != null)
    {
      ((QavVideoAudioRecorder)localObject2).a((EncodeConfig)localObject1, this);
      QavRecordReporter.a();
    }
    else
    {
      a(5, null);
    }
    return new int[] { i2, paramInt1 };
  }
  
  public void b()
  {
    d = true;
    this.H = (System.currentTimeMillis() - 200L);
    this.J = (this.H + 99999999L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRecord, mStartTime[");
    localStringBuilder.append(this.H);
    localStringBuilder.append("], mRealStartTime[");
    localStringBuilder.append(this.J);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    this.O = 0L;
    this.P = 31457380L;
    L();
    this.f = System.currentTimeMillis();
    this.L.sendEmptyMessageDelayed(10, 500L);
    this.L.sendEmptyMessageDelayed(11, 500L);
    this.V.a(0, this);
    int i1 = this.V.a(2, true);
    int i2 = this.V.a(4, true);
    int i3 = this.V.a(2, 48000, 1, 16);
    int i4 = this.V.a(4, 48000, 1, 16);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRecord, after registerAudioDataCallback, ret2=");
    localStringBuilder.append(i1);
    localStringBuilder.append(", ret4=");
    localStringBuilder.append(i2);
    localStringBuilder.append(", set2=");
    localStringBuilder.append(i3);
    localStringBuilder.append(", set4=");
    localStringBuilder.append(i4);
    QLog.i("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    if (this.V.k().cH)
    {
      i1 = this.V.a(3, true);
      i2 = this.V.a(3, 48000, 1, 16);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecord, registerAudioDataCallback, mix = true, ret3=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", set3=");
      localStringBuilder.append(i2);
      QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
      this.V.k().cF = true;
      this.V.k().cG = true;
    }
  }
  
  public void b(int paramInt)
  {
    d = false;
    this.I = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endRecord, stopType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], mStartTime[");
    ((StringBuilder)localObject).append(this.H);
    ((StringBuilder)localObject).append("], mRealStartTime[");
    ((StringBuilder)localObject).append(this.J);
    ((StringBuilder)localObject).append("], mEndTime[");
    ((StringBuilder)localObject).append(this.I);
    ((StringBuilder)localObject).append("]");
    QLog.w("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    this.L.removeMessages(10);
    this.L.removeMessages(11);
    this.L.removeMessages(15);
    if (paramInt == 1) {
      b(g());
    } else if (paramInt == 2) {
      c(g());
    } else {
      b(-1L);
    }
    boolean bool;
    if ((g() >= 1000L) && (paramInt == 1)) {
      bool = false;
    } else {
      bool = true;
    }
    this.T = bool;
    localObject = this.Q;
    if (localObject != null) {
      ((QavVideoAudioRecorder)localObject).a();
    }
    this.S = null;
    this.V.a(0, null);
    int i1 = this.V.b(2, true);
    int i2 = this.V.b(4, true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endRecord, after unregisterAudioDataCallbackAll, ret2=");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(", ret4=");
    ((StringBuilder)localObject).append(i2);
    QLog.i("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    if (this.V.k().cH)
    {
      i1 = this.V.a(3, false);
      i2 = this.V.a(3, 48000, 1, 16);
      this.V.k().cF = true;
      this.V.k().cG = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endRecord, registerAudioDataCallback, mix = true, ret3=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", set3=");
      ((StringBuilder)localObject).append(i2);
      QLog.i("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    }
    QavRecordReporter.a(this.j.s, this.j.t, paramInt, g());
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setShowState=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("QavVideoRecordUICtrl", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 3)
    {
      H();
      N();
      return;
    }
    this.K = 3;
    this.p.setVisibility(0);
    this.s.setVisibility(0);
    this.t.setVisibility(0);
    this.s.setAlpha(1.0F);
    this.t.setAlpha(1.0F);
    this.x.setMargins(i(2131298612), 0, 0, 0);
    this.s.setLayoutParams(this.x);
    this.t.setLayoutParams(this.y);
    localObject = this.z;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    RelativeLayout localRelativeLayout = this.q;
    if (localRelativeLayout != null) {
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.q;
    if (localObject != null) {
      ((RelativeLayout)localObject).requestLayout();
    }
    if (paramBoolean) {
      h();
    } else {
      N();
    }
    I();
    a(i());
  }
  
  public void b(boolean paramBoolean)
  {
    DoubleVideoCtrlUI localDoubleVideoCtrlUI = this.W;
    if (localDoubleVideoCtrlUI == null) {
      return;
    }
    localDoubleVideoCtrlUI.r(paramBoolean);
  }
  
  public void c(int paramInt)
  {
    b(paramInt, true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.V.k() == null) {
      return;
    }
    this.L.removeMessages(14);
    if (paramBoolean) {
      this.L.sendEmptyMessageDelayed(14, this.V.k().cC);
    }
  }
  
  public boolean c()
  {
    return d;
  }
  
  public void d(int paramInt)
  {
    paramInt = h(paramInt);
    if (this.G != paramInt)
    {
      this.G = paramInt;
      a(i());
      K();
    }
  }
  
  public boolean d()
  {
    return (((AVActivity)this.m.get()).L != null) && (((AVActivity)this.m.get()).L.V());
  }
  
  public void e()
  {
    b(1);
  }
  
  public void e(int paramInt)
  {
    N();
  }
  
  public long f()
  {
    long l1;
    try
    {
      if (this.S == null) {
        l1 = this.O;
      } else {
        l1 = FileSwapHelper.a(this.S);
      }
    }
    catch (Exception localException)
    {
      l1 = this.O;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getCurrentRecordSize Exception=");
      localStringBuilder2.append(localException.getMessage());
      QLog.d("QavVideoRecordUICtrl", 2, localStringBuilder2.toString());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getCurrentRecordSize=");
      localStringBuilder1.append(l1);
      QLog.d("QavVideoRecordUICtrl", 2, localStringBuilder1.toString());
    }
    return l1;
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
      localLayoutParams = (RelativeLayout.LayoutParams)this.E.getLayoutParams();
      localLayoutParams.setMargins(AIOUtils.b(-12.5F, ((AVActivity)this.m.get()).getResources()), 0, 0, AIOUtils.b(32.5F, ((AVActivity)this.m.get()).getResources()));
      localLayoutParams.addRule(2, 2131444486);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(6, 0);
      this.E.setLayoutParams(localLayoutParams);
      if (paramInt == 90)
      {
        this.E.setGravity(19);
        this.E.setRotation(270.0F);
        this.C.setRotation(270.0F);
        return;
      }
      this.E.setGravity(21);
      this.E.setRotation(90.0F);
      this.C.setRotation(90.0F);
      return;
    }
    label175:
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.E.getLayoutParams();
    localLayoutParams.setMargins(AIOUtils.b(10.0F, ((AVActivity)this.m.get()).getResources()), 0, 0, 0);
    localLayoutParams.addRule(2, 0);
    localLayoutParams.addRule(1, 2131444486);
    localLayoutParams.addRule(6, 2131444486);
    this.E.setLayoutParams(localLayoutParams);
    if (paramInt == 0)
    {
      this.E.setGravity(19);
      this.E.setRotation(0.0F);
    }
    else
    {
      this.E.setGravity(21);
      this.E.setRotation(180.0F);
    }
    this.C.setRotation(paramInt);
  }
  
  public long g()
  {
    long l1 = this.I - this.J;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRealDuration, dur[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], UITime[");
    localStringBuilder.append(this.I - this.H);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    return Math.max(0L, l1);
  }
  
  public void g(int paramInt)
  {
    if (this.W == null) {
      return;
    }
    boolean bool = this.V.k().cB;
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
      if (((AVActivity)this.m.get()).H == null) {
        return;
      }
      int i1 = 1;
      int i2 = 1 << paramInt - 1;
      int i3 = this.Y;
      if ((i3 & i2) == i2)
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
      this.Y = (i2 | i3);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return;
          }
          this.L.sendEmptyMessageDelayed(15, 2000L);
          QavRecordReporter.a("0X8008ACA");
          return;
        }
        TipsUtil.a(((AVActivity)this.m.get()).H, 1022, 2131893524);
        QavRecordReporter.a("0X8008AC9");
        return;
      }
      localObject = (FaceItem)((EffectFaceManager)((AVActivity)this.m.get()).H.c(3)).c();
      if ((localObject != null) && (((FaceItem)localObject).getId().equalsIgnoreCase("daquan"))) {
        paramInt = i1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        this.L.postDelayed(new QavVideoRecordUICtrl.8(this), 2000L);
      } else {
        TipsUtil.a(((AVActivity)this.m.get()).H, 1022, 2131893525);
      }
      QavRecordReporter.a("0X8008AC8");
    }
  }
  
  public void h()
  {
    Object localObject = this.W;
    if (localObject != null)
    {
      if (((DoubleVideoCtrlUI)localObject).V()) {
        return;
      }
      this.G = h(this.G);
      f(this.G);
      N();
      O();
      if (!i()) {
        return;
      }
      int i1 = this.G;
      if ((i1 != 90) && (i1 != 270)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 != 0)
      {
        localObject = this.W;
        if ((localObject != null) && (!((DoubleVideoCtrlUI)localObject).ab()))
        {
          if (o() == 3) {
            i1 = i(2131298608);
          } else {
            i1 = i(2131298614);
          }
          localObject = this.z;
          ((RelativeLayout.LayoutParams)localObject).height = i1;
          ((RelativeLayout.LayoutParams)localObject).width = i1;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(15.0F, ((AVActivity)this.m.get()).getResources());
          localObject = this.q;
          if (localObject != null) {
            ((RelativeLayout)localObject).setLayoutParams(this.z);
          }
          if (this.G == 90)
          {
            localObject = this.q;
            if (localObject != null) {
              ((RelativeLayout)localObject).setRotation(-90.0F);
            }
            localObject = this.r;
            if (localObject == null) {
              break label354;
            }
            ((RelativeLayout)localObject).setScaleX(1.0F);
            this.r.setScaleY(1.0F);
            break label354;
          }
          localObject = this.r;
          if (localObject != null)
          {
            ((RelativeLayout)localObject).setScaleX(-1.0F);
            this.r.setScaleY(-1.0F);
          }
          localObject = this.q;
          if (localObject == null) {
            break label354;
          }
          ((RelativeLayout)localObject).setRotation(-90.0F);
          break label354;
        }
      }
      localObject = this.z;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      RelativeLayout localRelativeLayout = this.q;
      if (localRelativeLayout != null) {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.r;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).setScaleX(1.0F);
        this.r.setScaleY(1.0F);
      }
      localObject = this.q;
      if (localObject != null) {
        ((RelativeLayout)localObject).setRotation(this.G);
      }
      label354:
      I();
      a(i());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if ((i1 != 1) && (i1 != 3) && (i1 != 5) && (i1 != 8)) {
      if (i1 != 14) {
        if (i1 == 15) {}
      }
    }
    switch (i1)
    {
    default: 
      return true;
    case 10: 
      this.L.removeMessages(10);
      if (!d) {
        return true;
      }
      long l1 = G();
      long l2 = this.c;
      if (l1 > l2)
      {
        e();
        l1 = this.c / 1000L;
        ReportController.b(null, "CliOper", "", "", "0X800863C", "0X800863C", 0, 0, String.valueOf(l1), "", "", "");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_timeout", true, l1, 0L, null, "", false);
        return true;
      }
      this.C.setProgress(l1, l2);
      this.D.setText(a(l1));
      this.L.sendEmptyMessageDelayed(10, 500L);
    case 11: 
      this.L.removeMessages(11);
      if (!d) {
        return true;
      }
      ThreadManager.postImmediately(new QavVideoRecordUICtrl.1(this), null, false);
      return true;
      if (((AVActivity)this.m.get()).H != null)
      {
        TipsUtil.a(((AVActivity)this.m.get()).H, 1022, 2131893526);
        return true;
        if (!((AVActivity)this.m.get()).ae)
        {
          D();
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
  
  public boolean i()
  {
    return this.K == 3;
  }
  
  public void j()
  {
    d = false;
    this.L.removeMessages(10);
    this.L.removeMessages(11);
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.Q;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.d();
    }
    this.r = null;
    this.q = null;
    this.u = null;
    this.v = null;
    this.w = null;
  }
  
  int k()
  {
    boolean bool = LiuHaiUtils.b();
    if (i())
    {
      if (bool) {
        return LiuHaiUtils.e((Activity)this.m.get());
      }
      return this.W.ap();
    }
    return 0;
  }
  
  int l()
  {
    if (i()) {
      return k() + n();
    }
    return 0;
  }
  
  public void m()
  {
    if (this.W != null)
    {
      if (!i()) {
        return;
      }
      int i1 = k();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
      localLayoutParams.topMargin = i1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("iveswu statusBar:density=");
      localStringBuilder.append(((AVActivity)this.m.get()).getResources().getDisplayMetrics().density);
      QLog.i("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
      this.p.setLayoutParams(localLayoutParams);
    }
  }
  
  public int n()
  {
    return i(2131298619);
  }
  
  public int o()
  {
    return this.K;
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onClick");
    if (paramView == this.t) {
      C();
    } else if (paramView == this.C) {
      M();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (d)
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.Q;
      if ((localQavVideoAudioRecorder != null) && (paramInt1 == 100)) {
        localQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
      }
    }
  }
  
  public boolean p()
  {
    int i1 = this.G;
    return (i1 == 90) || (i1 == 270);
  }
  
  public void q()
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeStart");
    this.F = false;
  }
  
  public void r() {}
  
  public void s() {}
  
  public void t()
  {
    this.J = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeRealStart, mRealStartTime[");
    localStringBuilder.append(this.J);
    localStringBuilder.append("], StartOffset[");
    localStringBuilder.append(this.J - this.H);
    localStringBuilder.append("]");
    QLog.w("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
  }
  
  public boolean u()
  {
    return this.F;
  }
  
  public boolean w()
  {
    boolean bool;
    if ((!A()) && (v()) && (y()) && (this.V.k().cA)) {
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
  
  public boolean x()
  {
    Object localObject = this.V;
    if ((localObject != null) && (((VideoController)localObject).k() != null))
    {
      if (((AVActivity)this.m.get()).H == null) {
        return false;
      }
      boolean bool1 = this.V.k().cB;
      boolean bool6 = this.V.k().cD;
      boolean bool7 = this.V.k().af;
      if (w())
      {
        if (bool1) {
          return true;
        }
        if (((AVActivity)this.m.get()).H.d(3))
        {
          localObject = (EffectFaceManager)((AVActivity)this.m.get()).H.c(3);
          FaceItem localFaceItem = (FaceItem)((EffectFaceManager)localObject).c();
          if (localFaceItem != null)
          {
            bool2 = ((EffectFaceManager)localObject).k();
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
        if (((AVActivity)this.m.get()).H.d(0))
        {
          localObject = (EffectZimuManager)((AVActivity)this.m.get()).H.c(0);
          if (localObject != null)
          {
            localObject = (ZimuItem)((EffectZimuManager)localObject).c();
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
          return (!bool6) || (this.V.k().cz >= 735);
        }
      }
    }
    return false;
  }
  
  public boolean y()
  {
    int i1 = this.k;
    boolean bool2 = true;
    if (i1 == 0)
    {
      if (this.j.s > this.j.e) {
        this.k = 2;
      } else if ((this.j.s == this.j.e) && (this.j.t >= this.j.f)) {
        this.k = 2;
      } else if (this.j.s > this.j.c) {
        this.k = 1;
      } else if ((this.j.s == this.j.c) && (this.j.t >= this.j.d)) {
        this.k = 1;
      } else {
        this.k = 3;
      }
      if (this.j.b != 1) {
        this.k = 4;
      }
      if (b) {
        this.k = 5;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPerformanceSupport=");
      localStringBuilder.append(this.k);
      QLog.d("QavVideoRecordUICtrl", 1, localStringBuilder.toString());
    }
    i1 = this.k;
    boolean bool1 = bool2;
    if (i1 != 2)
    {
      bool1 = bool2;
      if (i1 != 1)
      {
        if (i1 == 5) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean z()
  {
    if (this.k == 0) {
      y();
    }
    return this.k == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl
 * JD-Core Version:    0.7.0.1
 */