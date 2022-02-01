package com.tencent.mobileqq.activity.aio.item;

import android.view.View;

class FrameAnimationActor$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    if ((this.this$0.c == 0) && (this.this$0.d != null)) {
      this.this$0.d.a();
    }
    if (this.this$0.c >= this.this$0.b.length)
    {
      this.this$0.a.setBackgroundResource(this.this$0.b[this.this$0.e]);
      if (this.this$0.d != null) {
        this.this$0.d.b();
      }
      return;
    }
    this.this$0.a.setBackgroundResource(this.this$0.b[this.this$0.c]);
    if (this.this$0.d != null) {
      this.this$0.d.a(this.this$0.c);
    }
    this.this$0.a.postDelayed(FrameAnimationActor.a(this.this$0), this.this$0.f);
    FrameAnimationActor localFrameAnimationActor = this.this$0;
    localFrameAnimationActor.c += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FrameAnimationActor.1
 * JD-Core Version:    0.7.0.1
 */