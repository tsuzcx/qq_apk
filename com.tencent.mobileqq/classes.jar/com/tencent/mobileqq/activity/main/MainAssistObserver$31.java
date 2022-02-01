package com.tencent.mobileqq.activity.main;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

class MainAssistObserver$31
  implements DialogInterface.OnClickListener
{
  MainAssistObserver$31(MainAssistObserver paramMainAssistObserver, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.b.a, SearchContactsActivity.class);
    paramDialogInterface.putExtra("from_key", 0);
    paramDialogInterface.putExtra("fromType", 13);
    paramDialogInterface.putExtra("start_search_key", this.a);
    paramDialogInterface.putExtra("auto_add_and_prohibit_auto_search", true);
    this.b.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.31
 * JD-Core Version:    0.7.0.1
 */