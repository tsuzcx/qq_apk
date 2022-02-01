package com.tencent.biz.qqstory.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.utils.ImageUtil;

public class StoryFaceDrawable
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private int b;
  
  public StoryFaceDrawable(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
  }
  
  public StoryFaceDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    SLog.c("Q.qqstory.record.StoryFaceDrawable", "StoryFaceDrawable.");
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    setBounds(0, 0, paramInt1, paramInt2);
    if (paramBitmap == null) {}
    for (this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();; this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(paramInt1 / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), paramInt2 / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(this.jdField_a_of_type_Int / paramBitmap.getWidth(), this.b / paramBitmap.getHeight());
  }
  
  public void draw(Canvas paramCanvas)
  {
    SLog.c("Q.qqstory.record.StoryFaceDrawable", "StoryFaceDrawable draw start.");
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
    SLog.c("Q.qqstory.record.StoryFaceDrawable", "StoryFaceDrawable draw end.");
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryFaceDrawable
 * JD-Core Version:    0.7.0.1
 */