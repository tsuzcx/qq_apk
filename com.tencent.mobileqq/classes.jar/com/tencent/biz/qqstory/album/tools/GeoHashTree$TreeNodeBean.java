package com.tencent.biz.qqstory.album.tools;

public class GeoHashTree$TreeNodeBean
{
  public int a = 0;
  public String b;
  private int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mStr: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("mLevel: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("mPicCount: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashTree.TreeNodeBean
 * JD-Core Version:    0.7.0.1
 */