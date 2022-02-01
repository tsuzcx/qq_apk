package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.IMagicCallback;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$5
  implements PngFrameManager.IMagicCallback
{
  MarketFaceItemBuilder$5(MarketFaceItemBuilder paramMarketFaceItemBuilder, ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "func downloadVideoDetails, 【callback】 try to download video details.");
    }
    MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, paramHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */