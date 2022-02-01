package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedHandler;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.qroute.QRoute;

class ChatHistoryEmotionBaseFragment$4$1
  implements QueryCallback<Emoticon>
{
  ChatHistoryEmotionBaseFragment$4$1(ChatHistoryEmotionBaseFragment.4 param4, EmoticonResp paramEmoticonResp) {}
  
  public void a(Emoticon paramEmoticon)
  {
    QQAppInterface localQQAppInterface1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a.a;
    IEmoBatchAddedHandlerApi localIEmoBatchAddedHandlerApi = (IEmoBatchAddedHandlerApi)QRoute.api(IEmoBatchAddedHandlerApi.class);
    QQAppInterface localQQAppInterface2 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a.a;
    IEmoBatchAddedHandler localIEmoBatchAddedHandler1 = ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a);
    IEmoBatchAddedHandler localIEmoBatchAddedHandler2 = ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$4.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp.epId);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp.emoticonId);
    MarketFaceItemBuilder.a(localQQAppInterface1, paramEmoticon, localIEmoBatchAddedHandlerApi.createEmoBatchAddedCallback(localQQAppInterface2, localIEmoBatchAddedHandler1, localIEmoBatchAddedHandler2.a(localStringBuilder.toString())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.4.1
 * JD-Core Version:    0.7.0.1
 */