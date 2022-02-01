package com.tencent.mobileqq.apollo.view.hippy;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.CmBattleGameInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/view/hippy/CmBattleGameNativeModule$requestGameDataInThread$1", "Lcom/tencent/mobileqq/apollo/view/hippy/ICmBattleGameDataListener;", "onFailed", "", "errorMsg", "", "onSuccess", "battleGameDataList", "", "Lcom/tencent/mobileqq/apollo/model/CmBattleGameInfo;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmBattleGameNativeModule$requestGameDataInThread$1
  implements ICmBattleGameDataListener
{
  CmBattleGameNativeModule$requestGameDataInThread$1(ICmBattleGameDataListener paramICmBattleGameDataListener, int paramInt1, int paramInt2, AppInterface paramAppInterface) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    this.a.a(paramString);
  }
  
  public void a(@NotNull List<? extends CmBattleGameInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "battleGameDataList");
    paramList = CmBattleGameDataRequest.a.a(this.b, this.c, paramList);
    Collection localCollection = (Collection)paramList;
    int i;
    if ((localCollection != null) && (!localCollection.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      this.a.a("data is empty");
      QLog.e("CmBattleGameNativeModule", 1, "filter data error");
      return;
    }
    CmBattleGameDataRequest.a.a(this.d, this.b, this.c, paramList, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameNativeModule.requestGameDataInThread.1
 * JD-Core Version:    0.7.0.1
 */