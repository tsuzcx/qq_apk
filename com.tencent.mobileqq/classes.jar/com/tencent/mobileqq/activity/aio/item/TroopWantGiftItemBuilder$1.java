package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopWantGiftItemBuilder$1
  implements View.OnClickListener
{
  TroopWantGiftItemBuilder$1(TroopWantGiftItemBuilder paramTroopWantGiftItemBuilder, ChatMessage paramChatMessage, MessageForWantGiftMsg paramMessageForWantGiftMsg) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373889)
    {
      Object localObject1 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_send_him").a(0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
      ((StringBuilder)localObject2).append("");
      ((ReportTask)localObject1).a(new String[] { ((StringBuilder)localObject2).toString(), "29" }).a();
      localObject1 = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_AndroidContentContext, "url");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForWantGiftMsg.frienduin);
      localObject1 = ((String)localObject1).replace("{troopUin}", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForWantGiftMsg.senderuin);
      localObject1 = ((String)localObject1).replace("{uin}", ((StringBuilder)localObject2).toString()).replace("{from}", "29");
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopWantGiftItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */