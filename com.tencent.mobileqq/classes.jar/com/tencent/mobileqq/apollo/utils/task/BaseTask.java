package com.tencent.mobileqq.apollo.utils.task;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTask
  implements Handler.Callback
{
  private List<BaseTask> a = new ArrayList();
  protected Handler b = new Handler(Looper.getMainLooper());
  protected Context c;
  protected long d = 0L;
  public int e = -1;
  public String f = "";
  private BaseTask.Callback g;
  private int h = 1;
  private boolean i = false;
  private boolean j = false;
  private int k = 1;
  private long l = 0L;
  private long m = -1L;
  
  public BaseTask(Context paramContext, int paramInt)
  {
    this.c = paramContext;
    this.k = paramInt;
  }
  
  public BaseTask a(BaseTask.Callback paramCallback)
  {
    this.g = paramCallback;
    return this;
  }
  
  public BaseTask a(BaseTask paramBaseTask)
  {
    if (!this.a.contains(paramBaseTask)) {
      this.a.add(paramBaseTask);
    }
    return this;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.h = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.d = (SystemClock.uptimeMillis() - this.l);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task end: ");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" retCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramString);
    QLog.i("[cmshow]TaskFlow", 1, localStringBuilder.toString());
    a(3);
    this.i = false;
    this.e = paramInt;
    this.f = paramString;
    paramString = this.g;
    if (paramString != null) {
      paramString.a(this);
    }
  }
  
  protected abstract void c();
  
  public List<BaseTask> d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return this.h == 3;
  }
  
  @NonNull
  public String f()
  {
    return getClass().getSimpleName();
  }
  
  public void g()
  {
    int n = this.h;
    if (n == 2) {
      return;
    }
    if (n == 3)
    {
      this.j = true;
      localObject = this.g;
      if (localObject != null) {
        ((BaseTask.Callback)localObject).a(this);
      }
      return;
    }
    a(2);
    Object localObject = this.g;
    if (localObject != null) {
      ((BaseTask.Callback)localObject).b(this);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Task begin: ");
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    QLog.i("[cmshow]TaskFlow", 1, ((StringBuilder)localObject).toString());
    try
    {
      i();
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]TaskFlow", 1, "task exception!", localThrowable);
      k();
    }
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected final void i()
  {
    this.l = SystemClock.uptimeMillis();
  }
  
  public void j()
  {
    this.d = (SystemClock.uptimeMillis() - this.l);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Task end: ");
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" succ=");
    ((StringBuilder)localObject).append(true);
    QLog.i("[cmshow]TaskFlow", 1, ((StringBuilder)localObject).toString());
    a(3);
    this.i = true;
    localObject = this.g;
    if (localObject != null) {
      ((BaseTask.Callback)localObject).a(this);
    }
  }
  
  public void k()
  {
    this.d = (SystemClock.uptimeMillis() - this.l);
    a(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.BaseTask
 * JD-Core Version:    0.7.0.1
 */