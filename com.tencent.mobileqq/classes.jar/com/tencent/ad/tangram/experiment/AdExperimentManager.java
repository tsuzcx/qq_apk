package com.tencent.ad.tangram.experiment;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_experiment_settings.SettingsForJointExperiment;
import com.tencent.ad.tangram.protocol.gdt_experiment_settings.SettingsForJointExperiment.ExpItem;
import com.tencent.ad.tangram.protocol.gdt_experiment_settings.SettingsForJointExperiment.Range;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;

@Keep
public enum AdExperimentManager
{
  INSTANCE;
  
  private static final int PRECISION = 10000;
  private static final String TAG = AdExperimentManager.class.getSimpleName();
  private volatile AdExperimentManager.a cache = new AdExperimentManager.a(null);
  
  private AdExperimentManager() {}
  
  private static void cacheEachLayerParamsByHash(int paramInt, gdt_experiment_settings.SettingsForJointExperiment.ExpItem[] paramArrayOfExpItem, AdExperimentManager.a parama)
  {
    if (paramArrayOfExpItem != null)
    {
      if (paramArrayOfExpItem.length == 0) {
        return;
      }
      int k = paramArrayOfExpItem.length;
      int i = 0;
      while (i < k)
      {
        gdt_experiment_settings.SettingsForJointExperiment.ExpItem localExpItem = paramArrayOfExpItem[i];
        if (localExpItem.rangeList != null)
        {
          Object localObject = localExpItem.rangeList;
          int m = localObject.length;
          int j = 0;
          while (j < m)
          {
            localStringBuilder = localObject[j];
            if (localStringBuilder == null) {
              return;
            }
            if ((localStringBuilder.lower <= paramInt) && (paramInt <= localStringBuilder.upper))
            {
              paramArrayOfExpItem = TAG;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[cacheParams] hit the experiment. expId = ");
              ((StringBuilder)localObject).append(localExpItem.expId);
              AdLog.i(paramArrayOfExpItem, ((StringBuilder)localObject).toString());
              AdExperimentManager.a.access$600(parama, localExpItem.expId);
              AdExperimentManager.a.access$500(parama, localExpItem.expParamKey);
              return;
            }
            j += 1;
          }
          localObject = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[cacheParams] miss the experiment. expId = ");
          localStringBuilder.append(localExpItem.expId);
          AdLog.i((String)localObject, localStringBuilder.toString());
        }
        i += 1;
      }
    }
  }
  
  private boolean cacheEacheLayerParamsByWhiteLists(String paramString, gdt_experiment_settings.SettingsForJointExperiment.ExpItem[] paramArrayOfExpItem, AdExperimentManager.a parama)
  {
    if (paramArrayOfExpItem != null)
    {
      if (paramArrayOfExpItem.length == 0) {
        return false;
      }
      int k = paramArrayOfExpItem.length;
      int i = 0;
      while (i < k)
      {
        gdt_experiment_settings.SettingsForJointExperiment.ExpItem localExpItem = paramArrayOfExpItem[i];
        if (localExpItem.whiteList != null)
        {
          String[] arrayOfString = localExpItem.whiteList;
          int m = arrayOfString.length;
          int j = 0;
          while (j < m)
          {
            String str = arrayOfString[j];
            if ((!TextUtils.isEmpty(str)) && (str.equals(paramString)))
            {
              paramString = TAG;
              paramArrayOfExpItem = new StringBuilder();
              paramArrayOfExpItem.append("[checkWhiteListAndCacheParams] hit the whitelist. expId = ");
              paramArrayOfExpItem.append(localExpItem.expId);
              AdLog.i(paramString, paramArrayOfExpItem.toString());
              AdExperimentManager.a.access$500(parama, localExpItem.expParamKey);
              AdExperimentManager.a.access$600(parama, localExpItem.expId);
              return true;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static int murmurHash32(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramInt1 / 4;
    int j = 0;
    int i = paramInt1;
    while (j < k)
    {
      int m = j * 4;
      m = ((paramArrayOfByte[m] & 0xFF) + ((paramArrayOfByte[(m + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(m + 2)] & 0xFF) << 16) + ((paramArrayOfByte[(m + 3)] & 0xFF) << 24)) * 1540483477;
      i = i * 1540483477 ^ (m >> 24 ^ m) * 1540483477;
      j += 1;
    }
    k = paramInt1 % 4;
    j = i;
    if (k == 3) {
      j = i ^ (paramArrayOfByte[((paramInt1 & 0xFFFFFFFC) + 2)] & 0xFF) << 16;
    }
    if (k != 3)
    {
      i = j;
      if (k != 2) {}
    }
    else
    {
      i = j ^ (paramArrayOfByte[((paramInt1 & 0xFFFFFFFC) + 1)] & 0xFF) << 8;
    }
    j = i;
    if (k != 0) {
      j = (paramArrayOfByte[(paramInt1 & 0xFFFFFFFC)] & 0xFF ^ i) * 1540483477;
    }
    paramInt1 = (j >> 13 ^ j) * 1540483477;
    return (paramInt1 ^ paramInt1 >> 15) % paramInt2;
  }
  
  public String[] getAllExpIdsByCache(String paramString, gdt_settings.Settings paramSettings)
  {
    if (!AdExperimentManager.a.access$100(this.cache, paramString)) {
      updateCache(paramString, paramSettings);
    }
    return AdExperimentManager.a.access$300(this.cache);
  }
  
  public boolean isHitExperiment(String paramString1, String paramString2, gdt_settings.Settings paramSettings)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    if (!AdExperimentManager.a.access$100(this.cache, paramString1)) {
      updateCache(paramString1, paramSettings);
    }
    paramString1 = AdExperimentManager.a.access$200(this.cache);
    if (paramString1.length == 0) {
      return false;
    }
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      if (paramString2.equals(paramString1[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void updateCache(String paramString, gdt_settings.Settings paramSettings)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AdLog.e(TAG, "[updateCache] error, parameters should not be empty");
      return;
    }
    if (paramSettings == null)
    {
      AdLog.e(TAG, "[getExpId] error, settings are null");
      return;
    }
    AdExperimentManager.a locala = new AdExperimentManager.a(null);
    if (paramSettings.settingsForJointExperiment == null) {
      return;
    }
    paramSettings = paramSettings.settingsForJointExperiment;
    int j = paramSettings.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramSettings[i];
      if ((!TextUtils.isEmpty(localObject1.layerName)) && (!cacheEacheLayerParamsByWhiteLists(paramString, localObject1.itemList, locala)))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(localObject1.layerName);
        localObject2 = ((StringBuilder)localObject2).toString().getBytes();
        cacheEachLayerParamsByHash(murmurHash32((byte[])localObject2, localObject2.length, 10000), localObject1.itemList, locala);
      }
      i += 1;
    }
    AdExperimentManager.a.access$400(locala, paramString);
    this.cache = locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.experiment.AdExperimentManager
 * JD-Core Version:    0.7.0.1
 */