package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;

public class GiftRoundCornerFrameLayout
  extends FrameLayout
{
  private Path a;
  private RectF b;
  private float c = ViewUtils.dpToPx(4.0F);
  
  public GiftRoundCornerFrameLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GiftRoundCornerFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public GiftRoundCornerFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Path();
    this.b = new RectF();
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    this.a.reset();
    this.b.set(0.0F, 0.0F, getWidth(), getHeight());
    Path localPath = this.a;
    RectF localRectF = this.b;
    float f = this.c;
    localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
    paramCanvas.clipPath(this.a);
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.GiftRoundCornerFrameLayout
 * JD-Core Version:    0.7.0.1
 */