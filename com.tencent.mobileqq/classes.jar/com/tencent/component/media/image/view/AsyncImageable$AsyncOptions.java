package com.tencent.component.media.image.view;

import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;

public class AsyncImageable$AsyncOptions
{
  int jdField_a_of_type_Int = -1;
  Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config = ImageLoader.Options.DEFAULT_IMAGE_CONFIG;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  ImageProcessor jdField_a_of_type_ComTencentComponentMediaImageImageProcessor = null;
  RawImageProcessor jdField_a_of_type_ComTencentComponentMediaImageRawImageProcessor = null;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = true;
  boolean f = false;
  boolean g = false;
  
  public final void fillOptions(ImageLoader.Options paramOptions)
  {
    paramOptions.clipWidth = this.jdField_a_of_type_Int;
    paramOptions.clipHeight = this.jdField_b_of_type_Int;
    paramOptions.preferQuality = this.jdField_a_of_type_Boolean;
    paramOptions.justCover = this.jdField_b_of_type_Boolean;
    paramOptions.needShowGifAnimation = this.jdField_d_of_type_Boolean;
    paramOptions.imageConfig = this.jdField_a_of_type_AndroidGraphicsBitmap$Config;
    paramOptions.extraProcessor = this.jdField_a_of_type_ComTencentComponentMediaImageImageProcessor;
    paramOptions.processor = this.jdField_a_of_type_ComTencentComponentMediaImageRawImageProcessor;
    paramOptions.priority = this.e;
    paramOptions.fileRootPath = this.jdField_a_of_type_JavaLangString;
  }
  
  public void onClipSizeChanged(int paramInt1, int paramInt2) {}
  
  public void setAlwaysLoad(boolean paramBoolean)
  {
    if (this.f != paramBoolean) {
      this.f = paramBoolean;
    }
  }
  
  public void setAnimation(Animation paramAnimation1, Animation paramAnimation2)
  {
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation != paramAnimation1) || (this.jdField_b_of_type_AndroidViewAnimationAnimation != paramAnimation2))
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = paramAnimation1;
      this.jdField_b_of_type_AndroidViewAnimationAnimation = paramAnimation2;
    }
  }
  
  public void setClipSize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.jdField_b_of_type_Int != paramInt2))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      onClipSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  public void setDefaultImage(Drawable paramDrawable)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setFailImage(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  public void setFailImage(Drawable paramDrawable)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setFileRootPath(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    while (paramString != null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void setImageConfig(Bitmap.Config paramConfig)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap$Config != paramConfig) {
      this.jdField_a_of_type_AndroidGraphicsBitmap$Config = paramConfig;
    }
  }
  
  public void setImageProcessor(ImageProcessor paramImageProcessor)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageImageProcessor != paramImageProcessor) {
      this.jdField_a_of_type_ComTencentComponentMediaImageImageProcessor = paramImageProcessor;
    }
  }
  
  public void setJustCover(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setJustMemoryCache(boolean paramBoolean)
  {
    if (this.g != paramBoolean) {
      this.g = paramBoolean;
    }
  }
  
  public void setNeedShowGifAnimation(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean) {
      this.jdField_d_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setPreferQuality(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setPriority(boolean paramBoolean)
  {
    if (this.e != paramBoolean) {
      this.e = paramBoolean;
    }
  }
  
  public void setRawImageProcessor(RawImageProcessor paramRawImageProcessor)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageRawImageProcessor != paramRawImageProcessor) {
      this.jdField_a_of_type_ComTencentComponentMediaImageRawImageProcessor = paramRawImageProcessor;
    }
  }
  
  public void setTryStream(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean) {
      this.jdField_c_of_type_Boolean = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncOptions
 * JD-Core Version:    0.7.0.1
 */