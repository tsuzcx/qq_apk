package com.tencent.mobileqq.activity.main;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

class MainAssistObserver$27
  implements DialogInterface.OnClickListener
{
  MainAssistObserver$27(MainAssistObserver paramMainAssistObserver, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a, SearchContactsActivity.class);
    paramDialogInterface.putExtra("from_key", 0);
    paramDialogInterface.putExtra("fromType", 13);
    paramDialogInterface.putExtra("start_search_key", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("auto_add_and_prohibit_auto_search", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.27
 * JD-Core Version:    0.7.0.1
 */