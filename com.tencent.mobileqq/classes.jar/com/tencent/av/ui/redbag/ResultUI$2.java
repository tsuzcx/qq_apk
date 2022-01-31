package com.tencent.av.ui.redbag;

import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;
import mat;
import mpz;
import mqa;

public class ResultUI$2
  implements Runnable
{
  public ResultUI$2(mqa parammqa) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      QLog.w(this.this$0.i, 1, "innerShow 已经显示了");
      return;
    }
    this.this$0.b();
    AVActivity localAVActivity = this.this$0.a();
    if (localAVActivity == null)
    {
      QLog.w(this.this$0.i, 1, "innerShow avActivity为空");
      return;
    }
    if (!localAVActivity.e())
    {
      QLog.w(this.this$0.i, 1, "innerShow avActivity不在top, avActivity[" + localAVActivity + "]");
      return;
    }
    QLog.w(this.this$0.i, 1, "innerShow, avActivity[" + localAVActivity + "]");
    this.this$0.jdField_a_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Mpz.b())
    {
      if (this.this$0.jdField_a_of_type_Mpz.b)
      {
        this.this$0.b(localAVActivity);
        return;
      }
      this.this$0.c(localAVActivity);
      return;
    }
    if (this.this$0.jdField_a_of_type_Mpz.a())
    {
      if (this.this$0.jdField_a_of_type_Mpz.b)
      {
        this.this$0.b(localAVActivity);
        return;
      }
      this.this$0.a(localAVActivity);
      return;
    }
    if (this.this$0.jdField_a_of_type_Mpz.f == 3)
    {
      if (this.this$0.jdField_a_of_type_Mpz.b) {
        mat.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131696117);
      }
      for (;;)
      {
        this.this$0.a("EXCEPTION_BEFORE_GAME");
        return;
        mat.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131696115);
      }
    }
    if (this.this$0.jdField_a_of_type_Mpz.f == 4)
    {
      if (this.this$0.jdField_a_of_type_Mpz.b)
      {
        this.this$0.b(localAVActivity);
        return;
      }
      this.this$0.c(localAVActivity);
      this.this$0.a(localAVActivity, this.this$0.jdField_a_of_type_Mpz);
      return;
    }
    if (this.this$0.jdField_a_of_type_Mpz.f == 6)
    {
      if (this.this$0.jdField_a_of_type_Mpz.b) {
        mat.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131696118);
      }
      this.this$0.a("EXCEPTION_NOT_RECEIVE_REDBAG");
      return;
    }
    if (this.this$0.jdField_a_of_type_Mpz.f == 7)
    {
      if (this.this$0.jdField_a_of_type_Mpz.b) {
        mat.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131696116);
      }
      this.this$0.a("EXCEPTION_GAME_TIMEOUT");
      return;
    }
    QLog.w(this.this$0.i, 1, "innerShow, 不展示, mHitScore[" + this.this$0.jdField_a_of_type_Mpz.a + "], mExceptionType[" + this.this$0.jdField_a_of_type_Mpz.f + "]");
    this.this$0.a("other");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.redbag.ResultUI.2
 * JD-Core Version:    0.7.0.1
 */