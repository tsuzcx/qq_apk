package com.tencent.mobileqq.app;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MayknowRecommendManager$8
  implements ActionSheet.OnButtonClickListener
{
  MayknowRecommendManager$8(MayknowRecommendManager paramMayknowRecommendManager, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, " onMsgTabRecommendBClick recommend_item_menu hide clicked");
      }
      this.b.r();
      ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_hide", 0, 0, "", "", "", "");
    }
    this.a.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.8
 * JD-Core Version:    0.7.0.1
 */