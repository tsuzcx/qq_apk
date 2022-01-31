package com.tencent.component.media.photogif;

import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;

public class QzoneAnimationDrawable$Builder
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ImageProcessor jdField_a_of_type_ComTencentComponentMediaImageImageProcessor;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  int b;
  int c;
  
  public static Builder create()
  {
    return new Builder();
  }
  
  public QzoneAnimationDrawable build()
  {
    Object localObject = ImageLoader.Options.obtain();
    if (this.jdField_a_of_type_Long > 0L) {
      ((ImageLoader.Options)localObject).photoDelayTimeInMs = this.jdField_a_of_type_Long;
    }
    if (this.jdField_a_of_type_Int > 0) {
      ((ImageLoader.Options)localObject).clipWidth = this.jdField_a_of_type_Int;
    }
    if (this.b > 0) {
      ((ImageLoader.Options)localObject).clipHeight = this.b;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (((ImageLoader.Options)localObject).photoList = this.jdField_a_of_type_JavaUtilArrayList;; ((ImageLoader.Options)localObject).photoList = new ArrayList())
    {
      ((ImageLoader.Options)localObject).extraProcessor = this.jdField_a_of_type_ComTencentComponentMediaImageImageProcessor;
      localObject = new QzoneAnimationDrawable((ImageLoader.Options)localObject);
      if (this.c > 0) {
        ((QzoneAnimationDrawable)localObject).setRepeatCount(this.c);
      }
      return localObject;
    }
  }
  
  public Builder setDelayTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder setPhotos(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    return this;
  }
  
  public Builder setProcessor(ImageProcessor paramImageProcessor)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageProcessor = paramImageProcessor;
    return this;
  }
  
  public Builder setRepeatCount(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder setReqHeight(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder setReqWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.QzoneAnimationDrawable.Builder
 * JD-Core Version:    0.7.0.1
 */