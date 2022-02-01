package com.tencent.av;

import com.tencent.av.app.SessionInfo;

class VideoController$45
  implements Runnable
{
  VideoController$45(VideoController paramVideoController, String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.b.d(this.a);
    if ((!this.this$0.j) && (localSessionInfo != null) && (localSessionInfo.p != 21) && (localSessionInfo.p != 1011)) {
      this.this$0.a(this.a, localSessionInfo.h, false, false, true);
    }
    this.this$0.a(this.b, this.a, this.c, this.d, this.e, this.f, false, this.g, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.45
 * JD-Core Version:    0.7.0.1
 */