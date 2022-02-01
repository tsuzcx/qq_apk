package com.tencent.gdtad.api.adbox;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoClickCoordinateReportHelper;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
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
  private final GdtMotiveVideoClickCoordinateReportHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper = new GdtMotiveVideoClickCoordinateReportHelper();
  private final List<AdExposureChecker> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public GdtAdBoxDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755842);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxModel = new GdtAdBoxModel();
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxPresenter = new GdtAdBoxPresenter(this, this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxModel);
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxPresenter.a();
  }
  
  private void d()
  {
    Object localObject = getWindow();
    ((Window)localObject).setDimAmount(0.3F);
    localObject = (FrameLayout)((Window)localObject).getDecorView();
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559305, (ViewGroup)localObject, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOnDismissListener(new GdtAdBoxDialog.1(this));
    this.jdField_a_of_type_AndroidWidgetGridLayout = ((GridLayout)((FrameLayout)localObject).findViewById(2131367964));
    a();
    localObject = findViewById(2131381103);
    ((View)localObject).setOnClickListener(new GdtAdBoxDialog.2(this));
    ((View)localObject).setContentDescription(HardCodeUtil.a(2131690946));
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
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBox.a().getAds();
    paramInt5 = paramInt7 * paramInt1 + paramInt8;
    if (paramInt5 >= ((List)localObject1).size()) {
      return;
    }
    localObject1 = (GdtAd)((List)localObject1).get(paramInt5);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131368603);
    Object localObject2 = ((GdtAd)localObject1).info.display_info.basic_info.img.get();
    GdtLog.a("GdtAdBoxDialog", "bindView() i = [" + paramInt7 + "], j = [" + paramInt8 + "], url = [" + (String)localObject2 + "]");
    try
    {
      localImageView.setImageDrawable(((IMiniAppService)QRoute.api(IMiniAppService.class)).getIcon(localImageView.getContext(), (String)localObject2, true, 2130841320, 65));
      localObject2 = (TextView)paramLinearLayout.findViewById(2131372115);
      String str = ((GdtAd)localObject1).info.display_info.mini_program_name.get().trim();
      ((TextView)localObject2).setText(str);
      localImageView.setContentDescription(str);
      ((TextView)localObject2).setContentDescription(str);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(localImageView);
      localObject2 = new GridLayout.LayoutParams();
      ((GridLayout.LayoutParams)localObject2).rowSpec = GridLayout.spec(paramInt7, 1, GridLayout.LEFT);
      ((GridLayout.LayoutParams)localObject2).columnSpec = GridLayout.spec(paramInt8, 1, GridLayout.TOP);
      ((GridLayout.LayoutParams)localObject2).width = paramInt4;
      ((GridLayout.LayoutParams)localObject2).rightMargin = paramInt6;
      ((GridLayout.LayoutParams)localObject2).bottomMargin = paramInt6;
      if (paramInt7 == 0) {
        ((GridLayout.LayoutParams)localObject2).topMargin = paramInt3;
      }
      if (paramInt8 % paramInt1 == 0) {
        ((GridLayout.LayoutParams)localObject2).leftMargin = paramInt2;
      }
      paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localImageView.setOnClickListener(new GdtAdBoxDialog.4(this));
      localImageView.setTag(2131367779, localObject1);
      localImageView.setTag(2131381649, localObject1);
      GdtOriginalExposureReporter.a((GdtAd)localObject1, this.jdField_a_of_type_AndroidAppActivity);
      b();
      paramLinearLayout = new AdExposureChecker((Ad)localObject1, new WeakReference(localImageView));
      paramLinearLayout.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_JavaUtilList.add(paramLinearLayout);
      paramLinearLayout.startCheck();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        GdtLog.d("GdtAdBoxDialog", "bad url params", localException);
      }
    }
  }
  
  public void a(View paramView)
  {
    Object localObject = paramView.getTag(2131381649);
    if ((localObject != null) && ((localObject instanceof GdtAd)))
    {
      localObject = (GdtAd)localObject;
      paramView = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.b(((GdtAd)localObject).getUrlForImpression(), a(paramView));
      GdtReporter.doCgiReport(paramView);
      QLog.d("GdtAdBoxDialog", 1, "reportImpression exposure report url: " + paramView);
    }
  }
  
  public void a(GdtAdBox paramGdtAdBox)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBox = paramGdtAdBox;
  }
  
  protected void a(GdtAdBoxModel paramGdtAdBoxModel)
  {
    GdtLog.a("GdtAdBoxDialog", "bindData() called with: model = [" + paramGdtAdBoxModel + "]");
    int i = this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBox.a().getAds().size();
    if (i == 0)
    {
      GdtLog.a("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
      this.jdField_a_of_type_AndroidViewView.post(new GdtAdBoxDialog.3(this));
      return;
    }
    if (i > 9) {
      i = 9;
    }
    for (;;)
    {
      int m = (int)Math.ceil(i * 1.0F / 3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
      int n = GdtUIUtils.a(23.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i1 = GdtUIUtils.a(21.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i2 = GdtUIUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i3 = GdtUIUtils.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i4 = GdtUIUtils.a(65.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i5 = i4 + GdtUIUtils.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i6 = GdtUIUtils.a(22.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramGdtAdBoxModel = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
      int j = 0;
      if (j < m)
      {
        int k = 0;
        for (;;)
        {
          if ((k >= 3) || (3 * j + k >= i))
          {
            j += 1;
            break;
          }
          LinearLayout localLinearLayout = (LinearLayout)paramGdtAdBoxModel.inflate(2131559296, null);
          a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramGdtAdBoxModel = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramGdtAdBoxModel.width = (3 * (i4 + i6) + n + i2);
      paramGdtAdBoxModel.height = ((i5 + i6) * m + i1 + i3);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramGdtAdBoxModel);
      return;
    }
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
    if (this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxPresenter.a()) {
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
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxPresenter.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxPresenter.c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityPause();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    GdtLog.a("GdtAdBoxDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBoxDialog
 * JD-Core Version:    0.7.0.1
 */