package com.tencent.mobileqq.app;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class FrameHelperActivity$11
  implements View.OnTouchListener
{
  FrameHelperActivity$11(FrameHelperActivity paramFrameHelperActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return false;
      }
      if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(13))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.clearAnimation();
        }
        if (this.a.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          this.a.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          return false;
        }
      }
      else
      {
        FrameHelperActivity.b(this.a);
        return false;
      }
    }
    else if (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface)this.a.a().getAppRuntime(), false))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(13, 200L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.11
 * JD-Core Version:    0.7.0.1
 */