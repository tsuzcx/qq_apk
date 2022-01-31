package com.tencent.av.screenshare.floatingwindow;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import bdkf;
import com.tencent.qphone.base.util.QLog;
import lyl;
import lym;

public class ScreenShareFloatingRelativeLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private View jdField_a_of_type_AndroidViewView;
  private lym jdField_a_of_type_Lym;
  private int b;
  
  public ScreenShareFloatingRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScreenShareFloatingRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScreenShareFloatingRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnTouchListener(new lyl(this));
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364350);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Int == 0) || (this.b == 0))
    {
      this.jdField_a_of_type_Int = bdkf.a();
      this.b = bdkf.b();
      setCurPosition(this.jdField_a_of_type_AndroidGraphicsPoint);
    }
  }
  
  public void setCurPosition(Point paramPoint)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ScreenShareFloatingRelativeLayout", 2, "setCurPosition position = " + paramPoint);
      QLog.d("ScreenShareFloatingRelativeLayout", 2, "setCurPosition mScreenWidth = " + this.jdField_a_of_type_Int);
      QLog.d("ScreenShareFloatingRelativeLayout", 2, "setCurPosition mScreenHeight = " + this.b);
    }
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
    if ((this.jdField_a_of_type_Int != 0) && (this.b != 0))
    {
      if ((paramPoint.x == 0) && (paramPoint.y == 0))
      {
        paramPoint.y = (this.b / 2);
        paramPoint.x = 0;
      }
      if (this.jdField_a_of_type_Lym != null) {
        this.jdField_a_of_type_Lym.a(this, paramPoint.x, paramPoint.y);
      }
    }
  }
  
  public void setFloatListener(lym paramlym)
  {
    this.jdField_a_of_type_Lym = paramlym;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.screenshare.floatingwindow.ScreenShareFloatingRelativeLayout
 * JD-Core Version:    0.7.0.1
 */