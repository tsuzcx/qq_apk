import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bczy
{
  private static volatile bczy jdField_a_of_type_Bczy;
  bdaa jdField_a_of_type_Bdaa = null;
  bdad jdField_a_of_type_Bdad = null;
  
  public static bczy a()
  {
    if (jdField_a_of_type_Bczy == null) {}
    try
    {
      if (jdField_a_of_type_Bczy == null)
      {
        bczy localbczy = new bczy();
        localbczy.b();
        jdField_a_of_type_Bczy = localbczy;
      }
      return jdField_a_of_type_Bczy;
    }
    finally {}
  }
  
  public static void a()
  {
    bczy localbczy = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localbczy.jdField_a_of_type_Bdad.a) }));
    }
    bdaa.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bdad = new bdad();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Bdaa = new bdaa();
    }
  }
  
  public void a(boolean paramBoolean, bczz parambczz)
  {
    this.jdField_a_of_type_Bdad.a(paramBoolean, parambczz);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bdad.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bdad.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bdad.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Bdad.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Bdad.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczy
 * JD-Core Version:    0.7.0.1
 */