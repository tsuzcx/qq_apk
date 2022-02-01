package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReaderBannerProcessor$1
  implements View.OnClickListener
{
  ReaderBannerProcessor$1(ReaderBannerProcessor paramReaderBannerProcessor, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a().a(32, 0, null);
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("bookid", this.jdField_a_of_type_Long);
    localIntent1.putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    localIntent1.putExtra("is_from_conversation", true);
    Intent localIntent2 = new Intent();
    localIntent2.putExtras(localIntent1);
    localIntent2.putExtra("readtype", "15");
    localIntent2.setClassName(ReaderBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorReaderBannerProcessor), "cooperation.qqreader.QRBridgeActivity");
    localIntent2.addFlags(268435456);
    ReaderBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorReaderBannerProcessor).startActivity(localIntent2);
    ReportController.a(ReaderBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorReaderBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ReaderBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */