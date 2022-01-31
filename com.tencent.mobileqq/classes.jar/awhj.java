import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class awhj
{
  private static volatile awhj jdField_a_of_type_Awhj;
  awhl jdField_a_of_type_Awhl = null;
  awho jdField_a_of_type_Awho = null;
  
  public static awhj a()
  {
    if (jdField_a_of_type_Awhj == null) {}
    try
    {
      if (jdField_a_of_type_Awhj == null)
      {
        awhj localawhj = new awhj();
        localawhj.b();
        jdField_a_of_type_Awhj = localawhj;
      }
      return jdField_a_of_type_Awhj;
    }
    finally {}
  }
  
  public static void a()
  {
    awhj localawhj = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localawhj.jdField_a_of_type_Awho.a) }));
    }
    awhl.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Awho = new awho();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Awhl = new awhl();
    }
  }
  
  public void a(boolean paramBoolean, awhk paramawhk)
  {
    this.jdField_a_of_type_Awho.a(paramBoolean, paramawhk);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Awho.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Awho.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Awho.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Awho.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Awho.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awhj
 * JD-Core Version:    0.7.0.1
 */