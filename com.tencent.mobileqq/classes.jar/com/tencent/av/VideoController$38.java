package com.tencent.av;

import android.content.Context;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.av.wtogether.callback.RealNameAuthCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class VideoController$38
  implements RealNameAuthCallback
{
  VideoController$38(VideoController paramVideoController, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, Context paramContext, WTogetherRealNameVideoProcessHelper paramWTogetherRealNameVideoProcessHelper) {}
  
  public void a()
  {
    QLog.d(VideoController.a, 2, "onScreenShareRecv onCancel");
    this.g.a(null);
    QQToast.makeText(this.f, 1, 2131893613, 1).show();
  }
  
  public void a(boolean paramBoolean)
  {
    String str = VideoController.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScreenShareRecv onAuthResult auth:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      VideoController.a(this.h, this.a, this.b, true, this.c, false, this.d, this.e);
    }
    else
    {
      QLog.e(VideoController.a, 2, "onScreenShareRecv fail to auth");
      QQToast.makeText(this.f, 1, 2131893613, 1).show();
    }
    this.g.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.38
 * JD-Core Version:    0.7.0.1
 */