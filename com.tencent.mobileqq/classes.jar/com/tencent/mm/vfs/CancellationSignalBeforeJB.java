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
      catch (InterruptedException localInterruptedException) {}
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
    //   30: ifnull +9 -> 39
    //   33: aload_1
    //   34: invokeinterface 32 1 0
    //   39: aload_0
    //   40: monitorenter
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 19	com/tencent/mm/vfs/CancellationSignalBeforeJB:mCancelInProgress	Z
    //   46: aload_0
    //   47: invokevirtual 35	java/lang/Object:notifyAll	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    //   63: astore_1
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 19	com/tencent/mm/vfs/CancellationSignalBeforeJB:mCancelInProgress	Z
    //   71: aload_0
    //   72: invokevirtual 35	java/lang/Object:notifyAll	()V
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	CancellationSignalBeforeJB
    //   26	8	1	localOnCancelListener	CancellationSignalBeforeJB.OnCancelListener
    //   53	4	1	localObject1	Object
    //   58	4	1	localObject2	Object
    //   63	15	1	localObject3	Object
    //   79	4	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   41	52	53	finally
    //   54	56	53	finally
    //   2	11	58	finally
    //   12	29	58	finally
    //   59	61	58	finally
    //   33	39	63	finally
    //   66	77	79	finally
    //   80	82	79	finally
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
      if ((!this.mIsCanceled) || (paramOnCancelListener == null)) {
        return;
      }
    }
    finally {}
    paramOnCancelListener.onCancel();
  }
  
  public void throwIfCanceled()
  {
    if (isCanceled()) {
      throw new OperationCanceledException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.CancellationSignalBeforeJB
 * JD-Core Version:    0.7.0.1
 */