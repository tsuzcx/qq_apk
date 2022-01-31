package com.tencent.mobileqq.activity;

import aehe;
import android.os.Handler;
import android.os.Message;
import bcwd;
import bcwe;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$11$1
  implements Runnable
{
  public TroopRequestActivity$11$1(aehe paramaehe, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bcwd localbcwd = bcwe.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Aehe.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localbcwd != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localbcwd.a();
      this.jdField_a_of_type_Aehe.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.11.1
 * JD-Core Version:    0.7.0.1
 */