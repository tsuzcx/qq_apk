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
import nqa;

public class RoundEmptyRectRelativeLayout
  extends RelativeLayout
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private ArrayList<nqa> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  
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
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
  }
  
  public boolean a(nqa paramnqa)
  {
    if ((paramnqa != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramnqa)))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramnqa);
      return true;
    }
    return false;
  }
  
  public boolean b(nqa paramnqa)
  {
    if (paramnqa != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.remove(paramnqa);
    }
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    Path localPath = new Path();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      nqa localnqa = (nqa)localIterator.next();
      localPath.addRoundRect(nqa.a(localnqa), nqa.a(localnqa), Path.Direction.CW);
    }
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, i, j), null, 31);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.RoundEmptyRectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */