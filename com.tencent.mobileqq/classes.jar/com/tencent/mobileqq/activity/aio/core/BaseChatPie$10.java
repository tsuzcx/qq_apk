package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class BaseChatPie$10
  implements Runnable
{
  BaseChatPie$10(BaseChatPie paramBaseChatPie, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (ChatActivityUtils.a(this.this$0.app, this.this$0.sessionInfo.curType, this.val$uin, this.this$0.sessionInfo.phoneNum)) {
      this.this$0.mActivity.runOnUiThread(new BaseChatPie.10.1(this));
    }
    while (this.val$isSingleWayFriend) {
      return;
    }
    this.this$0.mActivity.runOnUiThread(new BaseChatPie.10.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.10
 * JD-Core Version:    0.7.0.1
 */