package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bjnm;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

class BaseChatPie$43
  implements Runnable
{
  BaseChatPie$43(BaseChatPie paramBaseChatPie, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    if ((!this.this$0.sessionInfo.curFriendUin.equals(this.val$message.frienduin)) && ((this.val$message.senderuin == null) || (!this.val$message.senderuin.equalsIgnoreCase(this.this$0.app.getCurrentAccountUin()))) && (!this.this$0.isOpenFromShare))
    {
      if (this.this$0.mMsgbox == null)
      {
        BaseChatPie.access$1302(this.this$0, new View(this.this$0.mContext));
        BaseChatPie.access$1300(this.this$0).setId(2131371471);
        BaseChatPie.access$1300(this.this$0).setBackgroundColor(this.this$0.mContext.getResources().getColor(2131166448));
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.this$0.mTipsContainer.addView(BaseChatPie.access$1300(this.this$0), (ViewGroup.LayoutParams)localObject);
        this.this$0.mMsgbox = new TextView(this.this$0.mContext);
        this.this$0.mMsgbox.setId(2131371468);
        this.this$0.mMsgbox.setSingleLine();
        this.this$0.mMsgbox.setBackgroundDrawable(this.this$0.mContext.getResources().getDrawable(2130839164));
        this.this$0.mMsgbox.setGravity(17);
        this.this$0.mMsgbox.setTextSize(2, 14.0F);
        this.this$0.mMsgbox.setBackgroundResource(2130839164);
        this.this$0.mMsgbox.setTextColor(this.this$0.mContext.getResources().getColorStateList(2131167088));
        this.this$0.mMsgbox.setPadding((int)(this.this$0.mDensity * 10.0F), this.this$0.mMsgbox.getPaddingTop(), (int)(this.this$0.mDensity * 10.0F), this.this$0.mMsgbox.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.this$0.mContext.getResources().getDimension(2131297076));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131371471);
        this.this$0.mTipsContainer.addView(this.this$0.mMsgbox, (ViewGroup.LayoutParams)localObject);
        this.this$0.mMsgbox.setOnClickListener(this.this$0);
      }
      if ((!ChatActivityUtils.a(this.this$0.sessionInfo.curType)) && (!this.this$0.isOneWayFriend())) {
        break label567;
      }
      BaseChatPie.access$1300(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      this.this$0.mMsgbox.setVisibility(0);
      ThreadManager.postImmediately(new BaseChatPie.43.1(this), null, true);
      this.this$0.mMsgbox.requestLayout();
      this.this$0.mMsgbox.setTag(this.val$intent);
      localObject = this.this$0.mMsgbox.getHandler();
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.this$0.cancelMessageBox);
        ((Handler)localObject).postDelayed(this.this$0.cancelMessageBox, 10000L);
      }
      bjnm.a(this.this$0.app).a(this.val$message, this.this$0.mMsgbox);
      this.this$0.onMsgBoxShow();
      return;
      label567:
      BaseChatPie.access$1300(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.43
 * JD-Core Version:    0.7.0.1
 */