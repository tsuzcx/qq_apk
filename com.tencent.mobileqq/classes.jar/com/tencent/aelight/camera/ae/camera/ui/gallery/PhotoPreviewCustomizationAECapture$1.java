package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class PhotoPreviewCustomizationAECapture$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationAECapture$1(PhotoPreviewCustomizationAECapture paramPhotoPreviewCustomizationAECapture) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewCustomizationAECapture.a(this.a))
    {
      QLog.d(PhotoPreviewCustomizationAECapture.b, 2, "need more pic.");
      paramView = this.a;
      PhotoPreviewCustomizationAECapture.a(paramView, String.format(PhotoPreviewCustomizationAECapture.a(paramView).getString(2064515215), new Object[] { Integer.valueOf(this.a.a.maxSelectNum) }));
      return;
    }
    if (!NetworkUtils.a(PhotoPreviewCustomizationAECapture.b(this.a)))
    {
      paramView = this.a;
      PhotoPreviewCustomizationAECapture.a(paramView, PhotoPreviewCustomizationAECapture.c(paramView).getString(2064515092));
      return;
    }
    paramView = (String)this.a.a.selectedPhotoList.get(0);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.a.a.allMediaInfoHashMap.get(paramView);
    if ((PhotoPreviewCustomizationAECapture.a(this.a) > 0) && (PhotoPreviewCustomizationAECapture.b(this.a) > 0) && (localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth < PhotoPreviewCustomizationAECapture.a(this.a)) || (localLocalMediaInfo.mediaHeight < PhotoPreviewCustomizationAECapture.b(this.a))))
    {
      paramView = this.a;
      PhotoPreviewCustomizationAECapture.a(paramView, String.format(PhotoPreviewCustomizationAECapture.d(paramView).getString(2064515090), new Object[] { Integer.valueOf(PhotoPreviewCustomizationAECapture.a(this.a)), Integer.valueOf(PhotoPreviewCustomizationAECapture.b(this.a)) }));
      return;
    }
    if (PhotoPreviewCustomizationAECapture.a(this.a, paramView, localLocalMediaInfo))
    {
      paramView = this.a;
      PhotoPreviewCustomizationAECapture.a(paramView, PhotoPreviewCustomizationAECapture.e(paramView).getString(2064515091));
      return;
    }
    PhotoPreviewCustomizationAECapture.b(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture.1
 * JD-Core Version:    0.7.0.1
 */