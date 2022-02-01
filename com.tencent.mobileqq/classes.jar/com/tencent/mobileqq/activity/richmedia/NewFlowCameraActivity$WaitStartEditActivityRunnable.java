package com.tencent.mobileqq.activity.richmedia;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import anvx;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import ykq;
import ykv;

class NewFlowCameraActivity$WaitStartEditActivityRunnable
  implements Runnable
{
  public final int a;
  public final long a;
  public final File[] a;
  public long b;
  
  private NewFlowCameraActivity$WaitStartEditActivityRunnable(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    paramString = new File(paramString);
    if (paramString.isDirectory()) {}
    for (this.jdField_a_of_type_ArrayOfJavaIoFile = paramString.listFiles();; this.jdField_a_of_type_ArrayOfJavaIoFile = null)
    {
      this.b = a();
      this.jdField_a_of_type_Int = paramInt;
      paramNewFlowCameraActivity.c(anvx.a(2131706942));
      return;
    }
  }
  
  private long a()
  {
    long l1 = 0L;
    long l2 = l1;
    if (this.jdField_a_of_type_ArrayOfJavaIoFile != null)
    {
      File[] arrayOfFile = this.jdField_a_of_type_ArrayOfJavaIoFile;
      int j = arrayOfFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l2 = FileUtils.getFileSizes(arrayOfFile[i].getAbsolutePath());
        i += 1;
        l1 = l2 + l1;
      }
    }
    return l2;
  }
  
  public void run()
  {
    long l = a();
    ykq.a("PTV.NewFlowCameraActivity", "recordTime = %d, currentLength = %d, old length = %d", Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(l), Long.valueOf(this.b));
    if (l == this.b)
    {
      ykv.b("video_shoot", "wait_start_edit", 0, 0, new String[] { Build.MODEL.toLowerCase(), String.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int) });
      this.this$0.M();
      NewFlowCameraActivity.a(this.this$0, this.jdField_a_of_type_Int);
      return;
    }
    this.b = l;
    this.this$0.a.postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.WaitStartEditActivityRunnable
 * JD-Core Version:    0.7.0.1
 */