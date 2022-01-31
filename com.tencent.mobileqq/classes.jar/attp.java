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

public class attp
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public attr a;
  public attt a;
  atuc jdField_a_of_type_Atuc = new attq(this);
  atuf jdField_a_of_type_Atuf;
  public atur a;
  public String a;
  public List<atuf> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public attp()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Atuf = ((atuf)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    atuf localatuf;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Attr.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localatuf = (atuf)localIterator.next();
    } while ((localatuf.jdField_a_of_type_Int > this.jdField_a_of_type_Attr.jdField_b_of_type_Int) || (localatuf.jdField_b_of_type_Int <= this.jdField_a_of_type_Attr.jdField_b_of_type_Int));
    this.jdField_a_of_type_Atuf = localatuf;
  }
  
  public void a(int paramInt, atup paramatup)
  {
    if (this.jdField_a_of_type_Attt == null) {}
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
            int j = this.jdField_a_of_type_Attt.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Attt.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Attt.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Attt.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Attt.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          attt localattt = this.jdField_a_of_type_Attt;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Attt.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Attt.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramatup == null);
        paramatup.a();
        return;
        paramatup = this.jdField_a_of_type_Attt;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Attt.jdField_a_of_type_JavaLangString));
      paramatup = this.jdField_a_of_type_Attr;
      paramatup.jdField_b_of_type_Int += this.jdField_a_of_type_Attt.a(paramInt);
    } while (this.jdField_a_of_type_Attr.jdField_a_of_type_Attv == null);
    this.jdField_a_of_type_Attr.e = this.jdField_a_of_type_Attr.jdField_a_of_type_Attv.a(this.jdField_a_of_type_Attr.jdField_b_of_type_Int, this.jdField_a_of_type_Attr.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Atuf.jdField_c_of_type_Int;
    this.jdField_a_of_type_Atur.a(this.jdField_a_of_type_Atuf.g);
    this.jdField_a_of_type_Atur.a(this.jdField_a_of_type_Atuc);
    this.jdField_a_of_type_Atur.a(this.jdField_a_of_type_Atuf);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Atuf.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Atuf.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Atur.a(this.jdField_a_of_type_Atuf.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Atuf.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt, atup paramatup)
  {
    if (this.jdField_a_of_type_Attt == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Attt.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramatup == null);
        d();
        return;
        attt localattt = this.jdField_a_of_type_Attt;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Attt.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Attt.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Attt.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramatup == null);
    paramatup.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Atur.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attp
 * JD-Core Version:    0.7.0.1
 */