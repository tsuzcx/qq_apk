package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import UserGrowth.stGrayPolicyInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.util.LogUtil;

public class WSExpPolicyEntities
{
  private String a;
  private String b;
  private String c;
  private stGetAllABTestPolicyRsp d;
  
  public WSExpPolicyEntities(String paramString, stGetAllABTestPolicyRsp paramstGetAllABTestPolicyRsp)
  {
    this.a = paramString;
    this.d = paramstGetAllABTestPolicyRsp;
    this.b = a(this.d.policyInfo);
    this.c = a(this.d);
  }
  
  private String a(stGetAllABTestPolicyRsp paramstGetAllABTestPolicyRsp)
  {
    if (paramstGetAllABTestPolicyRsp == null) {
      return "";
    }
    return Base64.encodeToString(WSFileUtils.a(paramstGetAllABTestPolicyRsp), 0);
  }
  
  private String a(Map<String, stGrayPolicyInfo> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      HashSet localHashSet = new HashSet();
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        String str = ((stGrayPolicyInfo)((Map.Entry)paramMap.next()).getValue()).grayPolicyId;
        if ((!TextUtils.isEmpty(str)) && (!localHashSet.contains(str)))
        {
          localHashSet.add(str);
          localStringBuilder.append(str);
          localStringBuilder.append("_");
        }
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public stGrayPolicyInfo a(String paramString)
  {
    if ((this.d.policyInfo != null) && (!this.d.policyInfo.isEmpty())) {
      return (stGrayPolicyInfo)this.d.policyInfo.get(paramString);
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public stGetAllABTestPolicyRsp c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (WSExpPolicyEntities)paramObject;
      if (!TextUtils.equals(paramObject.a(), a())) {
        return false;
      }
      Object localObject = paramObject.d;
      paramObject = this.d;
      if ((localObject != null) && (paramObject != null))
      {
        localObject = ((stGetAllABTestPolicyRsp)localObject).policyInfo;
        paramObject = paramObject.policyInfo;
        if (localObject == null) {
          return paramObject == null;
        }
        return ((Map)localObject).equals(paramObject);
      }
      return localObject == paramObject;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSExpPolicyEntities{\nmUin='");
    localStringBuilder.append(LogUtil.getSafePrintUin(this.a));
    localStringBuilder.append('\'');
    localStringBuilder.append("\nmTestIds='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append("\nserverTime='");
    localStringBuilder.append(this.d.serverTime);
    localStringBuilder.append('\'');
    localStringBuilder.append("\nmPolicyInfoMap=");
    String str;
    if (this.d.policyInfo != null) {
      str = this.d.policyInfo.toString();
    } else {
      str = "null";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyEntities
 * JD-Core Version:    0.7.0.1
 */