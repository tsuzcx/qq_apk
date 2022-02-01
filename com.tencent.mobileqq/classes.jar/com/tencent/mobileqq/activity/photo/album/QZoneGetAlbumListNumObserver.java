package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QZoneGetAlbumListNumObserver
  extends QZonePhotoObserver
{
  private WeakReference<PhotoOtherData> a;
  
  public QZoneGetAlbumListNumObserver(PhotoOtherData paramPhotoOtherData)
  {
    this.a = new WeakReference(paramPhotoOtherData);
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
      {
        ((PhotoOtherData)this.a.get()).jdField_a_of_type_Long = ((get_albumlist_num_rsp)paramBundle).album_num;
        ((PhotoOtherData)this.a.get()).jdField_a_of_type_Boolean = true;
      }
      MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this);
      this.a.clear();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QZoneGetAlbumListNumObserver
 * JD-Core Version:    0.7.0.1
 */