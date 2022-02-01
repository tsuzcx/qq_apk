package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogic;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicDefault;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogic;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicAECircle;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicFileAssistant;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicFileAssistant;
import com.tencent.mobileqq.ark.image.AlbumListLogicArk;
import com.tencent.mobileqq.ark.image.PhotoListLogicArk;
import com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk;

public class PhotoLogicFactory
{
  public static AlbumListLogic a(int paramInt, AlbumListFragment paramAlbumListFragment)
  {
    switch (paramInt)
    {
    default: 
      return new AlbumListLogicDefault(paramAlbumListFragment);
    case 1: 
      return new AlbumListLogicAIO(paramAlbumListFragment);
    case 7: 
      return new AlbumListLogicQzone(paramAlbumListFragment);
    case 4: 
      return new AlbumListLogicMiniApp(paramAlbumListFragment);
    case 3: 
      return new AlbumListLogicArk(paramAlbumListFragment);
    }
    return new AlbumListLogicWeiyun(paramAlbumListFragment);
  }
  
  public static PhotoListLogic a(int paramInt, NewPhotoListActivity paramNewPhotoListActivity)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 42: 
    case 48: 
    case 49: 
    case 50: 
    case 52: 
    default: 
      return new PhotoListLogicDefault(paramNewPhotoListActivity);
    case 1: 
      return new PhotoListLogicAIO(paramNewPhotoListActivity);
    case 7: 
      return new PhotoListLogicQzone(paramNewPhotoListActivity);
    case 4: 
      return new PhotoListLogicMiniApp(paramNewPhotoListActivity);
    case 30: 
      return new PhotoListLogicNearby(paramNewPhotoListActivity);
    case 3: 
      return new PhotoListLogicArk(paramNewPhotoListActivity);
    case 2: 
      return new PhotoListLogicEmotion(paramNewPhotoListActivity);
    case 23: 
      return new PhotoListLogicAEPlay(paramNewPhotoListActivity);
    case 26: 
      return new PhotoListLogicAECamera(paramNewPhotoListActivity);
    case 29: 
      return new PhotoListLogicAECircle(paramNewPhotoListActivity);
    case 24: 
      return new PhotoListLogicTroopBarPublish(paramNewPhotoListActivity);
    case 25: 
      return new PhotoListLogicReadInJoy(paramNewPhotoListActivity);
    case 28: 
      return new PhotoListLogicWeiyun(paramNewPhotoListActivity);
    case 27: 
      return new PhotoListLogicTencentDocs(paramNewPhotoListActivity);
    case 40: 
      return new PhotoListLogicDataline(paramNewPhotoListActivity);
    case 51: 
      return new PhotoListLogicFileAssistant(paramNewPhotoListActivity);
    case 41: 
      return new PhotoListLogicTroopFile(paramNewPhotoListActivity);
    case 43: 
      return new PhotoListLogicFavourite(paramNewPhotoListActivity);
    case 44: 
      return new PhotoListLogicProfileCustomCover(paramNewPhotoListActivity);
    case 45: 
      return new PhotoListLogicScanEntry(paramNewPhotoListActivity);
    case 46: 
      return new PhotoListLogicHealthEntry(paramNewPhotoListActivity);
    case 47: 
      return new PhotoListLogicTroopHw(paramNewPhotoListActivity);
    case 53: 
      return new PhotoListLogicAECameraForCMShow(paramNewPhotoListActivity);
    }
    return new PhotoListLogicQcircle(paramNewPhotoListActivity);
  }
  
  public static PhotoPreviewLogic a(int paramInt, NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    switch (paramInt)
    {
    default: 
      return new PhotoPreviewLogicDefault(paramNewPhotoPreviewActivity);
    case 1: 
      return new PhotoPreviewLogicAIO(paramNewPhotoPreviewActivity);
    case 7: 
      return new PhotoPreviewLogicQzone(paramNewPhotoPreviewActivity);
    case 2: 
      return new PhotoPreviewLogicEmotion(paramNewPhotoPreviewActivity);
    case 23: 
      return new PhotoPreviewLogicAEPlay(paramNewPhotoPreviewActivity);
    case 24: 
      return new PhotoPreviewLogicTroopBarPublish(paramNewPhotoPreviewActivity);
    case 25: 
      return new PhotoPreviewLogicReadInJoy(paramNewPhotoPreviewActivity);
    case 3: 
      return new PhotoPreviewLogicArk(paramNewPhotoPreviewActivity);
    case 28: 
      return new PhotoPreviewLogicWeiyun(paramNewPhotoPreviewActivity);
    case 40: 
      return new PhotoPreviewLogicDataline(paramNewPhotoPreviewActivity);
    case 51: 
      return new PhotoPreviewLogicFileAssistant(paramNewPhotoPreviewActivity);
    case 42: 
      return new PhotoPreviewLogicAioLongShot(paramNewPhotoPreviewActivity);
    case 45: 
      return new PhotoPreviewLogicScanEntry(paramNewPhotoPreviewActivity);
    case 52: 
      return new PhotoPreviewLogicFastImage(paramNewPhotoPreviewActivity);
    case 29: 
      return new PhotoPreviewLogicAECircle(paramNewPhotoPreviewActivity);
    case 4: 
      return new PhotoPreviewLogicMiniApp(paramNewPhotoPreviewActivity);
    }
    return new PhotoPreviewLogicAECMShow(paramNewPhotoPreviewActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoLogicFactory
 * JD-Core Version:    0.7.0.1
 */