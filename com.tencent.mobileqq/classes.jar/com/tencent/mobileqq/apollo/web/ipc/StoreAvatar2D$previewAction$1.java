package com.tencent.mobileqq.apollo.web.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController.PlayActionData;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import cooperation.vip.manager.QZoneVipInfoManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/web/ipc/StoreAvatar2D$previewAction$1", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "onDownLoadFinish", "", "success", "", "uin", "", "roleId", "", "dressIds", "", "actionId", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class StoreAvatar2D$previewAction$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  StoreAvatar2D$previewAction$1(IStoreAvatar2D.PreviewActionCallback paramPreviewActionCallback, ApolloStoreViewController.PlayActionData paramPlayActionData) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2)
  {
    if (!paramBoolean)
    {
      this.b.a(1, this.c);
      return;
    }
    if ((this.c.floatPreview == 1) && (StoreAvatar2D.a(this.a) != null))
    {
      paramString = StoreAvatar2D.a(this.a);
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      paramString = paramString.getRuntimeService(IApolloDaoManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "app!!\n                  …ava, ProcessConstant.ALL)");
      paramString = (IApolloDaoManagerService)paramString;
      paramArrayOfInt = StoreAvatar2D.a(this.a);
      if (paramArrayOfInt == null) {
        Intrinsics.throwNpe();
      }
      paramString = paramString.getApolloBaseInfo(paramArrayOfInt.getCurrentAccountUin());
      int i;
      if (paramString != null)
      {
        i = paramString.apolloVipFlag;
        paramInt2 = paramString.apolloVipLevel;
      }
      else
      {
        paramInt2 = 0;
        i = 0;
      }
      paramString = this.c;
      paramString.userVipFlag = i;
      paramString.userApolloVipLevel = paramInt2;
    }
    paramString = this.c;
    paramArrayOfInt = QZoneVipInfoManager.a();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "QZoneVipInfoManager.getInstance()");
    paramString.isSuperYellow = paramArrayOfInt.c();
    paramString = this.c;
    paramString.partnerRoleId = paramInt1;
    this.b.a(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D.previewAction.1
 * JD-Core Version:    0.7.0.1
 */