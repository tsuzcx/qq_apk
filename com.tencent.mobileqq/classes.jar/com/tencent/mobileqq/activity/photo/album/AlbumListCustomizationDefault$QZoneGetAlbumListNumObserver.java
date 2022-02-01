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
      ((PhotoOtherData)AlbumListCustomizationDefault.a(this.a)).b = l;
      paramBundle = this.a.d();
      if (paramBundle != null)
      {
        paramBundle.a(((PhotoOtherData)AlbumListCustomizationDefault.b(this.a)).b);
        paramBundle.c();
      }
    }
    ((PhotoOtherData)AlbumListCustomizationDefault.c(this.a)).c = true;
    MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this.a.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault.QZoneGetAlbumListNumObserver
 * JD-Core Version:    0.7.0.1
 */