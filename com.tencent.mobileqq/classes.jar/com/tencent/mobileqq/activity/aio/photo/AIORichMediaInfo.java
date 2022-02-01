package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AIORichMediaInfo
  extends GalleryImage
{
  public int a;
  public Rect a;
  public AIORichMediaData a;
  AIORichMediaInfo.DataState a;
  public boolean a;
  public int b;
  Rect jdField_b_of_type_AndroidGraphicsRect;
  boolean jdField_b_of_type_Boolean = true;
  public int c;
  boolean c;
  
  public AIORichMediaInfo(AIORichMediaData paramAIORichMediaData)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState = new AIORichMediaInfo.DataState();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = paramAIORichMediaData;
    this.isImgCenterCropMode = true;
  }
  
  private Drawable a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {}
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    do
    {
      File localFile2;
      do
      {
        File localFile1;
        do
        {
          return null;
          localFile1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18);
          localFile2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20);
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
          if ((localFile1 == null) || (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18)) == null)) {
            break;
          }
        } while (URLDrawableHelper.getExifRotation(localFile1.getAbsolutePath()) != 0);
        return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18), localURLDrawableOptions);
        if ((localFile2 == null) || (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)) == null)) {
          break;
        }
      } while (URLDrawableHelper.getExifRotation(localFile2.getAbsolutePath()) != 0);
      return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20), localURLDrawableOptions);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null);
    return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16), localURLDrawableOptions);
  }
  
  @Deprecated
  public static URLDrawable a(PicUiInterface paramPicUiInterface)
  {
    return URLDrawableHelper.getNestDrawable(paramPicUiInterface, 1);
  }
  
  private Drawable b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!AIOFileVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
      return null;
    }
    Object localObject = (AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    File localFile = ((AIOFileVideoData)localObject).a(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    if ((localFile != null) && (GlobalImageCache.a.get(((AIOFileVideoData)localObject).a(0)) != null)) {
      return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
    }
    if (localFile != null)
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
      ((URLDrawable)localObject).downloadImediatly();
      return localObject;
    }
    return null;
  }
  
  public Drawable getAnimationDrawable()
  {
    for (;;)
    {
      try
      {
        if (!AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        if ((localObject1 == null) || (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2)) == null)) {
          continue;
        }
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2), localURLDrawableOptions);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          break label397;
        }
        QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        return null;
        if (!AIOShortVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        Object localObject2 = (AIOShortVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        Object localObject3 = ((AIOShortVideoData)localObject2).a(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        if ((localObject3 == null) || (GlobalImageCache.a.get(((AIOShortVideoData)localObject2).a(0)) == null)) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
        continue;
        if (localObject3 == null) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
        ((URLDrawable)localObject2).downloadImediatly();
        continue;
        if (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        localObject2 = a();
        continue;
        if (!AIOFileVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        localObject2 = b();
        continue;
        return localObject2;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
      }
      localObject3 = getThumbRect();
      if ((localObject1 != null) && ((((Drawable)localObject1).getIntrinsicHeight() * 3 < ((Drawable)localObject1).getIntrinsicWidth()) || (((Drawable)localObject1).getIntrinsicWidth() * 3 < ((Drawable)localObject1).getIntrinsicHeight()))) {
        this.isImgCenterCropMode = false;
      }
      if ((localObject1 == null) || (localObject3 == null)) {
        break label397;
      }
      this.jdField_c_of_type_Int = getCutValue((Rect)localObject3, (Drawable)localObject1);
      if (((Drawable)localObject1).getIntrinsicHeight() == -1) {
        break label397;
      }
      if (((Drawable)localObject1).getIntrinsicWidth() != -1) {
        continue;
      }
      return null;
      if ((localObject3 != null) && (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) != null))
      {
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), localURLDrawableOptions);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) == null) {
          continue;
        }
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1), localURLDrawableOptions);
        ((URLDrawable)localObject1).downloadImediatly();
      }
    }
    label397:
    return null;
  }
  
  public int getCutValue()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Rect getStartSrcRect()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Rect getThumbRect()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return this.jdField_a_of_type_AndroidGraphicsRect;
    }
    return super.getThumbRect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo
 * JD-Core Version:    0.7.0.1
 */