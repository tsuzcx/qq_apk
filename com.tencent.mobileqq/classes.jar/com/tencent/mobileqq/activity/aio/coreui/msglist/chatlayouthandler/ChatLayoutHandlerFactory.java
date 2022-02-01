package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.AvatarPendantHandler;
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.QCircleHandler;
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.StickerHandler;
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class ChatLayoutHandlerFactory
  implements IChatLayoutHandlerFactory
{
  private Context jdField_a_of_type_AndroidContentContext;
  private volatile SparseArray<ChatLayoutHandler> jdField_a_of_type_AndroidUtilSparseArray;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private HandleChatLayoutBehindGetBubbleViewProcessor jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutBehindGetBubbleViewProcessor;
  private HandleChatLayoutPreGetBubbleViewProcessor jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutPreGetBubbleViewProcessor;
  private IChatLayoutListenerController jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile SparseArray<ChatLayoutHandler> b;
  
  public ChatLayoutHandlerFactory(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController = new ChatLayoutListenerController();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    SparseArray localSparseArray;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatLayoutHandlerFactory", 2, "mHandleCachePreNewView init");
        }
        localSparseArray = new SparseArray();
        localSparseArray.append(0, new HeadIconHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController));
        localSparseArray.append(1, new AvatarPendantHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController));
        localSparseArray.append(2, new NickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController));
        localSparseArray.append(3, new TroopRelevantHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController));
        localSparseArray.append(4, new QCircleHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController));
        this.jdField_a_of_type_AndroidUtilSparseArray = localSparseArray;
      }
      if (this.b != null) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatLayoutHandlerFactory", 2, "mHandleCacheBehindNewView init");
        }
        localSparseArray = new SparseArray();
        localSparseArray.append(0, new BubbleBgHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController));
        localSparseArray.append(1, new StickerHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController));
        this.b = localSparseArray;
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public ChatLayoutHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutPreGetBubbleViewProcessor == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutPreGetBubbleViewProcessor = new HandleChatLayoutPreGetBubbleViewProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutPreGetBubbleViewProcessor;
  }
  
  public ChatLayoutHandler a(int paramInt)
  {
    a();
    ChatLayoutHandler localChatLayoutHandler = (ChatLayoutHandler)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localChatLayoutHandler != null) {
      return localChatLayoutHandler;
    }
    return (ChatLayoutHandler)this.b.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    a();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ChatLayoutHandler localChatLayoutHandler = (ChatLayoutHandler)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localChatLayoutHandler != null) {
        localChatLayoutHandler.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, paramBundle);
      }
      i += 1;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    ChatLayoutHandler localChatLayoutHandler = a(paramInt);
    if ((localChatLayoutHandler instanceof IBaseBubbleClickProcessor)) {
      ((IBaseBubbleClickProcessor)localChatLayoutHandler).a(paramView);
    }
  }
  
  public void a(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController.a(paramInt, paramIChatLayoutListener);
  }
  
  public boolean a(int paramInt, View paramView)
  {
    ChatLayoutHandler localChatLayoutHandler = a(paramInt);
    if ((localChatLayoutHandler instanceof IBaseBubbleLongClickProcessor)) {
      return ((IBaseBubbleLongClickProcessor)localChatLayoutHandler).a(paramView);
    }
    return false;
  }
  
  public ChatLayoutHandler b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutBehindGetBubbleViewProcessor == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutBehindGetBubbleViewProcessor = new HandleChatLayoutBehindGetBubbleViewProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerHandleChatLayoutBehindGetBubbleViewProcessor;
  }
  
  public void b(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    a();
    int i = 0;
    while (i < this.b.size())
    {
      ChatLayoutHandler localChatLayoutHandler = (ChatLayoutHandler)this.b.get(i);
      if (localChatLayoutHandler != null) {
        localChatLayoutHandler.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, paramBundle);
      }
      i += 1;
    }
  }
  
  public void b(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController.b(paramInt, paramIChatLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandlerFactory
 * JD-Core Version:    0.7.0.1
 */