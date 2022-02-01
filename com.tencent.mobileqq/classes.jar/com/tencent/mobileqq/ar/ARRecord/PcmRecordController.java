package com.tencent.mobileqq.ar.ARRecord;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PcmRecordController
  extends AudioRecordController
{
  private long jdField_a_of_type_Long;
  private AudioGenerator jdField_a_of_type_ComTencentMobileqqArARRecordAudioGenerator;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public PcmRecordController(VideoRecordController paramVideoRecordController, String paramString)
  {
    super(paramVideoRecordController);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    while (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioGenerator != null) && (this.jdField_a_of_type_Long > 0L) && (!this.b)) {
        try
        {
          long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
          byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioGenerator.a(l);
          VideoRecordController localVideoRecordController = (VideoRecordController)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localVideoRecordController != null) {
            localVideoRecordController.a(arrayOfByte, SystemClock.elapsedRealtimeNanos());
          }
          if (QLog.isColorLevel()) {
            QLog.d("PcmRecordController", 2, String.format("record audio duration: %s, buffer length: %s", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) }));
          }
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          sleep(200L);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.e("PcmRecordController", 1, "AudioRecordController read fail.", localException);
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioGenerator == null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioGenerator = new AudioGenerator(this.jdField_a_of_type_JavaLangString, 48000, 1, 16);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.b = false;
        start();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PcmRecordController", 2, String.format("startAudioRecord, mIsRecording: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      AudioGenerator localAudioGenerator = this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioGenerator;
      if (localAudioGenerator != null)
      {
        localAudioGenerator.a();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioGenerator = null;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = 0L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PcmRecordController", 2, String.format("stopAudioRecord, isRecording: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.PcmRecordController
 * JD-Core Version:    0.7.0.1
 */