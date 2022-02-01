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
  public static final int c;
  public static final int d;
  public static final int e;
  protected float a;
  protected RectF a;
  protected TextPaint a;
  private boolean a;
  protected float b;
  protected int f = 2147483647;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_c_of_type_Int = AIOUtils.b(22.0F, localResources);
    e = AIOUtils.b(14.0F, localResources);
    d = Math.min(localResources.getDisplayMetrics().widthPixels - TextLayer.jdField_a_of_type_Int, AIOUtils.b(270.0F, localResources));
  }
  
  public NormalTextItem()
  {
    this(0, DynamicTextBuilder.a(0));
  }
  
  public NormalTextItem(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
    this.jdField_a_of_type_Int = jdField_c_of_type_Int;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    int i = paramInt3 + 10;
    c(i);
    a(paramInt1, paramString);
    if (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() < paramInt2) {
      return i;
    }
    c(paramInt3);
    a(paramInt1, paramString);
    return paramInt3;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject = super.b(paramInt);
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "　　";
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, d, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    int i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
    int j = this.f;
    paramInt = 0;
    localObject = paramString;
    if (i > j)
    {
      i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(this.f - 1);
      localObject = paramString;
      if (i < paramString.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.subSequence(0, i));
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a((CharSequence)localObject, 0, ((String)localObject).length(), this.jdField_a_of_type_AndroidTextTextPaint, d, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    }
    if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
      return;
    }
    float f1 = 0.0F;
    while (paramInt < this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount())
    {
      f1 = Math.max(f1, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      float f1;
      Object localObject;
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(a() / 2.0F, b() / 2.0F);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
        f1 = -((this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F);
        String str = super.b(0);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "　　";
        }
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.jdField_a_of_type_AndroidTextTextPaint);
        if (super.b(0))
        {
          int i = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject);
          int j = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
          localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
          ((RectF)localObject).left = (-i / 2.0F);
          ((RectF)localObject).top = (-j / 2.0F);
          ((RectF)localObject).right = (i / 2.0F);
          ((RectF)localObject).bottom = (j / 2.0F);
          paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, a());
        }
        paramCanvas.restore();
        return;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      paramCanvas.save();
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        f1 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
        float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
        localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
        ((RectF)localObject).left = 0.0F;
        ((RectF)localObject).top = 0.0F;
        ((RectF)localObject).right = f1;
        ((RectF)localObject).bottom = f2;
        paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, a());
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
    while (paramInt3 > e)
    {
      c(paramInt3);
      a(paramInt1, paramString);
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() < paramInt2)
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
    double d1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
    double d2 = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    d2 = paramInt2;
    Double.isNaN(d2);
    this.f = ((int)(d2 / d1));
    a(paramInt1, paramString);
    return true;
  }
  
  public boolean a(String paramString)
  {
    int i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
    i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(i - 1);
    return paramString.length() > i + 1;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getColor();
  }
  
  public int f()
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout == null) {
      return 0;
    }
    return this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem
 * JD-Core Version:    0.7.0.1
 */