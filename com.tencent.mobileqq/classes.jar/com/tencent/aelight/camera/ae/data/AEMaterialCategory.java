package com.tencent.aelight.camera.ae.data;

import java.util.ArrayList;
import java.util.List;

public class AEMaterialCategory
  implements Cloneable
{
  public int a;
  public String a;
  public List<AEMaterialMetaData> a;
  public boolean a;
  public int b;
  public String b;
  
  public AEMaterialCategory()
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public AEMaterialCategory(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public AEMaterialCategory a()
  {
    AEMaterialCategory localAEMaterialCategory = new AEMaterialCategory();
    localAEMaterialCategory.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localAEMaterialCategory.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localAEMaterialCategory.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAEMaterialCategory.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localAEMaterialCategory.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList();
    localAEMaterialCategory.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localAEMaterialCategory;
  }
  
  public int hashCode()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.hashCode();
    }
    return 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialCategory
 * JD-Core Version:    0.7.0.1
 */