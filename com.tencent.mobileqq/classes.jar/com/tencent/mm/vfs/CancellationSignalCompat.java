package com.tencent.mm.vfs;

import android.os.Build.VERSION;
import android.os.CancellationSignal;

public class CancellationSignalCompat
{
  private CancellationSignal signal;
  private CancellationSignalBeforeJB signalBeforeJB;
  
  public CancellationSignalCompat()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      this.signalBeforeJB = new CancellationSignalBeforeJB();
      return;
    }
    this.signal = new CancellationSignal();
  }
  
  public void cancel()
  {
    if (this.signal != null)
    {
      this.signal.cancel();
      return;
    }
    this.signalBeforeJB.cancel();
  }
  
  public boolean isCanceled()
  {
    if (this.signal != null) {
      return this.signal.isCanceled();
    }
    return this.signalBeforeJB.isCanceled();
  }
  
  public void throwIfCanceled()
  {
    if (this.signal != null)
    {
      if (this.signal.isCanceled()) {
        throw new OperationCanceledException();
      }
    }
    else {
      this.signalBeforeJB.throwIfCanceled();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CancellationSignalCompat
 * JD-Core Version:    0.7.0.1
 */