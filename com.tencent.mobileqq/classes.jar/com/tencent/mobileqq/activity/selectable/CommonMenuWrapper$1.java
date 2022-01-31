package com.tencent.mobileqq.activity.selectable;

import ahpe;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.widget.BubblePopupWindow;

public class CommonMenuWrapper$1
  implements Runnable
{
  public CommonMenuWrapper$1(ahpe paramahpe, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
      ahpe.a(this.this$0).a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1
 * JD-Core Version:    0.7.0.1
 */