package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

class SimpleURLConnectionDownloader$1
  extends ProgressFutureImpl<File>
{
  SimpleURLConnectionDownloader$1(Future paramFuture, double paramDouble, AtomicLong paramAtomicLong)
  {
    super(paramFuture, null);
  }
  
  public double getProgress()
  {
    if ((this.a != 0.0D) && (!isDone()))
    {
      double d1 = this.b.get();
      double d2 = this.a;
      Double.isNaN(d1);
      return d1 / d2;
    }
    if (isDone()) {
      return 1.0D;
    }
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader.1
 * JD-Core Version:    0.7.0.1
 */