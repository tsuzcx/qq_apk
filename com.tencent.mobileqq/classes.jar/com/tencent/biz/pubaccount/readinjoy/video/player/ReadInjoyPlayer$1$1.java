package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import sdj;
import sgs;
import sgt;
import sgu;
import sjt;

public class ReadInjoyPlayer$1$1
  implements Runnable
{
  public ReadInjoyPlayer$1$1(sgt paramsgt, sjt paramsjt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Sjt.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Sgt.jdField_a_of_type_JavaLangString)) && (sgs.a(this.jdField_a_of_type_Sgt.jdField_a_of_type_Sgs, this.jdField_a_of_type_Sgt.jdField_a_of_type_JavaLangString, ""))) {
      if (this.jdField_a_of_type_Sjt.d == 2) {
        this.jdField_a_of_type_Sgt.jdField_a_of_type_Sgs.a(202, 108, 0, "vid2url failed, video deleted");
      }
    }
    label223:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Sjt.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Sgt.jdField_a_of_type_Sgs.a(202, 107, 0, "vid2url failed, get null");
        return;
      }
      sdj localsdj;
      if (this.jdField_a_of_type_Sjt.jdField_a_of_type_Int == 1)
      {
        i = 102;
        this.jdField_a_of_type_Sgt.jdField_a_of_type_Sgs.a(this.jdField_a_of_type_Sjt.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Sjt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sjt.e, this.jdField_a_of_type_Sjt.jdField_b_of_type_Boolean, i, this.jdField_a_of_type_Sgt.jdField_a_of_type_Long, this.jdField_a_of_type_Sgt.jdField_a_of_type_Int);
        localsdj = this.jdField_a_of_type_Sgt.jdField_a_of_type_Sgs.jdField_a_of_type_Sdj;
        if (!this.jdField_a_of_type_Sjt.jdField_a_of_type_Boolean) {
          break label223;
        }
      }
      for (int i = 1;; i = 0)
      {
        localsdj.b = i;
        this.jdField_a_of_type_Sgt.jdField_a_of_type_Sgs.jdField_a_of_type_Sgu.a(this.jdField_a_of_type_Sjt);
        return;
        i = 101;
        break;
      }
    }
    QLog.d(sgs.a(this.jdField_a_of_type_Sgt.jdField_a_of_type_Sgs), 2, "vid2url换回来后，当前视频已经不再播放，vid:" + this.jdField_a_of_type_Sjt.jdField_b_of_type_JavaLangString + " url:" + this.jdField_a_of_type_Sjt.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */