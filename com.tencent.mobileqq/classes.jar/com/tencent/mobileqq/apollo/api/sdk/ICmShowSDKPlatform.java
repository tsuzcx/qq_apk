package com.tencent.mobileqq.apollo.api.sdk;

import android.content.Context;
import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/sdk/ICmShowSDKPlatform;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "changeApolloStatus", "", "mode", "", "changeApolloStatusListener", "Lcom/tencent/mobileqq/apollo/api/sdk/onChangeApolloStatusListener;", "initCmShowData", "selfUin", "", "friendUin", "onCmShowDataInitListener", "Lcom/tencent/mobileqq/apollo/api/sdk/onCmShowDataInitListener;", "traceFeatureId", "initSdk", "cmSoLoadCompleteCallback", "Lcom/tencent/mobileqq/apollo/api/res/IApolloSoLoader$OnCmSoLoadCompleteCallback;", "isSdkInit", "", "context", "Landroid/content/Context;", "openCmShowStore", "url", "preLoadRes", "uins", "Ljava/util/ArrayList;", "actionIds", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ICmShowSDKPlatform
  extends QRouteApi
{
  public abstract void changeApolloStatus(int paramInt, @Nullable onChangeApolloStatusListener paramonChangeApolloStatusListener);
  
  public abstract void initCmShowData(@Nullable String paramString1, @Nullable String paramString2, @Nullable onCmShowDataInitListener paramonCmShowDataInitListener, int paramInt);
  
  public abstract void initSdk(@Nullable IApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback, int paramInt);
  
  public abstract boolean isSdkInit(@NotNull Context paramContext);
  
  public abstract void openCmShowStore(@Nullable String paramString);
  
  public abstract void preLoadRes(@Nullable ArrayList<String> paramArrayList, @Nullable int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.ICmShowSDKPlatform
 * JD-Core Version:    0.7.0.1
 */