package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class IDonotCareTextItem
  extends DynamicTextItem
{
  public static final int a = AIOUtils.b(24.0F, BaseApplicationImpl.getContext().getResources());
  public static final float b = ScreenUtil.dip2px(45.0F);
  TextDrawImplement c;
  private RectF d = new RectF();
  private RectF e = new RectF();
  private RectF f = new RectF();
  private int g;
  private int h;
  private TextPaint i = new TextPaint();
  private float j;
  private float p;
  private Bitmap q;
  private Bitmap r;
  
  public IDonotCareTextItem(int paramInt, List<String> paramList, Bitmap paramBitmap1, Bitmap paramBitmap2, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.i.setTypeface(Typeface.DEFAULT);
    this.i.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.i.setTypeface(Typeface.defaultFromStyle(1));
    } else {
      this.i.setTypeface(paramTypeface);
    }
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.FILL_AND_STROKE);
    this.i.setColor(-16777216);
    this.i.setTextAlign(Paint.Align.LEFT);
    this.h = (a * 9);
    new BaseTextRegion.Builder().a(0.0F, 0.0F).a(this.h, a, 5, 9).a();
    this.g = a;
    this.i.setTextSize(this.g);
    this.q = paramBitmap1;
    this.r = paramBitmap2;
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private void a(int paramInt, RectF paramRectF, Canvas paramCanvas, Paint paramPaint)
  {
    if ((paramInt >= 0) && (paramRectF != null) && (paramCanvas != null))
    {
      if (paramPaint == null) {
        return;
      }
      if (paramInt < 4)
      {
        paramCanvas.drawBitmap(this.q, paramRectF.left + (paramRectF.width() - this.q.getWidth()) / 2.0F, paramRectF.top + (paramRectF.height() - this.q.getHeight()) / 2.0F, paramPaint);
        return;
      }
      paramCanvas.drawBitmap(this.r, paramRectF.left + (paramRectF.width() - this.r.getWidth()) / 2.0F, paramRectF.top + (paramRectF.height() - this.r.getHeight()) / 2.0F, paramPaint);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = super.c(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    paramInt = 0;
    this.c = new TextDrawImplement(0);
    this.c.a(paramString, this.h, a, this.i);
    this.c.a(new LineMarginCoverter((int)b));
    paramString = this.c;
    this.j = paramString.a(1, paramString.c()).width();
    paramString = this.c;
    this.p = paramString.a(1, paramString.c()).height();
    int k = 0;
    while (paramInt < this.c.c())
    {
      int m = this.c.a(paramInt);
      if (k <= m) {
        k = m;
      }
      paramInt += 1;
    }
    if (k <= 4) {
      this.j = this.q.getWidth();
    } else {
      this.j = this.r.getWidth();
    }
    this.c.a(new CenterMarginCoverter(this.j, this.p));
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.c == null) {
      return;
    }
    paramCanvas.save();
    this.i.setTextAlign(Paint.Align.LEFT);
    paramCanvas.save();
    int k = 0;
    RectF localRectF;
    while (k < this.c.c())
    {
      this.f.set(this.c.b(k));
      this.e.set(this.f);
      a(this.c.a(k), this.e, paramCanvas, this.i);
      localRectF = this.f;
      localRectF.bottom -= b;
      this.e.set(this.f);
      k += 1;
    }
    paramCanvas.restore();
    paramCanvas.rotate(-10.0F, this.j / 2.0F, this.p / 2.0F);
    paramCanvas.translate(0.0F, -ScreenUtil.dip2px(5.0F));
    this.i.setColor(-16777216);
    this.c.a(paramCanvas, 0, 0);
    if (super.f(0))
    {
      localRectF = this.d;
      TextDrawImplement localTextDrawImplement = this.c;
      localRectF.set(localTextDrawImplement.a(1, localTextDrawImplement.c()));
      paramCanvas.drawRoundRect(this.d, 6.0F, 6.0F, s());
    }
    paramCanvas.restore();
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
    return this.j;
  }
  
  public float d()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.IDonotCareTextItem
 * JD-Core Version:    0.7.0.1
 */