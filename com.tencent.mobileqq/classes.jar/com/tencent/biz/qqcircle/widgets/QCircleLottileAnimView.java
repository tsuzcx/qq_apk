package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.component.media.image.view.ViewForeground;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class QCircleLottileAnimView
  extends DiniFlyAnimationView
{
  private float[] a;
  private Path b;
  private RectF c = new RectF();
  private boolean d;
  private ViewForeground e = new ViewForeground(this, null);
  
  public QCircleLottileAnimView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleLottileAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleLottileAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!a())
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.b == null) {
      this.b = new Path();
    }
    int i = paramCanvas.save();
    try
    {
      try
      {
        Object localObject1 = this.b;
        RectF localRectF = this.c;
        localRectF.set(0.0F, 0.0F, getWidth(), getHeight());
        ((Path)localObject1).reset();
        ((Path)localObject1).addRoundRect(localRectF, this.a, Path.Direction.CW);
        paramCanvas.clipPath((Path)localObject1);
        super.onDraw(paramCanvas);
        localObject1 = this.e;
        if (localObject1 == null) {
          break label118;
        }
        ((ViewForeground)localObject1).draw(paramCanvas);
      }
      finally
      {
        break label124;
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      label113:
      break label113;
    }
    super.onDraw(paramCanvas);
    label118:
    paramCanvas.restoreToCount(i);
    return;
    label124:
    paramCanvas.restoreToCount(i);
    throw localObject2;
  }
  
  public void setNeedRadius(boolean paramBoolean)
  {
    this.d = paramBoolean;
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
    this.a = paramArrayOfFloat;
    boolean bool;
    if (paramArrayOfFloat != null) {
      bool = true;
    } else {
      bool = false;
    }
    setNeedRadius(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLottileAnimView
 * JD-Core Version:    0.7.0.1
 */