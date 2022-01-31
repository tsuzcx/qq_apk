package com.tencent.mobileqq.ar.view;

import actj;
import ajya;
import akxa;
import akzg;
import aljc;
import alje;
import aljo;
import alju;
import alkm;
import alku;
import alkv;
import alkz;
import allg;
import allt;
import almq;
import almr;
import alms;
import almt;
import almu;
import almv;
import almw;
import almx;
import almy;
import alnc;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
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
import android.widget.TextView;
import axqy;
import bbbr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import whj;

public class QRScanEntryView
  extends ScanEntryProviderView
  implements aljc, aljo, alkv, View.OnClickListener, View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private alnc jdField_a_of_type_Alnc;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new almq(this);
  protected View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewfinderView jdField_a_of_type_ComTencentMobileqqArViewViewfinderView;
  Runnable jdField_a_of_type_JavaLangRunnable = new QRScanEntryView.13(this);
  private String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new QRScanEntryView.1(this);
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Runnable jdField_c_of_type_JavaLangRunnable = new QRScanEntryView.2(this);
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public QRScanEntryView(Context paramContext, almy paramalmy)
  {
    super(paramContext, paramalmy);
  }
  
  private void a()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + alku.a().b() + ";mIsResumed=" + this.m);
    if ((alku.a().b()) && (this.m)) {
      alku.a().a(allg.jdField_a_of_type_Int, allg.jdField_b_of_type_Int);
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
      localObjectAnimator.addListener(new alms(this, paramView, paramBoolean1));
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
      paramView.setAlpha(1.0F);
      paramView.setVisibility(0);
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
        break label180;
      }
    }
    label180:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(localTextView, paramBoolean, true);
      if (!this.jdField_c_of_type_Boolean) {
        break label185;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844053, 0, 0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698595);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16717057);
      return;
      paramBoolean = false;
      break;
    }
    label185:
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844052, 0, 0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698596);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.e) && (paramBoolean))
    {
      axqy.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 1, 0, "", "", "", "");
      this.e = true;
    }
    while ((this.f) || (paramBoolean)) {
      return;
    }
    axqy.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 0, 0, "", "", "", "");
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
      ((alkz)this.jdField_a_of_type_Alkm).a(true, 0L);
      return;
    }
  }
  
  private void i()
  {
    LottieComposition.Factory.fromAssetFileName(this.jdField_a_of_type_AndroidContentContext, "qq_ar_light_first_show.json", new almr(this));
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
      View localView = LayoutInflater.from(getContext()).inflate(2131560645, this, true);
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131373422));
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView = ((ViewfinderView)findViewById(2131373427));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377369));
      allt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377370));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377372));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364746));
      if (paramBundle.getBoolean("hide_album", false)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(ajya.a(2131711224));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131711222));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131364747));
      findViewById(2131368630).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new almt(this));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373421));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373410));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new almu(this));
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    }
    alku.a().a(this);
    this.jdField_a_of_type_Alkm = new alkz();
    this.jdField_a_of_type_Alkm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ((alkz)this.jdField_a_of_type_Alkm).a(this, this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364196));
    asjn.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    if (alju.a())
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new almv(this));
    }
    this.k = true;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = Uri.parse("file://" + paramString);
    Object localObject1 = new SparseArray(2);
    int i = whj.a((Uri)localObject2, this.jdField_a_of_type_AndroidContentContext, 3, (SparseArray)localObject1);
    boolean bool1 = whj.a(i);
    boolean bool2 = whj.b(i);
    localObject2 = (Activity)this.jdField_a_of_type_AndroidContentContext;
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_QRScanEntryView", 2, "scan photo QRCode finish");
      }
      localObject1 = (Pair)((SparseArray)localObject1).get(1);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("detectType", 1);
      ((Intent)localObject2).putExtra("scannerResult", String.valueOf(((Pair)localObject1).first).trim());
      ((Intent)localObject2).putExtra("scannerType", String.valueOf(((Pair)localObject1).second).trim());
      ((Intent)localObject2).putExtra("filePath", paramString);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setResult(13, (Intent)localObject2);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
      return;
    }
    if ((bool2) && (localObject2 != null))
    {
      localObject1 = (String)((SparseArray)localObject1).get(2);
      ((alkz)this.jdField_a_of_type_Alkm).b(true);
      MiniAppLauncher.launchAppByMiniCode((Context)localObject2, (String)localObject1, 1049, new almw(this, (String)localObject1, paramString));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "doDealGalleryPicFile deal fail");
    }
    akzg.a(ajya.a(2131711223), false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeSuccess type=%s data=%s fromDetect=%b", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) }));
    }
    if (!this.m)
    {
      QLog.d("AREngine_QRScanEntryView", 1, "QREntry has closed,so give up this result");
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    if (localActivity != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("detectType", 1);
      localIntent.putExtra("scannerResult", paramString2.trim());
      localIntent.putExtra("scannerType", paramString1.trim());
      localActivity.setResult(13, localIntent);
      localActivity.finish();
      localActivity.overridePendingTransition(0, 0);
    }
    if ((localActivity != null) && ((localActivity instanceof ScanTorchActivity)))
    {
      long l = ((ScanTorchActivity)localActivity).a();
      if (l > 0L)
      {
        akxa.a().b(l, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_QRScanEntryView", 2, String.format("QR_识别_启动累计耗时 timeCost=%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        }
      }
    }
    axqy.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 0, 0, "", "", "", "");
  }
  
  public void a(List<alje> paramList, long paramLong)
  {
    boolean bool;
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramList.size() > 0)
      {
        bool = true;
        if (paramList.size() <= 0) {
          break label85;
        }
        localObject = ((alje)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect;
        label42:
        QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDetectResult suc=%b rect=%s", new Object[] { Boolean.valueOf(bool), localObject }));
      }
    }
    else {
      if (this.m) {
        break label93;
      }
    }
    label85:
    label93:
    while ((this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView == null) || (!alju.a()))
    {
      return;
      bool = false;
      break;
      localObject = "null";
      break label42;
    }
    if (paramList.size() > 0) {}
    for (paramList = ((alje)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect;; paramList = new Rect())
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setDetectRect(paramList);
      return;
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) }));
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDecodeResult suc=%b result=%s bFromDetect=%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2) }));
    }
    if (!this.m) {}
    label236:
    label240:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView != null) && (alju.a()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramBoolean2)
        {
          localObject = "1";
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" [ ").append(paramString).append(" ]");
          this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setMiniText(localStringBuilder.toString());
        }
      }
      else
      {
        if (!paramBoolean1) {
          continue;
        }
        if ((!bbbr.a(paramString, this.jdField_a_of_type_JavaLangString)) || (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 10000L)) {
          break label236;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
        if (localObject != null)
        {
          ((alkz)this.jdField_a_of_type_Alkm).b(true);
          MiniAppLauncher.launchAppByMiniCode((Context)localObject, paramString, 1047, new almx(this, paramString, (Activity)localObject));
        }
        axqy.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 1, 0, "", "", "", "");
        return;
        localObject = "0";
        break;
      }
    }
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
    ((alkz)this.jdField_a_of_type_Alkm).a(true, 1000L);
    a();
    if ((this.jdField_a_of_type_Alnc != null) && (!this.g))
    {
      this.jdField_a_of_type_Alnc.a(2);
      this.g = true;
    }
  }
  
  public void d()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onPause ");
    super.d();
    h();
    alku.a().a();
    if (this.jdField_a_of_type_Alnc != null)
    {
      this.jdField_a_of_type_Alnc.a(3);
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
    alku.a().b(this);
    if (this.jdField_a_of_type_Alnc != null) {
      this.jdField_a_of_type_Alnc.a(4);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    asjn.jdField_b_of_type_Boolean = false;
  }
  
  public void f()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewShow ");
    super.f();
    h();
    if (c())
    {
      a();
      if ((this.jdField_a_of_type_Alnc != null) && (!this.g))
      {
        this.jdField_a_of_type_Alnc.a(2);
        this.g = true;
      }
    }
  }
  
  public void g()
  {
    QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewClose ");
    super.g();
    ((alkz)this.jdField_a_of_type_Alkm).a(false, 0L);
    alku.a().a();
    if (this.jdField_c_of_type_Boolean) {
      alku.a().a(false);
    }
    if (this.jdField_a_of_type_Alnc != null)
    {
      this.jdField_a_of_type_Alnc.a(3);
      this.g = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377370: 
      l();
      return;
    }
    m();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (alku.a().b()) {
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
    if (this.jdField_a_of_type_Alkm != null) {
      ((alkz)this.jdField_a_of_type_Alkm).a(paramRect);
    }
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    if (this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.setRect(paramRect);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, paramRect.bottom - actj.a(60.0F, getResources()), localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
  }
  
  public void setVoiceScanStatusListener(alnc paramalnc)
  {
    this.jdField_a_of_type_Alnc = paramalnc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView
 * JD-Core Version:    0.7.0.1
 */