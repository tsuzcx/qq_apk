package com.tencent.mobileqq.activity.photo.album;

class PhotoListLogicBase$1
  implements Runnable
{
  PhotoListLogicBase$1(PhotoListLogicBase paramPhotoListLogicBase) {}
  
  public void run()
  {
    if (this.this$0.mActivity.queryPhotoTask == null) {
      this.this$0.mActivity.excuteQueryPhotoTask(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase.1
 * JD-Core Version:    0.7.0.1
 */