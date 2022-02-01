package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import uqf;

public class RoundCornerImageView
  extends KandianUrlImageView
{
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private int b = 0;
  
  public RoundCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i;
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      i = getWidth() - getPaddingLeft() - getPaddingRight();
      int j = getHeight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      this.jdField_a_of_type_AndroidGraphicsRectF.left = getPaddingLeft();
      this.jdField_a_of_type_AndroidGraphicsRectF.top = getPaddingTop();
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (getPaddingLeft() + i);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j - k - m + getPaddingTop());
      if (this.jdField_a_of_type_Int <= 0) {
        break label173;
      }
      i = this.jdField_a_of_type_Int;
      if (this.b != 0) {
        break label183;
      }
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, i, i, Path.Direction.CCW);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      try
      {
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception paramCanvas)
      {
        label173:
        label183:
        float f1;
        float f2;
        float f3;
        float f4;
        Path localPath;
        RectF localRectF;
        Path.Direction localDirection;
        uqf.d("RoundCornerImageView", paramCanvas.getMessage());
      }
      i /= 30;
      break;
      if (this.b == 1)
      {
        f1 = i;
        f2 = i;
        f3 = i;
        f4 = i;
        localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        localDirection = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      }
    }
  }
  
  public void setCorner(int paramInt)
  {
    setCorner(paramInt, 0);
  }
  
  public void setCorner(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return;
    }
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */