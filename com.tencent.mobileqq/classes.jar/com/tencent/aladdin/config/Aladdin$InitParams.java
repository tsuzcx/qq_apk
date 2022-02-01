package com.tencent.aladdin.config;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.aladdin.config.network.AladdinRequestHandler;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.aladdin.config.utils.AladdinLogger;

public class Aladdin$InitParams
{
  @NonNull
  private String appFlavorId = "";
  @NonNull
  private Integer appId = Integer.valueOf(0);
  @NonNull
  private String appVersion = "";
  @NonNull
  private final Context context;
  private final AsyncTaskExecutor executor;
  private final AladdinLogger logger;
  @NonNull
  private final AladdinRequestHandler requestHandler;
  private final String rootDir;
  @NonNull
  private final String userId;
  
  private Aladdin$InitParams(Aladdin.InitParams.Builder paramBuilder)
  {
    this.context = Aladdin.InitParams.Builder.access$1000(paramBuilder);
    this.rootDir = Aladdin.InitParams.Builder.access$1100(paramBuilder);
    this.userId = Aladdin.InitParams.Builder.access$1200(paramBuilder);
    this.appId = Aladdin.InitParams.Builder.access$1300(paramBuilder);
    this.appVersion = Aladdin.InitParams.Builder.access$1400(paramBuilder);
    this.executor = Aladdin.InitParams.Builder.access$1500(paramBuilder);
    this.requestHandler = Aladdin.InitParams.Builder.access$1600(paramBuilder);
    this.logger = Aladdin.InitParams.Builder.access$1700(paramBuilder);
    this.appFlavorId = Aladdin.InitParams.Builder.access$1800(paramBuilder);
  }
  
  public static Aladdin.InitParams.Builder newBuilder()
  {
    return new Aladdin.InitParams.Builder(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.Aladdin.InitParams
 * JD-Core Version:    0.7.0.1
 */