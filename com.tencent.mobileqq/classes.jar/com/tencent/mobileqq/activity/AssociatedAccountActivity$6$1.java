package com.tencent.mobileqq.activity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

class AssociatedAccountActivity$6$1
  implements Runnable
{
  AssociatedAccountActivity$6$1(AssociatedAccountActivity.6 param6, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0.isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0.leftView.setText("");
      AssociatedAccountActivity.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).setText(this.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        AssociatedAccountActivity.access$200(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).setVisibility(8);
      } else {
        AssociatedAccountActivity.access$300(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).setVisibility(0);
      }
      AssociatedAccountActivity.access$400(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0.leftView.setContentDescription(this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0.leftView.bringToFront();
      if ("1103".equals(ThemeUtil.curThemeId))
      {
        ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0.getResources().getColorStateList(2131167053);
        AssociatedAccountActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).setTextColor(localColorStateList);
        AssociatedAccountActivity.access$600(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).setBackgroundResource(2130838321);
        AssociatedAccountActivity.access$700(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).setPadding(ViewUtils.a(8.0F), 0, ViewUtils.a(8.0F), 0);
        Object localObject = AssociatedAccountActivity.access$800(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.a(24.0F);
        if ((localObject instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.a(8.0F);
        }
        AssociatedAccountActivity.access$900(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).requestLayout();
        localObject = (GradientDrawable)AssociatedAccountActivity.access$1000(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity$6.this$0).getBackground();
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            ((GradientDrawable)localObject).setColor(localColorStateList);
          } else {
            ((GradientDrawable)localObject).setColor(localColorStateList.getDefaultColor());
          }
          ((GradientDrawable)localObject).setAlpha(46);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.6.1
 * JD-Core Version:    0.7.0.1
 */