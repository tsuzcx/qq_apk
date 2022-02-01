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
import anvx;
import apmx;
import apmz;
import apni;
import apno;
import apog;
import apoo;
import apop;
import apot;
import appa;
import appk;
import apqh;
import apqi;
import apqj;
import apqk;
import apql;
import apqm;
import apqn;
import apqo;
import apqp;
import apqt;
import bdla;
import bhcl;
import com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;
import mtj;
import zmh;
import zmi;

public class QRScanEntryView
  extends ScanEntryProviderView
  implements View.OnClickListener, View.OnTouchListener, apmx, apni, apop
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new apqh(this);
  protected View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apqt jdField_a_of_type_Apqt;
  private ScannerMultiResultSelectView jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView;
  private ViewfinderView jdField_a_of_type_ComTencentMobileqqArViewViewfinderView;
  Runnable jdField_a_of_type_JavaLangRunnable = new QRScanEntryView.13(this);
  private zmi jdField_a_of_type_Zmi = new apql(this);
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
  private boolean g;
  
  public QRScanEntryView(Context paramContext, apqp paramapqp)
  {
    super(paramContext, paramapqp);
  }
  
  private void a()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + apoo.a().b() + ";mIsResumed=" + this.m);
    if ((apoo.a().b()) && (this.m)) {
      apoo.a().a(appa.jdField_a_of_type_Int, appa.jdField_b_of_type_Int);
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (paramView != null)
    {
      if (paramBoolean2) {
        break label33;
      }
      paramView.setAlpha(1.0F);
      if (!paramBoolean1) {
        break label27;
      }
    }
    for (;;)
    {
      paramView.setVisibility(i);
      return;
      label27:
      i = 4;
    }
    label33:
    ObjectAnimator localObjectAnimator;
    if (paramBoolean1)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setAlpha(0.0F);
      paramView.setVisibility(4);
    }
    for (;;)
    {
      localObjectAnimator.addListener(new apqj(this, paramView, paramBoolean1));
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
      paramView.setAlpha(1.0F);
      paramView.setVisibility(0);
    }
  }
  
  private void a(ScannerResult paramScannerResult, int paramInt, zmh paramzmh)
  {
    if ((paramScannerResult == null) || (!paramScannerResult.a()) || (this.jdField_a_of_type_Apog == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView != null) && (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.a()));
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView == null)
      {
        this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView = new ScannerMultiResultSelectView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.setMultiSelectListener(this.jdField_a_of_type_Zmi);
      }
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131376947);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.a(localRelativeLayout, paramScannerResult, paramInt, paramzmh, 1);
    } while ((mtj.b(this.jdField_a_of_type_AndroidContentContext)) || (mtj.a(this.jdField_a_of_type_AndroidContentContext)) || (mtj.d(this.jdField_a_of_type_AndroidContentContext)));
    bhcl.b(2131230757, false);
  }
  
  private void a(ScannerResult paramScannerResult, zmh paramzmh)
  {
    ThreadManager.getUIHandler().post(new QRScanEntryView.15(this, paramScannerResult, paramzmh));
  }
  
  private void a(String paramString1, Activity paramActivity, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramActivity == null) || (this.jdField_a_of_type_Apog == null)) {
      return;
    }
    MiniAppLauncher.launchAppByMiniCode(paramActivity, paramString1, 1049, new apqk(this, paramString1, paramString2, paramActivity, (apot)this.jdField_a_of_type_Apog));
  }
  
  private void a(String paramString1, String paramString2, Activity paramActivity, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramActivity == null)) {
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
      }
    }
    else {
      return;
    }
    TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    boolean bool = this.jdField_b_of_type_Boolean;
    if (!paramBoolean)
    {
      paramBoolean = true;
      a(localTextView, bool, paramBoolean);
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
        break label184;
      }
    }
    label184:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(localTextView, paramBoolean, true);
      if (!this.jdField_c_of_type_Boolean) {
        break label189;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844830, 0, 0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698299);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16717057);
      return;
      paramBoolean = false;
      break;
    }
    label189:
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844829, 0, 0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698300);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.e) && (paramBoolean))
    {
      bdla.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 1, 0, "", "", "", "");
      this.e = true;
    }
    while ((this.f) || (paramBoolean)) {
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 0, 0, "", "", "", "");
    this.f = true;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "resetFlashLightState");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_b_of_type_Boolean, false);
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      ((apot)this.jdField_a_of_type_Apog).a(true, 0L);
      return;
    }
  }
  
  private void i()
  {
    LottieComposition.Factory.fromAssetFileName(this.jdField_a_of_type_AndroidContentContext, "qq_ar_light_first_show.json", new apqi(this));
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
      View localView = LayoutInflater.from(getContext()).inflate(2131561013, this, true);
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131374781));
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView = ((ViewfinderView)findViewById(2131374786));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379020));
      appk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379021));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379023));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365217));
      if (paramBundle.getBoolean("hide_album", false)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131710674));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131710672));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365218));
      findViewById(2131369476).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new apqm(this));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374780));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374769));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new apqn(this));
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    }
    apoo.a().a(this);
    this.jdField_a_of_type_Apog = new apot();
    this.jdField_a_of_type_Apog.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ((apot)this.jdField_a_of_type_Apog).a(this, this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364616));
    com.tencent.mobileqq.minicode.RecogUtil.SAVE_DETECT_IMAGE = false;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    if (apno.a())
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new apqo(this));
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
    if ((!this.m) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Apog == null) || ((this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView != null) && (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.a())))
    {
      QLog.d("AREngine_QRScanEntryView", 1, "QREntry has closed,so give up this result");
      return;
    }
    zmh localzmh = new zmh();
    localzmh.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localzmh.jdField_a_of_type_Int = paramInt1;
    localzmh.jdField_b_of_type_Int = paramInt2;
    ((apot)this.jdField_a_of_type_Apog).b(true);
    if ((paramScannerResult.jdField_b_of_type_Boolean) && (paramArrayOfByte != null))
    {
      ThreadManagerV2.excute(new QRScanEntryView.7(this, paramArrayOfByte, paramInt1, paramInt2, paramScannerResult, localzmh), 16, null, true);
      return;
    }
    a(paramScannerResult, localzmh);
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Apog == null)) {
      return;
    }
    ((apot)this.jdField_a_of_type_Apog).b(true);
    ThreadManagerV2.excute(new QRScanEntryView.6(this, paramString), 16, null, true);
  }
  
  public void a(List<apmz> paramList)
  {
    boolean bool;
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramList.size() > 0)
      {
        bool = true;
        if (paramList.size() <= 0) {
          break label80;
        }
        localObject = ((apmz)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect;
        label40:
        QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDetectResult suc=%b rect=%s", new Object[] { Boolean.valueOf(bool), localObject }));
      }
    }
    else {
      if (this.m) {
        break label87;
      }
    }
    label80:
    label87:
    while ((this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView == null) || (!apno.a()))
    {
      return;
      bool = false;
      break;
      localObject = "null";
      break label40;
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setDetectRect(paramList);
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) }));
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView != null) && (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.a()))
    {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.a();
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
    ((apot)this.jdField_a_of_type_Apog).a(true, 1000L);
    a();
    if ((this.jdField_a_of_type_Apqt != null) && (!this.g))
    {
      this.jdField_a_of_type_Apqt.a(2);
      this.g = true;
    }
  }
  
  public void d()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onPause ");
    super.d();
    h();
    apoo.a().a();
    if (this.jdField_a_of_type_Apqt != null)
    {
      this.jdField_a_of_type_Apqt.a(3);
      this.g = false;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("dispatchTouchEvent", new Object[0]) + bool);
    }
    return bool;
  }
  
  public void e()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onDestroy ");
    super.e();
    apoo.a().b(this);
    if (this.jdField_a_of_type_Apqt != null) {
      this.jdField_a_of_type_Apqt.a(4);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    com.tencent.mobileqq.minicode.RecogUtil.SAVE_DETECT_IMAGE = false;
  }
  
  public void f()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewShow ");
    super.f();
    h();
    if (c())
    {
      a();
      if ((this.jdField_a_of_type_Apqt != null) && (!this.g))
      {
        this.jdField_a_of_type_Apqt.a(2);
        this.g = true;
      }
    }
  }
  
  public void g()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewClose ");
    super.g();
    ((apot)this.jdField_a_of_type_Apog).a(false, 0L);
    apoo.a().a();
    if (this.jdField_c_of_type_Boolean) {
      apoo.a().a(false);
    }
    if (this.jdField_a_of_type_Apqt != null)
    {
      this.jdField_a_of_type_Apqt.a(3);
      this.g = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      l();
      continue;
      m();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (apoo.a().b()) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > ViewConfiguration.getDoubleTapTimeout()))
      {
        this.jdField_b_of_type_Long = 0L;
        continue;
        if ((this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long <= ViewConfiguration.getTapTimeout()))
        {
          paramView = ThreadManager.getUIHandler();
          if (this.jdField_b_of_type_Long > 0L)
          {
            paramView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
            paramView.post(this.jdField_c_of_type_JavaLangRunnable);
          }
          for (;;)
          {
            this.jdField_b_of_type_Long = System.currentTimeMillis();
            break;
            paramView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getDoubleTapTimeout());
          }
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
        }
      }
    }
  }
  
  public void setRectAreas(Rect paramRect)
  {
    if (this.jdField_a_of_type_Apog != null) {
      ((apot)this.jdField_a_of_type_Apog).a(paramRect);
    }
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    if (this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setRect(paramRect);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, paramRect.bottom - AIOUtils.dp2px(60.0F, getResources()), localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
  }
  
  public void setVoiceScanStatusListener(apqt paramapqt)
  {
    this.jdField_a_of_type_Apqt = paramapqt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView
 * JD-Core Version:    0.7.0.1
 */