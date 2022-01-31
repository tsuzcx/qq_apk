package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class RedPacketRainConfigManager
{
  private static RedPacketRainConfigManager jdField_a_of_type_ComTencentMobileqqArmapRedPacketRainConfigManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap a;
  public boolean a;
  
  private RedPacketRainConfigManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("北京市", "华北");
    this.jdField_a_of_type_JavaUtilHashMap.put("天津市", "华北");
    this.jdField_a_of_type_JavaUtilHashMap.put("河北省", "华北");
    this.jdField_a_of_type_JavaUtilHashMap.put("山西省", "华北");
    this.jdField_a_of_type_JavaUtilHashMap.put("内蒙古自治区", "华北");
    this.jdField_a_of_type_JavaUtilHashMap.put("辽宁省", "东北");
    this.jdField_a_of_type_JavaUtilHashMap.put("吉林省", "东北");
    this.jdField_a_of_type_JavaUtilHashMap.put("黑龙江省", "东北");
    this.jdField_a_of_type_JavaUtilHashMap.put("上海市", "华东");
    this.jdField_a_of_type_JavaUtilHashMap.put("江苏省", "华东");
    this.jdField_a_of_type_JavaUtilHashMap.put("浙江省", "华东");
    this.jdField_a_of_type_JavaUtilHashMap.put("安徽省", "华东");
    this.jdField_a_of_type_JavaUtilHashMap.put("福建省", "华东");
    this.jdField_a_of_type_JavaUtilHashMap.put("江西省", "华东");
    this.jdField_a_of_type_JavaUtilHashMap.put("山东省", "华东");
    this.jdField_a_of_type_JavaUtilHashMap.put("河南省", "中南");
    this.jdField_a_of_type_JavaUtilHashMap.put("湖北省", "中南");
    this.jdField_a_of_type_JavaUtilHashMap.put("湖南省", "中南");
    this.jdField_a_of_type_JavaUtilHashMap.put("广东省", "中南");
    this.jdField_a_of_type_JavaUtilHashMap.put("广西壮族自治区", "中南");
    this.jdField_a_of_type_JavaUtilHashMap.put("海南省", "中南");
    this.jdField_a_of_type_JavaUtilHashMap.put("重庆市", "西南");
    this.jdField_a_of_type_JavaUtilHashMap.put("四川省", "西南");
    this.jdField_a_of_type_JavaUtilHashMap.put("贵州省", "西南");
    this.jdField_a_of_type_JavaUtilHashMap.put("云南省", "西南");
    this.jdField_a_of_type_JavaUtilHashMap.put("西藏自治区", "西南");
    this.jdField_a_of_type_JavaUtilHashMap.put("陕西省", "西北");
    this.jdField_a_of_type_JavaUtilHashMap.put("甘肃省", "西北");
    this.jdField_a_of_type_JavaUtilHashMap.put("青海省", "西北");
    this.jdField_a_of_type_JavaUtilHashMap.put("宁夏回族自治区", "西北");
    this.jdField_a_of_type_JavaUtilHashMap.put("新疆维吾尔自治区", "西北");
    this.jdField_a_of_type_JavaUtilHashMap.put("台湾", "港澳台");
    this.jdField_a_of_type_JavaUtilHashMap.put("香港特别行政区", "港澳台");
    this.jdField_a_of_type_JavaUtilHashMap.put("澳门特别行政区", "港澳台");
  }
  
  public static RedPacketRainConfigManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArmapRedPacketRainConfigManager != null) {
      return jdField_a_of_type_ComTencentMobileqqArmapRedPacketRainConfigManager;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqArmapRedPacketRainConfigManager != null)
      {
        RedPacketRainConfigManager localRedPacketRainConfigManager1 = jdField_a_of_type_ComTencentMobileqqArmapRedPacketRainConfigManager;
        return localRedPacketRainConfigManager1;
      }
    }
    jdField_a_of_type_ComTencentMobileqqArmapRedPacketRainConfigManager = new RedPacketRainConfigManager();
    RedPacketRainConfigManager localRedPacketRainConfigManager2 = jdField_a_of_type_ComTencentMobileqqArmapRedPacketRainConfigManager;
    return localRedPacketRainConfigManager2;
  }
  
  public void a(QQAppInterface paramQQAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.RedPacketRainConfigManager
 * JD-Core Version:    0.7.0.1
 */