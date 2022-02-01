package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class PhotoListCustomizationAIO$1
  implements Runnable
{
  PhotoListCustomizationAIO$1(PhotoListCustomizationAIO paramPhotoListCustomizationAIO, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.a) {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(PhotoListCustomizationAIO.a(this.this$0), this.b, this.c, PhotoListCustomizationAIO.b(this.this$0).b, ((PhotoOtherData)this.this$0.f).d, false);
    } else {
      PhotoUtils.sendPhoto(PhotoListCustomizationAIO.c(this.this$0), this.b, this.c, ((PhotoOtherData)this.this$0.f).d, PhotoListCustomizationAIO.d(this.this$0).a);
    }
    ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.d, 0, this.e, this.f, "", "");
    com.tencent.mobileqq.shortvideo.SVBusiUtil.c = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO.1
 * JD-Core Version:    0.7.0.1
 */