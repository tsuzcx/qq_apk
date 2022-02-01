package com.tencent.mobileqq.activity.chathistory;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.TimestampReporter;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.LocationShareItemBuilder;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.apollo.aio.item.IApolloItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryBubbleListAdapter
  extends ChatAdapter1
{
  public final String r = getClass().getSimpleName();
  public boolean s = false;
  public boolean t = false;
  protected QQAppInterface u;
  protected ChatHistoryBubbleListAdapter.HistoryItemOnlongClickListener v;
  protected ChatHistoryBubbleListAdapter.HistoryDeleteOperator w;
  protected SessionInfo x;
  
  public ChatHistoryBubbleListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.u = paramQQAppInterface;
    this.v = new ChatHistoryBubbleListAdapter.HistoryItemOnlongClickListener(this, null);
    this.x = paramSessionInfo;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (paramInt1 == 0) {
      localObject1 = null;
    } else {
      localObject1 = (ChatMessage)this.a.get(paramInt1 - 1);
    }
    long l1 = 0L;
    while (paramInt1 < paramInt2)
    {
      ChatMessage localChatMessage = (ChatMessage)this.a.get(paramInt1);
      boolean bool2 = MessageUtils.c(localChatMessage.msgtype);
      boolean bool1;
      if ((bool2) && ((paramInt1 == 0) || ((localChatMessage.time < this.m) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.m) && (localChatMessage.time - l1 > 300L) && ((localObject1 == null) || (localChatMessage.time - ((ChatMessage)localObject1).time > 60L))) || ((this.n.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L)))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localChatMessage.mNeedTimeStamp = bool1;
      if (localChatMessage.mNeedTimeStamp)
      {
        long l2 = localChatMessage.time;
        l1 = l2;
        if (localChatMessage.time < this.m)
        {
          TimestampReporter.a(localChatMessage);
          l1 = l2;
        }
      }
      Object localObject2 = localObject1;
      if (bool2) {
        if ((localChatMessage instanceof MessageForUniteGrayTip))
        {
          localObject2 = localObject1;
          if (((MessageForUniteGrayTip)localChatMessage).tipParam.i == 1) {}
        }
        else
        {
          localObject2 = localChatMessage;
        }
      }
      localChatMessage.isFlowMessage = false;
      localChatMessage.isDui = false;
      paramInt1 += 1;
      localObject1 = localObject2;
    }
    if (this.a.size() > 0) {
      this.n.add(Long.valueOf(((ChatMessage)this.a.get(0)).uniseq));
    }
  }
  
  private List<ChatMessage> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  public int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    paramList = b(paramList);
    int i = paramList.size();
    int k = this.a.size();
    this.a.addAll(0, paramList);
    this.s = (paramBoolean ^ true);
    int j = this.a.size();
    if ((k > 0) && (j > 200))
    {
      k = Math.max(paramList.size(), 200);
      this.a.subList(k, j).clear();
      this.t = true;
    }
    a(0, paramList.size());
    return i;
  }
  
  public void a(ChatHistoryBubbleListAdapter.HistoryDeleteOperator paramHistoryDeleteOperator)
  {
    this.w = paramHistoryDeleteOperator;
  }
  
  public int b(List<MessageRecord> paramList, boolean paramBoolean)
  {
    paramList = b(paramList);
    int i = this.a.size();
    this.a.addAll(paramList);
    this.t = (paramBoolean ^ true);
    int j = this.a.size();
    if ((i > 0) && (j > 200))
    {
      i = Math.min(j - 200, i);
      this.a.subList(0, i).clear();
      i = -i;
      this.s = true;
      a(0, 1);
    }
    else
    {
      i = 0;
    }
    a(this.a.size() - paramList.size(), this.a.size());
    return i;
  }
  
  public boolean c(ChatMessage paramChatMessage)
  {
    return this.a.remove(paramChatMessage);
  }
  
  protected boolean g()
  {
    return false;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.a.get(paramInt);
    Object localObject = this.c.a(localChatMessage, this);
    if ((localObject instanceof BaseBubbleBuilder)) {
      ((BaseBubbleBuilder)localObject).p = true;
    }
    View localView = ((ChatItemBuilder)localObject).a(paramInt, this.a.size(), localChatMessage, paramView, paramViewGroup, this.v);
    if (localView != null) {
      localView.setTag(2131430591, localChatMessage);
    }
    if ((localView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)localView).f();
    }
    if ((localChatMessage.msgtype != -2009) && (localChatMessage.msgtype != -2016))
    {
      if (localChatMessage.msgtype == -2076)
      {
        if ((localObject instanceof LocationShareItemBuilder)) {
          ((LocationShareItemBuilder)localObject).a(false);
        }
      }
      else if ((localChatMessage.msgtype == -2039) && ((localObject instanceof IApolloItemBuilder)))
      {
        localObject = (IApolloItemBuilder)localObject;
        ((IApolloItemBuilder)localObject).a(false);
        ((IApolloItemBuilder)localObject).a(AIOUtils.b(localView));
      }
    }
    else {
      ((VideoItemBuilder)localObject).a(false);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.r;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIOTime getView ");
      localStringBuilder.append(localChatMessage.getClass().getName());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter
 * JD-Core Version:    0.7.0.1
 */