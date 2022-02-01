package com.tencent.mobileqq.activity;

import aemg;
import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$12$1
  implements Runnable
{
  public EditInfoActivity$12$1(aemg paramaemg, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aemg.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Aemg.a.g);
      this.jdField_a_of_type_Aemg.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Aemg.a.finish();
      return;
    }
    if (this.jdField_a_of_type_Int == 40) {
      QQToast.a(this.jdField_a_of_type_Aemg.a, 1, 2131717945, 0).b(this.jdField_a_of_type_Aemg.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_Aemg.a.onBackEvent();
      return;
      QQToast.a(this.jdField_a_of_type_Aemg.a, 2, 2131693743, 0).b(this.jdField_a_of_type_Aemg.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.12.1
 * JD-Core Version:    0.7.0.1
 */