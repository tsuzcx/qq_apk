package com.tencent.biz.qqstory.videoplayer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class StoryPlayerCommentDialog$1
  implements DialogInterface.OnKeyListener
{
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.StoryPlayerCommentDialog.1
 * JD-Core Version:    0.7.0.1
 */