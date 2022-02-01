package com.tencent.biz.qqcircle.immersive.feed.pic;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class QFSAutoPictureManager$RecyclerTouchListener
  implements View.OnTouchListener
{
  private WeakReference<QFSAutoPictureManager> a;
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSAutoPictureManager)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return false;
    }
    return QFSAutoPictureManager.a((QFSAutoPictureManager)localObject, paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.pic.QFSAutoPictureManager.RecyclerTouchListener
 * JD-Core Version:    0.7.0.1
 */