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

public class awxz
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public awyb a;
  public awyd a;
  awym jdField_a_of_type_Awym = new awya(this);
  awyp jdField_a_of_type_Awyp;
  public awzb a;
  public String a;
  public List<awyp> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public awxz()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Awyp = ((awyp)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    awyp localawyp;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Awyb.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localawyp = (awyp)localIterator.next();
    } while ((localawyp.jdField_a_of_type_Int > this.jdField_a_of_type_Awyb.jdField_b_of_type_Int) || (localawyp.jdField_b_of_type_Int <= this.jdField_a_of_type_Awyb.jdField_b_of_type_Int));
    this.jdField_a_of_type_Awyp = localawyp;
  }
  
  public void a(int paramInt, awyz paramawyz)
  {
    if (this.jdField_a_of_type_Awyd == null) {}
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
            int j = this.jdField_a_of_type_Awyd.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Awyd.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Awyd.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Awyd.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Awyd.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          awyd localawyd = this.jdField_a_of_type_Awyd;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Awyd.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Awyd.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramawyz == null);
        paramawyz.a();
        return;
        paramawyz = this.jdField_a_of_type_Awyd;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Awyd.jdField_a_of_type_JavaLangString));
      paramawyz = this.jdField_a_of_type_Awyb;
      paramawyz.jdField_b_of_type_Int += this.jdField_a_of_type_Awyd.a(paramInt);
    } while (this.jdField_a_of_type_Awyb.jdField_a_of_type_Awyf == null);
    this.jdField_a_of_type_Awyb.e = this.jdField_a_of_type_Awyb.jdField_a_of_type_Awyf.a(this.jdField_a_of_type_Awyb.jdField_b_of_type_Int, this.jdField_a_of_type_Awyb.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Awyp.jdField_c_of_type_Int;
    this.jdField_a_of_type_Awzb.a(this.jdField_a_of_type_Awyp.g);
    this.jdField_a_of_type_Awzb.a(this.jdField_a_of_type_Awym);
    this.jdField_a_of_type_Awzb.a(this.jdField_a_of_type_Awyp);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Awyp.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Awyp.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Awzb.a(this.jdField_a_of_type_Awyp.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Awyp.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt, awyz paramawyz)
  {
    if (this.jdField_a_of_type_Awyd == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Awyd.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramawyz == null);
        d();
        return;
        awyd localawyd = this.jdField_a_of_type_Awyd;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Awyd.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Awyd.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Awyd.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramawyz == null);
    paramawyz.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Awzb.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxz
 * JD-Core Version:    0.7.0.1
 */