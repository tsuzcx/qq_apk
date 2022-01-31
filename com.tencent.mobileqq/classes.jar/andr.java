import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class andr
{
  protected static bauf a;
  private baue jdField_a_of_type_Baue;
  public AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<andv> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Bauf = new andt();
  }
  
  public andr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Baue = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
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
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((andv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Baue.b(((andv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Baub);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(andv paramandv, andu arg2)
  {
    if ((paramandv == null) || (??? == null)) {
      return false;
    }
    ??? = new ands(this, paramandv, ???);
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = ???;
    localbaub.jdField_a_of_type_JavaLangString = paramandv.jdField_a_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.c = paramandv.c;
    localbaub.e = 1;
    localbaub.jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
    this.jdField_a_of_type_Baue.a(localbaub);
    paramandv.jdField_a_of_type_Baub = localbaub;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramandv);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramandv.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andr
 * JD-Core Version:    0.7.0.1
 */