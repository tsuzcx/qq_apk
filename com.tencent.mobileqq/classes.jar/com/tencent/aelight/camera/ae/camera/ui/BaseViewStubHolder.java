package com.tencent.aelight.camera.ae.camera.ui;

import android.view.View;
import android.view.ViewStub;
import java.util.LinkedList;
import java.util.Queue;

public abstract class BaseViewStubHolder
{
  private final ViewStub a;
  private boolean b = false;
  private Queue<Runnable> c;
  
  public BaseViewStubHolder(ViewStub paramViewStub)
  {
    this.a = paramViewStub;
    this.c = new LinkedList();
  }
  
  private void d()
  {
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.c.poll();
      if (localRunnable != null) {
        try
        {
          localRunnable.run();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          throw new RuntimeException("doPendingActions encounter an error", localException);
        }
      }
    }
  }
  
  public ViewStub a()
  {
    return this.a;
  }
  
  protected abstract void a(View paramView);
  
  protected void a(Runnable paramRunnable)
  {
    if (this.b)
    {
      paramRunnable.run();
      return;
    }
    if (paramRunnable != null) {
      this.c.add(paramRunnable);
    }
  }
  
  public boolean ap_()
  {
    return this.b;
  }
  
  protected final void c()
  {
    if (this.b) {
      return;
    }
    View localView = this.a.inflate();
    this.b = true;
    a(localView);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder
 * JD-Core Version:    0.7.0.1
 */