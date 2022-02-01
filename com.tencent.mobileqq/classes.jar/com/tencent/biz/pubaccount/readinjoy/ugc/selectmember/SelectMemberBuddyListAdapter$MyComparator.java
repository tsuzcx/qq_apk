package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

class SelectMemberBuddyListAdapter$MyComparator
  implements Comparator<SelectMemberBuddyListAdapter.FriendHolder>
{
  public int a(SelectMemberBuddyListAdapter.FriendHolder paramFriendHolder)
  {
    if (paramFriendHolder.jdField_a_of_type_Int != -1) {
      return paramFriendHolder.jdField_a_of_type_Int;
    }
    Friends localFriends = paramFriendHolder.jdField_a_of_type_ComTencentMobileqqDataFriends;
    int k = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
    int j;
    int i;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label132;
      }
      i = 4096;
      switch (k)
      {
      case 5: 
      case 6: 
      default: 
        label64:
        i = j | i | (int)localFriends.getLastLoginType();
      }
    }
    for (;;)
    {
      paramFriendHolder.jdField_a_of_type_Int = i;
      return i;
      j = 131072;
      break;
      label132:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        i = 8192;
        break label64;
      }
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ))
      {
        i = 12288;
        break label64;
      }
      i = 16384;
      break label64;
      i = j | i | 0x1;
      continue;
      i = j | i | 0x2;
      continue;
      i = j | i | 0x3;
    }
  }
  
  public int a(SelectMemberBuddyListAdapter.FriendHolder paramFriendHolder1, SelectMemberBuddyListAdapter.FriendHolder paramFriendHolder2)
  {
    return a(paramFriendHolder1) - a(paramFriendHolder2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.SelectMemberBuddyListAdapter.MyComparator
 * JD-Core Version:    0.7.0.1
 */