package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface IChatPieCreator
{
  public abstract boolean canReuse(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent);
  
  public abstract boolean clearLastWhenReuse(FragmentActivity paramFragmentActivity);
  
  public abstract BaseChatPie create(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator
 * JD-Core Version:    0.7.0.1
 */