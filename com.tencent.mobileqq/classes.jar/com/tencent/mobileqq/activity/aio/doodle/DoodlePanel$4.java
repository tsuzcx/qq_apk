package com.tencent.mobileqq.activity.aio.doodle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DoodlePanel$4
  implements DialogInterface.OnClickListener
{
  DoodlePanel$4(DoodlePanel paramDoodlePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (this.a.a != null) {
        this.a.a.a(false, false);
      }
      DoodlePanel.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.4
 * JD-Core Version:    0.7.0.1
 */