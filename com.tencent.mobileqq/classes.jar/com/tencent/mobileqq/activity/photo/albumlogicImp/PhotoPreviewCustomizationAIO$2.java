package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;
import java.util.ArrayList;

class PhotoPreviewCustomizationAIO$2
  implements Runnable
{
  PhotoPreviewCustomizationAIO$2(PhotoPreviewCustomizationAIO paramPhotoPreviewCustomizationAIO, boolean paramBoolean, Intent paramIntent, Pair paramPair, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.a)
    {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(PhotoPreviewCustomizationAIO.a(this.this$0), this.b, (ArrayList)this.c.first, PhotoPreviewCustomizationAIO.b(this.this$0).b, ((PhotoOtherData)this.this$0.g).d, true);
      PhotoPreviewCustomizationAIO.c(this.this$0).setResult(-1);
      PhotoPreviewCustomizationAIO.d(this.this$0).finish();
    }
    else
    {
      PhotoUtils.sendPhoto(PhotoPreviewCustomizationAIO.e(this.this$0), this.b, (ArrayList)this.c.first, ((PhotoOtherData)this.this$0.g).d, PhotoPreviewCustomizationAIO.f(this.this$0).e);
    }
    ReportController.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.d, 0, this.e, this.f, "", "");
    com.tencent.mobileqq.shortvideo.SVBusiUtil.c = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.2
 * JD-Core Version:    0.7.0.1
 */