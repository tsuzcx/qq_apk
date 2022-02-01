package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

class ChatHistoryStructMsgView$2
  implements Runnable
{
  ChatHistoryStructMsgView$2(ChatHistoryStructMsgView paramChatHistoryStructMsgView, boolean paramBoolean) {}
  
  public void run()
  {
    int i;
    int j;
    if (this.a)
    {
      localObject1 = this.this$0.b.getMessageFacade();
      localObject2 = this.this$0.i;
      i = this.this$0.j;
      j = ChatHistoryStructMsgView.b();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, new int[] { -2011 }, j);
    }
    else
    {
      long l1;
      long l2;
      int k;
      if (UinTypeUtil.h(this.this$0.j))
      {
        localObject1 = this.this$0;
        ((ChatHistoryStructMsgView)localObject1).o -= 1L;
        localObject1 = this.this$0.b.getMessageFacade();
        localObject2 = this.this$0.i;
        i = this.this$0.j;
        l1 = this.this$0.n;
        j = this.this$0.q;
        l2 = this.this$0.o;
        k = ChatHistoryStructMsgView.b();
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { -2011 }, k);
      }
      else
      {
        localObject1 = this.this$0.b.getMessageFacade();
        localObject2 = this.this$0.i;
        i = this.this$0.j;
        l1 = this.this$0.n;
        j = this.this$0.q;
        l2 = this.this$0.p;
        k = ChatHistoryStructMsgView.b();
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { -2011 }, k);
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() < ChatHistoryStructMsgView.b())) {
      this.this$0.m = true;
    }
    Object localObject2 = new LinkedHashMap();
    Object localObject3;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      i = ((List)localObject1).size() - 1;
      while (i >= 0)
      {
        localObject3 = (MessageRecord)((List)localObject1).get(i);
        if (ChatHistoryStructAdapter.a((MessageRecord)localObject3))
        {
          if (((MessageRecord)localObject3).shmsgseq < this.this$0.o) {
            this.this$0.o = ((MessageRecord)localObject3).shmsgseq;
          }
          if (((MessageRecord)localObject3).versionCode < this.this$0.q) {
            this.this$0.q = ((MessageRecord)localObject3).versionCode;
          }
          if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.this$0.n)) {
            this.this$0.n = ((MessageRecord)localObject3).getId();
          }
          if (((MessageRecord)localObject3).time < this.this$0.p) {
            this.this$0.p = ((MessageRecord)localObject3).time;
          }
          if ((localObject3 instanceof MessageForStructing))
          {
            localObject4 = (MessageForStructing)localObject3;
            if ((((MessageForStructing)localObject4).structingMsg != null) && ((((MessageForStructing)localObject4).structingMsg instanceof AbsShareMsg)))
            {
              localObject4 = (AbsShareMsg)((MessageForStructing)localObject4).structingMsg;
              if ((((MessageRecord)localObject3).time >= 1548460800L) && (FMConstants.a(((AbsShareMsg)localObject4).mMsgUrl))) {
                break label598;
              }
            }
          }
          Object localObject4 = QfileTimeUtils.a(((MessageRecord)localObject3).time * 1000L);
          if (!((LinkedHashMap)localObject2).containsKey(localObject4)) {
            ((LinkedHashMap)localObject2).put(localObject4, new ArrayList());
          }
          ((List)((LinkedHashMap)localObject2).get(localObject4)).add(localObject3);
        }
        label598:
        i -= 1;
      }
    }
    if (this.this$0.l == null) {
      this.this$0.l = new ArrayList();
    }
    Object localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (!this.this$0.l.contains(localObject3)) {
        this.this$0.l.add(localObject3);
      }
      this.this$0.l.addAll((Collection)((LinkedHashMap)localObject2).get(localObject3));
    }
    this.this$0.s.sendEmptyMessage(1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initEntity, size: ");
      ((StringBuilder)localObject1).append(this.this$0.l.size());
      QLog.d("ChatHistoryStruct", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryStructMsgView.2
 * JD-Core Version:    0.7.0.1
 */