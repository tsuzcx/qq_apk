package com.tencent.mobileqq.activity.contacts.friend;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import java.util.Comparator;

class BuddyListAdapter$MyComparator
  implements Comparator<BuddyListItem>
{
  public int a(BuddyListItem paramBuddyListItem1, BuddyListItem paramBuddyListItem2)
  {
    paramBuddyListItem1 = (Friends)paramBuddyListItem1.a;
    paramBuddyListItem2 = (Friends)paramBuddyListItem2.a;
    int i = a(paramBuddyListItem1);
    int j = a(paramBuddyListItem2);
    if (i == j) {
      return ContactSorter.a(paramBuddyListItem1.mComparePartInt, paramBuddyListItem1.mCompareSpell, paramBuddyListItem2.mComparePartInt, paramBuddyListItem2.mCompareSpell);
    }
    return i - j;
  }
  
  public int a(Friends paramFriends)
  {
    int k = OnlineStatusUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int j;
    if ((k != 6) && (k != 0)) {
      j = 65536;
    } else {
      j = 131072;
    }
    boolean bool = SimpleUIUtil.a();
    int i = 16384;
    if (!bool) {
      if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
        i = 0;
      } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        i = 4096;
      } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        i = 8192;
      } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        i = 12288;
      }
    }
    if (k != 1) {
      if (k != 2) {
        if ((k != 3) && (k != 4))
        {
          if (k == 7) {
            break label164;
          }
          i = (int)paramFriends.getLastLoginType() | i;
        }
      }
    }
    for (;;)
    {
      return i | j;
      i |= 0x1;
      continue;
      label164:
      i |= 0x3;
      continue;
      i |= 0x2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.MyComparator
 * JD-Core Version:    0.7.0.1
 */