package com.tencent.mobileqq.activity.aio.photo;

import android.net.Uri;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import java.io.File;
import java.util.ArrayList;

class AIOGalleryScene$15
  implements Runnable
{
  AIOGalleryScene$15(AIOGalleryScene paramAIOGalleryScene, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ZhuoXusManager.a().c()) {
      return;
    }
    if ((this.this$0.ae != null) && (this.this$0.ae.equals(this.a.getPath())))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file://");
      ((StringBuilder)localObject).append(this.a.getAbsolutePath());
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      AIOGalleryScene.a(this.this$0, (Uri)localObject, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.15
 * JD-Core Version:    0.7.0.1
 */