package com.tencent.gdtad.basics.adbox;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class GdtAdBoxDialog
  extends ReportDialog
  implements GdtAdBoxView
{
  protected Activity a;
  protected GdtAdBox b;
  protected GdtAdBoxPresenter c;
  protected GdtAdBoxModel d;
  protected GridLayout e;
  protected View f;
  public GdtThirdProcessorProxy g = new GdtThirdProcessorProxy();
  private final GdtMotiveVideoClickCoordinateReportHelper h = new GdtMotiveVideoClickCoordinateReportHelper();
  private final List<AdExposureChecker> i = new ArrayList();
  private AdExposureChecker.ExposureCallback j = null;
  
  public GdtAdBoxDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953338);
    this.a = ((Activity)paramContext);
  }
  
  private void c()
  {
    this.d = new GdtAdBoxModel();
    this.c = new GdtAdBoxPresenter(this, this.d);
    this.c.a();
  }
  
  private void d()
  {
    Object localObject = getWindow();
    ((Window)localObject).setDimAmount(0.3F);
    localObject = (FrameLayout)((Window)localObject).getDecorView();
    this.f = getLayoutInflater().inflate(2131624933, (ViewGroup)localObject, false);
    setContentView(this.f);
    setOnDismissListener(new GdtAdBoxDialog.1(this));
    this.e = ((GridLayout)((FrameLayout)localObject).findViewById(2131434287));
    a();
    localObject = findViewById(2131449302);
    ((View)localObject).setOnClickListener(new GdtAdBoxDialog.2(this));
    ((View)localObject).setContentDescription(HardCodeUtil.a(2131886182));
    setCanceledOnTouchOutside(false);
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, LinearLayout paramLinearLayout)
  {
    Object localObject1 = this.b.a().getAds();
    paramInt5 = paramInt7 * paramInt1 + paramInt8;
    if (paramInt5 >= ((List)localObject1).size()) {
      return;
    }
    localObject1 = (GdtAd)((List)localObject1).get(paramInt5);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131435219);
    Object localObject2 = ((GdtAd)localObject1).info.display_info.basic_info.img.get();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("bindView() i = [");
    ((StringBuilder)localObject4).append(paramInt7);
    ((StringBuilder)localObject4).append("], j = [");
    ((StringBuilder)localObject4).append(paramInt8);
    ((StringBuilder)localObject4).append("], url = [");
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append("]");
    GdtLog.a("GdtAdBoxDialog", ((StringBuilder)localObject4).toString());
    try
    {
      localObject2 = this.g.a(this.a, (String)localObject2);
      if (localObject2 != null) {
        localImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    catch (Exception localException)
    {
      GdtLog.d("GdtAdBoxDialog", "bad url params", localException);
    }
    Object localObject3 = (TextView)paramLinearLayout.findViewById(2131439121);
    localObject4 = ((GdtAd)localObject1).info.display_info.mini_program_name.get().trim();
    ((TextView)localObject3).setText((CharSequence)localObject4);
    localImageView.setContentDescription((CharSequence)localObject4);
    ((TextView)localObject3).setContentDescription((CharSequence)localObject4);
    this.h.a(localImageView);
    localObject3 = new GridLayout.LayoutParams();
    ((GridLayout.LayoutParams)localObject3).rowSpec = GridLayout.spec(paramInt7, 1, GridLayout.LEFT);
    ((GridLayout.LayoutParams)localObject3).columnSpec = GridLayout.spec(paramInt8, 1, GridLayout.TOP);
    ((GridLayout.LayoutParams)localObject3).width = paramInt4;
    ((GridLayout.LayoutParams)localObject3).rightMargin = paramInt6;
    ((GridLayout.LayoutParams)localObject3).bottomMargin = paramInt6;
    if (paramInt7 == 0) {
      ((GridLayout.LayoutParams)localObject3).topMargin = paramInt3;
    }
    if (paramInt8 % paramInt1 == 0) {
      ((GridLayout.LayoutParams)localObject3).leftMargin = paramInt2;
    }
    paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localImageView.setOnClickListener(new GdtAdBoxDialog.4(this));
    localImageView.setTag(2131434080, localObject1);
    localImageView.setTag(2131449865, localObject1);
    GdtOriginalExposureReporter.a((GdtAd)localObject1, this.a);
    b();
    paramLinearLayout = new AdExposureChecker((Ad)localObject1, new WeakReference(localImageView));
    paramLinearLayout.setCallback(new WeakReference(this.j));
    this.i.add(paramLinearLayout);
    paramLinearLayout.startCheck();
  }
  
  public void a(View paramView)
  {
    Object localObject = paramView.getTag(2131449865);
    if ((localObject != null) && ((localObject instanceof GdtAd)))
    {
      localObject = (GdtAd)localObject;
      paramView = this.h.b(((GdtAd)localObject).getUrlForImpression(), b(paramView));
      GdtReporter.doCgiReport(paramView);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportImpression exposure report url: ");
      ((StringBuilder)localObject).append(paramView);
      QLog.d("GdtAdBoxDialog", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(GdtAdBox paramGdtAdBox)
  {
    this.b = paramGdtAdBox;
  }
  
  protected void a(GdtAdBoxModel paramGdtAdBoxModel)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bindData() called with: model = [");
    ((StringBuilder)localObject).append(paramGdtAdBoxModel);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("GdtAdBoxDialog", ((StringBuilder)localObject).toString());
    int m = this.b.a().getAds().size();
    if (m == 0)
    {
      paramGdtAdBoxModel = new StringBuilder();
      paramGdtAdBoxModel.append("bindData() called with: total = [");
      paramGdtAdBoxModel.append(m);
      paramGdtAdBoxModel.append("]");
      GdtLog.a("GdtAdBoxDialog", paramGdtAdBoxModel.toString());
      this.f.post(new GdtAdBoxDialog.3(this));
      return;
    }
    if (m > 9) {
      m = 9;
    }
    int i1 = (int)Math.ceil(m * 1.0F / 3);
    this.e.setColumnCount(3);
    this.e.setRowCount(i1);
    int i2 = ViewUtils.dip2px(26.0F);
    int i3 = ViewUtils.dip2px(38.0F);
    int i4 = ViewUtils.dip2px(4.0F);
    int i5 = ViewUtils.dip2px(98.0F);
    int i6 = ViewUtils.dip2px(65.0F);
    int i7 = i6 + ViewUtils.dip2px(24.0F);
    int i8 = ViewUtils.dip2px(22.0F);
    this.e.removeAllViews();
    paramGdtAdBoxModel = LayoutInflater.from(this.a);
    int k = 0;
    while (k < i1)
    {
      int n = 0;
      while ((n < 3) && (3 * k + n < m))
      {
        localObject = (LinearLayout)paramGdtAdBoxModel.inflate(2131624924, null);
        a(3, i2, i3, i6, i7, i8, k, n, (LinearLayout)localObject);
        this.e.addView((View)localObject);
        n += 1;
      }
      k += 1;
    }
    paramGdtAdBoxModel = this.f.getLayoutParams();
    paramGdtAdBoxModel.width = (i2 + (i6 + i8) * 3 + i4);
    paramGdtAdBoxModel.height = (i3 + (i7 + i8) * i1 + i5);
    this.f.setLayoutParams(paramGdtAdBoxModel);
  }
  
  public GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams b(View paramView)
  {
    try
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      paramView = new GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams(paramView.getWidth(), paramView.getHeight(), arrayOfInt[0], arrayOfInt[1]);
      return paramView;
    }
    catch (Exception paramView)
    {
      QLog.i("GdtAdBoxDialog", 1, "gdiReportExposure", paramView);
    }
    return null;
  }
  
  public void b()
  {
    if (this.j == null) {
      this.j = new GdtAdBoxDialog.5(this);
    }
  }
  
  public void b(GdtAdBoxModel paramGdtAdBoxModel)
  {
    a(paramGdtAdBoxModel);
  }
  
  public void onBackPressed()
  {
    if (this.c.e()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    c();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.c.b();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityResume();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.c.c();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityPause();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWindowFocusChanged() called with: hasFocus = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    GdtLog.a("GdtAdBoxDialog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxDialog
 * JD-Core Version:    0.7.0.1
 */