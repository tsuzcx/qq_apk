package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ComicBannerProcessor$1
  implements View.OnClickListener
{
  ComicBannerProcessor$1(ComicBannerProcessor paramComicBannerProcessor, String paramString) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "20");
      label17:
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(ComicBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorComicBannerProcessor), "/base/vipcomic");
      localActivityURIRequest.extra().putString("options", localJSONObject.toString());
      QRoute.startUri(localActivityURIRequest, null);
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145((AppInterface)ComicBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorComicBannerProcessor).getAppRuntime(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      ReportController.a(ComicBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorComicBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ComicBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */