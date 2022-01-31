package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import tlo;
import tne;

public class WSVerticalItemVideoProgressController$1
  implements Runnable
{
  public WSVerticalItemVideoProgressController$1(tne paramtne) {}
  
  public void run()
  {
    try
    {
      if (tne.a(this.this$0) != null) {
        tne.a(this.this$0).setThumb(tne.a(this.this$0).getDrawable(2130841467));
      }
      return;
    }
    catch (Exception localException)
    {
      tlo.d("WS_VIDEO_seekBar", "seekBar un active runnable error:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1
 * JD-Core Version:    0.7.0.1
 */