package com.tencent.mobileqq.armap;

import android.view.MotionEvent;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class CaiShenActivity$2
  implements InterceptTouchEventLayout.InterceptTouchEventListener
{
  CaiShenActivity$2(CaiShenActivity paramCaiShenActivity) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (!NetworkUtil.d(this.this$0.getApplicationContext())))
    {
      QQToast.a(this.this$0.getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(this.this$0.getTitleBarHeight());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.2
 * JD-Core Version:    0.7.0.1
 */