package com.tencent.biz.pubaccount.readinjoy.report;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import rjm;

public class UserActionCollector$1
  implements Runnable
{
  public UserActionCollector$1(rjm paramrjm, int paramInt, AbsListView paramAbsListView) {}
  
  public void run()
  {
    for (int i = this.this$0.i;; i = j)
    {
      try
      {
        if (this.jdField_a_of_type_Int != 0) {
          break label75;
        }
        j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
        int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentWidgetAbsListView.getContext());
        int m = this.jdField_a_of_type_ComTencentWidgetAbsListView.getResources().getDimensionPixelOffset(2131298776);
        i = j - k - m;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          label75:
          AIOUtils.catchedExceptionInRelease("UserActionCollector", "calculte height error !", localException);
        }
      }
      if (i > 0) {
        this.this$0.i = i;
      }
      this.this$0.d();
      return;
      j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector.1
 * JD-Core Version:    0.7.0.1
 */