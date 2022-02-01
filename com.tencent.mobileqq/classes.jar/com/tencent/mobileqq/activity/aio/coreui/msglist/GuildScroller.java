package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GuildGuestReplyHeadMsgRefresh;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateBar;
import com.tencent.mobileqq.guild.navigatebar.GuildAioTips;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;

public class GuildScroller
  extends Scroller
{
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    a(paramInt1, paramLong, paramInt2, 2, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>type = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", value = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", unreadMsgCount = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", flushType = ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("GuildScroller.troop.special_msg", 2, ((StringBuilder)localObject).toString());
    }
    long l = n();
    Object localObject = new GuildScroller.1(this);
    this.d.c(paramInt3);
    a(paramInt1, paramLong, paramInt2, paramInt4, l, (Runnable)localObject);
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, Runnable paramRunnable)
  {
    int i;
    if (this.a.c().b() == 9) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>firstSeq:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("|value:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("|type:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("GuildScroller.troop.special_msg", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0)
    {
      if (((this.a instanceof GuildChatContext)) && (((GuildChatContext)this.a).Y()))
      {
        QLog.e("GuildScroller", 1, "isGuest = true");
        new GuildGuestReplyHeadMsgRefresh().a(this.a, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramRunnable);
        return;
      }
      localObject = this.a.e().a().a(paramInt1);
      if (localObject != null)
      {
        ((IHeadMsgRefresher)localObject).a(this.a, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramRunnable);
        return;
      }
      paramRunnable = new StringBuilder();
      paramRunnable.append("no refresher found for type: ");
      paramRunnable.append(paramInt1);
      QLog.e("GuildScroller", 1, paramRunnable.toString());
    }
  }
  
  public void a(Observer paramObserver, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1)
  {
    if (this.e == null) {
      this.e = new GuildAioTips(this.a);
    }
    this.d.a(this.e);
    super.a(paramObserver, paramRelativeLayout, paramChatAdapter1);
  }
  
  public GuildAioMsgNavigateBar c()
  {
    return (GuildAioMsgNavigateBar)this.e.k();
  }
  
  public GuildAioTips d()
  {
    return (GuildAioTips)this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.GuildScroller
 * JD-Core Version:    0.7.0.1
 */