package com.tencent.biz.qqstory.takevideo.artfilter;

public class FilterTemplate
  implements Comparable
{
  public int a;
  public String a;
  int b;
  public String b;
  public String c;
  
  public FilterTemplate()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public FilterTemplate(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  public int a(FilterTemplate paramFilterTemplate)
  {
    if (paramFilterTemplate == null) {}
    do
    {
      return -1;
      if (this.jdField_b_of_type_Int < paramFilterTemplate.jdField_b_of_type_Int) {
        return 1;
      }
    } while (this.jdField_b_of_type_Int != paramFilterTemplate.jdField_b_of_type_Int);
    return 0;
  }
  
  public String toString()
  {
    return "FilterTemplate{id='" + this.jdField_a_of_type_Int + '\'' + ", thumbPath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", priority=" + this.jdField_b_of_type_Int + ", name='" + this.jdField_b_of_type_JavaLangString + '\'' + ", pron='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.FilterTemplate
 * JD-Core Version:    0.7.0.1
 */