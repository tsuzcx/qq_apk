package com.tencent.gdtad.views.videoimax;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.gdtad.log.GdtLog;

public class GdtVideoImaxEnterImageView
  extends ImageView
{
  private Rect a;
  
  public GdtVideoImaxEnterImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtVideoImaxEnterImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtVideoImaxEnterImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDraw() called with: hashcode = ");
    localStringBuilder.append(System.identityHashCode(this));
    GdtLog.a("GdtVideoImaxEnterImageView", localStringBuilder.toString());
    if (this.a != null)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(this.a);
      super.onDraw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setClipBoundsCompact(Rect paramRect)
  {
    this.a = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxEnterImageView
 * JD-Core Version:    0.7.0.1
 */