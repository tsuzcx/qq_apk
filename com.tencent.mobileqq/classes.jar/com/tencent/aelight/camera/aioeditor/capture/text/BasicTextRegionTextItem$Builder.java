package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class BasicTextRegionTextItem$Builder
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  ArrayList<BaseTextRegion> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int = 0;
  float d = 0.0F;
  
  public BasicTextRegionTextItem$Builder()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public BasicTextRegionTextItem a(int paramInt, List<String> paramList)
  {
    BasicTextRegionTextItem localBasicTextRegionTextItem = new BasicTextRegionTextItem(paramInt, paramList);
    localBasicTextRegionTextItem.jdField_a_of_type_JavaUtilArrayList.clear();
    localBasicTextRegionTextItem.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    if (localTypeface != null) {
      localBasicTextRegionTextItem.a(localTypeface);
    }
    localBasicTextRegionTextItem.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      BasicTextRegionTextItem.a(localBasicTextRegionTextItem, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Int);
    }
    BasicTextRegionTextItem.a(localBasicTextRegionTextItem, this.jdField_b_of_type_Boolean, this.d, this.jdField_c_of_type_Int);
    if (!paramList.isEmpty()) {
      localBasicTextRegionTextItem.a(0, (String)paramList.get(0));
    }
    return localBasicTextRegionTextItem;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
  
  public void a(BaseTextRegion paramBaseTextRegion)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramBaseTextRegion);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BasicTextRegionTextItem.Builder
 * JD-Core Version:    0.7.0.1
 */