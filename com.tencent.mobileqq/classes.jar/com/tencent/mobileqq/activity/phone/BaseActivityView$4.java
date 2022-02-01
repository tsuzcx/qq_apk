package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.utils.NetworkUtil;

class BaseActivityView$4
  implements DialogInterface.OnKeyListener
{
  BaseActivityView$4(BaseActivityView paramBaseActivityView) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (this.a.a.f()) && (NetworkUtil.d(this.a.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView.4
 * JD-Core Version:    0.7.0.1
 */