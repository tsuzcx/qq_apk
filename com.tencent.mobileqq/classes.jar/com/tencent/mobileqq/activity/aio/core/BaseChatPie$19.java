package com.tencent.mobileqq.activity.aio.core;

import ahqs;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseChatPie$19
  implements View.OnClickListener
{
  BaseChatPie$19(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mTipsMgr.a();
    SharedPreferences.Editor localEditor = this.this$0.app.getPreferences().edit();
    localEditor.putInt("funcall_tip_" + this.this$0.sessionInfo.curFriendUin, 4);
    localEditor.commit();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.19
 * JD-Core Version:    0.7.0.1
 */