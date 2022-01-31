package com.tencent.mobileqq.activity.chathistory;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wlk;

public class ChatHistoryBubbleListAdapter
  extends ChatAdapter1
{
  public ChatHistoryBubbleListAdapter.HistoryDeleteOperator a;
  public final String a;
  protected wlk a;
  public boolean a;
  public SessionInfo b;
  public QQAppInterface b;
  public boolean b;
  
  public ChatHistoryBubbleListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Wlk = new wlk(this, null);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private List a(List paramList)
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
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject;
    ChatMessage localChatMessage;
    if (paramInt1 == 0)
    {
      localObject = null;
      if (paramInt1 >= paramInt2) {
        return;
      }
      localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
      if (((localObject != null) && (localChatMessage.time - ((ChatMessage)localObject).time <= 180L)) || (!MessageUtils.b(localChatMessage.msgtype))) {
        break label105;
      }
    }
    label105:
    for (localChatMessage.mNeedTimeStamp = true;; localChatMessage.mNeedTimeStamp = false)
    {
      localChatMessage.isFlowMessage = false;
      localChatMessage.isDui = false;
      paramInt1 += 1;
      localObject = localChatMessage;
      break;
      localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt1 - 1);
      break;
    }
  }
  
  public int a(List paramList, boolean paramBoolean)
  {
    paramList = a(paramList);
    int i = paramList.size();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      int j = this.jdField_a_of_type_JavaUtilList.size();
      if ((k > 0) && (j > 200))
      {
        k = Math.max(paramList.size(), 200);
        this.jdField_a_of_type_JavaUtilList.subList(k, j).clear();
        this.jdField_b_of_type_Boolean = true;
      }
      b(0, paramList.size());
      return i;
    }
  }
  
  public void a(ChatHistoryBubbleListAdapter.HistoryDeleteOperator paramHistoryDeleteOperator)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryDeleteOperator = paramHistoryDeleteOperator;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
  }
  
  public int b(List paramList, boolean paramBoolean)
  {
    int j = 0;
    paramList = a(paramList);
    int k = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      int m = this.jdField_a_of_type_JavaUtilList.size();
      int i = j;
      if (k > 0)
      {
        i = j;
        if (m > 200)
        {
          i = Math.min(m - 200, k);
          this.jdField_a_of_type_JavaUtilList.subList(0, i).clear();
          i = -i;
          this.jdField_a_of_type_Boolean = true;
          b(0, 1);
        }
      }
      b(this.jdField_a_of_type_JavaUtilList.size() - paramList.size(), this.jdField_a_of_type_JavaUtilList.size());
      return i;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage, this);
    paramView = localChatItemBuilder.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Wlk);
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
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      return paramView;
      if ((localChatMessage.msgtype == -2039) && ((localChatItemBuilder instanceof ApolloItemBuilder)))
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter
 * JD-Core Version:    0.7.0.1
 */