package com.tencent.mobileqq.apollo.aio.item.api;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IApolloItemBuilderFactory
  extends QRouteApi
{
  public abstract <T> T createChatItemBuilder(int paramInt, BaseQQAppInterface paramBaseQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.api.IApolloItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */