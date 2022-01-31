package com.tencent.mobileqq.activity.aio.photo;

import aget;
import agfi;
import com.tencent.common.galleryactivity.AbstractImageAdapter;

public class AIOImageListScene$7
  implements Runnable
{
  public AIOImageListScene$7(aget paramaget) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (!((agfi)this.this$0.a).a(false))) {
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.7
 * JD-Core Version:    0.7.0.1
 */