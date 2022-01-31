package com.tencent.mobileqq.ar.config;

import com.tencent.qphone.base.util.QLog;

public class WorldCupStaticInstance
{
  public static WorldCupStaticInstance a;
  long jdField_a_of_type_Long = -1L;
  public boolean a;
  long[] jdField_a_of_type_ArrayOfLong = { -1L, -1L, -1L };
  long jdField_b_of_type_Long = -1L;
  boolean jdField_b_of_type_Boolean = false;
  public boolean c;
  
  public WorldCupStaticInstance()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static final WorldCupStaticInstance a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupStaticInstance == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupStaticInstance == null) {
        jdField_a_of_type_ComTencentMobileqqArConfigWorldCupStaticInstance = new WorldCupStaticInstance();
      }
      return jdField_a_of_type_ComTencentMobileqqArConfigWorldCupStaticInstance;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WorldCupMgr", 1, "清除静态量");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLong.length)
    {
      this.jdField_a_of_type_ArrayOfLong[i] = -1L;
      i += 1;
    }
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupStaticInstance
 * JD-Core Version:    0.7.0.1
 */