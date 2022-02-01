package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.RecentBaseDataConfig;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.data.RecentUser;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  protected static final String DES_DEFAULT_HAVE_MSG = "%s,%s,%d条未读,%s";
  protected static final String DES_DEFAULT_NO_MSG = "%s,%s,%s";
  @ParcelAnnotation.NotParcel
  protected Bundle mArgsBundle;
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  
  public RecentUserBaseData(RecentUser paramRecentUser)
  {
    if (paramRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.mUser = paramRecentUser;
  }
  
  public RecentUser a()
  {
    return this.mUser;
  }
  
  public String a()
  {
    return this.mUser.troopUin;
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.mUser = paramRecentUser;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public final void b()
  {
    if ((isUnreadMsgNumInTabNum()) && (a()))
    {
      this.mMenuFlag &= 0xFFF0FFFF;
      if (this.mUnreadNum != 0) {
        this.mMenuFlag |= 0x10000;
      }
    }
    else
    {
      return;
    }
    this.mMenuFlag |= 0x20000;
  }
  
  public long getLastDraftTime()
  {
    return this.mUser.lastmsgdrafttime;
  }
  
  public long getLastMsgTime()
  {
    return this.mUser.lastmsgtime;
  }
  
  public int getRecentUserType()
  {
    return this.mUser.getType();
  }
  
  public String getRecentUserUin()
  {
    return this.mUser.uin;
  }
  
  public final boolean isUnreadMsgNumInTabNum()
  {
    return (this.mUnreadFlag == 1) || (this.mUnreadFlag == 4);
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (this.mArgsBundle == null) {
      this.mArgsBundle = new Bundle();
    }
    for (;;)
    {
      this.mMsgExtroInfo = "";
      RecentBaseDataConfig.a().a(paramBaseQQAppInterface, this);
      return;
      this.mArgsBundle.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */