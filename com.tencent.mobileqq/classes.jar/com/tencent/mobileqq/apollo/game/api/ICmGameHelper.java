package com.tencent.mobileqq.apollo.game.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Deprecated(message="轻游相关功能已下架")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/game/api/ICmGameHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createGameAppInterface", "Lcom/tencent/common/app/AppInterface;", "app", "Lmqq/app/MobileQQ;", "processName", "", "getAppInterface", "getGlobalActivity", "Landroid/app/Activity;", "onGameCrashed", "", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ICmGameHelper
  extends QRouteApi
{
  @NotNull
  public abstract AppInterface createGameAppInterface(@NotNull MobileQQ paramMobileQQ, @NotNull String paramString);
  
  @Nullable
  public abstract AppInterface getAppInterface();
  
  @Nullable
  public abstract Activity getGlobalActivity();
  
  public abstract void onGameCrashed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.api.ICmGameHelper
 * JD-Core Version:    0.7.0.1
 */