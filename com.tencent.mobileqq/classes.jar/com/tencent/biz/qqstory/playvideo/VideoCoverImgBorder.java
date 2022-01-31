package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import xod;

public class VideoCoverImgBorder
  extends ImageView
{
  private final int jdField_a_of_type_Int = xod.a(getContext(), 1.0F);
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private final int jdField_b_of_type_Int = xod.a(getContext(), 2.0F);
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int c = this.jdField_b_of_type_Int;
  private int d;
  private int e;
  private int f = this.jdField_b_of_type_Int;
  private int g = -1;
  
  public VideoCoverImgBorder(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    setState(2);
  }
  
  public VideoCoverImgBorder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    setState(2);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.d + this.f);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.e + this.f);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (getWidth() - this.f - this.d);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (getHeight() - this.f - this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.c, Path.Direction.CCW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsRectF.left = this.d;
    this.jdField_b_of_type_AndroidGraphicsRectF.top = this.e;
    this.jdField_b_of_type_AndroidGraphicsRectF.right = (getWidth() - this.d);
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (getHeight() - this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.c, Path.Direction.CCW);
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.c + this.f, this.c + this.f, Path.Direction.CCW);
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    paramCanvas.drawColor(this.g);
    paramCanvas.restoreToCount(i);
  }
  
  public void setState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.d = this.jdField_a_of_type_Int;
      this.e = this.jdField_a_of_type_Int;
      this.f = this.jdField_a_of_type_Int;
      this.g = -570319;
      return;
    case 1: 
      this.d = 0;
      this.e = 0;
      this.f = this.jdField_b_of_type_Int;
      this.g = -15550475;
      return;
    }
    this.d = this.jdField_a_of_type_Int;
    this.e = this.jdField_a_of_type_Int;
    this.f = this.jdField_a_of_type_Int;
    this.g = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverImgBorder
 * JD-Core Version:    0.7.0.1
 */