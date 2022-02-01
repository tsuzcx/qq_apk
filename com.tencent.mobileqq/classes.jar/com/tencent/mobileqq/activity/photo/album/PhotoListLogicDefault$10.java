package com.tencent.mobileqq.activity.photo.album;

import aktf;
import android.support.v7.widget.GridLayoutManager;

public class PhotoListLogicDefault$10
  implements Runnable
{
  public PhotoListLogicDefault$10(aktf paramaktf, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mActivity != null) {
      ((NewPhotoListActivity)this.this$0.mActivity).gridLayoutManager.scrollToPositionWithOffset(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.10
 * JD-Core Version:    0.7.0.1
 */