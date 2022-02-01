package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

class ContactSyncJumpActivity$3
  extends Handler
{
  ContactSyncJumpActivity$3(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      if (this.a.a()) {
        break label149;
      }
      i = paramMessage.arg1 - 1;
      if (i != 0) {
        break label39;
      }
      ContactSyncJumpActivity.a(this.a);
    }
    label39:
    while ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (this.a.jdField_a_of_type_Int != 2))
    {
      int i;
      return;
      if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_Int == 2))
      {
        paramMessage = "(" + i + ")";
        ((TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131365836)).setText(String.format(this.a.getResources().getString(2131698657), new Object[] { paramMessage }));
      }
      paramMessage = obtainMessage(1000);
      paramMessage.arg1 = i;
      sendMessageDelayed(paramMessage, 1000L);
      return;
    }
    label149:
    ((TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131365836)).setText(String.format(this.a.getResources().getString(2131698657), new Object[] { "" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */