package com.tencent.mobileqq.activity.aio.item;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ThumbItemBuilder$2
  implements View.OnClickListener
{
  ThumbItemBuilder$2(ThumbItemBuilder paramThumbItemBuilder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40303);
    String str = IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, "call", "mvip.gongneng.anroid.individuation.web");
    str = str + "&funcallId=" + this.jdField_a_of_type_Int;
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, str, 524288L, localIntent, true, -1);
    int i = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    if (i == 2) {
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004A25", "0X8004A25", 0, 0, "" + i, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 3) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */