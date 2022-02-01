package com.tencent.mobileqq.ar.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.arengine.MiniSaveImgListener;
import com.tencent.mobileqq.ar.arengine.QRRecognizerListener;
import com.tencent.mobileqq.ar.model.AbstractSession;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.CameraProxy.CameraOperationStatusCallBack;
import com.tencent.mobileqq.ar.model.QRSession;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.ImageData;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.MultiSelectListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class QRScanEntryView
  extends ScanEntryProviderView
  implements View.OnClickListener, View.OnTouchListener, MiniSaveImgListener, QRRecognizerListener, CameraProxy.CameraOperationStatusCallBack
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new QRScanEntryView.10(this);
  protected View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ScanEntryProviderContainerView.onVoiceScanStatusListener jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener;
  private ViewfinderView jdField_a_of_type_ComTencentMobileqqArViewViewfinderView;
  private ScannerMultiResultSelectView.MultiSelectListener jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener = new QRScanEntryView.16(this);
  private ScannerMultiResultSelectView jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView;
  Runnable jdField_a_of_type_JavaLangRunnable = new QRScanEntryView.13(this);
  volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new QRScanEntryView.1(this);
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Runnable jdField_c_of_type_JavaLangRunnable = new QRScanEntryView.2(this);
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g = false;
  
  public QRScanEntryView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext, paramScanEntryContainerViewListener);
  }
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIfNeedAutoFocus isCameraPrviewing=");
    localStringBuilder.append(CameraProxy.a().b());
    localStringBuilder.append(";mIsResumed=");
    localStringBuilder.append(this.m);
    QLog.d("AREngine_QRScanEntryView", 1, localStringBuilder.toString());
    if ((CameraProxy.a().b()) && (this.m)) {
      CameraProxy.a().a(UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int);
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramView != null)
    {
      int i = 4;
      if (!paramBoolean2)
      {
        paramView.setAlpha(1.0F);
        if (paramBoolean1) {
          i = 0;
        }
        paramView.setVisibility(i);
        return;
      }
      ObjectAnimator localObjectAnimator;
      if (paramBoolean1)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
        paramView.setAlpha(0.0F);
        paramView.setVisibility(4);
      }
      else
      {
        localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
        paramView.setAlpha(1.0F);
        paramView.setVisibility(0);
      }
      localObjectAnimator.addListener(new QRScanEntryView.12(this, paramView, paramBoolean1));
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
    }
  }
  
  private void a(ScannerResult paramScannerResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if ((paramScannerResult != null) && (paramScannerResult.a()) && (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView;
      if ((localObject != null) && (((ScannerMultiResultSelectView)localObject).a())) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView = new ScannerMultiResultSelectView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView.setMultiSelectListener(this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$MultiSelectListener);
      }
      localObject = (RelativeLayout)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131376809);
      this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView.a((RelativeLayout)localObject, paramScannerResult, paramInt, paramImageData, 1);
      if ((!PhoneStatusTools.b(this.jdField_a_of_type_AndroidContentContext)) && (!PhoneStatusTools.a(this.jdField_a_of_type_AndroidContentContext)) && (!PhoneStatusTools.d(this.jdField_a_of_type_AndroidContentContext))) {
        AudioUtil.b(2131230765, false);
      }
    }
  }
  
  private void a(ScannerResult paramScannerResult, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    ThreadManager.getUIHandler().post(new QRScanEntryView.15(this, paramScannerResult, paramImageData));
  }
  
  private void a(String paramString1, Activity paramActivity, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramActivity != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession == null) {
        return;
      }
      QRSession localQRSession = (QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchAppByMiniCode(paramActivity, paramString1, 1049, new QRScanEntryView.14(this, paramString1, paramString2, paramActivity, localQRSession));
    }
  }
  
  private void a(String paramString1, String paramString2, Activity paramActivity, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramActivity == null) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("detectType", 1);
      localIntent.putExtra("scannerResult", paramString1.trim());
      localIntent.putExtra("scannerType", paramString2.trim());
      if (!TextUtils.isEmpty(paramString3)) {
        localIntent.putExtra("filePath", paramString3);
      }
      paramActivity.setResult(13, localIntent);
      paramActivity.finish();
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("updateFlashLightView byUserClick=%s mIsFlashLightVisible=%s mIsFlashLightOn=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_c_of_type_Boolean) }));
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
      {
        this.jdField_d_of_type_Boolean = true;
        i();
        return;
      }
      a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_b_of_type_Boolean, paramBoolean ^ true);
      TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      a(localTextView, paramBoolean, true);
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844867, 0, 0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698642);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16717057);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844866, 0, 0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698643);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.e) && (paramBoolean))
    {
      ReportController.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 1, 0, "", "", "", "");
      this.e = true;
      return;
    }
    if ((!this.f) && (!paramBoolean))
    {
      ReportController.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 0, 0, "", "", "", "");
      this.f = true;
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "resetFlashLightState");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_b_of_type_Boolean, false);
    a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_b_of_type_Boolean ^ true, false);
    ((QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).a(true, 0L);
  }
  
  private void i()
  {
    LottieComposition.Factory.fromAssetFileName(this.jdField_a_of_type_AndroidContentContext, "qq_ar_light_first_show.json", new QRScanEntryView.11(this));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onLuminanceChanged luminance=%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new QRScanEntryView.9(this, paramInt));
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, String.format("onSaveImg %d", new Object[] { Long.valueOf(paramLong) }));
    }
    ThreadManager.getUIHandler().post(new QRScanEntryView.8(this));
  }
  
  public void a(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131560963, this, true);
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131374667));
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView = ((ViewfinderView)findViewById(2131374672));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378803));
      UniformUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378804));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378806));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365222));
      if (paramBundle.getBoolean("hide_album", false)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131711165));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131711163));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365223));
      findViewById(2131369428).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new QRScanEntryView.3(this));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374666));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374655));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new QRScanEntryView.4(this));
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    }
    CameraProxy.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession = new QRSession();
    this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ((QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).a(this, this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364617));
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).setSaveDetectImage(false);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    if (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn())
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new QRScanEntryView.5(this));
    }
    this.k = true;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  public void a(ScannerResult paramScannerResult, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeSuccess results=%s", new Object[] { paramScannerResult }));
    }
    if ((this.m) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView;
      if ((localObject == null) || (!((ScannerMultiResultSelectView)localObject).a()))
      {
        localObject = new ScannerMultiResultSelectView.ImageData();
        ((ScannerMultiResultSelectView.ImageData)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        ((ScannerMultiResultSelectView.ImageData)localObject).jdField_a_of_type_Int = paramInt1;
        ((ScannerMultiResultSelectView.ImageData)localObject).jdField_b_of_type_Int = paramInt2;
        ((QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).b(true);
        if ((paramScannerResult.jdField_b_of_type_Boolean) && (paramArrayOfByte != null))
        {
          ThreadManagerV2.excute(new QRScanEntryView.7(this, paramArrayOfByte, paramInt1, paramInt2, paramScannerResult, (ScannerMultiResultSelectView.ImageData)localObject), 16, null, true);
          return;
        }
        a(paramScannerResult, (ScannerMultiResultSelectView.ImageData)localObject);
        return;
      }
    }
    QLog.d("AREngine_QRScanEntryView", 1, "QREntry has closed,so give up this result");
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession == null) {
        return;
      }
      ((QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).b(true);
      ThreadManagerV2.excute(new QRScanEntryView.6(this, paramString), 16, null, true);
    }
  }
  
  public void a(List<AIRect> paramList)
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (paramList.size() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject;
      if (paramList.size() > 0) {
        localObject = ((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect;
      } else {
        localObject = "null";
      }
      QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDetectResult suc=%b rect=%s", new Object[] { Boolean.valueOf(bool), localObject }));
    }
    if (!this.m) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView != null) && (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn())) {
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setDetectRect(paramList);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) }));
    }
  }
  
  public boolean a()
  {
    ScannerMultiResultSelectView localScannerMultiResultSelectView = this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView;
    if ((localScannerMultiResultSelectView != null) && (localScannerMultiResultSelectView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView.a();
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onStartPreviewSuccess");
    }
    a();
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onResume ");
    super.c();
    ((QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).a(true, 1000L);
    a();
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener;
    if ((localonVoiceScanStatusListener != null) && (!this.g))
    {
      localonVoiceScanStatusListener.a(2);
      this.g = true;
    }
  }
  
  public void d()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onPause ");
    super.d();
    h();
    CameraProxy.a().a();
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener;
    if (localonVoiceScanStatusListener != null)
    {
      localonVoiceScanStatusListener.a(3);
      this.g = false;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append(String.format("dispatchTouchEvent", new Object[0]));
      paramMotionEvent.append(bool);
      QLog.d("AREngine_QRScanEntryView", 2, paramMotionEvent.toString());
    }
    return bool;
  }
  
  public void e()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onDestroy ");
    super.e();
    CameraProxy.a().b(this);
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener;
    if (localonVoiceScanStatusListener != null) {
      localonVoiceScanStatusListener.a(4);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).setSaveDetectImage(false);
  }
  
  public void f()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewShow ");
    super.f();
    h();
    if (c())
    {
      a();
      ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener;
      if ((localonVoiceScanStatusListener != null) && (!this.g))
      {
        localonVoiceScanStatusListener.a(2);
        this.g = true;
      }
    }
  }
  
  public void g()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewClose ");
    super.g();
    ((QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).a(false, 0L);
    CameraProxy.a().a();
    if (this.jdField_c_of_type_Boolean) {
      CameraProxy.a().a(false);
    }
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener;
    if (localonVoiceScanStatusListener != null)
    {
      localonVoiceScanStatusListener.a(3);
      this.g = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131365222)
    {
      if (i == 2131378804) {
        l();
      }
    }
    else {
      m();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (CameraProxy.a().b())
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3) {
            return true;
          }
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
          return true;
        }
        if ((this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long <= ViewConfiguration.getTapTimeout()))
        {
          paramView = ThreadManager.getUIHandler();
          if (this.jdField_b_of_type_Long > 0L)
          {
            paramView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
            paramView.post(this.jdField_c_of_type_JavaLangRunnable);
          }
          else
          {
            paramView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getDoubleTapTimeout());
          }
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          return true;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
        this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > ViewConfiguration.getDoubleTapTimeout())) {
          this.jdField_b_of_type_Long = 0L;
        }
      }
    }
    return true;
  }
  
  public void setRectAreas(Rect paramRect)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null) {
      ((QRSession)this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).a(paramRect);
    }
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView;
    if (localObject != null) {
      ((ViewfinderView)localObject).setRect(paramRect);
    }
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, paramRect.bottom - AIOUtils.b(60.0F, getResources()), ((ViewGroup.MarginLayoutParams)localObject).rightMargin, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
  }
  
  public void setVoiceScanStatusListener(ScanEntryProviderContainerView.onVoiceScanStatusListener paramonVoiceScanStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener = paramonVoiceScanStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView
 * JD-Core Version:    0.7.0.1
 */