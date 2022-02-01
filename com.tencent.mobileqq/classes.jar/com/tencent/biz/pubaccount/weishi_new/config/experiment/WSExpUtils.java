package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import UserGrowth.stGrayPolicyInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public class WSExpUtils
{
  @NonNull
  public static String a(WSExpPolicyEntities paramWSExpPolicyEntities, String paramString1, String paramString2)
  {
    paramWSExpPolicyEntities = b(paramWSExpPolicyEntities, paramString1);
    if ((paramWSExpPolicyEntities != null) && (paramWSExpPolicyEntities.params != null))
    {
      paramWSExpPolicyEntities = (String)paramWSExpPolicyEntities.params.get(paramString2);
      if (paramWSExpPolicyEntities != null) {
        return paramWSExpPolicyEntities;
      }
      return "";
    }
    return "";
  }
  
  @Nullable
  public static Map<String, String> a(WSExpPolicyEntities paramWSExpPolicyEntities, String paramString)
  {
    paramWSExpPolicyEntities = b(paramWSExpPolicyEntities, paramString);
    if (paramWSExpPolicyEntities != null) {
      return paramWSExpPolicyEntities.params;
    }
    return null;
  }
  
  private static stGrayPolicyInfo b(WSExpPolicyEntities paramWSExpPolicyEntities, String paramString)
  {
    if (paramWSExpPolicyEntities != null) {
      return paramWSExpPolicyEntities.a(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpUtils
 * JD-Core Version:    0.7.0.1
 */