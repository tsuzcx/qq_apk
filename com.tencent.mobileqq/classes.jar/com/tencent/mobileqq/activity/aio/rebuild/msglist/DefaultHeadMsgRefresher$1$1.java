package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class DefaultHeadMsgRefresher$1$1
  implements Runnable
{
  DefaultHeadMsgRefresher$1$1(DefaultHeadMsgRefresher.1 param1, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    Scroller localScroller = this.b.a.e().d();
    if (this.b.a.b().isFinishing()) {
      return;
    }
    boolean bool = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(this.b.a);
    if ((this.a != null) && ((this.b.c <= 200) || (bool)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshHeadMessage==>fistseq: ");
        ((StringBuilder)localObject).append(this.b.d);
        ((StringBuilder)localObject).append(", mr.shmsgseq:");
        ((StringBuilder)localObject).append(this.a.shmsgseq);
        QLog.d("DefaultHeadMsgRefresher.troop.special_msg", 2, ((StringBuilder)localObject).toString());
      }
      if ((int)this.b.d >= this.a.shmsgseq + 1L)
      {
        localScroller.a(this.b.d, this.a.shmsgseq, false);
        if (this.b.e == 5) {
          localScroller.a(this.a.uniseq);
        }
        if (bool)
        {
          localScroller.a(0, -1, this.b.f, 6, true);
          return;
        }
        localScroller.a(this.b.e, 0, -1, this.b.f, 6);
        return;
      }
      Object localObject = this.b.a.e().b();
      int i;
      if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeListUiIsGuildListUI(localObject)) {
        i = this.b.a.e().b().b(this.a.uniseq);
      } else {
        i = this.b.a.e().b().a((ChatMessage)this.a);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshHeadMessage==>pos: ");
        ((StringBuilder)localObject).append(i);
        QLog.d("DefaultHeadMsgRefresher.troop.special_msg", 2, ((StringBuilder)localObject).toString());
      }
      if (i != -1) {
        localScroller.a(this.b.e, i, i, null, 6);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DefaultHeadMsgRefresher.1.1
 * JD-Core Version:    0.7.0.1
 */