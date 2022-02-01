package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RoundFrameLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  
  public RoundFrameLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramInt1 = this.jdField_a_of_type_Int;
    localPath.addRoundRect(localRectF, paramInt1, paramInt1, Path.Direction.CW);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void setRadius(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(getWidth(), getHeight());
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.RoundFrameLayout
 * JD-Core Version:    0.7.0.1
 */