package com.tencent.av.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class AVSchema$MyTroopObserver$1
  implements DialogInterface.OnClickListener
{
  AVSchema$MyTroopObserver$1(AVSchema.MyTroopObserver paramMyTroopObserver, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver.jdField_a_of_type_ComTencentAvShareAVSchema.a("checkQAVPermission.callback", this.jdField_a_of_type_Long)) {
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver.jdField_a_of_type_ComTencentAvShareAVSchema.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver.jdField_a_of_type_JavaLangString);
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver.jdField_a_of_type_ComTencentAvShareAVSchema.getBaseActivity(), true, new AVSchema.MyTroopObserver.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyTroopObserver.1
 * JD-Core Version:    0.7.0.1
 */