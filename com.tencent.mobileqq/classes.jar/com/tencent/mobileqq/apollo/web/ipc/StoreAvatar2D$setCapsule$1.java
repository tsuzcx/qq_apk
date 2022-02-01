package com.tencent.mobileqq.apollo.web.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StoreAvatar2D$setCapsule$1
  implements Runnable
{
  StoreAvatar2D$setCapsule$1(StoreAvatar2D paramStoreAvatar2D, String paramString) {}
  
  public final void run()
  {
    Object localObject = StoreAvatar2D.a(this.this$0);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((AppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app!!\n                .g…ava, ProcessConstant.ALL)");
    localObject = (IApolloDaoManagerService)localObject;
    ApolloPandora localApolloPandora = ((IApolloDaoManagerService)localObject).getApolloPandora(this.a, true);
    if (localApolloPandora != null)
    {
      localApolloPandora.hadStolen = 1;
      ((IApolloDaoManagerService)localObject).saveOrUpdateApolloPandora(localApolloPandora);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]StoreAvatar2D", 2, "setCapsuleHadStolenAsync uin had Stolen");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("[cmshow]StoreAvatar2D", 2, "setCapsuleHadStolenAsync local not save apolloPandora");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D.setCapsule.1
 * JD-Core Version:    0.7.0.1
 */