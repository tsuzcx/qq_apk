package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;

public class TextDrawImplement
{
  private ArrayList<PerLineModel> a = new ArrayList();
  private TextDrawer b;
  private int c = 0;
  private BaseBackgroundDrawer d;
  private float e = 0.0F;
  private float f = 0.0F;
  
  public TextDrawImplement(int paramInt)
  {
    if (paramInt == 1)
    {
      this.b = new PerLineDrawer();
      return;
    }
    if (paramInt == 0) {
      return;
    }
    throw new IllegalArgumentException("TextDrawImplement init failed");
  }
  
  public float a()
  {
    RectF localRectF = new RectF();
    localRectF.left = 3.4028235E+38F;
    localRectF.top = 3.4028235E+38F;
    localRectF.right = 1.4E-45F;
    localRectF.bottom = 1.4E-45F;
    int i = 0;
    while (i < this.a.size())
    {
      PerLineModel localPerLineModel = (PerLineModel)this.a.get(i);
      if (localRectF.left > localPerLineModel.c.left) {
        localRectF.left = localPerLineModel.c.left;
      }
      if (localRectF.right < localPerLineModel.c.right) {
        localRectF.right = localPerLineModel.c.right;
      }
      if (localRectF.top > localPerLineModel.c.top) {
        localRectF.top = localPerLineModel.c.top;
      }
      if (localRectF.bottom < localPerLineModel.c.bottom) {
        localRectF.bottom = localPerLineModel.c.bottom;
      }
      i += 1;
    }
    return localRectF.width();
  }
  
  public int a(int paramInt)
  {
    return ((PerLineModel)this.a.get(paramInt)).e.length();
  }
  
  public RectF a(int paramInt1, int paramInt2)
  {
    paramInt1 -= 1;
    paramInt2 -= 1;
    if ((paramInt1 >= 0) && (paramInt1 < this.a.size()) && (paramInt2 >= 0) && (paramInt2 < this.a.size()) && (paramInt2 >= paramInt1))
    {
      RectF localRectF = new RectF();
      localRectF.left = 3.4028235E+38F;
      localRectF.top = 3.4028235E+38F;
      localRectF.right = 1.4E-45F;
      localRectF.bottom = 1.4E-45F;
      while (paramInt1 <= paramInt2)
      {
        PerLineModel localPerLineModel = (PerLineModel)this.a.get(paramInt1);
        if (localRectF.left > localPerLineModel.c.left) {
          localRectF.left = localPerLineModel.c.left;
        }
        if (localRectF.right < localPerLineModel.c.right) {
          localRectF.right = localPerLineModel.c.right;
        }
        if (localRectF.top > localPerLineModel.c.top) {
          localRectF.top = localPerLineModel.c.top;
        }
        if (localRectF.bottom < localPerLineModel.c.bottom) {
          localRectF.bottom = localPerLineModel.c.bottom;
        }
        paramInt1 += 1;
      }
      return localRectF;
    }
    return null;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.c == 2)
    {
      localObject = this.d;
      if (localObject != null) {
        ((BaseBackgroundDrawer)localObject).a(paramCanvas, this.a, paramInt1, paramInt2);
      }
    }
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PerLineModel localPerLineModel = (PerLineModel)((Iterator)localObject).next();
      if (this.c == 1)
      {
        BaseBackgroundDrawer localBaseBackgroundDrawer = this.d;
        if (localBaseBackgroundDrawer != null) {
          localPerLineModel.a(paramCanvas, localBaseBackgroundDrawer, paramInt1, paramInt2);
        }
      }
      localPerLineModel.a(paramCanvas, paramInt1, paramInt2);
    }
  }
  
  public void a(BaseBackgroundDrawer paramBaseBackgroundDrawer)
  {
    this.c = 2;
    this.d = paramBaseBackgroundDrawer;
  }
  
  public void a(BaseCovert paramBaseCovert)
  {
    int i = 0;
    while (i < this.a.size())
    {
      paramBaseCovert.a(i, (PerLineModel)this.a.get(i));
      i += 1;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    if (paramTextPaint == null) {
      paramTextPaint = new TextPaint();
    }
    paramTextPaint.setTextSize(paramInt2);
    StaticLayout localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.a.clear();
    float f1 = 0.0F;
    paramInt1 = 0;
    while (paramInt1 < localStaticLayout.getLineCount())
    {
      Object localObject = new RectF();
      String str = paramCharSequence.subSequence(localStaticLayout.getLineStart(paramInt1), localStaticLayout.getLineEnd(paramInt1)).toString();
      Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
      float f2 = paramTextPaint.measureText(str, 0, str.length());
      float f3 = Math.abs(localFontMetrics.bottom - localFontMetrics.top);
      float f4 = Math.abs(localFontMetrics.ascent);
      ((RectF)localObject).left = 0.0F;
      ((RectF)localObject).right = (0.0F + f2);
      ((RectF)localObject).top = f1;
      f1 += f3;
      ((RectF)localObject).bottom = f1;
      localObject = new PerLineModel(0, 0, paramTextPaint, str, (RectF)localObject, f4);
      this.a.add(localObject);
      if (this.e < f2) {
        this.e = f2;
      }
      this.f += f3;
      paramInt1 += 1;
    }
  }
  
  public float b()
  {
    RectF localRectF = new RectF();
    localRectF.left = 3.4028235E+38F;
    localRectF.top = 3.4028235E+38F;
    localRectF.right = 1.4E-45F;
    localRectF.bottom = 1.4E-45F;
    int i = 0;
    while (i < this.a.size())
    {
      PerLineModel localPerLineModel = (PerLineModel)this.a.get(i);
      if (localRectF.left > localPerLineModel.c.left) {
        localRectF.left = localPerLineModel.c.left;
      }
      if (localRectF.right < localPerLineModel.c.right) {
        localRectF.right = localPerLineModel.c.right;
      }
      if (localRectF.top > localPerLineModel.c.top) {
        localRectF.top = localPerLineModel.c.top;
      }
      if (localRectF.bottom < localPerLineModel.c.bottom) {
        localRectF.bottom = localPerLineModel.c.bottom;
      }
      i += 1;
    }
    return localRectF.height();
  }
  
  public RectF b(int paramInt)
  {
    return ((PerLineModel)this.a.get(paramInt)).c;
  }
  
  public void b(BaseBackgroundDrawer paramBaseBackgroundDrawer)
  {
    this.c = 1;
    this.d = paramBaseBackgroundDrawer;
  }
  
  public int c()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.TextDrawImplement
 * JD-Core Version:    0.7.0.1
 */