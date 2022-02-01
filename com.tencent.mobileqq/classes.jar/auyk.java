import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Date;

class auyk
{
  static auyk jdField_a_of_type_Auyk = new auyk(false, new Date(0L), new Date(0L));
  final Date jdField_a_of_type_JavaUtilDate;
  final boolean jdField_a_of_type_Boolean;
  final Date b;
  
  auyk(boolean paramBoolean, @NonNull Date paramDate1, @NonNull Date paramDate2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilDate = paramDate1;
    this.b = paramDate2;
  }
  
  private boolean b()
  {
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    return (this.jdField_a_of_type_JavaUtilDate.getTime() <= l) && (this.b.getTime() >= l);
  }
  
  boolean a()
  {
    return (b()) && (this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyk
 * JD-Core Version:    0.7.0.1
 */