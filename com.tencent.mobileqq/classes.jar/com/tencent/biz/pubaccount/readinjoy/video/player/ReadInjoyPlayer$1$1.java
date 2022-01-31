package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import osl;
import rod;
import roe;
import rof;

public class ReadInjoyPlayer$1$1
  implements Runnable
{
  public ReadInjoyPlayer$1$1(roe paramroe, osl paramosl) {}
  
  public void run()
  {
    int i = 1;
    if ((this.jdField_a_of_type_Osl.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Roe.jdField_a_of_type_JavaLangString)) && (rod.a(this.jdField_a_of_type_Roe.jdField_a_of_type_Rod, this.jdField_a_of_type_Roe.jdField_a_of_type_JavaLangString, ""))) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Osl.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Roe.jdField_a_of_type_Rod.a(123, 107, 0, "UUIDToUrlCallback vid2url ERROR ");
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_a_of_type_Osl.jdField_a_of_type_Int == 1) {}
      for (;;)
      {
        this.jdField_a_of_type_Roe.jdField_a_of_type_Rod.a(this.jdField_a_of_type_Osl.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Osl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Osl.f, this.jdField_a_of_type_Osl.jdField_b_of_type_Boolean, i, this.jdField_a_of_type_Roe.jdField_a_of_type_Long, this.jdField_a_of_type_Roe.jdField_a_of_type_Int);
        this.jdField_a_of_type_Roe.jdField_a_of_type_Rod.a.a(this.jdField_a_of_type_Osl);
        return;
        i = 2;
      }
    }
    QLog.d(rod.a(this.jdField_a_of_type_Roe.jdField_a_of_type_Rod), 2, "vid2url换回来后，当前视频已经不再播放，vid:" + this.jdField_a_of_type_Osl.jdField_b_of_type_JavaLangString + " url:" + this.jdField_a_of_type_Osl.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */