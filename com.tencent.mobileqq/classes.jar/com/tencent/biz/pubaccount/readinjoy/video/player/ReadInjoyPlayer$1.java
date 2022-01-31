package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import qmp;

public class ReadInjoyPlayer$1
  implements Runnable
{
  public ReadInjoyPlayer$1(qmp paramqmp, int paramInt1, String paramString1, long paramLong, int paramInt2, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 7))
    {
      qmp.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    if ((this.jdField_a_of_type_Int == 2) || ((this.jdField_a_of_type_Int == 6) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      qmp.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_Int == 5)
    {
      qmp.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
      return;
    }
    qmp.c(this.this$0, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1
 * JD-Core Version:    0.7.0.1
 */