package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.qphone.base.util.QLog;

class LoadDataJob$UnmarshallJob
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  private LoadDataJob.UnmarshallJobListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public LoadDataJob$UnmarshallJob(LoadDataJob paramLoadDataJob, int paramInt, byte[] paramArrayOfByte, LoadDataJob.UnmarshallJobListener paramUnmarshallJobListener)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener = paramUnmarshallJobListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener.a(this.jdField_a_of_type_Int, null);
      return;
    }
    try
    {
      Object localObject = this.this$0.a(this.jdField_a_of_type_ArrayOfByte);
      if (localObject != null)
      {
        localObject = (PathDrawer)PathDrawer.a.a((MyParcel)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener.a(this.jdField_a_of_type_Int, (PathDrawer)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnmarshallJob", 2, "unmarshall  exception:" + this.this$0.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener.a(this.jdField_a_of_type_Int, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.UnmarshallJob
 * JD-Core Version:    0.7.0.1
 */