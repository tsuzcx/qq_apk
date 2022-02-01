package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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

public class ShadowBubbleTextItem
  extends DynamicTextItem
{
  private static float[] g = { 62.0F, 35.5F, 8.0F, 13.0F, 117.0F, 35.0F, 22.0F, 14.0F, 181.0F, 40.0F, 25.0F, 13.0F };
  List<Bitmap> a = new ArrayList(3);
  Resources b = BaseApplicationImpl.getContext().getResources();
  private TextPaint c = null;
  private RectF d = new RectF();
  private int e;
  private float f = 0.0F;
  private InputFilter h = null;
  
  public ShadowBubbleTextItem(int paramInt, Typeface paramTypeface, @NonNull List<String> paramList, @NonNull List<Bitmap> paramList1)
  {
    super(paramInt, paramList);
    this.a.clear();
    this.a.addAll(paramList1);
    this.c = new TextPaint();
    if (paramTypeface != null) {
      this.c.setTypeface(paramTypeface);
    }
    this.c.setAntiAlias(true);
    this.c.setColor(-16777216);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString, Point paramPoint)
  {
    int i = paramInt3;
    while (i >= 16)
    {
      this.c.setTextSize(AIOUtils.b(i, this.b));
      StaticLayout localStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.c, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
      this.n = localStaticLayout;
      if ((localStaticLayout.getLineCount() > 1) && (localStaticLayout.getLineVisibleEnd(1) < paramString.length())) {
        paramInt3 = 0;
      } else {
        paramInt3 = 1;
      }
      if (localStaticLayout.getHeight() > paramInt2) {
        paramInt3 = 0;
      }
      if (paramInt3 != 0)
      {
        float f1 = super.a(localStaticLayout);
        float f2 = localStaticLayout.getHeight();
        paramPoint.set((int)(paramInt1 - f1), (int)(paramInt2 - f2));
        return true;
      }
      paramPoint.set(0, 0);
      i -= 2;
    }
    return false;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject1 = c(paramInt);
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "  ";
    }
    Object localObject3 = b(10, paramString);
    Object localObject4 = new Point[3];
    paramString = new float[3];
    Object localObject2 = new boolean[3];
    localObject1 = new StaticLayout[3];
    int[] arrayOfInt = new int[3];
    paramInt = 0;
    float f1;
    float f2;
    while (paramInt < 3)
    {
      localObject4[paramInt] = new Point(0, 0);
      localObject2[paramInt] = 0;
      float[] arrayOfFloat = g;
      i = paramInt * 4;
      f1 = AIOUtils.b(arrayOfFloat[i], this.b);
      f2 = AIOUtils.b(g[(i + 1)], this.b);
      localObject2[paramInt] = a((int)f1, (int)f2, 37, (String)localObject3, localObject4[paramInt]);
      localObject1[paramInt] = this.n;
      paramString[paramInt] = this.n.getPaint().getTextSize();
      paramInt += 1;
    }
    localObject3 = new float[3];
    paramInt = 0;
    while (paramInt < 3)
    {
      this.c.setTextSize(paramString[paramInt]);
      arrayOfInt[paramInt] = localObject1[paramInt].getLineCount();
      if (localObject2[paramInt] != 0)
      {
        localObject4 = g;
        i = paramInt * 4;
        f1 = AIOUtils.b(localObject4[i], this.b);
        f2 = AIOUtils.b(g[(i + 1)], this.b);
        localObject3[paramInt] = (super.a(localObject1[paramInt]) * localObject1[paramInt].getHeight() / (f1 * f2));
      }
      else
      {
        localObject3[paramInt] = 0.0F;
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("scale:");
        ((StringBuilder)localObject4).append(localObject3[paramInt]);
        ((StringBuilder)localObject4).append(" index:");
        ((StringBuilder)localObject4).append(paramInt);
        QLog.i("ShadowBubbleTextItem", 2, ((StringBuilder)localObject4).toString());
      }
      paramInt += 1;
    }
    paramInt = 2;
    int j;
    for (int i = 2; paramInt >= 0; i = j)
    {
      if ((localObject2[paramInt] != 1) || (localObject2[i] != 1) || (arrayOfInt[paramInt] >= arrayOfInt[i]))
      {
        j = i;
        if (localObject3[paramInt] > localObject3[i])
        {
          int k;
          if ((localObject2[paramInt] == 1) && (localObject2[i] == 1) && (arrayOfInt[paramInt] > arrayOfInt[i])) {
            k = 1;
          } else {
            k = 0;
          }
          j = i;
          if (k != 0) {}
        }
      }
      else
      {
        j = paramInt;
      }
      paramInt -= 1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("curIndex:");
      ((StringBuilder)localObject2).append(i);
      QLog.i("ShadowBubbleTextItem", 2, ((StringBuilder)localObject2).toString());
    }
    this.e = i;
    this.n = localObject1[i];
    this.c.setTextSize(paramString[i]);
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap((Bitmap)this.a.get(this.e), 0.0F, 0.0F, this.c);
    if (this.n != null)
    {
      float f3 = AIOUtils.b(g[(this.e * 4 + 2)], this.b);
      float f4 = AIOUtils.b(g[(this.e * 4 + 3)], this.b);
      float f5 = AIOUtils.b(g[(this.e * 4)], this.b);
      float f6 = AIOUtils.b(g[(this.e * 4 + 1)], this.b);
      float f1 = super.a(this.n);
      float f2 = this.n.getHeight();
      this.f = AIOUtils.b(2.0F, this.b);
      paramCanvas.translate(f3 + (f5 - f1) * 0.5F, f4 + (f6 - f2) * 0.5F);
      this.n.draw(paramCanvas);
      if (f(0))
      {
        RectF localRectF = this.d;
        f3 = this.f;
        localRectF.left = (0.0F - f3);
        localRectF.top = (0.0F - f3);
        localRectF.right = (f1 + f3 * 2.0F);
        localRectF.bottom = (f2 + f3 * 2.0F);
        paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, s());
      }
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
    return ((Bitmap)this.a.get(this.e)).getWidth();
  }
  
  public float d()
  {
    return ((Bitmap)this.a.get(this.e)).getHeight();
  }
  
  public InputFilter f()
  {
    if (this.h == null) {
      this.h = new ShadowBubbleTextItem.1(this, 20);
    }
    return this.h;
  }
  
  public int g()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.ShadowBubbleTextItem
 * JD-Core Version:    0.7.0.1
 */