package com.tencent.mobileqq.activity.recent.data;

import ajya;
import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;

public class RecentCallItem
  extends RecentBaseData
{
  public static final int CALL_STATE_CALLIN = 1;
  public static final int CALL_STATE_CALLOUT = 2;
  private static final String TAG = "RecentCallItem";
  protected QCallRecent call;
  
  public int a()
  {
    return this.call.type;
  }
  
  public long a()
  {
    return this.call.lastCallTime;
  }
  
  public String a()
  {
    return this.call.uin;
  }
  
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
    this.mCallingText = ajya.a(2131713159);
    this.call.isVideo = 1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentCallItem
 * JD-Core Version:    0.7.0.1
 */