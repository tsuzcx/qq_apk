package com.tencent.aelight.camera.aioeditor.capture.text;

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
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class FoodAloneTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float = 0.73F;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter = null;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "#ffffff";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_b_of_type_Float = 0.31F;
  private int jdField_b_of_type_Int;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public FoodAloneTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * paramFloat);
  }
  
  private void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a(paramTypeface);
    this.e = a(48.75F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.e);
    this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(HardCodeUtil.a(2131704808)));
    this.f = a(27.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.f);
    this.c = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(HardCodeUtil.a(2131704807)));
    this.g = a(18.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.g);
    this.d = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(HardCodeUtil.a(2131704809)));
    this.k = a(0.0F);
    this.l = a(0.0F);
    double d1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    Double.isNaN(d1);
    this.h = ((int)(d1 * 0.98D));
    d1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    Double.isNaN(d1);
    this.i = ((int)(d1 * 0.98D));
  }
  
  public float a()
  {
    return this.h;
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new FoodAloneTextItem.2(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = super.a(paramInt, new FoodAloneTextItem.1(this));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int n = paramString.length();
    if (n > 10)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(0, 10));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(10, Math.min(n, 20)));
      this.j = this.g;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
      this.m = this.d;
      n = this.m;
      paramInt = n * 2 + this.k;
      n = n * 10 + this.l * 9;
    }
    else if (n > 5)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.j = this.f;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
      this.m = this.c;
      paramInt = this.m;
      n = paramInt * n + this.l * Math.max(n - 1, 0);
      paramInt *= 1;
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.j = this.e;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
      this.m = this.jdField_b_of_type_Int;
      i1 = this.m;
      paramInt = n;
      if (n == 0) {
        paramInt = 2;
      }
      int i2 = this.m;
      int i3 = this.l;
      int i4 = Math.max(paramInt - 1, 0);
      n = i1 * 1;
      i1 = i2 * paramInt + i3 * i4;
      paramInt = n;
      n = i1;
    }
    float f1 = n;
    n = this.i;
    float f2 = n;
    float f3 = this.jdField_a_of_type_Float;
    if (f1 > f2 * f3)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, f1 - n * f3, this.h, n * (1.0F - f3) + f1);
      paramString = this.jdField_b_of_type_AndroidGraphicsRectF;
      n = this.h;
      f2 = n - paramInt;
      f3 = this.jdField_b_of_type_Float;
      paramString.set(f2 * f3, 0.0F, n * f3 + paramInt * (1.0F - f3), f1);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.h, n);
    paramString = this.jdField_b_of_type_AndroidGraphicsRectF;
    n = this.h;
    f2 = n - paramInt;
    f3 = this.jdField_b_of_type_Float;
    int i1 = this.i;
    float f4 = i1;
    float f5 = this.jdField_a_of_type_Float;
    paramString.set(f2 * f3, (f4 * f5 - f1) / 2.0F, n * f3 + paramInt * (1.0F - f3), (i1 * f5 + f1) / 2.0F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    Object localObject = new Rect();
    ((Rect)localObject).set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsRectF, null);
    if (super.b(0)) {
      paramCanvas.drawRoundRect(new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.left, this.jdField_b_of_type_AndroidGraphicsRectF.top, this.jdField_b_of_type_AndroidGraphicsRectF.right, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + this.m * 0.1F), 6.0F, 6.0F, a());
    }
    double d1 = this.jdField_b_of_type_AndroidGraphicsRectF.left;
    double d2 = this.m;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int i2 = (int)(d1 + d2 * 0.5D);
    int n = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.top + this.m);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      int i5 = ((String)localObject).length();
      int i4 = 0;
      int i3 = n;
      for (n = i4; n < i5; n = i4)
      {
        i4 = n + 1;
        paramCanvas.drawText(((String)localObject).substring(n, i4), i2, i3, this.jdField_a_of_type_AndroidTextTextPaint);
        i3 += this.m + this.l;
      }
      i2 += this.m + this.k;
      n = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.top + this.m);
      i1 -= 1;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.bottom - Math.min(this.jdField_b_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FoodAloneTextItem
 * JD-Core Version:    0.7.0.1
 */