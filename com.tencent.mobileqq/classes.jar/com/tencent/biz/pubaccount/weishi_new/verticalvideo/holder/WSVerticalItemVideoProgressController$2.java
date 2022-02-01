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
    float f1 = 0.0F;
    Object localObject;
    float f3;
    float f4;
    float f2;
    if (WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController) != null)
    {
      localObject = new Rect();
      WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).a((Rect)localObject);
      if ((WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - WeishiUIUtil.f) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + WeishiUIUtil.f)))
      {
        if (!WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController))
        {
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController, true);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).a(this.jdField_a_of_type_JavaLangRunnable);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).setSeekBarActivated(true);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).setThumb(WSVerticalItemVideoProgressController.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).getDrawable(2130841989));
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).requestDisallowInterceptTouchEvent(true);
        }
        f3 = ((Rect)localObject).top;
        f4 = ((Rect)localObject).height() / 2.0F;
        f2 = paramMotionEvent.getX() - ((Rect)localObject).left;
        if (f2 >= 0.0F) {}
      }
    }
    for (;;)
    {
      localObject = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f3 + f4, paramMotionEvent.getMetaState());
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
        WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController, false);
        WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).requestDisallowInterceptTouchEvent(false);
      }
      WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).a((MotionEvent)localObject);
      return true;
      if (f2 > ((Rect)localObject).width())
      {
        f1 = ((Rect)localObject).width();
        continue;
        return false;
      }
      else
      {
        f1 = f2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.2
 * JD-Core Version:    0.7.0.1
 */