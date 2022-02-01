package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NormalHighLightTextItem
  extends NormalTextItem
{
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  public NormalHighLightTextItem(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(jdField_c_of_type_Int);
    if (this.jdField_b_of_type_AndroidTextTextPaint == null) {
      this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint(this.jdField_a_of_type_AndroidTextTextPaint);
    }
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(2.0F);
    d();
  }
  
  private int a(Map<Integer, Integer> paramMap, int paramInt)
  {
    int i = paramInt;
    if (paramMap != null)
    {
      i = paramInt;
      if (paramMap.containsKey(Integer.valueOf(paramInt)))
      {
        paramMap = (Integer)paramMap.get(Integer.valueOf(paramInt));
        i = paramInt;
        if (paramMap != null)
        {
          i = paramInt;
          if (paramMap.intValue() > 0) {
            i = paramMap.intValue();
          }
        }
      }
    }
    return i;
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap;
    Integer localInteger1 = Integer.valueOf(-14079703);
    ((Map)localObject1).put(localInteger1, Integer.valueOf(-1275068417));
    Object localObject2 = this.jdField_a_of_type_JavaUtilMap;
    localObject1 = Integer.valueOf(-1);
    ((Map)localObject2).put(localObject1, Integer.valueOf(-869717719));
    Object localObject3 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = Integer.valueOf(-1027508);
    ((Map)localObject3).put(localObject2, Integer.valueOf(-27761));
    Object localObject4 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = Integer.valueOf(-1131223);
    ((Map)localObject4).put(localObject3, Integer.valueOf(-6997));
    Object localObject5 = this.jdField_a_of_type_JavaUtilMap;
    localObject4 = Integer.valueOf(-6038445);
    ((Map)localObject5).put(localObject4, Integer.valueOf(-5770946));
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    localObject5 = Integer.valueOf(-12147713);
    localMap.put(localObject5, Integer.valueOf(-4199169));
    localMap = this.jdField_a_of_type_JavaUtilMap;
    Integer localInteger2 = Integer.valueOf(-7768577);
    localMap.put(localInteger2, Integer.valueOf(-5464321));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-496479), Integer.valueOf(-20274));
    this.jdField_b_of_type_JavaUtilMap.put(localInteger1, Integer.valueOf(-2130706433));
    this.jdField_b_of_type_JavaUtilMap.put(localObject1, Integer.valueOf(-1003935447));
    this.jdField_b_of_type_JavaUtilMap.put(localObject2, Integer.valueOf(-62975));
    this.jdField_b_of_type_JavaUtilMap.put(localObject3, Integer.valueOf(-27136));
    this.jdField_b_of_type_JavaUtilMap.put(localObject4, Integer.valueOf(-5505226));
    this.jdField_b_of_type_JavaUtilMap.put(localObject5, Integer.valueOf(-16744193));
    this.jdField_b_of_type_JavaUtilMap.put(localInteger2, Integer.valueOf(-10682121));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(-496479), Integer.valueOf(-65439));
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(a(this.jdField_a_of_type_JavaUtilMap, paramInt));
    this.jdField_b_of_type_AndroidTextTextPaint.setShadowLayer(10.0F, 0.0F, 0.0F, a(this.jdField_b_of_type_JavaUtilMap, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject = super.b(paramInt);
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "　　";
    }
    if (this.jdField_b_of_type_AndroidTextTextPaint == null) {
      this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint(this.jdField_a_of_type_AndroidTextTextPaint);
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_b_of_type_AndroidTextTextPaint, d, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > this.f)
    {
      paramInt = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(this.f - 1);
      localObject = paramString;
      if (paramInt < paramString.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.subSequence(0, paramInt));
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a((CharSequence)localObject, 0, ((String)localObject).length(), this.jdField_b_of_type_AndroidTextTextPaint, d, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      float f1;
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(a() / 2.0F, b() / 2.0F);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
        this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
        f1 = -((this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F);
        String str = super.b(0);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "　　";
        }
        this.jdField_b_of_type_AndroidTextTextPaint.setAlpha(102);
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.jdField_b_of_type_AndroidTextTextPaint);
        this.jdField_b_of_type_AndroidTextTextPaint.setAlpha(255);
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.jdField_b_of_type_AndroidTextTextPaint);
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.jdField_a_of_type_AndroidTextTextPaint);
        if (super.b(0))
        {
          int i = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject);
          int j = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
          this.jdField_a_of_type_AndroidGraphicsRectF.left = (-i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.top = (-j / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.right = (i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j / 2.0F);
          paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
        }
        paramCanvas.restore();
        return;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      paramCanvas.save();
      Object localObject = this.jdField_a_of_type_AndroidTextStaticLayout;
      if (localObject != null)
      {
        ((StaticLayout)localObject).getPaint().setAlpha(102);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
        this.jdField_a_of_type_AndroidTextStaticLayout.getPaint().setAlpha(255);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      }
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        f1 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
        float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
        this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = f1;
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = f2;
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      paramCanvas.restore();
    }
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.NormalHighLightTextItem
 * JD-Core Version:    0.7.0.1
 */