package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ClipLayout
  extends RelativeLayout
{
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ClipLayout(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public ClipLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    RectF localRectF = new RectF(new Rect(0, 0, getWidth(), getHeight()));
    this.jdField_a_of_type_AndroidGraphicsPath.addRect(localRectF, Path.Direction.CCW);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      a();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    RectF localRectF = new RectF(new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
    this.jdField_a_of_type_AndroidGraphicsPath.addRect(localRectF, Path.Direction.CCW);
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        a();
      }
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.REPLACE);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setNeedClip(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ClipLayout
 * JD-Core Version:    0.7.0.1
 */