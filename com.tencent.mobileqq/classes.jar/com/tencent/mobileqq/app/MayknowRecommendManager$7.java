package com.tencent.mobileqq.app;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MayknowRecommendManager$7
  implements ActionSheet.OnButtonClickListener
{
  MayknowRecommendManager$7(MayknowRecommendManager paramMayknowRecommendManager, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, " onMsgTabRecommendBClick recommend_item_menu hide clicked");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.h();
      ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_hide", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.7
 * JD-Core Version:    0.7.0.1
 */