package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.Entity;

public class BaseQueueItem
{
  public int a;
  public ContentValues a;
  ProxyListener a;
  public Entity a;
  public String a;
  public String[] a;
  public int b;
  public String b;
  public String c;
  
  public BaseQueueItem(String paramString1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_AndroidContentContentValues = paramContentValues;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener = paramProxyListener;
  }
  
  public BaseQueueItem(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = paramEntity;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener = paramProxyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseQueueItem
 * JD-Core Version:    0.7.0.1
 */