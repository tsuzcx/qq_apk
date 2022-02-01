package com.tencent.mobileqq.activity.aio.photo;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class AIOGalleryAdapter$4
  implements ITroopMemberApiClientApi.Callback
{
  AIOGalleryAdapter$4(AIOGalleryAdapter paramAIOGalleryAdapter, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIOImageData paramAIOImageData) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ThumbnailFile_Large");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a.runOnUiThread(new AIOGalleryAdapter.4.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.4
 * JD-Core Version:    0.7.0.1
 */