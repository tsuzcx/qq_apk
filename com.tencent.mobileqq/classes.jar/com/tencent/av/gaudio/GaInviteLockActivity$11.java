package com.tencent.av.gaudio;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GaInviteLockActivity$11
  implements Runnable
{
  GaInviteLockActivity$11(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void run()
  {
    int i = this.this$0.a;
    long l = this.this$0.b;
    int j = AVUtil.d(this.this$0.d);
    Object localObject = this.this$0.e.a(i, String.valueOf(l), null);
    String str1 = this.this$0.e.a(j, String.valueOf(this.this$0.c), String.valueOf(this.this$0.b));
    if (QLog.isDebugVersion())
    {
      String str2 = this.this$0.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAsyncSubThreadRunnable[groupName,");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("],[peerName,");
      localStringBuilder.append(str1);
      localStringBuilder.append("]");
      QLog.w(str2, 1, localStringBuilder.toString());
    }
    if ((!this.this$0.isFinishing()) && (GaInviteLockActivity.b(this.this$0) != null))
    {
      GaInviteLockActivity.b(this.this$0).removeCallbacks(GaInviteLockActivity.g(this.this$0));
      GaInviteLockActivity.g(this.this$0).a((String)localObject, str1);
      GaInviteLockActivity.b(this.this$0).post(GaInviteLockActivity.g(this.this$0));
    }
    if (GaInviteLockActivity.h(this.this$0) == null) {
      GaInviteLockActivity.a(this.this$0, new QavUpdateAvatarViewHelper());
    }
    localObject = new AvatarParam(j, String.valueOf(this.this$0.c), null, true);
    GaInviteLockActivity.h(this.this$0).a(this.this$0.e, this.this$0.j, (AvatarParam)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.11
 * JD-Core Version:    0.7.0.1
 */