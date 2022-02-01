package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ApathyTextItem
  extends DynamicTextItem
{
  private RectF A = new RectF();
  private int B = 1;
  private String C = "";
  private Rect D = new Rect();
  private InputFilter E = null;
  private Bitmap a;
  private Bitmap b;
  private Bitmap c;
  private TextPaint d;
  private TextPaint e;
  private int f = 4;
  private int g = 4;
  private int h = 36;
  private int i = 36;
  private int j = 95;
  private int p = 180;
  private float q = 0.85F;
  private float r = 0.9F;
  private float s = 2.0F;
  private float t;
  private int u;
  private int v;
  private int w;
  private Resources x;
  private ArrayList<String> y = new ArrayList();
  private RectF z = new RectF();
  
  public ApathyTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramList);
    this.a = paramBitmap1;
    this.b = paramBitmap2;
    this.c = paramBitmap3;
    this.x = BaseApplicationImpl.getContext().getResources();
    this.f = AIOUtils.b(this.f, this.x);
    this.h = AIOUtils.b(this.h, this.x);
    this.g = AIOUtils.b(this.g, this.x);
    this.i = AIOUtils.b(this.i, this.x);
    this.j = AIOUtils.b(this.j, this.x);
    this.p = AIOUtils.b(this.p, this.x);
    this.w = this.f;
    a(paramTypeface);
    int k = Math.min(paramList.size(), b());
    paramInt = 0;
    while (paramInt < k)
    {
      a(paramInt, (String)paramList.get(paramInt));
      paramInt += 1;
    }
  }
  
  private void a(Typeface paramTypeface)
  {
    this.d = new TextPaint();
    this.d.setTypeface(paramTypeface);
    this.d.setAntiAlias(true);
    this.d.setColor(Color.parseColor("#045389"));
    this.d.setStyle(Paint.Style.FILL_AND_STROKE);
    this.d.setTextAlign(Paint.Align.CENTER);
    this.e = new TextPaint();
    this.e.setTypeface(paramTypeface);
    this.e.setAntiAlias(true);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setStrokeJoin(Paint.Join.ROUND);
    this.e.setStrokeCap(Paint.Cap.ROUND);
    this.e.setTextAlign(Paint.Align.CENTER);
    this.e.setColor(Color.parseColor("#ddf3fd"));
    this.e.setStrokeWidth(AIOUtils.b(2.0F, this.x));
    if (Build.VERSION.SDK_INT >= 21) {
      this.e.setShadowLayer(AIOUtils.b(1.0F, this.x), AIOUtils.b(1.0F, this.x), AIOUtils.b(1.0F, this.x), Color.parseColor("#33000000"));
    }
  }
  
  private void u()
  {
    this.t *= this.r;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = TroopFileUtils.c(super.a(paramInt, new ApathyTextItem.1(this))).replaceAll("\n", "");
    this.C = paramString;
    this.y.clear();
    paramInt = paramString.length();
    float f1;
    float f2;
    int k;
    if (paramInt > 10)
    {
      this.y.add(paramString.substring(0, 10));
      this.y.add(paramString.substring(10, Math.min(20, paramInt)));
      this.t = Math.min(this.p / 10, this.h / this.s);
      u();
      paramInt = this.h;
      f1 = paramInt;
      f2 = this.t;
      k = (int)((f1 - 2.0F * f2) / 3.0F);
      this.v = k;
      this.u = k;
      this.A.set(0.0F, 0.0F, paramInt + this.g * 2, f2 * 10.0F + this.f * 2 + this.w * 2);
      this.B = 3;
    }
    else if (paramInt > 5)
    {
      this.y.add(paramString.substring(0, 5));
      this.y.add(paramString.substring(5, paramInt));
      this.t = ((int)Math.min(this.j / 5, this.h / this.s));
      u();
      paramInt = this.h;
      f1 = paramInt;
      f2 = this.t;
      k = (int)((f1 - 2.0F * f2) / 3.0F);
      this.v = k;
      this.u = k;
      this.A.set(0.0F, 0.0F, paramInt + this.g * 2, f2 * 5.0F + this.f * 2 + this.w * 2);
      this.B = 2;
    }
    else if (paramInt > 1)
    {
      this.y.add(paramString);
      this.t = Math.min(this.h, this.j / paramInt);
      u();
      this.u = 0;
      k = this.h;
      f1 = k;
      f2 = this.t;
      this.v = ((int)((f1 - f2) / 2.0F));
      this.A.set(0.0F, 0.0F, k + this.g * 2, paramInt * f2 + this.f * 2 + this.w * 2);
      this.B = 2;
    }
    else
    {
      this.y.add(paramString);
      this.t = this.h;
      u();
      this.A.set(0.0F, 0.0F, this.h + this.g * 2, this.t + this.f * 2 + this.w * 2);
      this.u = 0;
      this.v = ((int)((this.h - this.t) / 2.0F));
      this.B = 1;
    }
    this.z.set(this.A.left + this.g * 1.2F, this.A.top + this.f * 1.2F, this.A.right - this.g * 1.2F, this.A.bottom - this.f * 1.2F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int k = this.B;
    Object localObject;
    if (1 == k) {
      localObject = this.a;
    } else if (2 == k) {
      localObject = this.b;
    } else if (3 == k) {
      localObject = this.c;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      this.D.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      paramCanvas.drawBitmap((Bitmap)localObject, this.D, this.A, null);
    }
    if (super.f(0)) {
      paramCanvas.drawRoundRect(this.z, 6.0F, 6.0F, s());
    }
    this.d.setTextSize(this.t);
    this.e.setTextSize(this.t);
    double d1 = this.g + this.v;
    float f1 = this.t;
    double d2 = f1;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int n = (int)(d1 + d2 * 0.5D);
    k = (int)(this.f + f1 * this.q + this.w);
    int m = this.y.size() - 1;
    while (m >= 0)
    {
      localObject = (String)this.y.get(m);
      int i3 = ((String)localObject).length();
      int i2 = 0;
      int i1 = k;
      for (k = i2; k < i3; k = i2)
      {
        i2 = k + 1;
        String str = ((String)localObject).substring(k, i2);
        f1 = n;
        f2 = i1;
        paramCanvas.drawText(str, f1, f2, this.e);
        paramCanvas.drawText(((String)localObject).substring(k, i2), f1, f2, this.d);
        i1 = (int)(f2 + this.t);
      }
      f1 = n;
      float f2 = this.u;
      float f3 = this.t;
      n = (int)(f1 + (f2 + f3));
      k = (int)(this.f + f3 * this.q + this.w);
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
    return this.A.width();
  }
  
  public float d()
  {
    return this.A.height();
  }
  
  public boolean e()
  {
    return (TextUtils.isEmpty(this.C)) || (super.e());
  }
  
  public InputFilter f()
  {
    if (this.E == null) {
      this.E = new ApathyTextItem.2(this, 20);
    }
    return this.E;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.ApathyTextItem
 * JD-Core Version:    0.7.0.1
 */