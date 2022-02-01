package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;

class WSVerticalItemVideoProgressController$1
  implements Runnable
{
  WSVerticalItemVideoProgressController$1(WSVerticalItemVideoProgressController paramWSVerticalItemVideoProgressController) {}
  
  public void run()
  {
    try
    {
      if (WSVerticalItemVideoProgressController.a(this.this$0) != null)
      {
        WSVerticalItemVideoProgressController.a(this.this$0).setThumb(WSVerticalItemVideoProgressController.b(this.this$0).getDrawable(2130842803));
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekBar un active runnable error:");
      localStringBuilder.append(localException);
      WSLog.d("WS_VIDEO_seekBar", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1
 * JD-Core Version:    0.7.0.1
 */