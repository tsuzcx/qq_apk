package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.qphone.base.util.QLog;

class LoadDataJob$UnmarshallJob
  implements Runnable
{
  private byte[] a;
  private LoadDataJob.UnmarshallJobListener b;
  private int c = -1;
  
  public LoadDataJob$UnmarshallJob(LoadDataJob paramLoadDataJob, int paramInt, byte[] paramArrayOfByte, LoadDataJob.UnmarshallJobListener paramUnmarshallJobListener)
  {
    this.a = paramArrayOfByte;
    this.b = paramUnmarshallJobListener;
    this.c = paramInt;
  }
  
  public void run()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    byte[] arrayOfByte = this.a;
    if (arrayOfByte == null)
    {
      ((LoadDataJob.UnmarshallJobListener)localObject).a(this.c, null);
      return;
    }
    try
    {
      localObject = this.this$0.a(arrayOfByte);
      if (localObject == null) {
        break label115;
      }
      localObject = (PathDrawer)PathDrawer.b.b((MyParcel)localObject);
      this.b.a(this.c, (PathDrawer)localObject);
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
    this.b.a(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.UnmarshallJob
 * JD-Core Version:    0.7.0.1
 */