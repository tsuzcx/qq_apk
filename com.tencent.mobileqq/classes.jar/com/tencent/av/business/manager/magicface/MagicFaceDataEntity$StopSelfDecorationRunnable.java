package com.tencent.av.business.manager.magicface;

import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import java.lang.ref.WeakReference;

class MagicFaceDataEntity$StopSelfDecorationRunnable
  implements Runnable
{
  final PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
  WeakReference<MagicFaceDataEntity> jdField_a_of_type_JavaLangRefWeakReference;
  
  MagicFaceDataEntity$StopSelfDecorationRunnable(MagicFaceDataEntity paramMagicFaceDataEntity, PendantItem paramPendantItem)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = paramPendantItem;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMagicFaceDataEntity);
  }
  
  public void run()
  {
    MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localMagicFaceDataEntity != null)
    {
      PendantItem localPendantItem = (PendantItem)localMagicFaceDataEntity.a.a();
      if ((localPendantItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getName().equals(localPendantItem.getName()))) {
        localMagicFaceDataEntity.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.StopSelfDecorationRunnable
 * JD-Core Version:    0.7.0.1
 */