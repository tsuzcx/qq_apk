package com.tencent.mobileqq.activity.photo.album;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class QZonePhotoObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1002) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QZonePhotoObserver
 * JD-Core Version:    0.7.0.1
 */