import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class avvv
  implements URLDrawable.URLDrawableListener
{
  avvv(avvu paramavvu, long paramLong, AtomicBoolean paramAtomicBoolean, Bundle paramBundle) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    System.currentTimeMillis();
    long l = this.jdField_a_of_type_Long;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      avvu.a(this.jdField_a_of_type_Avvu, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("DynamicNow | NowEntry", 1, "download cover pic failed!");
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Avvu.a.b("download_cover").c("1").d(paramThrowable.getMessage()).i(String.valueOf(l1 - l2)).b();
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      avvu.a(this.jdField_a_of_type_Avvu, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.i("DynamicNow | NowEntry", 1, " download cover pic  success  timeconsume = " + l);
    this.jdField_a_of_type_Avvu.a.b("download_cover").c("0").i(String.valueOf(l)).b();
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      avvu.a(this.jdField_a_of_type_Avvu, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvv
 * JD-Core Version:    0.7.0.1
 */