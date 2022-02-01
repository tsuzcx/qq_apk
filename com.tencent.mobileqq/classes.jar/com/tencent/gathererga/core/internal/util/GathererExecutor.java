package com.tencent.gathererga.core.internal.util;

import com.tencent.gathererga.core.IExecutor;

public class GathererExecutor
  implements IExecutor
{
  private static volatile GathererExecutor a;
  private IExecutor b = null;
  private IExecutor c = null;
  
  public static GathererExecutor a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GathererExecutor();
        }
      }
      finally {}
    }
    return a;
  }
  
  private IExecutor b()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    IExecutor localIExecutor = this.c;
    localObject = localIExecutor;
    if (localIExecutor == null)
    {
      this.c = new GathererExecutor.DefaultExecutor();
      localObject = this.c;
    }
    return localObject;
  }
  
  public void a(IExecutor paramIExecutor)
  {
    this.b = paramIExecutor;
  }
  
  public void a(Runnable paramRunnable)
  {
    b().a(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.GathererExecutor
 * JD-Core Version:    0.7.0.1
 */