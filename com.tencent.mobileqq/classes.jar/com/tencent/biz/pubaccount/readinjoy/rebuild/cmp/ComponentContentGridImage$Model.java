package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.PicInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ComponentContentGridImage$Model
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<SquareCornerTextImageView.PicInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private ComponentContentGridImage$Model(ComponentContentGridImage.Model.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaUtilList = ComponentContentGridImage.Model.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangString = ComponentContentGridImage.Model.Builder.a(paramBuilder);
    this.jdField_b_of_type_JavaLangString = ComponentContentGridImage.Model.Builder.b(paramBuilder);
    this.jdField_b_of_type_JavaUtilList = ComponentContentGridImage.Model.Builder.b(paramBuilder);
    this.jdField_a_of_type_Int = ComponentContentGridImage.Model.Builder.a(paramBuilder);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<SquareCornerTextImageView.PicInfo> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<URL> b()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.Model
 * JD-Core Version:    0.7.0.1
 */