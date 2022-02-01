package com.tencent.mobileqq.activity.photo;

import ajob;
import android.graphics.Bitmap;
import android.os.Handler;
import ataw;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;

public class FileVideoMediaPlayHelper$3
  implements Runnable
{
  public FileVideoMediaPlayHelper$3(ajob paramajob, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = ataw.a(this.a);
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      ThreadManagerV2.getUIHandlerV2().post(new FileVideoMediaPlayHelper.3.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.3
 * JD-Core Version:    0.7.0.1
 */