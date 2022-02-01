package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.qphone.base.util.QLog;

class ChatPieApolloViewController$4
  extends IApolloRunnableTask
{
  ChatPieApolloViewController$4(ChatPieApolloViewController paramChatPieApolloViewController, ApolloRender paramApolloRender) {}
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return "sBasicScript";
  }
  
  public void run()
  {
    if (this.a.getSavaWrapper() != null) {
      this.a.getSavaWrapper().a(ApolloManagerServiceImpl.sBasicScript);
    }
    QLog.i("sava_ChatPieApolloViewController", 1, "preLoadEngine sBasicScript");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.4
 * JD-Core Version:    0.7.0.1
 */