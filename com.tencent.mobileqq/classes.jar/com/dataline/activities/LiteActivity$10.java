package com.dataline.activities;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.widget.XEditTextEx;

class LiteActivity$10
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  LiteActivity$10(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.q.getLineCount() > 3) && (!LiteActivity.c(this.a)) && (!SimpleUIUtil.e()))
    {
      this.a.I.setVisibility(0);
      return;
    }
    this.a.I.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.10
 * JD-Core Version:    0.7.0.1
 */