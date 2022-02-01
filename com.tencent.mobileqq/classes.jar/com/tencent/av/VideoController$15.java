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
    String str = this.this$0.e.a(this.this$0.k().p, String.valueOf(this.this$0.k().aN), null);
    Bitmap localBitmap = this.this$0.e.a(this.this$0.k().p, String.valueOf(this.this$0.k().aN), null, true, true);
    QAVNotification.a(this.this$0.e).a(this.this$0.k().f, str, localBitmap, String.valueOf(this.this$0.k().aN), 44, this.this$0.k().p, this.this$0.k().g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.15
 * JD-Core Version:    0.7.0.1
 */