package com.tencent.biz.qqstory.takevideo.doodle.layer.model;

public class TextInfo
{
  public int a;
  public String a;
  public int b;
  public int c;
  public int d;
  
  public void a(TextInfo paramTextInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramTextInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramTextInfo.jdField_a_of_type_Int;
    this.b = paramTextInfo.b;
    this.c = paramTextInfo.c;
    this.d = paramTextInfo.d;
  }
  
  public String toString()
  {
    return "TextInfo{text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", textColor=" + this.jdField_a_of_type_Int + ", size=" + this.b + ", state=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo
 * JD-Core Version:    0.7.0.1
 */