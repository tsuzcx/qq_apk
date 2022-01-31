package com.tencent.mfsdk.reporter;

import abvp;
import abvs;
import com.tencent.mfsdk.MagnifierSDK;

class DFObserver$InsertRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private abvp jdField_a_of_type_Abvp;
  private String jdField_a_of_type_JavaLangString;
  
  public DFObserver$InsertRunnable(long paramLong, String paramString, abvp paramabvp)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Abvp = paramabvp;
  }
  
  public void run()
  {
    if (MagnifierSDK.a != null)
    {
      MagnifierSDK.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Abvp);
      this.jdField_a_of_type_Abvp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.DFObserver.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */