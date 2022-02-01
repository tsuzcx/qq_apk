package com.tencent.av.ui.redbag;

import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;
import mbf;
import mqy;
import mqz;

public class ResultUI$2
  implements Runnable
{
  public ResultUI$2(mqz parammqz) {}
  
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
    if (this.this$0.jdField_a_of_type_Mqy.b())
    {
      if (this.this$0.jdField_a_of_type_Mqy.b)
      {
        this.this$0.b(localAVActivity);
        return;
      }
      this.this$0.c(localAVActivity);
      return;
    }
    if (this.this$0.jdField_a_of_type_Mqy.a())
    {
      if (this.this$0.jdField_a_of_type_Mqy.b)
      {
        this.this$0.b(localAVActivity);
        return;
      }
      this.this$0.a(localAVActivity);
      return;
    }
    if (this.this$0.jdField_a_of_type_Mqy.f == 3)
    {
      if (this.this$0.jdField_a_of_type_Mqy.b) {
        mbf.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695561);
      }
      for (;;)
      {
        this.this$0.a("EXCEPTION_BEFORE_GAME");
        return;
        mbf.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695559);
      }
    }
    if (this.this$0.jdField_a_of_type_Mqy.f == 4)
    {
      if (this.this$0.jdField_a_of_type_Mqy.b)
      {
        this.this$0.b(localAVActivity);
        return;
      }
      this.this$0.c(localAVActivity);
      this.this$0.a(localAVActivity, this.this$0.jdField_a_of_type_Mqy);
      return;
    }
    if (this.this$0.jdField_a_of_type_Mqy.f == 6)
    {
      if (this.this$0.jdField_a_of_type_Mqy.b) {
        mbf.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695562);
      }
      this.this$0.a("EXCEPTION_NOT_RECEIVE_REDBAG");
      return;
    }
    if (this.this$0.jdField_a_of_type_Mqy.f == 7)
    {
      if (this.this$0.jdField_a_of_type_Mqy.b) {
        mbf.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695560);
      }
      this.this$0.a("EXCEPTION_GAME_TIMEOUT");
      return;
    }
    QLog.w(this.this$0.i, 1, "innerShow, 不展示, mHitScore[" + this.this$0.jdField_a_of_type_Mqy.a + "], mExceptionType[" + this.this$0.jdField_a_of_type_Mqy.f + "]");
    this.this$0.a("other");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.ResultUI.2
 * JD-Core Version:    0.7.0.1
 */