package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AlbumListCustomizationDefault$QZoneGetAlbumListNumObserver
  extends QZonePhotoObserver
{
  AlbumListCustomizationDefault$QZoneGetAlbumListNumObserver(AlbumListCustomizationDefault paramAlbumListCustomizationDefault) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      ((PhotoOtherData)AlbumListCustomizationDefault.a(this.a)).jdField_a_of_type_Long = l;
      paramBundle = this.a.a();
      if (paramBundle != null)
      {
        paramBundle.a(((PhotoOtherData)AlbumListCustomizationDefault.b(this.a)).jdField_a_of_type_Long);
        paramBundle.b();
      }
    }
    ((PhotoOtherData)AlbumListCustomizationDefault.c(this.a)).jdField_a_of_type_Boolean = true;
    MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault.QZoneGetAlbumListNumObserver
 * JD-Core Version:    0.7.0.1
 */