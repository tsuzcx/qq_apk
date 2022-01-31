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

public class atxy
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public atya a;
  public atyc a;
  atyl jdField_a_of_type_Atyl = new atxz(this);
  atyo jdField_a_of_type_Atyo;
  public atza a;
  public String a;
  public List<atyo> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public atxy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Atyo = ((atyo)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    atyo localatyo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Atya.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localatyo = (atyo)localIterator.next();
    } while ((localatyo.jdField_a_of_type_Int > this.jdField_a_of_type_Atya.jdField_b_of_type_Int) || (localatyo.jdField_b_of_type_Int <= this.jdField_a_of_type_Atya.jdField_b_of_type_Int));
    this.jdField_a_of_type_Atyo = localatyo;
  }
  
  public void a(int paramInt, atyy paramatyy)
  {
    if (this.jdField_a_of_type_Atyc == null) {}
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
            int j = this.jdField_a_of_type_Atyc.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Atyc.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Atyc.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Atyc.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          atyc localatyc = this.jdField_a_of_type_Atyc;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Atyc.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Atyc.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramatyy == null);
        paramatyy.a();
        return;
        paramatyy = this.jdField_a_of_type_Atyc;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Atyc.jdField_a_of_type_JavaLangString));
      paramatyy = this.jdField_a_of_type_Atya;
      paramatyy.jdField_b_of_type_Int += this.jdField_a_of_type_Atyc.a(paramInt);
    } while (this.jdField_a_of_type_Atya.jdField_a_of_type_Atye == null);
    this.jdField_a_of_type_Atya.e = this.jdField_a_of_type_Atya.jdField_a_of_type_Atye.a(this.jdField_a_of_type_Atya.jdField_b_of_type_Int, this.jdField_a_of_type_Atya.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Atyo.jdField_c_of_type_Int;
    this.jdField_a_of_type_Atza.a(this.jdField_a_of_type_Atyo.g);
    this.jdField_a_of_type_Atza.a(this.jdField_a_of_type_Atyl);
    this.jdField_a_of_type_Atza.a(this.jdField_a_of_type_Atyo);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Atyo.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Atyo.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Atza.a(this.jdField_a_of_type_Atyo.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Atyo.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt, atyy paramatyy)
  {
    if (this.jdField_a_of_type_Atyc == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Atyc.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramatyy == null);
        d();
        return;
        atyc localatyc = this.jdField_a_of_type_Atyc;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Atyc.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Atyc.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Atyc.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramatyy == null);
    paramatyy.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Atza.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxy
 * JD-Core Version:    0.7.0.1
 */