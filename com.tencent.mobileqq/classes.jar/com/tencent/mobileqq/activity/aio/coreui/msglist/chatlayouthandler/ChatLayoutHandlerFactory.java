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
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.OnlineStatusChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.QCircleHandler;
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.StickerHandler;
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class ChatLayoutHandlerFactory
  implements IChatLayoutHandlerFactory
{
  private volatile SparseArray<ChatLayoutHandler> a;
  private volatile SparseArray<ChatLayoutHandler> b;
  private HandleChatLayoutPreGetBubbleViewProcessor c;
  private HandleChatLayoutBehindGetBubbleViewProcessor d;
  private IChatLayoutListenerController e;
  private QQAppInterface f;
  private SessionInfo g;
  private Context h;
  private View.OnClickListener i;
  private View.OnLongClickListener j;
  private Object k = new Object();
  
  public ChatLayoutHandlerFactory(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.f = paramQQAppInterface;
    this.g = paramSessionInfo;
    this.h = paramContext;
    this.i = paramOnClickListener;
    this.j = paramOnLongClickListener;
    this.e = new ChatLayoutListenerController();
  }
  
  private void c()
  {
    if (this.a == null) {
      synchronized (this.k)
      {
        if (this.a == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatLayoutHandlerFactory", 2, "mHandleCachePreNewView init");
          }
          SparseArray localSparseArray1 = new SparseArray();
          localSparseArray1.append(0, new HeadIconHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          localSparseArray1.append(1, new AvatarPendantHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          localSparseArray1.append(2, new OnlineStatusChatLayoutHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          localSparseArray1.append(3, new NickHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          localSparseArray1.append(4, new TroopRelevantHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          localSparseArray1.append(5, new QCircleHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          this.a = localSparseArray1;
        }
      }
    }
    if (this.b == null) {
      synchronized (this.k)
      {
        if (this.b == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatLayoutHandlerFactory", 2, "mHandleCacheBehindNewView init");
          }
          SparseArray localSparseArray2 = new SparseArray();
          localSparseArray2.append(0, new BubbleBgHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          localSparseArray2.append(1, new StickerHandler(this.f, this.g, this.h, this.i, this.j, this.e));
          this.b = localSparseArray2;
        }
        return;
      }
    }
  }
  
  public ChatLayoutHandler a()
  {
    if (this.c == null) {
      this.c = new HandleChatLayoutPreGetBubbleViewProcessor(this.f, this.g, this.h, this.i, this.j, this.e, this);
    }
    return this.c;
  }
  
  public ChatLayoutHandler a(int paramInt)
  {
    c();
    ChatLayoutHandler localChatLayoutHandler = (ChatLayoutHandler)this.a.get(paramInt);
    if (localChatLayoutHandler != null) {
      return localChatLayoutHandler;
    }
    return (ChatLayoutHandler)this.b.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    c();
    int m = 0;
    while (m < this.a.size())
    {
      ChatLayoutHandler localChatLayoutHandler = (ChatLayoutHandler)this.a.get(m);
      if (localChatLayoutHandler != null) {
        localChatLayoutHandler.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, paramBundle);
      }
      m += 1;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    ChatLayoutHandler localChatLayoutHandler = a(paramInt);
    if ((localChatLayoutHandler instanceof IBaseBubbleClickProcessor)) {
      ((IBaseBubbleClickProcessor)localChatLayoutHandler).b(paramView);
    }
  }
  
  public void a(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.e.a(paramInt, paramIChatLayoutListener);
  }
  
  public ChatLayoutHandler b()
  {
    if (this.d == null) {
      this.d = new HandleChatLayoutBehindGetBubbleViewProcessor(this.f, this.g, this.h, this.i, this.j, this.e, this);
    }
    return this.d;
  }
  
  public void b(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    c();
    int m = 0;
    while (m < this.b.size())
    {
      ChatLayoutHandler localChatLayoutHandler = (ChatLayoutHandler)this.b.get(m);
      if (localChatLayoutHandler != null) {
        localChatLayoutHandler.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, paramBundle);
      }
      m += 1;
    }
  }
  
  public void b(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.e.b(paramInt, paramIChatLayoutListener);
  }
  
  public boolean b(int paramInt, View paramView)
  {
    ChatLayoutHandler localChatLayoutHandler = a(paramInt);
    if ((localChatLayoutHandler instanceof IBaseBubbleLongClickProcessor)) {
      return ((IBaseBubbleLongClickProcessor)localChatLayoutHandler).a(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandlerFactory
 * JD-Core Version:    0.7.0.1
 */