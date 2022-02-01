package com.tencent.aelight.camera.aioeditor.capture.text;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSizeTextItem
  extends DynamicTextItem
{
  StaticLayout a;
  TextPaint b;
  RectF c = new RectF();
  Random d = new Random();
  public int[] e = { 12, 20, 24 };
  Context f;
  public int g = 0;
  private float h;
  private String i = "";
  private RectF j = new RectF();
  private InputFilter p = null;
  
  public RandomSizeTextItem(Context paramContext, int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.f = paramContext;
    this.g = a(paramContext, 235.0F);
    this.b = new TextPaint();
    this.b.setAntiAlias(true);
    this.b.setTypeface(paramTypeface);
    this.b.setTextSize(AIOUtils.b(28.0F, paramContext.getResources()));
    this.b.setColor(-1);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public ArrayList<Integer> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.e;
    int m = localObject.length;
    int k = 0;
    while (k < m)
    {
      localArrayList2.add(Integer.valueOf(localObject[k]));
      k += 1;
    }
    Collections.shuffle(localArrayList2);
    int i1 = paramArrayOfString.length;
    k = 0;
    m = 0;
    while (k < i1)
    {
      localObject = paramArrayOfString[k];
      Integer localInteger = (Integer)localArrayList2.get(m % localArrayList2.size());
      int i2 = ((String)localObject).length();
      int n = 0;
      while (n < i2)
      {
        int i3 = ((String)localObject).charAt(n);
        if ((i3 != 8220) && (i3 != 8221)) {
          localArrayList1.add(localInteger);
        } else {
          localArrayList1.add(Integer.valueOf(48));
        }
        n += 1;
      }
      m += 1;
      k += 1;
    }
    return localArrayList1;
  }
  
  @TargetApi(18)
  public void a(int paramInt, String paramString)
  {
    int k = 0;
    if ((TextUtils.equals(super.b(0), paramString)) && (this.a != null)) {
      return;
    }
    super.a(paramInt, paramString);
    paramString = super.a(paramInt, new RandomSizeTextItem.1(this));
    this.i = paramString;
    paramString = b(b(paramString));
    this.a = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.b, this.g, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
    if (this.a.getLineCount() >= 3)
    {
      paramInt = this.a.getLineEnd(2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.subSequence(0, paramInt - 1));
      localStringBuilder.append("”");
      paramString = localStringBuilder.toString();
      this.a = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.b, this.g, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
    }
    int m = this.a.getLineCount();
    float f1 = 0.0F;
    paramInt = k;
    while (paramInt < m)
    {
      f1 = Math.max(f1, this.a.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.h = f1;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 0.0F);
      this.a.draw(paramCanvas);
      if (super.f(0))
      {
        int k = AIOUtils.b(5.0F, this.f.getResources());
        RectF localRectF = this.j;
        float f1 = k;
        localRectF.left = f1;
        localRectF.top = (-k);
        localRectF.right = (c() + f1);
        this.j.bottom = (d() + f1);
        paramCanvas.drawRoundRect(this.j, 6.0F, 6.0F, s());
      }
      paramCanvas.restore();
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
  
  public CharSequence b(String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("“");
    int m = paramArrayOfString.length;
    int k = 0;
    while (k < m)
    {
      ((StringBuilder)localObject).append(paramArrayOfString[k]);
      k += 1;
    }
    ((StringBuilder)localObject).append("”");
    paramArrayOfString = a(paramArrayOfString);
    paramArrayOfString.add(0, Integer.valueOf(48));
    paramArrayOfString.add(Integer.valueOf(48));
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    int n = ((SpannableString)localObject).length();
    for (k = 1; k < n - 1; k = m)
    {
      AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(AIOUtils.b(((Integer)paramArrayOfString.get(k)).intValue(), this.f.getResources()));
      m = k + 1;
      ((SpannableString)localObject).setSpan(localAbsoluteSizeSpan, k, m, 33);
    }
    return localObject;
  }
  
  public String[] b(String paramString)
  {
    int n = paramString.length();
    int k = 0;
    int m = 0;
    if (n <= 7)
    {
      String[] arrayOfString2 = new String[n];
      for (k = m;; k = m)
      {
        arrayOfString1 = arrayOfString2;
        if (k >= n) {
          break;
        }
        m = k + 1;
        arrayOfString2[k] = paramString.substring(k, m);
      }
    }
    String[] arrayOfString1 = new String[7];
    int i1;
    for (m = 0; k < 7; m = i1)
    {
      i1 = this.d.nextInt(n - (7 - k) + 1) + 1;
      n -= i1;
      i1 += m;
      arrayOfString1[k] = paramString.substring(m, i1);
      k += 1;
    }
    return arrayOfString1;
  }
  
  public float c()
  {
    StaticLayout localStaticLayout = this.a;
    if (localStaticLayout != null) {
      return localStaticLayout.getWidth();
    }
    return 0.0F;
  }
  
  public float d()
  {
    StaticLayout localStaticLayout = this.a;
    if (localStaticLayout != null) {
      return localStaticLayout.getHeight();
    }
    return 0.0F;
  }
  
  public boolean e()
  {
    return (TextUtils.isEmpty(this.i)) || (super.e());
  }
  
  public InputFilter f()
  {
    if (this.p == null) {
      this.p = new RandomSizeTextItem.2(this, 20);
    }
    return this.p;
  }
  
  public int g()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RandomSizeTextItem
 * JD-Core Version:    0.7.0.1
 */