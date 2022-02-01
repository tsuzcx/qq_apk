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
  protected ChatHistoryBubbleListAdapter.HistoryDeleteOperator a;
  protected ChatHistoryBubbleListAdapter.HistoryItemOnlongClickListener a;
  public final String a;
  protected SessionInfo b;
  protected QQAppInterface b;
  public boolean b;
  public boolean c = false;
  
  public ChatHistoryBubbleListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryItemOnlongClickListener = new ChatHistoryBubbleListAdapter.HistoryItemOnlongClickListener(this, null);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private List<ChatMessage> a(List<MessageRecord> paramList)
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
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (paramInt1 == 0) {
      localObject1 = null;
    } else {
      localObject1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1 - 1);
    }
    long l1 = 0L;
    while (paramInt1 < paramInt2)
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
      boolean bool2 = MessageUtils.b(localChatMessage.msgtype);
      boolean bool1;
      if ((bool2) && ((paramInt1 == 0) || ((localChatMessage.time < this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L) && ((localObject1 == null) || (localChatMessage.time - ((ChatMessage)localObject1).time > 60L))) || ((this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L)))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localChatMessage.mNeedTimeStamp = bool1;
      if (localChatMessage.mNeedTimeStamp)
      {
        long l2 = localChatMessage.time;
        l1 = l2;
        if (localChatMessage.time < this.jdField_b_of_type_Long)
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
          if (((MessageForUniteGrayTip)localChatMessage).tipParam.b == 1) {}
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
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0)).uniseq));
    }
  }
  
  public int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    paramList = a(paramList);
    int i = paramList.size();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
    this.jdField_b_of_type_Boolean = (paramBoolean ^ true);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if ((k > 0) && (j > 200))
    {
      k = Math.max(paramList.size(), 200);
      this.jdField_a_of_type_JavaUtilList.subList(k, j).clear();
      this.c = true;
    }
    a(0, paramList.size());
    return i;
  }
  
  public void a(ChatHistoryBubbleListAdapter.HistoryDeleteOperator paramHistoryDeleteOperator)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryDeleteOperator = paramHistoryDeleteOperator;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
  }
  
  public int b(List<MessageRecord> paramList, boolean paramBoolean)
  {
    paramList = a(paramList);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.c = (paramBoolean ^ true);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if ((i > 0) && (j > 200))
    {
      i = Math.min(j - 200, i);
      this.jdField_a_of_type_JavaUtilList.subList(0, i).clear();
      i = -i;
      this.jdField_b_of_type_Boolean = true;
      a(0, 1);
    }
    else
    {
      i = 0;
    }
    a(this.jdField_a_of_type_JavaUtilList.size() - paramList.size(), this.jdField_a_of_type_JavaUtilList.size());
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(localChatMessage, this);
    if ((localObject instanceof BaseBubbleBuilder)) {
      ((BaseBubbleBuilder)localObject).c = true;
    }
    View localView = ((ChatItemBuilder)localObject).a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryItemOnlongClickListener);
    if (localView != null) {
      localView.setTag(2131364534, localChatMessage);
    }
    if ((localView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)localView).b();
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
        ((IApolloItemBuilder)localObject).a(AIOUtils.a(localView));
      }
    }
    else {
      ((VideoItemBuilder)localObject).a(false);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIOTime getView ");
      localStringBuilder.append(localChatMessage.getClass().getName());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter
 * JD-Core Version:    0.7.0.1
 */