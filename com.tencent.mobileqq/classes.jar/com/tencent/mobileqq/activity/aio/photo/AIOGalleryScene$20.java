package com.tencent.mobileqq.activity.aio.photo;

import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class AIOGalleryScene$20
  implements Runnable
{
  AIOGalleryScene$20(AIOGalleryScene paramAIOGalleryScene, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file://");
        ((StringBuilder)localObject).append(this.a.getAbsolutePath());
        localObject = Uri.parse(((StringBuilder)localObject).toString());
        AIOGalleryScene.a(this.this$0, (Uri)localObject, this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add qr action sheet error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.i("AIOGalleryScene", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.20
 * JD-Core Version:    0.7.0.1
 */