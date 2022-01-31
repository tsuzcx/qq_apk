package com.tencent.mobileqq.activity;

import aciy;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.theme.ThemeUtil;

class AssociatedAccountActivity$5$1
  implements Runnable
{
  AssociatedAccountActivity$5$1(AssociatedAccountActivity.5 param5, String paramString1, String paramString2) {}
  
  public void run()
  {
    ColorStateList localColorStateList;
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.leftView.setText("");
      AssociatedAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).setText(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label331;
      }
      AssociatedAccountActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).setVisibility(8);
      AssociatedAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.leftView.setContentDescription(this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.leftView.bringToFront();
      if ("1103".equals(ThemeUtil.curThemeId))
      {
        localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.getResources().getColorStateList(2131101257);
        AssociatedAccountActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).setTextColor(localColorStateList);
        AssociatedAccountActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).setBackgroundResource(2130838175);
        AssociatedAccountActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).setPadding(aciy.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.getResources()), 0, aciy.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.getResources()), 0);
        localObject = AssociatedAccountActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = aciy.a(24.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.getResources());
        if ((localObject instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = aciy.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0.getResources());
        }
        AssociatedAccountActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).requestLayout();
        localObject = (GradientDrawable)AssociatedAccountActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).getBackground();
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label348;
          }
          ((GradientDrawable)localObject).setColor(localColorStateList);
        }
      }
    }
    for (;;)
    {
      ((GradientDrawable)localObject).setAlpha(46);
      return;
      label331:
      AssociatedAccountActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$5.this$0).setVisibility(0);
      break;
      label348:
      ((GradientDrawable)localObject).setColor(localColorStateList.getDefaultColor());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.5.1
 * JD-Core Version:    0.7.0.1
 */