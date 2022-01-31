package com.tencent.mobileqq.avatar.dynamicavatar;

import abjn;
import abjo;
import abjp;
import abjr;
import abjt;
import abju;
import abjv;
import abjw;
import abjx;
import abjy;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.FlowActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DynamicAvatarRecordActivity
  extends FlowActivity
  implements View.OnClickListener, RMViewSTInterface
{
  public int a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new abjn(this);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new abju(this);
  public Button a;
  public ImageView a;
  public TextView a;
  public RMVideoStateMgr a;
  public CameraCover a;
  public CameraGLSurfaceView a;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new abjx(this);
  CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  public QQCustomDialog a;
  public CircleProgress a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  String jdField_a_of_type_JavaLangString;
  volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  public Button b;
  public ImageView b;
  public TextView b;
  volatile AtomicBoolean b;
  int c;
  public TextView c;
  int d;
  public TextView d;
  public boolean d;
  int e;
  public TextView e;
  public boolean e;
  int jdField_f_of_type_Int = -1;
  boolean jdField_f_of_type_Boolean = true;
  int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  
  public DynamicAvatarRecordActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Object localObject = DynamicAvatarRecordActivity.class;
    if (CameraCompatibleList.d(CameraCompatibleList.c)) {
      localObject = MX3DynamicAvatarRecordActivity.class;
    }
    localObject = new Intent(paramActivity, (Class)localObject);
    ((Intent)localObject).putExtra("param_source", paramInt1);
    paramActivity.startActivityForResult((Intent)localObject, paramInt2);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_a_of_type_Int = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.a(paramBoolean))
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(16);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624516);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
      }
      ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399)).setText(paramString);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog", paramString);
    }
  }
  
  private boolean b()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
    a(104);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
    if (FlowCameraConstant.jdField_a_of_type_Int == 1)
    {
      FlowCameraConstant.jdField_a_of_type_Int = 2;
      if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
        break label110;
      }
    }
    label110:
    for (String str = "前";; str = "后")
    {
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("当前" + str + "置相机");
      a(false);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.j();
      return true;
      FlowCameraConstant.jdField_a_of_type_Int = 1;
      break;
    }
  }
  
  private void d()
  {
    if (this.h == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.h = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e()
  {
    runOnUiThread(new abjv(this));
  }
  
  private void f()
  {
    e();
    b();
    ThreadManager.postImmediately(new abjw(this), null, true);
  }
  
  private void g()
  {
    runOnUiThread(new abjy(this));
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   4: getfield 307	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 73	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: iconst_1
    //   16: invokevirtual 310	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   19: pop
    //   20: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   23: lstore 9
    //   25: invokestatic 45	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   28: astore 12
    //   30: invokestatic 320	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   33: ifeq +478 -> 511
    //   36: ldc_w 322
    //   39: iconst_0
    //   40: invokestatic 328	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   43: new 330	abjz
    //   46: dup
    //   47: aload_0
    //   48: aload 12
    //   50: invokespecial 333	abjz:<init>	(Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   53: invokevirtual 338	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   56: invokestatic 320	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   59: ifeq +220 -> 279
    //   62: lconst_0
    //   63: lstore 7
    //   65: aload 12
    //   67: getfield 339	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   70: astore 13
    //   72: aload 13
    //   74: monitorenter
    //   75: aload 12
    //   77: getfield 339	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   80: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   83: istore 11
    //   85: lload 7
    //   87: lstore 5
    //   89: iload 11
    //   91: ifne +104 -> 195
    //   94: lload 7
    //   96: lstore_3
    //   97: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +15 -> 115
    //   103: lload 7
    //   105: lstore_3
    //   106: ldc 161
    //   108: iconst_2
    //   109: ldc_w 344
    //   112: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: lload 7
    //   117: lstore_3
    //   118: invokestatic 349	android/os/SystemClock:elapsedRealtime	()J
    //   121: lstore 5
    //   123: lload 7
    //   125: lstore_3
    //   126: aload 12
    //   128: getfield 339	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   131: ldc2_w 350
    //   134: invokevirtual 357	java/lang/Object:wait	(J)V
    //   137: lload 7
    //   139: lstore_3
    //   140: invokestatic 349	android/os/SystemClock:elapsedRealtime	()J
    //   143: lload 5
    //   145: lsub
    //   146: lstore 7
    //   148: lload 7
    //   150: lstore 5
    //   152: lload 7
    //   154: lstore_3
    //   155: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +37 -> 195
    //   161: lload 7
    //   163: lstore_3
    //   164: ldc 161
    //   166: iconst_2
    //   167: new 231	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 359
    //   177: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: lload 7
    //   182: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   185: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: lload 7
    //   193: lstore 5
    //   195: aload 13
    //   197: monitorexit
    //   198: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +12 -> 213
    //   204: ldc 161
    //   206: iconst_2
    //   207: ldc_w 364
    //   210: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: lload 5
    //   215: ldc2_w 365
    //   218: lcmp
    //   219: ifge +60 -> 279
    //   222: bipush 30
    //   224: lload 5
    //   226: l2i
    //   227: isub
    //   228: istore_2
    //   229: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +29 -> 261
    //   235: ldc 161
    //   237: iconst_2
    //   238: new 231	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 368
    //   248: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload_2
    //   252: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 373	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: iload_2
    //   262: istore_1
    //   263: iload_2
    //   264: bipush 10
    //   266: if_icmpge +6 -> 272
    //   269: bipush 10
    //   271: istore_1
    //   272: iload_1
    //   273: i2l
    //   274: lstore_3
    //   275: lload_3
    //   276: invokestatic 378	java/lang/Thread:sleep	(J)V
    //   279: aload 12
    //   281: getfield 307	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   284: ifnull -274 -> 10
    //   287: aload 12
    //   289: getfield 381	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_Double	D
    //   292: d2i
    //   293: putstatic 386	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:y	I
    //   296: aload 12
    //   298: getfield 307	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   301: invokevirtual 392	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getFrameIndex	()I
    //   304: putstatic 395	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:z	I
    //   307: getstatic 398	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:A	I
    //   310: istore_1
    //   311: iconst_m1
    //   312: putstatic 398	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:A	I
    //   315: new 400	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   318: dup
    //   319: aconst_null
    //   320: aconst_null
    //   321: aload 12
    //   323: getfield 402	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   326: aconst_null
    //   327: aconst_null
    //   328: invokespecial 405	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   331: astore 12
    //   333: aload 12
    //   335: iconst_1
    //   336: invokevirtual 406	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   339: aload 12
    //   341: iconst_0
    //   342: invokevirtual 408	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   345: aload 12
    //   347: iconst_1
    //   348: invokevirtual 410	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:c	(Z)V
    //   351: aload 12
    //   353: invokevirtual 413	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   356: iload_1
    //   357: putstatic 398	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:A	I
    //   360: aload_0
    //   361: aload 12
    //   363: getfield 414	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   366: putfield 415	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   369: aload_0
    //   370: getfield 415	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   373: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: ifne +57 -> 433
    //   379: new 423	java/io/File
    //   382: dup
    //   383: aload_0
    //   384: getfield 415	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   387: invokespecial 425	java/io/File:<init>	(Ljava/lang/String;)V
    //   390: astore 12
    //   392: aload 12
    //   394: invokevirtual 428	java/io/File:exists	()Z
    //   397: ifeq +36 -> 433
    //   400: new 231	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   407: aload 12
    //   409: invokevirtual 431	java/io/File:getParent	()Ljava/lang/String;
    //   412: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: getstatic 434	java/io/File:separator	Ljava/lang/String;
    //   418: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 436
    //   424: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 440	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   433: aload_0
    //   434: getfield 73	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   437: iconst_0
    //   438: invokevirtual 310	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   441: pop
    //   442: aload_0
    //   443: getfield 75	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   446: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   449: ifeq +11 -> 460
    //   452: aload_0
    //   453: invokevirtual 442	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:a	()V
    //   456: aload_0
    //   457: invokespecial 444	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:i	()V
    //   460: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq -453 -> 10
    //   466: ldc 161
    //   468: iconst_2
    //   469: new 231	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 446
    //   479: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_0
    //   483: getfield 415	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   486: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc_w 448
    //   492: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   498: lload 9
    //   500: lsub
    //   501: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   504: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: return
    //   511: invokestatic 453	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   514: invokevirtual 456	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   517: invokevirtual 461	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   520: pop
    //   521: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq -468 -> 56
    //   527: ldc 161
    //   529: iconst_2
    //   530: ldc_w 463
    //   533: invokestatic 373	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto -480 -> 56
    //   539: astore 13
    //   541: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +12 -> 556
    //   547: ldc 161
    //   549: iconst_2
    //   550: ldc_w 465
    //   553: invokestatic 373	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload 13
    //   558: invokevirtual 466	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   561: goto -505 -> 56
    //   564: astore 14
    //   566: lload_3
    //   567: lstore 5
    //   569: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq -377 -> 195
    //   575: ldc 161
    //   577: iconst_2
    //   578: new 231	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 468
    //   588: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload 14
    //   593: invokevirtual 471	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   596: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: lload_3
    //   606: lstore 5
    //   608: goto -413 -> 195
    //   611: astore 12
    //   613: aload 13
    //   615: monitorexit
    //   616: aload 12
    //   618: athrow
    //   619: astore 13
    //   621: goto -342 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	DynamicAvatarRecordActivity
    //   262	95	1	i	int
    //   228	39	2	j	int
    //   96	510	3	l1	long
    //   87	520	5	l2	long
    //   63	129	7	l3	long
    //   23	476	9	l4	long
    //   83	7	11	bool	boolean
    //   28	380	12	localObject1	Object
    //   611	6	12	localObject2	Object
    //   70	126	13	localAtomicBoolean	AtomicBoolean
    //   539	75	13	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   619	1	13	localInterruptedException1	java.lang.InterruptedException
    //   564	28	14	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   511	536	539	java/lang/UnsatisfiedLinkError
    //   97	103	564	java/lang/InterruptedException
    //   106	115	564	java/lang/InterruptedException
    //   118	123	564	java/lang/InterruptedException
    //   126	137	564	java/lang/InterruptedException
    //   140	148	564	java/lang/InterruptedException
    //   155	161	564	java/lang/InterruptedException
    //   164	191	564	java/lang/InterruptedException
    //   75	85	611	finally
    //   97	103	611	finally
    //   106	115	611	finally
    //   118	123	611	finally
    //   126	137	611	finally
    //   140	148	611	finally
    //   155	161	611	finally
    //   164	191	611	finally
    //   195	198	611	finally
    //   569	605	611	finally
    //   613	616	611	finally
    //   275	279	619	java/lang/InterruptedException
  }
  
  private void i()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Intent localIntent = new Intent(this, SelectCoverActivity.class);
    localIntent.putExtra("param_source", this.jdField_a_of_type_Int);
    localIntent.putExtra("param_from_newer_guide", this.jdField_g_of_type_Boolean);
    localIntent.putExtra("key_video_file_path", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_video_duration", this.jdField_g_of_type_Int);
    if (((Boolean)this.jdField_a_of_type_AndroidWidgetButton.getTag()).booleanValue())
    {
      str = "1";
      localIntent.putExtra("key_video_has_voice", str);
      if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
        break label130;
      }
    }
    label130:
    for (String str = "0";; str = "1")
    {
      localIntent.putExtra("key_camera_id", str);
      startActivityForResult(localIntent, 1);
      return;
      str = "0";
      break;
    }
  }
  
  public void A()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "finishUI()");
    }
  }
  
  int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getMeasuredHeight();
    int m = (int)(paramInt2 * FlowCameraConstant.jdField_a_of_type_Float);
    int j;
    int i;
    if (k <= this.jdField_c_of_type_Int)
    {
      j = (k - (int)(k * 0.83F)) / 2;
      paramInt1 = this.jdField_c_of_type_Int;
      i = this.jdField_c_of_type_Int;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = m;
    }
    for (;;)
    {
      if (paramBoolean) {
        i = paramInt1;
      }
      k = paramInt1;
      if (paramInt1 % 2 != 0) {
        k = paramInt1 - 1;
      }
      paramInt1 = i;
      if (i % 2 != 0) {
        paramInt1 = i - 1;
      }
      paramArrayOfInt[2] = k;
      paramArrayOfInt[3] = paramInt1;
      paramArrayOfInt[4] = paramInt2;
      paramArrayOfInt[5] = m;
      return j;
      j = this.jdField_c_of_type_Int;
      i = this.jdField_c_of_type_Int * paramInt1 / paramInt2;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = (k * paramInt2 / this.jdField_c_of_type_Int);
      k = (k - j) / 2;
      paramInt1 = j;
      j = k;
    }
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "dismissProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "realDeleteVideoSegment(), delReason = " + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "previewSizeAdjustUI(), width = " + paramInt1 + ", height = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "[previewSizeAdjustUI]rmStateMgr == null");
      }
      return;
    }
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    int[] arrayOfInt = new int[6];
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
      label103:
      if (localObject != this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView) {
        break label240;
      }
    }
    label240:
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, paramInt2, arrayOfInt, bool);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a((View)localObject);
      localLayoutParams.width = arrayOfInt[2];
      localLayoutParams.height = arrayOfInt[3];
      ((View)localObject).setLayoutParams(localLayoutParams);
      localRMVideoClipSpec.jdField_c_of_type_Int = arrayOfInt[0];
      localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
      localRMVideoClipSpec.jdField_e_of_type_Int = 480;
      localRMVideoClipSpec.jdField_f_of_type_Int = 480;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setPreviewSize(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, localRMVideoClipSpec);
      return;
      localObject = a(2131362087);
      break label103;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "errorOcured(), errCode = " + paramInt + ", errMsg = " + paramString + ", isReport = " + paramBoolean);
    }
    runOnUiThread(new abjp(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_g_of_type_Int = paramInt;
    RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
    localRMVideoStateMgr.jdField_a_of_type_Int += 1;
    if (paramBoolean)
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.post(new abjo(this, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Int = paramBundle.getInt("param_source", 0);
    this.jdField_g_of_type_Boolean = paramBundle.getBoolean("param_from_newer_guide", false);
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("source must not be null");
    }
    FlowCameraConstant.jdField_a_of_type_Int = 1;
    if (!CameraAbility.c()) {
      FlowCameraConstant.jdField_a_of_type_Int = 2;
    }
    FlowCameraConstant.jdField_a_of_type_Float = 1.0F;
    a(paramBundle, false);
    paramBundle = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
    int i = NetworkUtil.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 4, paramBundle, false, 0, i, 8);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, FlowCameraMqqAction.a(this), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e(false);
    if (!bool)
    {
      super.finish();
      return;
    }
    paramBundle = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Int = paramBundle.widthPixels;
    this.jdField_d_of_type_Int = paramBundle.heightPixels;
    if (this.jdField_c_of_type_Int <= 0)
    {
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      this.jdField_c_of_type_Int = paramBundle.widthPixels;
      this.jdField_d_of_type_Int = paramBundle.heightPixels;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2130970313, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)a(2131370019));
    paramViewGroup = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getLayoutParams();
    paramViewGroup.height = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setLayoutParams(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131370017));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(true));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("声音打开");
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131370018));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    ImageView localImageView;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1)
    {
      paramViewGroup = "前";
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("当前" + paramViewGroup + "置相机");
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370027));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365226));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131364406));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131370021));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131370022));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131370026));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131370023));
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131370024));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)a(2131370025));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131492969), 100, getResources().getColor(2131493308));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131370026));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localImageView = new ImageView(this);
      if (this.jdField_c_of_type_Int <= 0) {
        break label466;
      }
      localImageView.setImageBitmap(DynamicUtils.a(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int, this.jdField_c_of_type_Int / 2 - 8));
    }
    for (paramViewGroup = new FrameLayout.LayoutParams(-1, -1);; paramViewGroup = new FrameLayout.LayoutParams(1, 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(localImageView, -1, paramViewGroup);
      return;
      paramViewGroup = "后";
      break;
      label466:
      localImageView.setImageBitmap(DynamicUtils.a(5, 5, 2));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    if (VersionUtils.d())
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext)))
      {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_f_of_type_Boolean = false;
        ConfigurationInfo localConfigurationInfo = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
        paramBoolean = VideoEnvironment.a();
        if ((localConfigurationInfo == null) || (localConfigurationInfo.reqGlEsVersion < 131072) || (!paramBoolean)) {
          break label315;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)a(2131362089));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
        }
        ((FrameLayout.LayoutParams)localObject1).height = 1;
        ((FrameLayout.LayoutParams)localObject1).width = 1;
      }
    }
    for (;;)
    {
      ((View)localObject2).setId(2131362087);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
      this.jdField_d_of_type_Boolean = true;
      return;
      ((CameraTextureView)localObject2).a = new TexturePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {}
      for (((CameraPreview)localObject2).a = ((SurfacePreviewContext)localObject1);; ((CameraPreview)localObject2).a = new SurfacePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_f_of_type_Boolean = true;
        break;
      }
      label315:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)a(2131362089));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
    }
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "playVideo getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + ", errcode=" + i + ", hasFrame=" + bool);
    }
    if ((i != 0) || (!bool))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(0, "视频录制出错，请重新录制", false);
      c();
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("DynamicAvatarRecordActivity", 2, "playVideo isCurrentPreviewState= true......");
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Boolean = true;
      View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
    } while (!QLog.isColorLevel());
    QLog.i("DynamicAvatarRecordActivity", 2, "replay totaltime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setText("0\"");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public int d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "getCurrentBlockTimeLength()");
    }
    return 0;
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "deleteLastVideoSegment(), deleteNative = " + paramBoolean);
    }
  }
  
  public void n()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_InitState()");
    }
  }
  
  public void o()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_RecordState()");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      if (paramInt1 == 1)
      {
        if (this.jdField_a_of_type_Int != 1) {
          break label86;
        }
        if (!this.jdField_g_of_type_Boolean) {
          break label78;
        }
        setResult(-1, paramIntent);
        finish();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAvatarRecordActivity", 2, "onActivityResult，requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
      }
      return;
      label78:
      setResult(-1);
      break;
      label86:
      if ((this.jdField_a_of_type_Int == 2) && (paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getStringExtra("key_photo_file_path"))))
      {
        setResult(-1, paramIntent);
        finish();
        continue;
        if (paramInt2 == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃录制，当前视频将会被删除");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new abjt(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i = 1;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (((Boolean)this.jdField_a_of_type_AndroidWidgetButton.getTag()).booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d(false);
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(false));
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842462);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("声音关闭");
        if (this.jdField_a_of_type_Int == 1) {
          i = 0;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007104", "0X8007104", i, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842465);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("声音打开");
      break;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        b();
        i = j;
        if (this.jdField_a_of_type_Int == 1) {
          i = 0;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007105", "0X8007105", i, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          a("视频处理中...");
        }
        for (;;)
        {
          i = k;
          if (this.jdField_a_of_type_Int == 1) {
            i = 0;
          }
          ReportController.b(null, "dc00898", "", "", "0X8007109", "0X8007109", i, 0, "", "", "", "");
          return;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (new File(this.jdField_a_of_type_JavaLangString).exists()))
          {
            i();
          }
          else
          {
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
            QQToast.a(this, "发生错误，请重试。", 0).a();
          }
        }
      }
      if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
      {
        i = m;
        if (this.jdField_a_of_type_Int == 1) {
          i = 0;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007107", "0X8007107", i, 0, "", "", "", "");
        finish();
        return;
      }
    } while (paramView != this.jdField_d_of_type_AndroidWidgetTextView);
    EncodeThread.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
    g();
    this.jdField_a_of_type_JavaLangString = null;
    i = n;
    if (this.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    ReportController.b(null, "dc00898", "", "", "0X8007108", "0X8007108", i, 0, "", "", "", "");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("DynamicAvatarRecordActivity", 2, localStringBuilder.toString());
    }
    this.U = true;
    this.V = false;
    if (("Meizu".equals(Build.MANUFACTURER)) && ("M032".equals(Build.MODEL))) {
      this.jdField_e_of_type_Boolean = false;
    }
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    if (g())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
      return;
    }
    if (AudioHelper.b())
    {
      QQToast.a(this, "该机型不支持动态头像动能。", 0).a();
      finish();
      return;
    }
    PerfTracer.traceEnd("Video_component_onCreate");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
    }
    View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
    if (localView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087) == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() != 4)) {
      Looper.myQueue().addIdleHandler(new abjr(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    d();
  }
  
  protected void onStop()
  {
    super.onStop();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      if (this.h == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.h = 0;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("DynamicAvatarRecordActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
    }
  }
  
  public void p()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_IdleState()");
    }
  }
  
  public void q()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_previewState()");
    }
    int i = this.jdField_g_of_type_Int;
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.jdField_c_of_type_Int, i, j, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).c != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((RMVideoThumbGenMgr.ThumbGenItem)localObject2).c, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label146:
      break label146;
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(super.getResources(), localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
  }
  
  public void r()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initRecordEngineOK()");
    }
  }
  
  public void s()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "getFirstFrame()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(0);
    }
  }
  
  public void t()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "addOneSegment_RecordState()");
    }
  }
  
  public void u()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "notifyAvcodecOK()");
    }
  }
  
  public void w()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "onViewDestroy()");
    }
  }
  
  public void x()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "enterViewVideoMode()");
    }
  }
  
  public void y()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "exitViewVideoMode()");
    }
  }
  
  public void z()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "recordVideoFinish()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity
 * JD-Core Version:    0.7.0.1
 */