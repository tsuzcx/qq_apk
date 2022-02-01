package com.tencent.mobileqq.activity.aio.photo;

import android.widget.SeekBar;
import android.widget.TextView;

class AIOGalleryScene$4
  implements Runnable
{
  AIOGalleryScene$4(AIOGalleryScene paramAIOGalleryScene, long paramLong, float paramFloat, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.c.c();
    if (localObject != null)
    {
      if (((AIORichMediaInfo)localObject).a.L != this.a) {
        return;
      }
      if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = (AIOFileVideoData)((AIORichMediaInfo)localObject).a;
        ((AIOFileVideoData)localObject).n = (((float)((AIOFileVideoData)localObject).O * this.b));
      }
      this.this$0.d(false);
      this.this$0.c(true);
      this.this$0.j.setText(this.c);
      int i = (int)(this.b * 10000.0F);
      this.this$0.l.setProgress(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.4
 * JD-Core Version:    0.7.0.1
 */