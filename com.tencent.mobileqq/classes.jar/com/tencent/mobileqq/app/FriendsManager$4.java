package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

class FriendsManager$4
  implements Comparator<SpecialCareInfo>
{
  FriendsManager$4(FriendsManager paramFriendsManager) {}
  
  private String a(SpecialCareInfo paramSpecialCareInfo)
  {
    Friends localFriends = this.a.c(paramSpecialCareInfo.uin);
    if (localFriends == null) {
      return paramSpecialCareInfo.uin;
    }
    paramSpecialCareInfo = new StringBuilder();
    paramSpecialCareInfo.append(ContactUtils.a(localFriends));
    paramSpecialCareInfo.append(localFriends.uin);
    return paramSpecialCareInfo.toString();
  }
  
  public int a(SpecialCareInfo paramSpecialCareInfo1, SpecialCareInfo paramSpecialCareInfo2)
  {
    return ContactSorter.a(a(paramSpecialCareInfo1), a(paramSpecialCareInfo2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager.4
 * JD-Core Version:    0.7.0.1
 */