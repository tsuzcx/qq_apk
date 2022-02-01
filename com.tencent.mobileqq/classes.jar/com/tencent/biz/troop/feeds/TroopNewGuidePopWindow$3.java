package com.tencent.biz.troop.feeds;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.utils.DisplayUtils;

class TroopNewGuidePopWindow$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopNewGuidePopWindow$3(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.d.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - DisplayUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.c.setMaxWidth(i);
    this.a.c.setText(new ColorNickText(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.h, 16).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.3
 * JD-Core Version:    0.7.0.1
 */