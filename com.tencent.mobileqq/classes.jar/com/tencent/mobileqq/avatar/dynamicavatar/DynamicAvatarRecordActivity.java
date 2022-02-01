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
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new DynamicAvatarRecordActivity.1(this);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new DynamicAvatarRecordActivity.4(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
  CameraCover jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover;
  CameraGLSurfaceView jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new DynamicAvatarRecordActivity.7(this);
  CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  String jdField_a_of_type_JavaLangString;
  volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_b_of_type_Boolean = false;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = true;
  int jdField_e_of_type_Int = 0;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  int f = -1;
  int g = -1;
  int h;
  private int i;
  private boolean k;
  
  public DynamicAvatarRecordActivity()
  {
    this.jdField_i_of_type_Int = 0;
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
    com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_a_of_type_Int = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.a(paramBoolean))
    {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(16);
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
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
      }
      ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646)).setText(paramString);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
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
  
  private boolean d()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
    a(104);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
      FlowCameraConstant.jdField_a_of_type_Int = 2;
    } else {
      FlowCameraConstant.jdField_a_of_type_Int = 1;
    }
    int j;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
      j = 2131703717;
    } else {
      j = 2131703724;
    }
    String str = HardCodeUtil.a(j);
    Button localButton = this.jdField_b_of_type_AndroidWidgetButton;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703727));
    localStringBuilder.append(str);
    localStringBuilder.append(HardCodeUtil.a(2131703728));
    localButton.setContentDescription(localStringBuilder.toString());
    b(false);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.j();
    return true;
  }
  
  private void q()
  {
    if (this.jdField_i_of_type_Int == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_i_of_type_Int = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void r()
  {
    runOnUiThread(new DynamicAvatarRecordActivity.5(this));
  }
  
  private void s()
  {
    r();
    o();
    ThreadManager.postImmediately(new DynamicAvatarRecordActivity.6(this), null, true);
  }
  
  private void t()
  {
    runOnUiThread(new DynamicAvatarRecordActivity.8(this));
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
    long l4 = System.currentTimeMillis();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (VideoEnvironment.supportSubmitCallback()) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new DynamicAvatarRecordActivity.9(this, localRMVideoStateMgr));
    } else {
      try
      {
        RecordManager.a().a().recordSubmit();
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
      synchronized (localRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        boolean bool = localRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
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
            localRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(15000L);
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
        int j;
        if (l2 < 30L)
        {
          int m = 30 - (int)l2;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("[@] doInBackground after sync block: needSleep=");
            ((StringBuilder)???).append(m);
            QLog.d("DynamicAvatarRecordActivity", 2, ((StringBuilder)???).toString());
          }
          j = m;
          if (m < 10) {
            j = 10;
          }
          l1 = j;
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
      if (localObject1.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null) {
        return;
      }
      CodecParam.mRecordTime = (int)localObject1.jdField_a_of_type_Double;
      CodecParam.mRecordFrames = localObject1.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      j = CodecParam.mGopSize;
      CodecParam.mGopSize = -1;
      localObject2 = new EncodeThread(null, null, localObject1.jdField_a_of_type_JavaLangString, null, null);
      ((EncodeThread)localObject2).setEnableHardEncode(true);
      ((EncodeThread)localObject2).setEnableDeleteCache(false);
      ((EncodeThread)localObject2).setEnableBaselineMp4Encode(true);
      ((EncodeThread)localObject2).run();
      CodecParam.mGopSize = j;
      this.jdField_a_of_type_JavaLangString = ((EncodeThread)localObject2).mTargetFilePath;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject2 = new File(this.jdField_a_of_type_JavaLangString);
        if (((File)localObject2).exists())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append(((File)localObject2).getParent());
          ((StringBuilder)???).append(File.separator);
          ((StringBuilder)???).append(".nomedia");
          FileUtils.createFileIfNotExits(((StringBuilder)???).toString());
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        n();
        v();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("video encode finished, mVideoPath = ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", time cost = ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l4);
        QLog.i("DynamicAvatarRecordActivity", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
  }
  
  private void v()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Intent localIntent = new Intent(this, SelectCoverActivity.class);
    localIntent.putExtra("param_source", this.jdField_b_of_type_Int);
    localIntent.putExtra("param_from_newer_guide", this.k);
    localIntent.putExtra("key_video_file_path", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_video_duration", this.h);
    boolean bool = ((Boolean)this.jdField_a_of_type_AndroidWidgetButton.getTag()).booleanValue();
    String str2 = "1";
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localIntent.putExtra("key_video_has_voice", str1);
    String str1 = str2;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
      str1 = "0";
    }
    localIntent.putExtra("key_camera_id", str1);
    startActivityForResult(localIntent, 1);
  }
  
  public int a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "getCurrentBlockTimeLength()");
    }
    return 0;
  }
  
  int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getMeasuredHeight();
    int i1 = (int)(paramInt2 * FlowCameraConstant.jdField_a_of_type_Float);
    int j = this.jdField_d_of_type_Int;
    if (m <= j)
    {
      m = (m - (int)(m * 0.83F)) / 2;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = i1;
      paramInt1 = j;
    }
    else
    {
      paramInt1 = paramInt1 * j / paramInt2;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = (m * paramInt2 / j);
      m = (m - j) / 2;
    }
    if (paramBoolean) {
      paramInt1 = j;
    }
    int n = j;
    if (j % 2 != 0) {
      n = j - 1;
    }
    j = paramInt1;
    if (paramInt1 % 2 != 0) {
      j = paramInt1 - 1;
    }
    paramArrayOfInt[2] = n;
    paramArrayOfInt[3] = j;
    paramArrayOfInt[4] = paramInt2;
    paramArrayOfInt[5] = i1;
    return m;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DynamicAvatarRecordActivity", 2, "[previewSizeAdjustUI]rmStateMgr == null");
      }
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
    int[] arrayOfInt = new int[6];
    RMVideoClipSpec localRMVideoClipSpec = ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
    if (localObject == null) {
      localObject = findViewById(2131366988);
    }
    boolean bool;
    if (localObject == this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView) {
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
    localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
    localRMVideoClipSpec.jdField_e_of_type_Int = 480;
    localRMVideoClipSpec.f = 480;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
    if (localObject != null) {
      ((CameraGLSurfaceView)localObject).setPreviewSize(this.f, this.g, localRMVideoClipSpec);
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
    this.h = paramInt;
    RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
    localRMVideoStateMgr.jdField_a_of_type_Int += 1;
    if (paramBoolean)
    {
      r();
      return;
    }
    ThreadManager.getUIHandler().post(new DynamicAvatarRecordActivity.10(this, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_b_of_type_Int = paramBundle.getInt("param_source", 0);
    this.k = paramBundle.getBoolean("param_from_newer_guide", false);
    if (this.jdField_b_of_type_Int != 0)
    {
      FlowCameraConstant.jdField_a_of_type_Int = 1;
      if (!CameraAbility.c()) {
        FlowCameraConstant.jdField_a_of_type_Int = 2;
      }
      FlowCameraConstant.jdField_a_of_type_Float = 1.0F;
      a(paramBundle, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4, 8);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, getAppRuntime().getAccount(), this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e(false);
      if (!bool)
      {
        super.finish();
        return;
      }
      paramBundle = getResources().getDisplayMetrics();
      this.jdField_d_of_type_Int = paramBundle.widthPixels;
      this.jdField_e_of_type_Int = paramBundle.heightPixels;
      if (this.jdField_d_of_type_Int <= 0)
      {
        paramBundle = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
        this.jdField_d_of_type_Int = paramBundle.widthPixels;
        this.jdField_e_of_type_Int = paramBundle.heightPixels;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
      return;
    }
    throw new IllegalArgumentException("source must not be null");
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2131561043, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)findViewById(2131366998));
    paramViewGroup = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getLayoutParams();
    paramViewGroup.height = this.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setLayoutParams(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131380970));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(true));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131703718));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364244));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
      j = 2131703714;
    } else {
      j = 2131703733;
    }
    paramViewGroup = HardCodeUtil.a(j);
    Object localObject = this.jdField_b_of_type_AndroidWidgetButton;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703730));
    localStringBuilder.append(paramViewGroup);
    localStringBuilder.append(HardCodeUtil.a(2131703731));
    ((Button)localObject).setContentDescription(localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376291));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373027));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)findViewById(2131367002));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365214));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365218));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365215));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365216));
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365217));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131376281));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167394), 100, getResources().getColor(2131165349));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365215));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    localObject = new ImageView(this);
    int j = this.jdField_d_of_type_Int;
    if (j > 0)
    {
      ((ImageView)localObject).setImageBitmap(DynamicUtils.a(j, j, j / 2 - 8));
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    }
    else
    {
      ((ImageView)localObject).setImageBitmap(DynamicUtils.a(5, 5, 2));
      paramViewGroup = new FrameLayout.LayoutParams(1, 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject, -1, paramViewGroup);
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
  
  public void ag_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DynamicAvatarRecordActivity", 4, "initUI_RecordState()");
    }
  }
  
  void b(boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1;
    if ((a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366988) == null) && (paramBoolean)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
    } else {
      localObject1 = null;
    }
    if (VersionUtils.d())
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext))) {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
      } else {
        ((CameraTextureView)localObject2).a = new TexturePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
      localObject1 = localObject2;
    }
    else
    {
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {
        ((CameraPreview)localObject2).a = ((SurfacePreviewContext)localObject1);
      } else {
        ((CameraPreview)localObject2).a = new SurfacePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
      localObject1 = localObject2;
    }
    Object localObject2 = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
    paramBoolean = VideoEnvironment.isBeautySupported();
    if ((localObject2 != null) && (((ConfigurationInfo)localObject2).reqGlEsVersion >= 131072) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)findViewById(2131367004));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
      if (localObject2 != null) {
        ((CameraGLSurfaceView)localObject2).setVideoContext(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
      }
      localLayoutParams.height = 1;
      localLayoutParams.width = 1;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)findViewById(2131367004));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
    }
    ((View)localObject1).setId(2131366988);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject1, 0, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject1);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
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
    int j = this.h;
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initPlayer(CodecParam.RECORD_MAX_TIME, j, m, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).c != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLoadingBitmap == null))
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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLoadingBitmap = new BitmapDrawable(super.getResources(), localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
    s();
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
    CameraGLSurfaceView localCameraGLSurfaceView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
    if ((localCameraGLSurfaceView != null) && (localCameraGLSurfaceView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(0);
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
  
  protected void n()
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
  
  public void o()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getVFileAndAFile(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.checkVideoSourceValidate(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playVideo getVFileAndAFile=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", errcode=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", hasFrame=");
      ((StringBuilder)localObject).append(bool);
      QLog.i("DynamicAvatarRecordActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((j == 0) && (bool))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("DynamicAvatarRecordActivity", 2, "playVideo isCurrentPreviewState= true......");
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mSecurityChecked = true;
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366988);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("replay totaltime = ");
        ((StringBuilder)localObject).append((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        QLog.i("DynamicAvatarRecordActivity", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(0, HardCodeUtil.a(2131703723), false);
    p();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        int j = this.jdField_b_of_type_Int;
        if (j == 1)
        {
          if (this.k) {
            setResult(-1, paramIntent);
          } else {
            setResult(-1);
          }
          finish();
        }
        else if ((j == 2) && (paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getStringExtra("key_photo_file_path"))))
        {
          setResult(-1, paramIntent);
          finish();
        }
      }
    }
    else if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createFullScreenDialog(this, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(HardCodeUtil.a(2131703732));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131703725), 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131703719));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new DynamicAvatarRecordActivity.3(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void onClick(View paramView)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    int j;
    if (paramView == localButton)
    {
      if (((Boolean)localButton.getTag()).booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d(false);
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(false));
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845073);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131703721));
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d(true);
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(true));
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845076);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131703726));
      }
      if (this.jdField_b_of_type_Int == 1) {
        j = 0;
      } else {
        j = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007104", "0X8007104", j, 0, "", "", "", "");
    }
    else if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
    {
      d();
      if (this.jdField_b_of_type_Int == 1) {
        j = 0;
      } else {
        j = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007105", "0X8007105", j, 0, "", "", "", "");
    }
    else if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        a(HardCodeUtil.a(2131703716));
      }
      else if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (new File(this.jdField_a_of_type_JavaLangString).exists()))
      {
        v();
      }
      else
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QQToast.a(this, HardCodeUtil.a(2131703715), 0).a();
      }
      if (this.jdField_b_of_type_Int == 1) {
        j = 0;
      } else {
        j = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007109", "0X8007109", j, 0, "", "", "", "");
    }
    else if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
    {
      if (this.jdField_b_of_type_Int == 1) {
        j = 0;
      } else {
        j = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007107", "0X8007107", j, 0, "", "", "", "");
      finish();
    }
    else if (paramView == this.jdField_d_of_type_AndroidWidgetTextView)
    {
      EncodeThread.cancelCurrentEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      t();
      this.jdField_a_of_type_JavaLangString = null;
      if (this.jdField_b_of_type_Int == 1) {
        j = 0;
      } else {
        j = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X8007108", "0X8007108", j, 0, "", "", "", "");
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
    this.jdField_i_of_type_Boolean = true;
    this.j = false;
    if (("Meizu".equals(Build.MANUFACTURER)) && ("M032".equals(Build.MODEL))) {
      this.jdField_d_of_type_Boolean = false;
    }
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    if (c())
    {
      QQToast.a(this, HardCodeUtil.a(2131703722), 0).a();
      finish();
      return;
    }
    if (AudioPlayerHelper.a())
    {
      QQToast.a(this, HardCodeUtil.a(2131703720), 0).a();
      finish();
      return;
    }
    PerfTracer.traceEnd("Video_component_onCreate");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.CLOSE_CAMERA"), "com.tencent.msg.permission.pushnotify");
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
    if (localObject != null) {
      ((CameraGLSurfaceView)localObject).onPause();
    }
    localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366988);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366988) == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() != 4)) {
      Looper.myQueue().addIdleHandler(new DynamicAvatarRecordActivity.2(this));
    }
    CameraGLSurfaceView localCameraGLSurfaceView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
    if (localCameraGLSurfaceView != null) {
      localCameraGLSurfaceView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    q();
  }
  
  protected void onStop()
  {
    super.onStop();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      if (this.jdField_i_of_type_Int == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_i_of_type_Int = 0;
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
  
  public void p()
  {
    RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
    if (localRMVideoStateMgr != null)
    {
      localRMVideoStateMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setText("0\"");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity
 * JD-Core Version:    0.7.0.1
 */