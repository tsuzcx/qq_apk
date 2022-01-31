import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class amzi
{
  protected static bapw a;
  private bapv jdField_a_of_type_Bapv;
  public AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<amzm> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Bapw = new amzk();
  }
  
  public amzi(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bapv = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
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
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((amzm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bapv.b(((amzm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Baps);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(amzm paramamzm, amzl arg2)
  {
    if ((paramamzm == null) || (??? == null)) {
      return false;
    }
    ??? = new amzj(this, paramamzm, ???);
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = ???;
    localbaps.jdField_a_of_type_JavaLangString = paramamzm.jdField_a_of_type_JavaLangString;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.c = paramamzm.c;
    localbaps.e = 1;
    localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
    this.jdField_a_of_type_Bapv.a(localbaps);
    paramamzm.jdField_a_of_type_Baps = localbaps;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramamzm);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramamzm.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzi
 * JD-Core Version:    0.7.0.1
 */