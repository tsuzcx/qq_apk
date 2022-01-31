package com.tencent.av;

import android.content.Context;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.QLog;
import lfs;
import lid;

public class VideoController$AnyChatReqTimeoutRunnable
  implements Runnable
{
  public long a = 0L;
  
  VideoController$AnyChatReqTimeoutRunnable(VideoController paramVideoController) {}
  
  public void run()
  {
    try
    {
      if (!this.this$0.a().k())
      {
        if (QLog.isColorLevel()) {
          QLog.e(VideoController.a, 2, "AnyChatReqTimeoutRunnable show dialog!");
        }
        Context localContext = this.this$0.a();
        PopupDialog.b(localContext, 230, null, localContext.getString(2131721290), 0, 2131721323, new lfs(this), null);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.AnyChatReqTimeoutRunnable
 * JD-Core Version:    0.7.0.1
 */