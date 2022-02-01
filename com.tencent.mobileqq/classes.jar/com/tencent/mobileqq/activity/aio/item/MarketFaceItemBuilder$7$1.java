package com.tencent.mobileqq.activity.aio.item;

import ahch;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Set;

class MarketFaceItemBuilder$7$1
  implements Runnable
{
  MarketFaceItemBuilder$7$1(MarketFaceItemBuilder.7 param7, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.this$0.a.isEmpty())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.this$0.a.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
      ahch.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.jdField_a_of_type_Ahcu, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (!this.jdField_a_of_type_Boolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.this$0.b, 1, 2131689862, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1
 * JD-Core Version:    0.7.0.1
 */