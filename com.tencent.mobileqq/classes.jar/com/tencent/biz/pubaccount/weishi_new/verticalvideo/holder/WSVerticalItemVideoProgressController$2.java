package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout.DispatchTouchEventListener;

class WSVerticalItemVideoProgressController$2
  implements WSVerticalVideoRelativeLayout.DispatchTouchEventListener
{
  WSVerticalItemVideoProgressController$2(WSVerticalItemVideoProgressController paramWSVerticalItemVideoProgressController, Runnable paramRunnable) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (WSVerticalItemVideoProgressController.a(this.b) != null)
    {
      Object localObject = new Rect();
      WSVerticalItemVideoProgressController.a(this.b).a((Rect)localObject);
      if ((WSVerticalItemVideoProgressController.c(this.b)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - WeishiUIUtil.h) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + WeishiUIUtil.h)))
      {
        if (!WSVerticalItemVideoProgressController.c(this.b))
        {
          WSVerticalItemVideoProgressController.a(this.b, true);
          WSVerticalItemVideoProgressController.a(this.b).a(this.a);
          WSVerticalItemVideoProgressController.a(this.b).setSeekBarActivated(true);
          WSVerticalItemVideoProgressController.a(this.b).setThumb(WSVerticalItemVideoProgressController.d(this.b).getDrawable(2130842804));
          WSVerticalItemVideoProgressController.e(this.b).requestDisallowInterceptTouchEvent(true);
        }
        float f2 = ((Rect)localObject).top;
        float f3 = ((Rect)localObject).height() / 2.0F;
        float f1 = paramMotionEvent.getX() - ((Rect)localObject).left;
        if (f1 < 0.0F) {
          f1 = 0.0F;
        } else if (f1 > ((Rect)localObject).width()) {
          f1 = ((Rect)localObject).width();
        }
        localObject = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f2 + f3, paramMotionEvent.getMetaState());
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
        {
          WSVerticalItemVideoProgressController.a(this.b).postDelayed(this.a, 400L);
          WSVerticalItemVideoProgressController.a(this.b, false);
          WSVerticalItemVideoProgressController.e(this.b).requestDisallowInterceptTouchEvent(false);
        }
        WSVerticalItemVideoProgressController.a(this.b).a((MotionEvent)localObject);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.2
 * JD-Core Version:    0.7.0.1
 */