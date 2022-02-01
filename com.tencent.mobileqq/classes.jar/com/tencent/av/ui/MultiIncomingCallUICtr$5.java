package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;

class MultiIncomingCallUICtr$5
  implements Runnable
{
  MultiIncomingCallUICtr$5(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  public void run()
  {
    String str = UITools.a(this.this$0.D.z());
    if (this.this$0.o != null)
    {
      this.this$0.o.a(str);
      if (this.this$0.D.z() % 60L >= 1L)
      {
        this.this$0.o.a();
        this.this$0.a();
        return;
      }
      this.this$0.c.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.5
 * JD-Core Version:    0.7.0.1
 */