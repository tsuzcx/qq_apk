package com.tencent.biz.pubaccount.readinjoy.drawable;

import bgfb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oet;
import oey;

public class ReadInJoyLottieDrawable$5$1
  implements Runnable
{
  public ReadInJoyLottieDrawable$5$1(oey paramoey) {}
  
  public void run()
  {
    if (bgfb.b(this.this$0.jdField_a_of_type_JavaIoFile, this.this$0.b)) {}
    try
    {
      oet.a(this.this$0.jdField_a_of_type_Oet, this.this$0.b);
      this.this$0.jdField_a_of_type_JavaIoFile.delete();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyLottieDrawable", 1, this.this$0.jdField_a_of_type_Long + " download lottie resource fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.5.1
 * JD-Core Version:    0.7.0.1
 */