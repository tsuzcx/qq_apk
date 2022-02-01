package com.tencent.ad.tangram.experiment;

import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.util.ArrayList;
import java.util.Arrays;

final class AdExperimentManager$a
{
  private volatile String currentCachedUin = "";
  private volatile ArrayList<String> expIdsInCache = new ArrayList();
  private volatile ArrayList<String> paramKeysInCache = new ArrayList();
  
  private String[] getAllExpIds()
  {
    return (String[])this.expIdsInCache.toArray(new String[0]);
  }
  
  private String[] getAllParams()
  {
    return (String[])this.paramKeysInCache.toArray(new String[0]);
  }
  
  private boolean isValid(String paramString)
  {
    return (!TextUtils.isEmpty(this.currentCachedUin)) && (this.currentCachedUin.equals(paramString));
  }
  
  private void putExpId(String paramString)
  {
    this.expIdsInCache.add(paramString);
  }
  
  private void putParamKeys(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      this.paramKeysInCache.addAll(Arrays.asList(paramArrayOfString));
    }
  }
  
  private void setCachedUin(String paramString)
  {
    String str = AdExperimentManager.access$700();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Cache::setCachedUin] update pre uin");
    localStringBuilder.append(paramString);
    AdLog.i(str, localStringBuilder.toString());
    this.currentCachedUin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.experiment.AdExperimentManager.a
 * JD-Core Version:    0.7.0.1
 */