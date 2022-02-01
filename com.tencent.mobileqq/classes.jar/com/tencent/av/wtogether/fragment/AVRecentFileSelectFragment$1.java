package com.tencent.av.wtogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class AVRecentFileSelectFragment$1
  implements DialogInterface.OnClickListener
{
  AVRecentFileSelectFragment$1(AVRecentFileSelectFragment paramAVRecentFileSelectFragment, ChooseFileInfo paramChooseFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("enter video[");
    paramDialogInterface.append(this.a);
    paramDialogInterface.append("]");
    QLog.d("AVRecentFileSelectFragment", 1, paramDialogInterface.toString());
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("watch_together_uinType", AVRecentFileSelectFragment.a(this.b));
    paramDialogInterface.putExtra("watch_together_uin", AVRecentFileSelectFragment.b(this.b));
    paramDialogInterface.putExtra("ChooseFileInfo", this.a);
    AVRecentFileSelectFragment.c(this.b).setResult(-1, paramDialogInterface);
    AVRecentFileSelectFragment.c(this.b).superFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment.1
 * JD-Core Version:    0.7.0.1
 */