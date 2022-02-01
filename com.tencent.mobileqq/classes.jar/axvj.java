import androidx.annotation.NonNull;
import mqq.app.AppRuntime.Status;

public class axvj
{
  public int a;
  public long a;
  public String a;
  public AppRuntime.Status a;
  public int b;
  public String b;
  public String c;
  
  public axvj()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
  }
  
  public axvj(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public axvj(AppRuntime.Status paramStatus)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = axvd.a(paramStatus);
    this.jdField_a_of_type_JavaLangString = axvd.a(paramStatus);
  }
  
  public static String a(AppRuntime.Status paramStatus, long paramLong)
  {
    return paramStatus.getValue() + "" + paramLong + "";
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong == 1000L;
  }
  
  public static boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    return (paramStatus == AppRuntime.Status.online) && (paramLong > 40000L);
  }
  
  @NonNull
  public String toString()
  {
    return "id=" + this.jdField_a_of_type_Long + " title=" + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvj
 * JD-Core Version:    0.7.0.1
 */