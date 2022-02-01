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
    if (WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController) != null)
    {
      Object localObject = new Rect();
      WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).a((Rect)localObject);
      if ((WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - WeishiUIUtil.g) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + WeishiUIUtil.g)))
      {
        if (!WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController))
        {
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController, true);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).a(this.jdField_a_of_type_JavaLangRunnable);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).setSeekBarActivated(true);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).setThumb(WSVerticalItemVideoProgressController.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).getDrawable(2130841886));
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).requestDisallowInterceptTouchEvent(true);
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
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController, false);
          WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).requestDisallowInterceptTouchEvent(false);
        }
        WSVerticalItemVideoProgressController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemVideoProgressController).a((MotionEvent)localObject);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.2
 * JD-Core Version:    0.7.0.1
 */