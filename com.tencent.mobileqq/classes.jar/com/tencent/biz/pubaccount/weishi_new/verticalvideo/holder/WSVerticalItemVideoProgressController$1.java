package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import vmp;
import vrf;

public class WSVerticalItemVideoProgressController$1
  implements Runnable
{
  public WSVerticalItemVideoProgressController$1(vrf paramvrf) {}
  
  public void run()
  {
    try
    {
      if (vrf.a(this.this$0) != null) {
        vrf.a(this.this$0).setThumb(vrf.a(this.this$0).getDrawable(2130841846));
      }
      return;
    }
    catch (Exception localException)
    {
      vmp.d("WS_VIDEO_seekBar", "seekBar un active runnable error:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1
 * JD-Core Version:    0.7.0.1
 */