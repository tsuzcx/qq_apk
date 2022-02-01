package com.tencent.mobileqq.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.qroute.QRoute;
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
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.a(this.jdField_a_of_type_Int);
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager.a(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.a();
    }
    else if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      Object localObject2 = ((IReadInJoySearchJumpUrlConfProcessor)QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig().c();
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
      }
      localObject1 = ((String)localObject1).replace("$KEYWORD$", URLEncoder.encode(str1));
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int != 25) && (this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int != 10)) {
        localObject1 = ((String)localObject1).replace("$FROM$", UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int));
      } else {
        localObject1 = ((String)localObject1).replace("$FROM$", "kandian_history");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(URLEncoder.encode(UniteSearchActivity.c));
      localObject1 = ((String)localObject1).replace("$SEARCHID$", ((StringBuilder)localObject2).toString());
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_AndroidContentContext, (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager.a(str1);
      localObject1 = new ReportModelDC02528().module("search_his").action("clk_search_his").ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int)).ver4(str1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{experiment_id:");
      ((StringBuilder)localObject2).append(UniteSearchReportController.b);
      ((StringBuilder)localObject2).append("}");
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
      localObject1 = new UniteSearchHandler(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str2 = UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.jdField_a_of_type_Int);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{experiment_id:");
      localStringBuilder.append(UniteSearchReportController.b);
      localStringBuilder.append("}");
      ((UniteSearchHandler)localObject1).b((QQAppInterface)localObject2, "clk_search_his", "search_his", str2, "", str1, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SearchWordHistoryAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */