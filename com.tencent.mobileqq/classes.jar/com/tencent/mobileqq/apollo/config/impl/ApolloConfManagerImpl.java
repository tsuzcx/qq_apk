package com.tencent.mobileqq.apollo.config.impl;

import com.tencent.mobileqq.apollo.config.ApolloConfProcessor;
import com.tencent.mobileqq.apollo.config.ApolloGrayConfProcessor;
import com.tencent.mobileqq.apollo.config.IApolloConfManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import org.jetbrains.annotations.NotNull;

public class ApolloConfManagerImpl
  implements IApolloConfManager
{
  @NotNull
  public Class<? extends IQConfigProcessor<?>> getGrayProcessClazz()
  {
    return ApolloGrayConfProcessor.class;
  }
  
  @NotNull
  public Class<? extends IQConfigProcessor<?>> getProcessClazz()
  {
    return ApolloConfProcessor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.impl.ApolloConfManagerImpl
 * JD-Core Version:    0.7.0.1
 */