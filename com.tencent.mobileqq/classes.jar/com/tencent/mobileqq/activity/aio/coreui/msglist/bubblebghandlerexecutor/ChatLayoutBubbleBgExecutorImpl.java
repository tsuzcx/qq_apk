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
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  private static int k;
  private List<ChatLayoutBubbleBgExecutor> l;
  private ChatLayoutBubbleBgExecutor m;
  private ChatLayoutBubbleBgExecutor n;
  private ChatLayoutBubbleBgExecutor o;
  
  static
  {
    int i1 = k;
    k = i1 + 1;
    d = i1;
    i1 = k;
    k = i1 + 1;
    e = i1;
    i1 = k;
    k = i1 + 1;
    f = i1;
    i1 = k;
    k = i1 + 1;
    g = i1;
    i1 = k;
    k = i1 + 1;
    h = i1;
    i1 = k;
    k = i1 + 1;
    i = i1;
    i1 = k;
    k = i1 + 1;
    j = i1;
  }
  
  public ChatLayoutBubbleBgExecutorImpl(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  private ChatLayoutBubbleBgExecutor b()
  {
    if (this.n == null) {
      this.n = new DefaultMsgBubbleBgExecutor(this.a, this.b, this.c);
    }
    return this.n;
  }
  
  private void b(int paramInt, ChatMessage paramChatMessage)
  {
    if (this.l == null)
    {
      this.l = new ArrayList();
      this.l.add(new SimpleUIMsgBubbleBgExecutor(this.a, this.b, this.c));
      this.l.add(new ConfessMsgBubbleBgExecutor(this.a, this.b, this.c));
      this.l.add(new QimMsgBubbleBgExecutor(this.a, this.b, this.c));
      this.l.add(new GameMsgBubbleBgExecutor(this.a, this.b, this.c));
    }
    this.m = null;
    if (paramInt != 0)
    {
      this.m = b();
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        ChatLayoutBubbleBgExecutor localChatLayoutBubbleBgExecutor = (ChatLayoutBubbleBgExecutor)localIterator.next();
        if (localChatLayoutBubbleBgExecutor.a(paramInt, paramChatMessage)) {
          this.m = localChatLayoutBubbleBgExecutor;
        }
      }
    }
    this.m = c();
  }
  
  private ChatLayoutBubbleBgExecutor c()
  {
    if (this.o == null) {
      this.o = new NoneBubbleBgExecutor(this.a, this.b, this.c);
    }
    return this.o;
  }
  
  public int a()
  {
    ChatLayoutBubbleBgExecutor localChatLayoutBubbleBgExecutor = this.m;
    if (localChatLayoutBubbleBgExecutor != null) {
      return localChatLayoutBubbleBgExecutor.a();
    }
    return k;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    b(paramInt3, paramChatMessage);
    if (a(paramInt3, paramChatMessage)) {
      this.m.a(paramChatMessage, paramViewHolder, paramInt1, paramInt2, paramBoolean, paramInt3);
    }
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    return this.m != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutorImpl
 * JD-Core Version:    0.7.0.1
 */