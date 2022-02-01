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
    paramDialogInterface.append(this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
    paramDialogInterface.append("]");
    QLog.d("AVRecentFileSelectFragment", 1, paramDialogInterface.toString());
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("watch_together_uinType", AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment));
    paramDialogInterface.putExtra("watch_together_uin", AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment));
    paramDialogInterface.putExtra("ChooseFileInfo", this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
    AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment).setResult(-1, paramDialogInterface);
    AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment).superFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment.1
 * JD-Core Version:    0.7.0.1
 */