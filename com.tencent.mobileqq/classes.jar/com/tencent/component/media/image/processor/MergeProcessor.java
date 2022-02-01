package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;

@Public
public class MergeProcessor
  extends ImageProcessor
{
  private ArrayList<ImageProcessor> mProcessors;
  private int mType;
  
  @Public
  public MergeProcessor()
  {
    this.mType = 1;
    this.mProcessors = new ArrayList();
  }
  
  @Public
  public MergeProcessor(int paramInt)
  {
    this.mType = paramInt;
    this.mProcessors = new ArrayList();
  }
  
  @Public
  public void addProcessor(int paramInt, ImageProcessor paramImageProcessor)
  {
    if ((paramInt >= 0) && (paramInt <= this.mProcessors.size()) && (paramImageProcessor != null)) {
      this.mProcessors.add(paramInt, paramImageProcessor);
    }
  }
  
  @Public
  public void addProcessor(ImageProcessor paramImageProcessor)
  {
    if (paramImageProcessor != null) {
      this.mProcessors.add(paramImageProcessor);
    }
  }
  
  @Public
  public ImageProcessor getProcessor(int paramInt)
  {
    return (ImageProcessor)this.mProcessors.get(paramInt);
  }
  
  @Public
  public int getProcessorCount()
  {
    return this.mProcessors.size();
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    int i = 0;
    Drawable localDrawable = paramDrawable;
    while (i < this.mProcessors.size())
    {
      if (localDrawable == null) {
        return paramDrawable;
      }
      localDrawable = ((ImageProcessor)this.mProcessors.get(i)).process(localDrawable);
      i += 1;
    }
    return localDrawable;
  }
  
  @Public
  public void removeProcessor(ImageProcessor paramImageProcessor)
  {
    this.mProcessors.remove(paramImageProcessor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.processor.MergeProcessor
 * JD-Core Version:    0.7.0.1
 */