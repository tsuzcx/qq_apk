package com.tencent.av.business.handler;

public class SentenceInfo
{
  public int a;
  public CharSequence a;
  public String a;
  public boolean a;
  public CharSequence b;
  
  public SentenceInfo(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence1;
    this.b = paramCharSequence2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SentenceInfo{uin='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", src_text='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tra_text='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.SentenceInfo
 * JD-Core Version:    0.7.0.1
 */