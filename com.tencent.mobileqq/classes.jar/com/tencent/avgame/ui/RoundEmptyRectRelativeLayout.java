package com.tencent.avgame.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class RoundEmptyRectRelativeLayout
  extends RelativeLayout
{
  private Paint a = new Paint();
  private ArrayList<RoundEmptyRectRelativeLayout.ClipRoundRect> b = new ArrayList(5);
  
  @TargetApi(11)
  public RoundEmptyRectRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  @TargetApi(11)
  public RoundEmptyRectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RoundEmptyRectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
  }
  
  public boolean a(RoundEmptyRectRelativeLayout.ClipRoundRect paramClipRoundRect)
  {
    if ((paramClipRoundRect != null) && (!this.b.contains(paramClipRoundRect)))
    {
      this.b.add(paramClipRoundRect);
      return true;
    }
    return false;
  }
  
  public boolean b(RoundEmptyRectRelativeLayout.ClipRoundRect paramClipRoundRect)
  {
    if (paramClipRoundRect != null) {
      return this.b.remove(paramClipRoundRect);
    }
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    Path localPath = new Path();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      RoundEmptyRectRelativeLayout.ClipRoundRect localClipRoundRect = (RoundEmptyRectRelativeLayout.ClipRoundRect)localIterator.next();
      localPath.addRoundRect(RoundEmptyRectRelativeLayout.ClipRoundRect.a(localClipRoundRect), RoundEmptyRectRelativeLayout.ClipRoundRect.b(localClipRoundRect), Path.Direction.CW);
    }
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, i, j), null, 31);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawPath(localPath, this.a);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.RoundEmptyRectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */