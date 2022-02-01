package com.tencent.mobileqq.apollo.aio.item.api.impl;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class ApolloItemBuilderFactoryImpl
  implements IApolloItemBuilderFactory
{
  public <T> T createChatItemBuilder(int paramInt, BaseQQAppInterface paramBaseQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, Object paramObject1, Object paramObject2)
  {
    paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    paramObject1 = (SessionInfo)paramObject1;
    paramObject2 = (AIOAnimationConatiner)paramObject2;
    if (paramInt != 56)
    {
      if (paramInt != 88) {}
      return null;
    }
    return new ApolloItemBuilder(paramBaseQQAppInterface, paramBaseAdapter, paramContext, paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.api.impl.ApolloItemBuilderFactoryImpl
 * JD-Core Version:    0.7.0.1
 */