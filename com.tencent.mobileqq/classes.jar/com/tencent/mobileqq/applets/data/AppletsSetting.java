package com.tencent.mobileqq.applets.data;

import java.util.ArrayList;
import java.util.List;

public class AppletsSetting
{
  public String a;
  public List<AppletItem> a;
  
  public AppletsSetting()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppletsSetting:[");
    localStringBuilder.append("des = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletsSetting
 * JD-Core Version:    0.7.0.1
 */