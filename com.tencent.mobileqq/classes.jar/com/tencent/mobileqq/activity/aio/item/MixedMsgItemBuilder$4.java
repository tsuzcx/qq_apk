package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MixedMsgItemBuilder$4
  implements ActionSheet.OnButtonClickListener
{
  MixedMsgItemBuilder$4(MixedMsgItemBuilder paramMixedMsgItemBuilder, MessageForMixedMsg paramMessageForMixedMsg, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      long l = SystemClock.uptimeMillis();
      if (l - this.c.a < 500L) {
        return;
      }
      paramView = this.c;
      paramView.a = l;
      paramView = (MixedMsgManager)paramView.d.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      this.c.d.getMessageFacade().h(this.a.frienduin, this.a.istroop, this.a.uniseq);
      paramView.a(this.c.f, this.a, true);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */