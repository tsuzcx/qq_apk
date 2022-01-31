package com.tencent.mobileqq.activity.aio.item;

import adue;
import bcql;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Set;

class MarketFaceItemBuilder$10$1
  implements Runnable
{
  MarketFaceItemBuilder$10$1(MarketFaceItemBuilder.10 param10, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$10.this$0.a.isEmpty())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$10.this$0.a.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$10.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
      adue.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$10.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$10.jdField_a_of_type_Adus, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$10.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (!this.jdField_a_of_type_Boolean) {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$10.this$0.b, 1, 2131689911, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10.1
 * JD-Core Version:    0.7.0.1
 */