package com.tencent.biz.qqstory.takevideo.slideshow;

import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;

public class SlideProgressNotifier$RefreshProgressThread
  extends Thread
{
  int jdField_a_of_type_Int;
  RefreshUICallBack jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowRefreshUICallBack;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c;
  int d;
  
  public SlideProgressNotifier$RefreshProgressThread(int paramInt1, int paramInt2, int paramInt3, RefreshUICallBack paramRefreshUICallBack)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    paramInt2 -= paramInt3;
    if (paramInt2 > 0) {
      this.c = (paramInt1 / paramInt2);
    } else {
      this.c = 100;
    }
    this.d = paramInt3;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowRefreshUICallBack = paramRefreshUICallBack;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancel progress update thread, stack trace : ");
      localStringBuilder.append(ThrowablesUtils.a(new RuntimeException()));
      QLog.d("QQProgressNotifier", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void run()
  {
    while (!this.jdField_a_of_type_Boolean)
    {
      int i = this.d;
      int j = this.b;
      if (i < j)
      {
        RefreshUICallBack localRefreshUICallBack1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowRefreshUICallBack;
        if (localRefreshUICallBack1 != null)
        {
          localRefreshUICallBack1.a(i);
          this.d += 1;
          try
          {
            Thread.sleep(this.c);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      else
      {
        this.d = j;
        RefreshUICallBack localRefreshUICallBack2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowRefreshUICallBack;
        if (localRefreshUICallBack2 != null) {
          localRefreshUICallBack2.a(this.d);
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier.RefreshProgressThread
 * JD-Core Version:    0.7.0.1
 */