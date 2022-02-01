package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.TimestampReporter;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class MiniChatAdapter
  extends ChatAdapter1
{
  public final String a;
  protected List<ChatMessage> b;
  
  public MiniChatAdapter(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.jdField_a_of_type_JavaLangString = "MiniPie.MiniChatAdapter";
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory = new MiniChatItemFactory(paramContext, paramQQAppInterface, paramSessionInfo, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener = null;
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l1 = 0L;
    paramCharSequence = null;
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(paramInt);
      boolean bool2 = MessageUtils.b(localChatMessage.msgtype);
      boolean bool1;
      if ((bool2) && ((paramInt == 0) || ((localChatMessage.time < this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.jdField_b_of_type_Long) && (localChatMessage.time - l1 > 300L) && ((paramCharSequence == null) || (localChatMessage.time - paramCharSequence.time > 60L))) || ((this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L)))) {
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
      Object localObject = paramCharSequence;
      if (bool2) {
        if ((localChatMessage instanceof MessageForUniteGrayTip))
        {
          localObject = paramCharSequence;
          if (((MessageForUniteGrayTip)localChatMessage).tipParam.b == 1) {}
        }
        else
        {
          localObject = localChatMessage;
        }
      }
      if (paramInt != paramList.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      paramInt += 1;
      paramCharSequence = (CharSequence)localObject;
    }
    if (paramList.size() > 0) {
      this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Long.valueOf(((ChatMessage)paramList.get(0)).uniseq));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("list addr = ");
    paramCharSequence.append(paramList.hashCode());
    paramCharSequence.append(",size = ");
    paramCharSequence.append(paramList.size());
    QLog.d("MiniPie.MiniChatAdapter", 1, paramCharSequence.toString());
    super.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    ((MiniChatItemFactory)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory).a(paramBoolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b(List<ChatMessage> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void c()
  {
    super.c();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = paramView;
    }
    else
    {
      localObject1 = this.jdField_b_of_type_JavaUtilList;
      if ((localObject1 != null) && (((List)localObject1).size() > paramInt)) {
        localObject1 = (ChatMessage)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      } else {
        localObject1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
      localObject2 = AIOUtils.a();
      ((StringBuilder)localObject2).append("AIO_ChatAdapter_getView");
      ((StringBuilder)localObject2).append(" | ");
      ((StringBuilder)localObject2).append(localObject1.getClass().getName());
      StartupTracker.a(null, ((StringBuilder)localObject2).toString());
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a((ChatMessage)localObject1, this);
      if (paramInt != 0)
      {
        localObject2 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
        if ((localObject2 != null) && ((localObject2 instanceof MessageForTroopUnreadTips))) {
          ((ChatMessage)localObject1).mNeedTimeStamp = true;
        }
      }
      localObject2 = ((ChatItemBuilder)localObject3).a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), (ChatMessage)localObject1, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1$BubbleOnlongClickListener);
      if (localObject2 != null)
      {
        ((View)localObject2).setTag(2131364534, localObject1);
        if (((localObject3 instanceof AbstractChatItemBuilder)) && ((localObject2 instanceof IChatShieldClick))) {
          localObject3 = (IChatShieldClick)localObject2;
        }
      }
      localObject3 = AIOUtils.a();
      ((StringBuilder)localObject3).append("AIO_ChatAdapter_getView");
      ((StringBuilder)localObject3).append(" | ");
      ((StringBuilder)localObject3).append(localObject1.getClass().getName());
      StartupTracker.a(((StringBuilder)localObject3).toString(), null);
      localObject1 = localObject2;
    }
    if ((localObject1 != null) && ((localObject1 instanceof IChatShieldClick)))
    {
      localObject2 = (IChatShieldClick)localObject1;
      ((IChatShieldClick)localObject2).setIsShieldTouchForItem(true);
      ((IChatShieldClick)localObject2).setFrom(((MiniChatItemFactory)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory).a);
      if ((localObject1 instanceof BaseChatItemLayout)) {
        ((BaseChatItemLayout)localObject1).d();
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("list.addr = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatAdapter
 * JD-Core Version:    0.7.0.1
 */