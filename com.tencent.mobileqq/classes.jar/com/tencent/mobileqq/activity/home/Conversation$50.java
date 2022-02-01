package com.tencent.mobileqq.activity.home;

import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;

class Conversation$50
  extends AVObserver
{
  Conversation$50(Conversation paramConversation) {}
  
  protected void a(int paramInt, long paramLong)
  {
    paramInt = UITools.c(paramInt);
    this.b.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = UITools.c(paramInt);
    this.b.a(8, Long.toString(paramLong1), paramInt);
    this.b.c(paramLong1);
    this.b.b(new Conversation.50.1(this, paramLong1));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    this.b.a(8, paramString1, paramInt);
    this.b.b(new Conversation.50.4(this));
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    this.b.b(new Conversation.50.6(this));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!this.b.C) {
      return;
    }
    this.b.b(new Conversation.50.5(this));
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void b(int paramInt, long paramLong)
  {
    paramInt = UITools.c(paramInt);
    this.b.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.b.s().getCurrentAccountUin()).longValue()) {
      this.b.b(new Conversation.50.2(this, paramLong1));
    }
  }
  
  protected void c(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.b.s().getCurrentAccountUin()).longValue()) {
      this.b.b(new Conversation.50.3(this, paramLong1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.50
 * JD-Core Version:    0.7.0.1
 */