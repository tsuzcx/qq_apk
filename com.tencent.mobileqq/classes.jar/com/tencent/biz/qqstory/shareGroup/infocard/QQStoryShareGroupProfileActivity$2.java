package com.tencent.biz.qqstory.shareGroup.infocard;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQStoryShareGroupProfileActivity$2
  implements ActionSheet.OnButtonClickListener
{
  QQStoryShareGroupProfileActivity$2(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (UIUtils.b()) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (HardCodeUtil.a(2131710990).equals(paramView))
    {
      paramView = TroopInfoUIUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.c, 0);
      paramView.putInt("extra_last_open_from", this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a);
      TroopUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, paramView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.2
 * JD-Core Version:    0.7.0.1
 */