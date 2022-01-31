package com.tencent.mobileqq.apollo.view;

import aljf;

class FrameGifView$DecoderRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private aljf jdField_a_of_type_Aljf;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public void a(aljf paramaljf, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Aljf = paramaljf;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Aljf != null) {
      this.jdField_a_of_type_Aljf.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.FrameGifView.DecoderRunnable
 * JD-Core Version:    0.7.0.1
 */