package com.tencent.mobileqq.activity.aio.helper;

import aght;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class FullScreenInputHelper$3
  implements Runnable
{
  public FullScreenInputHelper$3(aght paramaght) {}
  
  public void run()
  {
    if (aght.a(this.this$0).input.getLineCount() > 3)
    {
      this.this$0.a.setVisibility(0);
      return;
    }
    this.this$0.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.3
 * JD-Core Version:    0.7.0.1
 */