package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class PromotionConfigInfo$PromotionItem
{
  long jdField_a_of_type_Long;
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  public String a;
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final TreeMap<Integer, PromotionConfigInfo.ZipItem> jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  public boolean a;
  long b;
  public String b;
  public long c = 0L;
  
  public PromotionConfigInfo$PromotionItem()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ArCloudConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public TreeMap<Integer, PromotionConfigInfo.ZipItem> a()
  {
    return this.jdField_a_of_type_JavaUtilTreeMap;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("id[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("], recoglizeMask[");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject2 = this.jdField_a_of_type_JavaUtilTreeMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PromotionConfigInfo.ZipItem localZipItem = (PromotionConfigInfo.ZipItem)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\n");
        localStringBuilder.append(localZipItem);
        localObject1 = localStringBuilder.toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", begin[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append("], end[");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject2).append("], title[");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("], tips[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilHashMap.size());
      ((StringBuilder)localObject2).append("]");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem
 * JD-Core Version:    0.7.0.1
 */