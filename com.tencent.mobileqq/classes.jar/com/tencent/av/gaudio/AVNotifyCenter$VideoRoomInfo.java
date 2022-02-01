package com.tencent.av.gaudio;

import com.tencent.av.utils.AudioHelper;

public class AVNotifyCenter$VideoRoomInfo
{
  public int a;
  final long jdField_a_of_type_Long = AudioHelper.b();
  public int b;
  public long b;
  public int c;
  public long c;
  public int d;
  public int e;
  public int f;
  
  AVNotifyCenter$VideoRoomInfo(AVNotifyCenter paramAVNotifyCenter) {}
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int == 2) && (this.d == 2) && (this.e == 4) && (this.jdField_c_of_type_Int == 0);
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_Int == 2) && (this.d == 2) && (this.e == 5) && (this.jdField_c_of_type_Int == 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], roomMode[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], gameId[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], liveExtraMode[");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("], memberNum[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], event[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], time[");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo
 * JD-Core Version:    0.7.0.1
 */