package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PublicAccountChatPie$24
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountChatPie$24(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.ab) {
      return;
    }
    this.a.ab = true;
    if ((this.a.jdField_a_of_type_ArrayOfInt != null) && (this.a.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      this.a.v(2131695271);
      paramInt = this.a.jdField_a_of_type_ArrayOfInt[0];
      if (paramInt == 0) {
        this.a.b(true, 0);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.a.b(false, paramInt);
      continue;
      this.a.v(2131695271);
      this.a.b(true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.24
 * JD-Core Version:    0.7.0.1
 */