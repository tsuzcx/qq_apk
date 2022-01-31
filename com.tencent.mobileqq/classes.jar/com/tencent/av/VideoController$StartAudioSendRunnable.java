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
    if (this.jdField_a_of_type_Int > 0) {}
    for (int i = 1;; i = 2)
    {
      VideoController.a().a(this.jdField_a_of_type_Long, "StartAudioSendRunnable", this.jdField_a_of_type_Boolean, this.b, i);
      return;
    }
  }
  
  public String toString()
  {
    return "seq[" + this.jdField_a_of_type_Long + "], mFrom[" + this.jdField_a_of_type_JavaLangString + "], mEnable[" + this.jdField_a_of_type_Boolean + "], mNotifySvr[" + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.StartAudioSendRunnable
 * JD-Core Version:    0.7.0.1
 */