package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class AVActivity$14
  implements Runnable
{
  AVActivity$14(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.I == null) {
      return;
    }
    SessionInfo localSessionInfo = this.this$0.I.k();
    if (localSessionInfo.b())
    {
      this.this$0.I.a(localSessionInfo.s, 229);
      this.this$0.I.b(229);
      int i = localSessionInfo.g;
      this.this$0.I.b(localSessionInfo.s, 21);
      if (i == 1) {
        localSessionInfo.a(this.a, "av.onResume.1", 3);
      } else if (i == 2) {
        localSessionInfo.a(this.a, "av.onResume.2", 4);
      }
      if (localSessionInfo.c()) {
        localSessionInfo.p = 1;
      } else {
        localSessionInfo.p = 3000;
      }
      localSessionInfo.c(this.a, false);
      localSessionInfo.d("AVActivity.onResume", 0);
      this.this$0.X.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.14
 * JD-Core Version:    0.7.0.1
 */