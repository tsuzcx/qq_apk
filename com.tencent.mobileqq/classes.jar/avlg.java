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

public class avlg
{
  public int a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  public avli a;
  public avlk a;
  avlt jdField_a_of_type_Avlt = new avlh(this);
  avlw jdField_a_of_type_Avlw;
  public avmi a;
  public String a;
  public List<avlw> a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = new Action.2(this);
  CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public boolean a;
  public int b;
  public volatile boolean b;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  public boolean d;
  
  public avlg()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_Avlw = ((avlw)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    avlw localavlw;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Avli.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localavlw = (avlw)localIterator.next();
    } while ((localavlw.jdField_a_of_type_Int > this.jdField_a_of_type_Avli.jdField_b_of_type_Int) || (localavlw.jdField_b_of_type_Int <= this.jdField_a_of_type_Avli.jdField_b_of_type_Int));
    this.jdField_a_of_type_Avlw = localavlw;
  }
  
  public void a(int paramInt, avmg paramavmg)
  {
    if (this.jdField_a_of_type_Avlk == null) {}
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
            int j = this.jdField_a_of_type_Avlk.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_Avlk.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Avlk.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_Avlk.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Avlk.jdField_c_of_type_JavaLangString)) {
              break;
            }
          } while (paramInt < i);
          d();
          return;
          avlk localavlk = this.jdField_a_of_type_Avlk;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Avlk.jdField_a_of_type_JavaLangString)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Avlk.jdField_b_of_type_JavaLangString))) {
            break;
          }
          d();
        } while (paramavmg == null);
        paramavmg.a();
        return;
        paramavmg = this.jdField_a_of_type_Avlk;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Avlk.jdField_a_of_type_JavaLangString));
      paramavmg = this.jdField_a_of_type_Avli;
      paramavmg.jdField_b_of_type_Int += this.jdField_a_of_type_Avlk.a(paramInt);
    } while (this.jdField_a_of_type_Avli.jdField_a_of_type_Avlm == null);
    this.jdField_a_of_type_Avli.e = this.jdField_a_of_type_Avli.jdField_a_of_type_Avlm.a(this.jdField_a_of_type_Avli.jdField_b_of_type_Int, this.jdField_a_of_type_Avli.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Avlw.jdField_c_of_type_Int;
    this.jdField_a_of_type_Avmi.a(this.jdField_a_of_type_Avlw.g);
    this.jdField_a_of_type_Avmi.a(this.jdField_a_of_type_Avlt);
    this.jdField_a_of_type_Avmi.a(this.jdField_a_of_type_Avlw);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Avlw.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_Avlw.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_Avmi.a(this.jdField_a_of_type_Avlw.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_Avlw.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt, avmg paramavmg)
  {
    if (this.jdField_a_of_type_Avlk == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Avlk.jdField_c_of_type_JavaLangString)) {
            break;
          }
        } while (paramavmg == null);
        d();
        return;
        avlk localavlk = this.jdField_a_of_type_Avlk;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Avlk.jdField_a_of_type_JavaLangString)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Avlk.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Avlk.jdField_b_of_type_Int != paramInt));
      d();
    } while (paramavmg == null);
    paramavmg.a();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Avmi.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlg
 * JD-Core Version:    0.7.0.1
 */