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

public class awrl
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public awrn a;
  public awrp a;
  awry jdField_a_of_type_Awry = new awrm(this);
  awsb jdField_a_of_type_Awsb;
  public awsn a;
  public String a;
  public List<awsb> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public awrl()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Awsb = ((awsb)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    awsb localawsb;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Awrn.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localawsb = (awsb)localIterator.next();
    } while ((localawsb.jdField_a_of_type_Int > this.jdField_a_of_type_Awrn.jdField_b_of_type_Int) || (localawsb.jdField_b_of_type_Int <= this.jdField_a_of_type_Awrn.jdField_b_of_type_Int));
    this.jdField_a_of_type_Awsb = localawsb;
  }
  
  public void a(int paramInt, awsl paramawsl)
  {
    if (this.jdField_a_of_type_Awrp == null) {}
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
            int j = this.jdField_a_of_type_Awrp.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Awrp.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Awrp.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Awrp.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Awrp.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          awrp localawrp = this.jdField_a_of_type_Awrp;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Awrp.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Awrp.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramawsl == null);
        paramawsl.a();
        return;
        paramawsl = this.jdField_a_of_type_Awrp;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Awrp.jdField_a_of_type_JavaLangString));
      paramawsl = this.jdField_a_of_type_Awrn;
      paramawsl.jdField_b_of_type_Int += this.jdField_a_of_type_Awrp.a(paramInt);
    } while (this.jdField_a_of_type_Awrn.jdField_a_of_type_Awrr == null);
    this.jdField_a_of_type_Awrn.e = this.jdField_a_of_type_Awrn.jdField_a_of_type_Awrr.a(this.jdField_a_of_type_Awrn.jdField_b_of_type_Int, this.jdField_a_of_type_Awrn.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Awsb.jdField_c_of_type_Int;
    this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_Awsb.g);
    this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_Awry);
    this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_Awsb);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Awsb.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Awsb.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_Awsb.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Awsb.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt, awsl paramawsl)
  {
    if (this.jdField_a_of_type_Awrp == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Awrp.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramawsl == null);
        d();
        return;
        awrp localawrp = this.jdField_a_of_type_Awrp;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Awrp.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Awrp.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Awrp.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramawsl == null);
    paramawsl.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Awsn.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrl
 * JD-Core Version:    0.7.0.1
 */