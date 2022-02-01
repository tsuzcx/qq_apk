package com.tencent.mobileqq.apollo.store.api.impl;

import com.tencent.mobileqq.apollo.store.ApolloStoreStabilityReportManager;
import com.tencent.mobileqq.apollo.store.api.IApolloStoreReportHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/store/api/impl/ApolloStoreReportHelperImpl;", "Lcom/tencent/mobileqq/apollo/store/api/IApolloStoreReportHelper;", "()V", "reportSSORetCodeNonZero", "", "cmd", "", "ssoErrorCode", "", "ssoCost", "", "reportSSOSuccessCost", "reportSSOTimeout", "Constant", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloStoreReportHelperImpl
  implements IApolloStoreReportHelper
{
  public static final ApolloStoreReportHelperImpl.Constant Constant = new ApolloStoreReportHelperImpl.Constant(null);
  @NotNull
  public static final String TAG = "_apollo_store_stability_";
  
  public void reportSSORetCodeNonZero(@NotNull String paramString, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportSSORetCodeNonZero. cmd=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ssoErrorCode=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ApolloStoreStabilityReportManager.a();
    if (((ApolloStoreStabilityReportManager)localObject).a(paramString))
    {
      ((ApolloStoreStabilityReportManager)localObject).a(paramString, null, -1002, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd is not in white list");
    }
  }
  
  public void reportSSOSuccessCost(@Nullable String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportSSOSuccessCost. cmd=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ssoCost=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ApolloStoreStabilityReportManager.a();
    if (((ApolloStoreStabilityReportManager)localObject).a(paramString))
    {
      ((ApolloStoreStabilityReportManager)localObject).a(paramString, null, 1000, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd is not in white list");
    }
  }
  
  public void reportSSOTimeout(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportSSOTimeout. cmd=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ApolloStoreStabilityReportManager.a();
    if (((ApolloStoreStabilityReportManager)localObject).a(paramString))
    {
      ((ApolloStoreStabilityReportManager)localObject).a(paramString, null, -1001, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_apollo_store_stability_", 2, "reportSSOTimeout. cmd is not in white list");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.api.impl.ApolloStoreReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */