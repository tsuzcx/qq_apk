package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import ahgl;
import ahgs;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;

public class SpringHbConversationEntry$2
  implements Runnable
{
  public SpringHbConversationEntry$2(ahgs paramahgs) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringHbConversationEntry", 2, "mTouchReleaseRunnable mActiveState:" + ahgs.a(this.this$0) + "  mResume:" + this.this$0.jdField_a_of_type_Boolean + " mTitleIsVisible:" + this.this$0.f);
        }
        ahgs.a(this.this$0, 400);
        if (ahgs.a(this.this$0) != null)
        {
          bool = this.this$0.a();
          ahgs.a(this.this$0).d();
          if ((this.this$0.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) && (this.this$0.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getScrollY() != 0))
          {
            this.this$0.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSpringbackOffset(0);
            long l = 0L;
            if (bool) {
              l = 300L;
            }
            this.this$0.a(0, l);
          }
          if ((this.this$0.jdField_a_of_type_Boolean) && (this.this$0.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null)) {
            this.this$0.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(true);
          }
          if (!this.this$0.f)
          {
            if (!this.this$0.jdField_a_of_type_Boolean) {
              this.this$0.c(true);
            }
          }
          else
          {
            ahgs.c(this.this$0);
            if ((ahgl.a != 2) && (ahgl.a != 3)) {
              break;
            }
            ahgs.a(this.this$0, true);
            return;
          }
          if ((this.this$0.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.this$0.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.m)) {
            continue;
          }
          this.this$0.c(false);
          continue;
        }
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbConversationEntry", 1, "onTouchRelease", localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbConversationEntry.2
 * JD-Core Version:    0.7.0.1
 */