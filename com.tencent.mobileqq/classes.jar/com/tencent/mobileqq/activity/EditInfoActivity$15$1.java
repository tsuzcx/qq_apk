package com.tencent.mobileqq.activity;

import adfg;
import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$15$1
  implements Runnable
{
  public EditInfoActivity$15$1(adfg paramadfg, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adfg.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Adfg.a.g);
      this.jdField_a_of_type_Adfg.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Adfg.a.finish();
      return;
    }
    if (this.jdField_a_of_type_Int == 40) {
      QQToast.a(this.jdField_a_of_type_Adfg.a, 1, 2131718186, 0).b(this.jdField_a_of_type_Adfg.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_Adfg.a.onBackEvent();
      return;
      QQToast.a(this.jdField_a_of_type_Adfg.a, 2, 2131693841, 0).b(this.jdField_a_of_type_Adfg.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.15.1
 * JD-Core Version:    0.7.0.1
 */