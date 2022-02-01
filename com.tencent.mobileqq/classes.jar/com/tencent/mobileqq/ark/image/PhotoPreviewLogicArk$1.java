package com.tencent.mobileqq.ark.image;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Locale;

class PhotoPreviewLogicArk$1
  implements View.OnClickListener
{
  PhotoPreviewLogicArk$1(PhotoPreviewLogicArk paramPhotoPreviewLogicArk) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
    if (PhotoPreviewLogicArk.a(this.a).selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(PhotoPreviewLogicArk.b(this.a).selectedPhotoList.size() * 128);
        int i = 0;
        while (i < PhotoPreviewLogicArk.c(this.a).selectedPhotoList.size())
        {
          localStringBuilder.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), PhotoPreviewLogicArk.d(this.a).selectedPhotoList.get(i) }));
          i += 1;
        }
        QLog.d("PhotoPreviewLogicArk", 2, localStringBuilder.toString());
      }
      ThreadManagerV2.executeOnSubThread(new PhotoPreviewLogicArk.1.1(this));
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.a.mActivity).finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ChooseImageIPCModule.a().a("callbackArk", null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1
 * JD-Core Version:    0.7.0.1
 */