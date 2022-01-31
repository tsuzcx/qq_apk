package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;

@Public
public class MergeProcessor
  extends ImageProcessor
{
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  @Public
  public MergeProcessor()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  @Public
  public MergeProcessor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  @Public
  public void addProcessor(int paramInt, ImageProcessor paramImageProcessor)
  {
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size()) && (paramImageProcessor != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramImageProcessor);
    }
  }
  
  @Public
  public void addProcessor(ImageProcessor paramImageProcessor)
  {
    if (paramImageProcessor != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramImageProcessor);
    }
  }
  
  @Public
  public ImageProcessor getProcessor(int paramInt)
  {
    return (ImageProcessor)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  @Public
  public int getProcessorCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getType()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    int i = 0;
    Drawable localDrawable = paramDrawable;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (localDrawable == null) {
        return paramDrawable;
      }
      localDrawable = ((ImageProcessor)this.jdField_a_of_type_JavaUtilArrayList.get(i)).process(localDrawable);
      i += 1;
    }
    return localDrawable;
  }
  
  @Public
  public void removeProcessor(ImageProcessor paramImageProcessor)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramImageProcessor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.MergeProcessor
 * JD-Core Version:    0.7.0.1
 */