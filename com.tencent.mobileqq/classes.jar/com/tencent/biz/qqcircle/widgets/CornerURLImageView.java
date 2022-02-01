package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.component.media.image.view.ViewForeground;
import com.tencent.image.URLImageView;

public class CornerURLImageView
  extends URLImageView
{
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private ViewForeground jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground = new ViewForeground(this, null);
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  public CornerURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CornerURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CornerURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!a())
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    int i = paramCanvas.save();
    try
    {
      Object localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      localRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      ((Path)localObject1).reset();
      ((Path)localObject1).addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject1);
      super.onDraw(paramCanvas);
      localObject1 = this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground;
      if (localObject1 != null) {
        ((ViewForeground)localObject1).draw(paramCanvas);
      }
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      super.onDraw(paramCanvas);
      return;
    }
    finally
    {
      paramCanvas.restoreToCount(i);
    }
  }
  
  public void setNeedRadius(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRadius(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      setRadius(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat });
      return;
    }
    setRadius(null);
  }
  
  public void setRadius(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    if (paramArrayOfFloat != null) {}
    for (boolean bool = true;; bool = false)
    {
      setNeedRadius(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.CornerURLImageView
 * JD-Core Version:    0.7.0.1
 */