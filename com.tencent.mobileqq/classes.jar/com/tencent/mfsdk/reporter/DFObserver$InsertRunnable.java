package com.tencent.mfsdk.reporter;

import aaad;
import aaag;
import com.tencent.mfsdk.MagnifierSDK;

class DFObserver$InsertRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private aaad jdField_a_of_type_Aaad;
  private String jdField_a_of_type_JavaLangString;
  
  public DFObserver$InsertRunnable(long paramLong, String paramString, aaad paramaaad)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aaad = paramaaad;
  }
  
  public void run()
  {
    if (MagnifierSDK.a != null)
    {
      MagnifierSDK.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaad);
      this.jdField_a_of_type_Aaad.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.DFObserver.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */