package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.qphone.base.util.QLog;

class VideoController$25
  implements Runnable
{
  VideoController$25(VideoController paramVideoController, String paramString) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.k();
    if ((!localSessionInfo.e()) && (this.this$0.d != null) && (TextUtils.equals(this.a, localSessionInfo.s)))
    {
      long l1 = localSessionInfo.D();
      long l2 = this.this$0.d.getChatRoomId(localSessionInfo.s);
      String str = VideoController.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAvReqAutoAccept, from[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], to[");
      localStringBuilder.append(l2);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
      localSessionInfo.e(l2);
    }
    if (this.this$0.e.d(17)) {
      ((WTogetherMng)this.this$0.e.c(17)).d(localSessionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.25
 * JD-Core Version:    0.7.0.1
 */