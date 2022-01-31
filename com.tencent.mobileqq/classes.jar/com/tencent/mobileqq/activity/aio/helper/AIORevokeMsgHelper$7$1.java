package com.tencent.mobileqq.activity.aio.helper;

import acwe;
import acwl;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import bbms;
import bbmy;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class AIORevokeMsgHelper$7$1
  implements Runnable
{
  public AIORevokeMsgHelper$7$1(acwl paramacwl, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.jdField_a_of_type_Int), ", type: ", Integer.valueOf(acwe.a(this.jdField_a_of_type_Acwl.a).jdField_a_of_type_Int) });
      }
      bbmy.a(acwe.a(this.jdField_a_of_type_Acwl.a), acwe.a(this.jdField_a_of_type_Acwl.a).getString(2131628758), 0).b(acwe.a(this.jdField_a_of_type_Acwl.a).getTitleBarHeight());
    }
    if ((this.jdField_a_of_type_Int == 0) && (BaseChatItemLayout.a)) {
      acwe.a(this.jdField_a_of_type_Acwl.a).a(false, null, false);
    }
    if (acwe.a(this.jdField_a_of_type_Acwl.a).c != null) {
      acwe.a(this.jdField_a_of_type_Acwl.a).c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.7.1
 * JD-Core Version:    0.7.0.1
 */