package com.tencent.mobileqq.apollo.view;

import ajru;

class FrameGifView$DecoderRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private ajru jdField_a_of_type_Ajru;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public void a(ajru paramajru, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Ajru = paramajru;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajru != null) {
      this.jdField_a_of_type_Ajru.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.FrameGifView.DecoderRunnable
 * JD-Core Version:    0.7.0.1
 */