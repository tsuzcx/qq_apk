package com.tencent.av;

import android.graphics.Bitmap;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;

class VideoController$15
  implements Runnable
{
  VideoController$15(VideoController paramVideoController) {}
  
  public void run()
  {
    String str = this.this$0.a.a(this.this$0.a().k, String.valueOf(this.this$0.a().f), null);
    Bitmap localBitmap = this.this$0.a.a(this.this$0.a().k, String.valueOf(this.this$0.a().f), null, true, true);
    QAVNotification.a(this.this$0.a).a(this.this$0.a().b, str, localBitmap, String.valueOf(this.this$0.a().f), 44, this.this$0.a().k, this.this$0.a().d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.15
 * JD-Core Version:    0.7.0.1
 */