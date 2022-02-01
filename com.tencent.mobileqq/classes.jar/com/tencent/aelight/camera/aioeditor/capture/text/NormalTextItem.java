package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
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
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class NormalTextItem
  extends DynamicTextItem
{
  public static final int b;
  public static final int c;
  public static final int d;
  private boolean a = false;
  protected RectF e = new RectF();
  protected int f = 2147483647;
  protected TextPaint g = new TextPaint();
  protected float h;
  protected float i;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    b = AIOUtils.b(22.0F, localResources);
    d = AIOUtils.b(14.0F, localResources);
    c = Math.min(localResources.getDisplayMetrics().widthPixels - TextLayer.b, AIOUtils.b(270.0F, localResources));
  }
  
  public NormalTextItem()
  {
    this(0, DynamicTextBuilder.a(0));
  }
  
  public NormalTextItem(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.g.setTypeface(Typeface.DEFAULT);
    this.g.setTextAlign(Paint.Align.CENTER);
    this.g.setAntiAlias(true);
    this.g.setStyle(Paint.Style.FILL_AND_STROKE);
    this.g.setTextSize(b);
    this.g.setColor(-1);
    this.g.setTextAlign(Paint.Align.LEFT);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
    this.k = b;
  }
  
  public void a(int paramInt)
  {
    this.g.setColor(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject = super.c(paramInt);
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "　　";
    }
    if (this.l) {
      this.g.setTextSize(this.k);
    }
    this.n = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.g, c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    int j = this.n.getLineCount();
    int k = this.f;
    paramInt = 0;
    localObject = paramString;
    if (j > k)
    {
      j = this.n.getLineEnd(this.f - 1);
      localObject = paramString;
      if (j < paramString.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.subSequence(0, j));
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.n = StaticLayoutWithMaxLines.a((CharSequence)localObject, 0, ((String)localObject).length(), this.g, c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    }
    if (this.n.getLineCount() == 1)
    {
      this.h = this.g.measureText((String)localObject);
      this.i = (this.g.descent() - this.g.ascent());
      return;
    }
    float f1 = 0.0F;
    while (paramInt < this.n.getLineCount())
    {
      f1 = Math.max(f1, this.n.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.h = f1;
    this.i = this.n.getHeight();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      float f1;
      Object localObject;
      if (this.n.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(c() / 2.0F, d() / 2.0F);
        this.g.setTextAlign(Paint.Align.CENTER);
        f1 = -((this.g.descent() + this.g.ascent()) / 2.0F);
        String str = super.c(0);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "　　";
        }
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.g);
        if (super.f(0))
        {
          int j = (int)this.g.measureText((String)localObject);
          int k = (int)Math.ceil(this.g.descent() - this.g.ascent());
          localObject = this.e;
          ((RectF)localObject).left = (-j / 2.0F);
          ((RectF)localObject).top = (-k / 2.0F);
          ((RectF)localObject).right = (j / 2.0F);
          ((RectF)localObject).bottom = (k / 2.0F);
          paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, s());
        }
        paramCanvas.restore();
        return;
      }
      this.g.setTextAlign(Paint.Align.LEFT);
      paramCanvas.save();
      this.n.draw(paramCanvas);
      if (super.f(0))
      {
        f1 = super.a(this.n);
        float f2 = this.n.getHeight();
        localObject = this.e;
        ((RectF)localObject).left = 0.0F;
        ((RectF)localObject).top = 0.0F;
        ((RectF)localObject).right = f1;
        ((RectF)localObject).bottom = f2;
        paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, s());
      }
      paramCanvas.restore();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramInt3 -= 10;
    while (paramInt3 > d)
    {
      g(paramInt3);
      a(paramInt1, paramString);
      if (this.n.getHeight() < paramInt2)
      {
        paramInt3 = 0;
        break label57;
      }
      paramInt3 -= 10;
    }
    paramInt3 = 1;
    label57:
    if (paramInt3 == 0) {
      return false;
    }
    double d1 = this.n.getHeight();
    double d2 = this.n.getLineCount();
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    d2 = paramInt2;
    Double.isNaN(d2);
    this.f = ((int)(d2 / d1));
    a(paramInt1, paramString);
    return true;
  }
  
  public int b()
  {
    return 1;
  }
  
  public int b(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    int j = paramInt3 + 10;
    g(j);
    a(paramInt1, paramString);
    if (this.n.getHeight() < paramInt2) {
      return j;
    }
    g(paramInt3);
    a(paramInt1, paramString);
    return paramInt3;
  }
  
  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean b(String paramString)
  {
    int j = this.n.getLineCount();
    j = this.n.getLineEnd(j - 1);
    return paramString.length() > j + 1;
  }
  
  public float c()
  {
    return this.h;
  }
  
  public float d()
  {
    return this.i;
  }
  
  public int g()
  {
    return 0;
  }
  
  public void g(int paramInt)
  {
    this.g.setTextSize(paramInt);
    this.k = paramInt;
    this.l = true;
  }
  
  public int u()
  {
    return this.g.getColor();
  }
  
  public boolean v()
  {
    return this.a;
  }
  
  public int w()
  {
    if (this.n == null) {
      return 0;
    }
    return this.n.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem
 * JD-Core Version:    0.7.0.1
 */