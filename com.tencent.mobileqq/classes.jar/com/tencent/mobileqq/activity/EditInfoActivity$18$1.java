package com.tencent.mobileqq.activity;

import adwl;
import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$18$1
  implements Runnable
{
  public EditInfoActivity$18$1(adwl paramadwl, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adwl.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Adwl.a.h);
      this.jdField_a_of_type_Adwl.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Adwl.a.finish();
      return;
    }
    if (this.jdField_a_of_type_Int == 40) {
      QQToast.a(this.jdField_a_of_type_Adwl.a, 1, 2131718572, 0).b(this.jdField_a_of_type_Adwl.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_Adwl.a.onBackEvent();
      return;
      QQToast.a(this.jdField_a_of_type_Adwl.a, 2, 2131694032, 0).b(this.jdField_a_of_type_Adwl.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.18.1
 * JD-Core Version:    0.7.0.1
 */