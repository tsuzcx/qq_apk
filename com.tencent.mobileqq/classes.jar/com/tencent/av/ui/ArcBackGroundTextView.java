package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class ArcBackGroundTextView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public ArcBackGroundTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ArcBackGroundTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ArcBackGroundTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1711276032);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ArcBackGroundTextView, 0, 0);
    this.jdField_a_of_type_Float = paramContext.getDimension(0, 0.0F);
    this.jdField_b_of_type_Float = paramContext.getDimension(1, 0.0F);
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = Math.round(this.jdField_b_of_type_Float);
    this.jdField_b_of_type_Int = ((int)Math.round(Math.sqrt(Math.pow(this.jdField_a_of_type_Float, 2.0D) - Math.pow(this.jdField_a_of_type_Float - this.jdField_a_of_type_Int, 2.0D)) * 2.0D));
    setMeasuredDimension(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    if (getId() == 2131366201) {}
    for (paramInt1 = 0;; paramInt1 = 5) {
      for (float f1 = 0.0F; f1 < this.jdField_b_of_type_Int; f1 = (float)(f1 + 0.2D))
      {
        float f2 = (float)(Math.sqrt(Math.pow(this.jdField_a_of_type_Float, 2.0D) - Math.pow(f1 - this.jdField_b_of_type_Int / 2, 2.0D)) - this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, f2 + paramInt1);
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPath.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.ArcBackGroundTextView
 * JD-Core Version:    0.7.0.1
 */