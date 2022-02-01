package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public class DiscussChatPieCreator
  implements IChatPieCreator
{
  public boolean canReuse(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    return paramBaseChatPie instanceof DiscussChatPie;
  }
  
  public boolean clearLastWhenReuse(FragmentActivity paramFragmentActivity)
  {
    return ((paramFragmentActivity instanceof SplashActivity)) || ((paramFragmentActivity instanceof ChatActivity));
  }
  
  public BaseChatPie create(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    return new DiscussChatPie(paramQQAppInterface, paramTopGestureLayout, paramFragmentActivity, paramFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.DiscussChatPieCreator
 * JD-Core Version:    0.7.0.1
 */