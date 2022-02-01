package com.tencent.mobileqq.activity.contact.connections;

import android.support.annotation.NonNull;

public class TabLayoutStatus
{
  public int a;
  public boolean a;
  public int b = 0;
  
  public TabLayoutStatus()
  {
    this.jdField_a_of_type_Int = 23;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 23;
    this.b = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 23;
    this.b = 0;
  }
  
  @NonNull
  public String toString()
  {
    return "TabLayoutStatus{tabId=" + this.jdField_a_of_type_Int + ", tabPosition=" + this.b + ", display='" + this.jdField_a_of_type_Boolean + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus
 * JD-Core Version:    0.7.0.1
 */