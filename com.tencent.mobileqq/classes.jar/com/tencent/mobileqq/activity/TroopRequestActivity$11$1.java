package com.tencent.mobileqq.activity;

import acax;
import android.os.Handler;
import android.os.Message;
import azri;
import azrj;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$11$1
  implements Runnable
{
  public TroopRequestActivity$11$1(acax paramacax, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    azri localazri = azrj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Acax.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localazri != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localazri.a();
      this.jdField_a_of_type_Acax.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.11.1
 * JD-Core Version:    0.7.0.1
 */