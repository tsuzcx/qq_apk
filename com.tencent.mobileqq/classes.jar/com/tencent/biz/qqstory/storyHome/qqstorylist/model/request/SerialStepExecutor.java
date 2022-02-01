package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SerialStepExecutor
  extends SimpleStepExector
{
  protected Step a;
  protected Handler b;
  protected Object c;
  private ConcurrentLinkedQueue<Step> d = new ConcurrentLinkedQueue();
  private String e = "SerialStepExecutor";
  private volatile int f = 0;
  
  public SerialStepExecutor(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  private void g()
  {
    if (this.f == 2) {
      return;
    }
    this.b.post(new SerialStepExecutor.1(this));
  }
  
  public SerialStepExecutor a(SimpleStepExector.CompletedHandler paramCompletedHandler)
  {
    this.h = paramCompletedHandler;
    return this;
  }
  
  public SerialStepExecutor a(SimpleStepExector.ErrorHandler paramErrorHandler)
  {
    this.g = paramErrorHandler;
    return this;
  }
  
  public SerialStepExecutor a(Step paramStep)
  {
    SLog.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramStep.c());
    this.d.offer(paramStep);
    return this;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    if (this.g != null) {
      this.g.a(paramErrorMessage);
    }
    if (this.a.d())
    {
      this.c = this.a.a();
      if (this.c == null)
      {
        paramErrorMessage = new StringBuilder();
        paramErrorMessage.append("error step:");
        paramErrorMessage.append(this.a.c());
        paramErrorMessage.append(",return null result");
        SLog.e("Q.qqstory.home.SerialStepExecutor", paramErrorMessage.toString());
      }
      g();
      return;
    }
    f();
  }
  
  public void a(String paramString)
  {
    try
    {
      this.c = this.a.a();
      if (this.c == null)
      {
        paramString = new StringBuilder();
        paramString.append("done step:");
        paramString.append(this.a.c());
        paramString.append(",return null result");
        SLog.e("Q.qqstory.home.SerialStepExecutor", paramString.toString());
      }
      g();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.f = 1;
      g();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void e() {}
  
  public void f()
  {
    try
    {
      this.f = 2;
      SLog.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.a != null)
      {
        this.a.f();
        this.a.a(null);
        this.a.a(null);
      }
      this.d.clear();
      this.b.removeCallbacksAndMessages(null);
      this.g = null;
      this.h = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor
 * JD-Core Version:    0.7.0.1
 */