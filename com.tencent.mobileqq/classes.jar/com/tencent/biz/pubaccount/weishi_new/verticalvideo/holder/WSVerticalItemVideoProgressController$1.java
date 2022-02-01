package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import uya;
import vcl;

public class WSVerticalItemVideoProgressController$1
  implements Runnable
{
  public WSVerticalItemVideoProgressController$1(vcl paramvcl) {}
  
  public void run()
  {
    try
    {
      if (vcl.a(this.this$0) != null) {
        vcl.a(this.this$0).setThumb(vcl.a(this.this$0).getDrawable(2130841833));
      }
      return;
    }
    catch (Exception localException)
    {
      uya.d("WS_VIDEO_seekBar", "seekBar un active runnable error:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1
 * JD-Core Version:    0.7.0.1
 */