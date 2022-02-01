package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class PhotoViewAttacher$2
  extends GestureDetector.SimpleOnGestureListener
{
  PhotoViewAttacher$2(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PhotoViewAttacher.n(this.a) != null)
    {
      if (this.a.e() > PhotoViewAttacher.l()) {
        return false;
      }
      if (paramMotionEvent1.getPointerCount() <= PhotoViewAttacher.m())
      {
        if (paramMotionEvent2.getPointerCount() > PhotoViewAttacher.m()) {
          return false;
        }
        return PhotoViewAttacher.n(this.a).a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.m(this.a) != null) {
      PhotoViewAttacher.m(this.a).onLongClick(PhotoViewAttacher.i(this.a));
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent1 = new StringBuilder();
    paramMotionEvent1.append("onScroll distanceX:");
    paramMotionEvent1.append(paramFloat1);
    paramMotionEvent1.append(" distanceY:");
    paramMotionEvent1.append(paramFloat2);
    QLog.d("PhotoViewAttacher", 4, paramMotionEvent1.toString());
    paramFloat1 = 0.0F - paramFloat1;
    paramFloat2 = 0.0F - paramFloat2;
    if (PhotoViewAttacher.l(this.a) != null) {
      PhotoViewAttacher.l(this.a).a(paramFloat1, paramFloat2);
    }
    return this.a.a(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multitouchimg.PhotoViewAttacher.2
 * JD-Core Version:    0.7.0.1
 */