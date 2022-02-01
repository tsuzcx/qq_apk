package com.tencent.biz.pubaccount.readinjoy.reward;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager$Callback;", "", "onRewardCoinWindowVisibilityChanged", "", "visiable", "", "onRewardDuplicate", "msg", "", "onRewardResult", "success", "itemIndex", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJVideoRewardCoinManager$Callback
{
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, @NotNull String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.Callback
 * JD-Core Version:    0.7.0.1
 */