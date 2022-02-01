package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  protected static final String DES_DEFAULT_HAVE_MSG = "%s,%s,%d条未读,%s";
  protected static final String DES_DEFAULT_NO_MSG = "%s,%s,%s";
  @ParcelAnnotation.NotParcel
  protected Bundle mArgsBundle;
  @ParcelAnnotation.NotParcel
  public BaseRecentUser mUser;
  
  public RecentUserBaseData(BaseRecentUser paramBaseRecentUser)
  {
    if (paramBaseRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.mUser = paramBaseRecentUser;
  }
  
  public long getLastDraftTime()
  {
    return this.mUser.lastmsgdrafttime;
  }
  
  public long getLastMsgTime()
  {
    return this.mUser.lastmsgtime;
  }
  
  public int getMenuFlag()
  {
    return this.mMenuFlag;
  }
  
  public BaseRecentUser getRecentUser()
  {
    return this.mUser;
  }
  
  public int getRecentUserMsgType()
  {
    return this.mUser.msgType;
  }
  
  public String getRecentUserTroopUin()
  {
    return this.mUser.troopUin;
  }
  
  public int getRecentUserType()
  {
    return this.mUser.getType();
  }
  
  public String getRecentUserUin()
  {
    return this.mUser.uin;
  }
  
  protected boolean isEnableUnreadState()
  {
    return false;
  }
  
  public final boolean isUnreadMsgNumInTabNum()
  {
    return (this.mUnreadFlag == 1) || (this.mUnreadFlag == 4);
  }
  
  public void setRecentUser(BaseRecentUser paramBaseRecentUser)
  {
    this.mUser = paramBaseRecentUser;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if (this.mArgsBundle == null) {
      this.mArgsBundle = new Bundle();
    }
    for (;;)
    {
      this.mMsgExtroInfo = "";
      paramIMCoreAppRuntime.getRecentConfig().getRecentMenuFlagDispatch().processor(paramIMCoreAppRuntime, this);
      return;
      this.mArgsBundle.clear();
    }
  }
  
  public final void updateMsgUnreadStateMenu()
  {
    if ((isUnreadMsgNumInTabNum()) && (isEnableUnreadState()))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */