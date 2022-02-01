package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;

public class PlayingListPreloader$CurrentVid
{
  public int a;
  public final long a;
  public final String a;
  public boolean a;
  public String b = "";
  
  public PlayingListPreloader$CurrentVid(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public ErrorMessage a()
  {
    return new ErrorMessage(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader.CurrentVid
 * JD-Core Version:    0.7.0.1
 */