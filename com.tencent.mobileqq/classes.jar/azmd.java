import android.os.SystemClock;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.qphone.base.util.QLog;

public class azmd
  implements azpa
{
  private long jdField_a_of_type_Long;
  private UsingTimeReportManager jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  
  public azmd(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager != null) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager.a(this);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager.b(this);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void h()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("BaseUsingTimeReport", 2, "stop,usingTime=" + l);
    }
    if ((l > 0L) && (this.jdField_b_of_type_Boolean)) {
      a(l);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public UsingTimeReportManager a()
  {
    return null;
  }
  
  public void a()
  {
    f();
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.i("BaseUsingTimeReport", 2, "start(), mStartTime=" + this.jdField_a_of_type_Long);
  }
  
  public void a(long paramLong) {}
  
  public void b()
  {
    h();
    g();
  }
  
  public void c()
  {
    h();
  }
  
  public void d()
  {
    a();
  }
  
  public void e()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmd
 * JD-Core Version:    0.7.0.1
 */