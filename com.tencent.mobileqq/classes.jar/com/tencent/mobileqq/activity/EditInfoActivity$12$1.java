package com.tencent.mobileqq.activity;

import aedc;
import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$12$1
  implements Runnable
{
  public EditInfoActivity$12$1(aedc paramaedc, boolean paramBoolean, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aedc.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Aedc.a.g);
      this.jdField_a_of_type_Aedc.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Aedc.a.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aedc.a, 2, 2131693726, 0).b(this.jdField_a_of_type_Aedc.a.getTitleBarHeight());
    this.jdField_a_of_type_Aedc.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.12.1
 * JD-Core Version:    0.7.0.1
 */