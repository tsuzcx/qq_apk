package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AIORichMediaInfo
  extends GalleryImage
{
  public int a;
  public AIORichMediaData a;
  public boolean a;
  public int b;
  public Rect b;
  boolean b;
  Rect c;
  public int d;
  boolean d;
  
  public AIORichMediaInfo(AIORichMediaData paramAIORichMediaData)
  {
    this.jdField_b_of_type_Int = -2;
    this.jdField_b_of_type_Boolean = true;
    this.a = paramAIORichMediaData;
    this.jdField_c_of_type_Boolean = true;
  }
  
  @Deprecated
  public static URLDrawable a(PicUiInterface paramPicUiInterface)
  {
    return URLDrawableHelper.b(paramPicUiInterface, 1);
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public Rect a()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect;
  }
  
  public Rect b()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return this.jdField_b_of_type_AndroidGraphicsRect;
    }
    return super.b();
  }
  
  public int c()
  {
    return 0;
  }
  
  public Drawable c()
  {
    for (;;)
    {
      try
      {
        if (!AIOImageData.class.isInstance(this.a)) {
          continue;
        }
        localObject1 = this.a.a(2);
        localObject3 = this.a.a(4);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
        if ((localObject1 == null) || (BaseApplicationImpl.sImageCache.get(this.a.a(2)) == null)) {
          continue;
        }
        if (URLDrawableHelper.a(((File)localObject1).getAbsolutePath()) != 0) {
          return null;
        }
        localObject1 = URLDrawable.getDrawable(this.a.a(2), localURLDrawableOptions);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          break label549;
        }
        QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        return null;
        if (!AIOShortVideoData.class.isInstance(this.a)) {
          continue;
        }
        Object localObject2 = (AIOShortVideoData)this.a;
        Object localObject3 = ((AIOShortVideoData)localObject2).a(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
        if ((localObject3 == null) || (BaseApplicationImpl.sImageCache.get(((AIOShortVideoData)localObject2).a(0)) == null)) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.a.a(0), localURLDrawableOptions);
        continue;
        if (localObject3 == null) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.a.a(0), localURLDrawableOptions);
        ((URLDrawable)localObject2).downloadImediatly();
        continue;
        if (!AIOFilePicData.class.isInstance(this.a)) {
          continue;
        }
        localObject2 = this.a.a(18);
        localObject3 = this.a.a(20);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
        if ((localObject2 == null) || (BaseApplicationImpl.sImageCache.get(this.a.a(18)) == null)) {
          continue;
        }
        if (URLDrawableHelper.a(((File)localObject2).getAbsolutePath()) != 0) {
          break label549;
        }
        localObject2 = URLDrawable.getDrawable(this.a.a(18), localURLDrawableOptions);
        continue;
        if ((localObject3 == null) || (BaseApplicationImpl.sImageCache.get(this.a.a(20)) == null)) {
          continue;
        }
        if (URLDrawableHelper.a(((File)localObject3).getAbsolutePath()) != 0) {
          break label549;
        }
        localObject2 = URLDrawable.getDrawable(this.a.a(20), localURLDrawableOptions);
        continue;
        if (this.a.a(16) == null) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.a.a(16), localURLDrawableOptions);
        continue;
        localObject2 = null;
        continue;
      }
      localObject3 = b();
      if ((localObject1 != null) && ((((Drawable)localObject1).getIntrinsicHeight() * 3 < ((Drawable)localObject1).getIntrinsicWidth()) || (((Drawable)localObject1).getIntrinsicWidth() * 3 < ((Drawable)localObject1).getIntrinsicHeight()))) {
        this.jdField_c_of_type_Boolean = false;
      }
      if ((localObject1 == null) || (localObject3 == null)) {
        break label549;
      }
      this.jdField_d_of_type_Int = a((Rect)localObject3, (Drawable)localObject1);
      if ((((Drawable)localObject1).getIntrinsicHeight() == -1) || (((Drawable)localObject1).getIntrinsicWidth() == -1)) {
        break label549;
      }
      return localObject1;
      if ((localObject3 != null) && (BaseApplicationImpl.sImageCache.get(this.a.a(4)) != null))
      {
        if (URLDrawableHelper.a(((File)localObject3).getAbsolutePath()) != 0) {
          break label549;
        }
        localObject1 = URLDrawable.getDrawable(this.a.a(4), localURLDrawableOptions);
      }
      else
      {
        if (this.a.a(1) == null) {
          continue;
        }
        localObject1 = URLDrawable.getDrawable(this.a.a(1), localURLDrawableOptions);
        ((URLDrawable)localObject1).downloadImediatly();
      }
    }
    label549:
    return null;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo
 * JD-Core Version:    0.7.0.1
 */