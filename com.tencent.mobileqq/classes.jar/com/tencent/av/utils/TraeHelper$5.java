package com.tencent.av.utils;

import android.content.Context;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

class TraeHelper$5
  implements Runnable
{
  TraeHelper$5(TraeHelper paramTraeHelper, Button paramButton, Context paramContext) {}
  
  public void run()
  {
    VideoController localVideoController = this.this$0.d;
    if (localVideoController == null) {
      return;
    }
    this.this$0.n = 2;
    TraeHelper.5.1 local1 = new TraeHelper.5.1(this);
    localVideoController.aj().runOnUiThread(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5
 * JD-Core Version:    0.7.0.1
 */