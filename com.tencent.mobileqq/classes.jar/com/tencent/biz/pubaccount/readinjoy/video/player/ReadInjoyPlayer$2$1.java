package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import ocs;
import qmp;
import qmq;
import qmr;

public class ReadInjoyPlayer$2$1
  implements Runnable
{
  public ReadInjoyPlayer$2$1(qmq paramqmq, ocs paramocs) {}
  
  public void run()
  {
    int i = 1;
    if ((this.jdField_a_of_type_Ocs.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Qmq.jdField_a_of_type_JavaLangString)) && (qmp.a(this.jdField_a_of_type_Qmq.jdField_a_of_type_Qmp, this.jdField_a_of_type_Qmq.jdField_a_of_type_JavaLangString, ""))) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Ocs.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Qmq.jdField_a_of_type_Qmp.a(123, 107, 0, "UUIDToUrlCallback vid2url ERROR ");
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_a_of_type_Ocs.jdField_a_of_type_Int == 1) {}
      for (;;)
      {
        this.jdField_a_of_type_Qmq.jdField_a_of_type_Qmp.a(this.jdField_a_of_type_Ocs.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Ocs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ocs.f, this.jdField_a_of_type_Ocs.jdField_b_of_type_Boolean, i, this.jdField_a_of_type_Qmq.jdField_a_of_type_Long, this.jdField_a_of_type_Qmq.jdField_a_of_type_Int);
        this.jdField_a_of_type_Qmq.jdField_a_of_type_Qmp.a.a(this.jdField_a_of_type_Ocs);
        return;
        i = 2;
      }
    }
    QLog.d(qmp.a(this.jdField_a_of_type_Qmq.jdField_a_of_type_Qmp), 2, "vid2url换回来后，当前视频已经不再播放，vid:" + this.jdField_a_of_type_Ocs.jdField_b_of_type_JavaLangString + " url:" + this.jdField_a_of_type_Ocs.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */