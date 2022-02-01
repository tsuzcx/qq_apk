package com.tencent.biz.pubaccount.AccountDetail.view;

import android.view.MotionEvent;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

class ReadInJoyNewFeedsTopGestureLayout$EdgeFlingListener
  implements IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener
{
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (ReadInJoyNewFeedsTopGestureLayout.a(this.a) != null)
    {
      if (ReadInJoyNewFeedsTopGestureLayout.a(this.a).getTopGestureLayout() == null) {
        return false;
      }
      TopGestureLayout localTopGestureLayout = ReadInJoyNewFeedsTopGestureLayout.a(this.a).getTopGestureLayout();
      if (!localTopGestureLayout.isGestureIdle())
      {
        if (localTopGestureLayout.isGestureEnd()) {
          return false;
        }
        paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
        paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
        int i = 1;
        if (localTopGestureLayout.hasGestureFlag(1))
        {
          double d1 = paramMotionEvent1.getX();
          double d2 = DeviceInfoUtil.i();
          Double.isNaN(d2);
          if (d1 > d2 * 0.2133333333333334D) {
            i = 0;
          }
          if ((i != 0) && (paramFloat1 < 0.0F) && (paramFloat2 < 0.5F) && (ReadInJoyNewFeedsTopGestureLayout.a(this.a).getOnFlingGesture() != null))
          {
            localTopGestureLayout.setGestureFlag(-1);
            if (!ReadInJoyNewFeedsTopGestureLayout.a(this.a).isInTwoFingerMode())
            {
              ReadInJoyNewFeedsTopGestureLayout.a(this.a).getOnFlingGesture().flingLToR();
              return false;
            }
          }
        }
        else if ((localTopGestureLayout.hasGestureFlag(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F) && (ReadInJoyNewFeedsTopGestureLayout.a(this.a).getOnFlingGesture() != null))
        {
          localTopGestureLayout.setGestureFlag(-1);
          if (!ReadInJoyNewFeedsTopGestureLayout.a(this.a).isInTwoFingerMode()) {
            ReadInJoyNewFeedsTopGestureLayout.a(this.a).getOnFlingGesture().flingRToL();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout.EdgeFlingListener
 * JD-Core Version:    0.7.0.1
 */