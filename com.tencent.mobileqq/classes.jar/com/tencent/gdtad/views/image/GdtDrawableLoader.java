package com.tencent.gdtad.views.image;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class GdtDrawableLoader
{
  private URL a;
  private WeakReference<GdtDrawableLoader.Listener> b;
  private URLDrawable c;
  private boolean d = false;
  private int e = 0;
  
  public GdtDrawableLoader(String paramString, WeakReference<GdtDrawableLoader.Listener> paramWeakReference)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.a = new URL(paramString);
        this.b = paramWeakReference;
        return;
      }
    }
    catch (MalformedURLException paramWeakReference)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GdtDrawableLoader error ");
      localStringBuilder.append(paramString);
      GdtLog.d("GdtDrawableLoader", localStringBuilder.toString(), paramWeakReference);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.d)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notify ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(g());
        GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
        this.d = true;
        if (paramBoolean)
        {
          ((GdtDrawableLoader.Listener)this.b.get()).a(this.c);
          return;
        }
        ((GdtDrawableLoader.Listener)this.b.get()).b(this.c);
      }
    }
  }
  
  private URLDrawable.URLDrawableListener c()
  {
    return new GdtDrawableLoader.1(this);
  }
  
  private void d()
  {
    if (f())
    {
      localObject = this.c;
      if (localObject != null)
      {
        int j = ((URLDrawable)localObject).getStatus();
        int i = 0;
        if (j == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is loading ");
          ((StringBuilder)localObject).append(g());
          GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
          if (!this.c.isDownloadStarted()) {
            this.c.startDownload(true);
          }
        }
        do
        {
          for (;;)
          {
            i = 1;
            break label351;
            if (this.c.getStatus() != 4) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("drawable status is file downloaded ");
            ((StringBuilder)localObject).append(g());
            GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
          }
          if (this.c.getStatus() == 1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("drawable status is successed ");
            ((StringBuilder)localObject).append(g());
            GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
            a(true);
            break label351;
          }
          if (this.c.getStatus() != 2) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is failed ");
          ((StringBuilder)localObject).append(g());
          GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
        } while (e());
        a(false);
        break label351;
        if (this.c.getStatus() == 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is cancled ");
          ((StringBuilder)localObject).append(g());
          GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
          a(false);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is ");
          ((StringBuilder)localObject).append(this.c.getStatus());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(g());
          GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
        }
        label351:
        if ((i != 0) && (!this.d)) {
          new Handler(Looper.getMainLooper()).postDelayed(new GdtDrawableLoader.2(this), 100L);
        }
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("update error ");
    ((StringBuilder)localObject).append(g());
    GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
  }
  
  private boolean e()
  {
    if ((f()) && (this.c != null) && (this.e < 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry ");
      localStringBuilder.append(g());
      GdtLog.b("GdtDrawableLoader", localStringBuilder.toString());
      this.e += 1;
      this.c.restartDownload();
      return true;
    }
    return false;
  }
  
  private boolean f()
  {
    return this.a != null;
  }
  
  private String g()
  {
    URLDrawable localURLDrawable = this.c;
    if ((localURLDrawable != null) && (localURLDrawable.getURL() != null)) {
      return this.c.getURL().toString();
    }
    if (f()) {
      return this.a.toString();
    }
    return null;
  }
  
  public URLDrawable a()
  {
    return this.c;
  }
  
  public void b()
  {
    if (!f())
    {
      GdtLog.d("GdtDrawableLoader", "load error");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load ");
    ((StringBuilder)localObject).append(g());
    GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = true;
    this.c = URLDrawable.getDrawable(this.a, (URLDrawable.URLDrawableOptions)localObject);
    localObject = this.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load error ");
      ((StringBuilder)localObject).append(g());
      GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
      return;
    }
    ((URLDrawable)localObject).setURLDrawableListener(c());
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtDrawableLoader
 * JD-Core Version:    0.7.0.1
 */