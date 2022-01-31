package com.tencent.aladdin.config;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.aladdin.config.network.AladdinConfigVersionManager;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import java.io.File;

public class AladdinUserConfig
{
  @NonNull
  private final String basePath;
  @NonNull
  private final SparseArrayCompat<AladdinConfig> configs = new SparseArrayCompat();
  @NonNull
  private final AsyncTaskExecutor executor;
  @NonNull
  private final AladdinConfigVersionManager versionManager;
  
  AladdinUserConfig(String paramString1, String paramString2, @NonNull AsyncTaskExecutor paramAsyncTaskExecutor)
  {
    this.basePath = (paramString1 + File.separator + paramString2);
    this.executor = paramAsyncTaskExecutor;
    this.versionManager = new AladdinConfigVersionManager(this.basePath);
  }
  
  @NonNull
  public AladdinConfig get(int paramInt)
  {
    try
    {
      AladdinConfig localAladdinConfig2 = (AladdinConfig)this.configs.get(paramInt);
      AladdinConfig localAladdinConfig1 = localAladdinConfig2;
      if (localAladdinConfig2 == null)
      {
        localAladdinConfig1 = new AladdinConfig(this.basePath + File.separator + paramInt + ".xml", paramInt, this.executor, Aladdin.getParserById(paramInt));
        this.configs.put(paramInt, localAladdinConfig1);
      }
      return localAladdinConfig1;
    }
    finally {}
  }
  
  @NonNull
  public String getBasePath()
  {
    return this.basePath;
  }
  
  public AladdinConfigVersionManager getVersionInfo()
  {
    return this.versionManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.AladdinUserConfig
 * JD-Core Version:    0.7.0.1
 */