package com.tencent.mfsdk.reporter;

import com.tencent.mfsdk.MagnifierSDK;
import zqo;
import zqr;

class DFObserver$InsertRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private zqo jdField_a_of_type_Zqo;
  
  public DFObserver$InsertRunnable(long paramLong, String paramString, zqo paramzqo)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Zqo = paramzqo;
  }
  
  public void run()
  {
    if (MagnifierSDK.a != null)
    {
      MagnifierSDK.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zqo);
      this.jdField_a_of_type_Zqo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.DFObserver.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */