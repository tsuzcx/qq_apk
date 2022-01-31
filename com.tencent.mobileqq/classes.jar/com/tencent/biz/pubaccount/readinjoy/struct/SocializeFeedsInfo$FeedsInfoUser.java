package com.tencent.biz.pubaccount.readinjoy.struct;

public class SocializeFeedsInfo$FeedsInfoUser
  implements Cloneable
{
  public int a;
  public long a;
  
  public SocializeFeedsInfo$FeedsInfoUser(SocializeFeedsInfo paramSocializeFeedsInfo) {}
  
  public FeedsInfoUser a()
  {
    try
    {
      FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)super.clone();
      return localFeedsInfoUser;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String toString()
  {
    return "uin=" + this.jdField_a_of_type_Long + "type=" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser
 * JD-Core Version:    0.7.0.1
 */