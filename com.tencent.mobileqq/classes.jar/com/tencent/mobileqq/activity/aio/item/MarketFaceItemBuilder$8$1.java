package com.tencent.mobileqq.activity.aio.item;

import ahaw;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Set;

class MarketFaceItemBuilder$8$1
  implements Runnable
{
  MarketFaceItemBuilder$8$1(MarketFaceItemBuilder.8 param8, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$8.this$0.a.isEmpty())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$8.this$0.a.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$8.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
      ahaw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$8.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$8.jdField_a_of_type_Ahbj, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$8.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (!this.jdField_a_of_type_Boolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$8.this$0.b, 1, 2131689908, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8.1
 * JD-Core Version:    0.7.0.1
 */