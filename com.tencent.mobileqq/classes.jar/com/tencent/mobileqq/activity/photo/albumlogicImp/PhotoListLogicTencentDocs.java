package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;

public class PhotoListLogicTencentDocs
  extends PhotoListLogicDefault
{
  PhotoListLogicTencentDocs(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    ((PhotoOtherData)this.mOtherCommonData).a = 6291456;
    paramIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicTencentDocs
 * JD-Core Version:    0.7.0.1
 */