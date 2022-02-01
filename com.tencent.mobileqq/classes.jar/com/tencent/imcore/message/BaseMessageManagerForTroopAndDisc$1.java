package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

class BaseMessageManagerForTroopAndDisc$1
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$1(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, long paramLong1, long paramLong2, int paramInt, long paramLong3, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    long l = Math.min(this.a, this.b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>pkgIndex : ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" beginSeq:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" fixEndSeq:");
      localStringBuilder.append(l);
      QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg.trooptroop_pull_msg", 2, localStringBuilder.toString());
    }
    this.this$0.b.putAioInParallelPullMsgMark(this.e, this.d, l);
    BaseMessageManagerForTroopAndDisc.g.a(this.this$0.a, this.e, this.d, l, true, this.f, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.1
 * JD-Core Version:    0.7.0.1
 */