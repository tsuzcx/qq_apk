package com.tencent.mobileqq.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfBean;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

class SearchWordHistoryAdapter$ViewHolder
  implements View.OnClickListener
{
  public int a;
  public View a;
  public ImageView a;
  public TextView a;
  public PressEffectImageView a;
  public View b;
  
  SearchWordHistoryAdapter$ViewHolder(SearchWordHistoryAdapter paramSearchWordHistoryAdapter) {}
  
  public void onClick(View paramView)
  {
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.a(this.jdField_a_of_type_Int);
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager.a(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.a();
    }
    while (paramView != this.jdField_a_of_type_AndroidViewView)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str2 = ReadInjoySearchJumpurlConfProcessor.a().c;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    str1 = str1.replace("$KEYWORD$", URLEncoder.encode(str3));
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int == 25) || (this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int == 10)) {}
    for (str1 = str1.replace("$FROM$", "kandian_history");; str1 = str1.replace("$FROM$", UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int)))
    {
      str1 = str1.replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.c));
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_AndroidContentContext, str1);
      this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager.a(str3);
      UniteSearchReportController.a(null, new ReportModelDC02528().module("search_his").action("clk_search_his").ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int)).ver4(str3).ver7("{experiment_id:" + UniteSearchReportController.b + "}"));
      new UniteSearchHandler(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_search_his", "search_his", UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int), "", str3, "{experiment_id:" + UniteSearchReportController.b + "}");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SearchWordHistoryAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */