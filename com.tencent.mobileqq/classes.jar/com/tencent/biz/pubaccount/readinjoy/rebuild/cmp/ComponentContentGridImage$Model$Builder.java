package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public final class ComponentContentGridImage$Model$Builder
{
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public Builder a(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(@NonNull List paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public ComponentContentGridImage.Model a()
  {
    return new ComponentContentGridImage.Model(this, null);
  }
  
  public Builder b(@NonNull String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder b(@NonNull List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.Model.Builder
 * JD-Core Version:    0.7.0.1
 */