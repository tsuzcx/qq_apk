package com.tencent.biz.pubaccount.weishi_new.net;

import android.os.Bundle;

@Deprecated
public class WeishiResult
  implements IResult, Cloneable
{
  @NeedParcel
  public int a;
  @NeedParcel
  private final Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  @NeedParcel
  private Object jdField_a_of_type_JavaLangObject;
  @NeedParcel
  private String jdField_a_of_type_JavaLangString;
  @NeedParcel
  private int b;
  @NeedParcel
  private int c;
  
  public WeishiResult() {}
  
  public WeishiResult(WeishiResult paramWeishiResult)
  {
    this.jdField_a_of_type_Int = paramWeishiResult.jdField_a_of_type_Int;
    this.b = paramWeishiResult.b;
    this.c = paramWeishiResult.c;
    this.jdField_a_of_type_JavaLangString = paramWeishiResult.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangObject = paramWeishiResult.jdField_a_of_type_JavaLangObject;
  }
  
  public WeishiResult a()
  {
    return new WeishiResult(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiResult
 * JD-Core Version:    0.7.0.1
 */