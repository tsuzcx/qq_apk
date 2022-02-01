package com.tencent.av.gaudio;

class AVNotifyCenter$AvChatData
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
    paramAVNotifyCenter = new StringBuilder();
    paramAVNotifyCenter.append("AvChatData_");
    paramAVNotifyCenter.append(paramString);
    paramAVNotifyCenter.append("_");
    paramAVNotifyCenter.append(paramLong);
    this.jdField_a_of_type_JavaLangString = paramAVNotifyCenter.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mRelationId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], mRelationType[");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("], mUinType[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], mIsChating[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], mIsWaitting[");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.AvChatData
 * JD-Core Version:    0.7.0.1
 */