package com.tencent.avgame.gamelogic.data;

import android.text.TextUtils;

public class GameActivityCenterEntry
{
  public int a;
  public String a;
  public String b = null;
  
  public GameActivityCenterEntry()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.b) ^ true;
  }
  
  public boolean b()
  {
    return (a()) && (this.jdField_a_of_type_Int == 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{redPoint: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", iconUrl: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", jumpUrl: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameActivityCenterEntry
 * JD-Core Version:    0.7.0.1
 */