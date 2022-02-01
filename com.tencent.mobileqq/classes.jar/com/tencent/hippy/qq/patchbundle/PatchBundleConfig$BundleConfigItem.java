package com.tencent.hippy.qq.patchbundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatchBundleConfig$BundleConfigItem
  implements Serializable
{
  public String mName;
  public final List<String> mPreLoadList = new ArrayList();
  public final List<String> mPrefetchList = new ArrayList();
  public final List<PatchBundleConfig.SSOListConfig> mSSOList = new ArrayList();
  public String mVersion;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BundleConfigItem{mName='");
    localStringBuilder.append(this.mName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVersion='");
    localStringBuilder.append(this.mVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSSOList=");
    localStringBuilder.append(this.mSSOList);
    localStringBuilder.append(", mPreLoadList=");
    localStringBuilder.append(this.mPreLoadList);
    localStringBuilder.append(", mPrefetchList=");
    localStringBuilder.append(this.mPrefetchList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleConfig.BundleConfigItem
 * JD-Core Version:    0.7.0.1
 */