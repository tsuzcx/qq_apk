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
    Future localFuture = this.a;
    if (localFuture != null) {
      try
      {
        boolean bool = localFuture.cancel(false);
        return bool;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */