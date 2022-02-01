package com.tencent.mobileqq.activity.aio;

import agej;
import agjg;
import android.view.View;
import blqv;
import com.tencent.widget.XListView;

class MediaPlayerManager$6
  implements Runnable
{
  MediaPlayerManager$6(MediaPlayerManager paramMediaPlayerManager, int paramInt) {}
  
  public void run()
  {
    agjg localagjg;
    float f;
    if (MediaPlayerManager.a(this.this$0) != null)
    {
      localagjg = MediaPlayerManager.a(this.this$0, MediaPlayerManager.a(this.this$0));
      long l = MediaPlayerManager.a(this.this$0).b();
      f = 0.0F;
      if (l > 0L) {
        f = this.a / (float)l;
      }
      if (MediaPlayerManager.a(this.this$0) != null) {
        break label100;
      }
      if (localagjg != null) {
        localagjg.a(MediaPlayerManager.a(this.this$0), -1, null, MediaPlayerManager.a(this.this$0), this.a, f);
      }
    }
    label100:
    int i;
    do
    {
      return;
      i = MediaPlayerManager.a(MediaPlayerManager.a(this.this$0), MediaPlayerManager.a(this.this$0));
    } while (i > MediaPlayerManager.a(this.this$0).getCount());
    View localView = agej.a(MediaPlayerManager.a(this.this$0), MediaPlayerManager.a(this.this$0).getHeaderViewsCount() + i);
    localagjg.a(MediaPlayerManager.a(this.this$0), i, localView, MediaPlayerManager.a(this.this$0), this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager.6
 * JD-Core Version:    0.7.0.1
 */