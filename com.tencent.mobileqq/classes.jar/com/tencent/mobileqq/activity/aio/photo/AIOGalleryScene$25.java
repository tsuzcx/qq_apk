package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.Locale;

class AIOGalleryScene$25
  implements AIOGalleryAdapter.OnTroopThumbListener
{
  AIOGalleryScene$25(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void a(AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    if ((this.a.c.c() != null) && ((this.a.c.c().a instanceof AIOImageData)))
    {
      AIOImageData localAIOImageData = (AIOImageData)this.a.c.c().a;
      if ((!paramBoolean) && (TextUtils.equals(localAIOImageData.w, paramAIOImageData.w)))
      {
        if (localAIOImageData.O > 0L) {
          this.a.f.setText(String.format(Locale.CHINA, AIOGalleryScene.O(this.a).getString(2131892727), new Object[] { FileUtil.a(localAIOImageData.O) }));
        } else {
          this.a.f.setText(2131892724);
        }
        this.a.d(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.25
 * JD-Core Version:    0.7.0.1
 */