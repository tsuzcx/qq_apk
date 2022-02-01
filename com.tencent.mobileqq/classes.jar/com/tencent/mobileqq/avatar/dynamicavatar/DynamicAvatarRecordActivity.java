package com.tencent.mobileqq.avatar.dynamicavatar;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
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
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.FlowActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class DynamicAvatarRecordActivity
  extends FlowActivity
  implements View.OnClickListener, RMViewSTInterface
{
  Button B;
  TextView C;
  TextView D;
  ImageViewVideoPlayer E;
  TextView F;
  TextView G;
  TextView H;
  ImageView I;
  ImageView J;
  CircleProgress K;
  boolean L = true;
  int M = -1;
  int N = -1;
  ProgressDialog O;
  ActionSheet P;
  int Q;
  String R;
  QQCustomDialog S;
  volatile AtomicBoolean T = new AtomicBoolean(false);
  volatile AtomicBoolean U = new AtomicBoolean(false);
  View.OnTouchListener V = new DynamicAvatarRecordActivity.4(this);
  CameraExceptionHandler.Callback W = new DynamicAvatarRecordActivity.7(this);
  private boolean X;
  private int Y = 0;
  private BroadcastReceiver Z = new DynamicAvatarRecordActivity.1(this);
  int d;
  RMVideoStateMgr e = RMVideoStateMgr.a();
  int f = 0;
  int g = 0;
  boolean h = false;
  boolean i;
  CameraProxy j;
  Handler k = new Handler();
  CameraCover l;
  CameraGLSurfaceView m;
  Button n;
  
  private void A()
  {
    this.U.set(false);
    Intent localIntent = new Intent(this, SelectCoverActivity.class);
    localIntent.putExtra("param_source", this.d);
    localIntent.putExtra("param_from_newer_guide", this.X);
    localIntent.putExtra("key_video_file_path", this.R);
    localIntent.putExtra("key_video_duration", this.Q);
    boolean bool = ((Boolean)this.n.getTag()).booleanValue();
    String str2 = "1";
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localIntent.putExtra("key_video_has_voice", str1);
    String str1 = str2;
    if (FlowCameraConstant.b == 1) {
      str1 = "0";
    }
    localIntent.putExtra("key_camera_id", str1);
    startActivityForResult(localIntent, 1);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Object localObject = DynamicAvatarRecordActivity.class;
    if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.c)) {
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
    com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.b = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.a = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.e(paramBoolean))
    {
      this.h = this.e.c(16);
      return;
    }
    this.e.c(4);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.O == null)
      {
        this.O = new ReportProgressDialog(this, 2131953338);
        this.O.setCancelable(false);
        this.O.show();
        this.O.setContentView(2131625585);
      }
      ((TextView)this.O.findViewById(2131440191)).setText(paramString);
      if (!this.O.isShowing())
      {
        this.O.show();
        return;
      }
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog", paramString);
      }
    }
  }
  
  private void u()
  {
    if (this.Y == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.Z, localIntentFilter);
      this.Y = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void v()
  {
    runOnUiThread(new DynamicAvatarRecordActivity.5(this));
  }
  
  private void w()
  {
    v();
    s();
    ThreadManager.postImmediately(new DynamicAvatarRecordActivity.6(this), null, true);
  }
  
  private void x()
  {
    runOnUiThread(new DynamicAvatarRecordActivity.8(this));
  }
  
  private void y()
  {
    if (this.e.o == null) {
      return;
    }
    this.T.getAndSet(true);
    long l4 = System.currentTimeMillis();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (VideoEnvironment.supportSubmitCallback()) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new DynamicAvatarRecordActivity.9(this, localRMVideoStateMgr));
    } else {
      try
      {
        RecordManager.a().b().recordSubmit();
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAvatarRecordActivity", 2, " stopRecord Sync recordSubmit ...");
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAvatarRecordActivity", 2, " stopRecord...exception...UnsatisfiedLinkError");
        }
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    if (VideoEnvironment.supportSubmitCallback())
    {
      long l3 = 0L;
      synchronized (localRMVideoStateMgr.H)
      {
        boolean bool = localRMVideoStateMgr.H.get();
        long l2 = l3;
        long l1;
        if (!bool)
        {
          l1 = l3;
          try
          {
            if (QLog.isColorLevel())
            {
              l1 = l3;
              QLog.i("DynamicAvatarRecordActivity", 2, "[@] doInBackground before wait");
            }
            l1 = l3;
            l2 = SystemClock.elapsedRealtime();
            l1 = l3;
            localRMVideoStateMgr.H.wait(15000L);
            l1 = l3;
            l3 = SystemClock.elapsedRealtime() - l2;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l1 = l3;
              StringBuilder localStringBuilder1 = new StringBuilder();
              l1 = l3;
              localStringBuilder1.append("[@] doInBackground after wait, waitDuration = ");
              l1 = l3;
              localStringBuilder1.append(l3);
              l1 = l3;
              QLog.i("DynamicAvatarRecordActivity", 2, localStringBuilder1.toString());
              l2 = l3;
            }
          }
          catch (InterruptedException localInterruptedException2)
          {
            l2 = l1;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("[@] doInBackground, exception = ");
              localStringBuilder2.append(localInterruptedException2.getMessage());
              QLog.i("DynamicAvatarRecordActivity", 2, localStringBuilder2.toString());
              l2 = l1;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("DynamicAvatarRecordActivity", 2, "[@] doInBackground after sync block");
        }
        int i1;
        if (l2 < 30L)
        {
          int i2 = 30 - (int)l2;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("[@] doInBackground after sync block: needSleep=");
            ((StringBuilder)???).append(i2);
            QLog.d("DynamicAvatarRecordActivity", 2, ((StringBuilder)???).toString());
          }
          i1 = i2;
          if (i2 < 10) {
            i1 = 10;
          }
          l1 = i1;
        }
        try
        {
          Thread.sleep(l1);
        }
        catch (InterruptedException localInterruptedException1)
        {
          label421:
          Object localObject2;
          break label421;
        }
      }
    }
    else
    {
      if (localObject1.o == null) {
        return;
      }
      CodecParam.mRecordTime = (int)localObject1.n;
      CodecParam.mRecordFrames = localObject1.o.getFrameIndex();
      i1 = CodecParam.mGopSize;
      CodecParam.mGopSize = -1;
      localObject2 = new EncodeThread(null, null, localObject1.s, null, null);
      ((EncodeThread)localObject2).setEnableHardEncode(true);
      ((EncodeThread)localObject2).setEnableDeleteCache(false);
      ((EncodeThread)localObject2).setEnableBaselineMp4Encode(true);
      ((EncodeThread)localObject2).run();
      CodecParam.mGopSize = i1;
      this.R = ((EncodeThread)localObject2).mTargetFilePath;
      if (!TextUtils.isEmpty(this.R))
      {
        localObject2 = new File(this.R);
        if (((File)localObject2).exists())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append(((File)localObject2).getParent());
          ((StringBuilder)???).append(File.separator);
          ((StringBuilder)???).append(".nomedia");
          FileUtils.createFileIfNotExits(((StringBuilder)???).toString());
        }
      }
      this.T.getAndSet(false);
      if (this.U.get())
      {
        r();
        A();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("video encode finished, mVideoPath = ");
        ((StringBuilder)localObject2).append(this.R);
        ((StringBuilder)localObject2).append(", time cost = ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l4);
        QLog.i("DynamicAvatarRecordActivity", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
  }
  
  private boolean z()
  {
    this.B.setEnabled(false);
    this.e.r();
    a(104);
    this.l.removeViewAt(0);
    if (FlowCameraConstant.b == 1) {
      FlowCameraConstant.b = 2;
    } else {
      FlowCameraConstant.b = 1;
    }
    int i1;
    if (FlowCameraConstant.b == 1) {
      i1 = 2131901664;
    } else {
      i1 = 2131901670;
    }
    String str = HardCodeUtil.a(i1);
    Button localButton = this.B;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901673));
    localStringBuilder.append(str);
    localStringBuilder.append(HardCodeUtil.a(2131901674));
    localButton.setContentDescription(localStringBuilder.toString());
    b(false);
    this.B.setEnabled(true);
    this.e.q();
    return true;
  }
  
  int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i2 = this.l.getMeasuredHeight();
    int i4 = (int)(paramInt2 * FlowCameraConstant.a);
    int i1 = this.f;
    if (i2 <= i1)
    {
      i2 = (i2 - (int)(i2 * 0.83F)) / 2;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = i4;
      paramInt1 = i1;
    }
    else
    {
      paramInt1 = paramInt1 * i1 / paramInt2;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = (i2 * paramInt2 / i1);
      i2 = (i2 - i1) / 2;
    }
    if (paramBoolean) {
      paramInt1 = i1;
    }
    int i3 = i1;
    if (i1 % 2 != 0) {
      i3 = i1 - 1;
    }
    i1 = paramInt1;
    if (paramInt1 % 2 != 0) {
      i1 = paramInt1 - 1;
    }
    paramArrayOfInt[2] = i3;
    paramArrayOfInt[3] = i1;
    paramArrayOfInt[4] = paramInt2;
    paramArrayOfInt[5] = i4;
    return i2;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_InitState()");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("realDeleteVideoSegment(), delReason = ");
      localStringBuilder.append(paramInt);
      QLog.i("DynamicAvatarRecordActivity", 4, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("previewSizeAdjustUI(), width = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", height = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("DynamicAvatarRecordActivity", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "[previewSizeAdjustUI]rmStateMgr == null");
      }
      return;
    }
    this.M = paramInt1;
    this.N = paramInt2;
    int[] arrayOfInt = new int[6];
    RMVideoClipSpec localRMVideoClipSpec = ((RMVideoStateMgr)localObject).J;
    localObject = this.m;
    if (localObject == null) {
      localObject = findViewById(2131433436);
    }
    boolean bool;
    if (localObject == this.m) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramInt1, paramInt2, arrayOfInt, bool);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a((View)localObject);
    localLayoutParams.width = arrayOfInt[2];
    localLayoutParams.height = arrayOfInt[3];
    ((View)localObject).setLayoutParams(localLayoutParams);
    localRMVideoClipSpec.c = arrayOfInt[0];
    localRMVideoClipSpec.d = arrayOfInt[1];
    localRMVideoClipSpec.e = 480;
    localRMVideoClipSpec.f = 480;
    this.e.a(localRMVideoClipSpec, false);
    localObject = this.m;
    if (localObject != null) {
      ((CameraGLSurfaceView)localObject).setPreviewSize(this.M, this.N, localRMVideoClipSpec);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorOcured(), errCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errMsg = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isReport = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("DynamicAvatarRecordActivity", 4, localStringBuilder.toString());
    }
    runOnUiThread(new DynamicAvatarRecordActivity.11(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.Q = paramInt;
    RMVideoStateMgr localRMVideoStateMgr = this.e;
    localRMVideoStateMgr.w += 1;
    if (paramBoolean)
    {
      v();
      return;
    }
    ThreadManager.getUIHandler().post(new DynamicAvatarRecordActivity.10(this, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = paramBundle.getInt("param_source", 0);
    this.X = paramBundle.getBoolean("param_from_newer_guide", false);
    if (this.d != 0)
    {
      FlowCameraConstant.b = 1;
      if (!CameraAbility.d()) {
        FlowCameraConstant.b = 2;
      }
      FlowCameraConstant.a = 1.0F;
      a(paramBundle, false);
      this.e.a(4, 8);
      boolean bool = this.e.a(this, getAppRuntime().getAccount(), this);
      this.e.f(false);
      if (!bool)
      {
        super.finish();
        return;
      }
      paramBundle = getResources().getDisplayMetrics();
      this.f = paramBundle.widthPixels;
      this.g = paramBundle.heightPixels;
      if (this.f <= 0)
      {
        paramBundle = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
        this.f = paramBundle.widthPixels;
        this.g = paramBundle.heightPixels;
      }
      this.j = new CameraProxy(this, this.k);
      this.e.a(this.j);
      this.j.a(new CameraExceptionHandler(this.k, this.W));
      return;
    }
    throw new IllegalArgumentException("source must not be null");
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2131627385, paramViewGroup);
    this.l = ((CameraCover)findViewById(2131433446));
    paramViewGroup = (LinearLayout.LayoutParams)this.l.getLayoutParams();
    paramViewGroup.height = this.f;
    this.l.setLayoutParams(paramViewGroup);
    this.n = ((Button)findViewById(2131449961));
    this.n.setEnabled(false);
    this.n.setTag(Boolean.valueOf(true));
    this.n.setContentDescription(HardCodeUtil.a(2131901665));
    this.B = ((Button)findViewById(2131430256));
    this.B.setEnabled(false);
    if (FlowCameraConstant.b == 1) {
      i1 = 2131901661;
    } else {
      i1 = 2131901679;
    }
    paramViewGroup = HardCodeUtil.a(i1);
    Object localObject = this.B;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901676));
    localStringBuilder.append(paramViewGroup);
    localStringBuilder.append(HardCodeUtil.a(2131901677));
    ((Button)localObject).setContentDescription(localStringBuilder.toString());
    this.C = ((TextView)findViewById(2131444500));
    this.D = ((TextView)findViewById(2131440606));
    this.E = ((ImageViewVideoPlayer)findViewById(2131433450));
    this.F = ((TextView)findViewById(2131431380));
    this.G = ((TextView)findViewById(2131431384));
    this.H = ((TextView)findViewById(2131431381));
    this.I = ((ImageView)findViewById(2131431382));
    this.I.setEnabled(false);
    this.I.setOnTouchListener(this.V);
    this.J = ((ImageView)findViewById(2131431383));
    this.K = ((CircleProgress)findViewById(2131444490));
    this.K.setBgAndProgressColor(100, getResources().getColor(2131168464), 100, getResources().getColor(2131165591));
    this.K.setStrokeWidth(6.0F);
    this.H = ((TextView)findViewById(2131431381));
    this.n.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setOnClickListener(this);
    localObject = new ImageView(this);
    int i1 = this.f;
    if (i1 > 0)
    {
      ((ImageView)localObject).setImageBitmap(DynamicUtils.a(i1, i1, i1 / 2 - 8));
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    }
    else
    {
      ((ImageView)localObject).setImageBitmap(DynamicUtils.a(5, 5, 2));
      paramViewGroup = new FrameLayout.LayoutParams(1, 1);
    }
    this.l.addView((View)localObject, -1, paramViewGroup);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteLastVideoSegment(), deleteNative = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("DynamicAvatarRecordActivity", 4, localStringBuilder.toString());
    }
  }
  
  void b(boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1;
    if ((a(this.l, 2131433436) == null) && (paramBoolean)) {
      localObject1 = this.e.o;
    } else {
      localObject1 = null;
    }
    if (VersionUtils.d())
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext))) {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
      } else {
        ((CameraTextureView)localObject2).a = new TexturePreviewContext(this.j, this.f, this.g);
      }
      this.e.a(((CameraTextureView)localObject2).a);
      localObject1 = localObject2;
    }
    else
    {
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {
        ((CameraPreview)localObject2).b = ((SurfacePreviewContext)localObject1);
      } else {
        ((CameraPreview)localObject2).b = new SurfacePreviewContext(this.j, this.f, this.g);
      }
      this.e.a(((CameraPreview)localObject2).b);
      localObject1 = localObject2;
    }
    Object localObject2 = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
    paramBoolean = VideoEnvironment.isBeautySupported();
    if ((localObject2 != null) && (((ConfigurationInfo)localObject2).reqGlEsVersion >= 131072) && (paramBoolean))
    {
      this.m = ((CameraGLSurfaceView)findViewById(2131433452));
      localObject2 = this.m;
      if (localObject2 != null) {
        ((CameraGLSurfaceView)localObject2).setVideoContext(this.e.o);
      }
      localLayoutParams.height = 1;
      localLayoutParams.width = 1;
    }
    else
    {
      this.m = ((CameraGLSurfaceView)findViewById(2131433452));
      this.m.setVisibility(8);
      this.m = null;
    }
    ((View)localObject1).setId(2131433436);
    this.l.addView((View)localObject1, 0, localLayoutParams);
    this.l.setCameraView((View)localObject1);
    this.i = true;
  }
  
  public void cb_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_RecordState()");
    }
  }
  
  public void cc_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_IdleState()");
    }
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_previewState()");
    }
    int i1 = this.Q;
    int i2 = this.e.o.getFrameIndex();
    this.E.initPlayer(CodecParam.RECORD_MAX_TIME, i1, i2, this.e.s);
    this.E.setCyclePlay(true);
    Object localObject2 = this.e.e.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).h != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.E.mLoadingBitmap == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((RMVideoThumbGenMgr.ThumbGenItem)localObject2).h, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label146:
      break label146;
    }
    if (localObject1 != null) {
      this.E.mLoadingBitmap = new BitmapDrawable(super.getResources(), localObject1);
    }
    this.E.startPlayer();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initRecordEngineOK()");
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "addOneSegment_RecordState()");
    }
  }
  
  public void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "recordVideoFinish()");
    }
    this.e.m();
    this.e.r();
    w();
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "onViewDestroy()");
    }
  }
  
  public void i()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "getFirstFrame()");
    }
    CameraGLSurfaceView localCameraGLSurfaceView = this.m;
    if ((localCameraGLSurfaceView != null) && (localCameraGLSurfaceView.getVisibility() != 0)) {
      this.m.setVisibility(0);
    }
  }
  
  public void j()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "finishUI()");
    }
  }
  
  public void k()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "notifyAvcodecOK()");
    }
  }
  
  public int l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "getCurrentBlockTimeLength()");
    }
    return 0;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        int i1 = this.d;
        if (i1 == 1)
        {
          if (this.X) {
            setResult(-1, paramIntent);
          } else {
            setResult(-1);
          }
          finish();
        }
        else if ((i1 == 2) && (paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getStringExtra("key_photo_file_path"))))
        {
          setResult(-1, paramIntent);
          finish();
        }
      }
    }
    else if (paramInt2 == 0) {
      this.e.b(false);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult，requestCode:");
      paramIntent.append(paramInt1);
      paramIntent.append(",resultCode:");
      paramIntent.append(paramInt2);
      QLog.d("DynamicAvatarRecordActivity", 2, paramIntent.toString());
    }
  }
  
  public void onBackPressed()
  {
    if (this.e.n == 0.0D)
    {
      finish();
      return;
    }
    if (this.P == null) {
      this.P = ActionSheet.createFullScreenDialog(this, false);
    }
    this.P.setMainTitle(HardCodeUtil.a(2131901678));
    this.P.addButton(HardCodeUtil.a(2131901671), 3);
    this.P.addCancelButton(HardCodeUtil.a(2131898212));
    this.P.setOnButtonClickListener(new DynamicAvatarRecordActivity.3(this));
    this.P.show();
  }
  
  public void onClick(View paramView)
  {
    Button localButton = this.n;
    int i1;
    if (paramView == localButton)
    {
      if (((Boolean)localButton.getTag()).booleanValue())
      {
        this.e.d(false);
        this.n.setTag(Boolean.valueOf(false));
        this.n.setBackgroundResource(2130846510);
        this.n.setContentDescription(HardCodeUtil.a(2131901667));
      }
      else
      {
        this.e.d(true);
        this.n.setTag(Boolean.valueOf(true));
        this.n.setBackgroundResource(2130846513);
        this.n.setContentDescription(HardCodeUtil.a(2131901672));
      }
      if (this.d == 1) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007104", "0X8007104", i1, 0, "", "", "", "");
    }
    else if (paramView == this.B)
    {
      z();
      if (this.d == 1) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007105", "0X8007105", i1, 0, "", "", "", "");
    }
    else if (paramView == this.H)
    {
      this.U.set(true);
      if (this.T.get())
      {
        a(HardCodeUtil.a(2131901663));
      }
      else if ((!TextUtils.isEmpty(this.R)) && (new File(this.R).exists()))
      {
        A();
      }
      else
      {
        this.U.set(false);
        QQToast.makeText(this, HardCodeUtil.a(2131901662), 0).show();
      }
      if (this.d == 1) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007109", "0X8007109", i1, 0, "", "", "", "");
    }
    else if (paramView == this.F)
    {
      if (this.d == 1) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007107", "0X8007107", i1, 0, "", "", "", "");
      finish();
    }
    else if (paramView == this.G)
    {
      EncodeThread.cancelCurrentEncoder();
      this.E.stopPlayer();
      this.E.releasePlayer();
      b(true);
      this.e.b(false);
      this.e.h();
      x();
      this.R = null;
      if (this.d == 1) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007108", "0X8007108", i1, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.OPEN_CAMERA"), "com.tencent.msg.permission.pushnotify");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=");
      localStringBuilder.append(Build.PRODUCT);
      localStringBuilder.append("|");
      localStringBuilder.append("MODEL=");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("|");
      localStringBuilder.append("BOARD=");
      localStringBuilder.append(Build.BOARD);
      localStringBuilder.append("|");
      localStringBuilder.append("BOOTLOADER=");
      localStringBuilder.append(Build.BOOTLOADER);
      localStringBuilder.append("|");
      localStringBuilder.append("CPU_ABI=");
      localStringBuilder.append(Build.CPU_ABI);
      localStringBuilder.append("|");
      localStringBuilder.append("CPU_ABI2=");
      localStringBuilder.append(Build.CPU_ABI2);
      localStringBuilder.append("|");
      localStringBuilder.append("DEVICE=");
      localStringBuilder.append(Build.DEVICE);
      localStringBuilder.append("|");
      localStringBuilder.append("DISPLAY=");
      localStringBuilder.append(Build.DISPLAY);
      localStringBuilder.append("|");
      localStringBuilder.append("FLNGERPRINT=");
      localStringBuilder.append(Build.FINGERPRINT);
      localStringBuilder.append("|");
      localStringBuilder.append("HARDWARE=");
      localStringBuilder.append(Build.HARDWARE);
      localStringBuilder.append("|");
      localStringBuilder.append("ID=");
      localStringBuilder.append(Build.ID);
      localStringBuilder.append("|");
      localStringBuilder.append("MANUFACTURER=");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("|");
      localStringBuilder.append("SDK_INT=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append("|");
      QLog.i("DynamicAvatarRecordActivity", 2, localStringBuilder.toString());
    }
    this.y = true;
    this.z = false;
    if (("Meizu".equals(Build.MANUFACTURER)) && ("M032".equals(Build.MODEL))) {
      this.L = false;
    }
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    if (p())
    {
      QQToast.makeText(this, HardCodeUtil.a(2131901668), 0).show();
      finish();
      return;
    }
    if (AudioPlayerHelper.e())
    {
      QQToast.makeText(this, HardCodeUtil.a(2131901666), 0).show();
      finish();
      return;
    }
    PerfTracer.traceEnd("Video_component_onCreate");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.e.g();
    QQCustomDialog localQQCustomDialog = this.S;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.S = null;
    }
    sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.CLOSE_CAMERA"), "com.tencent.msg.permission.pushnotify");
  }
  
  protected void onPause()
  {
    super.onPause();
    this.e.f();
    Object localObject = this.m;
    if (localObject != null) {
      ((CameraGLSurfaceView)localObject).onPause();
    }
    localObject = a(this.l, 2131433436);
    if (localObject != null) {
      this.l.removeView((View)localObject);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.i) {
      this.e.e();
    }
    if ((a(this.l, 2131433436) == null) && (this.e.G.get() != 4)) {
      Looper.myQueue().addIdleHandler(new DynamicAvatarRecordActivity.2(this));
    }
    CameraGLSurfaceView localCameraGLSurfaceView = this.m;
    if (localCameraGLSurfaceView != null) {
      localCameraGLSurfaceView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    u();
  }
  
  protected void onStop()
  {
    super.onStop();
    try
    {
      if (this.E != null) {
        this.E.stopPlayer();
      }
      this.e.h();
      if (this.Y == 1)
      {
        unregisterReceiver(this.Z);
        this.Y = 0;
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" already unregisterReceiver");
        localStringBuilder.append(localIllegalArgumentException);
        QLog.i("DynamicAvatarRecordActivity", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 2, "dismissProgressDialog");
    }
    try
    {
      if (this.O != null) {
        this.O.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void s()
  {
    int i1 = this.E.getVFileAndAFile(this.e.s);
    boolean bool = this.E.checkVideoSourceValidate(this.e);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playVideo getVFileAndAFile=");
      ((StringBuilder)localObject).append(this.e.s);
      ((StringBuilder)localObject).append(", errcode=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", hasFrame=");
      ((StringBuilder)localObject).append(bool);
      QLog.i("DynamicAvatarRecordActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((i1 == 0) && (bool))
    {
      if (this.e.b())
      {
        if (QLog.isColorLevel()) {
          QLog.i("DynamicAvatarRecordActivity", 2, "playVideo isCurrentPreviewState= true......");
        }
        return;
      }
      this.E.mSecurityChecked = true;
      localObject = a(this.l, 2131433436);
      if (localObject != null) {
        this.l.removeView((View)localObject);
      }
      this.e.a(4);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("replay totaltime = ");
        ((StringBuilder)localObject).append((int)this.e.n);
        QLog.i("DynamicAvatarRecordActivity", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.e.b(0, HardCodeUtil.a(2131901669), false);
    t();
  }
  
  public void t()
  {
    RMVideoStateMgr localRMVideoStateMgr = this.e;
    if (localRMVideoStateMgr != null)
    {
      localRMVideoStateMgr.b(false);
      this.e.h();
      this.C.setText("0\"");
      this.C.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity
 * JD-Core Version:    0.7.0.1
 */