package com.tencent.mobileqq.apollo.view.hippy;

import com.tencent.mobileqq.apollo.model.CmBattleGameInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/view/hippy/ICmBattleGameDataListener;", "", "onFailed", "", "errorMsg", "", "onSuccess", "battleGameDataList", "", "Lcom/tencent/mobileqq/apollo/model/CmBattleGameInfo;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ICmBattleGameDataListener
{
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@NotNull List<? extends CmBattleGameInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.ICmBattleGameDataListener
 * JD-Core Version:    0.7.0.1
 */