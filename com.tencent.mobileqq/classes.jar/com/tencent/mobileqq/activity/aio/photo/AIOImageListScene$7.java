package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageAdapter;

class AIOImageListScene$7
  implements Runnable
{
  AIOImageListScene$7(AIOImageListScene paramAIOImageListScene) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (!((AIOPhotoListAdapter)this.this$0.a).a(false))) {
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.7
 * JD-Core Version:    0.7.0.1
 */