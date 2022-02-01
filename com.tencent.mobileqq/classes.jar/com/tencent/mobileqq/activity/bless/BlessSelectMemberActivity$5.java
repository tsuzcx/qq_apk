package com.tencent.mobileqq.activity.bless;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.util.MqqWeakReferenceHandler;

class BlessSelectMemberActivity$5
  implements DialogInterface.OnKeyListener
{
  BlessSelectMemberActivity$5(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84) {}
    do
    {
      return true;
      if (paramInt != 4) {
        break;
      }
    } while (BlessSelectMemberActivity.a() == null);
    BlessSelectMemberActivity.a().sendEmptyMessage(1);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity.5
 * JD-Core Version:    0.7.0.1
 */