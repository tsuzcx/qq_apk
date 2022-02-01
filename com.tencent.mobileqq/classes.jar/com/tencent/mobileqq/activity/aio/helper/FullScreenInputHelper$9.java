package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.widget.XEditTextEx;

class FullScreenInputHelper$9
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FullScreenInputHelper$9(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public void onGlobalLayout()
  {
    if ((FullScreenInputHelper.a(this.a).a.getLineCount() > 3) && (FullScreenInputHelper.a(this.a)) && (this.a.a()) && (!SimpleUIUtil.a()))
    {
      this.a.a.setVisibility(0);
      return;
    }
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.9
 * JD-Core Version:    0.7.0.1
 */