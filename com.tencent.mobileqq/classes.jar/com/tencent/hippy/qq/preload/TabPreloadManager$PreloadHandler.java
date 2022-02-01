package com.tencent.hippy.qq.preload;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.app.MobileQQ;

public class TabPreloadManager$PreloadHandler
  extends Handler
{
  public TabPreloadManager$PreloadHandler(TabPreloadManager paramTabPreloadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.this$0.onPreload();
      return;
    }
    TabPreloadManager.access$500(this.this$0, (String)paramMessage.obj);
    if (MobileQQ.sProcessId == 1) {
      this.this$0.checkForToolProcess((String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.TabPreloadManager.PreloadHandler
 * JD-Core Version:    0.7.0.1
 */