package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class WSExpFileCacheUtils
{
  private static final Object a = new Object();
  
  public static WSExpPolicyEntities a(String paramString)
  {
    synchronized (a)
    {
      paramString = b(paramString);
      return paramString;
    }
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_exp_data_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean a(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    synchronized (a)
    {
      boolean bool = b(paramWSExpPolicyEntities);
      return bool;
    }
  }
  
  public static WSExpPolicyEntities b(String paramString)
  {
    stGetAllABTestPolicyRsp localstGetAllABTestPolicyRsp = (stGetAllABTestPolicyRsp)WSFileUtils.a(new stGetAllABTestPolicyRsp(), a(paramString));
    if (localstGetAllABTestPolicyRsp == null) {
      return null;
    }
    return new WSExpPolicyEntities(paramString, localstGetAllABTestPolicyRsp);
  }
  
  public static boolean b(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    if ((paramWSExpPolicyEntities != null) && (paramWSExpPolicyEntities.a() != null)) {
      return WSFileUtils.a(paramWSExpPolicyEntities.a(), a(paramWSExpPolicyEntities.a()));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpFileCacheUtils
 * JD-Core Version:    0.7.0.1
 */