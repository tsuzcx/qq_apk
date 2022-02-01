package com.tencent.comic.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoodoHippyConfig
  implements Serializable
{
  public static final int HIPPY_STATUS_CLOSE = 0;
  public static final int HIPPY_STATUS_OPEN = 1;
  public final List<String> mAllModules = new ArrayList();
  public int mHippyStatus = 1;
  public String mMainModuleName;
  public final List<String> mPreloadModules = new ArrayList();
  public String mPsKeyHost;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BoodoHippyConfig{mHippyStatus=");
    localStringBuilder.append(this.mHippyStatus);
    localStringBuilder.append(", mMainModuleName='");
    localStringBuilder.append(this.mMainModuleName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPreloadModules=");
    localStringBuilder.append(this.mPreloadModules);
    localStringBuilder.append(", mAllModules=");
    localStringBuilder.append(this.mAllModules);
    localStringBuilder.append(", mPsKeyHost=");
    localStringBuilder.append(this.mPsKeyHost);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.data.BoodoHippyConfig
 * JD-Core Version:    0.7.0.1
 */