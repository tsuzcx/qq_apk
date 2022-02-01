package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.LocationShareItemBuilder;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.apollo.api.aio.item.IApolloGameItemBuilder;
import com.tencent.mobileqq.apollo.api.aio.item.IApolloItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.List;

public class ChatHistoryAdapterForC2C
  extends ChatAdapter1
{
  public int a;
  private ChatHistoryAdapterForC2C.ActionListener jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C$ActionListener;
  private ChatHistoryAdapterForC2C.HistoryItemOnlongClickListener jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C$HistoryItemOnlongClickListener = new ChatHistoryAdapterForC2C.HistoryItemOnlongClickListener(this, null);
  public Calendar a;
  Context b;
  public Calendar b;
  
  public ChatHistoryAdapterForC2C(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie, ChatHistoryAdapterForC2C.ActionListener paramActionListener)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C$ActionListener = paramActionListener;
  }
  
  private void e()
  {
    long l1 = 0L;
    int i = 0;
    Object localObject = null;
    ChatMessage localChatMessage;
    boolean bool1;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      boolean bool2 = MessageUtils.b(localChatMessage.msgtype);
      if ((bool2) && ((i == 0) || ((localChatMessage.time < this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L) && ((localObject == null) || (localChatMessage.time - localObject.time > 60L))) || ((this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L))))
      {
        bool1 = true;
        label170:
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
        if ((!bool2) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.b == 1))) {
          break label283;
        }
        localObject = localChatMessage;
      }
    }
    label283:
    for (;;)
    {
      if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      i += 1;
      break;
      bool1 = false;
      break label170;
      return;
    }
  }
  
  public int a(List<ChatMessage> paramList, int paramInt1, Calendar paramCalendar1, Calendar paramCalendar2, int paramInt2, MessageRecord paramMessageRecord)
  {
    if ((paramList == null) || (paramCalendar1 == null)) {
      return -1;
    }
    int i;
    int j;
    if (paramInt1 == 2)
    {
      if ((this.jdField_b_of_type_JavaUtilCalendar != null) && (this.jdField_b_of_type_JavaUtilCalendar.get(1) == paramCalendar1.get(1)) && (this.jdField_b_of_type_JavaUtilCalendar.get(2) == paramCalendar1.get(2)) && (this.jdField_b_of_type_JavaUtilCalendar.get(5) == paramCalendar1.get(5))) {
        return -1;
      }
      this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
      paramInt2 = paramList.size() + 2;
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
      e();
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0)).uniseq));
      }
      i = paramInt2;
      if (paramInt1 == 6)
      {
        i = paramInt2;
        if (paramMessageRecord != null)
        {
          j = this.jdField_a_of_type_JavaUtilList.size();
          paramInt1 = 0;
        }
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt1 >= j) {
          break label584;
        }
        i = paramInt2;
        if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).shmsgseq == paramMessageRecord.shmsgseq)
        {
          if (paramInt1 < j - 1) {}
          for (paramInt2 = paramInt1 + 2;; paramInt2 = paramInt1)
          {
            i = paramInt2;
            if (!QLog.isColorLevel()) {
              break label573;
            }
            QLog.d("ChatHistoryC2CAllFragment", 2, "refreshData---> cache id: " + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).getId() + ", searchRecord id: " + paramMessageRecord.getId() + ",msgseq:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msgseq + ",searchRecord: " + paramMessageRecord.msgseq + ",selection:" + paramInt2 + ",cacheRecords size:" + j + ",msg text:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msg + ",search text:" + paramMessageRecord.msg);
            notifyDataSetChanged();
            return paramInt2;
            if (paramInt1 == 3)
            {
              if ((this.jdField_a_of_type_JavaUtilCalendar != null) && (this.jdField_a_of_type_JavaUtilCalendar.get(1) == paramCalendar1.get(1)) && (this.jdField_a_of_type_JavaUtilCalendar.get(2) == paramCalendar1.get(2)) && (this.jdField_a_of_type_JavaUtilCalendar.get(5) == paramCalendar1.get(5))) {
                return -1;
              }
              this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
              this.jdField_a_of_type_JavaUtilList.addAll(paramList);
              break;
            }
            if ((paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 1) || (paramInt1 == 0))
            {
              this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
              if (paramCalendar2 == null) {
                break label553;
              }
            }
            label553:
            for (this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar2.clone());; this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone()))
            {
              this.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_JavaUtilList.addAll(paramList);
              paramInt2 = 0;
              break;
            }
          }
        }
        label573:
        paramInt1 += 1;
        paramInt2 = i;
      }
      label584:
      i = paramInt2;
    }
    notifyDataSetChanged();
    return i;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if (paramList == null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.removeAll(paramList);
      paramList.clear();
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(localChatMessage, this);
    View localView = ((ChatItemBuilder)localObject).a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C$HistoryItemOnlongClickListener);
    if (localView != null) {
      localView.setTag(2131364647, localChatMessage);
    }
    if ((localView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)localView).b();
    }
    if ((localChatMessage.msgtype == -2009) || (localChatMessage.msgtype == -2016)) {
      ((VideoItemBuilder)localObject).a(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAdapterForC2C", 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (localChatMessage.msgtype == -2076)
      {
        if ((localObject instanceof LocationShareItemBuilder)) {
          ((LocationShareItemBuilder)localObject).a(false);
        }
      }
      else if (localChatMessage.msgtype == -2039) {
        if ((localObject instanceof IApolloItemBuilder))
        {
          localObject = (IApolloItemBuilder)localObject;
          ((IApolloItemBuilder)localObject).a(false);
          ((IApolloItemBuilder)localObject).a(AIOUtils.a(localView));
        }
        else if ((localObject instanceof IApolloGameItemBuilder))
        {
          ((IApolloGameItemBuilder)localObject).a(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C
 * JD-Core Version:    0.7.0.1
 */