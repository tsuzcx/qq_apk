package com.tencent.chirp;

import android.content.Context;
import pcv;

public class PCMRecorder
{
  private int jdField_a_of_type_Int = 44100;
  private Context jdField_a_of_type_AndroidContentContext;
  private PCMRecorder.OnQQRecorderListener jdField_a_of_type_ComTencentChirpPCMRecorder$OnQQRecorderListener;
  private volatile pcv jdField_a_of_type_Pcv;
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
    if (this.jdField_a_of_type_Pcv != null)
    {
      this.jdField_a_of_type_Pcv.a = false;
      this.jdField_a_of_type_Pcv = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Pcv == null)
    {
      this.jdField_a_of_type_Pcv = new pcv(this);
      this.jdField_a_of_type_Pcv.start();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.chirp.PCMRecorder
 * JD-Core Version:    0.7.0.1
 */