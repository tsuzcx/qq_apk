package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils;
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
    TroopMemberGlobalLevelUtils.a(localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.CheckGlamourPicturesRunnable
 * JD-Core Version:    0.7.0.1
 */