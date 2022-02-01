package com.tencent.mobileqq.apollo.api.uitls;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/uitls/IApolloConfigHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isTargetVersion", "", "localVer", "", "minVer", "maxVer", "parseBaseScriptConfig", "", "object", "Lorg/json/JSONObject;", "key", "isUpdate", "parseConfigJson", "configContent", "app", "Lmqq/app/AppRuntime;", "parseGameConfigJson", "contentString", "parsePreDownloadConfig", "parseTraceConfigJson", "content", "parseUrlGrayConfigJson", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloConfigHelper
  extends QRouteApi
{
  public abstract boolean isTargetVersion(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3);
  
  public abstract void parseBaseScriptConfig(@Nullable JSONObject paramJSONObject, @Nullable String paramString, boolean paramBoolean);
  
  public abstract void parseConfigJson(@Nullable String paramString, @Nullable AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void parseGameConfigJson(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, boolean paramBoolean);
  
  public abstract void parsePreDownloadConfig(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString);
  
  public abstract void parseTraceConfigJson(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString);
  
  public abstract void parseUrlGrayConfigJson(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.IApolloConfigHelper
 * JD-Core Version:    0.7.0.1
 */