package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public abstract interface IHeadIconProcessor
  extends IBaseChatItemLayoutProcessor
{
  public abstract VasAvatar a();
  
  public abstract void a(Object paramObject);
  
  public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public abstract void a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract BaseChatItemLayoutViewBasicAbility b();
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor
 * JD-Core Version:    0.7.0.1
 */