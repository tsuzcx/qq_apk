class anta
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
    localStringBuilder.append("wSubCmd: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", llAccount: ").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", cKeyLen: ").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", dwRoomNum: ").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", dwClientSeq: ").append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", llFromAccount: ").append(this.d);
    localStringBuilder.append(", dwFlag: ").append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", cRelationBufLen: ").append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", dwRelationId: ").append(this.jdField_e_of_type_Long);
    localStringBuilder.append(", wCount: ").append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", dwSendTime: ").append(this.jdField_f_of_type_Long);
    localStringBuilder.append(", wReverseLen: ").append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", cOriginalType: ").append(this.h);
    localStringBuilder.append(", dwMsgSeq: ").append(this.jdField_g_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anta
 * JD-Core Version:    0.7.0.1
 */