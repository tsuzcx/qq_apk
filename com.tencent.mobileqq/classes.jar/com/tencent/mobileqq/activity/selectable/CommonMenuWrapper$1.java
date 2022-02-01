package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.view.View;
import com.tencent.widget.BubblePopupWindow;

class CommonMenuWrapper$1
  implements Runnable
{
  CommonMenuWrapper$1(CommonMenuWrapper paramCommonMenuWrapper, Activity paramActivity, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject != null)
    {
      if (!((Activity)localObject).isFinishing()) {
        CommonMenuWrapper.a(this.this$0).showAtLocation(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.b, true);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getContext();
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        CommonMenuWrapper.a(this.this$0).showAtLocation(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.b, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1
 * JD-Core Version:    0.7.0.1
 */