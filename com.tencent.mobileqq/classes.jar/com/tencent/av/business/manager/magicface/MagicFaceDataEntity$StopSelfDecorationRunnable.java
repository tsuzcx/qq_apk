package com.tencent.av.business.manager.magicface;

import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import java.lang.ref.WeakReference;

class MagicFaceDataEntity$StopSelfDecorationRunnable
  implements Runnable
{
  final PendantItem a;
  WeakReference<MagicFaceDataEntity> b;
  
  MagicFaceDataEntity$StopSelfDecorationRunnable(MagicFaceDataEntity paramMagicFaceDataEntity, PendantItem paramPendantItem)
  {
    this.a = paramPendantItem;
    this.b = new WeakReference(paramMagicFaceDataEntity);
  }
  
  public void run()
  {
    MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.b.get();
    if (localMagicFaceDataEntity != null)
    {
      PendantItem localPendantItem = (PendantItem)localMagicFaceDataEntity.k.c();
      if ((localPendantItem != null) && (this.a.getName().equals(localPendantItem.getName()))) {
        localMagicFaceDataEntity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.StopSelfDecorationRunnable
 * JD-Core Version:    0.7.0.1
 */