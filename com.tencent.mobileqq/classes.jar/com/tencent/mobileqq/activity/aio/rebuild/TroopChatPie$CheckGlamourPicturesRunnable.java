package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import bgtl;
import mqq.util.WeakReference;

public class TroopChatPie$CheckGlamourPicturesRunnable
  implements Runnable
{
  WeakReference<Context> a;
  
  public TroopChatPie$CheckGlamourPicturesRunnable(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  public void run()
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return;
    }
    bgtl.a(localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.CheckGlamourPicturesRunnable
 * JD-Core Version:    0.7.0.1
 */