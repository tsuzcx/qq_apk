package com.tencent.biz.pubaccount.readinjoy.struct;

public class SocializeFeedsInfo$BiuCommentInfo
  implements Cloneable
{
  public int a;
  public Long a;
  public String a;
  public int b;
  public Long b;
  public String b;
  public int c = 0;
  
  public SocializeFeedsInfo$BiuCommentInfo(SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public BiuCommentInfo a()
  {
    try
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)super.clone();
      return localBiuCommentInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String toString()
  {
    return "biuTime=" + this.jdField_a_of_type_Int + "uin=" + this.jdField_a_of_type_JavaLangLong + "feedId=" + this.jdField_b_of_type_JavaLangLong + "comment=" + this.jdField_a_of_type_JavaLangString + "feedsType=" + this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo
 * JD-Core Version:    0.7.0.1
 */