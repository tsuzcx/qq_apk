package com.tencent.av.wtogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.qphone.base.util.QLog;

class AVGroupFileSelectFragment$1
  implements DialogInterface.OnClickListener
{
  AVGroupFileSelectFragment$1(AVGroupFileSelectFragment paramAVGroupFileSelectFragment, ChooseFileInfo paramChooseFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("AVGroupFileSelectFragment", 1, "enter video " + this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("watch_together_uinType", AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment));
    paramDialogInterface.putExtra("watch_together_uin", AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment));
    paramDialogInterface.putExtra("ChooseFileInfo", this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).setResult(-1, paramDialogInterface);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).superFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment.1
 * JD-Core Version:    0.7.0.1
 */