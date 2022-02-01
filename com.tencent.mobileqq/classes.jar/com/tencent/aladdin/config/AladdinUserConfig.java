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
    this.basePath = (paramString1 + File.separator + paramString2);
    this.executor = paramAsyncTaskExecutor;
    this.versionManager = new AladdinConfigVersionManager(this.basePath);
    initConfigIds();
  }
  
  private void initConfigIds()
  {
    try
    {
      Object localObject1 = new File(this.basePath);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String str = localObject1[i].getName();
            Object localObject2;
            if ((!TextUtils.isEmpty(str)) && (str.contains(".xml"))) {
              localObject2 = str.substring(0, str.lastIndexOf(".xml"));
            }
            try
            {
              localObject2 = Integer.valueOf((String)localObject2);
              this.configIds.add(localObject2);
              i += 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                Log.e("AladdinUserConfig", "[initConfigs] error, fileName = " + str + ", e = " + localNumberFormatException);
              }
            }
          }
        }
        printLocalConfigIdList("initConfigIds");
      }
    }
    catch (Exception localException)
    {
      Log.e("AladdinUserConfig", "[initConfigIds] failed, e = " + localException);
    }
    for (;;)
    {
      return;
      Log.i("AladdinUserConfig", "[initConfigIds] dir does not exists, basePath = " + this.basePath);
    }
  }
  
  private void printLocalConfigIdList(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(paramString).append("]").append(" local config id list: ");
    if (this.configIds.size() <= 0) {
      localStringBuilder.append("null");
    }
    paramString = this.configIds.iterator();
    while (paramString.hasNext()) {
      localStringBuilder.append((Integer)paramString.next()).append(" | ");
    }
    Log.i("AladdinUserConfig", localStringBuilder.toString());
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
  
  public int[] getConfigIdList()
  {
    int[] arrayOfInt;
    if (this.configIds.size() > 0)
    {
      arrayOfInt = new int[this.configIds.size()];
      int i = 0;
      while (i < this.configIds.size())
      {
        arrayOfInt[i] = ((Integer)this.configIds.get(i)).intValue();
        i += 1;
      }
    }
    for (;;)
    {
      printLocalConfigIdList("getConfigIdList");
      return arrayOfInt;
      Log.i("AladdinUserConfig", "[getConfigIdList] configIds is null.");
      arrayOfInt = new int[1];
    }
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