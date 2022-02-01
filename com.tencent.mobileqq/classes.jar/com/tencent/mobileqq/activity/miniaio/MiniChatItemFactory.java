package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class MiniChatItemFactory
  extends ItemBuilderFactory
{
  boolean f = false;
  
  public MiniChatItemFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 62) || (paramInt == 96) || (paramInt == 75);
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (a(a(this.b, paramChatMessage)))
    {
      if (this.e == null) {
        this.e = new MiniChatTextItemBuilder(this.b, paramBaseAdapter, this.a, this.c, this.d);
      }
      paramChatMessage = a(this.e, paramBaseAdapter);
    }
    else
    {
      paramChatMessage = super.a(paramChatMessage, paramBaseAdapter);
    }
    if ((paramChatMessage instanceof BaseBubbleBuilder)) {
      ((BaseBubbleBuilder)paramChatMessage).o = true;
    }
    return paramChatMessage;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatItemFactory
 * JD-Core Version:    0.7.0.1
 */