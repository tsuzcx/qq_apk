package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class VoiceChangeData$1
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = VoiceChangeData.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable|urldrawable load failed. url = ");
    localStringBuilder.append(this.c.b);
    AVLog.printErrorLog(paramURLDrawable, localStringBuilder.toString());
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = VoiceChangeData.a;
    paramThrowable = new StringBuilder();
    paramThrowable.append("getDrawable|urldrawable load failed. url = ");
    paramThrowable.append(this.c.b);
    AVLog.printErrorLog(paramURLDrawable, paramThrowable.toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeData.1
 * JD-Core Version:    0.7.0.1
 */