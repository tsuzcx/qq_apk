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
      PhotoPreviewCustomizationAECapture.a(paramView, String.format(PhotoPreviewCustomizationAECapture.b(paramView).getString(2064187562), new Object[] { Integer.valueOf(this.a.f.maxSelectNum) }));
      return;
    }
    if (!NetworkUtils.a(PhotoPreviewCustomizationAECapture.c(this.a)))
    {
      paramView = this.a;
      PhotoPreviewCustomizationAECapture.a(paramView, PhotoPreviewCustomizationAECapture.d(paramView).getString(2064187422));
      return;
    }
    paramView = (String)this.a.f.selectedPhotoList.get(0);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.a.f.allMediaInfoHashMap.get(paramView);
    if ((PhotoPreviewCustomizationAECapture.e(this.a) > 0) && (PhotoPreviewCustomizationAECapture.f(this.a) > 0) && (localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth < PhotoPreviewCustomizationAECapture.e(this.a)) || (localLocalMediaInfo.mediaHeight < PhotoPreviewCustomizationAECapture.f(this.a))))
    {
      paramView = this.a;
      PhotoPreviewCustomizationAECapture.a(paramView, String.format(PhotoPreviewCustomizationAECapture.g(paramView).getString(2064187420), new Object[] { Integer.valueOf(PhotoPreviewCustomizationAECapture.e(this.a)), Integer.valueOf(PhotoPreviewCustomizationAECapture.f(this.a)) }));
      return;
    }
    if (PhotoPreviewCustomizationAECapture.a(this.a, paramView, localLocalMediaInfo))
    {
      paramView = this.a;
      PhotoPreviewCustomizationAECapture.a(paramView, PhotoPreviewCustomizationAECapture.h(paramView).getString(2064187421));
      return;
    }
    PhotoPreviewCustomizationAECapture.b(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture.1
 * JD-Core Version:    0.7.0.1
 */