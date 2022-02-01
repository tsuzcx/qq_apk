package com.tencent.gamecenter.common.util;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class ScreenshotManager$3
  implements Runnable
{
  ScreenshotManager$3(ScreenshotManager paramScreenshotManager, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addMaskAsync mRemoveCall=");
    ((StringBuilder)localObject).append(ScreenshotManager.b(this.this$0));
    QLog.i("ScreenshotManager", 1, ((StringBuilder)localObject).toString());
    if ((ScreenshotManager.a(this.this$0) != null) && (!ScreenshotManager.b(this.this$0))) {
      try
      {
        if (ScreenshotManager.c(this.this$0) == null)
        {
          ScreenshotManager.a(this.this$0, new ImageView(this.a.getContext()));
          ScreenshotManager.c(this.this$0).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        ScreenshotManager.c(this.this$0).setImageBitmap(ScreenshotManager.a(this.this$0));
        this.this$0.b();
        localObject = new FrameLayout.LayoutParams(-1, -1);
        ((ViewGroup)this.a.getParent()).addView(ScreenshotManager.c(this.this$0), (ViewGroup.LayoutParams)localObject);
        ScreenshotManager.c(this.this$0).setVisibility(0);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMaskAsync e=");
        localStringBuilder.append(localThrowable.toString());
        QLog.e("ScreenshotManager", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.3
 * JD-Core Version:    0.7.0.1
 */