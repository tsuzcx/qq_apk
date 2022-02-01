package com.tencent.mm.vfs;

public class CancellationSignalBeforeJB
{
  private boolean mCancelInProgress;
  private boolean mIsCanceled;
  private CancellationSignalBeforeJB.OnCancelListener mOnCancelListener;
  
  private void waitForCancelFinishedLocked()
  {
    while (this.mCancelInProgress) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        label14:
        break label14;
      }
    }
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mm/vfs/CancellationSignalBeforeJB:mIsCanceled	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 25	com/tencent/mm/vfs/CancellationSignalBeforeJB:mIsCanceled	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 19	com/tencent/mm/vfs/CancellationSignalBeforeJB:mCancelInProgress	Z
    //   22: aload_0
    //   23: getfield 27	com/tencent/mm/vfs/CancellationSignalBeforeJB:mOnCancelListener	Lcom/tencent/mm/vfs/CancellationSignalBeforeJB$OnCancelListener;
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: ifnull +33 -> 63
    //   33: aload_1
    //   34: invokeinterface 32 1 0
    //   39: goto +24 -> 63
    //   42: astore_1
    //   43: aload_0
    //   44: monitorenter
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 19	com/tencent/mm/vfs/CancellationSignalBeforeJB:mCancelInProgress	Z
    //   50: aload_0
    //   51: invokevirtual 35	java/lang/Object:notifyAll	()V
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    //   63: aload_0
    //   64: monitorenter
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 19	com/tencent/mm/vfs/CancellationSignalBeforeJB:mCancelInProgress	Z
    //   70: aload_0
    //   71: invokevirtual 35	java/lang/Object:notifyAll	()V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	CancellationSignalBeforeJB
    //   26	8	1	localOnCancelListener	CancellationSignalBeforeJB.OnCancelListener
    //   42	15	1	localObject1	Object
    //   58	4	1	localObject2	Object
    //   77	4	1	localObject3	Object
    //   82	4	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   33	39	42	finally
    //   45	56	58	finally
    //   59	61	58	finally
    //   65	76	77	finally
    //   78	80	77	finally
    //   2	11	82	finally
    //   12	29	82	finally
    //   83	85	82	finally
  }
  
  public boolean isCanceled()
  {
    try
    {
      boolean bool = this.mIsCanceled;
      return bool;
    }
    finally {}
  }
  
  public void setOnCancelListener(CancellationSignalBeforeJB.OnCancelListener paramOnCancelListener)
  {
    try
    {
      waitForCancelFinishedLocked();
      if (this.mOnCancelListener == paramOnCancelListener) {
        return;
      }
      this.mOnCancelListener = paramOnCancelListener;
      if ((this.mIsCanceled) && (paramOnCancelListener != null))
      {
        paramOnCancelListener.onCancel();
        return;
      }
      return;
    }
    finally {}
  }
  
  public void throwIfCanceled()
  {
    if (!isCanceled()) {
      return;
    }
    throw new OperationCanceledException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.CancellationSignalBeforeJB
 * JD-Core Version:    0.7.0.1
 */