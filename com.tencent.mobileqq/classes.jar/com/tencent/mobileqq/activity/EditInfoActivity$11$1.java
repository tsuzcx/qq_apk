package com.tencent.mobileqq.activity;

import abad;
import android.content.Intent;
import bcpw;
import com.tencent.mobileqq.data.Card;

public class EditInfoActivity$11$1
  implements Runnable
{
  public EditInfoActivity$11$1(abad paramabad, boolean paramBoolean, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_Abad.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Abad.a.g);
      this.jdField_a_of_type_Abad.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Abad.a.finish();
      return;
    }
    bcpw.a(this.jdField_a_of_type_Abad.a, 2, 2131694298, 0).b(this.jdField_a_of_type_Abad.a.getTitleBarHeight());
    this.jdField_a_of_type_Abad.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11.1
 * JD-Core Version:    0.7.0.1
 */