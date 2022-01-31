import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axgr
{
  private static volatile axgr jdField_a_of_type_Axgr;
  axgt jdField_a_of_type_Axgt = null;
  axgw jdField_a_of_type_Axgw = null;
  
  public static axgr a()
  {
    if (jdField_a_of_type_Axgr == null) {}
    try
    {
      if (jdField_a_of_type_Axgr == null)
      {
        axgr localaxgr = new axgr();
        localaxgr.b();
        jdField_a_of_type_Axgr = localaxgr;
      }
      return jdField_a_of_type_Axgr;
    }
    finally {}
  }
  
  public static void a()
  {
    axgr localaxgr = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localaxgr.jdField_a_of_type_Axgw.a) }));
    }
    axgt.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Axgw = new axgw();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Axgt = new axgt();
    }
  }
  
  public void a(boolean paramBoolean, axgs paramaxgs)
  {
    this.jdField_a_of_type_Axgw.a(paramBoolean, paramaxgs);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Axgw.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Axgw.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Axgw.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Axgw.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Axgw.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgr
 * JD-Core Version:    0.7.0.1
 */