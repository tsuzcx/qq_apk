package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import UserGrowth.stGrayPolicyInfo;
import android.text.TextUtils;
import java.util.Map;

public class WSExpUtils
{
  public static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.parseInt(paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static long a(String paramString, long paramLong)
  {
    long l = paramLong;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.parseLong(paramString);
      }
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramLong;
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpUtils
 * JD-Core Version:    0.7.0.1
 */