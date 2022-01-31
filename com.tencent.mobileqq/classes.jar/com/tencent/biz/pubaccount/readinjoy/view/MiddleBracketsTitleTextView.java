package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class MiddleBracketsTitleTextView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b = 2;
  
  public MiddleBracketsTitleTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MiddleBracketsTitleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MiddleBracketsTitleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = getPaint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(getTextSize());
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getCurrentTextColor());
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
        if (this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString) > this.b * this.jdField_a_of_type_Int)
        {
          float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText("...]");
          float f2 = this.b * this.jdField_a_of_type_Int;
          if (i < this.jdField_a_of_type_JavaLangString.length())
          {
            String str = this.jdField_a_of_type_JavaLangString.substring(0, i + 1);
            if (this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str) <= f2 - 1.8F * f1) {
              break label183;
            }
            this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString.substring(0, i) + "...]");
            setText(this.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          super.onDraw(paramCanvas);
          return;
        }
      }
      catch (Exception localException)
      {
        super.onDraw(paramCanvas);
        if (QLog.isColorLevel()) {
          QLog.d("MiddleBracketsTitleTextView", 2, "drawTitle", localException);
        }
      }
      return;
      label183:
      i += 1;
    }
  }
  
  public boolean a()
  {
    try
    {
      Object localObject = getClass().getSuperclass().getDeclaredField("mLayout");
      ((Field)localObject).setAccessible(true);
      localObject = (Layout)((Field)localObject).get(this);
      if (localObject == null) {
        return false;
      }
      int i = ((Layout)localObject).getEllipsisCount(this.b - 1);
      if (i > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiddleBracketsTitleTextView", 2, "checkOverLine", localException);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (getText() != null) && (this.jdField_a_of_type_Boolean) && (a()))
    {
      a(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setNeedAddBrackets(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTitle(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.MiddleBracketsTitleTextView
 * JD-Core Version:    0.7.0.1
 */