package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;

public class FullScreenImageView
  extends ImageView
{
  public FullScreenImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FullScreenImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Drawable localDrawable = getDrawable();
    if (((localDrawable instanceof BitmapDrawable)) && (((BitmapDrawable)localDrawable).getBitmap().isRecycled()))
    {
      SLog.e("", "can not draw a bitmap which is recycled " + this);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(UIUtils.a(super.getContext()), UIUtils.b(super.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenImageView
 * JD-Core Version:    0.7.0.1
 */