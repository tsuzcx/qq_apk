package com.tencent.av;

import android.graphics.Bitmap;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;

class VideoController$14
  implements Runnable
{
  VideoController$14(VideoController paramVideoController, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.e.a(3000, this.a, null, true, true);
    String str = this.this$0.e.a(1004, this.b, this.a);
    QAVNotification.a(this.this$0.e).a(this.c, str, localBitmap, this.a, 57, 3000, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.14
 * JD-Core Version:    0.7.0.1
 */