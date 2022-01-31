package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import bjiq;
import bjlc;
import com.tencent.qphone.base.util.QLog;

class FollowCaptureLauncher$ConvertAllIFrameRunnable
  implements Runnable
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public FollowCaptureLauncher$ConvertAllIFrameRunnable(String paramString1, String paramString2, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void run()
  {
    try
    {
      bjiq.a();
      long l1 = System.currentTimeMillis();
      int i = bjlc.a(this.jdField_a_of_type_JavaLangString, this.b);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, new Object[] { "ffmpegToAllIFrame cost: ", Long.valueOf(l2 - l1), ", ret:", Integer.valueOf(i) });
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(65539);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(65540);
      } while (!QLog.isColorLevel());
      QLog.e("FollowCaptureLauncher", 2, "convert to all ifrane video error", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(65540);
      } while (!QLog.isColorLevel());
      QLog.e("FollowCaptureLauncher", 2, "convert to all ifrane video error", localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher.ConvertAllIFrameRunnable
 * JD-Core Version:    0.7.0.1
 */