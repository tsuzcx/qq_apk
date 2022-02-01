package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import rwf;
import rzo;
import rzp;
import rzq;
import scv;

public class ReadInjoyPlayer$1$1
  implements Runnable
{
  public ReadInjoyPlayer$1$1(rzp paramrzp, scv paramscv) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Scv.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Rzp.jdField_a_of_type_JavaLangString)) && (rzo.a(this.jdField_a_of_type_Rzp.jdField_a_of_type_Rzo, this.jdField_a_of_type_Rzp.jdField_a_of_type_JavaLangString, ""))) {
      if (this.jdField_a_of_type_Scv.d == 2) {
        this.jdField_a_of_type_Rzp.jdField_a_of_type_Rzo.a(202, 108, 0, "vid2url failed, video deleted");
      }
    }
    label223:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Scv.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Rzp.jdField_a_of_type_Rzo.a(202, 107, 0, "vid2url failed, get null");
        return;
      }
      rwf localrwf;
      if (this.jdField_a_of_type_Scv.jdField_a_of_type_Int == 1)
      {
        i = 102;
        this.jdField_a_of_type_Rzp.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Scv.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Scv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Scv.e, this.jdField_a_of_type_Scv.jdField_b_of_type_Boolean, i, this.jdField_a_of_type_Rzp.jdField_a_of_type_Long, this.jdField_a_of_type_Rzp.jdField_a_of_type_Int);
        localrwf = this.jdField_a_of_type_Rzp.jdField_a_of_type_Rzo.jdField_a_of_type_Rwf;
        if (!this.jdField_a_of_type_Scv.jdField_a_of_type_Boolean) {
          break label223;
        }
      }
      for (int i = 1;; i = 0)
      {
        localrwf.b = i;
        this.jdField_a_of_type_Rzp.jdField_a_of_type_Rzo.jdField_a_of_type_Rzq.a(this.jdField_a_of_type_Scv);
        return;
        i = 101;
        break;
      }
    }
    QLog.d(rzo.a(this.jdField_a_of_type_Rzp.jdField_a_of_type_Rzo), 2, "vid2url换回来后，当前视频已经不再播放，vid:" + this.jdField_a_of_type_Scv.jdField_b_of_type_JavaLangString + " url:" + this.jdField_a_of_type_Scv.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */