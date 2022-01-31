package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

class LengthHashURLConnectionDownloader$1
  extends ProgressFutureImpl<File>
{
  LengthHashURLConnectionDownloader$1(Future paramFuture, double paramDouble, AtomicLong paramAtomicLong)
  {
    super(paramFuture, null);
  }
  
  public double getProgress()
  {
    double d = 0.0D;
    if ((this.a != 0.0D) && (!isDone())) {
      d = this.b.get() / this.a;
    }
    while (!isDone()) {
      return d;
    }
    return 1.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.LengthHashURLConnectionDownloader.1
 * JD-Core Version:    0.7.0.1
 */