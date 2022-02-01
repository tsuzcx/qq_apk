package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import spn;
import ssx;
import ssy;
import ssz;
import sxc;

public class ReadInjoyPlayer$1$1
  implements Runnable
{
  public ReadInjoyPlayer$1$1(ssy paramssy, sxc paramsxc) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Sxc.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Ssy.jdField_a_of_type_JavaLangString)) && (ssx.a(this.jdField_a_of_type_Ssy.jdField_a_of_type_Ssx, this.jdField_a_of_type_Ssy.jdField_a_of_type_JavaLangString, ""))) {
      if (this.jdField_a_of_type_Sxc.d == 2) {
        this.jdField_a_of_type_Ssy.jdField_a_of_type_Ssx.a(202, 108, 0, "vid2url failed, video deleted");
      }
    }
    label223:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Sxc.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Ssy.jdField_a_of_type_Ssx.a(202, 107, 0, "vid2url failed, get null");
        return;
      }
      spn localspn;
      if (this.jdField_a_of_type_Sxc.jdField_a_of_type_Int == 1)
      {
        i = 102;
        this.jdField_a_of_type_Ssy.jdField_a_of_type_Ssx.a(this.jdField_a_of_type_Sxc.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Sxc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sxc.e, this.jdField_a_of_type_Sxc.jdField_b_of_type_Boolean, i, this.jdField_a_of_type_Ssy.jdField_a_of_type_Long, this.jdField_a_of_type_Ssy.jdField_a_of_type_Int);
        localspn = this.jdField_a_of_type_Ssy.jdField_a_of_type_Ssx.jdField_a_of_type_Spn;
        if (!this.jdField_a_of_type_Sxc.jdField_a_of_type_Boolean) {
          break label223;
        }
      }
      for (int i = 1;; i = 0)
      {
        localspn.b = i;
        this.jdField_a_of_type_Ssy.jdField_a_of_type_Ssx.jdField_a_of_type_Ssz.a(this.jdField_a_of_type_Sxc);
        return;
        i = 101;
        break;
      }
    }
    QLog.d(ssx.a(this.jdField_a_of_type_Ssy.jdField_a_of_type_Ssx), 2, "vid2url换回来后，当前视频已经不再播放，vid:" + this.jdField_a_of_type_Sxc.jdField_b_of_type_JavaLangString + " url:" + this.jdField_a_of_type_Sxc.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */