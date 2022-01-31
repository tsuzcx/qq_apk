package com.tencent.chirp;

import android.content.Context;
import pjh;

public class PCMRecorder
{
  private int jdField_a_of_type_Int = 44100;
  private Context jdField_a_of_type_AndroidContentContext;
  private PCMRecorder.OnQQRecorderListener jdField_a_of_type_ComTencentChirpPCMRecorder$OnQQRecorderListener;
  private volatile pjh jdField_a_of_type_Pjh;
  private int b;
  
  public PCMRecorder(Context paramContext, int paramInt, PCMRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.b = (paramInt / 50 * 2 * 2);
    this.jdField_a_of_type_ComTencentChirpPCMRecorder$OnQQRecorderListener = paramOnQQRecorderListener;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Pjh != null)
    {
      this.jdField_a_of_type_Pjh.a = false;
      this.jdField_a_of_type_Pjh = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Pjh == null)
    {
      this.jdField_a_of_type_Pjh = new pjh(this);
      this.jdField_a_of_type_Pjh.start();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.chirp.PCMRecorder
 * JD-Core Version:    0.7.0.1
 */