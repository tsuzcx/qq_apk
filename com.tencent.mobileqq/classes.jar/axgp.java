import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axgp
{
  private static volatile axgp jdField_a_of_type_Axgp;
  axgr jdField_a_of_type_Axgr = null;
  axgu jdField_a_of_type_Axgu = null;
  
  public static axgp a()
  {
    if (jdField_a_of_type_Axgp == null) {}
    try
    {
      if (jdField_a_of_type_Axgp == null)
      {
        axgp localaxgp = new axgp();
        localaxgp.b();
        jdField_a_of_type_Axgp = localaxgp;
      }
      return jdField_a_of_type_Axgp;
    }
    finally {}
  }
  
  public static void a()
  {
    axgp localaxgp = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localaxgp.jdField_a_of_type_Axgu.a) }));
    }
    axgr.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Axgu = new axgu();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Axgr = new axgr();
    }
  }
  
  public void a(boolean paramBoolean, axgq paramaxgq)
  {
    this.jdField_a_of_type_Axgu.a(paramBoolean, paramaxgq);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Axgu.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Axgu.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Axgu.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Axgu.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Axgu.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgp
 * JD-Core Version:    0.7.0.1
 */