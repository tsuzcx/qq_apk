package com.tencent.mobileqq.activity.aio.anim.egg;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public abstract interface IEggBizPlayer
{
  public abstract int a();
  
  public abstract void a(QQAppInterface paramQQAppInterface, Handler paramHandler, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ArrayList<AioAnimationRule> paramArrayList, int paramInt2);
  
  public abstract void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo);
  
  public abstract void a(List<ChatMessage> paramList);
  
  public abstract int b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.egg.IEggBizPlayer
 * JD-Core Version:    0.7.0.1
 */