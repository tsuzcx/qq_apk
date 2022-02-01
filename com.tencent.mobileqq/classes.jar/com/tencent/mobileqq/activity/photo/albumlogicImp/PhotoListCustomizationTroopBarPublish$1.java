package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class PhotoListCustomizationTroopBarPublish$1
  implements MediaScanner.OnMediaInfoScannerListener
{
  PhotoListCustomizationTroopBarPublish$1(PhotoListCustomizationTroopBarPublish paramPhotoListCustomizationTroopBarPublish, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    PhotoListCustomizationTroopBarPublish.a(this.c).u.b();
    if (((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).isValidMedia(PhotoListCustomizationTroopBarPublish.b(this.c), paramLocalMediaInfo))
    {
      this.a.putExtra("media_info", paramLocalMediaInfo);
      PhotoUtils.sendPhoto(PhotoListCustomizationTroopBarPublish.c(this.c), this.a, this.b, 2, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopBarPublish.1
 * JD-Core Version:    0.7.0.1
 */