package com.tencent.biz.pubaccount.readinjoy.drawable;

import bjtz;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;
import out;
import ouy;

public class ReadInJoyLottieDrawable$5$1
  implements Runnable
{
  public ReadInJoyLottieDrawable$5$1(ouy paramouy) {}
  
  public void run()
  {
    if (bjtz.b(this.this$0.jdField_a_of_type_JavaIoFile, this.this$0.b)) {}
    try
    {
      out localout = (out)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localout != null) {
        out.a(localout, this.this$0.b);
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