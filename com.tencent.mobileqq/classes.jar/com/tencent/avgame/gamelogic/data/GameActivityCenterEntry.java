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
    return !TextUtils.isEmpty(this.b);
  }
  
  public boolean b()
  {
    return (a()) && (this.jdField_a_of_type_Int == 1);
  }
  
  public String toString()
  {
    return "{redPoint: " + this.jdField_a_of_type_Int + ", iconUrl: " + this.jdField_a_of_type_JavaLangString + ", jumpUrl: " + this.b + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameActivityCenterEntry
 * JD-Core Version:    0.7.0.1
 */