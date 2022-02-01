package com.tencent.hippy.qq.patchbundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatchBundleConfig$SubBundleConfig
  implements Serializable
{
  public String mBusinessName;
  public final HashMap<String, PatchBundleConfig.BundleConfigItem> mSubConfigs = new HashMap();
  public final List<String> mSupportVersions = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubBundleConfig{mBusinessName='");
    localStringBuilder.append(this.mBusinessName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSubConfigs=");
    localStringBuilder.append(this.mSubConfigs);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleConfig.SubBundleConfig
 * JD-Core Version:    0.7.0.1
 */