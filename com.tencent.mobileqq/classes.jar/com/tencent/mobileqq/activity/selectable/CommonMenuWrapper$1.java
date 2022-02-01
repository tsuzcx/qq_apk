package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.widget.BubblePopupWindow;

class CommonMenuWrapper$1
  implements Runnable
{
  CommonMenuWrapper$1(CommonMenuWrapper paramCommonMenuWrapper, Activity paramActivity, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        CommonMenuWrapper.a(this.this$0).a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.b, true);
      }
    }
    Context localContext;
    do
    {
      return;
      localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    } while ((!(localContext instanceof Activity)) || (((Activity)localContext).isFinishing()));
    CommonMenuWrapper.a(this.this$0).a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1
 * JD-Core Version:    0.7.0.1
 */