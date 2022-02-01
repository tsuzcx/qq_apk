package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class NormalRectTagTextItem
  extends NormalTextItem
{
  public static final int b;
  private static final int g;
  private static final int i;
  private Paint a;
  private RectF b;
  private int h = Color.parseColor("#FFFFFF");
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    i = AIOUtils.b(1.0F, localResources);
    jdField_b_of_type_Int = AIOUtils.b(22.0F, localResources);
    g = AIOUtils.b(11.0F, localResources);
  }
  
  public NormalRectTagTextItem(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16777215);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(230);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float + jdField_b_of_type_Int * 2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(230);
    this.h = paramInt;
    if ((paramInt != Color.parseColor("#FFFFFF")) && (paramInt != Color.parseColor("#F7E368")) && (paramInt != Color.parseColor("#7ED5F8")))
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#ffffff"));
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#000000"));
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(a() / 2.0F, b() / 2.0F);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
        Object localObject2 = super.b(0);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "　　";
        }
        j = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject1);
        int k = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
        localObject2 = this.jdField_b_of_type_AndroidGraphicsRectF;
        int m = jdField_b_of_type_Int;
        ((RectF)localObject2).left = (-(m * 2 + j) / 2.0F);
        ((RectF)localObject2).right = ((m * 2 + j) / 2.0F);
        m = g;
        ((RectF)localObject2).top = (-(m * 2 + k) / 2.0F);
        ((RectF)localObject2).bottom = ((m * 2 + k) / 2.0F);
        m = i;
        paramCanvas.drawRoundRect((RectF)localObject2, m, m, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawText((String)localObject1, 0.0F, -((this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F), this.jdField_a_of_type_AndroidTextTextPaint);
        if (super.b(0))
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.left = (-j / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.top = (-k / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.right = (j / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (k / 2.0F);
          paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
        }
        paramCanvas.restore();
        return;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      paramCanvas.save();
      paramCanvas.translate(jdField_b_of_type_Int, g);
      float f1 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      Object localObject1 = this.jdField_b_of_type_AndroidGraphicsRectF;
      int j = jdField_b_of_type_Int;
      ((RectF)localObject1).left = (-j);
      ((RectF)localObject1).right = (j + f1);
      j = g;
      ((RectF)localObject1).top = (-j);
      ((RectF)localObject1).bottom = (j + f2);
      j = i;
      paramCanvas.drawRoundRect((RectF)localObject1, j, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = f1;
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = f2;
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      paramCanvas.restore();
    }
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float + g * 2;
  }
  
  public int e()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.NormalRectTagTextItem
 * JD-Core Version:    0.7.0.1
 */