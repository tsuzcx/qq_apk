package com.tencent.mobileqq.activity.aio.helper;

import android.content.ClipboardManager;
import com.tencent.widget.XEditTextEx.OnWindowFocusChangedListener;

class FullScreenInputHelper$6
  implements XEditTextEx.OnWindowFocusChangedListener
{
  FullScreenInputHelper$6(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a().addPrimaryClipChangedListener(FullScreenInputHelper.a(this.a));
      FullScreenInputHelper.c(this.a);
      return;
    }
    this.a.a().removePrimaryClipChangedListener(FullScreenInputHelper.a(this.a));
    FullScreenInputHelper.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.6
 * JD-Core Version:    0.7.0.1
 */