import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class autj
{
  public float a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public long e;
  public long f;
  public long g;
  public long h;
  
  public autj()
  {
    this.jdField_b_of_type_Int = 999;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  public float a()
  {
    if (c()) {}
    while (a()) {
      return 0.4F;
    }
    return 1.0F;
  }
  
  public void a(autk paramautk)
  {
    this.jdField_a_of_type_Long = paramautk.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramautk.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramautk.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramautk.jdField_c_of_type_Long;
    this.jdField_d_of_type_Long = paramautk.jdField_d_of_type_Long;
    this.e = paramautk.e;
    this.f = paramautk.f;
    this.g = paramautk.g;
    this.jdField_a_of_type_Boolean = paramautk.jdField_b_of_type_Boolean;
    this.h = paramautk.h;
    this.jdField_c_of_type_JavaLangString = paramautk.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramautk.jdField_b_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramautk.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = paramautk.jdField_a_of_type_Boolean;
  }
  
  public boolean a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Long == 12L) || (this.jdField_a_of_type_Long == 1L) || (this.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Long == 3L)) {
      bool = false;
    }
    do
    {
      return bool;
      if ((!auss.c(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_Long != 7L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkForDisplayInfo", 2, "isInTwinkling icon_status:" + this.f + " currentMillis:" + NetConnInfoCenter.getServerTimeMillis() + " icon_status_end_time:" + this.g);
      }
    } while ((this.f == 2L) && (NetConnInfoCenter.getServerTimeMillis() < this.g * 1000L));
    while (!auss.a(this.jdField_d_of_type_Long * 1000L)) {
      return false;
    }
    return true;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Long == 5L) || (this.jdField_a_of_type_Long == 6L) || (this.jdField_a_of_type_Long == 8L) || (this.jdField_a_of_type_Long == 4L);
  }
  
  public boolean c()
  {
    return this.f == 1L;
  }
  
  public boolean d()
  {
    if ((this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {}
    while ((this.jdField_c_of_type_Int == 0) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     autj
 * JD-Core Version:    0.7.0.1
 */