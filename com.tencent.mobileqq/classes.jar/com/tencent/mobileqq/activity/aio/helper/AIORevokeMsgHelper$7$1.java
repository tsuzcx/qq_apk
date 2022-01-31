package com.tencent.mobileqq.activity.aio.helper;

import adha;
import adhh;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import bcpq;
import bcpw;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class AIORevokeMsgHelper$7$1
  implements Runnable
{
  public AIORevokeMsgHelper$7$1(adhh paramadhh, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.jdField_a_of_type_Int), ", type: ", Integer.valueOf(adha.a(this.jdField_a_of_type_Adhh.a).jdField_a_of_type_Int) });
      }
      bcpw.a(adha.a(this.jdField_a_of_type_Adhh.a), adha.a(this.jdField_a_of_type_Adhh.a).getString(2131694411), 0).b(adha.a(this.jdField_a_of_type_Adhh.a).getTitleBarHeight());
    }
    if ((this.jdField_a_of_type_Int == 0) && (BaseChatItemLayout.a)) {
      adha.a(this.jdField_a_of_type_Adhh.a).a(false, null, false);
    }
    if (adha.a(this.jdField_a_of_type_Adhh.a).c != null) {
      adha.a(this.jdField_a_of_type_Adhh.a).c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.7.1
 * JD-Core Version:    0.7.0.1
 */