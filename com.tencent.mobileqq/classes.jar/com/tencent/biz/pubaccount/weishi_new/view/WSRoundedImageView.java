package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;

public class WSRoundedImageView
  extends ResizeURLImageView
{
  RoundCornerHelper a = new RoundCornerHelper();
  
  public WSRoundedImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WSRoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WSRoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.a.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void invalidate()
  {
    RoundCornerHelper localRoundCornerHelper = this.a;
    if (localRoundCornerHelper != null) {
      localRoundCornerHelper.a(this);
    }
    super.invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(this.a.jdField_a_of_type_AndroidGraphicsRectF, null, 31);
    super.onDraw(paramCanvas);
    this.a.a(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a(this, paramInt1, paramInt2);
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.a.b = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView
 * JD-Core Version:    0.7.0.1
 */