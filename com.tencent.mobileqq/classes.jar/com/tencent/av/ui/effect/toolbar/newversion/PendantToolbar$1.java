package com.tencent.av.ui.effect.toolbar.newversion;

import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.qphone.base.util.QLog;

class PendantToolbar$1
  implements Runnable
{
  PendantToolbar$1(PendantToolbar paramPendantToolbar, String paramString, long paramLong) {}
  
  public void run()
  {
    if (PendantToolbar.access$000(this.this$0) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("postSetCurrentItemById, id[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.w("PendantToolbar", 1, localStringBuilder.toString());
      PendantToolbar.access$000(this.this$0).a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar.1
 * JD-Core Version:    0.7.0.1
 */