import android.os.Vibrator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.magicfaceaction.Action.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class ascp
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public ascr a;
  public asct a;
  asdc jdField_a_of_type_Asdc = new ascq(this);
  asdf jdField_a_of_type_Asdf;
  public asdr a;
  public String a;
  public List<asdf> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public ascp()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Asdf = ((asdf)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    asdf localasdf;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Ascr.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localasdf = (asdf)localIterator.next();
    } while ((localasdf.jdField_a_of_type_Int > this.jdField_a_of_type_Ascr.jdField_b_of_type_Int) || (localasdf.jdField_b_of_type_Int <= this.jdField_a_of_type_Ascr.jdField_b_of_type_Int));
    this.jdField_a_of_type_Asdf = localasdf;
  }
  
  public void a(int paramInt, asdp paramasdp)
  {
    if (this.jdField_a_of_type_Asct == null) {}
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            int j = this.jdField_a_of_type_Asct.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Asct.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Asct.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Asct.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Asct.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          asct localasct = this.jdField_a_of_type_Asct;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Asct.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Asct.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramasdp == null);
        paramasdp.a();
        return;
        paramasdp = this.jdField_a_of_type_Asct;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Asct.jdField_a_of_type_JavaLangString));
      paramasdp = this.jdField_a_of_type_Ascr;
      paramasdp.jdField_b_of_type_Int += this.jdField_a_of_type_Asct.a(paramInt);
    } while (this.jdField_a_of_type_Ascr.jdField_a_of_type_Ascv == null);
    this.jdField_a_of_type_Ascr.e = this.jdField_a_of_type_Ascr.jdField_a_of_type_Ascv.a(this.jdField_a_of_type_Ascr.jdField_b_of_type_Int, this.jdField_a_of_type_Ascr.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Asdf.jdField_c_of_type_Int;
    this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asdf.g);
    this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asdc);
    this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asdf);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Asdf.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Asdf.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asdf.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Asdf.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidOsVibrator.cancel();
      }
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Action", 2, "===Magicaction is stop====");
      }
      return true;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Int > 0) {
      ThreadManager.getTimer().schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.jdField_a_of_type_Int * 1000);
    }
  }
  
  public void b(int paramInt, asdp paramasdp)
  {
    if (this.jdField_a_of_type_Asct == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Asct.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramasdp == null);
        d();
        return;
        asct localasct = this.jdField_a_of_type_Asct;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Asct.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Asct.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Asct.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramasdp == null);
    paramasdp.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Asdr.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascp
 * JD-Core Version:    0.7.0.1
 */