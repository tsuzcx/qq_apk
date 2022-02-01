package com.tencent.biz.richframework.animation.drawable;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class AnimationDrawableFactory$1
  implements RFWDownloader.RFWDownloadListener
{
  AnimationDrawableFactory$1(AnimationDrawableFactory paramAnimationDrawableFactory, long paramLong, AnimationDrawableCreateOption paramAnimationDrawableCreateOption, String paramString, AnimationDrawableFactory.CreateResultListener paramCreateResultListener) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost time");
    localStringBuilder.append(System.currentTimeMillis() - this.a);
    QLog.d("AnimationDrawableFactory", 1, localStringBuilder.toString());
    if ((paramBoolean) && (System.currentTimeMillis() - this.a < this.b.c()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get drawable file list success:");
      localStringBuilder.append(this.c);
      QLog.d("AnimationDrawableFactory", 1, localStringBuilder.toString());
      paramString = AnimationDrawableFactory.a(paramString, this.b.f());
      if ((paramString != null) && (paramString.length != 0)) {
        RFThreadManager.getUIHandler().post(new AnimationDrawableFactory.1.1(this, paramString));
      } else {
        this.d.a(false, null);
      }
    }
    else
    {
      QLog.d("AnimationDrawableFactory", 1, "create animationDrawable failed");
      this.d.a(false, null);
    }
    paramString = new StringBuilder();
    paramString.append("removeKey");
    paramString.append(this.c);
    QLog.d("AnimationDrawableFactory", 1, paramString.toString());
    AnimationDrawableFactory.a(this.e).remove(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1
 * JD-Core Version:    0.7.0.1
 */