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

public class ascn
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public ascp a;
  public ascr a;
  asda jdField_a_of_type_Asda = new asco(this);
  asdd jdField_a_of_type_Asdd;
  public asdp a;
  public String a;
  public List<asdd> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public ascn()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Asdd = ((asdd)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    asdd localasdd;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Ascp.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localasdd = (asdd)localIterator.next();
    } while ((localasdd.jdField_a_of_type_Int > this.jdField_a_of_type_Ascp.jdField_b_of_type_Int) || (localasdd.jdField_b_of_type_Int <= this.jdField_a_of_type_Ascp.jdField_b_of_type_Int));
    this.jdField_a_of_type_Asdd = localasdd;
  }
  
  public void a(int paramInt, asdn paramasdn)
  {
    if (this.jdField_a_of_type_Ascr == null) {}
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
            int j = this.jdField_a_of_type_Ascr.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Ascr.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Ascr.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Ascr.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Ascr.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          ascr localascr = this.jdField_a_of_type_Ascr;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Ascr.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Ascr.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramasdn == null);
        paramasdn.a();
        return;
        paramasdn = this.jdField_a_of_type_Ascr;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Ascr.jdField_a_of_type_JavaLangString));
      paramasdn = this.jdField_a_of_type_Ascp;
      paramasdn.jdField_b_of_type_Int += this.jdField_a_of_type_Ascr.a(paramInt);
    } while (this.jdField_a_of_type_Ascp.jdField_a_of_type_Asct == null);
    this.jdField_a_of_type_Ascp.e = this.jdField_a_of_type_Ascp.jdField_a_of_type_Asct.a(this.jdField_a_of_type_Ascp.jdField_b_of_type_Int, this.jdField_a_of_type_Ascp.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Asdd.jdField_c_of_type_Int;
    this.jdField_a_of_type_Asdp.a(this.jdField_a_of_type_Asdd.g);
    this.jdField_a_of_type_Asdp.a(this.jdField_a_of_type_Asda);
    this.jdField_a_of_type_Asdp.a(this.jdField_a_of_type_Asdd);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Asdd.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Asdd.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Asdp.a(this.jdField_a_of_type_Asdd.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Asdd.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt, asdn paramasdn)
  {
    if (this.jdField_a_of_type_Ascr == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Ascr.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramasdn == null);
        d();
        return;
        ascr localascr = this.jdField_a_of_type_Ascr;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Ascr.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Ascr.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Ascr.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramasdn == null);
    paramasdn.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Asdp.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascn
 * JD-Core Version:    0.7.0.1
 */