package com.tencent.av;

import android.graphics.Bitmap;
import com.tencent.av.app.VideoAppInterface;
import lfe;
import mtt;

class VideoController$13
  implements Runnable
{
  VideoController$13(VideoController paramVideoController) {}
  
  public void run()
  {
    String str = this.this$0.a.getDisplayName(this.this$0.a().j, String.valueOf(this.this$0.a().g), null);
    Bitmap localBitmap = this.this$0.a.a(this.this$0.a().j, String.valueOf(this.this$0.a().g), null, true, true);
    mtt.a(this.this$0.a).a(this.this$0.a().c, str, localBitmap, String.valueOf(this.this$0.a().g), 44, this.this$0.a().j, this.this$0.a().d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.13
 * JD-Core Version:    0.7.0.1
 */