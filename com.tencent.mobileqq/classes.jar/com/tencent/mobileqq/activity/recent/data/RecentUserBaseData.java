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
    if (paramRecentUser != null)
    {
      this.mUser = paramRecentUser;
      return;
    }
    throw new NullPointerException("RecentUser is null");
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
      if (this.mUnreadNum != 0)
      {
        this.mMenuFlag |= 0x10000;
        return;
      }
      this.mMenuFlag |= 0x20000;
    }
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
    int i = this.mUnreadFlag;
    boolean bool = true;
    if (i != 1)
    {
      if (this.mUnreadFlag == 4) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    paramContext = this.mArgsBundle;
    if (paramContext == null) {
      this.mArgsBundle = new Bundle();
    } else {
      paramContext.clear();
    }
    this.mMsgExtroInfo = "";
    RecentBaseDataConfig.a().a(paramBaseQQAppInterface, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */