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
  
  public void onClick(View paramView, int paramInt)
  {
    if (UIUtils.d()) {
      return;
    }
    this.a.superDismiss();
    paramView = this.a.getContent(paramInt);
    if (HardCodeUtil.a(2131908656).equals(paramView))
    {
      paramView = TroopInfoUIUtil.a(this.b.v, 0);
      paramView.putInt("extra_last_open_from", this.b.w);
      TroopUtils.a(this.b, paramView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.2
 * JD-Core Version:    0.7.0.1
 */