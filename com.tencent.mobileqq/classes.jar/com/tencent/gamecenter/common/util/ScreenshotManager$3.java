package com.tencent.gamecenter.common.util;

import aadi;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class ScreenshotManager$3
  implements Runnable
{
  public ScreenshotManager$3(aadi paramaadi, WebView paramWebView) {}
  
  public void run()
  {
    QLog.i("ScreenshotManager", 1, "addMaskAsync mRemoveCall=" + aadi.a(this.this$0));
    if ((aadi.a(this.this$0) != null) && (!aadi.a(this.this$0))) {}
    try
    {
      if (aadi.a(this.this$0) == null)
      {
        aadi.a(this.this$0, new ImageView(this.a.getContext()));
        aadi.a(this.this$0).setScaleType(ImageView.ScaleType.FIT_XY);
      }
      aadi.a(this.this$0).setImageBitmap(aadi.a(this.this$0));
      this.this$0.a();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ((ViewGroup)this.a.getParent()).addView(aadi.a(this.this$0), localLayoutParams);
      aadi.a(this.this$0).setVisibility(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScreenshotManager", 1, "addMaskAsync e=" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.3
 * JD-Core Version:    0.7.0.1
 */