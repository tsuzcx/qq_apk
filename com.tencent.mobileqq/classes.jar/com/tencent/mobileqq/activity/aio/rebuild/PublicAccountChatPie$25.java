package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PublicAccountChatPie$25
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountChatPie$25(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.R) {
      return;
    }
    paramView = this.a;
    paramView.R = true;
    if ((paramView.jdField_a_of_type_ArrayOfInt != null) && (this.a.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      this.a.l(2131695275);
      paramInt = this.a.jdField_a_of_type_ArrayOfInt[0];
      if (paramInt == 0) {
        this.a.a(true, 0);
      } else {
        this.a.a(false, paramInt);
      }
    }
    else
    {
      this.a.l(2131695275);
      this.a.a(true, 0);
    }
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.25
 * JD-Core Version:    0.7.0.1
 */