package com.tencent.mobileqq.apollo.api.aio.impl;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.api.aio.ICmGameChatPieCreator;
import com.tencent.mobileqq.app.QQAppInterface;

public class CmGameChatPieCreatorImpl
  implements IChatPieCreator, ICmGameChatPieCreator
{
  public boolean canReuse(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    return false;
  }
  
  public boolean clearLastWhenReuse(FragmentActivity paramFragmentActivity)
  {
    return false;
  }
  
  public BaseChatPie create(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    return new CmGameChatPie(paramQQAppInterface, paramTopGestureLayout, paramFragmentActivity, paramFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPieCreatorImpl
 * JD-Core Version:    0.7.0.1
 */