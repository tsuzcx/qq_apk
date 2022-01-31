package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.nearby.HotChatUtil;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  public RecentUser a;
  
  public RecentUserBaseData(RecentUser paramRecentUser)
  {
    if (paramRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.a = paramRecentUser;
    switch (this.a.type)
    {
    }
    for (;;)
    {
      e();
      this.f &= 0xFFFFFF0F;
      if (this.a.showUpTime != 0L) {
        break;
      }
      this.f |= 0x10;
      return;
      this.f |= 0x1000;
      continue;
      this.f |= 0x2000;
    }
    this.f |= 0x20;
  }
  
  public int a()
  {
    return this.a.type;
  }
  
  public long a()
  {
    return this.a.lastmsgtime;
  }
  
  public RecentUser a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.a.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.d = "";
    this.f &= 0xFFFFFF0F;
    if ((this.a.type == 1) && (!HotChatUtil.a(paramQQAppInterface, this.a)))
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
      int j = this.f;
      if (paramQQAppInterface.b(this.a.uin)) {}
      for (int i = 32;; i = 16)
      {
        this.f = (i | j);
        return;
      }
    }
    if ((this.a.showUpTime == 0L) && (9223372036854775807L - this.a.lastmsgtime > 4L))
    {
      this.f |= 0x10;
      return;
    }
    this.f |= 0x20;
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.a = paramRecentUser;
  }
  
  public final boolean a()
  {
    return (this.b == 1) || (this.b == 4);
  }
  
  public long b()
  {
    return this.a.lastmsgdrafttime;
  }
  
  public String c()
  {
    return this.a.troopUin;
  }
  
  public void e()
  {
    switch (this.a.type)
    {
    }
    do
    {
      return;
    } while (!a());
    this.f &= 0xFFF0FFFF;
    if (this.c != 0)
    {
      this.f |= 0x10000;
      return;
    }
    this.f |= 0x20000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */