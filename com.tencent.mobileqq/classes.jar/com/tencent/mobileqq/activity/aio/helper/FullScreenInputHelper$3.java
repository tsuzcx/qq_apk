package com.tencent.mobileqq.activity.aio.helper;

import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class FullScreenInputHelper$3
  implements Runnable
{
  FullScreenInputHelper$3(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public void run()
  {
    if (this.this$0.a.Y.getLineCount() > 3)
    {
      FullScreenInputHelper.a(this.this$0);
      return;
    }
    this.this$0.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.3
 * JD-Core Version:    0.7.0.1
 */