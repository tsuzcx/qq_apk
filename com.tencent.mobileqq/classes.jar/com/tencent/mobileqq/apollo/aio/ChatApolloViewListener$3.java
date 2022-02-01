package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData.From;
import com.tencent.mobileqq.apollo.model.ApolloInfo;

class ChatApolloViewListener$3
  implements Runnable
{
  ChatApolloViewListener$3(ChatApolloViewListener paramChatApolloViewListener, BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo, String paramString, ApolloCmQQStatusData paramApolloCmQQStatusData, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    ChatApolloViewListener.a(this.this$0, this.a, this.b, this.c);
    this.d.showUpFreqDecrement(ApolloCmQQStatusData.From.AIO);
    this.d.printFreqRemaining();
    ChatApolloViewListener.a(this.this$0, this.a, l, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatApolloViewListener.3
 * JD-Core Version:    0.7.0.1
 */