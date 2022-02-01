package com.tencent.av.utils;

import android.content.Context;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mua;

public class TraeHelper$5
  implements Runnable
{
  public TraeHelper$5(mua parammua, Button paramButton, Context paramContext) {}
  
  public void run()
  {
    VideoController localVideoController = this.this$0.a;
    if (localVideoController == null) {
      return;
    }
    this.this$0.d = 2;
    TraeHelper.5.1 local1 = new TraeHelper.5.1(this);
    localVideoController.a().runOnUiThread(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5
 * JD-Core Version:    0.7.0.1
 */