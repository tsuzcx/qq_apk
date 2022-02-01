package com.tencent.av.gaudio;

public class VideoViewInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  
  public VideoViewInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 4L;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof VideoViewInfo)))
    {
      paramObject = (VideoViewInfo)paramObject;
      if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "Uin[" + this.jdField_a_of_type_Long + "], VideoSrcType[" + this.jdField_a_of_type_Int + "], isBig[" + this.jdField_a_of_type_Boolean + "], isRender[" + this.jdField_b_of_type_Boolean + "], isNeedRequest[" + this.c + "], hasRecvData[" + this.d + "], inviteId[" + this.jdField_a_of_type_JavaLangString + "], isMirror[" + this.g + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.VideoViewInfo
 * JD-Core Version:    0.7.0.1
 */