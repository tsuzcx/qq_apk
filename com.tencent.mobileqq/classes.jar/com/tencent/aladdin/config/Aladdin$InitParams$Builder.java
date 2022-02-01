package com.tencent.aladdin.config;

import android.content.Context;
import com.tencent.aladdin.config.network.AladdinRequestHandler;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.aladdin.config.utils.AladdinLogger;

public final class Aladdin$InitParams$Builder
{
  private String appFlavorId;
  private Integer appId;
  private String appVersion;
  private Context context;
  private AsyncTaskExecutor executor;
  private AladdinLogger logger;
  private AladdinRequestHandler requestHandler;
  private String rootDir;
  private String userId;
  
  public Aladdin.InitParams build()
  {
    return new Aladdin.InitParams(this, null);
  }
  
  public Builder withAppFlavorId(String paramString)
  {
    this.appFlavorId = paramString;
    return this;
  }
  
  public Builder withAppId(Integer paramInteger)
  {
    this.appId = paramInteger;
    return this;
  }
  
  public Builder withAppVersion(String paramString)
  {
    this.appVersion = paramString;
    return this;
  }
  
  public Builder withContext(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
  
  public Builder withExecutor(AsyncTaskExecutor paramAsyncTaskExecutor)
  {
    this.executor = paramAsyncTaskExecutor;
    return this;
  }
  
  public Builder withLogger(AladdinLogger paramAladdinLogger)
  {
    this.logger = paramAladdinLogger;
    return this;
  }
  
  public Builder withRequestHandler(AladdinRequestHandler paramAladdinRequestHandler)
  {
    this.requestHandler = paramAladdinRequestHandler;
    return this;
  }
  
  public Builder withRootDir(String paramString)
  {
    this.rootDir = paramString;
    return this;
  }
  
  public Builder withUserId(String paramString)
  {
    this.userId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.Aladdin.InitParams.Builder
 * JD-Core Version:    0.7.0.1
 */