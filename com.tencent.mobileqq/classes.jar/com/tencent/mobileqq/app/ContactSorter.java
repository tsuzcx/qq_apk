package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ContactSorter
{
  public static Comparator<Entity> a = new ContactSorter.1();
  
  private static int a(char paramChar)
  {
    if (((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'))) {
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return 10;
    }
    return 5;
  }
  
  public static int a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 < paramInt2) {
      return -1;
    }
    String str2 = "";
    String str1 = paramString1;
    if (paramString1 == null) {
      str1 = "";
    }
    if (paramString2 == null) {
      paramString2 = str2;
    }
    return str1.compareTo(paramString2);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 != null) {
      i = paramString1.length();
    } else {
      i = 0;
    }
    int j;
    if (paramString2 != null) {
      j = paramString2.length();
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0))
    {
      char[] arrayOfChar1 = ChnToSpell.b(paramString1, 1).toCharArray();
      char[] arrayOfChar2 = ChnToSpell.b(paramString2, 1).toCharArray();
      i = a(arrayOfChar1[0]);
      j = a(arrayOfChar2[0]);
      if (i > j) {
        return 1;
      }
      if (i < j) {
        return -1;
      }
      if (arrayOfChar1[0] > arrayOfChar2[0]) {
        return 1;
      }
      if (arrayOfChar1[0] < arrayOfChar2[0]) {
        return -1;
      }
      if (paramString1.charAt(0) < 'ÿ') {
        i = 1;
      } else {
        i = 0;
      }
      if (paramString2.charAt(0) < 'ÿ') {
        j = 1;
      } else {
        j = 0;
      }
      if ((i ^ j) != 0) {
        return paramString1.charAt(0) - paramString2.charAt(0);
      }
      j = Math.min(arrayOfChar1.length, arrayOfChar2.length);
      i = 1;
      while (i < j)
      {
        if (arrayOfChar1[i] > arrayOfChar2[i]) {
          return 1;
        }
        if (arrayOfChar1[i] < arrayOfChar2[i]) {
          return -1;
        }
        i += 1;
      }
      if (arrayOfChar1.length > arrayOfChar2.length) {
        return 1;
      }
      if (arrayOfChar1.length < arrayOfChar2.length) {
        return -1;
      }
      return 0;
    }
    return i - j;
  }
  
  public static void a(DiscussionInfo paramDiscussionInfo)
  {
    String str = b(paramDiscussionInfo);
    paramDiscussionInfo.mCompareSpell = ChnToSpell.b(str, 1);
    paramDiscussionInfo.mComparePartInt = b(str, paramDiscussionInfo.mCompareSpell);
  }
  
  public static void a(Friends paramFriends)
  {
    String str = b(paramFriends);
    paramFriends.mCompareSpell = ChnToSpell.b(str, 1);
    paramFriends.mComparePartInt = b(str, paramFriends.mCompareSpell);
  }
  
  public static void a(PublicAccountInfo paramPublicAccountInfo)
  {
    String str = b(paramPublicAccountInfo);
    paramPublicAccountInfo.mCompareSpell = ChnToSpell.b(str, 1);
    paramPublicAccountInfo.mComparePartInt = b(str, paramPublicAccountInfo.mCompareSpell);
  }
  
  public static int b(String paramString1, String paramString2)
  {
    int j = 0;
    int k = paramString2.charAt(0);
    int i;
    if (((k >= 65) && (k <= 90)) || ((k >= 97) && (k <= 122))) {
      i = 65536;
    } else if ((k >= 48) && (k <= 57)) {
      i = 262144;
    } else {
      i = 131072;
    }
    if (paramString1.charAt(0) >= 'ÿ') {
      j = 1;
    }
    return k << 8 | i | 0x0 | j;
  }
  
  public static String b(DiscussionInfo paramDiscussionInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDiscussionInfo.discussionName);
    localStringBuilder.append("-");
    localStringBuilder.append(paramDiscussionInfo.uin);
    return localStringBuilder.toString();
  }
  
  public static String b(Friends paramFriends)
  {
    String str = paramFriends.getFriendNick();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("-");
    localStringBuilder.append(paramFriends.uin);
    return localStringBuilder.toString();
  }
  
  public static String b(PublicAccountInfo paramPublicAccountInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPublicAccountInfo.name);
    localStringBuilder.append("-");
    localStringBuilder.append(paramPublicAccountInfo.uin);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactSorter
 * JD-Core Version:    0.7.0.1
 */