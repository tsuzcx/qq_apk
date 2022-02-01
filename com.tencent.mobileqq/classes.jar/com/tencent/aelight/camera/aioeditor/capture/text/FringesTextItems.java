package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.List;

public class FringesTextItems
  extends DynamicTextItem
{
  public static final float a;
  public static final float b;
  public static final float c;
  public static final float d;
  public static final float e;
  public static final float f;
  public static final float g;
  public static final float h;
  private static final String s = "FringesTextItems";
  private RectF A = new RectF();
  float i;
  DrawFilter j = new PaintFlagsDrawFilter(0, 3);
  float p;
  float q;
  float r;
  private StaticLayout t;
  private Bitmap u;
  private Bitmap v;
  private TextPaint w = new TextPaint();
  private Paint x;
  private float y;
  private float z;
  
  static
  {
    float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    a = 2.0F * f1;
    b = 13.0F * f1;
    c = 1.0F * f1;
    float f2 = 5.0F * f1;
    d = f2;
    e = 15.0F * f1;
    f = f2;
    g = f2;
    h = f1 * 6.0F;
  }
  
  public FringesTextItems(int paramInt, List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.w.setAntiAlias(true);
    this.w.setTypeface(paramTypeface);
    this.w.setTextSize(AIOUtils.b(20.0F, BaseApplicationImpl.getContext().getResources()));
    this.w.setTextSkewX(-0.25F);
    this.w.setColor(-6741743);
    boolean bool;
    try
    {
      Paint.class.getDeclaredMethod("setLetterSpacing", new Class[] { Float.TYPE }).invoke(this.w, new Object[] { Float.valueOf(0.4F) });
      bool = true;
    }
    catch (Exception paramTypeface)
    {
      paramTypeface.printStackTrace();
      bool = false;
    }
    paramTypeface = TextLayer.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLetterSpacing");
    localStringBuilder.append(bool);
    QLog.i(paramTypeface, 1, localStringBuilder.toString());
    this.x = new Paint();
    this.x.setColor(-1);
    this.x.setAntiAlias(true);
    this.x.setStrokeWidth(2.0F);
    this.x.setStyle(Paint.Style.STROKE);
    this.v = paramBitmap1;
    this.u = paramBitmap2;
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.y - this.v.getWidth(), 0.0F);
    paramCanvas.drawBitmap(this.v, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.v.getHeight() + e - (this.u.getHeight() + g));
    paramCanvas.drawBitmap(this.u, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(b - (this.t.getWidth() - this.i) * 0.5F, e + this.v.getHeight());
    paramCanvas.save();
    float f1 = a;
    paramCanvas.translate(-f1, -f1);
    this.w.setColor(-65536);
    this.t.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    f1 = a;
    paramCanvas.translate(f1, f1);
    this.w.setColor(-16776961);
    this.t.draw(paramCanvas);
    paramCanvas.restore();
    this.w.setColor(-1);
    this.t.draw(paramCanvas);
    if (super.f(0))
    {
      f1 = this.t.getHeight();
      float f2 = this.t.getWidth() / 2.0F;
      RectF localRectF = this.A;
      float f3 = this.i;
      localRectF.left = (f2 - f3 / 2.0F);
      float f4 = a;
      localRectF.top = (-f4);
      localRectF.right = (f2 + f3 / 2.0F);
      localRectF.bottom = (f1 + f4);
      paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, s());
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.z - c);
    paramCanvas.drawLine(0.0F, 0.0F, this.y, 0.0F, this.x);
    paramCanvas.restore();
  }
  
  private void d(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.y - this.v.getWidth(), 0.0F);
    paramCanvas.drawBitmap(this.v, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(this.q, this.r);
    paramCanvas.drawBitmap(this.u, 0.0F, 0.0F, null);
    paramCanvas.restore();
    paramCanvas.save();
    if (this.q > 0.0F) {
      f1 = b;
    } else {
      f1 = b + (this.y - this.p) * 0.5F;
    }
    paramCanvas.translate(f1 - (this.t.getWidth() - this.i) * 0.5F, f + this.v.getHeight());
    paramCanvas.save();
    float f1 = a;
    paramCanvas.translate(-f1, -f1);
    this.w.setColor(-65536);
    this.t.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    f1 = a;
    paramCanvas.translate(f1, f1);
    this.w.setColor(-16776961);
    this.t.draw(paramCanvas);
    paramCanvas.restore();
    this.w.setColor(-1);
    this.t.draw(paramCanvas);
    if (super.f(0))
    {
      f1 = this.t.getHeight();
      float f2 = this.t.getWidth() / 2.0F;
      RectF localRectF = this.A;
      float f3 = this.i;
      localRectF.left = (f2 - f3 / 2.0F);
      float f4 = a;
      localRectF.top = (-f4);
      localRectF.right = (f2 + f3 / 2.0F);
      localRectF.bottom = (f1 + f4);
      paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, s());
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.z - c);
    paramCanvas.drawLine(0.0F, 0.0F, this.y, 0.0F, this.x);
    paramCanvas.restore();
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = super.c(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    paramInt = (int)this.w.measureText(HardCodeUtil.a(2131902938));
    this.t = new StaticLayout(paramString, this.w, paramInt, Layout.Alignment.ALIGN_CENTER, 1.2F, 0.0F, false);
    float f1 = 0.0F;
    this.i = 0.0F;
    int k = this.t.getLineCount();
    paramInt = 0;
    while (paramInt < k)
    {
      this.i = Math.max(this.t.getLineWidth(paramInt), this.i);
      paramInt += 1;
    }
    this.p = (this.i + a * 2.0F + b * 2.0F);
    if (k == 1)
    {
      this.y = this.p;
      this.z = (this.t.getHeight() + a * 2.0F + c + d + e + this.v.getHeight());
      return;
    }
    paramString = this.t;
    paramInt = k - 2;
    float f2 = (paramString.getLineWidth(paramInt) * 0.5F + h + this.u.getWidth()) * 2.0F;
    this.y = Math.max(this.p, f2);
    this.z = (this.t.getHeight() + a * 2.0F + c + d + f + this.v.getHeight());
    float f3 = this.p;
    if (f2 <= f3) {
      f1 = (f3 - f2) * 0.5F;
    }
    this.q = f1;
    this.r = (this.t.getLineBottom(paramInt) - this.w.descent() - this.u.getHeight() + this.v.getHeight() + f);
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(this.j);
    if (this.t.getLineCount() == 1)
    {
      c(paramCanvas);
      return;
    }
    d(paramCanvas);
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
    return this.y;
  }
  
  public float d()
  {
    return this.z;
  }
  
  public int g()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FringesTextItems
 * JD-Core Version:    0.7.0.1
 */