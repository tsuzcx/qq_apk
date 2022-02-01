package com.tencent.biz.qqstory.shareGroup.icon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

class ShareGroupDrawableState
  extends Drawable.ConstantState
{
  @NonNull
  public final String a;
  private String b = "story.icon.ShareGroupDrawableState";
  @NonNull
  private Context c;
  @NonNull
  private ShareGroupDrawableState.StreamCreator<Bitmap> d;
  @NonNull
  private Drawable e;
  private AtomicBoolean f = new AtomicBoolean(false);
  private Bitmap g;
  private Error h;
  private long i;
  private volatile boolean j = false;
  private final CopyOnWriteArraySet<ShareGroupDrawableState.CallBackWeakWrapper> k = new CopyOnWriteArraySet();
  
  public ShareGroupDrawableState(String paramString, Context paramContext, Drawable paramDrawable)
  {
    if ((paramString != null) && (paramContext != null) && (paramDrawable != null))
    {
      this.a = paramString;
      this.c = paramContext;
      this.e = paramDrawable;
      paramString = new StringBuilder();
      paramString.append(this.b);
      paramString.append("[");
      paramString.append(System.identityHashCode(this));
      paramString.append("]");
      this.b = paramString.toString();
      return;
    }
    throw new IllegalArgumentException("params should not be null");
  }
  
  private void a(boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ShareGroupDrawableState.CallBackWeakWrapper localCallBackWeakWrapper = (ShareGroupDrawableState.CallBackWeakWrapper)((Iterator)localObject).next();
        if (ShareGroupDrawableState.CallBackWeakWrapper.a(localCallBackWeakWrapper))
        {
          if (paramBoolean) {
            localCallBackWeakWrapper.a(this);
          } else {
            localCallBackWeakWrapper.b(this);
          }
        }
        else
        {
          IconLog.a(this.b, "remove invalid callback %s", this.k);
          this.k.remove(localCallBackWeakWrapper);
        }
      }
      return;
    }
    Object localObject = new IllegalStateException("notifyCallBack should be at Main-Thread");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.f.getAndSet(true)) && (!paramBoolean))
    {
      if ((this.h != null) && (Math.abs(this.i - SystemClock.uptimeMillis()) > 10000L))
      {
        IconLog.b(this.b, "load again, oldError=%s", this.h);
        this.h = null;
        b(true);
      }
    }
    else
    {
      IconLog.a(this.b, "startLoad");
      this.d.a(this).subscribe(new ShareGroupDrawableState.1(this));
    }
  }
  
  Bitmap a()
  {
    return this.g;
  }
  
  public void a(ShareGroupDrawableState.CallBack paramCallBack)
  {
    this.k.add(new ShareGroupDrawableState.CallBackWeakWrapper(paramCallBack));
  }
  
  void a(@NonNull ShareGroupDrawableState.StreamCreator<Bitmap> paramStreamCreator)
  {
    this.d = paramStreamCreator;
  }
  
  Error b()
  {
    return this.h;
  }
  
  public void c()
  {
    IconLog.b(this.b, "recycle");
    this.j = true;
  }
  
  public void d()
  {
    b(false);
  }
  
  public Drawable e()
  {
    if (this.g != null) {
      return new BitmapDrawable(this.c.getResources(), this.g);
    }
    return null;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new ShareGroupIconDrawable(this, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupDrawableState
 * JD-Core Version:    0.7.0.1
 */