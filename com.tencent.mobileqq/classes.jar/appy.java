import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class appy
{
  protected static beup a;
  private beuo jdField_a_of_type_Beuo;
  public AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<apqc> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Beup = new apqa();
  }
  
  public appy(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Beuo = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((apqc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Beuo.b(((apqc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Beum);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(apqc paramapqc, apqb arg2)
  {
    if ((paramapqc == null) || (??? == null)) {
      return false;
    }
    ??? = new appz(this, paramapqc, ???);
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = ???;
    localbeum.jdField_a_of_type_JavaLangString = paramapqc.jdField_a_of_type_JavaLangString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = paramapqc.c;
    localbeum.d = 1;
    localbeum.jdField_a_of_type_Beup = jdField_a_of_type_Beup;
    this.jdField_a_of_type_Beuo.a(localbeum);
    paramapqc.jdField_a_of_type_Beum = localbeum;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramapqc);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramapqc.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appy
 * JD-Core Version:    0.7.0.1
 */