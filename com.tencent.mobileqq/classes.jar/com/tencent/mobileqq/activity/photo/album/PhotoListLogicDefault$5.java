package com.tencent.mobileqq.activity.photo.album;

import aira;

public class PhotoListLogicDefault$5
  implements Runnable
{
  public PhotoListLogicDefault$5(aira paramaira) {}
  
  public void run()
  {
    if (((NewPhotoListActivity)this.this$0.mActivity).queryPhotoTask == null) {
      ((NewPhotoListActivity)this.this$0.mActivity).excuteQueryPhotoTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.5
 * JD-Core Version:    0.7.0.1
 */