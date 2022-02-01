import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class axap
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
  
  public axap()
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
  
  public void a(axaq paramaxaq)
  {
    this.jdField_a_of_type_Long = paramaxaq.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramaxaq.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramaxaq.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramaxaq.jdField_c_of_type_Long;
    this.jdField_d_of_type_Long = paramaxaq.jdField_d_of_type_Long;
    this.e = paramaxaq.e;
    this.f = paramaxaq.f;
    this.g = paramaxaq.g;
    this.jdField_a_of_type_Boolean = paramaxaq.jdField_b_of_type_Boolean;
    this.h = paramaxaq.h;
    this.jdField_c_of_type_JavaLangString = paramaxaq.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramaxaq.jdField_b_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramaxaq.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = paramaxaq.jdField_a_of_type_Boolean;
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
      if ((!awzy.c(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_Long != 7L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkForDisplayInfo", 2, "isInTwinkling icon_status:" + this.f + " currentMillis:" + NetConnInfoCenter.getServerTimeMillis() + " icon_status_end_time:" + this.g);
      }
    } while ((this.f == 2L) && (NetConnInfoCenter.getServerTimeMillis() < this.g * 1000L));
    while (!awzy.a(this.jdField_d_of_type_Long * 1000L)) {
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkForDisplayInfo{");
    localStringBuilder.append("type=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", level=").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", count=").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", continue_days=").append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", last_action_time=").append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", last_change_time=").append(this.e);
    localStringBuilder.append(", icon_status=").append(this.f);
    localStringBuilder.append(", icon_status_end_time=").append(this.g);
    localStringBuilder.append(", hasRemindInContact=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", remindAnimStartTime=").append(this.h);
    localStringBuilder.append(", sortKeyForNormal=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isInAIOTitleLeft2=").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", sortKeyForAIOTitle=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", name='").append(this.jdField_a_of_type_JavaLangString).append("'");
    localStringBuilder.append(", disableLocalResource=").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", iconResId=").append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", iconApngUrl='").append(this.jdField_b_of_type_JavaLangString).append("'");
    localStringBuilder.append(", icon_static_url='").append(this.jdField_c_of_type_JavaLangString).append("'");
    localStringBuilder.append(", icon_name='").append(this.jdField_d_of_type_JavaLangString).append("'");
    localStringBuilder.append(", user_close_flag=").append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axap
 * JD-Core Version:    0.7.0.1
 */