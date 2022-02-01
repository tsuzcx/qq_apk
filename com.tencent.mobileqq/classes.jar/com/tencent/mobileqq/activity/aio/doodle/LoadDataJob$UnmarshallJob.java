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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener;
    if (localObject == null) {
      return;
    }
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte == null)
    {
      ((LoadDataJob.UnmarshallJobListener)localObject).a(this.jdField_a_of_type_Int, null);
      return;
    }
    try
    {
      localObject = this.this$0.a(arrayOfByte);
      if (localObject == null) {
        break label115;
      }
      localObject = (PathDrawer)PathDrawer.a.a((MyParcel)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener.a(this.jdField_a_of_type_Int, (PathDrawer)localObject);
      return;
    }
    catch (Exception localException)
    {
      label72:
      break label72;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unmarshall  exception:");
      ((StringBuilder)localObject).append(this.this$0.a);
      QLog.d("UnmarshallJob", 2, ((StringBuilder)localObject).toString());
    }
    label115:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob$UnmarshallJobListener.a(this.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.UnmarshallJob
 * JD-Core Version:    0.7.0.1
 */