package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MultiForwardScroller
  extends Scroller
{
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>type:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("|value:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("MultiForwardChatPie", 2, ((StringBuilder)localObject).toString());
    }
    MultiForwardContext localMultiForwardContext = (MultiForwardContext)this.a;
    Object localObject = localMultiForwardContext.a().a();
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (ChatMessage)localIterator.next();
        if ((!MsgProxyUtils.b((MessageRecord)localObject)) && (!MsgProxyUtils.a((MessageRecord)localObject)) && (!(localObject instanceof MessageForSafeGrayTips)) && (((ChatMessage)localObject).shmsgseq == paramLong)) {
          break label154;
        }
      }
    }
    localObject = null;
    label154:
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1)
    {
      if (localObject != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QLog.d("MultiForwardChatPie", 2, new Object[] { "refreshHeadMessage==>", "isFind:", Boolean.valueOf(bool1) });
    }
    localMultiForwardContext.a().b(paramInt3);
    if ((localObject != null) && (!UniteGrayTipMsgUtil.a((MessageRecord)localObject)))
    {
      paramInt2 = localMultiForwardContext.a().a(((MessageRecord)localObject).uniseq);
      if (paramInt2 != -1)
      {
        localMultiForwardContext.a().a(paramInt1, paramInt2, paramInt2, null, 10);
        return;
      }
      if (((MessageRecord)localObject).msgtype == -2006) {
        QQToast.a(this.a.a(), HardCodeUtil.a(2131707038), 0).b(this.a.b());
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiForwardChatPie", 2, new Object[] { "pos is -1, msgtype:", Integer.valueOf(((MessageRecord)localObject).msgtype) });
      }
    }
    else
    {
      QQToast.a(this.a.a(), 2131697699, 0).b(this.a.b());
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        if (localObject != null) {
          bool1 = true;
        }
        QLog.d("MultiForwardChatPie", 2, new Object[] { "foundMsgRecord:", Boolean.valueOf(bool1) });
      }
    }
  }
  
  public void a(MultiForwardContext paramMultiForwardContext)
  {
    this.a = paramMultiForwardContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.MultiForwardScroller
 * JD-Core Version:    0.7.0.1
 */