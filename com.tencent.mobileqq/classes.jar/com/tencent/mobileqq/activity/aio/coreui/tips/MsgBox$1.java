package com.tencent.mobileqq.activity.aio.coreui.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class MsgBox$1
  implements Runnable
{
  MsgBox$1(MsgBox paramMsgBox, AIOContext paramAIOContext, Message paramMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if ((!this.a.O().b.equals(this.b.frienduin)) && ((this.b.senderuin == null) || (!this.b.senderuin.equalsIgnoreCase(this.c.getCurrentAccountUin()))) && (!this.a.B()))
    {
      if (MsgBox.a(this.this$0) == null)
      {
        MsgBox.a(this.this$0, new View(this.d));
        MsgBox.b(this.this$0).setId(2131438958);
        MsgBox.b(this.this$0).setBackgroundColor(this.d.getResources().getColor(2131167318));
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.this$0.a.addView(MsgBox.b(this.this$0), (ViewGroup.LayoutParams)localObject);
        MsgBox.a(this.this$0, new TextView(this.d));
        MsgBox.a(this.this$0).setId(2131438955);
        MsgBox.a(this.this$0).setSingleLine();
        MsgBox.a(this.this$0).setBackgroundDrawable(this.d.getResources().getDrawable(2130839262));
        MsgBox.a(this.this$0).setGravity(17);
        MsgBox.a(this.this$0).setTextSize(2, 14.0F);
        MsgBox.a(this.this$0).setBackgroundResource(2130839262);
        MsgBox.a(this.this$0).setTextColor(this.d.getResources().getColorStateList(2131168114));
        float f1 = this.c.getApplication().getResources().getDisplayMetrics().density;
        localObject = MsgBox.a(this.this$0);
        int i = (int)(f1 * 10.0F);
        ((TextView)localObject).setPadding(i, MsgBox.a(this.this$0).getPaddingTop(), i, MsgBox.a(this.this$0).getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.d.getResources().getDimension(2131297461));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131438958);
        this.this$0.a.addView(MsgBox.a(this.this$0), (ViewGroup.LayoutParams)localObject);
        MsgBox.a(this.this$0).setOnClickListener(this.this$0);
      }
      if ((!ChatActivityUtils.a(this.a.O().a)) && (!this.a.A())) {
        MsgBox.b(this.this$0).setVisibility(8);
      } else {
        MsgBox.b(this.this$0).setVisibility(0);
      }
      MsgBox.a(this.this$0).setVisibility(0);
      ThreadManager.postImmediately(new MsgBox.1.1(this), null, true);
      MsgBox.a(this.this$0).requestLayout();
      MsgBox.a(this.this$0).setTag(this.e);
      Object localObject = MsgBox.a(this.this$0).getHandler();
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.this$0.b);
        ((Handler)localObject).postDelayed(this.this$0.b, 10000L);
      }
      localObject = this.a.z().a().b().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IMsgTipsListener)((Iterator)localObject).next()).a(this.a, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox.1
 * JD-Core Version:    0.7.0.1
 */