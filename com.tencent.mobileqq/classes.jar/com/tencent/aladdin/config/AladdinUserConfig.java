package com.tencent.aladdin.config;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import com.tencent.aladdin.config.network.AladdinConfigVersionManager;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.aladdin.config.utils.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AladdinUserConfig
{
  private static final String TAG = "AladdinUserConfig";
  @NonNull
  private final String basePath;
  @NonNull
  private final List<Integer> configIds = new ArrayList();
  @NonNull
  private final SparseArrayCompat<AladdinConfig> configs = new SparseArrayCompat();
  @NonNull
  private final AsyncTaskExecutor executor;
  @NonNull
  private final AladdinConfigVersionManager versionManager;
  
  AladdinUserConfig(String paramString1, String paramString2, @NonNull AsyncTaskExecutor paramAsyncTaskExecutor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    this.basePath = localStringBuilder.toString();
    this.executor = paramAsyncTaskExecutor;
    this.versionManager = new AladdinConfigVersionManager(this.basePath);
    initConfigIds();
  }
  
  private void initConfigIds()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new File(this.basePath);
        if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
        {
          localObject1 = ((File)localObject1).listFiles();
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            localObject2 = localObject1[i].getName();
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).contains(".xml"))) {
              break label238;
            }
            Object localObject3 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(".xml"));
            try
            {
              localObject3 = Integer.valueOf((String)localObject3);
              this.configIds.add(localObject3);
            }
            catch (NumberFormatException localNumberFormatException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[initConfigs] error, fileName = ");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append(", e = ");
              localStringBuilder.append(localNumberFormatException);
              Log.e("AladdinUserConfig", localStringBuilder.toString());
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[initConfigIds] dir does not exists, basePath = ");
          ((StringBuilder)localObject1).append(this.basePath);
          Log.i("AladdinUserConfig", ((StringBuilder)localObject1).toString());
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[initConfigIds] failed, e = ");
        ((StringBuilder)localObject2).append(localException);
        Log.e("AladdinUserConfig", ((StringBuilder)localObject2).toString());
      }
      printLocalConfigIdList("initConfigIds");
      return;
      label238:
      i += 1;
    }
  }
  
  private void printLocalConfigIdList(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    localStringBuilder.append(" local config id list: ");
    if (this.configIds.size() <= 0) {
      localStringBuilder.append("null");
    }
    paramString = this.configIds.iterator();
    while (paramString.hasNext())
    {
      localStringBuilder.append((Integer)paramString.next());
      localStringBuilder.append(" | ");
    }
    Log.i("AladdinUserConfig", localStringBuilder.toString());
  }
  
  @NonNull
  public AladdinConfig get(int paramInt)
  {
    try
    {
      AladdinConfig localAladdinConfig = (AladdinConfig)this.configs.get(paramInt);
      Object localObject1 = localAladdinConfig;
      if (localAladdinConfig == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.basePath);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(".xml");
        localObject1 = new AladdinConfig(((StringBuilder)localObject1).toString(), paramInt, this.executor, Aladdin.getParserById(paramInt));
        this.configs.put(paramInt, localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  @NonNull
  public String getBasePath()
  {
    return this.basePath;
  }
  
  public int[] getConfigIdList()
  {
    if (this.configIds.size() > 0)
    {
      int[] arrayOfInt2 = new int[this.configIds.size()];
      int i = 0;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (i >= this.configIds.size()) {
          break;
        }
        arrayOfInt2[i] = ((Integer)this.configIds.get(i)).intValue();
        i += 1;
      }
    }
    Log.i("AladdinUserConfig", "[getConfigIdList] configIds is null.");
    int[] arrayOfInt1 = new int[1];
    printLocalConfigIdList("getConfigIdList");
    return arrayOfInt1;
  }
  
  public AladdinConfigVersionManager getVersionInfo()
  {
    return this.versionManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.AladdinUserConfig
 * JD-Core Version:    0.7.0.1
 */