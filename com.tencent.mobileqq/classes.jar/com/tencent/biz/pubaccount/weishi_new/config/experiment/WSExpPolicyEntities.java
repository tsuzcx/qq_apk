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

public class WSExpPolicyEntities
{
  private stGetAllABTestPolicyRsp jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public WSExpPolicyEntities(String paramString, stGetAllABTestPolicyRsp paramstGetAllABTestPolicyRsp)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp = paramstGetAllABTestPolicyRsp;
    this.b = a(this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo);
    this.c = a(this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp);
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
  
  public stGetAllABTestPolicyRsp a()
  {
    return this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp;
  }
  
  public stGrayPolicyInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo != null) && (!this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo.isEmpty())) {
      return (stGrayPolicyInfo)this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo.get(paramString);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
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
      Object localObject = paramObject.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp;
      paramObject = this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp;
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
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append("\nmTestIds='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append("\nserverTime='");
    localStringBuilder.append(this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.serverTime);
    localStringBuilder.append('\'');
    localStringBuilder.append("\nmPolicyInfoMap=");
    String str;
    if (this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo != null) {
      str = this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo.toString();
    } else {
      str = "null";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyEntities
 * JD-Core Version:    0.7.0.1
 */