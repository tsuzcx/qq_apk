package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;

class ClassificationSearchActivity$15
  implements DialogInterface.OnClickListener
{
  ClassificationSearchActivity$15(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ThreadManager.post(new ClassificationSearchActivity.15.1(this), 10, null, true);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.15
 * JD-Core Version:    0.7.0.1
 */