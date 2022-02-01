package com.tencent.av.wtogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class AVGroupFileSelectFragment$1
  implements DialogInterface.OnClickListener
{
  AVGroupFileSelectFragment$1(AVGroupFileSelectFragment paramAVGroupFileSelectFragment, ChooseFileInfo paramChooseFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("enter video ");
    paramDialogInterface.append(this.a);
    QLog.d("AVGroupFileSelectFragment", 1, paramDialogInterface.toString());
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("watch_together_uinType", AVGroupFileSelectFragment.a(this.b));
    paramDialogInterface.putExtra("watch_together_uin", AVGroupFileSelectFragment.b(this.b));
    paramDialogInterface.putExtra("ChooseFileInfo", this.a);
    AVGroupFileSelectFragment.c(this.b).setResult(-1, paramDialogInterface);
    AVGroupFileSelectFragment.c(this.b).superFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment.1
 * JD-Core Version:    0.7.0.1
 */