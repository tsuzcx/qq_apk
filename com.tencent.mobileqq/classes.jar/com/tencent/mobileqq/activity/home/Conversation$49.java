package com.tencent.mobileqq.activity.home;

import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;

class Conversation$49
  extends AVObserver
{
  Conversation$49(Conversation paramConversation) {}
  
  protected void a(int paramInt, long paramLong)
  {
    paramInt = UITools.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = UITools.c(paramInt);
    this.a.a(8, Long.toString(paramLong1), paramInt);
    this.a.b(paramLong1);
    this.a.b(new Conversation.49.1(this, paramLong1));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, paramInt);
    this.a.b(new Conversation.49.4(this));
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    this.a.b(new Conversation.49.6(this));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!this.a.e) {
      return;
    }
    this.a.b(new Conversation.49.5(this));
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void b(int paramInt, long paramLong)
  {
    paramInt = UITools.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a().getCurrentAccountUin()).longValue()) {
      this.a.b(new Conversation.49.2(this, paramLong1));
    }
  }
  
  protected void c(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a().getCurrentAccountUin()).longValue()) {
      this.a.b(new Conversation.49.3(this, paramLong1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.49
 * JD-Core Version:    0.7.0.1
 */