package com.tencent.component.media.photogif;

import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;

public class QzoneAnimationDrawable$Builder
{
  long delayTimeInMs;
  ArrayList<String> photos;
  ImageProcessor processor;
  int repeatCount;
  int reqHeight;
  int reqWidth;
  
  public static Builder create()
  {
    return new Builder();
  }
  
  public QzoneAnimationDrawable build()
  {
    Object localObject = ImageLoader.Options.obtain();
    long l = this.delayTimeInMs;
    if (l > 0L) {
      ((ImageLoader.Options)localObject).photoDelayTimeInMs = l;
    }
    int i = this.reqWidth;
    if (i > 0) {
      ((ImageLoader.Options)localObject).clipWidth = i;
    }
    i = this.reqHeight;
    if (i > 0) {
      ((ImageLoader.Options)localObject).clipHeight = i;
    }
    ArrayList localArrayList = this.photos;
    if (localArrayList != null) {
      ((ImageLoader.Options)localObject).photoList = localArrayList;
    } else {
      ((ImageLoader.Options)localObject).photoList = new ArrayList();
    }
    ((ImageLoader.Options)localObject).extraProcessor = this.processor;
    localObject = new QzoneAnimationDrawable((ImageLoader.Options)localObject);
    i = this.repeatCount;
    if (i > 0) {
      ((QzoneAnimationDrawable)localObject).setRepeatCount(i);
    }
    return localObject;
  }
  
  public Builder setDelayTime(long paramLong)
  {
    this.delayTimeInMs = paramLong;
    return this;
  }
  
  public Builder setPhotos(ArrayList<String> paramArrayList)
  {
    this.photos = paramArrayList;
    return this;
  }
  
  public Builder setProcessor(ImageProcessor paramImageProcessor)
  {
    this.processor = paramImageProcessor;
    return this;
  }
  
  public Builder setRepeatCount(int paramInt)
  {
    this.repeatCount = paramInt;
    return this;
  }
  
  public Builder setReqHeight(int paramInt)
  {
    this.reqHeight = paramInt;
    return this;
  }
  
  public Builder setReqWidth(int paramInt)
  {
    this.reqWidth = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.photogif.QzoneAnimationDrawable.Builder
 * JD-Core Version:    0.7.0.1
 */