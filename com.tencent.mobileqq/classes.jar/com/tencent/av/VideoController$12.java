package com.tencent.av;

import android.graphics.Bitmap;
import com.tencent.av.app.VideoAppInterface;
import mvj;

class VideoController$12
  implements Runnable
{
  VideoController$12(VideoController paramVideoController, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a.a(3000, this.a, null, true, true);
    String str = this.this$0.a.getDisplayName(1004, this.b, this.a);
    mvj.a(this.this$0.a).a(this.c, str, localBitmap, this.a, 57, 3000, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.12
 * JD-Core Version:    0.7.0.1
 */