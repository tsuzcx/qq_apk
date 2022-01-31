package com.tencent.mobileqq.activity.photo;

import aiji;
import android.graphics.Bitmap;
import android.os.Handler;
import aroo;
import bdcs;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class FileVideoMediaPlayHelper$3
  implements Runnable
{
  public FileVideoMediaPlayHelper$3(aiji paramaiji, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = aroo.a(this.a);
    if (bdcs.b(str)) {
      ThreadManagerV2.getUIHandlerV2().post(new FileVideoMediaPlayHelper.3.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.3
 * JD-Core Version:    0.7.0.1
 */