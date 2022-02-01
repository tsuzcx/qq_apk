package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;

abstract class ArkDataRequest
{
  protected int a;
  protected ArkDataRequest.IDataRequestCallback a;
  protected String a;
  protected int b;
  protected String b;
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArkDataRequest.IDataRequestCallback paramIDataRequestCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest$IDataRequestCallback = paramIDataRequestCallback;
  }
  
  public boolean a(String paramString)
  {
    a();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = -1;
    return true;
  }
  
  public abstract boolean b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkDataRequest
 * JD-Core Version:    0.7.0.1
 */