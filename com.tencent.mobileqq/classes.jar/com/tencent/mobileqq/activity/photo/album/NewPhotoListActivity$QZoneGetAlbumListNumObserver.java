package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.observer.QZoneObserver;
import mqq.app.AppRuntime;

class NewPhotoListActivity$QZoneGetAlbumListNumObserver
  extends QZoneObserver
{
  NewPhotoListActivity$QZoneGetAlbumListNumObserver(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onGetQZoneAlbumListNum(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp))) {
      ((PhotoOtherData)this.a.mPhotoListLogic.mOtherCommonData).a = ((get_albumlist_num_rsp)paramBundle).album_num;
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity.QZoneGetAlbumListNumObserver
 * JD-Core Version:    0.7.0.1
 */