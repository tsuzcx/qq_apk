package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import java.util.Locale;

public class RecentItemNoticeData
  extends AbsRecentUserBusinessBaseData
{
  public String from;
  public Intent intent;
  public long time;
  public int type;
  public long uin;
  public String url;
  public String wording;
  
  public RecentItemNoticeData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(int paramInt, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2)
  {
    this.type = paramInt;
    this.uin = paramLong1;
    this.wording = paramString1;
    this.url = paramString2;
    this.from = paramString3;
    this.time = paramLong2;
    this.mDisplayTime = paramLong2;
    this.mTitleName = String.format(Locale.getDefault(), "%s:%s", new Object[] { paramString3, paramString1 });
    this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
  }
  
  public void a(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.d)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        break label102;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      label102:
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
  
  public boolean a(int paramInt, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2)
  {
    if (this.type != paramInt) {}
    while ((this.uin != paramLong1) || (this.time != paramLong2) || (!Utils.a(this.wording, paramString1)) || (!Utils.a(this.url, paramString2)) || (!Utils.a(this.from, paramString3))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData
 * JD-Core Version:    0.7.0.1
 */