package com.tencent.mobileqq.activity;

import acqy;
import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$11$1
  implements Runnable
{
  public EditInfoActivity$11$1(acqy paramacqy, boolean paramBoolean, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acqy.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Acqy.a.g);
      this.jdField_a_of_type_Acqy.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Acqy.a.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Acqy.a, 2, 2131694454, 0).b(this.jdField_a_of_type_Acqy.a.getTitleBarHeight());
    this.jdField_a_of_type_Acqy.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11.1
 * JD-Core Version:    0.7.0.1
 */