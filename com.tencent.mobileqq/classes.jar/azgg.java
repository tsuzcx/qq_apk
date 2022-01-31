import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class azgg
{
  private static volatile azgg jdField_a_of_type_Azgg;
  azgi jdField_a_of_type_Azgi = null;
  azgl jdField_a_of_type_Azgl = null;
  
  public static azgg a()
  {
    if (jdField_a_of_type_Azgg == null) {}
    try
    {
      if (jdField_a_of_type_Azgg == null)
      {
        azgg localazgg = new azgg();
        localazgg.b();
        jdField_a_of_type_Azgg = localazgg;
      }
      return jdField_a_of_type_Azgg;
    }
    finally {}
  }
  
  public static void a()
  {
    azgg localazgg = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localazgg.jdField_a_of_type_Azgl.a) }));
    }
    azgi.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Azgl = new azgl();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Azgi = new azgi();
    }
  }
  
  public void a(boolean paramBoolean, azgh paramazgh)
  {
    this.jdField_a_of_type_Azgl.a(paramBoolean, paramazgh);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Azgl.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Azgl.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Azgl.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Azgl.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Azgl.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgg
 * JD-Core Version:    0.7.0.1
 */