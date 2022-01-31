package com.tencent.av;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import kvq;
import lbk;

class VideoController$StartRingRunnable
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  
  VideoController$StartRingRunnable(VideoController paramVideoController, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.this$0.a().jdField_n_of_type_Int < 0)
    {
      lbk.a();
      long l = lbk.c();
      int i = lbk.f();
      int j = Build.VERSION.SDK_INT;
      if ((i < 4) || (l / 1000L < 800L) || (j < 9)) {
        this.this$0.a().jdField_n_of_type_Int = 0;
      }
    }
    if ((this.this$0.a() != null) && (this.this$0.a().d == 1L) && (!TextUtils.isEmpty(this.this$0.a().jdField_n_of_type_JavaLangString))) {
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), this.jdField_a_of_type_JavaLangString, this.this$0.a().jdField_n_of_type_JavaLangString });
    }
    for (;;)
    {
      this.this$0.b(this.jdField_a_of_type_Long);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      return;
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), this.jdField_a_of_type_JavaLangString });
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.StartRingRunnable
 * JD-Core Version:    0.7.0.1
 */