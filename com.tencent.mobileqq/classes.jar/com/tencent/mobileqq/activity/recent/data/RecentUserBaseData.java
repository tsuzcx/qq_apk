package com.tencent.mobileqq.activity.recent.data;

import ahee;
import android.content.Context;
import ascr;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  protected static final String DES_DEFAULT_HAVE_MSG = "%s,%s,%d条未读,%s";
  protected static final String DES_DEFAULT_NO_MSG = "%s,%s,%s";
  @ahee
  public RecentUser mUser;
  
  public RecentUserBaseData(RecentUser paramRecentUser)
  {
    if (paramRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.mUser = paramRecentUser;
    switch (this.mUser.getType())
    {
    }
    for (;;)
    {
      e();
      this.mMenuFlag &= 0xFFFFFF0F;
      if (this.mUser.showUpTime != 0L) {
        break;
      }
      this.mMenuFlag |= 0x10;
      return;
      this.mMenuFlag |= 0x1000;
      continue;
      this.mMenuFlag |= 0x2000;
    }
    this.mMenuFlag |= 0x20;
  }
  
  public int a()
  {
    return this.mUser.getType();
  }
  
  public long a()
  {
    return this.mUser.lastmsgtime;
  }
  
  public RecentUser a()
  {
    return this.mUser;
  }
  
  public String a()
  {
    return this.mUser.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mMsgExtroInfo = "";
    this.mMenuFlag &= 0xFFFFFF0F;
    if ((this.mUser.getType() == 1) && (!ascr.a(paramQQAppInterface, this.mUser)))
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      int j = this.mMenuFlag;
      if (paramQQAppInterface.b(this.mUser.uin)) {}
      for (int i = 32;; i = 16)
      {
        this.mMenuFlag = (i | j);
        return;
      }
    }
    FriendsStatusUtil.a(paramQQAppInterface, this.mUser);
    if ((this.mUser.showUpTime == 0L) && (9223372036854775807L - this.mUser.lastmsgtime > 4L))
    {
      this.mMenuFlag |= 0x10;
      return;
    }
    this.mMenuFlag |= 0x20;
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.mUser = paramRecentUser;
  }
  
  public final boolean a()
  {
    return (this.mUnreadFlag == 1) || (this.mUnreadFlag == 4);
  }
  
  public long b()
  {
    return this.mUser.lastmsgdrafttime;
  }
  
  public String c()
  {
    return this.mUser.troopUin;
  }
  
  public void e()
  {
    switch (this.mUser.getType())
    {
    }
    do
    {
      return;
    } while (!a());
    this.mMenuFlag &= 0xFFF0FFFF;
    if (this.mUnreadNum != 0)
    {
      this.mMenuFlag |= 0x10000;
      return;
    }
    this.mMenuFlag |= 0x20000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */