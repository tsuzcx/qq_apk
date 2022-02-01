package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.DrawerPushItem;
import java.util.Comparator;

class ApolloManagerServiceImpl$21
  implements Comparator<DrawerPushItem>
{
  ApolloManagerServiceImpl$21(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public int a(DrawerPushItem paramDrawerPushItem1, DrawerPushItem paramDrawerPushItem2)
  {
    if (paramDrawerPushItem2.priority == paramDrawerPushItem1.priority) {
      return paramDrawerPushItem1.sub_priority - paramDrawerPushItem2.sub_priority;
    }
    return paramDrawerPushItem1.priority - paramDrawerPushItem2.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.21
 * JD-Core Version:    0.7.0.1
 */