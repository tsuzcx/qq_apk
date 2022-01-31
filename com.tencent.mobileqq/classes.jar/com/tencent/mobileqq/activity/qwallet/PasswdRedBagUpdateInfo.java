package com.tencent.mobileqq.activity.qwallet;

public class PasswdRedBagUpdateInfo
{
  public int a;
  public long a;
  public long b;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PasswdRedBagUpdateInfo))
    {
      paramObject = (PasswdRedBagUpdateInfo)paramObject;
      if ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramObject.jdField_a_of_type_Long == this.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagUpdateInfo
 * JD-Core Version:    0.7.0.1
 */