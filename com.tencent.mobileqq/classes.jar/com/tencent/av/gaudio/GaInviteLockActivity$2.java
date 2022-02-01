package com.tencent.av.gaudio;

import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class GaInviteLockActivity$2
  implements Runnable
{
  GaInviteLockActivity$2(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void run()
  {
    if (GaInviteLockActivity.a(this.this$0) == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.this$0.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mTaskCheckRunnable before");
      ((StringBuilder)localObject2).append(GaInviteLockActivity.a(this.this$0));
      ((StringBuilder)localObject2).append(";currentMemberSize=");
      ((StringBuilder)localObject2).append(GaInviteLockActivity.a(this.this$0).size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (GaInviteLockActivity.a(this.this$0))
    {
      long l = QQAudioHelper.a() / 1000L;
      localObject1 = new ArrayList();
      localObject2 = GaInviteLockActivity.a(this.this$0).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Memberinfo localMemberinfo = (Memberinfo)((Iterator)localObject2).next();
        if (localMemberinfo.b + 60L > l)
        {
          ((ArrayList)localObject1).add(localMemberinfo);
        }
        else if (QLog.isColorLevel())
        {
          String str = this.this$0.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mTaskCheckRunnable ");
          localStringBuilder.append(localMemberinfo.b);
          localStringBuilder.append(";otherTimestamp=");
          localStringBuilder.append(l);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      GaInviteLockActivity.a(this.this$0, (ArrayList)localObject1);
    }
    GaInviteLockActivity.a(this.this$0).postDelayed(GaInviteLockActivity.a(this.this$0), 10000L);
    if (QLog.isColorLevel())
    {
      localObject1 = this.this$0.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mTaskCheckRunnable after");
      ((StringBuilder)localObject2).append(GaInviteLockActivity.a(this.this$0));
      ((StringBuilder)localObject2).append(";currentMemberSize=");
      ((StringBuilder)localObject2).append(GaInviteLockActivity.a(this.this$0).size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.2
 * JD-Core Version:    0.7.0.1
 */