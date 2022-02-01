package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class FoodAloneTextItem
  extends DynamicTextItem
{
  private InputFilter A = null;
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private TextPaint g;
  private int h;
  private int i;
  private int j;
  private String p = "#ffffff";
  private float q = 0.73F;
  private float r = 0.31F;
  private int s;
  private int t;
  private Bitmap u;
  private Resources v;
  private RectF w = new RectF();
  private RectF x = new RectF();
  private int y;
  private ArrayList<String> z = new ArrayList();
  
  public FoodAloneTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.v.getDisplayMetrics().density * paramFloat);
  }
  
  private void a(Typeface paramTypeface)
  {
    this.g = new TextPaint();
    this.g.setAntiAlias(true);
    this.g.setColor(Color.parseColor(this.p));
    this.g.setTypeface(paramTypeface);
    this.g.setStyle(Paint.Style.FILL_AND_STROKE);
    this.g.setTextAlign(Paint.Align.CENTER);
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    this.v = BaseApplicationImpl.getContext().getResources();
    this.u = paramBitmap;
    a(paramTypeface);
    this.d = a(48.75F);
    this.g.setTextSize(this.d);
    this.a = ((int)this.g.measureText(HardCodeUtil.a(2131902709)));
    this.e = a(27.0F);
    this.g.setTextSize(this.e);
    this.b = ((int)this.g.measureText(HardCodeUtil.a(2131902708)));
    this.f = a(18.0F);
    this.g.setTextSize(this.f);
    this.c = ((int)this.g.measureText(HardCodeUtil.a(2131902710)));
    this.s = a(0.0F);
    this.t = a(0.0F);
    double d1 = this.u.getWidth();
    Double.isNaN(d1);
    this.h = ((int)(d1 * 0.98D));
    d1 = this.u.getHeight();
    Double.isNaN(d1);
    this.i = ((int)(d1 * 0.98D));
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = super.a(paramInt, new FoodAloneTextItem.1(this));
    this.z.clear();
    int k = paramString.length();
    if (k > 10)
    {
      this.z.add(paramString.substring(0, 10));
      this.z.add(paramString.substring(10, Math.min(k, 20)));
      this.j = this.f;
      this.g.setTextSize(this.j);
      this.y = this.c;
      k = this.y;
      paramInt = k * 2 + this.s;
      k = k * 10 + this.t * 9;
    }
    else if (k > 5)
    {
      this.z.add(paramString);
      this.j = this.e;
      this.g.setTextSize(this.j);
      this.y = this.b;
      paramInt = this.y;
      k = paramInt * k + this.t * Math.max(k - 1, 0);
      paramInt *= 1;
    }
    else
    {
      this.z.add(paramString);
      this.j = this.d;
      this.g.setTextSize(this.j);
      this.y = this.a;
      m = this.y;
      paramInt = k;
      if (k == 0) {
        paramInt = 2;
      }
      int n = this.y;
      int i1 = this.t;
      int i2 = Math.max(paramInt - 1, 0);
      k = m * 1;
      m = n * paramInt + i1 * i2;
      paramInt = k;
      k = m;
    }
    float f1 = k;
    k = this.i;
    float f2 = k;
    float f3 = this.q;
    if (f1 > f2 * f3)
    {
      this.w.set(0.0F, f1 - k * f3, this.h, k * (1.0F - f3) + f1);
      paramString = this.x;
      k = this.h;
      f2 = k - paramInt;
      f3 = this.r;
      paramString.set(f2 * f3, 0.0F, k * f3 + paramInt * (1.0F - f3), f1);
      return;
    }
    this.w.set(0.0F, 0.0F, this.h, k);
    paramString = this.x;
    k = this.h;
    f2 = k - paramInt;
    f3 = this.r;
    int m = this.i;
    float f4 = m;
    float f5 = this.q;
    paramString.set(f2 * f3, (f4 * f5 - f1) / 2.0F, k * f3 + paramInt * (1.0F - f3), (m * f5 + f1) / 2.0F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    Object localObject = new Rect();
    ((Rect)localObject).set(0, 0, this.u.getWidth(), this.u.getHeight());
    paramCanvas.drawBitmap(this.u, (Rect)localObject, this.w, null);
    if (super.f(0)) {
      paramCanvas.drawRoundRect(new RectF(this.x.left, this.x.top, this.x.right, this.x.bottom + this.y * 0.1F), 6.0F, 6.0F, s());
    }
    double d1 = this.x.left;
    double d2 = this.y;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int n = (int)(d1 + d2 * 0.5D);
    int k = (int)(this.x.top + this.y);
    int m = this.z.size() - 1;
    while (m >= 0)
    {
      localObject = (String)this.z.get(m);
      int i3 = ((String)localObject).length();
      int i2 = 0;
      int i1 = k;
      for (k = i2; k < i3; k = i2)
      {
        i2 = k + 1;
        paramCanvas.drawText(((String)localObject).substring(k, i2), n, i1, this.g);
        i1 += this.y + this.t;
      }
      n += this.y + this.s;
      k = (int)(this.x.top + this.y);
      m -= 1;
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
    return this.h;
  }
  
  public float d()
  {
    return this.w.bottom - Math.min(this.x.top, this.w.top);
  }
  
  public InputFilter f()
  {
    if (this.A == null) {
      this.A = new FoodAloneTextItem.2(this, 20);
    }
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FoodAloneTextItem
 * JD-Core Version:    0.7.0.1
 */