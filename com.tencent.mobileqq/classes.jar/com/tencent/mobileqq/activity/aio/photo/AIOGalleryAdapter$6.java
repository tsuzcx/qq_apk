package com.tencent.mobileqq.activity.aio.photo;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class AIOGalleryAdapter$6
  implements ITroopMemberApiClientApi.Callback
{
  AIOGalleryAdapter$6(AIOGalleryAdapter paramAIOGalleryAdapter, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIOImageData paramAIOImageData) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ThumbnailFile_Large");
    this.d.a.runOnUiThread(new AIOGalleryAdapter.6.1(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.6
 * JD-Core Version:    0.7.0.1
 */