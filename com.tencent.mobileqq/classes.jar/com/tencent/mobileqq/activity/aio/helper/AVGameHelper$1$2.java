package com.tencent.mobileqq.activity.aio.helper;

import aggv;
import aggw;
import aijr;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bdla;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;

public class AVGameHelper$1$2
  implements Runnable
{
  public AVGameHelper$1$2(aggw paramaggw, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      aggv.a(this.jdField_a_of_type_Aggw.a).a();
      bdla.b(null, "dc00898", "", "", "0X800B033", "0X800B033", 0, 0, "", "", aggv.a(this.jdField_a_of_type_Aggw.a).curFriendUin, "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aggw.a.a, 1, this.jdField_a_of_type_Aggw.a.a.getResources().getString(2131690475), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2
 * JD-Core Version:    0.7.0.1
 */