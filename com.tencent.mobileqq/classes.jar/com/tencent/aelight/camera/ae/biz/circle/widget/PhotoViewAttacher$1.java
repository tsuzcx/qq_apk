package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.graphics.Matrix;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class PhotoViewAttacher$1
  implements OnGestureListener
{
  PhotoViewAttacher$1(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (PhotoViewAttacher.a(this.a).a()) {
      return;
    }
    PhotoViewAttacher.a(this.a).postTranslate(paramFloat1, paramFloat2);
    PhotoViewAttacher.a(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDrag dx:");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append(" dy:");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append(" mAllowParentInterceptOnEdge:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.a(this.a));
    ((StringBuilder)localObject).append(" mBlockParentIntercept:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.b(this.a));
    ((StringBuilder)localObject).append(" mHorizontalScrollEdge:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.a(this.a));
    ((StringBuilder)localObject).append(" mVerticalScrollEdge:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.b(this.a));
    ((StringBuilder)localObject).append(" imageviewHashCode:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.a(this.a).hashCode());
    QLog.d("PhotoViewAttacher", 4, ((StringBuilder)localObject).toString());
    localObject = PhotoViewAttacher.a(this.a).getParent();
    if (localObject != null) {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(this.a.a(paramFloat1, paramFloat2));
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScale scalefactor:");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" curScale:");
    localStringBuilder.append(this.a.a());
    localStringBuilder.append(" focusX:");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append(" focusY:");
    localStringBuilder.append(paramFloat3);
    QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
    float f = this.a.a();
    PhotoViewAttacher.a(this.a, paramFloat2);
    PhotoViewAttacher.b(this.a, paramFloat3);
    if (((f > PhotoViewAttacher.b()) && (paramFloat1 > 1.0F)) || ((f < PhotoViewAttacher.c()) && (paramFloat1 < 1.0F))) {
      return;
    }
    PhotoViewAttacher.a(this.a).postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    PhotoViewAttacher.a(this.a);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFling startX:");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append(" startY:");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append(" getScale:");
    ((StringBuilder)localObject).append(this.a.a());
    ((StringBuilder)localObject).append(" velocityX:");
    ((StringBuilder)localObject).append(paramFloat3);
    ((StringBuilder)localObject).append(" velocityY:");
    ((StringBuilder)localObject).append(paramFloat4);
    QLog.d("PhotoViewAttacher", 2, ((StringBuilder)localObject).toString());
    if (this.a.a() == 1.0F) {
      return;
    }
    localObject = this.a;
    PhotoViewAttacher.a((PhotoViewAttacher)localObject, new PhotoViewAttacher.FlingRunnable((PhotoViewAttacher)localObject, PhotoViewAttacher.a((PhotoViewAttacher)localObject).getContext()));
    localObject = PhotoViewAttacher.a(this.a);
    PhotoViewAttacher localPhotoViewAttacher = this.a;
    int i = PhotoViewAttacher.a(localPhotoViewAttacher, PhotoViewAttacher.a(localPhotoViewAttacher));
    localPhotoViewAttacher = this.a;
    ((PhotoViewAttacher.FlingRunnable)localObject).a(i, PhotoViewAttacher.b(localPhotoViewAttacher, PhotoViewAttacher.a(localPhotoViewAttacher)), (int)paramFloat3, (int)paramFloat4);
    PhotoViewAttacher.a(this.a).post(PhotoViewAttacher.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.PhotoViewAttacher.1
 * JD-Core Version:    0.7.0.1
 */