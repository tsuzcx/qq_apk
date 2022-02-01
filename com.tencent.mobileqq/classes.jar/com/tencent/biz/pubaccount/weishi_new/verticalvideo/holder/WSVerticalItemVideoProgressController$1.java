package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import uqf;
import uuq;

public class WSVerticalItemVideoProgressController$1
  implements Runnable
{
  public WSVerticalItemVideoProgressController$1(uuq paramuuq) {}
  
  public void run()
  {
    try
    {
      if (uuq.a(this.this$0) != null) {
        uuq.a(this.this$0).setThumb(uuq.a(this.this$0).getDrawable(2130841791));
      }
      return;
    }
    catch (Exception localException)
    {
      uqf.d("WS_VIDEO_seekBar", "seekBar un active runnable error:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1
 * JD-Core Version:    0.7.0.1
 */