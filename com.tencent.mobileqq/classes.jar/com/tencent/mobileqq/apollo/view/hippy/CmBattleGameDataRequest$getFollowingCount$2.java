package com.tencent.mobileqq.apollo.view.hippy;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.CmBattleGameInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuc", "", "ret", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onCmdListener"}, k=3, mv={1, 1, 16})
final class CmBattleGameDataRequest$getFollowingCount$2
  implements MiniAppCmdInterface
{
  CmBattleGameDataRequest$getFollowingCount$2(List paramList, ICmBattleGameDataListener paramICmBattleGameDataListener, AppInterface paramAppInterface, int paramInt1, int paramInt2) {}
  
  public final void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("batchGetFollowingCount isSuc=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", ret=");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("CmBattleGameDataRequest", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (paramJSONObject != null)) {
      localObject = ((Iterable)this.a).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      CmBattleGameInfo localCmBattleGameInfo = (CmBattleGameInfo)((Iterator)localObject).next();
      localCmBattleGameInfo.followerCount = paramJSONObject.optInt(localCmBattleGameInfo.appid, 0);
      continue;
      QLog.e("CmBattleGameDataRequest", 1, "batchGetFollowingCount error!");
    }
    this.b.a(this.a);
    ((IApolloDaoManagerService)this.c.getRuntimeService(IApolloDaoManagerService.class, "all")).updateCmBattleGameInfo(this.a);
    CmBattleGameDataRequest.a(CmBattleGameDataRequest.a, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameDataRequest.getFollowingCount.2
 * JD-Core Version:    0.7.0.1
 */