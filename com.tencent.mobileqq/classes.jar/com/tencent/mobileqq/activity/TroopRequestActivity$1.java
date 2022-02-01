package com.tencent.mobileqq.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.troop.associations.TroopAssociationsUtil;

class TroopRequestActivity$1
  extends ClickableSpan
{
  TroopRequestActivity$1(TroopRequestActivity paramTroopRequestActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    TroopAssociationsUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.1
 * JD-Core Version:    0.7.0.1
 */