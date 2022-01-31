import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import mqq.app.AppRuntime;

public abstract class apzg
{
  public static int a;
  public static int b = 2;
  private String a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public apzg(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.BaseChannel", 2, String.format("channel: %s is destroy", new Object[] { a() }));
    }
  }
  
  public String b()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzg
 * JD-Core Version:    0.7.0.1
 */