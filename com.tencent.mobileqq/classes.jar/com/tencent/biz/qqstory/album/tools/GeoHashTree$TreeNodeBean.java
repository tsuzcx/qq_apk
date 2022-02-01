package com.tencent.biz.qqstory.album.tools;

public class GeoHashTree$TreeNodeBean
{
  public int a;
  public String a;
  private int b;
  
  public GeoHashTree$TreeNodeBean()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mStr: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("mLevel: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append("mPicCount: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashTree.TreeNodeBean
 * JD-Core Version:    0.7.0.1
 */