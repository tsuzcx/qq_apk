package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.mp.mobileqq_mp.SubscribeRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import mqq.app.NewIntent;

class StructingMsgItemBuilder$16
  implements PopupMenuDialog.OnClickActionListener
{
  StructingMsgItemBuilder$16(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Activity paramActivity, AbsStructMsg paramAbsStructMsg) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (StructingMsgItemBuilder.c(this.d)) {
      return;
    }
    String str = this.a.getExtInfoFromExtStr("msg_template_id");
    int i = this.a.istroop;
    NewIntent localNewIntent = new NewIntent(this.b, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "PubAccountFollowSvc.subscribe");
    mobileqq_mp.SubscribeRequest localSubscribeRequest = new mobileqq_mp.SubscribeRequest();
    localSubscribeRequest.msg_id.set(this.c.msgId);
    localSubscribeRequest.index.set(paramMenuItem.id);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.a.frienduin);
      l1 = l2;
    }
    catch (Exception paramMenuItem)
    {
      label119:
      break label119;
    }
    localSubscribeRequest.template_id.set(str);
    localSubscribeRequest.puin.set(l1);
    localNewIntent.setObserver(new StructingMsgItemBuilder.16.1(this, str));
    localNewIntent.putExtra("data", localSubscribeRequest.toByteArray());
    this.d.d.startServlet(localNewIntent);
    StructingMsgItemBuilder.c(this.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.16
 * JD-Core Version:    0.7.0.1
 */