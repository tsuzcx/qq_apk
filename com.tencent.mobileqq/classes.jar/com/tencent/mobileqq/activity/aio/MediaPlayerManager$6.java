package com.tencent.mobileqq.activity.aio;

import android.view.View;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XListView;

class MediaPlayerManager$6
  implements Runnable
{
  MediaPlayerManager$6(MediaPlayerManager paramMediaPlayerManager, int paramInt) {}
  
  public void run()
  {
    if (MediaPlayerManager.a(this.this$0) != null)
    {
      Object localObject = this.this$0;
      localObject = MediaPlayerManager.a((MediaPlayerManager)localObject, MediaPlayerManager.a((MediaPlayerManager)localObject));
      long l = MediaPlayerManager.a(this.this$0).a();
      float f;
      if (l > 0L) {
        f = this.a / (float)l;
      } else {
        f = 0.0F;
      }
      if (MediaPlayerManager.a(this.this$0) == null)
      {
        if (localObject != null) {
          ((MediaPlayerManager.Callback)localObject).a(MediaPlayerManager.a(this.this$0), -1, null, MediaPlayerManager.a(this.this$0), this.a, f);
        }
      }
      else
      {
        int i = MediaPlayerManager.a(MediaPlayerManager.a(this.this$0), MediaPlayerManager.a(this.this$0));
        if (i <= MediaPlayerManager.a(this.this$0).getCount())
        {
          View localView = AIOUtils.a(MediaPlayerManager.a(this.this$0), MediaPlayerManager.a(this.this$0).getHeaderViewsCount() + i);
          ((MediaPlayerManager.Callback)localObject).a(MediaPlayerManager.a(this.this$0), i, localView, MediaPlayerManager.a(this.this$0), this.a, f);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager.6
 * JD-Core Version:    0.7.0.1
 */