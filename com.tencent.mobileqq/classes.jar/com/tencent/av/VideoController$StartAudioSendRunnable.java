package com.tencent.av;

class VideoController$StartAudioSendRunnable
  implements Runnable
{
  int jdField_a_of_type_Int = 5;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  VideoController$StartAudioSendRunnable(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Int -= 1;
    int i;
    if (this.jdField_a_of_type_Int > 0) {
      i = 1;
    } else {
      i = 2;
    }
    VideoController.a(VideoController.a(), this.jdField_a_of_type_Long, "StartAudioSendRunnable", this.jdField_a_of_type_Boolean, this.b, i);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], mFrom[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], mEnable[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], mNotifySvr[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.StartAudioSendRunnable
 * JD-Core Version:    0.7.0.1
 */