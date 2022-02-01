package com.tencent.biz.pubaccount.weishi_new.drama.data;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;

public class WSDramaEpisodeParams
  extends FetcherParams
{
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  public WSDramaEpisodeParams(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3)
  {
    super(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean3;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaEpisodeParams
 * JD-Core Version:    0.7.0.1
 */