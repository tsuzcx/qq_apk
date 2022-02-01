package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import java.util.ArrayList;
import java.util.List;

class ReadInJoyFeedbackPopupWindow$1$1
  extends AnimateUtils.AnimationAdapter
{
  ReadInJoyFeedbackPopupWindow$1$1(ReadInJoyFeedbackPopupWindow.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (ReadInJoyFeedbackPopupWindow.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(ReadInJoyFeedbackPopupWindow.a(this.a.a));
      ReadInJoyFeedbackPopupWindow.a(this.a.a).a(paramAnimation, ReadInJoyFeedbackPopupWindow.a(this.a.a));
      QQToast.a(this.a.a.a, 2, 2131718245, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.1.1
 * JD-Core Version:    0.7.0.1
 */