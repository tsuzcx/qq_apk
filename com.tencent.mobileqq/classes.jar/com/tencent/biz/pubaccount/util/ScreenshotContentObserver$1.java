package com.tencent.biz.pubaccount.util;

import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class ScreenshotContentObserver$1
  extends FileObserver
{
  ScreenshotContentObserver$1(ScreenshotContentObserver paramScreenshotContentObserver, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEvent->time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(", path:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ScreenshotContentObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt != 256) {
        return;
      }
      if (!paramString.equalsIgnoreCase(ScreenshotContentObserver.a(this.b)))
      {
        if (paramString.contains("temp")) {
          return;
        }
        if (ScreenshotContentObserver.b(this.b) != null)
        {
          localObject = ScreenshotContentObserver.b(this.b);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append(paramString);
          ((ScreenshotContentObserver.Listener)localObject).a(null, localStringBuilder.toString(), 1);
          ScreenshotContentObserver.a(this.b, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ScreenshotContentObserver.1
 * JD-Core Version:    0.7.0.1
 */