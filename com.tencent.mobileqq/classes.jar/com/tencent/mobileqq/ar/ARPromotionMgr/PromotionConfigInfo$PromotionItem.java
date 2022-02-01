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
    String str = "id[" + this.jdField_a_of_type_JavaLangString + "], recoglizeMask[" + this.c + "]";
    Object localObject = str;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaUtilTreeMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        PromotionConfigInfo.ZipItem localZipItem = (PromotionConfigInfo.ZipItem)((Iterator)localObject).next();
        str = str + "\n" + localZipItem;
      }
      localObject = str + ", begin[" + this.jdField_a_of_type_Long + "], end[" + this.jdField_b_of_type_Long + "], title[" + this.jdField_b_of_type_JavaLangString + "], tips[" + this.jdField_a_of_type_JavaUtilHashMap.size() + "]";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem
 * JD-Core Version:    0.7.0.1
 */