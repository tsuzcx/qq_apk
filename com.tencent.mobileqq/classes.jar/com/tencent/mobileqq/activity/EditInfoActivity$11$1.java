package com.tencent.mobileqq.activity;

import aaql;
import android.content.Intent;
import bbmy;
import com.tencent.mobileqq.data.Card;

public class EditInfoActivity$11$1
  implements Runnable
{
  public EditInfoActivity$11$1(aaql paramaaql, boolean paramBoolean, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aaql.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Aaql.a.g);
      this.jdField_a_of_type_Aaql.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Aaql.a.finish();
      return;
    }
    bbmy.a(this.jdField_a_of_type_Aaql.a, 2, 2131628648, 0).b(this.jdField_a_of_type_Aaql.a.getTitleBarHeight());
    this.jdField_a_of_type_Aaql.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11.1
 * JD-Core Version:    0.7.0.1
 */