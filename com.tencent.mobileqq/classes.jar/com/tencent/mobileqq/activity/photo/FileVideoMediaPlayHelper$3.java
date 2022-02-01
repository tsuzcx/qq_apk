package com.tencent.mobileqq.activity.photo;

import akqc;
import android.graphics.Bitmap;
import android.os.Handler;
import auoo;
import bhmi;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class FileVideoMediaPlayHelper$3
  implements Runnable
{
  public FileVideoMediaPlayHelper$3(akqc paramakqc, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = auoo.a(this.a);
    if (bhmi.b(str)) {
      ThreadManagerV2.getUIHandlerV2().post(new FileVideoMediaPlayHelper.3.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.3
 * JD-Core Version:    0.7.0.1
 */