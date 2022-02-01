package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.Context;
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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LangTextItem
  extends DynamicTextItem
{
  private TextPaint a;
  private TextPaint b;
  private Resources c;
  private ArrayList<String> d = new ArrayList();
  private ArrayList<Integer> e = new ArrayList();
  private ArrayList<ArrayList<Integer>> f = new ArrayList();
  private ArrayList<Integer> g = new ArrayList();
  private Bitmap h;
  private int i;
  private int j;
  private int p;
  private Rect q = new Rect();
  private InputFilter r = null;
  
  public LangTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface1, Typeface paramTypeface2, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(BaseApplicationImpl.getContext(), paramTypeface1, paramTypeface2, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * this.c.getDisplayMetrics().density);
  }
  
  private int a(ArrayList<Integer> paramArrayList)
  {
    int k = this.j * 2;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Integer localInteger = (Integer)paramArrayList.next();
      if (localInteger.intValue() > k) {
        k = localInteger.intValue();
      }
    }
    return k;
  }
  
  private void a(Context paramContext, Typeface paramTypeface1, Typeface paramTypeface2, Bitmap paramBitmap)
  {
    this.c = paramContext.getResources();
    this.h = paramBitmap;
    a(paramTypeface2, paramTypeface1);
    this.q.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  private void a(Typeface paramTypeface1, Typeface paramTypeface2)
  {
    this.a = new TextPaint();
    this.a.setTypeface(paramTypeface2);
    this.a.setAntiAlias(true);
    this.a.setColor(Color.parseColor("#ffffff"));
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setTextSize(a(79.5F));
    this.a.setTextAlign(Paint.Align.CENTER);
    this.j = ((int)this.a.measureText(HardCodeUtil.a(2131903945)));
    this.b = new TextPaint();
    this.b.setTypeface(paramTypeface1);
    this.b.setAntiAlias(true);
    this.b.setColor(Color.parseColor("#ffffff"));
    this.b.setStyle(Paint.Style.FILL_AND_STROKE);
    this.b.setTextSize(a(14.0F));
    this.a.setTextAlign(Paint.Align.LEFT);
    this.p = ((int)(this.j * 1.3F));
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.d.clear();
    this.g.clear();
    paramString = super.a(paramInt, new LangTextItem.1(this)).split("\n");
    int k = paramString.length;
    paramInt = 0;
    while (paramInt < k)
    {
      Object localObject = paramString[paramInt];
      if ((((String)localObject).length() == 6) && (k == 1))
      {
        this.d.add(localObject);
        this.g.add(Integer.valueOf((int)this.a.measureText((String)localObject)));
      }
      else
      {
        String str;
        if (((String)localObject).length() > 15)
        {
          str = ((String)localObject).substring(0, 5);
          this.d.add(str);
          this.g.add(Integer.valueOf((int)this.a.measureText(str)));
          str = ((String)localObject).substring(5, 10);
          this.d.add(str);
          this.g.add(Integer.valueOf((int)this.a.measureText(str)));
          str = ((String)localObject).substring(10, 15);
          this.d.add(str);
          this.g.add(Integer.valueOf((int)this.a.measureText(str)));
          localObject = ((String)localObject).substring(15, ((String)localObject).length());
          this.d.add(localObject);
          this.g.add(Integer.valueOf((int)this.a.measureText((String)localObject)));
        }
        else if (((String)localObject).length() > 10)
        {
          str = ((String)localObject).substring(0, 5);
          this.d.add(str);
          this.g.add(Integer.valueOf((int)this.a.measureText(str)));
          str = ((String)localObject).substring(5, 10);
          this.d.add(str);
          this.g.add(Integer.valueOf((int)this.a.measureText(str)));
          localObject = ((String)localObject).substring(10, ((String)localObject).length());
          this.d.add(localObject);
          this.g.add(Integer.valueOf((int)this.a.measureText((String)localObject)));
        }
        else if (((String)localObject).length() > 5)
        {
          str = ((String)localObject).substring(0, 5);
          this.d.add(str);
          this.g.add(Integer.valueOf((int)this.a.measureText(str)));
          localObject = ((String)localObject).substring(5, ((String)localObject).length());
          this.d.add(localObject);
          this.g.add(Integer.valueOf((int)this.a.measureText((String)localObject)));
        }
        else
        {
          this.d.add(localObject);
          this.g.add(Integer.valueOf((int)this.a.measureText((String)localObject)));
        }
      }
      paramInt += 1;
    }
    this.i = a(this.g);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (super.f(0)) {
      paramCanvas.drawRoundRect(new RectF(5.0F, 5.0F, c() - 5.0F, d() - 5.0F), 6.0F, 6.0F, s());
    }
    paramCanvas.save();
    paramCanvas.translate(this.i - a(77.0F), this.p - a(78.0F));
    Object localObject1 = new RectF();
    ((RectF)localObject1).set(0.0F, 0.0F, a(45.0F), a(45.0F));
    paramCanvas.drawBitmap(this.h, this.q, (RectF)localObject1, null);
    paramCanvas.restore();
    int k = this.p;
    int n = this.d.size();
    int m = 0;
    while (m < n)
    {
      int i1 = (this.i - ((Integer)this.g.get(m)).intValue()) / 2;
      localObject1 = (String)this.d.get(m);
      int i3 = 0;
      int i2 = 0;
      while (i3 < ((String)localObject1).length())
      {
        int i4 = i3 + 1;
        Object localObject3 = ((String)localObject1).substring(i3, i4);
        Object localObject2;
        if (SpellUtil.a(((String)localObject3).charAt(0)) == 3) {
          localObject2 = localObject3;
        } else {
          localObject2 = ChnToSpell.a((String)localObject3, 1).b;
        }
        Rect localRect = new Rect();
        this.a.getTextBounds((String)localObject3, 0, 1, localRect);
        int i6 = Math.abs(localRect.top - localRect.bottom) + 20;
        int i5 = Math.abs(localRect.right - localRect.left) + 20;
        float f1 = i1;
        paramCanvas.drawText((String)localObject3, f1, k - this.p * 0.085F, this.a);
        int i7 = this.p;
        float f2 = k - i7 + (i7 - i6) / 2;
        i3 = i1 + i5;
        localObject3 = new RectF(f1, f2, i3, k - i7 + (i7 + i6) / 2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localRect = new Rect();
          this.b.getTextBounds((String)localObject2, 0, ((String)localObject2).length(), localRect);
          i6 = localRect.right - localRect.left;
          if (i2 % 2 == 0) {
            paramCanvas.drawText((String)localObject2, i1 + (i5 - i6) / 2, ((RectF)localObject3).top, this.b);
          } else {
            paramCanvas.drawText((String)localObject2, i1 + (i5 - i6) / 2, ((RectF)localObject3).bottom + 30.0F, this.b);
          }
        }
        i2 += 1;
        i1 = i3;
        i3 = i4;
      }
      k += this.p;
      m += 1;
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
    return this.i + 10;
  }
  
  public float d()
  {
    int m = this.p;
    int k;
    if (this.d.size() == 0) {
      k = 1;
    } else {
      k = this.d.size();
    }
    return m * k + 10;
  }
  
  public InputFilter f()
  {
    if (this.r == null) {
      this.r = new LangTextItem.2(this, 20);
    }
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.LangTextItem
 * JD-Core Version:    0.7.0.1
 */