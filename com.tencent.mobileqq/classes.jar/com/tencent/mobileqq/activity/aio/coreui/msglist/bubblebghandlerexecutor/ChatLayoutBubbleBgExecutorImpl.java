package com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.ConfessMsgBubbleBgExecutor;
import com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.GameMsgBubbleBgExecutor;
import com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.QimMsgBubbleBgExecutor;
import com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.SimpleUIMsgBubbleBgExecutor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatLayoutBubbleBgExecutorImpl
  extends ChatLayoutBubbleBgExecutor
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  private static int h;
  private ChatLayoutBubbleBgExecutor jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor;
  private List<ChatLayoutBubbleBgExecutor> jdField_a_of_type_JavaUtilList;
  private ChatLayoutBubbleBgExecutor b;
  private ChatLayoutBubbleBgExecutor c;
  
  static
  {
    int i = h;
    h = i + 1;
    jdField_a_of_type_Int = i;
    i = h;
    h = i + 1;
    jdField_b_of_type_Int = i;
    i = h;
    h = i + 1;
    jdField_c_of_type_Int = i;
    i = h;
    h = i + 1;
    d = i;
    i = h;
    h = i + 1;
    e = i;
    i = h;
    h = i + 1;
    f = i;
    i = h;
    h = i + 1;
    g = i;
  }
  
  public ChatLayoutBubbleBgExecutorImpl(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  private ChatLayoutBubbleBgExecutor a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor == null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor = new DefaultMsgBubbleBgExecutor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor;
  }
  
  private void a(int paramInt, ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new SimpleUIMsgBubbleBgExecutor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilList.add(new ConfessMsgBubbleBgExecutor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilList.add(new QimMsgBubbleBgExecutor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_JavaUtilList.add(new GameMsgBubbleBgExecutor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor = null;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor = a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChatLayoutBubbleBgExecutor localChatLayoutBubbleBgExecutor = (ChatLayoutBubbleBgExecutor)localIterator.next();
        if (localChatLayoutBubbleBgExecutor.a(paramInt, paramChatMessage)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor = localChatLayoutBubbleBgExecutor;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor = b();
  }
  
  private ChatLayoutBubbleBgExecutor b()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor == null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor = new NoneBubbleBgExecutor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_c_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor;
  }
  
  public int a()
  {
    ChatLayoutBubbleBgExecutor localChatLayoutBubbleBgExecutor = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor;
    if (localChatLayoutBubbleBgExecutor != null) {
      return localChatLayoutBubbleBgExecutor.a();
    }
    return h;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    a(paramInt3, paramChatMessage);
    if (a(paramInt3, paramChatMessage)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor.a(paramChatMessage, paramViewHolder, paramInt1, paramInt2, paramBoolean, paramInt3);
    }
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutorImpl
 * JD-Core Version:    0.7.0.1
 */