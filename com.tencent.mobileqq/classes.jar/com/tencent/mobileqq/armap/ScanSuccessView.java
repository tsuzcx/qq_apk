package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.Random;
import mqq.app.MobileQQ;

public class ScanSuccessView
  extends View
{
  private int A = 0;
  private int B = 70;
  private int C = 180;
  private int D = 10;
  private int E = 0;
  private float F = 1.6875F;
  private int G = 18;
  RectF a = new RectF();
  RectF b = new RectF();
  RectF c = new RectF();
  RectF d = new RectF();
  RectF e = new RectF();
  String f = HardCodeUtil.a(2131910993);
  boolean g = true;
  boolean h = true;
  private Paint i;
  private Paint j;
  private Paint k;
  private Paint l;
  private Paint m;
  private Paint n;
  private Paint o;
  private float p = 51.0F;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v = 10.0F;
  private int w;
  private int x;
  private float y;
  private float z;
  
  public ScanSuccessView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    float f1 = this.p;
    this.q = (4.0F + f1 + 6.0F);
    this.t = (25.0F + f1);
    this.r = (36.0F + f1);
    this.s = (this.v / 2.0F + f1 + 47.0F);
    this.u = (f1 + 72.0F);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setColor(2147483647);
    this.i.setStyle(Paint.Style.FILL);
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setColor(-1);
    this.j.setStyle(Paint.Style.STROKE);
    this.j.setStrokeWidth(this.F * 8.0F);
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setColor(2147483647);
    this.k.setStyle(Paint.Style.STROKE);
    this.k.setStrokeWidth(2.0F);
    this.l = new Paint();
    this.l.setAntiAlias(true);
    this.l.setColor(-1);
    this.l.setStyle(Paint.Style.STROKE);
    this.l.setStrokeWidth(this.F * 6.0F);
    this.m = new Paint();
    this.m.setAntiAlias(true);
    this.m.setColor(-1);
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setStrokeWidth(this.F * 16.0F);
    this.n = new Paint();
    this.n.setAntiAlias(true);
    this.n.setStyle(Paint.Style.FILL);
    this.n.setARGB(255, 255, 255, 255);
    this.n.setTextSize(this.F * 28.0F);
    this.o = new Paint();
    this.o.setAntiAlias(true);
    this.o.setStyle(Paint.Style.FILL);
    this.o.setARGB(255, 255, 255, 255);
    this.G = DisplayUtil.a(MobileQQ.sMobileQQ, 18.0F);
    this.o.setTextSize(this.G);
    Paint.FontMetrics localFontMetrics = this.n.getFontMetrics();
    this.z = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.E % 10 == 9) {
      this.h = false;
    }
    if (this.E % 10 == 0) {
      this.h = true;
    }
    if (this.h) {
      this.E += 1;
    } else {
      this.E -= 1;
    }
    int i1 = this.E;
    this.w = (getWidth() / 2);
    this.x = (getHeight() / 2);
    Object localObject = this.a;
    i1 = this.w;
    float f2 = i1;
    float f3 = this.q;
    float f1 = this.F;
    ((RectF)localObject).left = (f2 - f3 * f1);
    int i2 = this.x;
    ((RectF)localObject).top = (i2 - f3 * f1);
    ((RectF)localObject).right = (i1 + f3 * f1);
    ((RectF)localObject).bottom = (i2 + f3 * f1);
    RectF localRectF = this.b;
    f2 = i1;
    f3 = this.r;
    localRectF.left = (f2 - f3 * f1);
    localRectF.top = (i2 - f3 * f1);
    localRectF.right = (i1 + f3 * f1);
    localRectF.bottom = (i2 + f3 * f1);
    localRectF = this.c;
    f2 = i1;
    f3 = this.s;
    localRectF.left = (f2 - f3 * f1);
    localRectF.top = (i2 - f3 * f1);
    localRectF.right = (i1 + f3 * f1);
    localRectF.bottom = (i2 + f3 * f1);
    localRectF = this.d;
    f2 = i1;
    f3 = this.t;
    localRectF.left = (f2 - f3 * f1);
    localRectF.top = (i2 - f3 * f1);
    localRectF.right = (i1 + f3 * f1);
    localRectF.bottom = (i2 + f3 * f1);
    localRectF = this.e;
    f2 = i1;
    f3 = this.u;
    int i3 = this.E;
    localRectF.left = (f2 - f3 * f1 - i3 % 10);
    localRectF.top = (i2 - f3 * f1 - i3 % 10);
    localRectF.right = (i1 + f3 * f1 + i3 % 10);
    localRectF.bottom = (i2 + f3 * f1 + i3 % 10);
    this.B += 10;
    this.C += 10;
    this.D += 10;
    paramCanvas.drawArc((RectF)localObject, this.B + 270, 90.0F, false, this.j);
    paramCanvas.drawArc(this.b, this.C + 270, 270.0F, false, this.l);
    paramCanvas.drawArc(this.c, this.D + 90, 90.0F, false, this.m);
    paramCanvas.drawArc(this.e, 0.0F, 360.0F, false, this.k);
    paramCanvas.drawArc(this.d, 0.0F, 360.0F, false, this.k);
    if (this.g)
    {
      paramCanvas.drawCircle(this.w, this.x, this.p * this.F, this.i);
      if (this.A > 99) {
        this.A = 99;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.A);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
      this.y = this.n.measureText((String)localObject, 0, ((String)localObject).length());
      if (this.A != 0) {
        paramCanvas.drawText((String)localObject, this.w - this.y / 2.0F, this.x + this.z / 4.0F, this.n);
      }
    }
    i1 = this.x;
    f1 = i1;
    f2 = this.z / 4.0F;
    f3 = this.F;
    f2 = f1 + f2 + 165.0F * f3;
    float f4 = i1;
    float f5 = this.u;
    i2 = this.G;
    f1 = f2;
    if (f2 < f4 + f5 * f3 + i2 / 2) {
      f1 = i1 + f5 * f3 + i2 / 2;
    }
    localObject = this.f;
    paramCanvas.drawText((String)localObject, this.w - this.o.measureText((String)localObject, 0, ((String)localObject).length()) / 2.0F, f1, this.o);
    postInvalidateDelayed(15L);
  }
  
  public void setFistAgree()
  {
    Random localRandom = new Random();
    this.A += localRandom.nextInt(20);
  }
  
  public void setScale(int paramInt)
  {
    this.F = (paramInt / 640.0F);
  }
  
  public void setScanText(String paramString)
  {
    this.f = paramString;
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setTotalProgress(int paramInt)
  {
    if (paramInt > this.A) {
      this.A = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ScanSuccessView
 * JD-Core Version:    0.7.0.1
 */