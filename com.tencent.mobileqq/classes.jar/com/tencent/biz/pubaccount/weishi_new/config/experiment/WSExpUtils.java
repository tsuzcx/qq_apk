package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import UserGrowth.stGrayPolicyInfo;
import java.util.Map;

public class WSExpUtils
{
  private static stGrayPolicyInfo a(WSExpPolicyEntities paramWSExpPolicyEntities, String paramString)
  {
    if (paramWSExpPolicyEntities != null) {
      return paramWSExpPolicyEntities.a(paramString);
    }
    return null;
  }
  
  public static String a(WSExpPolicyEntities paramWSExpPolicyEntities, String paramString1, String paramString2)
  {
    paramWSExpPolicyEntities = a(paramWSExpPolicyEntities, paramString1);
    if ((paramWSExpPolicyEntities != null) && (paramWSExpPolicyEntities.params != null)) {
      return (String)paramWSExpPolicyEntities.params.get(paramString2);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpUtils
 * JD-Core Version:    0.7.0.1
 */