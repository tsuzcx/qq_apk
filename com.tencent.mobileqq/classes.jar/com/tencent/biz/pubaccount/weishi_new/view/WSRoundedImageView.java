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
    if (this.a.e)
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.a.a);
      super.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.draw(paramCanvas);
  }
  
  public int getStrokeColor()
  {
    return this.a.c;
  }
  
  public int getStrokeWidth()
  {
    return this.a.d;
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
    paramCanvas.saveLayer(this.a.g, null, 31);
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
    this.a.c = paramInt;
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.a.d = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView
 * JD-Core Version:    0.7.0.1
 */