package com.tencent.mobileqq.app;

class QQGAudioMsgHandler$SubCmd0x8DMsg
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long;
  int jdField_e_of_type_Int;
  long jdField_e_of_type_Long;
  int jdField_f_of_type_Int;
  long jdField_f_of_type_Long;
  int jdField_g_of_type_Int;
  long jdField_g_of_type_Long;
  int h;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("{");
    localStringBuilder.append("wSubCmd: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", llAccount: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", cKeyLen: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", dwRoomNum: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", dwClientSeq: ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", llFromAccount: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", dwFlag: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", cRelationBufLen: ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", dwRelationId: ");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append(", wCount: ");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", dwSendTime: ");
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append(", wReverseLen: ");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", cOriginalType: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", dwMsgSeq: ");
    localStringBuilder.append(this.jdField_g_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.SubCmd0x8DMsg
 * JD-Core Version:    0.7.0.1
 */