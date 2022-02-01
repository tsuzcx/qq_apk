import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bbtd
{
  private static volatile bbtd jdField_a_of_type_Bbtd;
  bbtf jdField_a_of_type_Bbtf = null;
  bbti jdField_a_of_type_Bbti = null;
  
  public static bbtd a()
  {
    if (jdField_a_of_type_Bbtd == null) {}
    try
    {
      if (jdField_a_of_type_Bbtd == null)
      {
        bbtd localbbtd = new bbtd();
        localbbtd.b();
        jdField_a_of_type_Bbtd = localbbtd;
      }
      return jdField_a_of_type_Bbtd;
    }
    finally {}
  }
  
  public static void a()
  {
    bbtd localbbtd = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localbbtd.jdField_a_of_type_Bbti.a) }));
    }
    bbtf.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bbti = new bbti();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Bbtf = new bbtf();
    }
  }
  
  public void a(boolean paramBoolean, bbte parambbte)
  {
    this.jdField_a_of_type_Bbti.a(paramBoolean, parambbte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bbti.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bbti.d();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Bbti.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Bbti.a == 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Bbti.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtd
 * JD-Core Version:    0.7.0.1
 */