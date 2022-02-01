package com.tencent.av.wtogether;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class WTogetherRealNameVideoProcessHelper$RealNameAuthReceiver
  extends BroadcastReceiver
{
  private final WeakReference<WTogetherRealNameVideoProcessHelper> a;
  
  private WTogetherRealNameVideoProcessHelper$RealNameAuthReceiver(WTogetherRealNameVideoProcessHelper paramWTogetherRealNameVideoProcessHelper)
  {
    this.a = new WeakReference(paramWTogetherRealNameVideoProcessHelper);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (QLog.isColorLevel()) {
          QLog.i("WTogetherRealNameVideoProcessHelper", 2, "onReceive action[" + paramContext + "]");
        }
      } while (!"tencent.video.q2v.avReceivePushMsg".equals(paramContext));
      bool = paramIntent.getBooleanExtra("real_name_result", false);
      paramContext = (WTogetherRealNameVideoProcessHelper)this.a.get();
    } while (paramContext == null);
    WTogetherRealNameVideoProcessHelper.a(paramContext, bool);
    WTogetherRealNameVideoProcessHelper.b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper.RealNameAuthReceiver
 * JD-Core Version:    0.7.0.1
 */