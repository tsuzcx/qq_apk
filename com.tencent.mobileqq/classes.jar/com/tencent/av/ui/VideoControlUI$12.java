package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoControlUI$12
  extends ControlUIObserver
{
  VideoControlUI$12(VideoControlUI paramVideoControlUI, long paramLong1, long paramLong2) {}
  
  protected void b(long paramLong, boolean paramBoolean, String paramString)
  {
    if (this.d.V())
    {
      if (this.d.al != null) {
        this.d.al.b(this);
      }
      return;
    }
    String str = this.d.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNotify_ScreenShot_Finish, flag[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], _flag[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], path[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], ret[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.a == paramLong)
    {
      if (paramBoolean) {
        ScreenShotHelper.a((Context)this.d.ak.get(), paramString, false);
      }
      if (this.d.al != null) {
        this.d.al.b(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.12
 * JD-Core Version:    0.7.0.1
 */