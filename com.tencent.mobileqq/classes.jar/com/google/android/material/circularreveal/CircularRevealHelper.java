package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.math.MathUtils;

public class CircularRevealHelper
{
  public static final int a = 0;
  private final CircularRevealHelper.Delegate b;
  @NonNull
  private final View c;
  @NonNull
  private final Path d;
  @NonNull
  private final Paint e;
  @NonNull
  private final Paint f;
  @Nullable
  private CircularRevealWidget.RevealInfo g;
  @Nullable
  private Drawable h;
  private boolean i;
  private boolean j;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = 1;
      return;
    }
  }
  
  public CircularRevealHelper(CircularRevealHelper.Delegate paramDelegate)
  {
    this.b = paramDelegate;
    this.c = ((View)paramDelegate);
    this.c.setWillNotDraw(false);
    this.d = new Path();
    this.e = new Paint(7);
    this.f = new Paint(1);
    this.f.setColor(0);
  }
  
  private float b(@NonNull CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    return MathUtils.a(paramRevealInfo.a, paramRevealInfo.b, 0.0F, 0.0F, this.c.getWidth(), this.c.getHeight());
  }
  
  private void b(@NonNull Canvas paramCanvas)
  {
    if (j())
    {
      Rect localRect = this.h.getBounds();
      float f1 = this.g.a - localRect.width() / 2.0F;
      float f2 = this.g.b - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.h.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void g()
  {
    if (a == 1)
    {
      this.d.rewind();
      CircularRevealWidget.RevealInfo localRevealInfo = this.g;
      if (localRevealInfo != null) {
        this.d.addCircle(localRevealInfo.a, this.g.b, this.g.c, Path.Direction.CW);
      }
    }
    this.c.invalidate();
  }
  
  private boolean h()
  {
    CircularRevealWidget.RevealInfo localRevealInfo = this.g;
    boolean bool2 = false;
    int k;
    if ((localRevealInfo != null) && (!localRevealInfo.a())) {
      k = 0;
    } else {
      k = 1;
    }
    if (a == 0)
    {
      boolean bool1 = bool2;
      if (k == 0)
      {
        bool1 = bool2;
        if (this.j) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return k ^ 0x1;
  }
  
  private boolean i()
  {
    return (!this.i) && (Color.alpha(this.f.getColor()) != 0);
  }
  
  private boolean j()
  {
    return (!this.i) && (this.h != null) && (this.g != null);
  }
  
  public void a()
  {
    if (a == 0)
    {
      this.i = true;
      this.j = false;
      this.c.buildDrawingCache();
      Object localObject2 = this.c.getDrawingCache();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.c.getWidth() != 0)
        {
          localObject1 = localObject2;
          if (this.c.getHeight() != 0)
          {
            localObject1 = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
            localObject2 = new Canvas((Bitmap)localObject1);
            this.c.draw((Canvas)localObject2);
          }
        }
      }
      if (localObject1 != null) {
        this.e.setShader(new BitmapShader((Bitmap)localObject1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      }
      this.i = false;
      this.j = true;
    }
  }
  
  public void a(@ColorInt int paramInt)
  {
    this.f.setColor(paramInt);
    this.c.invalidate();
  }
  
  public void a(@NonNull Canvas paramCanvas)
  {
    if (h())
    {
      int k = a;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k == 2)
          {
            this.b.a(paramCanvas);
            if (i()) {
              paramCanvas.drawRect(0.0F, 0.0F, this.c.getWidth(), this.c.getHeight(), this.f);
            }
          }
          else
          {
            paramCanvas = new StringBuilder();
            paramCanvas.append("Unsupported strategy ");
            paramCanvas.append(a);
            throw new IllegalStateException(paramCanvas.toString());
          }
        }
        else
        {
          k = paramCanvas.save();
          paramCanvas.clipPath(this.d);
          this.b.a(paramCanvas);
          if (i()) {
            paramCanvas.drawRect(0.0F, 0.0F, this.c.getWidth(), this.c.getHeight(), this.f);
          }
          paramCanvas.restoreToCount(k);
        }
      }
      else
      {
        paramCanvas.drawCircle(this.g.a, this.g.b, this.g.c, this.e);
        if (i()) {
          paramCanvas.drawCircle(this.g.a, this.g.b, this.g.c, this.f);
        }
      }
    }
    else
    {
      this.b.a(paramCanvas);
      if (i()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.c.getWidth(), this.c.getHeight(), this.f);
      }
    }
    b(paramCanvas);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    this.h = paramDrawable;
    this.c.invalidate();
  }
  
  public void a(@Nullable CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    if (paramRevealInfo == null)
    {
      this.g = null;
    }
    else
    {
      CircularRevealWidget.RevealInfo localRevealInfo = this.g;
      if (localRevealInfo == null) {
        this.g = new CircularRevealWidget.RevealInfo(paramRevealInfo);
      } else {
        localRevealInfo.a(paramRevealInfo);
      }
      if (MathUtils.b(paramRevealInfo.c, b(paramRevealInfo), 1.0E-004F)) {
        this.g.c = 3.4028235E+38F;
      }
    }
    g();
  }
  
  public void b()
  {
    if (a == 0)
    {
      this.j = false;
      this.c.destroyDrawingCache();
      this.e.setShader(null);
      this.c.invalidate();
    }
  }
  
  @Nullable
  public CircularRevealWidget.RevealInfo c()
  {
    CircularRevealWidget.RevealInfo localRevealInfo = this.g;
    if (localRevealInfo == null) {
      return null;
    }
    localRevealInfo = new CircularRevealWidget.RevealInfo(localRevealInfo);
    if (localRevealInfo.a()) {
      localRevealInfo.c = b(localRevealInfo);
    }
    return localRevealInfo;
  }
  
  @ColorInt
  public int d()
  {
    return this.f.getColor();
  }
  
  @Nullable
  public Drawable e()
  {
    return this.h;
  }
  
  public boolean f()
  {
    return (this.b.c()) && (!h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealHelper
 * JD-Core Version:    0.7.0.1
 */