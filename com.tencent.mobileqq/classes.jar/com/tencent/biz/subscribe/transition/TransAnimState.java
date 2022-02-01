package com.tencent.biz.subscribe.transition;

import com.tencent.biz.subscribe.transition.inter.ITransAnimStateListener;

public class TransAnimState
{
  private volatile int a = 0;
  private ITransAnimStateListener b;
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    ITransAnimStateListener localITransAnimStateListener = this.b;
    if (localITransAnimStateListener != null)
    {
      if (paramInt != -1)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return;
            }
            localITransAnimStateListener.t();
            return;
          }
          localITransAnimStateListener.r();
          return;
        }
        localITransAnimStateListener.s();
        return;
      }
      localITransAnimStateListener.u();
    }
  }
  
  public void a(ITransAnimStateListener paramITransAnimStateListener)
  {
    this.b = paramITransAnimStateListener;
    a(this.a);
  }
  
  public boolean a()
  {
    return this.a == -1;
  }
  
  public boolean b()
  {
    return this.a == 1;
  }
  
  public void c()
  {
    a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransAnimState
 * JD-Core Version:    0.7.0.1
 */