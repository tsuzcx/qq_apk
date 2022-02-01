package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.utils.api.IApolloABTestApi;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public class ApolloABTestApiImpl
  implements IApolloABTestApi
{
  private static String EXP_CMSHOW_MOOD = "exp_cmshow_mood";
  private static final String TAG = "[cmshow]ApolloABTestApiImpl";
  
  public boolean canCmStatusExp()
  {
    boolean bool = doSwitchExp(EXP_CMSHOW_MOOD, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canCmStatusExp ");
    localStringBuilder.append(bool);
    QLog.i("[cmshow]ApolloABTestApiImpl", 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean doSwitchExp(String paramString, boolean paramBoolean)
  {
    Object localObject = ABTestController.a().a(paramString);
    StringBuilder localStringBuilder;
    if (((ExpEntityInfo)localObject).f())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("isExperiment.");
      QLog.d("[cmshow]ApolloABTestApiImpl", 1, localStringBuilder.toString());
      ((ExpEntityInfo)localObject).h();
      return true;
    }
    if (((ExpEntityInfo)localObject).g())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("isContrast.");
      QLog.d("[cmshow]ApolloABTestApiImpl", 1, localStringBuilder.toString());
      ((ExpEntityInfo)localObject).h();
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("exp miss.");
    QLog.d("[cmshow]ApolloABTestApiImpl", 1, ((StringBuilder)localObject).toString());
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloABTestApiImpl
 * JD-Core Version:    0.7.0.1
 */