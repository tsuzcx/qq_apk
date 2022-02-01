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
  
  public void excuteOnNetThread(Runnable paramRunnable, boolean paramBoolean)
  {
    try
    {
      if (this.running < this.maxRunning)
      {
        this.running += 1;
        URLDrawable.depImp.mThreadManager.executeOnNetThreadExcutor(paramRunnable, this, false);
      }
      else
      {
        this.queue.add(paramRunnable);
      }
      return;
    }
    finally {}
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.JobQueue
 * JD-Core Version:    0.7.0.1
 */