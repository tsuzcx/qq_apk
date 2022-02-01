import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bchg
{
  private static volatile bchg jdField_a_of_type_Bchg;
  bchi jdField_a_of_type_Bchi = null;
  bchl jdField_a_of_type_Bchl = null;
  
  public static bchg a()
  {
    if (jdField_a_of_type_Bchg == null) {}
    try
    {
      if (jdField_a_of_type_Bchg == null)
      {
        bchg localbchg = new bchg();
        localbchg.b();
        jdField_a_of_type_Bchg = localbchg;
      }
      return jdField_a_of_type_Bchg;
    }
    finally {}
  }
  
  public static void a()
  {
    bchg localbchg = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localbchg.jdField_a_of_type_Bchl.a) }));
    }
    bchi.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bchl = new bchl();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Bchi = new bchi();
    }
  }
  
  public void a(boolean paramBoolean, bchh parambchh)
  {
    this.jdField_a_of_type_Bchl.a(paramBoolean, parambchh);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bchl.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bchl.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bchl.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Bchl.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Bchl.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchg
 * JD-Core Version:    0.7.0.1
 */