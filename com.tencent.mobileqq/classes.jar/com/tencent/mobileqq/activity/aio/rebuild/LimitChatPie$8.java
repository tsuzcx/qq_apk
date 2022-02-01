package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.BaseActivity;

class LimitChatPie$8
  implements Runnable
{
  LimitChatPie$8(LimitChatPie paramLimitChatPie, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (this.this$0.a.isFinishing()) {
        return;
      }
      if ((this.this$0.u()) && (LimitChatPie.a(this.this$0))) {
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        LimitChatPie.a(this.this$0);
        return;
      }
      if (this.b) {
        LimitChatPie.a(this.this$0, this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.8
 * JD-Core Version:    0.7.0.1
 */