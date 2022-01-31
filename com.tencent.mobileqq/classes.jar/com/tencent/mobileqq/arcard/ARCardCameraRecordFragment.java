package com.tencent.mobileqq.arcard;

import aalk;
import aall;
import aalm;
import aaln;
import aalo;
import aalp;
import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.hiar.sdk.utils.GlUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.ARGLSurfaceView.ARGLSurfaceViewCallback;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController.RecordListener;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManager;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.ARCamera.AutoFocusListener;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

@TargetApi(14)
public class ARCardCameraRecordFragment
  extends Fragment
  implements Camera.PreviewCallback, SurfaceHolder.Callback, View.OnClickListener, ARGLSurfaceView.ARGLSurfaceViewCallback, VideoRecordController.RecordListener, ARRenderManagerCallBack, ARCamera.AutoFocusListener
{
  public int a;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ARGLSurfaceView jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  private ARRenderManager jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager;
  public ARCamera a;
  private ARCardCamereButtonLayout jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout;
  private OnCameraVideoRecordListener jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  public RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f = 0;
  private int g;
  private int h;
  private int i = 300;
  private int j;
  private int k;
  private int l;
  
  public ARCardCameraRecordFragment()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout = ((ARCardCamereButtonLayout)paramView.findViewById(2131363280));
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout.a(new aalk(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366955));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369228));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369526));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369527));
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeFile(ARResouceDir.c() + "arcard_videorecord_bg.png", localOptions));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369528));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
      }
      return;
    }
  }
  
  private void d()
  {
    if (!CameraAbility.c()) {
      this.jdField_a_of_type_Int = 0;
    }
    this.j = ARCardUtils.a(getActivity());
    this.k = ARCardUtils.b(getActivity());
  }
  
  private void e()
  {
    a(new aall(this));
  }
  
  private void f()
  {
    QLog.i("ARCardCameraRecordFragment", 2, "startPreviewAfterSurfaceCtreated.");
    if ((this.f != 2) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera == null) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.g = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a();
    this.h = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.b();
    this.jdField_b_of_type_Int = GlUtil.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_b_of_type_Int);
    QLog.i("ARCardCameraRecordFragment", 1, "mTextureId = " + this.jdField_b_of_type_Int + ", realImageWidth = " + this.g + ", realImageHeight = " + this.h);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this);
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.i("ARCardCameraRecordFragment", 2, "start preview successfully. mCurCameraState = " + this.f);
      if ((this.jdField_d_of_type_Int > 0) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.g, this.h, this.j, this.k);
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(false, 0.0F, 0.0F);
      }
      QLog.i("ARCardCameraRecordFragment", 2, "openCamera end. mIsCameraPreviewing = " + this.jdField_a_of_type_Boolean);
      return;
    }
    QLog.i("ARCardCameraRecordFragment", 2, "start preview failed. mCurCameraState = " + this.f);
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a();
    this.f = 0;
  }
  
  private void g()
  {
    boolean bool = VideoEncoderUtils.a();
    QLog.d("ARCardCameraRecordFragment", 2, String.format("initVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = new VideoRecordController(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(false);
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(this);
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(ARCardUtils.a);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController);
      }
    }
  }
  
  private void h()
  {
    boolean bool = VideoEncoderUtils.a();
    QLog.d("ARCardCameraRecordFragment", 2, String.format("unInitVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = null;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener = null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout != null)
    {
      this.l = paramInt1;
      if (paramInt1 >= 10000) {
        c();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("ARCardCameraRecordFragment", 1, "onRecordFinish.  filePath. " + paramString + " type" + paramInt);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (this.l < 500.0D)
      {
        ARRecordUtils.a("录制时间过短，请重新录制。", false);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener == null);
    this.jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener.a(new ARCardCameraRecordActivity.VideoRecordResult(1, paramString));
  }
  
  public void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera == null));
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    paramArCloudConfigInfo = new aalp(this, paramInt1, paramObject);
    ThreadManager.getSubThreadHandler().post(paramArCloudConfigInfo);
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback) {}
  
  public void a(OnCameraVideoRecordListener paramOnCameraVideoRecordListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener = paramOnCameraVideoRecordListener;
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    QLog.i("ARCardCameraRecordFragment", 2, "openCamera start. mCurCameraState = " + this.f);
    if (this.f == 2) {
      return true;
    }
    if (this.f == 1)
    {
      this.jdField_c_of_type_Int = 0;
      return true;
    }
    if (this.f == 3) {}
    this.f = 1;
    this.jdField_c_of_type_Int = 0;
    e();
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    QLog.i("ARCardCameraRecordFragment", 2, "closeCamera start. mCurCameraState = " + this.f + ", stopPreviewRender = " + paramBoolean);
    if (this.f == 0) {}
    while (this.f == 3) {
      return true;
    }
    if (this.f == 1) {}
    this.f = 3;
    this.jdField_c_of_type_Int = 10;
    a(new aaln(this, paramBoolean));
    return true;
  }
  
  public void b()
  {
    if (!CameraAbility.c()) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 1) {}
    for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int = 1)
    {
      QLog.i("ARCardCameraRecordFragment", 2, "changeCamera." + this.jdField_a_of_type_Int);
      a(false);
      a(new aalm(this));
      return;
    }
  }
  
  public void b(String paramString, int paramInt) {}
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null)
    {
      this.l = 0;
      bool = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(true, null);
    }
    return bool;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(true, true);
    }
  }
  
  public void c(int paramInt)
  {
    ARRecordUtils.a("录制时间过短，请重新录制。", false);
  }
  
  public void c(String paramString, int paramInt) {}
  
  public void d(String paramString, int paramInt) {}
  
  public void i()
  {
    QLog.i("ARCardCameraRecordFragment", 1, "onRecordStart. ");
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    g();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366955) {
      b();
    }
    do
    {
      return;
      if (paramView.getId() == 2131369528)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.e();
        return;
      }
    } while (paramView.getId() != 2131369526);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ARCardCameraRecordFragment", 2, "onCreate  this=");
    }
    super.onCreate(paramBundle);
    d();
    if (QLog.isColorLevel()) {
      QLog.i("ARCardCameraRecordFragment", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
  }
  
  public View onCreateView(LayoutInflater arg1, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARCardCameraRecordFragment", 2, "onCreateView");
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)???.inflate(2130970200, null));
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera = new ARCamera();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(true);
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = new ARGLSurfaceView(getActivity(), this, this);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager = new ARCardRender();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, getActivity(), this);
      ARCardRender.jdField_a_of_type_Int = this.j;
      ARCardRender.jdField_b_of_type_Int = this.k;
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderer(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager);
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderMode(0);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      ??? = new RelativeLayout.LayoutParams(-1, -1);
      ???.width = AIOUtils.a(225.0F, getActivity().getResources());
      ???.setMargins(0, AIOUtils.a(20.0F, getActivity().getResources()), 0, 0);
      ???.height = AIOUtils.a(390.0F, getActivity().getResources());
      ???.addRule(14);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, 0, ???);
      this.jdField_d_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ARCameraThread", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    QLog.i("ARCardCameraRecordFragment", 1, "onDestroy start.  this=" + this);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a();
    }
    super.onDestroy();
    QLog.i("ARCardCameraRecordFragment", 1, "onDestroy end.");
  }
  
  public void onPause()
  {
    a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.onPause();
    }
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout.d();
    this.jdField_c_of_type_Boolean = true;
    super.onPause();
    QLog.i("ARCardCameraRecordFragment", 1, "onPause end.");
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a() + 1L);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a());
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
    }
    paramCamera.addCallbackBuffer(paramArrayOfByte);
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener.a(true);
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    QLog.i("ARCardCameraRecordFragment", 1, "onResume start.");
    super.onResume();
    a();
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCamereButtonLayout.c();
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.onResume();
    }
  }
  
  public void onStart()
  {
    QLog.i("ARCardCameraRecordFragment", 1, "onStart start.");
    super.onStart();
    QLog.i("ARCardCameraRecordFragment", 1, "onStart end.");
  }
  
  public void onStop()
  {
    QLog.i("ARCardCameraRecordFragment", 1, "onStop start.");
    super.onStop();
    QLog.i("ARCardCameraRecordFragment", 1, "onStop end.");
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("ARCardCameraRecordFragment", 1, "surfaceChanged. holder = " + paramSurfaceHolder + ", format = " + paramInt1 + ", width = " + paramInt2 + ", height = " + paramInt3);
    paramInt1 = this.jdField_d_of_type_Int;
    paramInt2 = this.jdField_e_of_type_Int;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.getWidth();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.getHeight();
    this.jdField_b_of_type_Boolean = true;
    if (this.f == 2)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label208;
      }
      if (((paramInt1 != this.jdField_d_of_type_Int) || (paramInt2 != this.jdField_e_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.g, this.h, this.j, this.k);
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(false, 0.0F, 0.0F);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      }
      return;
      label208:
      QLog.i("ARCardCameraRecordFragment", 2, "continue to start preview after SurfaceCreated.");
      a(new aalo(this));
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    QLog.i("ARCardCameraRecordFragment", 1, "surfaceDestroyed. holder = " + paramSurfaceHolder);
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardCameraRecordFragment
 * JD-Core Version:    0.7.0.1
 */