package com.tencent.mobileqq.activity.aio.coreui.msglist;

import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FriendScroller
  extends Scroller
{
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    a(paramInt, paramLong1, paramLong2, 0, 0);
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==> aio cache is find! origUid");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", time");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("FriendScroller", 2, ((StringBuilder)localObject).toString());
    }
    QQAppInterface localQQAppInterface = this.a.a();
    Object localObject = (SessionInfo)this.a.O();
    List localList = localQQAppInterface.getMessageFacade().c(((SessionInfo)localObject).b, ((SessionInfo)localObject).a, paramLong2, paramLong1);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        localObject = (MessageRecord)localList.get(i);
        if ((!MsgProxyUtils.b((MessageRecord)localObject)) && (!(localObject instanceof MessageForSafeGrayTips))) {
          break label179;
        }
        i += 1;
      }
      localObject = null;
      label179:
      if ((localObject != null) && (!UniteGrayTipMsgUtil.b((MessageRecord)localObject)))
      {
        i = this.c.a(((MessageRecord)localObject).uniseq);
        if (i != -1)
        {
          a(paramInt1, i, i, null, 10);
          return;
        }
        if (((MessageRecord)localObject).msgtype == -2006) {
          QQToast.makeText(this.a.b(), HardCodeUtil.a(2131902856), 0).show(this.a.v());
        }
        if (paramInt2 == 1) {
          ReplyTextItemBuilder.a(localQQAppInterface, null, "0X800A36B");
        }
      }
      else
      {
        QQToast.makeText(this.a.b(), 2131895472, 0).show(this.a.v());
        if (paramInt2 == 1) {
          ReplyTextItemBuilder.a(localQQAppInterface, null, "0X800A36B");
        }
      }
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>type:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("|origUid:");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("FriendScroller", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new FriendScroller.1(this);
    boolean bool = a(paramLong1, paramLong2);
    d(paramInt2);
    if (!bool)
    {
      a(paramInt1, paramLong1, paramLong2, paramInt3, (Runnable)localObject);
      return;
    }
    a(paramInt1, paramLong1, paramLong2, paramInt3);
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, Runnable paramRunnable)
  {
    Object localObject = this.a.a();
    SessionInfo localSessionInfo = (SessionInfo)this.a.O();
    if (!NetworkUtil.isNetworkAvailable(this.a.b()))
    {
      QQToast.makeText(this.a.b(), 2131894999, 0).show(this.a.v());
      if (paramInt2 == 1) {
        ReplyTextItemBuilder.a((QQAppInterface)localObject, null, "0X800A36B");
      }
    }
    else
    {
      if (ReplyMsgUtils.a((QQAppInterface)localObject, localSessionInfo.b, localSessionInfo.a, paramLong2, paramLong1) != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshHeadMessage==> db is find! origUid");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append(", time");
          ((StringBuilder)localObject).append(paramLong2);
          QLog.d("FriendScroller", 2, ((StringBuilder)localObject).toString());
        }
        ((FriendListUI)this.a.e().b()).a(paramLong1, paramLong2, false);
        a(paramInt1, 0, -1, paramRunnable, 10);
        return;
      }
      QQToast.makeText(this.a.b(), 2131895472, 0).show(this.a.v());
      if (paramInt2 == 1) {
        ReplyTextItemBuilder.a((QQAppInterface)localObject, null, "0X800A36B");
      }
    }
  }
  
  protected boolean a(long paramLong1, long paramLong2)
  {
    Object localObject = this.c.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if ((!MsgProxyUtils.b(localChatMessage)) && (localChatMessage.msgUid == paramLong1) && (localChatMessage.time == paramLong2))
        {
          bool = true;
          break label82;
        }
      }
    }
    boolean bool = false;
    label82:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>isFind:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("FriendScroller", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.FriendScroller
 * JD-Core Version:    0.7.0.1
 */