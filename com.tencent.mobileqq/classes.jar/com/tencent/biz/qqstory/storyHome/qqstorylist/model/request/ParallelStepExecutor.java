package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

@Deprecated
public class ParallelStepExecutor
  extends SimpleStepExector
  implements Handler.Callback
{
  protected LinkedHashMap<String, Step> a = new LinkedHashMap();
  protected Vector<Step> b = new Vector();
  protected Handler c = new Handler(Looper.getMainLooper());
  public volatile int d = 0;
  protected boolean e = false;
  protected ErrorMessage f;
  private String i = "ParallelStepExecutor";
  private Handler j = new Handler(paramLooper, this);
  private Handler k;
  
  public ParallelStepExecutor(Looper paramLooper) {}
  
  private void b(String paramString)
  {
    if (paramString == null)
    {
      SLog.e("Q.qqstory.home.ParallelStepExecutor", "occur error ! step key is null!!");
      return;
    }
    SLog.e("Q.qqstory.home.ParallelStepExecutor", "%s have been finish", new Object[] { paramString });
    this.a.remove(paramString);
    if (this.a.size() == 0)
    {
      SLog.b("Q.qqstory.home.ParallelStepExecutor", "all step have finish");
      if (this.h != null)
      {
        this.d = 2;
        this.c.removeMessages(100);
        if (this.e) {
          this.g.a(this.f);
        } else {
          this.h.a();
        }
      }
      h();
    }
  }
  
  public ParallelStepExecutor a(SimpleStepExector.CompletedHandler paramCompletedHandler)
  {
    this.h = paramCompletedHandler;
    return this;
  }
  
  public ParallelStepExecutor a(SimpleStepExector.ErrorHandler paramErrorHandler)
  {
    this.g = paramErrorHandler;
    return this;
  }
  
  public ParallelStepExecutor a(Step paramStep)
  {
    SLog.a("Q.qqstory.home.ParallelStepExecutor", "add Step:%s", paramStep.c());
    this.a.put(paramStep.c(), paramStep);
    this.d = 0;
    return this;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.ParallelStepExecutor", "occur error:%s", new Object[] { paramErrorMessage.getErrorMessage() });
    this.e = true;
    this.f = paramErrorMessage;
    a(paramErrorMessage.extraMsg);
  }
  
  public void a(String paramString)
  {
    try
    {
      int m = this.d;
      if (m == 3) {
        return;
      }
      if (this.k != null)
      {
        this.k.obtainMessage(1, paramString).sendToTarget();
      }
      else
      {
        SLog.e("Q.qqstory.home.ParallelStepExecutor", "there is no mCompletedHandler !!!!");
        b(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      SLog.d("Q.qqstory.home.ParallelStepExecutor", "startAsyncStep count=%s", new Object[] { Integer.valueOf(this.a.size()) });
      if (this.d == 2)
      {
        SLog.e("Q.qqstory.home.ParallelStepExecutor", "startAsyncStep but state is done ,so ingore this start operate");
        return;
      }
      this.d = 1;
      if (this.k == null) {
        this.k = new Handler(Looper.myLooper(), this);
      }
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Step localStep = (Step)((Map.Entry)localIterator.next()).getValue();
        localStep.a(this);
        localStep.a(this);
        this.j.obtainMessage(2, localStep).sendToTarget();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public String c()
  {
    return this.i;
  }
  
  public void e() {}
  
  public void f()
  {
    try
    {
      this.d = 3;
      this.c.removeMessages(100);
      if (this.k != null) {
        this.k.removeMessages(1);
      }
      if (this.j != null) {
        this.j.removeMessages(2);
      }
      SLog.b("Q.qqstory.home.ParallelStepExecutor", "reset!");
      if (this.b.size() > 0)
      {
        SLog.b("Q.qqstory.home.ParallelStepExecutor", "reset premissSteps");
        ((Step)this.b.get(0)).f();
        this.b.clear();
      }
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Step localStep = (Step)((Map.Entry)localIterator.next()).getValue();
        if (localStep != null) {
          localStep.f();
        }
      }
      this.a.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 1)
    {
      if (m != 2) {
        return true;
      }
      ((Step)paramMessage.obj).b();
      return true;
    }
    b((String)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ParallelStepExecutor
 * JD-Core Version:    0.7.0.1
 */