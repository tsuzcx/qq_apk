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

public class awfh
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public awfj a;
  public awfl a;
  awfu jdField_a_of_type_Awfu = new awfi(this);
  awfx jdField_a_of_type_Awfx;
  public awgj a;
  public String a;
  public List<awfx> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public awfh()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Awfx = ((awfx)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    awfx localawfx;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Awfj.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localawfx = (awfx)localIterator.next();
    } while ((localawfx.jdField_a_of_type_Int > this.jdField_a_of_type_Awfj.jdField_b_of_type_Int) || (localawfx.jdField_b_of_type_Int <= this.jdField_a_of_type_Awfj.jdField_b_of_type_Int));
    this.jdField_a_of_type_Awfx = localawfx;
  }
  
  public void a(int paramInt, awgh paramawgh)
  {
    if (this.jdField_a_of_type_Awfl == null) {}
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
            int j = this.jdField_a_of_type_Awfl.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Awfl.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Awfl.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Awfl.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Awfl.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          awfl localawfl = this.jdField_a_of_type_Awfl;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Awfl.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramawgh == null);
        paramawgh.a();
        return;
        paramawgh = this.jdField_a_of_type_Awfl;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangString));
      paramawgh = this.jdField_a_of_type_Awfj;
      paramawgh.jdField_b_of_type_Int += this.jdField_a_of_type_Awfl.a(paramInt);
    } while (this.jdField_a_of_type_Awfj.jdField_a_of_type_Awfn == null);
    this.jdField_a_of_type_Awfj.e = this.jdField_a_of_type_Awfj.jdField_a_of_type_Awfn.a(this.jdField_a_of_type_Awfj.jdField_b_of_type_Int, this.jdField_a_of_type_Awfj.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Awfx.jdField_c_of_type_Int;
    this.jdField_a_of_type_Awgj.a(this.jdField_a_of_type_Awfx.g);
    this.jdField_a_of_type_Awgj.a(this.jdField_a_of_type_Awfu);
    this.jdField_a_of_type_Awgj.a(this.jdField_a_of_type_Awfx);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Awfx.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Awfx.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Awgj.a(this.jdField_a_of_type_Awfx.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Awfx.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt, awgh paramawgh)
  {
    if (this.jdField_a_of_type_Awfl == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Awfl.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramawgh == null);
        d();
        return;
        awfl localawfl = this.jdField_a_of_type_Awfl;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Awfl.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Awfl.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramawgh == null);
    paramawgh.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Awgj.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfh
 * JD-Core Version:    0.7.0.1
 */