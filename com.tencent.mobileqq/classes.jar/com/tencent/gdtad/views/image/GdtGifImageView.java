package com.tencent.gdtad.views.image;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

public class GdtGifImageView
  extends URLImageView
{
  GdtDrawableLoader.Listener a;
  GdtDrawableLoader.Listener b;
  private WeakReference<GdtGifImageView.LoadListener> c;
  private String d;
  private String e;
  private boolean f;
  private volatile boolean g;
  private volatile boolean h;
  
  public GdtGifImageView(Context paramContext, String paramString1, String paramString2, WeakReference<GdtGifImageView.LoadListener> paramWeakReference, boolean paramBoolean)
  {
    super(paramContext);
    this.c = paramWeakReference;
    this.f = false;
    this.d = paramString1;
    this.e = paramString2;
    this.h = paramBoolean;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.a = new GdtGifImageView.ImageLoadListener(this);
      new GdtDrawableLoader(paramString2, new WeakReference(this.a)).b();
    }
    if (!paramBoolean)
    {
      this.b = new GdtGifImageView.ImageLoadListener(this);
      paramContext = new GdtDrawableLoader(paramString1, new WeakReference(this.b));
      paramContext.b();
      setImageDrawable(paramContext.a());
    }
    URLDrawable.resume();
    AbstractGifImage.resumeAll();
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.d)) && (paramString.equals(this.d)))
    {
      this.f = true;
      setImageDrawable(paramURLDrawable);
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.e)) && (paramString.equals(this.e)) && (!this.f)) {
      setImageDrawable(paramURLDrawable);
    }
  }
  
  public void a(String paramString, WeakReference<GdtGifImageView.LoadListener> paramWeakReference)
  {
    this.f = false;
    this.c = paramWeakReference;
    paramWeakReference = new GdtDrawableLoader(paramString, new WeakReference(this.b));
    paramWeakReference.b();
    setImageDrawable(paramWeakReference.a());
    this.g = true;
    paramWeakReference = new StringBuilder();
    paramWeakReference.append("GdtGifImageView update completed ");
    paramWeakReference.append(paramString);
    GdtLog.a("GdtImageView", paramWeakReference.toString());
    URLDrawable.resume();
    AbstractGifImage.resumeAll();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtGifImageView
 * JD-Core Version:    0.7.0.1
 */