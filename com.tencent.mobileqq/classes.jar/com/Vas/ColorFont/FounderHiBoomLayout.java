package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.TextGraphMap;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.util.Arrays;

public class FounderHiBoomLayout
  extends FounderBaseLayout
{
  public static boolean a = false;
  private final HiBoomTextView b;
  private int[] c;
  private int[] d;
  private int[] e;
  private int[] f;
  private int[] g;
  private int[] h;
  private Canvas i;
  private Paint j;
  private Rect k = new Rect();
  private Rect l = new Rect();
  
  public FounderHiBoomLayout(HiBoomTextView paramHiBoomTextView)
  {
    this.b = paramHiBoomTextView;
    this.d = new int[2];
    this.e = new int[2];
    this.f = new int[2];
    this.g = new int[3];
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("drawMissingWord....char:");
    char c1 = (char)paramInt1;
    ((StringBuilder)localObject).append(String.valueOf(c1));
    ((StringBuilder)localObject).append("  code:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("  x:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("  y:");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("  width:");
    ((StringBuilder)localObject).append(paramInt4);
    ((StringBuilder)localObject).append("  height:");
    ((StringBuilder)localObject).append(paramInt5);
    FastColorFontLog.a("HiBoomFont.FounderHiBoomLayout", ((StringBuilder)localObject).toString());
    if ((paramInt4 > 0) && (paramInt5 > 0))
    {
      localObject = this.i;
      if (localObject == null) {
        this.i = new Canvas(this.o);
      } else {
        ((Canvas)localObject).setBitmap(this.o);
      }
      if (this.j == null)
      {
        this.j = new Paint();
        this.j.setColor(-16777216);
      }
      localObject = this.j;
      float f1 = paramInt5;
      ((Paint)localObject).setTextSize(f1);
      f1 /= 2.0F;
      float f2 = (this.j.descent() + this.j.ascent()) / 2.0F;
      localObject = this.i;
      float f3 = paramInt2;
      float f4 = paramInt3;
      ((Canvas)localObject).drawText(String.valueOf(c1), f3, f1 - f2 + f4, this.j);
      if (a)
      {
        localObject = new Paint();
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        ((Paint)localObject).setColor(-16776961);
        ((Paint)localObject).setStrokeWidth(1.0F);
        this.i.drawRect(f3, f4, paramInt2 + paramInt4, paramInt3 + paramInt5, (Paint)localObject);
      }
    }
  }
  
  private void a(String paramString) {}
  
  private void d()
  {
    int[] arrayOfInt = this.h;
    if ((arrayOfInt != null) && (arrayOfInt.length > 5))
    {
      int m = 1;
      for (;;)
      {
        arrayOfInt = this.h;
        if (m >= arrayOfInt.length) {
          break;
        }
        int n = arrayOfInt[m];
        int i1 = arrayOfInt[(m + 1)];
        int i2 = arrayOfInt[(m + 2)];
        int i3 = arrayOfInt[(m + 3)];
        int i4 = arrayOfInt[(m + 4)];
        if (n >= 0)
        {
          arrayOfInt = this.c;
          if (n < arrayOfInt.length) {
            a(arrayOfInt[n], i1, i2, i3, i4);
          }
        }
        m += 5;
      }
    }
  }
  
  private boolean k()
  {
    if (this.c.length > 0)
    {
      int[] arrayOfInt = this.g;
      if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap)
  {
    return 0;
  }
  
  protected void a()
  {
    super.a();
    this.r.addUpdateListener(new FounderHiBoomLayout.1(this));
  }
  
  public void a(ETFont paramETFont)
  {
    int n = 0;
    this.q = new ETFont(0, null, 0.0F);
    this.q.copy(paramETFont);
    paramETFont = paramETFont.mText;
    if (TextUtils.isEmpty(paramETFont)) {
      return;
    }
    int i1 = paramETFont.length();
    int[] arrayOfInt = this.c;
    int m;
    if (arrayOfInt != null)
    {
      m = n;
      if (arrayOfInt.length == i1) {}
    }
    else
    {
      this.c = new int[i1];
      m = n;
    }
    while (m < i1)
    {
      this.c[m] = paramETFont.charAt(m);
      m += 1;
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    this.h = FastColorFontHelper.a().a(this.q.mFontId, this.c, this.d, this.g, this.q.mAnimationId, this.p);
    if (k())
    {
      a("onDraw.....");
      Object localObject = this.g;
      if (!d(localObject[0], localObject[1])) {
        return false;
      }
      c();
      d();
      System.nanoTime();
      FastColorFontHelper.a().a(this.q.mFontId, this.c, this.q.mAnimationId, this.s, this.o, this.e);
      if (FastColorFontHelper.a) {
        System.nanoTime();
      }
      int m = this.g[2];
      localObject = this.k;
      int[] arrayOfInt1 = this.d;
      ((Rect)localObject).set(0, 0, arrayOfInt1[0] * 1000 / m - 1, arrayOfInt1[1] * 1000 / m - 1);
      m = FounderHiBoomLayout.2.a[this.b.getScaleType().ordinal()];
      if (m != 4)
      {
        if (m != 5)
        {
          if (m != 6)
          {
            int n;
            if (m != 7)
            {
              localObject = this.f;
              m = localObject[0];
              arrayOfInt1 = this.d;
              m = (m - arrayOfInt1[0]) / 2;
              n = (localObject[1] - arrayOfInt1[1]) / 2;
              this.l.set(m, n, arrayOfInt1[0] + m, arrayOfInt1[1] + n);
            }
            else
            {
              localObject = this.f;
              m = localObject[0];
              arrayOfInt1 = this.d;
              float f1 = Math.max(m / arrayOfInt1[0] * 1.0F, localObject[1] / arrayOfInt1[1] * 1.0F);
              localObject = this.d;
              float f2 = localObject[0];
              arrayOfInt1 = this.f;
              m = (int)((f2 * f1 - arrayOfInt1[0]) / 2.0F);
              n = (int)((localObject[1] * f1 - arrayOfInt1[1]) / 2.0F);
              this.l.set(-m, -n, localObject[0] + m, localObject[1] + n);
            }
          }
          else
          {
            localObject = this.l;
            arrayOfInt1 = this.d;
            ((Rect)localObject).set(0, 0, arrayOfInt1[0], arrayOfInt1[1]);
          }
        }
        else
        {
          localObject = this.l;
          arrayOfInt1 = this.f;
          m = arrayOfInt1[0];
          int[] arrayOfInt2 = this.d;
          ((Rect)localObject).set(m - arrayOfInt2[0], 0, arrayOfInt1[0] - arrayOfInt2[0] + arrayOfInt2[0], arrayOfInt2[1]);
        }
      }
      else
      {
        localObject = this.l;
        arrayOfInt1 = this.f;
        ((Rect)localObject).set(0, 0, arrayOfInt1[0], arrayOfInt1[1]);
      }
      paramCanvas.drawBitmap(this.o, this.k, this.l, null);
      if ((this.b.e) && (this.s == 0)) {
        b();
      }
      return true;
    }
    a(HardCodeUtil.a(2131902849));
    return false;
  }
  
  public int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
      n = 1;
    } else {
      n = 0;
    }
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int[] arrayOfInt3;
    if (m != 0)
    {
      arrayOfInt1 = this.e;
      arrayOfInt2 = this.d;
      arrayOfInt3 = this.f;
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      arrayOfInt3[0] = paramInt1;
      arrayOfInt2[0] = paramInt1;
      arrayOfInt1[0] = paramInt1;
    }
    else
    {
      arrayOfInt1 = this.e;
      this.d[0] = 0;
      arrayOfInt1[0] = 0;
    }
    if (n != 0)
    {
      arrayOfInt1 = this.e;
      arrayOfInt2 = this.d;
      arrayOfInt3 = this.f;
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      arrayOfInt3[1] = paramInt1;
      arrayOfInt2[1] = paramInt1;
      arrayOfInt1[1] = paramInt1;
    }
    else
    {
      arrayOfInt1 = this.e;
      this.d[1] = 0;
      arrayOfInt1[1] = 0;
    }
    if (paramInt3 > 0)
    {
      arrayOfInt1 = this.e;
      if ((arrayOfInt1[0] > paramInt3) || (arrayOfInt1[0] == 0))
      {
        arrayOfInt1 = this.e;
        this.d[0] = paramInt3;
        arrayOfInt1[0] = paramInt3;
      }
      arrayOfInt1 = this.e;
      if ((arrayOfInt1[1] > paramInt3) || (arrayOfInt1[1] == 0))
      {
        arrayOfInt1 = this.e;
        this.d[1] = paramInt3;
        arrayOfInt1[1] = paramInt3;
      }
    }
    if (FastColorFontHelper.a().a(this.q.mFontId, this.c, this.d) == 0)
    {
      arrayOfInt1 = this.f;
      arrayOfInt1[0] = 0;
      arrayOfInt1[1] = 0;
      return arrayOfInt1;
    }
    if (m == 0) {
      this.f[0] = this.d[0];
    }
    if (n == 0) {
      this.f[1] = this.d[1];
    }
    return this.f;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    return new int[0];
  }
  
  public void b()
  {
    Object localObject = this.g;
    if ((localObject[0] > 0) && (localObject[1] > 0))
    {
      if ((this.r != null) && (this.r.isRunning()))
      {
        FastColorFontLog.b("HiBoomFont.FounderHiBoomLayout", "动画执行中....");
        return;
      }
      if ((this.p[0] > 0) && (this.p[1] > 0))
      {
        i();
        return;
      }
      this.s = 0;
      FastColorFontHelper.a().a(this.q.mFontId, this.c, this.d, this.g, this.q.mAnimationId, this.p);
      if ((this.p[0] > 0) && (this.p[1] > 0))
      {
        i();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("该字体不支持动画....animInfo:");
      ((StringBuilder)localObject).append(Arrays.toString(this.p));
      ((StringBuilder)localObject).append("  ttf path:");
      ((StringBuilder)localObject).append(this.q.mFontPath);
      FastColorFontLog.a("HiBoomFont.FounderHiBoomLayout", ((StringBuilder)localObject).toString());
      return;
    }
    a("bitmap宽高异常");
  }
  
  public void e()
  {
    super.e();
    FastColorFontLog.a("HiBoomFont.FounderHiBoomLayout", "release....");
    this.c = null;
    this.i = null;
    Paint localPaint = this.j;
    if (localPaint != null)
    {
      localPaint.reset();
      this.j = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderHiBoomLayout
 * JD-Core Version:    0.7.0.1
 */