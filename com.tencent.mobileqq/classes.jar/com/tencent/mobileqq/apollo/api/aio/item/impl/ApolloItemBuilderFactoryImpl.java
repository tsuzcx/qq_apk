package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.api.aio.item.IApolloItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class ApolloItemBuilderFactoryImpl
  implements IApolloItemBuilderFactory
{
  public ChatItemBuilder createChatItemBuilder(int paramInt, QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 88: 
      return new ApolloGameItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    case 100: 
      return new CmGameTipsItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    }
    return new ApolloItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilderFactoryImpl
 * JD-Core Version:    0.7.0.1
 */