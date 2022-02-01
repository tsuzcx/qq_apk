package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class FullScreenInputHelper$9
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FullScreenInputHelper$9(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.a.Y.getLineCount() > 3) && (FullScreenInputHelper.g(this.a)) && (this.a.a()))
    {
      FullScreenInputHelper.a(this.a);
      return;
    }
    this.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.9
 * JD-Core Version:    0.7.0.1
 */