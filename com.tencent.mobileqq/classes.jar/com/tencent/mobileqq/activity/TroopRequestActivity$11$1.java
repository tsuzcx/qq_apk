package com.tencent.mobileqq.activity;

import aclf;
import android.os.Handler;
import android.os.Message;
import bata;
import batb;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$11$1
  implements Runnable
{
  public TroopRequestActivity$11$1(aclf paramaclf, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bata localbata = batb.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Aclf.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localbata != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localbata.a();
      this.jdField_a_of_type_Aclf.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.11.1
 * JD-Core Version:    0.7.0.1
 */