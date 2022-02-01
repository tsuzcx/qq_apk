package com.tencent.av.gaudio;

public class AVNotifyCenter$AvChatData
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = false;
  
  AVNotifyCenter$AvChatData(AVNotifyCenter paramAVNotifyCenter, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("AvChatData_" + paramString + "_" + paramLong);
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString + ", mRelationId[" + this.jdField_a_of_type_Long + "], mRelationType[" + this.jdField_c_of_type_Int + "], mUinType[" + this.jdField_b_of_type_Int + "], mPeerUin[" + this.jdField_b_of_type_JavaLangString + "], mIsChating[" + this.d + "], mIsWaitting[" + this.jdField_c_of_type_Boolean + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.AvChatData
 * JD-Core Version:    0.7.0.1
 */