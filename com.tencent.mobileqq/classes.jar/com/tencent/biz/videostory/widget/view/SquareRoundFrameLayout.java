package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.util.SquareRoundImageUtils;
import com.tencent.mobileqq.util.SquareRoundImageUtils.SquareRoundColorDrawable;

public class SquareRoundFrameLayout
  extends FrameLayout
{
  private Path a;
  
  public SquareRoundFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SquareRoundFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SquareRoundFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Path();
    setWillNotDraw(false);
    b();
    if (Build.VERSION.SDK_INT <= 16) {
      setLayerType(1, null);
    }
  }
  
  private void b()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Object localObject = new SquareRoundImageUtils.SquareRoundColorDrawable(getResources().getColor(2131165345), getWidth(), getHeight());
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, (Drawable)localObject);
    localObject = new ColorDrawable(0);
    localStateListDrawable.addState(new int[0], (Drawable)localObject);
    setForeground(localStateListDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.a);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))) {
      this.a = SquareRoundImageUtils.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.SquareRoundFrameLayout
 * JD-Core Version:    0.7.0.1
 */