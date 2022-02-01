package com.tencent.mobileqq.activity.aio.core.msglist.item;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class ItemBuilderSupplier<T extends ChatItemBuilder>
{
  protected Context a;
  protected QQAppInterface b;
  protected SessionInfo c;
  protected BaseChatPie d;
  protected AIOAnimationConatiner e;
  private T f;
  
  protected T a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (this.f == null) {
      this.f = b(paramChatMessage, paramBaseAdapter);
    }
    return this.f;
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.c = paramSessionInfo;
    this.d = paramBaseChatPie;
    this.e = paramAIOAnimationConatiner;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected abstract T b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier
 * JD-Core Version:    0.7.0.1
 */