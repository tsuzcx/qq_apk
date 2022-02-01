package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.view.Gravity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

public class GifDrawable
  extends Drawable
  implements Animatable, GifFrameLoader.FrameCallback
{
  private final GifDrawable.GifState a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e = true;
  private int f;
  private int g = -1;
  private boolean h;
  private Paint i;
  private Rect j;
  
  public GifDrawable(Context paramContext, GifDecoder paramGifDecoder, Transformation<Bitmap> paramTransformation, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this(new GifDrawable.GifState(new GifFrameLoader(Glide.a(paramContext), paramGifDecoder, paramInt1, paramInt2, paramTransformation, paramBitmap)));
  }
  
  GifDrawable(GifDrawable.GifState paramGifState)
  {
    this.a = ((GifDrawable.GifState)Preconditions.a(paramGifState));
  }
  
  private void h()
  {
    this.f = 0;
  }
  
  private void i()
  {
    Preconditions.a(this.d ^ true, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
    if (this.a.a.g() == 1)
    {
      invalidateSelf();
      return;
    }
    if (!this.b)
    {
      this.b = true;
      this.a.a.a(this);
      invalidateSelf();
    }
  }
  
  private void j()
  {
    this.b = false;
    this.a.a.b(this);
  }
  
  private Rect k()
  {
    if (this.j == null) {
      this.j = new Rect();
    }
    return this.j;
  }
  
  private Paint l()
  {
    if (this.i == null) {
      this.i = new Paint(2);
    }
    return this.i;
  }
  
  private Drawable.Callback m()
  {
    for (Drawable.Callback localCallback = getCallback(); (localCallback instanceof Drawable); localCallback = ((Drawable)localCallback).getCallback()) {}
    return localCallback;
  }
  
  public int a()
  {
    return this.a.a.d();
  }
  
  public void a(Transformation<Bitmap> paramTransformation, Bitmap paramBitmap)
  {
    this.a.a.a(paramTransformation, paramBitmap);
  }
  
  public Bitmap b()
  {
    return this.a.a.a();
  }
  
  public ByteBuffer c()
  {
    return this.a.a.f();
  }
  
  public int d()
  {
    return this.a.a.g();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.d) {
      return;
    }
    if (this.h)
    {
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
      this.h = false;
    }
    paramCanvas.drawBitmap(this.a.a.i(), null, k(), l());
  }
  
  public int e()
  {
    return this.a.a.e();
  }
  
  public void f()
  {
    if (m() == null)
    {
      stop();
      invalidateSelf();
      return;
    }
    invalidateSelf();
    if (e() == d() - 1) {
      this.f += 1;
    }
    int k = this.g;
    if ((k != -1) && (this.f >= k)) {
      stop();
    }
  }
  
  public void g()
  {
    this.d = true;
    this.a.a.h();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.a;
  }
  
  public int getIntrinsicHeight()
  {
    return this.a.a.c();
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.a.b();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.b;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.h = true;
  }
  
  public void setAlpha(int paramInt)
  {
    l().setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    l().setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Preconditions.a(this.d ^ true, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
    this.e = paramBoolean1;
    if (!paramBoolean1) {
      j();
    } else if (this.c) {
      i();
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    this.c = true;
    h();
    if (this.e) {
      i();
    }
  }
  
  public void stop()
  {
    this.c = false;
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifDrawable
 * JD-Core Version:    0.7.0.1
 */