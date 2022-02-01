package com.tencent.biz.qqstory.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.support.logging.SLog;

public class StoryFaceDrawable
  extends Drawable
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryFaceDrawable
 * JD-Core Version:    0.7.0.1
 */