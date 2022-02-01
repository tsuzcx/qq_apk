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
    if (paramJob != null)
    {
      bool = paramJob.priorty;
      if ((!this.priorty) || (!bool)) {
        break label27;
      }
    }
    label27:
    do
    {
      return 0;
      bool = false;
      break;
      if ((this.priorty) && (!bool)) {
        return 1;
      }
    } while (!bool);
    return -1;
  }
  
  public void run()
  {
    if (this.runnable != null) {
      this.runnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.Job
 * JD-Core Version:    0.7.0.1
 */