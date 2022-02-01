package com.tencent.mobileqq.activity.aio.navigate;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class NavigateBar
{
  protected BaseChatPie a;
  protected QQAppInterface b;
  protected Context c;
  protected SessionInfo d;
  public int e;
  public int f;
  
  public NavigateBar(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    this.a = paramBaseChatPie;
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.d = paramSessionInfo;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public abstract View a();
  
  public abstract void b();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public long g()
  {
    return 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NavigateBar{id=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.NavigateBar
 * JD-Core Version:    0.7.0.1
 */