package com.tencent.mobileqq.apollo.api.uitls.impl;

import com.tencent.mobileqq.apollo.api.uitls.IApolloConfigHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/uitls/impl/ApolloConfigHelperImpl;", "Lcom/tencent/mobileqq/apollo/api/uitls/IApolloConfigHelper;", "()V", "isTargetVersion", "", "localVer", "", "minVer", "maxVer", "parseBaseScriptConfig", "", "object", "Lorg/json/JSONObject;", "key", "isUpdate", "parseConfigJson", "configContent", "app", "Lmqq/app/AppRuntime;", "parseGameConfigJson", "contentString", "parsePreDownloadConfig", "parseTraceConfigJson", "content", "parseUrlGrayConfigJson", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloConfigHelperImpl
  implements IApolloConfigHelper
{
  public boolean isTargetVersion(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    return ApolloConfigUtils.a(paramString1, paramString2, paramString3);
  }
  
  public void parseBaseScriptConfig(@Nullable JSONObject paramJSONObject, @Nullable String paramString, boolean paramBoolean)
  {
    ApolloConfigUtils.a(paramJSONObject, paramString, paramBoolean);
  }
  
  public void parseConfigJson(@Nullable String paramString, @Nullable AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    ApolloConfigUtils.a(paramString, paramAppRuntime, paramBoolean);
  }
  
  public void parseGameConfigJson(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, boolean paramBoolean)
  {
    ApolloConfigUtils.b(paramAppRuntime, paramString, paramBoolean);
  }
  
  public void parsePreDownloadConfig(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString)
  {
    ApolloConfigUtils.b(paramAppRuntime, paramString);
  }
  
  public void parseTraceConfigJson(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString)
  {
    ApolloConfigUtils.a(paramAppRuntime, paramString);
  }
  
  public void parseUrlGrayConfigJson(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, boolean paramBoolean)
  {
    ApolloConfigUtils.a(paramAppRuntime, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloConfigHelperImpl
 * JD-Core Version:    0.7.0.1
 */