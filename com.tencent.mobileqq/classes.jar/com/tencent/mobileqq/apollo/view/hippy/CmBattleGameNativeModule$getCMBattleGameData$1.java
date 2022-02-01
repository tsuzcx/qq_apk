package com.tencent.mobileqq.apollo.view.hippy;

import com.tencent.mobileqq.apollo.model.CmBattleGameInfo;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/view/hippy/CmBattleGameNativeModule$getCMBattleGameData$1", "Lcom/tencent/mobileqq/apollo/view/hippy/ICmBattleGameDataListener;", "onFailed", "", "errorMsg", "", "onSuccess", "battleGameDataList", "", "Lcom/tencent/mobileqq/apollo/model/CmBattleGameInfo;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmBattleGameNativeModule$getCMBattleGameData$1
  implements ICmBattleGameDataListener
{
  CmBattleGameNativeModule$getCMBattleGameData$1(Promise paramPromise) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    this.a.reject(paramString);
  }
  
  public void a(@NotNull List<? extends CmBattleGameInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "battleGameDataList");
    paramList = GsonUtils.objList2Json(paramList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("promise resolve jsonData=");
      localStringBuilder.append(paramList);
      QLog.d("CmBattleGameNativeModule", 2, localStringBuilder.toString());
    }
    this.a.resolve(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameNativeModule.getCMBattleGameData.1
 * JD-Core Version:    0.7.0.1
 */