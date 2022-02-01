package com.tencent.gamecenter.wadl.util;

public class WadlProxyServiceUtil
{
  private static WadlProxyServiceWrap a;
  public static String a = "WadlProxyServiceUtil";
  
  public static WadlProxyServiceWrap a()
  {
    if (jdField_a_of_type_ComTencentGamecenterWadlUtilWadlProxyServiceWrap == null) {
      synchronized (jdField_a_of_type_JavaLangString)
      {
        if (jdField_a_of_type_ComTencentGamecenterWadlUtilWadlProxyServiceWrap == null) {
          jdField_a_of_type_ComTencentGamecenterWadlUtilWadlProxyServiceWrap = new WadlProxyServiceWrap();
        }
      }
    }
    return jdField_a_of_type_ComTencentGamecenterWadlUtilWadlProxyServiceWrap;
  }
  
  public static void a()
  {
    WadlProxyServiceWrap localWadlProxyServiceWrap = jdField_a_of_type_ComTencentGamecenterWadlUtilWadlProxyServiceWrap;
    if (localWadlProxyServiceWrap != null)
    {
      localWadlProxyServiceWrap.c();
      jdField_a_of_type_ComTencentGamecenterWadlUtilWadlProxyServiceWrap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil
 * JD-Core Version:    0.7.0.1
 */