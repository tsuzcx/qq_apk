package com.tencent.mobileqq.activity;

import acvn;
import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$11$1
  implements Runnable
{
  public EditInfoActivity$11$1(acvn paramacvn, boolean paramBoolean, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acvn.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Acvn.a.g);
      this.jdField_a_of_type_Acvn.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Acvn.a.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Acvn.a, 2, 2131694456, 0).b(this.jdField_a_of_type_Acvn.a.getTitleBarHeight());
    this.jdField_a_of_type_Acvn.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11.1
 * JD-Core Version:    0.7.0.1
 */