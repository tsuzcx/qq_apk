import mqq.app.AppRuntime.Status;

public class atlj
{
  public int a;
  public long a;
  public String a;
  public AppRuntime.Status a;
  public int b;
  public String b;
  
  public atlj(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public atlj(AppRuntime.Status paramStatus)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = atlf.a(paramStatus);
    this.jdField_a_of_type_JavaLangString = atlf.a(paramStatus);
  }
  
  public static String a(AppRuntime.Status paramStatus, long paramLong)
  {
    return paramStatus.getValue() + paramLong + "";
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong == 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atlj
 * JD-Core Version:    0.7.0.1
 */