package com.tencent.mobileqq.activity.aio.photo;

import adxg;
import adxv;
import com.tencent.common.galleryactivity.AbstractImageAdapter;

public class AIOImageListScene$7
  implements Runnable
{
  public AIOImageListScene$7(adxg paramadxg) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (!((adxv)this.this$0.a).a(false))) {
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.7
 * JD-Core Version:    0.7.0.1
 */