import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class azbx
{
  private static volatile azbx jdField_a_of_type_Azbx;
  azbz jdField_a_of_type_Azbz = null;
  azcc jdField_a_of_type_Azcc = null;
  
  public static azbx a()
  {
    if (jdField_a_of_type_Azbx == null) {}
    try
    {
      if (jdField_a_of_type_Azbx == null)
      {
        azbx localazbx = new azbx();
        localazbx.b();
        jdField_a_of_type_Azbx = localazbx;
      }
      return jdField_a_of_type_Azbx;
    }
    finally {}
  }
  
  public static void a()
  {
    azbx localazbx = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localazbx.jdField_a_of_type_Azcc.a) }));
    }
    azbz.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Azcc = new azcc();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Azbz = new azbz();
    }
  }
  
  public void a(boolean paramBoolean, azby paramazby)
  {
    this.jdField_a_of_type_Azcc.a(paramBoolean, paramazby);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Azcc.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Azcc.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Azcc.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Azcc.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Azcc.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbx
 * JD-Core Version:    0.7.0.1
 */