package com.tencent.mobileqq.activity.qwallet;

import android.text.TextUtils;

public class PasswdRedBagInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  
  public PasswdRedBagInfo() {}
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PasswdRedBagInfo))
    {
      paramObject = (PasswdRedBagInfo)paramObject;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label24;
      }
    }
    label24:
    while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo
 * JD-Core Version:    0.7.0.1
 */