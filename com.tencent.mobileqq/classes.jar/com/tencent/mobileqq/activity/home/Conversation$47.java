package com.tencent.mobileqq.activity.home;

import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;

class Conversation$47
  extends AVObserver
{
  Conversation$47(Conversation paramConversation) {}
  
  public void a(int paramInt, long paramLong)
  {
    paramInt = UITools.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = UITools.c(paramInt);
    this.a.a(8, Long.toString(paramLong1), paramInt);
    this.a.b(paramLong1);
    this.a.b(new Conversation.47.1(this, paramLong1));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, paramInt);
    this.a.b(new Conversation.47.4(this));
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.a.b(new Conversation.47.6(this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!this.a.f) {
      return;
    }
    this.a.b(new Conversation.47.5(this));
  }
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void b(int paramInt, long paramLong)
  {
    paramInt = UITools.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  public void b(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a().getCurrentAccountUin()).longValue()) {
      this.a.b(new Conversation.47.2(this, paramLong1));
    }
  }
  
  public void c(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a().getCurrentAccountUin()).longValue()) {
      this.a.b(new Conversation.47.3(this, paramLong1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.47
 * JD-Core Version:    0.7.0.1
 */