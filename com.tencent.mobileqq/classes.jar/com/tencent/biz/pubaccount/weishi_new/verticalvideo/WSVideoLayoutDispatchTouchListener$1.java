package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

class WSVideoLayoutDispatchTouchListener$1
  implements Runnable
{
  WSVideoLayoutDispatchTouchListener$1(WSVideoLayoutDispatchTouchListener paramWSVideoLayoutDispatchTouchListener) {}
  
  public void run()
  {
    try
    {
      if (WSVideoLayoutDispatchTouchListener.a(this.this$0) != null)
      {
        WSPlayerControlBar localWSPlayerControlBar = (WSPlayerControlBar)WSVideoLayoutDispatchTouchListener.a(this.this$0).get();
        if (localWSPlayerControlBar != null)
        {
          localWSPlayerControlBar.setThumb(BaseApplicationImpl.getContext().getResources().getDrawable(2130842803));
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekBar un active runnable error:");
      localStringBuilder.append(localException);
      WSLog.d("WSVideoLayoutDispatchTouchListener", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVideoLayoutDispatchTouchListener.1
 * JD-Core Version:    0.7.0.1
 */