import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apci
{
  protected static bdvv a;
  private bdvu jdField_a_of_type_Bdvu;
  public AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<apcm> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Bdvv = new apck();
  }
  
  public apci(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bdvu = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
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
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((apcm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bdvu.b(((apcm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bdvs);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(apcm paramapcm, apcl arg2)
  {
    if ((paramapcm == null) || (??? == null)) {
      return false;
    }
    ??? = new apcj(this, paramapcm, ???);
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = ???;
    localbdvs.jdField_a_of_type_JavaLangString = paramapcm.jdField_a_of_type_JavaLangString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = paramapcm.c;
    localbdvs.d = 1;
    localbdvs.jdField_a_of_type_Bdvv = jdField_a_of_type_Bdvv;
    this.jdField_a_of_type_Bdvu.a(localbdvs);
    paramapcm.jdField_a_of_type_Bdvs = localbdvs;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramapcm);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramapcm.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apci
 * JD-Core Version:    0.7.0.1
 */