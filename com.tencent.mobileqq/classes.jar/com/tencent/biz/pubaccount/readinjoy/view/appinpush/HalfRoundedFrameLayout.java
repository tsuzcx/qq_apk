package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class HalfRoundedFrameLayout
  extends FrameLayout
{
  final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  
  public HalfRoundedFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HalfRoundedFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HalfRoundedFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = AIOUtils.a(3.0F, getResources());
    int j = getWidth();
    int k = getHeight();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, k);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, i);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i * 2, i * 2);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, -180.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(j - i, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(j - i * 2, 0.0F, j, i * 2);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(j, i);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(j, k);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, k);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.HalfRoundedFrameLayout
 * JD-Core Version:    0.7.0.1
 */