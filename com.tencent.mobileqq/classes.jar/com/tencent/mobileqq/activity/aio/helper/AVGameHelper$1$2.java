package com.tencent.mobileqq.activity.aio.helper;

import afpr;
import afps;
import ahow;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bcef;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;

public class AVGameHelper$1$2
  implements Runnable
{
  public AVGameHelper$1$2(afps paramafps, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      afpr.a(this.jdField_a_of_type_Afps.a).a();
      bcef.b(null, "dc00898", "", "", "0X800B033", "0X800B033", 0, 0, "", "", afpr.a(this.jdField_a_of_type_Afps.a).curFriendUin, "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_Afps.a.a, 1, this.jdField_a_of_type_Afps.a.a.getResources().getString(2131690403), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2
 * JD-Core Version:    0.7.0.1
 */