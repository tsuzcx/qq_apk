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
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return "";
    }
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
  
  public stGetAllABTestPolicyRsp a()
  {
    return this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp;
  }
  
  public stGrayPolicyInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo == null) || (this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo.isEmpty())) {
      return null;
    }
    return (stGrayPolicyInfo)this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo.get(paramString);
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
    if (this == paramObject) {}
    Object localObject;
    do
    {
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (WSExpPolicyEntities)paramObject;
        if (!TextUtils.equals(paramObject.a(), a())) {
          return false;
        }
        localObject = paramObject.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp;
        paramObject = this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp;
        if ((localObject != null) && (paramObject != null)) {
          break;
        }
      } while (localObject == paramObject);
      return false;
      localObject = ((stGetAllABTestPolicyRsp)localObject).policyInfo;
      paramObject = paramObject.policyInfo;
      if (localObject != null) {
        break;
      }
    } while (paramObject == null);
    return false;
    return ((Map)localObject).equals(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WSExpPolicyEntities{\nmUin='").append(this.jdField_a_of_type_JavaLangString).append('\'').append("\nmTestIds='").append(this.b).append('\'').append("\nserverTime='").append(this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.serverTime).append('\'').append("\nmPolicyInfoMap=");
    if (this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo != null) {}
    for (String str = this.jdField_a_of_type_UserGrowthStGetAllABTestPolicyRsp.policyInfo.toString();; str = "null") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyEntities
 * JD-Core Version:    0.7.0.1
 */