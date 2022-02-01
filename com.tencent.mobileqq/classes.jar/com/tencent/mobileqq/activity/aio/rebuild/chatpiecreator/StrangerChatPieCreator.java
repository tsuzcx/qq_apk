package com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator;

import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class StrangerChatPieCreator
  implements IChatPieCreator
{
  public BaseChatPie a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    return new StrangerChatPie(paramQQAppInterface, paramTopGestureLayout, paramBaseActivity, paramBaseActivity);
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return ((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity));
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    return paramBaseChatPie.getClass() == StrangerChatPie.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.StrangerChatPieCreator
 * JD-Core Version:    0.7.0.1
 */