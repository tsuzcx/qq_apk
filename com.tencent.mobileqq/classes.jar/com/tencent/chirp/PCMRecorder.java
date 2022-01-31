package com.tencent.chirp;

import android.content.Context;
import xfl;

public class PCMRecorder
{
  private int jdField_a_of_type_Int = 44100;
  private Context jdField_a_of_type_AndroidContentContext;
  private volatile PCMRecorder.RecordThread jdField_a_of_type_ComTencentChirpPCMRecorder$RecordThread;
  private xfl jdField_a_of_type_Xfl;
  private int b;
  
  public PCMRecorder(Context paramContext, int paramInt, xfl paramxfl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.b = (paramInt / 50 * 2 * 2);
    this.jdField_a_of_type_Xfl = paramxfl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentChirpPCMRecorder$RecordThread != null)
    {
      this.jdField_a_of_type_ComTencentChirpPCMRecorder$RecordThread.a = false;
      this.jdField_a_of_type_ComTencentChirpPCMRecorder$RecordThread = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentChirpPCMRecorder$RecordThread == null)
    {
      this.jdField_a_of_type_ComTencentChirpPCMRecorder$RecordThread = new PCMRecorder.RecordThread(this);
      this.jdField_a_of_type_ComTencentChirpPCMRecorder$RecordThread.start();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.chirp.PCMRecorder
 * JD-Core Version:    0.7.0.1
 */