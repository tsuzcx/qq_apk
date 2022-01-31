package com.tencent.mobileqq.activity.aio;

import actj;
import acxf;
import android.view.View;
import bfxe;
import com.tencent.widget.XListView;

class MediaPlayerManager$6
  implements Runnable
{
  MediaPlayerManager$6(MediaPlayerManager paramMediaPlayerManager, int paramInt) {}
  
  public void run()
  {
    acxf localacxf;
    float f;
    if (MediaPlayerManager.a(this.this$0) != null)
    {
      localacxf = MediaPlayerManager.a(this.this$0, MediaPlayerManager.a(this.this$0));
      long l = MediaPlayerManager.a(this.this$0).a();
      f = 0.0F;
      if (l > 0L) {
        f = this.a / (float)l;
      }
      if (MediaPlayerManager.a(this.this$0) != null) {
        break label100;
      }
      if (localacxf != null) {
        localacxf.a(MediaPlayerManager.a(this.this$0), -1, null, MediaPlayerManager.a(this.this$0), this.a, f);
      }
    }
    label100:
    int i;
    do
    {
      return;
      i = MediaPlayerManager.a(MediaPlayerManager.a(this.this$0), MediaPlayerManager.a(this.this$0));
    } while (i > MediaPlayerManager.a(this.this$0).getCount());
    View localView = actj.a(MediaPlayerManager.a(this.this$0), MediaPlayerManager.a(this.this$0).getHeaderViewsCount() + i);
    localacxf.a(MediaPlayerManager.a(this.this$0), i, localView, MediaPlayerManager.a(this.this$0), this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager.6
 * JD-Core Version:    0.7.0.1
 */