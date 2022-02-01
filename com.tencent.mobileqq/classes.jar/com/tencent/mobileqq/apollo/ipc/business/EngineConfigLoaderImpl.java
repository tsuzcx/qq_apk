package com.tencent.mobileqq.apollo.ipc.business;

import androidx.annotation.Keep;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;

@Keep
public class EngineConfigLoaderImpl
  implements IEngineConfigLoader
{
  public void initConfig(IEngineConfigLoader.IConfigCallback paramIConfigCallback)
  {
    paramIConfigCallback.a(ApolloConstant.U);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.EngineConfigLoaderImpl
 * JD-Core Version:    0.7.0.1
 */