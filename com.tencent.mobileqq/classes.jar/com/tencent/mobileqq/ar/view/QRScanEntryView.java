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
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class QRScanEntryView
  extends ScanEntryProviderView
  implements View.OnClickListener, View.OnTouchListener, MiniSaveImgListener, QRRecognizerListener, CameraProxy.CameraOperationStatusCallBack
{
  private Runnable A = new QRScanEntryView.1(this);
  private Runnable B = new QRScanEntryView.2(this);
  private boolean K = false;
  private View.OnTouchListener L = new QRScanEntryView.10(this);
  private ScannerMultiResultSelectView.MultiSelectListener M = new QRScanEntryView.16(this);
  protected View a;
  volatile boolean b;
  ImageView c;
  Runnable d = new QRScanEntryView.13(this);
  private ViewfinderView e;
  private ViewGroup f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private ViewGroup j;
  private Rect k;
  private ViewGroup l;
  private TextView m;
  private TextView n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private int t;
  private int u;
  private long v;
  private long w;
  private CheckBox x;
  private ScannerMultiResultSelectView y;
  private ScanEntryProviderContainerView.onVoiceScanStatusListener z;
  
  public QRScanEntryView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext, paramScanEntryContainerViewListener);
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramView != null)
    {
      int i1 = 4;
      if (!paramBoolean2)
      {
        paramView.setAlpha(1.0F);
        if (paramBoolean1) {
          i1 = 0;
        }
        paramView.setVisibility(i1);
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
    if ((paramScannerResult != null) && (paramScannerResult.a()) && (this.G != null))
    {
      if (this.E == null) {
        return;
      }
      Object localObject = this.y;
      if ((localObject != null) && (((ScannerMultiResultSelectView)localObject).a())) {
        return;
      }
      if (this.y == null)
      {
        this.y = new ScannerMultiResultSelectView(this.E);
        this.y.setMultiSelectListener(this.M);
      }
      localObject = (RelativeLayout)((Activity)this.E).findViewById(2131445137);
      this.y.a((RelativeLayout)localObject, paramScannerResult, paramInt, paramImageData, 1);
      if ((!PhoneStatusTools.b(this.E)) && (!PhoneStatusTools.a(this.E)) && (!PhoneStatusTools.d(this.E))) {
        AudioUtil.b(2131230835, false);
      }
    }
  }
  
  private void a(ScannerResult paramScannerResult, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    ThreadManager.getUIHandler().post(new QRScanEntryView.15(this, paramScannerResult, paramImageData));
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
      QLog.d("AREngine_QRScanEntryView", 2, String.format("updateFlashLightView byUserClick=%s mIsFlashLightVisible=%s mIsFlashLightOn=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.o), Boolean.valueOf(this.p) }));
    }
    if (this.n != null)
    {
      if ((this.o) && (!this.p) && (!this.q))
      {
        this.q = true;
        j();
        return;
      }
      a(this.n, this.o, paramBoolean ^ true);
      TextView localTextView = this.m;
      if ((this.o) && (!this.p)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      a(localTextView, paramBoolean, true);
      if (this.p)
      {
        this.n.setCompoundDrawablesWithIntrinsicBounds(0, 2130846301, 0, 0);
        this.n.setText(2131896591);
        this.n.setTextColor(-16717057);
        return;
      }
      this.n.setCompoundDrawablesWithIntrinsicBounds(0, 2130846300, 0, 0);
      this.n.setText(2131896592);
      this.n.setTextColor(-1);
    }
  }
  
  private void b(String paramString1, String paramString2, Activity paramActivity, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramActivity != null))
    {
      if (this.G == null) {
        return;
      }
      QRSession localQRSession = (QRSession)this.G;
      if ("qq".equals(paramString2))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchAppByMiniCode(paramActivity, paramString1, 1047, new QRScanEntryView.14(this, paramString1, paramString3, paramActivity, localQRSession));
        return;
      }
      if ("wx".equals(paramString2))
      {
        QLog.i("AREngine_QRScanEntryView", 2, String.format("handleScannerMiniResult jumpMiniCode result=%s", new Object[] { paramString1 }));
        ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniApp(paramActivity, paramString1, 2, 1047);
        paramActivity.finish();
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.r) && (paramBoolean))
    {
      ReportController.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 1, 0, "", "", "", "");
      this.r = true;
      return;
    }
    if ((!this.s) && (!paramBoolean))
    {
      ReportController.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 0, 0, "", "", "", "");
      this.s = true;
    }
  }
  
  private void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIfNeedAutoFocus isCameraPrviewing=");
    localStringBuilder.append(CameraProxy.a().g());
    localStringBuilder.append(";mIsResumed=");
    localStringBuilder.append(this.J);
    QLog.d("AREngine_QRScanEntryView", 1, localStringBuilder.toString());
    if ((CameraProxy.a().g()) && (this.J)) {
      CameraProxy.a().a(UniformGLRenderManagerImpl.b, UniformGLRenderManagerImpl.c);
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "resetFlashLightState");
    }
    this.o = false;
    this.p = false;
    a(this.n, this.o, false);
    a(this.m, this.o ^ true, false);
    ((QRSession)this.G).a(true, 0L);
  }
  
  private void j()
  {
    LottieComposition.Factory.fromAssetFileName(this.E, "qq_ar_light_first_show.json", new QRScanEntryView.11(this));
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
    long l1 = System.currentTimeMillis();
    if (this.a == null)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131627304, this, true);
      this.l = ((ViewGroup)findViewById(2131442848));
      this.e = ((ViewfinderView)findViewById(2131442853));
      this.f = ((ViewGroup)findViewById(2131447484));
      UniformUtils.a(this.E, this.f);
      this.h = ((TextView)findViewById(2131447486));
      this.g = ((TextView)findViewById(2131447488));
      this.i = ((ImageView)findViewById(2131431388));
      if (paramBundle.getBoolean("hide_album", false)) {
        this.i.setVisibility(8);
      }
      this.h.setOnClickListener(this);
      this.h.setContentDescription(HardCodeUtil.a(2131901576));
      this.i.setOnClickListener(this);
      this.i.setOnTouchListener(this.L);
      this.i.setContentDescription(HardCodeUtil.a(2131908828));
      this.j = ((ViewGroup)findViewById(2131431389));
      findViewById(2131436471).setOnTouchListener(this.L);
      this.j.setOnClickListener(new QRScanEntryView.3(this));
      this.m = ((TextView)findViewById(2131442847));
      this.n = ((TextView)findViewById(2131442834));
      this.n.setOnTouchListener(this.L);
      this.n.setOnClickListener(new QRScanEntryView.4(this));
      this.a = localView;
      this.a.setOnTouchListener(this);
    }
    CameraProxy.a().a(this);
    this.G = new QRSession();
    this.G.a(this.E, this.C);
    ((QRSession)this.G).a(this, this);
    this.x = ((CheckBox)findViewById(2131430694));
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).setSaveDetectImage(false);
    this.x.setChecked(false);
    if (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn())
    {
      this.x.setVisibility(0);
      this.x.setOnCheckedChangeListener(new QRScanEntryView.5(this));
    }
    this.D = true;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
  }
  
  public void a(ScannerResult paramScannerResult, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeSuccess results=%s", new Object[] { paramScannerResult }));
    }
    if ((this.J) && (this.E != null) && (this.G != null))
    {
      Object localObject = this.y;
      if ((localObject == null) || (!((ScannerMultiResultSelectView)localObject).a()))
      {
        localObject = new ScannerMultiResultSelectView.ImageData();
        ((ScannerMultiResultSelectView.ImageData)localObject).a = paramArrayOfByte;
        ((ScannerMultiResultSelectView.ImageData)localObject).b = paramInt1;
        ((ScannerMultiResultSelectView.ImageData)localObject).c = paramInt2;
        ((QRSession)this.G).b(true);
        if ((paramScannerResult.d) && (paramArrayOfByte != null))
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
        localObject = ((AIRect)paramList.get(0)).b;
      } else {
        localObject = "null";
      }
      QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDetectResult suc=%b rect=%s", new Object[] { Boolean.valueOf(bool), localObject }));
    }
    if (!this.J) {
      return;
    }
    if ((this.e != null) && (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn())) {
      this.e.setDetectRect(paramList);
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
    ScannerMultiResultSelectView localScannerMultiResultSelectView = this.y;
    if ((localScannerMultiResultSelectView != null) && (localScannerMultiResultSelectView.a()))
    {
      this.y.b();
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onStartPreviewSuccess");
    }
    h();
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onResume ");
    super.c();
    ((QRSession)this.G).a(true, 1000L);
    h();
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.z;
    if ((localonVoiceScanStatusListener != null) && (!this.K))
    {
      localonVoiceScanStatusListener.a(2);
      this.K = true;
    }
  }
  
  public void d()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onPause ");
    super.d();
    i();
    CameraProxy.a().b();
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.z;
    if (localonVoiceScanStatusListener != null)
    {
      localonVoiceScanStatusListener.a(3);
      this.K = false;
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
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.z;
    if (localonVoiceScanStatusListener != null) {
      localonVoiceScanStatusListener.a(4);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.d);
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).setSaveDetectImage(false);
  }
  
  public void f()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewShow ");
    super.f();
    i();
    if (n())
    {
      h();
      ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.z;
      if ((localonVoiceScanStatusListener != null) && (!this.K))
      {
        localonVoiceScanStatusListener.a(2);
        this.K = true;
      }
    }
  }
  
  public void g()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewClose ");
    super.g();
    ((QRSession)this.G).a(false, 0L);
    CameraProxy.a().b();
    if (this.p) {
      CameraProxy.a().b(false);
    }
    ScanEntryProviderContainerView.onVoiceScanStatusListener localonVoiceScanStatusListener = this.z;
    if (localonVoiceScanStatusListener != null)
    {
      localonVoiceScanStatusListener.a(3);
      this.K = false;
    }
  }
  
  public void i_(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.E != null))
    {
      if (this.G == null) {
        return;
      }
      ((QRSession)this.G).b(true);
      ThreadManagerV2.excute(new QRScanEntryView.6(this, paramString), 16, null, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131431388)
    {
      if (i1 == 2131447486) {
        o();
      }
    }
    else {
      p();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (CameraProxy.a().g())
    {
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 3) {
            return true;
          }
          this.v = 0L;
          this.w = 0L;
          return true;
        }
        if ((this.v > 0L) && (System.currentTimeMillis() - this.v <= ViewConfiguration.getTapTimeout()))
        {
          paramView = ThreadManager.getUIHandler();
          if (this.w > 0L)
          {
            paramView.removeCallbacks(this.A);
            paramView.post(this.B);
          }
          else
          {
            paramView.postDelayed(this.A, ViewConfiguration.getDoubleTapTimeout());
          }
          this.w = System.currentTimeMillis();
          return true;
        }
      }
      else
      {
        this.t = ((int)paramMotionEvent.getRawX());
        this.u = ((int)paramMotionEvent.getRawY());
        this.v = System.currentTimeMillis();
        if ((this.w > 0L) && (System.currentTimeMillis() - this.w > ViewConfiguration.getDoubleTapTimeout())) {
          this.w = 0L;
        }
      }
    }
    return true;
  }
  
  public void setRectAreas(Rect paramRect)
  {
    if (this.G != null) {
      ((QRSession)this.G).a(paramRect);
    }
    this.k = paramRect;
    Object localObject = this.e;
    if (localObject != null) {
      ((ViewfinderView)localObject).setRect(paramRect);
    }
    localObject = (ViewGroup.MarginLayoutParams)this.l.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, paramRect.bottom - AIOUtils.b(60.0F, getResources()), ((ViewGroup.MarginLayoutParams)localObject).rightMargin, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
  }
  
  public void setVoiceScanStatusListener(ScanEntryProviderContainerView.onVoiceScanStatusListener paramonVoiceScanStatusListener)
  {
    this.z = paramonVoiceScanStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView
 * JD-Core Version:    0.7.0.1
 */