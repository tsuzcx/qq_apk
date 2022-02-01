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
import com.tencent.biz.qqstory.utils.UIUtils;

public class VideoCoverImgBorder
  extends ImageView
{
  private final int jdField_a_of_type_Int = UIUtils.a(getContext(), 1.0F);
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private final int jdField_b_of_type_Int = UIUtils.a(getContext(), 2.0F);
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int c = this.jdField_b_of_type_Int;
  private int d = 0;
  private int e = 0;
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
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    int j = this.d;
    int k = this.f;
    ((RectF)localObject).left = (j + k);
    ((RectF)localObject).top = (this.e + k);
    ((RectF)localObject).right = (getWidth() - this.f - this.d);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (getHeight() - this.f - this.e);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.c;
    ((Path)localObject).addRoundRect(localRectF, j, j, Path.Direction.CCW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
    ((RectF)localObject).left = this.d;
    ((RectF)localObject).top = this.e;
    ((RectF)localObject).right = (getWidth() - this.d);
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (getHeight() - this.e);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.c;
    ((Path)localObject).addRoundRect(localRectF, j, j, Path.Direction.CCW);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    j = this.c;
    k = this.f;
    ((Path)localObject).addRoundRect(localRectF, j + k, j + k, Path.Direction.CCW);
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    paramCanvas.drawColor(this.g);
    paramCanvas.restoreToCount(i);
  }
  
  public void setState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramInt = this.jdField_a_of_type_Int;
        this.d = paramInt;
        this.e = paramInt;
        this.f = paramInt;
        this.g = -1;
        return;
      }
      this.d = 0;
      this.e = 0;
      this.f = this.jdField_b_of_type_Int;
      this.g = -15550475;
      return;
    }
    paramInt = this.jdField_a_of_type_Int;
    this.d = paramInt;
    this.e = paramInt;
    this.f = paramInt;
    this.g = -570319;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverImgBorder
 * JD-Core Version:    0.7.0.1
 */