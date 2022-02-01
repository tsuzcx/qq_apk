package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler;
import com.tencent.mobileqq.model.QueryCallback;

class ChatHistoryEmotionBaseFragment$4$1
  implements QueryCallback<Emoticon>
{
  ChatHistoryEmotionBaseFragment$4$1(ChatHistoryEmotionBaseFragment.4 param4, EmoticonResp paramEmoticonResp) {}
  
  public void a(Emoticon paramEmoticon)
  {
    MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a.a, paramEmoticon, new EmoBatchAddedCallback(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a.a, ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a), ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp.epId + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp.emoticonId)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.4.1
 * JD-Core Version:    0.7.0.1
 */