package com.tencent.mobileqq.apollo.game.api.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/game/api/impl/CmGameHelperImpl;", "Lcom/tencent/mobileqq/apollo/game/api/ICmGameHelper;", "()V", "createGameAppInterface", "Lcom/tencent/common/app/AppInterface;", "app", "Lmqq/app/MobileQQ;", "processName", "", "getAppInterface", "getGlobalActivity", "Landroid/app/Activity;", "onGameCrashed", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmGameHelperImpl
  implements ICmGameHelper
{
  @NotNull
  public AppInterface createGameAppInterface(@NotNull MobileQQ paramMobileQQ, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMobileQQ, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "processName");
    return (AppInterface)new CmGameAppInterface(paramMobileQQ, paramString);
  }
  
  @Nullable
  public AppInterface getAppInterface()
  {
    return CmGameUtil.a();
  }
  
  @Nullable
  public Activity getGlobalActivity()
  {
    return ApolloGameUtil.a();
  }
  
  public void onGameCrashed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.api.impl.CmGameHelperImpl
 * JD-Core Version:    0.7.0.1
 */