package com.tencent.mobileqq.activity.photo.album.logicImp;

import aitc;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class PhotoListLogicWeiyun$1
  implements Runnable
{
  public PhotoListLogicWeiyun$1(aitc paramaitc, NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void run()
  {
    if (this.a.queryPhotoTask == null) {
      this.a.excuteQueryPhotoTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicWeiyun.1
 * JD-Core Version:    0.7.0.1
 */