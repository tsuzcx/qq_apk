package com.tencent.mobileqq.activity.contacts.base;

import android.content.Context;
import com.tencent.mobileqq.activity.contacts.device.BuddyListDevices;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.contacts.phone.BuddyListPhone;
import com.tencent.mobileqq.activity.contacts.troop.BuddyListTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;

public class BuddyItemBuilder
{
  public static BuddyListItem a(int paramInt, Entity paramEntity, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new BuddyListFriends(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 5) {
      return new BuddyListDevices(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 1) {
      return new BuddyListPhone(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 2) {
      return new BuddyListTroop(paramQQAppInterface, paramContext, paramEntity, 2);
    }
    if (paramInt == 3) {
      return new BuddyListTroop(paramQQAppInterface, paramContext, paramEntity, 3);
    }
    if (paramInt == 4) {
      return new BuddyListFriends(paramQQAppInterface, paramContext, paramEntity);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.BuddyItemBuilder
 * JD-Core Version:    0.7.0.1
 */