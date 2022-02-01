package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.mobileqq.DrawerPushItem;
import java.util.Comparator;

class ApolloDaoManagerServiceImpl$15
  implements Comparator<DrawerPushItem>
{
  ApolloDaoManagerServiceImpl$15(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
  public int a(DrawerPushItem paramDrawerPushItem1, DrawerPushItem paramDrawerPushItem2)
  {
    int i;
    if (paramDrawerPushItem2.priority == paramDrawerPushItem1.priority) {
      i = paramDrawerPushItem1.sub_priority;
    }
    for (int j = paramDrawerPushItem2.sub_priority;; j = paramDrawerPushItem2.priority)
    {
      return i - j;
      i = paramDrawerPushItem1.priority;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.15
 * JD-Core Version:    0.7.0.1
 */