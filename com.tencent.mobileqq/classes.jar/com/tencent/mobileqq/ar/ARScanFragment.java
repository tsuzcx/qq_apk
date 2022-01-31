package com.tencent.mobileqq.ar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.ar.arengine.QRRecognizerListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class ARScanFragment
  extends Fragment
  implements QRRecognizerListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  private ARScanFragment.ARScanFragmentCallback jdField_a_of_type_ComTencentMobileqqArARScanFragment$ARScanFragmentCallback;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  public AREngine a;
  private AREngineCallback jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
  public boolean a;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public ARScanFragment()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static ARScanFragment a(ARArguments paramARArguments, ArConfigInfo paramArConfigInfo)
  {
    paramArConfigInfo = new ARScanFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("AR_ARGUMENTS", paramARArguments);
    paramArConfigInfo.setArguments(localBundle);
    return paramArConfigInfo;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.d()) && (this.c)) {
        d();
      }
      if ((isResumed()) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.d())) {
        b(false);
      }
    }
  }
  
  private void d()
  {
    boolean bool = false;
    ArConfigInfo localArConfigInfo = null;
    getArguments();
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) {
      localArConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
    }
    Object localObject = getActivity().getIntent();
    if (localObject != null) {
      if (((Intent)localObject).getIntExtra("web_url_switch", 0) != 0) {}
    }
    for (bool = true;; bool = false)
    {
      localObject = ARGlobalRemoteManager.a(getActivity()).a();
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine == null) || (!this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c())) {
          break;
        }
        long l = System.currentTimeMillis();
        int i = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(false, bool, false, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, localArConfigInfo, (ARScanStarFaceConfigInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback);
        ARReport.a().b(System.currentTimeMillis() - l, i);
        if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.d()))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.f();
          return;
        }
        QLog.e("AREngine_ARScanFragment", 1, String.format("initAr fail. result=%s", new Object[] { Integer.valueOf(i) }));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARScanFragment", 1, "initAr fail.", localException);
        return;
      }
    }
  }
  
  private void e()
  {
    boolean bool = VideoEncoderUtils.a();
    QLog.d("AREngine_ARScanFragment", 2, String.format("initVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController == null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = new VideoRecordController(getActivity());
      }
      ARRenderManager localARRenderManager = null;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) {
        localARRenderManager = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a();
      }
      if (localARRenderManager != null) {
        localARRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController);
      }
      ARVideoRecordUIControllerImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController);
    }
  }
  
  private void f()
  {
    boolean bool = VideoEncoderUtils.a();
    QLog.d("AREngine_ARScanFragment", 2, String.format("unInitVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool) {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine == null) {
        break label79;
      }
    }
    label79:
    for (ARRenderManager localARRenderManager = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a();; localARRenderManager = null)
    {
      if (localARRenderManager != null) {
        localARRenderManager.a(null);
      }
      ARVideoRecordUIControllerImpl.a().b(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController);
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = null;
      }
      return;
    }
  }
  
  public AREngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, "setArDependReady mIsArDependReady=" + this.c);
    }
    if (!this.c)
    {
      this.c = true;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) {
        c();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, "setShaderConfig edgestart = " + paramFloat);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) {
      this.jdField_a_of_type_Float = paramFloat;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, "setCameraEdgeEnd edgeend = " + paramFloat1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null)
    {
      this.jdField_b_of_type_Float = paramFloat1;
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(this.jdField_a_of_type_Boolean, paramFloat2, this.jdField_b_of_type_Float);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment$ARScanFragmentCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment$ARScanFragmentCallback.b(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(paramLong);
    }
  }
  
  public void a(Rect paramRect)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(paramRect, this);
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.g(true);
    }
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
  }
  
  public void a(AREngineCallback paramAREngineCallback, ARScanFragment.ARScanFragmentCallback paramARScanFragmentCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback = paramAREngineCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARScanFragment$ARScanFragmentCallback = paramARScanFragmentCallback;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, String.format("onQRRecognizeSuccess type=%s data=%s", new Object[] { paramString1, paramString2 }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()))
    {
      b(true);
      c(true);
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && ((localFragmentActivity instanceof ScanTorchActivity)))
      {
        long l = ((ScanTorchActivity)localFragmentActivity).a();
        if (l > 0L)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.b();
          ScanEntranceReport.a().a(l, i, this.jdField_a_of_type_Int);
          ARDebugReport.a().c(l, System.currentTimeMillis());
        }
      }
      if (localFragmentActivity != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("scannerResult", paramString2.trim());
        localIntent.putExtra("scannerType", paramString1.trim());
        localFragmentActivity.setResult(13, localIntent);
        localFragmentActivity.finish();
        localFragmentActivity.overridePendingTransition(0, 0);
      }
      ReportController.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setHaveEdge flage = ").append(paramBoolean).append(" mAREngine == null?");
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AREngine_ARScanFragment", 2, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) }));
    }
    if ((paramBoolean) && (paramFloat > 0.003F) && ((int)(Math.sqrt(paramFloat) * 100.0D) < 20))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a.a(25, true);
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c())) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(paramBoolean, paramString);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, "stopModelRenderOnly.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.k();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanFragment", 1, String.format("pauseAR pause=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.d()) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a() == 2))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.g();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.h();
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanFragment", 1, String.format("pauseQR pause=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.g();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.h();
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, new Object[] { "onNoFeatureTrackAnimProcessCompleted success：", Boolean.valueOf(paramBoolean) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.e(paramBoolean);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void g(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, "setInSearchQuestion:" + paramBoolean);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanFragment", 2, "onCreate  this=" + this);
    }
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine = AREngine.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(paramBundle, paramBundle.getAppInterface());
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment$ARScanFragmentCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment$ARScanFragmentCallback.a(i);
    }
    e();
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARScanFragment", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a();
    if (paramLayoutInflater != null)
    {
      paramViewGroup = paramLayoutInflater.getParent();
      if (paramViewGroup != null)
      {
        QLog.d("AREngine_ARScanFragment", 1, String.format("onCreateView glSurfaceView has a parent? viewParent=%s", new Object[] { paramViewGroup }));
        if ((paramViewGroup instanceof ViewGroup)) {
          ((ViewGroup)paramViewGroup).removeView(paramLayoutInflater);
        }
      }
    }
    return paramLayoutInflater;
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    QLog.i("AREngine_ARScanFragment", 1, "onDestroy start.  this=" + this);
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.i();
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.i();
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine = null;
    AREngine.d();
    super.onDestroy();
    QLog.i("AREngine_ARScanFragment", 1, "onDestroy end.");
  }
  
  public void onPause()
  {
    QLog.i("AREngine_ARScanFragment", 1, "onPause start.");
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()))
    {
      GLSurfaceView localGLSurfaceView = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a();
      if (localGLSurfaceView != null) {
        localGLSurfaceView.onPause();
      }
      if ((!this.d) && (!this.e))
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(true);
        b(true);
        c(true);
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.b();
      long l = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c();
      ScanEntranceReport.a().a(i, l);
    }
    super.onPause();
    QLog.i("AREngine_ARScanFragment", 1, "onPause end.");
  }
  
  public void onResume()
  {
    QLog.i("AREngine_ARScanFragment", 1, "onResume start.");
    super.onResume();
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.t();
      this.jdField_a_of_type_Int = 0;
      GLSurfaceView localGLSurfaceView = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a();
      if (localGLSurfaceView != null) {
        localGLSurfaceView.onResume();
      }
      if ((!this.d) && (!this.e))
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.e();
        b(false);
        c(false);
      }
    }
    QLog.i("AREngine_ARScanFragment", 1, "onResume end.");
  }
  
  public void onStart()
  {
    QLog.i("AREngine_ARScanFragment", 1, "onStart start.");
    super.onStart();
    QLog.i("AREngine_ARScanFragment", 1, "onStart end.");
  }
  
  public void onStop()
  {
    QLog.i("AREngine_ARScanFragment", 1, "onStop start.");
    super.onStop();
    QLog.i("AREngine_ARScanFragment", 1, "onStop end.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARScanFragment
 * JD-Core Version:    0.7.0.1
 */