package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.observer.QZoneObserver;
import mqq.app.AppRuntime;

class AlbumListLogicDefault$QZoneGetAlbumListNumObserver
  extends QZoneObserver
{
  AlbumListLogicDefault$QZoneGetAlbumListNumObserver(AlbumListLogicDefault paramAlbumListLogicDefault) {}
  
  public void onGetQZoneAlbumListNum(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      ((PhotoOtherData)this.a.mOtherCommonData).jdField_a_of_type_Long = l;
      paramBundle = this.a.a();
      if (paramBundle != null)
      {
        paramBundle.a(((PhotoOtherData)this.a.mOtherCommonData).jdField_a_of_type_Long);
        paramBundle.postData();
      }
    }
    ((PhotoOtherData)this.a.mOtherCommonData).jdField_a_of_type_Boolean = false;
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogicDefault.QZoneGetAlbumListNumObserver
 * JD-Core Version:    0.7.0.1
 */