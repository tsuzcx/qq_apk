package com.tencent.mobileqq.activity.aio.helper;

import agtx;
import agty;
import aiul;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bdll;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;

public class AVGameHelper$1$2
  implements Runnable
{
  public AVGameHelper$1$2(agty paramagty, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      agtx.a(this.jdField_a_of_type_Agty.a).a();
      bdll.b(null, "dc00898", "", "", "0X800B033", "0X800B033", 0, 0, "", "", agtx.a(this.jdField_a_of_type_Agty.a).a, "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_Agty.a.a, 1, this.jdField_a_of_type_Agty.a.a.getResources().getString(2131690363), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2
 * JD-Core Version:    0.7.0.1
 */