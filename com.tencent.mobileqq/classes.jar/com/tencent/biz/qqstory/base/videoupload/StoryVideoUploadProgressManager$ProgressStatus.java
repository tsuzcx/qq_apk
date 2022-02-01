package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;

class StoryVideoUploadProgressManager$ProgressStatus
{
  public String a;
  public String b;
  public boolean c;
  public int d;
  public int e;
  private boolean g;
  private Runnable h = new StoryVideoUploadProgressManager.ProgressStatus.1(this);
  
  private StoryVideoUploadProgressManager$ProgressStatus(StoryVideoUploadProgressManager paramStoryVideoUploadProgressManager) {}
  
  private void c()
  {
    int i = this.d;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if ((i != 4) && (i != 5)) {
              return;
            }
            this.e = 100;
            return;
          }
          this.e += 1;
          if (this.e >= 100) {
            this.e = 99;
          }
        }
        else
        {
          this.e += 1;
          if (this.e >= 95) {
            this.e = 94;
          }
        }
      }
      else
      {
        this.e += 1;
        if (this.e >= 60) {
          this.e = 59;
        }
      }
    }
    else {
      this.e = 0;
    }
  }
  
  public void a()
  {
    this.g = false;
    StoryVideoUploadProgressManager.a(this.f).postDelayed(this.h, 200L);
  }
  
  public void b()
  {
    this.g = true;
    StoryVideoUploadProgressManager.a(this.f).removeCallbacks(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus
 * JD-Core Version:    0.7.0.1
 */