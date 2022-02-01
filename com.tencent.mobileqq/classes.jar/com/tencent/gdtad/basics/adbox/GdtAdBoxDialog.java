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
  protected View a;
  protected GridLayout a;
  private AdExposureChecker.ExposureCallback jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
  protected GdtAdBox a;
  protected GdtAdBoxModel a;
  protected GdtAdBoxPresenter a;
  private final GdtMotiveVideoClickCoordinateReportHelper jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper = new GdtMotiveVideoClickCoordinateReportHelper();
  public GdtThirdProcessorProxy a;
  private final List<AdExposureChecker> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public GdtAdBoxDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy = new GdtThirdProcessorProxy();
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxModel = new GdtAdBoxModel();
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxPresenter = new GdtAdBoxPresenter(this, this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxModel);
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxPresenter.a();
  }
  
  private void d()
  {
    Object localObject = getWindow();
    ((Window)localObject).setDimAmount(0.3F);
    localObject = (FrameLayout)((Window)localObject).getDecorView();
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559178, (ViewGroup)localObject, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOnDismissListener(new GdtAdBoxDialog.1(this));
    this.jdField_a_of_type_AndroidWidgetGridLayout = ((GridLayout)((FrameLayout)localObject).findViewById(2131367722));
    a();
    localObject = findViewById(2131380358);
    ((View)localObject).setOnClickListener(new GdtAdBoxDialog.2(this));
    ((View)localObject).setContentDescription(HardCodeUtil.a(2131689572));
    setCanceledOnTouchOutside(false);
  }
  
  public GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams a(View paramView)
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
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, LinearLayout paramLinearLayout)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBox.a().getAds();
    paramInt5 = paramInt7 * paramInt1 + paramInt8;
    if (paramInt5 >= ((List)localObject1).size()) {
      return;
    }
    localObject1 = (GdtAd)((List)localObject1).get(paramInt5);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131368343);
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
      localObject2 = this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject2);
      if (localObject2 != null) {
        localImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    catch (Exception localException)
    {
      GdtLog.d("GdtAdBoxDialog", "bad url params", localException);
    }
    Object localObject3 = (TextView)paramLinearLayout.findViewById(2131371697);
    localObject4 = ((GdtAd)localObject1).info.display_info.mini_program_name.get().trim();
    ((TextView)localObject3).setText((CharSequence)localObject4);
    localImageView.setContentDescription((CharSequence)localObject4);
    ((TextView)localObject3).setContentDescription((CharSequence)localObject4);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper.a(localImageView);
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
    localImageView.setTag(2131367538, localObject1);
    localImageView.setTag(2131380882, localObject1);
    GdtOriginalExposureReporter.a((GdtAd)localObject1, this.jdField_a_of_type_AndroidAppActivity);
    b();
    paramLinearLayout = new AdExposureChecker((Ad)localObject1, new WeakReference(localImageView));
    paramLinearLayout.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    this.jdField_a_of_type_JavaUtilList.add(paramLinearLayout);
    paramLinearLayout.startCheck();
  }
  
  public void a(View paramView)
  {
    Object localObject = paramView.getTag(2131380882);
    if ((localObject != null) && ((localObject instanceof GdtAd)))
    {
      localObject = (GdtAd)localObject;
      paramView = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper.b(((GdtAd)localObject).getUrlForImpression(), a(paramView));
      GdtReporter.doCgiReport(paramView);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportImpression exposure report url: ");
      ((StringBuilder)localObject).append(paramView);
      QLog.d("GdtAdBoxDialog", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(GdtAdBox paramGdtAdBox)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBox = paramGdtAdBox;
  }
  
  protected void a(GdtAdBoxModel paramGdtAdBoxModel)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bindData() called with: model = [");
    ((StringBuilder)localObject).append(paramGdtAdBoxModel);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("GdtAdBoxDialog", ((StringBuilder)localObject).toString());
    int j = this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBox.a().getAds().size();
    if (j == 0)
    {
      paramGdtAdBoxModel = new StringBuilder();
      paramGdtAdBoxModel.append("bindData() called with: total = [");
      paramGdtAdBoxModel.append(j);
      paramGdtAdBoxModel.append("]");
      GdtLog.a("GdtAdBoxDialog", paramGdtAdBoxModel.toString());
      this.jdField_a_of_type_AndroidViewView.post(new GdtAdBoxDialog.3(this));
      return;
    }
    if (j > 9) {
      j = 9;
    }
    int m = (int)Math.ceil(j * 1.0F / 3);
    this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
    this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
    int n = ViewUtils.a(26.0F);
    int i1 = ViewUtils.a(38.0F);
    int i2 = ViewUtils.a(4.0F);
    int i3 = ViewUtils.a(98.0F);
    int i4 = ViewUtils.a(65.0F);
    int i5 = i4 + ViewUtils.a(24.0F);
    int i6 = ViewUtils.a(22.0F);
    this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
    paramGdtAdBoxModel = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
    int i = 0;
    while (i < m)
    {
      int k = 0;
      while ((k < 3) && (3 * i + k < j))
      {
        localObject = (LinearLayout)paramGdtAdBoxModel.inflate(2131559169, null);
        a(3, n, i1, i4, i5, i6, i, k, (LinearLayout)localObject);
        this.jdField_a_of_type_AndroidWidgetGridLayout.addView((View)localObject);
        k += 1;
      }
      i += 1;
    }
    paramGdtAdBoxModel = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramGdtAdBoxModel.width = (n + (i4 + i6) * 3 + i2);
    paramGdtAdBoxModel.height = (i1 + (i5 + i6) * m + i3);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramGdtAdBoxModel);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new GdtAdBoxDialog.5(this);
    }
  }
  
  public void b(GdtAdBoxModel paramGdtAdBoxModel)
  {
    a(paramGdtAdBoxModel);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxPresenter.a()) {
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
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxPresenter.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityResume();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxPresenter.c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxDialog
 * JD-Core Version:    0.7.0.1
 */