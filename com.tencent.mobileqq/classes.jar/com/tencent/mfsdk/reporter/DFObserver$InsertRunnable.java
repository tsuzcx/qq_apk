package com.tencent.mfsdk.reporter;

import aaah;
import aaak;
import com.tencent.mfsdk.MagnifierSDK;

class DFObserver$InsertRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private aaah jdField_a_of_type_Aaah;
  private String jdField_a_of_type_JavaLangString;
  
  public DFObserver$InsertRunnable(long paramLong, String paramString, aaah paramaaah)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aaah = paramaaah;
  }
  
  public void run()
  {
    if (MagnifierSDK.a != null)
    {
      MagnifierSDK.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaah);
      this.jdField_a_of_type_Aaah.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.DFObserver.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */