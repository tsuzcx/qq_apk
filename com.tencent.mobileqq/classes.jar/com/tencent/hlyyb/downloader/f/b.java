package com.tencent.hlyyb.downloader.f;

import com.tencent.hlyyb.common.a.e;
import java.util.concurrent.Future;

final class b
  implements e
{
  private Future<?> a;
  
  public b(Future<?> paramFuture)
  {
    this.a = paramFuture;
  }
  
  public final boolean a()
  {
    boolean bool = false;
    if (this.a != null) {}
    try
    {
      bool = this.a.cancel(false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */