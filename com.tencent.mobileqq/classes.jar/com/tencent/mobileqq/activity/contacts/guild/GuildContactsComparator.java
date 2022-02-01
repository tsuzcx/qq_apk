package com.tencent.mobileqq.activity.contacts.guild;

import android.text.TextUtils;
import java.util.Comparator;

public class GuildContactsComparator
  implements Comparator<GuildContactsDataItem>
{
  public int a(GuildContactsDataItem paramGuildContactsDataItem1, GuildContactsDataItem paramGuildContactsDataItem2)
  {
    if (paramGuildContactsDataItem1.b > paramGuildContactsDataItem2.b) {
      return -1;
    }
    if (paramGuildContactsDataItem1.b == paramGuildContactsDataItem2.b)
    {
      if (!TextUtils.isEmpty(paramGuildContactsDataItem1.c)) {
        return paramGuildContactsDataItem1.c.compareTo(paramGuildContactsDataItem2.c);
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.guild.GuildContactsComparator
 * JD-Core Version:    0.7.0.1
 */