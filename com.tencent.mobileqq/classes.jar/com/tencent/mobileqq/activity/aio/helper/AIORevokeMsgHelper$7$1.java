package com.tencent.mobileqq.activity.aio.helper;

import adgx;
import adhe;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import bcqf;
import bcql;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class AIORevokeMsgHelper$7$1
  implements Runnable
{
  public AIORevokeMsgHelper$7$1(adhe paramadhe, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.jdField_a_of_type_Int), ", type: ", Integer.valueOf(adgx.a(this.jdField_a_of_type_Adhe.a).jdField_a_of_type_Int) });
      }
      bcql.a(adgx.a(this.jdField_a_of_type_Adhe.a), adgx.a(this.jdField_a_of_type_Adhe.a).getString(2131694412), 0).b(adgx.a(this.jdField_a_of_type_Adhe.a).getTitleBarHeight());
    }
    if ((this.jdField_a_of_type_Int == 0) && (BaseChatItemLayout.a)) {
      adgx.a(this.jdField_a_of_type_Adhe.a).a(false, null, false);
    }
    if (adgx.a(this.jdField_a_of_type_Adhe.a).c != null) {
      adgx.a(this.jdField_a_of_type_Adhe.a).c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.7.1
 * JD-Core Version:    0.7.0.1
 */