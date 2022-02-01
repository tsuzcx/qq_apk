package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import com.tencent.common.galleryactivity.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class AIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView
  extends URLImageView2
{
  int jdField_a_of_type_Int;
  public AIORichMediaInfo a;
  boolean b = false;
  
  public AIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, Context paramContext)
  {
    super(paramContext);
  }
  
  public Bitmap a(Rect paramRect, Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    Object localObject = new Rect(0, 0, paramInt1, paramInt2);
    ((Rect)localObject).offset(-paramRect.left, -paramRect.top);
    localObject = new RectF((Rect)localObject);
    Matrix localMatrix = new Matrix();
    paramMatrix.invert(localMatrix);
    paramMatrix = new RectF();
    localMatrix.mapRect(paramMatrix, (RectF)localObject);
    paramMatrix.intersect(0.0F, 0.0F, paramRect.width(), paramRect.height());
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, String.format("getRegionBmp dstScreenRectFInImg=%s rawImgRect=%s", new Object[] { paramMatrix, paramRect }));
    }
    float f = paramMatrix.width() / paramMatrix.height();
    int j = (int)(paramInt1 / f);
    int k = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getInSampleSize(1280, 1280, paramInt1, j);
    int i = j;
    paramInt2 = paramInt1;
    if (k > 1)
    {
      paramInt2 = paramInt1 / k;
      i = j / k;
    }
    paramRect = Bitmap.createBitmap(paramInt2, i, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(paramRect);
    localMatrix = new Matrix();
    f = paramInt2 / paramMatrix.width();
    localMatrix.postTranslate(-paramMatrix.left, -paramMatrix.top);
    localMatrix.postScale(f, f);
    ((Canvas)localObject).setMatrix(localMatrix);
    draw((Canvas)localObject);
    return paramRect;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramURLDrawable = paramURLDrawable.getURL().getRef();
    if ((paramURLDrawable == null) || (!paramURLDrawable.equals("DISPLAY"))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a.a(this.jdField_a_of_type_Int, false);
    }
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = paramURLDrawable.getURL().getRef();
    if ((localObject != null) && (((String)localObject).equals("NOSAMPLE")))
    {
      this.jdField_a_of_type_Boolean = true;
      super.onLoadSuccessed(paramURLDrawable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a.a(this.jdField_a_of_type_Int, true);
    }
    else
    {
      super.onLoadSuccessed(paramURLDrawable);
      if ((localObject == null) || (!((String)localObject).equals("DISPLAY"))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a.a(this.jdField_a_of_type_Int, true);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
      if (localObject != null)
      {
        if (((AIORichMediaInfo)localObject).b == -2) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.b = paramURLDrawable.getExifOrientation();
        }
        AIOGalleryAdapter.a((View)getParent(), paramURLDrawable, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.b);
      }
      localObject = paramURLDrawable.getCurrDrawable();
      if (VideoDrawable.class.isInstance(localObject)) {
        ((VideoDrawable)localObject).setOnPlayRepeatListener(new AIOGalleryAdapter.VideoListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a));
      }
    }
    AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a).put(this.jdField_a_of_type_Int, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct.GalleryUrlImageView
 * JD-Core Version:    0.7.0.1
 */