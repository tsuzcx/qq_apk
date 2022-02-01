package com.tencent.mobileqq.activity.aio.helper;

import afqj;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class FullScreenInputHelper$3
  implements Runnable
{
  public FullScreenInputHelper$3(afqj paramafqj) {}
  
  public void run()
  {
    if (afqj.a(this.this$0).input.getLineCount() > 3)
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