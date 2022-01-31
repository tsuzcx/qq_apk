package com.tencent.mobileqq.activity;

import aazz;
import android.content.Intent;
import bcql;
import com.tencent.mobileqq.data.Card;

public class EditInfoActivity$11$1
  implements Runnable
{
  public EditInfoActivity$11$1(aazz paramaazz, boolean paramBoolean, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aazz.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Aazz.a.g);
      this.jdField_a_of_type_Aazz.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Aazz.a.finish();
      return;
    }
    bcql.a(this.jdField_a_of_type_Aazz.a, 2, 2131694299, 0).b(this.jdField_a_of_type_Aazz.a.getTitleBarHeight());
    this.jdField_a_of_type_Aazz.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11.1
 * JD-Core Version:    0.7.0.1
 */