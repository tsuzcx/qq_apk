package com.tencent.component.media.image;

class ImageManager$Job
  implements Comparable<Job>, Runnable
{
  private boolean priorty;
  private Runnable runnable;
  
  public ImageManager$Job(Runnable paramRunnable, boolean paramBoolean)
  {
    this.runnable = paramRunnable;
    this.priorty = paramBoolean;
  }
  
  public int compareTo(Job paramJob)
  {
    boolean bool;
    if (paramJob != null) {
      bool = paramJob.priorty;
    } else {
      bool = false;
    }
    if ((this.priorty) && (bool)) {
      return 0;
    }
    if ((this.priorty) && (!bool)) {
      return 1;
    }
    if (bool) {
      return -1;
    }
    return 0;
  }
  
  public void run()
  {
    Runnable localRunnable = this.runnable;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.Job
 * JD-Core Version:    0.7.0.1
 */