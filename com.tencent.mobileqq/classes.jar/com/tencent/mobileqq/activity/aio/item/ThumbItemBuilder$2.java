package com.tencent.mobileqq.activity.aio.item;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class ThumbItemBuilder$2
  implements View.OnClickListener
{
  ThumbItemBuilder$2(ThumbItemBuilder paramThumbItemBuilder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("individuation_url_type", 40303);
    Object localObject2 = IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, "call", "mvip.gongneng.anroid.individuation.web");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("&funcallId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localObject2 = localStringBuilder.toString();
    VasWebviewUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, (String)localObject2, 524288L, (Intent)localObject1, true, -1);
    int j = ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    int i;
    if (j == 2)
    {
      i = 0;
    }
    else
    {
      i = j;
      if (j == 3) {
        i = 2;
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(i);
    ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004A25", "0X8004A25", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */