package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Locale;

class PhotoPreviewCustomizationArk$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationArk$1(PhotoPreviewCustomizationArk paramPhotoPreviewCustomizationArk) {}
  
  public void onClick(View paramView)
  {
    this.a.s().l.setClickable(false);
    if (this.a.f.selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(this.a.f.selectedPhotoList.size() * 128);
        int i = 0;
        while (i < this.a.f.selectedPhotoList.size())
        {
          localStringBuilder.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), this.a.f.selectedPhotoList.get(i) }));
          i += 1;
        }
        QLog.d("PhotoPreviewCustomizationArk", 2, localStringBuilder.toString());
      }
      ThreadManagerV2.executeOnSubThread(new PhotoPreviewCustomizationArk.1.1(this));
    }
    else
    {
      ChooseImageIPCModule.a().a("callbackArk", null, null);
    }
    PhotoPreviewCustomizationArk.d(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk.1
 * JD-Core Version:    0.7.0.1
 */