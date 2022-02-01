package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

final class e<TResult>
  implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult>
{
  private final Object a = new Object();
  private final int b;
  private final i<Void> c;
  private int d;
  private Exception e;
  private boolean f;
  
  e(int paramInt, i<Void> parami)
  {
    this.b = paramInt;
    this.c = parami;
  }
  
  private void a()
  {
    if (this.d >= this.b)
    {
      if (this.e != null) {
        this.c.a(new ExecutionException("a task failed", this.e));
      }
    }
    else {
      return;
    }
    if (this.f)
    {
      this.c.a();
      return;
    }
    this.c.a(null);
  }
  
  public final void onCanceled()
  {
    synchronized (this.a)
    {
      this.d += 1;
      this.f = true;
      a();
      return;
    }
  }
  
  public final void onFailure(Exception paramException)
  {
    synchronized (this.a)
    {
      this.d += 1;
      this.e = paramException;
      a();
      return;
    }
  }
  
  public final void onSuccess(TResult arg1)
  {
    synchronized (this.a)
    {
      this.d += 1;
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.e
 * JD-Core Version:    0.7.0.1
 */