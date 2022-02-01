package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class BasicTextRegionTextItem
  extends DynamicTextItem
{
  private InputFilter A = null;
  ArrayList<BaseTextRegion> a = new ArrayList();
  BaseTextRegion b = null;
  boolean c = false;
  boolean d = false;
  StaticLayout e;
  Resources f = BaseApplicationImpl.getContext().getResources();
  float g = 0.0F;
  float h = 0.0F;
  float i = 0.0F;
  float j = 0.0F;
  private Paint p = null;
  private TextPaint q = null;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private TextPaint x = null;
  private RectF y = new RectF();
  private float z = 0.0F;
  
  public BasicTextRegionTextItem(int paramInt, @NonNull List<String> paramList)
  {
    super(paramInt, paramList);
    this.q.setAntiAlias(true);
    this.q.setColor(-16777216);
    this.p = new Paint();
    this.p.setAntiAlias(true);
    this.x = new TextPaint();
    this.x.setAntiAlias(true);
    this.x.setStyle(Paint.Style.FILL_AND_STROKE);
    this.x.setStrokeJoin(Paint.Join.ROUND);
    this.x.setColor(-16777216);
    this.x.setStrokeWidth(AIOUtils.b(3.0F, BaseApplicationImpl.getContext().getResources()));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.d = true;
    if (this.d)
    {
      this.w = paramInt;
      this.t = AIOUtils.b(paramFloat1, BaseApplicationImpl.getApplication().getResources());
      this.u = AIOUtils.b(paramFloat2, BaseApplicationImpl.getApplication().getResources());
      this.v = AIOUtils.b(paramFloat3, BaseApplicationImpl.getApplication().getResources());
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat, int paramInt)
  {
    this.c = paramBoolean;
    if (this.c)
    {
      this.r = AIOUtils.b(paramFloat, BaseApplicationImpl.getContext().getResources());
      this.s = paramInt;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6, Point paramPoint)
  {
    int m = paramInt3;
    while (m >= paramInt4)
    {
      Object localObject1 = this.q;
      float f1 = m;
      ((TextPaint)localObject1).setTextSize(f1);
      this.x.setTextSize(f1);
      localObject1 = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.q, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      Object localObject2 = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.x, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      this.n = ((StaticLayout)localObject1);
      this.e = ((StaticLayout)localObject2);
      if (((StaticLayout)localObject1).getLineCount() > 1)
      {
        int k;
        if (((StaticLayout)localObject1).getLineVisibleEnd(1) < paramString.length()) {
          k = 0;
        } else {
          k = 1;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(paramString.length());
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(paramInt5);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(((StaticLayout)localObject1).getLineEnd(0));
          QLog.d("BasicTextRegionTextItem", 2, ((StringBuilder)localObject2).toString());
        }
        paramInt3 = k;
        if (paramString.length() >= paramInt5)
        {
          paramInt3 = k;
          if (((StaticLayout)localObject1).getLineEnd(0) < paramInt5) {
            paramInt3 = 0;
          }
        }
      }
      else
      {
        paramInt3 = 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("==>");
        ((StringBuilder)localObject2).append(((StaticLayout)localObject1).getHeight());
        ((StringBuilder)localObject2).append(" ==>");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append(" ==>");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" ==>");
        ((StringBuilder)localObject2).append(paramInt4);
        QLog.d("BasicTextRegionTextItem", 2, ((StringBuilder)localObject2).toString());
      }
      if (((StaticLayout)localObject1).getHeight() > paramInt2) {
        paramInt3 = 0;
      }
      if (paramInt3 != 0)
      {
        f1 = super.a((StaticLayout)localObject1);
        float f2 = ((StaticLayout)localObject1).getHeight();
        paramPoint.set((int)(paramInt1 - f1), (int)(paramInt2 - f2));
        return true;
      }
      paramPoint.set(0, 0);
      m -= 1;
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    this.q.setColor(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject1 = super.c(paramInt);
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "  ";
    }
    Object localObject2 = b(10, paramString);
    Object localObject3 = new Point[this.a.size()];
    localObject1 = new float[this.a.size()];
    boolean[] arrayOfBoolean = new boolean[this.a.size()];
    StaticLayout[] arrayOfStaticLayout1 = new StaticLayout[this.a.size()];
    StaticLayout[] arrayOfStaticLayout2 = new StaticLayout[this.a.size()];
    paramString = new int[this.a.size()];
    paramInt = 0;
    float f1;
    float f2;
    while (paramInt < this.a.size())
    {
      localObject3[paramInt] = new Point(0, 0);
      BaseTextRegion localBaseTextRegion = (BaseTextRegion)this.a.get(paramInt);
      arrayOfBoolean[paramInt] = false;
      f1 = localBaseTextRegion.c;
      f2 = localBaseTextRegion.d;
      arrayOfBoolean[paramInt] = a((int)f1, (int)f2, localBaseTextRegion.h, localBaseTextRegion.g, (String)localObject2, localBaseTextRegion.a, localBaseTextRegion.k, localObject3[paramInt]);
      arrayOfStaticLayout1[paramInt] = this.n;
      arrayOfStaticLayout2[paramInt] = this.e;
      localObject1[paramInt] = this.n.getPaint().getTextSize();
      paramInt += 1;
    }
    localObject2 = new float[this.a.size()];
    paramInt = 0;
    while (paramInt < this.a.size())
    {
      localObject3 = (BaseTextRegion)this.a.get(paramInt);
      this.q.setTextSize(localObject1[paramInt]);
      this.x.setTextSize(localObject1[paramInt]);
      paramString[paramInt] = arrayOfStaticLayout1[paramInt].getLineCount();
      if (arrayOfBoolean[paramInt] != 0)
      {
        f1 = AIOUtils.b(((BaseTextRegion)localObject3).c, this.f);
        f2 = AIOUtils.b(((BaseTextRegion)localObject3).d, this.f);
        localObject2[paramInt] = (super.a(arrayOfStaticLayout1[paramInt]) * arrayOfStaticLayout1[paramInt].getHeight() / (f1 * f2));
      }
      else
      {
        localObject2[paramInt] = 0.0F;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("scale:");
        ((StringBuilder)localObject3).append(localObject2[paramInt]);
        ((StringBuilder)localObject3).append(" index:");
        ((StringBuilder)localObject3).append(paramInt);
        QLog.i("BasicTextRegionTextItem", 2, ((StringBuilder)localObject3).toString());
      }
      paramInt += 1;
    }
    int k = this.a.size() - 1;
    paramInt = this.a.size() - 1;
    while (paramInt >= 0)
    {
      int m;
      if ((arrayOfBoolean[paramInt] != 1) || (arrayOfBoolean[k] != 1))
      {
        m = k;
        if (localObject2[paramInt] > localObject2[k])
        {
          int n;
          if ((arrayOfBoolean[paramInt] == 1) && (arrayOfBoolean[k] == 1) && (paramString[paramInt] > paramString[k])) {
            n = 1;
          } else {
            n = 0;
          }
          m = k;
          if (n != 0) {}
        }
      }
      else
      {
        m = paramInt;
      }
      paramInt -= 1;
      k = m;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("curIndex:");
      paramString.append(k);
      QLog.i("BasicTextRegionTextItem", 2, paramString.toString());
    }
    this.b = ((BaseTextRegion)this.a.get(k));
    this.n = arrayOfStaticLayout1[k];
    this.e = arrayOfStaticLayout2[k];
    this.q.setTextSize(localObject1[k]);
    this.x.setTextSize(localObject1[k]);
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap(this.b.i, 0.0F, 0.0F, this.p);
    if (this.n != null)
    {
      this.i = super.a(this.n);
      this.j = this.n.getHeight();
      this.g = (this.b.e + (this.b.c - this.i) / 2.0F);
      this.h = (this.b.f + (this.b.d - this.j) / 2.0F);
      paramCanvas.translate(this.g, this.h);
      if (this.c)
      {
        this.x.setStrokeWidth(this.r);
        this.x.setColor(this.s);
        this.e.draw(paramCanvas);
      }
      if (this.d)
      {
        this.x.setStrokeWidth(this.t);
        this.x.setColor(this.w);
        paramCanvas.translate(this.u, this.v);
        this.e.draw(paramCanvas);
        paramCanvas.translate(-this.u, -this.v);
      }
      this.n.draw(paramCanvas);
      if (super.f(0))
      {
        RectF localRectF = this.y;
        float f1 = this.z;
        localRectF.left = (0.0F - f1);
        localRectF.top = (0.0F - f1);
        localRectF.right = (this.i + f1 * 2.0F);
        localRectF.bottom = (this.j + f1 * 2.0F);
        paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, s());
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Typeface paramTypeface)
  {
    this.q.setTypeface(paramTypeface);
    this.x.setTypeface(paramTypeface);
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
    return this.b.i.getWidth();
  }
  
  public float d()
  {
    return this.b.i.getHeight();
  }
  
  public InputFilter f()
  {
    if (this.A == null) {
      this.A = new BasicTextRegionTextItem.1(this, 20);
    }
    return this.A;
  }
  
  public int g()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BasicTextRegionTextItem
 * JD-Core Version:    0.7.0.1
 */