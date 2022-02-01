package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class BubbleInterActiveAnim$DealChatMessage
{
  private boolean a;
  private MessageRecord b;
  private AIOAnimationConatiner c;
  private boolean d;
  private int e;
  private Object f;
  private BaseBubbleBuilder.ViewHolder g;
  private ChatMessage h;
  private BubbleInterActiveAnim.FindOriginalMsg i;
  
  public BubbleInterActiveAnim$DealChatMessage(MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner, boolean paramBoolean, int paramInt, Object paramObject)
  {
    this.b = paramMessageRecord;
    this.c = paramAIOAnimationConatiner;
    this.d = paramBoolean;
    this.e = paramInt;
    this.f = paramObject;
  }
  
  boolean a()
  {
    return this.a;
  }
  
  public BaseBubbleBuilder.ViewHolder b()
  {
    return this.g;
  }
  
  public ChatMessage c()
  {
    return this.h;
  }
  
  public BubbleInterActiveAnim.FindOriginalMsg d()
  {
    return this.i;
  }
  
  public DealChatMessage e()
  {
    if (!(this.f instanceof ChatMessage))
    {
      this.a = true;
      return this;
    }
    Object localObject = AIOUtils.b(AIOUtils.a(this.c.getListView(), this.e));
    if ((localObject instanceof BaseBubbleBuilder.ViewHolder)) {
      localObject = (BaseBubbleBuilder.ViewHolder)localObject;
    } else {
      localObject = null;
    }
    this.g = ((BaseBubbleBuilder.ViewHolder)localObject);
    this.h = ((ChatMessage)this.f);
    this.i = new BubbleInterActiveAnim.FindOriginalMsg(this.b, this.d, this.h).c();
    if (this.i.a())
    {
      this.a = true;
      return this;
    }
    this.a = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.DealChatMessage
 * JD-Core Version:    0.7.0.1
 */