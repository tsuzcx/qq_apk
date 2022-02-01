package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class GridTextItem
  extends DynamicTextItem
{
  List<Bitmap> a = new ArrayList(2);
  Resources b;
  private TextPaint c = null;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h = false;
  private float i;
  private int j;
  private String p;
  private int q;
  private int r;
  private boolean s;
  private RectF t = new RectF();
  
  public GridTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, List<Bitmap> paramList1)
  {
    super(paramInt, paramList);
    this.a.addAll(paramList1);
    this.b = BaseApplicationImpl.getContext().getResources();
    this.c = new TextPaint();
    if (paramTypeface != null) {
      this.c.setTypeface(paramTypeface);
    }
    this.c.setAntiAlias(true);
    this.c.setColor(-1);
    this.c.setTextSize(AIOUtils.b(9.0F, this.b));
    this.q = this.c.getFontMetricsInt(null);
    paramInt = this.d;
    if (paramInt <= 0)
    {
      this.d = (paramInt + this.q);
      this.d += AIOUtils.b(3.0F, this.b);
      this.d += ((Bitmap)this.a.get(0)).getHeight();
    }
    paramInt = this.e;
    if (paramInt <= 0)
    {
      this.e = (paramInt + this.q);
      this.e += AIOUtils.b(3.0F, this.b);
      this.e += ((Bitmap)this.a.get(1)).getHeight();
    }
    if (this.r <= 0) {
      this.r = AIOUtils.b(2.0F, this.b);
    }
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.p = super.c(paramInt);
    this.p = this.p.replaceAll("\\n", "");
    this.p = this.p.replaceAll("\\r", "");
    if (TextUtils.isEmpty(this.p))
    {
      this.s = true;
      this.p = " ";
    }
    else
    {
      this.s = false;
    }
    this.h = false;
    paramInt = SpellUtil.a(this.p);
    if (paramInt < 5)
    {
      this.j = 1;
      this.f = (((Bitmap)this.a.get(0)).getWidth() * paramInt);
      if (paramInt > 1) {
        this.f += (paramInt - 1) * AIOUtils.b(9.0F, this.b);
      }
      if (this.s) {
        paramInt = ((Bitmap)this.a.get(0)).getHeight();
      } else {
        paramInt = this.d;
      }
      this.g = paramInt;
      return;
    }
    this.f = (((Bitmap)this.a.get(1)).getWidth() * 5 + AIOUtils.b(9.0F, this.b) * 4);
    this.j = (paramInt / 5);
    if (paramInt % 5 > 0) {
      this.j += 1;
    }
    paramInt = this.j;
    this.g = ((paramInt - 1) * this.e + (paramInt - 1) * AIOUtils.b(15.0F, this.b));
    int k = this.g;
    if (this.h) {
      paramInt = (int)(this.i * this.e + 0.5F);
    } else {
      paramInt = this.e;
    }
    this.g = (k + paramInt);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.p)) {
      return;
    }
    int i4;
    if (SpellUtil.a(this.p) < 5) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    if (i4 != 0) {
      localObject1 = this.a.get(0);
    } else {
      localObject1 = this.a.get(1);
    }
    int k = ((Bitmap)localObject1).getWidth();
    if (i4 != 0) {
      localObject1 = this.a.get(0);
    } else {
      localObject1 = this.a.get(1);
    }
    int i6 = ((Bitmap)localObject1).getHeight();
    int i7 = AIOUtils.b(9.0F, this.b);
    int i1 = AIOUtils.b(15.0F, this.b);
    int i8 = AIOUtils.b(3.0F, this.b);
    int n;
    if (i4 != 0) {
      n = this.d;
    } else {
      n = this.e;
    }
    if (i4 != 0) {
      f1 = 40.0F;
    } else {
      f1 = 36.0F;
    }
    int m = AIOUtils.b(f1, this.b);
    float f1 = AIOUtils.b(9.0F, this.b);
    Object localObject1 = this.c;
    float f2 = m;
    ((TextPaint)localObject1).setTextSize(f2);
    int i9 = this.c.getFontMetricsInt(null);
    paramCanvas.save();
    m = this.r;
    paramCanvas.translate(m, m);
    if (this.s)
    {
      paramCanvas.drawBitmap((Bitmap)this.a.get(0), 0.0F, 0.0F, this.c);
    }
    else
    {
      paramCanvas.save();
      m = 0;
      int i2 = 0;
      for (;;)
      {
        int i3 = this.j;
        if (m >= i3) {
          break;
        }
        if ((this.h) && (m == i3 - 1)) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        paramCanvas.save();
        float f3;
        if (i3 != 0)
        {
          i3 = 6;
          f3 = this.i;
          paramCanvas.scale(f3, f3);
        }
        else
        {
          i3 = 5;
        }
        int i5 = 0;
        while ((i5 < i3) && (i2 < this.p.length()))
        {
          int i10 = SpellUtil.a(this.p.charAt(i2));
          if (i10 == 2) {
            localObject1 = this.p.substring(i2, i2 + 2);
          } else {
            localObject1 = this.p.substring(i2, i2 + 1);
          }
          f3 = k * 0.5F;
          if ((i10 != 0) && (i10 != 3)) {
            break label541;
          }
          Object localObject2;
          if (i10 == 3) {
            localObject2 = localObject1;
          } else {
            localObject2 = ChnToSpell.a((String)localObject1, 1).b;
          }
          this.c.setTextSize(f1);
          float f4 = this.q;
          float f5 = this.c.descent();
          this.c.setTextAlign(Paint.Align.CENTER);
          paramCanvas.drawText((String)localObject2, f3, f4 - f5, this.c);
          label541:
          paramCanvas.save();
          paramCanvas.translate(0.0F, this.q + i8);
          if (i4 != 0) {
            localObject2 = (Bitmap)this.a.get(0);
          } else {
            localObject2 = (Bitmap)this.a.get(1);
          }
          paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.c);
          paramCanvas.restore();
          this.c.setTextSize(f2);
          paramCanvas.drawText((String)localObject1, f3, this.q + i8 + (i6 - i9) * 0.5F - this.c.ascent(), this.c);
          if (i10 == 2) {
            i2 += 2;
          } else {
            i2 += 1;
          }
          paramCanvas.translate(k + i7, 0.0F);
          i5 += 1;
        }
        paramCanvas.restore();
        paramCanvas.translate(0.0F, n + i1);
        m += 1;
      }
      paramCanvas.restore();
    }
    paramCanvas.restore();
    if (super.f(0))
    {
      localObject1 = this.t;
      ((RectF)localObject1).left = 0.0F;
      ((RectF)localObject1).top = 0.0F;
      ((RectF)localObject1).right = c();
      this.t.bottom = d();
      paramCanvas.drawRoundRect(this.t, 6.0F, 6.0F, s());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 1;
  }
  
  public float c()
  {
    return this.f + this.r * 2;
  }
  
  public float d()
  {
    return this.g + this.r * 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.GridTextItem
 * JD-Core Version:    0.7.0.1
 */