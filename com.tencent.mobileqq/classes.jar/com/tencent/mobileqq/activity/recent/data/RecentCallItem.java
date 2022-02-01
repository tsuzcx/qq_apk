package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;

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
    this.mCallingText = HardCodeUtil.a(2131713106);
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
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentCallItem
 * JD-Core Version:    0.7.0.1
 */