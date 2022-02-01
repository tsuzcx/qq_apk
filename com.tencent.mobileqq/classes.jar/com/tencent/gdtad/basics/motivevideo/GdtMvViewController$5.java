package com.tencent.gdtad.basics.motivevideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class GdtMvViewController$5
  implements DialogInterface.OnKeyListener
{
  GdtMvViewController$5(GdtMvViewController paramGdtMvViewController) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.5
 * JD-Core Version:    0.7.0.1
 */