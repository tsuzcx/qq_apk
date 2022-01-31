package com.tencent.mobileqq.activity.aio.doodle;

import aewe;
import aewg;
import aewj;
import aewp;
import com.tencent.qphone.base.util.QLog;

class LoadDataJob$UnmarshallJob
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  private aewe jdField_a_of_type_Aewe;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public LoadDataJob$UnmarshallJob(LoadDataJob paramLoadDataJob, int paramInt, byte[] paramArrayOfByte, aewe paramaewe)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Aewe = paramaewe;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Aewe == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_a_of_type_Aewe.a(this.jdField_a_of_type_Int, null);
      return;
    }
    try
    {
      Object localObject = this.this$0.a(this.jdField_a_of_type_ArrayOfByte);
      if (localObject != null)
      {
        localObject = (aewp)aewp.a.a((aewg)localObject);
        this.jdField_a_of_type_Aewe.a(this.jdField_a_of_type_Int, (aewp)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnmarshallJob", 2, "unmarshall  exception:" + this.this$0.a);
      }
      this.jdField_a_of_type_Aewe.a(this.jdField_a_of_type_Int, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.UnmarshallJob
 * JD-Core Version:    0.7.0.1
 */