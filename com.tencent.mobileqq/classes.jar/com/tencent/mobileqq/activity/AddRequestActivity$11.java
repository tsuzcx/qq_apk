package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class AddRequestActivity$11
  implements DialogInterface.OnClickListener
{
  AddRequestActivity$11(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      long l = Long.valueOf(this.a.app.getCurrentAccountUin()).longValue();
      this.a.showDialog(2);
      this.a.h.a(l, Long.valueOf(this.a.a).longValue(), 1);
      return;
    }
    QQToast.makeText(this.a, 2131892104, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.11
 * JD-Core Version:    0.7.0.1
 */