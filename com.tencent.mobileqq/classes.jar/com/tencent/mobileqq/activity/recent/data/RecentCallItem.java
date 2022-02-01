package com.tencent.mobileqq.activity.recent.data;

import amtj;
import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class RecentCallItem
  extends RecentBaseData
{
  public static final int CALL_STATE_CALLIN = 1;
  public static final int CALL_STATE_CALLOUT = 2;
  private static final String TAG = "RecentCallItem";
  protected QCallRecent call;
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    this.mTitleName = "123123123";
    this.mLastMsg = this.call.lastCallMsg;
    this.mStatus = 0;
    this.mOnlineStatus = 4;
    this.mAuthenIconId = 1;
    this.mShowTime = "0";
    this.mUnreadNum = 0;
    this.mMenuFlag = 12288;
    this.mCallingText = amtj.a(2131712263);
    this.call.isVideo = 1;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    return this.call.lastCallTime;
  }
  
  public int getRecentUserType()
  {
    return this.call.type;
  }
  
  public String getRecentUserUin()
  {
    return this.call.uin;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentCallItem
 * JD-Core Version:    0.7.0.1
 */