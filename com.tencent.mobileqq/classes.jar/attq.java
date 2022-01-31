import android.os.Vibrator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class attq
  implements atuc
{
  attq(attp paramattp) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "fun startMagicPlay begins, sumPlayTimes:" + this.a.jdField_c_of_type_Int + ",actionGlobalData.openSound:" + this.a.jdField_a_of_type_Attr.d);
    }
    Object localObject;
    if (this.a.jdField_c_of_type_Int == 0)
    {
      this.a.b();
      if ((this.a.jdField_a_of_type_Atuf.c != null) && (this.a.jdField_a_of_type_Atuf.c.length() > 0) && (this.a.jdField_a_of_type_Attr.d))
      {
        if (this.a.jdField_a_of_type_Atuf.e > 0)
        {
          localObject = this.a.jdField_a_of_type_Atuf;
          ((atuf)localObject).e -= 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Action", 2, "fun startMagicPlay begins, start play Sound.");
        }
        this.a.jdField_a_of_type_Atur.a(this.a.jdField_a_of_type_Atuf.c, this.a.jdField_a_of_type_Atuf.e);
      }
      if (this.a.jdField_a_of_type_Atuf.a)
      {
        this.a.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
        if (this.a.jdField_a_of_type_Atuf.h != -1) {
          break label311;
        }
        this.a.jdField_a_of_type_AndroidOsVibrator.vibrate(new long[] { 0L, 1000L }, 0);
      }
    }
    for (;;)
    {
      localObject = this.a;
      ((attp)localObject).jdField_c_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("Action", 2, "fun startMagicPlay ends, sumPlayTimes:" + this.a.jdField_c_of_type_Int);
      }
      return;
      label311:
      this.a.jdField_a_of_type_AndroidOsVibrator.vibrate(this.a.jdField_a_of_type_Atuf.h * 1000);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "func endMagicPlay begins, isStop:" + this.a.jdField_c_of_type_Boolean + ",timeout:" + this.a.jdField_a_of_type_Int + ",playTimes:" + this.a.jdField_b_of_type_Int + ",sumPlayTimes:" + this.a.jdField_c_of_type_Int + ",isTimeout:" + this.a.jdField_b_of_type_Boolean);
    }
    if (this.a.jdField_c_of_type_Boolean) {
      this.a.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Int == -1)
      {
        if (this.a.jdField_b_of_type_Int == -1)
        {
          this.a.jdField_a_of_type_Atur.a(this.a.jdField_a_of_type_Atuf);
          return;
        }
        if (this.a.jdField_b_of_type_Int > this.a.jdField_c_of_type_Int)
        {
          this.a.jdField_a_of_type_Atur.a(this.a.jdField_a_of_type_Atuf);
          return;
        }
        if (this.a.jdField_b_of_type_Int == this.a.jdField_c_of_type_Int)
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
          return;
        }
      }
    } while (this.a.jdField_b_of_type_Boolean);
    this.a.jdField_a_of_type_Atur.a(this.a.jdField_a_of_type_Atuf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attq
 * JD-Core Version:    0.7.0.1
 */