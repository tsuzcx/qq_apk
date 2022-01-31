package com.tencent.biz.qqcircle.widgets;

import android.text.TextUtils;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import uer;

public class QCirclePolymorphicLikePopWindow$LoadGifRunnable
  implements Runnable
{
  private WeakReference<AnimationView> a;
  private WeakReference<String> b;
  private WeakReference<QCirclePolymorphicLikePopWindow> c;
  
  public QCirclePolymorphicLikePopWindow$LoadGifRunnable(QCirclePolymorphicLikePopWindow paramQCirclePolymorphicLikePopWindow, AnimationView paramAnimationView, String paramString)
  {
    this.c = new WeakReference(paramQCirclePolymorphicLikePopWindow);
    this.a = new WeakReference(paramAnimationView);
    this.b = new WeakReference(paramString);
  }
  
  public void run()
  {
    Object localObject1 = (String)this.b.get();
    AnimationView localAnimationView = (AnimationView)this.a.get();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).isDirectory())
      {
        localObject2 = ((File)localObject1).listFiles();
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          localObject1 = new String[localObject2.length];
          int i = 0;
          while (i < localObject2.length)
          {
            if (localObject2[i].isFile()) {
              localObject1[i] = localObject2[i].getAbsolutePath();
            }
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Arrays.sort((Object[])localObject1, new uer(this));
        localObject2 = new QQAnimationDrawable();
        ((QQAnimationDrawable)localObject2).c(2147483647);
        ((QQAnimationDrawable)localObject2).a(false);
        if (localObject1 != null)
        {
          ((QQAnimationDrawable)localObject2).a(localObject1.length * 30);
          ((QQAnimationDrawable)localObject2).a((String[])localObject1);
        }
        if (localAnimationView != null) {
          localAnimationView.post(new QCirclePolymorphicLikePopWindow.LoadGifRunnable.2(this, localAnimationView, (QQAnimationDrawable)localObject2));
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("polyView", 1, localException.getMessage());
        continue;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow.LoadGifRunnable
 * JD-Core Version:    0.7.0.1
 */