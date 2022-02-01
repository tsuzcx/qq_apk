package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class GridTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float;
  Resources jdField_a_of_type_AndroidContentResResources;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = null;
  private String jdField_a_of_type_JavaLangString;
  List<Bitmap> jdField_a_of_type_JavaUtilList = new ArrayList(2);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public GridTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, List<Bitmap> paramList1)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.b(9.0F, this.jdField_a_of_type_AndroidContentResResources));
    this.g = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null);
    paramInt = this.jdField_b_of_type_Int;
    if (paramInt <= 0)
    {
      this.jdField_b_of_type_Int = (paramInt + this.g);
      this.jdField_b_of_type_Int += AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentResResources);
      this.jdField_b_of_type_Int += ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getHeight();
    }
    paramInt = this.c;
    if (paramInt <= 0)
    {
      this.c = (paramInt + this.g);
      this.c += AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentResResources);
      this.c += ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getHeight();
    }
    if (this.h <= 0) {
      this.h = AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentResResources);
    }
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public float a()
  {
    return this.d + this.h * 2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.jdField_a_of_type_JavaLangString = super.b(paramInt);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceAll("\\n", "");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceAll("\\r", "");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = " ";
    }
    else
    {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Boolean = false;
    paramInt = SpellUtil.a(this.jdField_a_of_type_JavaLangString);
    if (paramInt < 5)
    {
      this.f = 1;
      this.d = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth() * paramInt);
      if (paramInt > 1) {
        this.d += (paramInt - 1) * AIOUtils.b(9.0F, this.jdField_a_of_type_AndroidContentResResources);
      }
      if (this.jdField_b_of_type_Boolean) {
        paramInt = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getHeight();
      } else {
        paramInt = this.jdField_b_of_type_Int;
      }
      this.e = paramInt;
      return;
    }
    this.d = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getWidth() * 5 + AIOUtils.b(9.0F, this.jdField_a_of_type_AndroidContentResResources) * 4);
    this.f = (paramInt / 5);
    if (paramInt % 5 > 0) {
      this.f += 1;
    }
    paramInt = this.f;
    this.e = ((paramInt - 1) * this.c + (paramInt - 1) * AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentResResources));
    int i = this.e;
    if (this.jdField_a_of_type_Boolean) {
      paramInt = (int)(this.jdField_a_of_type_Float * this.c + 0.5F);
    } else {
      paramInt = this.c;
    }
    this.e = (i + paramInt);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    int i2;
    if (SpellUtil.a(this.jdField_a_of_type_JavaLangString) < 5) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (i2 != 0) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.get(0);
    } else {
      localObject1 = this.jdField_a_of_type_JavaUtilList.get(1);
    }
    int i = ((Bitmap)localObject1).getWidth();
    if (i2 != 0) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.get(0);
    } else {
      localObject1 = this.jdField_a_of_type_JavaUtilList.get(1);
    }
    int i4 = ((Bitmap)localObject1).getHeight();
    int i5 = AIOUtils.b(9.0F, this.jdField_a_of_type_AndroidContentResResources);
    int m = AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentResResources);
    int i6 = AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentResResources);
    int k;
    if (i2 != 0) {
      k = this.jdField_b_of_type_Int;
    } else {
      k = this.c;
    }
    if (i2 != 0) {
      f1 = 40.0F;
    } else {
      f1 = 36.0F;
    }
    int j = AIOUtils.b(f1, this.jdField_a_of_type_AndroidContentResResources);
    float f1 = AIOUtils.b(9.0F, this.jdField_a_of_type_AndroidContentResResources);
    Object localObject1 = this.jdField_a_of_type_AndroidTextTextPaint;
    float f2 = j;
    ((TextPaint)localObject1).setTextSize(f2);
    int i7 = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null);
    paramCanvas.save();
    j = this.h;
    paramCanvas.translate(j, j);
    if (this.jdField_b_of_type_Boolean)
    {
      paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    else
    {
      paramCanvas.save();
      j = 0;
      int n = 0;
      for (;;)
      {
        int i1 = this.f;
        if (j >= i1) {
          break;
        }
        if ((this.jdField_a_of_type_Boolean) && (j == i1 - 1)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        paramCanvas.save();
        float f3;
        if (i1 != 0)
        {
          i1 = 6;
          f3 = this.jdField_a_of_type_Float;
          paramCanvas.scale(f3, f3);
        }
        else
        {
          i1 = 5;
        }
        int i3 = 0;
        while ((i3 < i1) && (n < this.jdField_a_of_type_JavaLangString.length()))
        {
          int i8 = SpellUtil.a(this.jdField_a_of_type_JavaLangString.charAt(n));
          if (i8 == 2) {
            localObject1 = this.jdField_a_of_type_JavaLangString.substring(n, n + 2);
          } else {
            localObject1 = this.jdField_a_of_type_JavaLangString.substring(n, n + 1);
          }
          f3 = i * 0.5F;
          if ((i8 != 0) && (i8 != 3)) {
            break label541;
          }
          Object localObject2;
          if (i8 == 3) {
            localObject2 = localObject1;
          } else {
            localObject2 = ChnToSpell.a((String)localObject1, 1).jdField_a_of_type_JavaLangString;
          }
          this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f1);
          float f4 = this.g;
          float f5 = this.jdField_a_of_type_AndroidTextTextPaint.descent();
          this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
          paramCanvas.drawText((String)localObject2, f3, f4 - f5, this.jdField_a_of_type_AndroidTextTextPaint);
          label541:
          paramCanvas.save();
          paramCanvas.translate(0.0F, this.g + i6);
          if (i2 != 0) {
            localObject2 = (Bitmap)this.jdField_a_of_type_JavaUtilList.get(0);
          } else {
            localObject2 = (Bitmap)this.jdField_a_of_type_JavaUtilList.get(1);
          }
          paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
          paramCanvas.restore();
          this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f2);
          paramCanvas.drawText((String)localObject1, f3, this.g + i6 + (i4 - i7) * 0.5F - this.jdField_a_of_type_AndroidTextTextPaint.ascent(), this.jdField_a_of_type_AndroidTextTextPaint);
          if (i8 == 2) {
            n += 2;
          } else {
            n += 1;
          }
          paramCanvas.translate(i + i5, 0.0F);
          i3 += 1;
        }
        paramCanvas.restore();
        paramCanvas.translate(0.0F, k + m);
        j += 1;
      }
      paramCanvas.restore();
    }
    paramCanvas.restore();
    if (super.b(0))
    {
      localObject1 = this.jdField_a_of_type_AndroidGraphicsRectF;
      ((RectF)localObject1).left = 0.0F;
      ((RectF)localObject1).top = 0.0F;
      ((RectF)localObject1).right = a();
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = b();
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.e + this.h * 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.GridTextItem
 * JD-Core Version:    0.7.0.1
 */