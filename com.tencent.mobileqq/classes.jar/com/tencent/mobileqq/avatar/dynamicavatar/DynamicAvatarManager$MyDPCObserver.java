package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.dpc.DPCObserver;
import mqq.util.WeakReference;

class DynamicAvatarManager$MyDPCObserver
  implements DPCObserver
{
  WeakReference<DynamicAvatarManager> a;
  
  public DynamicAvatarManager$MyDPCObserver(DynamicAvatarManager paramDynamicAvatarManager)
  {
    this.a = new WeakReference(paramDynamicAvatarManager);
  }
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    DynamicAvatarManager localDynamicAvatarManager = (DynamicAvatarManager)this.a.get();
    if (localDynamicAvatarManager != null) {
      localDynamicAvatarManager.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.MyDPCObserver
 * JD-Core Version:    0.7.0.1
 */