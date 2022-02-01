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
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
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
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      if (!AIOFilePicData.class.isInstance(localObject3)) {
        return null;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18);
      File localFile = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20);
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = URLDrawableHelperConstants.a;
      if ((localObject1 != null) && (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18)) != null))
      {
        if (URLDrawableHelper.getExifRotation(((File)localObject1).getAbsolutePath()) != 0) {
          return null;
        }
        return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18), (URLDrawable.URLDrawableOptions)localObject3);
      }
      if ((localFile != null) && (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)) != null))
      {
        if (URLDrawableHelper.getExifRotation(localFile.getAbsolutePath()) != 0) {
          return null;
        }
        return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20), (URLDrawable.URLDrawableOptions)localObject3);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16), (URLDrawable.URLDrawableOptions)localObject3);
      }
    }
    return localObject1;
  }
  
  @Deprecated
  public static URLDrawable a(PicUiInterface paramPicUiInterface)
  {
    return URLDrawableHelper.getNestDrawable(paramPicUiInterface, 1);
  }
  
  private Drawable b()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      if (!AIOFileVideoData.class.isInstance(localObject3)) {
        return null;
      }
      localObject1 = (AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localObject3 = ((AIOFileVideoData)localObject1).a(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
      if ((localObject3 != null) && (GlobalImageCache.a.get(((AIOFileVideoData)localObject1).a(0)) != null)) {
        return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
      }
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
        ((URLDrawable)localObject1).downloadImediatly();
      }
    }
    return localObject1;
  }
  
  public Drawable getAnimationDrawable()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        if (AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4);
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
          localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
          if ((localObject1 != null) && (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2)) != null))
          {
            localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2), localURLDrawableOptions);
          }
          else if ((localObject3 != null) && (GlobalImageCache.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) != null))
          {
            localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), localURLDrawableOptions);
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) == null) {
              break label405;
            }
            localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1), localURLDrawableOptions);
            ((URLDrawable)localObject1).downloadImediatly();
          }
        }
        else if (AIOShortVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject1 = (AIOShortVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject3 = ((AIOShortVideoData)localObject1).a(0);
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
          localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
          if ((localObject3 != null) && (GlobalImageCache.a.get(((AIOShortVideoData)localObject1).a(0)) != null))
          {
            localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
          }
          else
          {
            if (localObject3 == null) {
              break label405;
            }
            localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
            ((URLDrawable)localObject1).downloadImediatly();
          }
        }
        else if (AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject1 = a();
        }
        else
        {
          if (!AIOFileVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            break label405;
          }
          localObject1 = b();
        }
        Object localObject3 = getThumbRect();
        if ((localObject1 != null) && ((((Drawable)localObject1).getIntrinsicHeight() * 3 < ((Drawable)localObject1).getIntrinsicWidth()) || (((Drawable)localObject1).getIntrinsicWidth() * 3 < ((Drawable)localObject1).getIntrinsicHeight()))) {
          this.isImgCenterCropMode = false;
        }
        if ((localObject1 != null) && (localObject3 != null))
        {
          this.jdField_c_of_type_Int = getCutValue((Rect)localObject3, (Drawable)localObject1);
          if (((Drawable)localObject1).getIntrinsicHeight() != -1)
          {
            int i = ((Drawable)localObject1).getIntrinsicWidth();
            if (i == -1) {
              return null;
            }
            return localObject1;
          }
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        }
        return null;
      }
      label405:
      Object localObject2 = null;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo
 * JD-Core Version:    0.7.0.1
 */