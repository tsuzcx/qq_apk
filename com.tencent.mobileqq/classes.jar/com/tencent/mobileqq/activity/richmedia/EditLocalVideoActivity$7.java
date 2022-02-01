package com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup;

class EditLocalVideoActivity$7
  implements DialogInterface.OnShowListener
{
  EditLocalVideoActivity$7(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (EditLocalVideoActivity.j(this.a) != null) {
      EditLocalVideoActivity.j(this.a).setVisibility(8);
    }
    if (EditLocalVideoActivity.k(this.a) != null) {
      EditLocalVideoActivity.k(this.a).setVisibility(8);
    }
    if ((EditLocalVideoActivity.l(this.a) != null) && (EditLocalVideoActivity.m(this.a) != 1)) {
      EditLocalVideoActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.7
 * JD-Core Version:    0.7.0.1
 */