package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ApolloGameItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;
import uhn;

public class ChatHistoryAdapterForC2C
  extends ChatAdapter1
{
  public int a;
  public Context a;
  public Calendar a;
  uhn a;
  public Calendar b;
  
  public ChatHistoryAdapterForC2C(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Uhn = new uhn(this, null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(List paramList, int paramInt1, Calendar paramCalendar1, Calendar paramCalendar2, int paramInt2, MessageRecord paramMessageRecord)
  {
    if ((paramList == null) || (paramCalendar1 == null)) {
      return -1;
    }
    Object localObject = null;
    int i = 0;
    if (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      if (((localObject == null) || (localChatMessage.time - localObject.time > 180L)) && (MessageUtils.b(localChatMessage.msgtype))) {}
      for (localChatMessage.mNeedTimeStamp = true;; localChatMessage.mNeedTimeStamp = false)
      {
        if (i != paramList.size() - 1) {
          localChatMessage.isFlowMessage = false;
        }
        i += 1;
        localObject = localChatMessage;
        break;
      }
    }
    i = 0;
    int j;
    if (paramInt1 == 2)
    {
      if ((this.b != null) && (this.b.get(1) == paramCalendar1.get(1)) && (this.b.get(2) == paramCalendar1.get(2)) && (this.b.get(5) == paramCalendar1.get(5))) {
        return -1;
      }
      this.b = ((Calendar)paramCalendar1.clone());
      paramInt2 = paramList.size() + 2;
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
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
        i = paramInt2;
        if (paramInt1 >= j) {
          break label663;
        }
        i = paramInt2;
        if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).shmsgseq == paramMessageRecord.shmsgseq)
        {
          if (paramInt1 < j - 1) {}
          for (paramInt2 = paramInt1 + 2;; paramInt2 = paramInt1)
          {
            i = paramInt2;
            if (!QLog.isColorLevel()) {
              break label652;
            }
            QLog.d("ChatHistoryForC2C", 2, "refreshData---> cache id: " + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).getId() + ", searchRecord id: " + paramMessageRecord.getId() + ",msgseq:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msgseq + ",searchRecord: " + paramMessageRecord.msgseq + ",selection:" + paramInt2 + ",cacheRecords size:" + j + ",msg text:" + ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).msg + ",search text:" + paramMessageRecord.msg);
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
            if ((paramInt1 != 5) && (paramInt1 != 6) && (paramInt1 != 1))
            {
              paramInt2 = i;
              if (paramInt1 != 0) {
                break;
              }
            }
            this.b = ((Calendar)paramCalendar1.clone());
            if (paramCalendar2 != null) {}
            for (this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar2.clone());; this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone()))
            {
              this.jdField_a_of_type_JavaUtilList.clear();
              paramInt2 = 0;
              this.jdField_a_of_type_JavaUtilList.addAll(paramList);
              break;
            }
          }
        }
        label652:
        paramInt1 += 1;
        paramInt2 = i;
      }
    }
    label663:
    notifyDataSetChanged();
    return i;
  }
  
  public void b(List paramList)
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
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage, this);
    paramView = localChatItemBuilder.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Uhn);
    if (paramView != null) {
      paramView.setTag(2131361859, localChatMessage);
    }
    if ((paramView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)paramView).a();
    }
    if ((localChatMessage.msgtype == -2009) || (localChatMessage.msgtype == -2016)) {
      ((VideoItemBuilder)localChatItemBuilder).a(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAdapterForC2C", 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      return paramView;
      if (localChatMessage.msgtype == -2039) {
        if ((localChatItemBuilder instanceof ApolloItemBuilder))
        {
          ((ApolloItemBuilder)localChatItemBuilder).a(false);
          paramViewGroup = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
          if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView != null)
          {
            paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
            if ((paramViewGroup != null) && ((paramViewGroup instanceof AnimationDrawable)))
            {
              ((AnimationDrawable)paramViewGroup).stop();
              ((AnimationDrawable)paramViewGroup).selectDrawable(0);
            }
          }
        }
        else if ((localChatItemBuilder instanceof ApolloGameItemBuilder))
        {
          ((ApolloGameItemBuilder)localChatItemBuilder).a(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C
 * JD-Core Version:    0.7.0.1
 */