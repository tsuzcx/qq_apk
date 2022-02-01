package com.tencent.image;

import com.tencent.image.api.IThreadListener;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.URLDrawableDepWrap;
import java.util.LinkedList;

public class JobQueue
  implements IThreadListener
{
  protected final int maxRunning;
  protected LinkedList<Runnable> queue = new LinkedList();
  protected int running;
  
  public JobQueue(int paramInt)
  {
    this.maxRunning = paramInt;
  }
  
  /* Error */
  public void excuteOnNetThread(Runnable paramRunnable, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/image/JobQueue:running	I
    //   6: aload_0
    //   7: getfield 24	com/tencent/image/JobQueue:maxRunning	I
    //   10: if_icmpge +30 -> 40
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 29	com/tencent/image/JobQueue:running	I
    //   18: iconst_1
    //   19: iadd
    //   20: putfield 29	com/tencent/image/JobQueue:running	I
    //   23: getstatic 35	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   26: getfield 41	com/tencent/image/api/URLDrawableDepWrap:mThreadManager	Lcom/tencent/image/api/IThreadManager;
    //   29: aload_1
    //   30: aload_0
    //   31: iconst_0
    //   32: invokeinterface 47 4 0
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: getfield 22	com/tencent/image/JobQueue:queue	Ljava/util/LinkedList;
    //   44: aload_1
    //   45: invokevirtual 51	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: goto -12 -> 37
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	JobQueue
    //   0	57	1	paramRunnable	Runnable
    //   0	57	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	37	52	finally
    //   40	49	52	finally
  }
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    try
    {
      this.running -= 1;
      while (this.running < this.maxRunning)
      {
        Runnable localRunnable = (Runnable)this.queue.poll();
        if (localRunnable == null) {
          break;
        }
        this.running += 1;
        URLDrawable.depImp.mThreadManager.executeOnNetThreadExcutor(localRunnable, this, false);
      }
    }
    finally {}
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.JobQueue
 * JD-Core Version:    0.7.0.1
 */