package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.BaseActivity;

class LimitChatPie$8
  implements Runnable
{
  LimitChatPie$8(LimitChatPie paramLimitChatPie, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.f != null)
    {
      if (this.this$0.f.isFinishing()) {
        return;
      }
      if ((this.this$0.bG()) && (LimitChatPie.c(this.this$0))) {
        return;
      }
      if (this.a)
      {
        LimitChatPie.d(this.this$0);
        return;
      }
      if (this.b) {
        LimitChatPie.b(this.this$0, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.8
 * JD-Core Version:    0.7.0.1
 */