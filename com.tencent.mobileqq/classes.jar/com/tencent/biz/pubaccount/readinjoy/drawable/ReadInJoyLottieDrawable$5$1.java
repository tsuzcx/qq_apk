package com.tencent.biz.pubaccount.readinjoy.drawable;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import mqq.util.WeakReference;
import pta;
import ptf;

public class ReadInJoyLottieDrawable$5$1
  implements Runnable
{
  public ReadInJoyLottieDrawable$5$1(ptf paramptf) {}
  
  public void run()
  {
    if (FileUtils.unzip(this.this$0.jdField_a_of_type_JavaIoFile, this.this$0.b)) {}
    try
    {
      pta localpta = (pta)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localpta != null) {
        pta.a(localpta, this.this$0.b);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.5.1
 * JD-Core Version:    0.7.0.1
 */