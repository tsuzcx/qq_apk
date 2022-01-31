import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class andh
{
  protected static bauf a;
  private baue jdField_a_of_type_Baue;
  private bbaa jdField_a_of_type_Bbaa;
  public QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<andn> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, andm> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_Bauf = new andl();
  }
  
  public andh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Baue = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bbaa = ((bbaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(andn paramandn, andm paramandm)
  {
    if ((paramandn == null) || (paramandm == null)) {
      return false;
    }
    Object localObject1 = new andi(this, paramandn);
    ??? = new andj(this);
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = ((baug)???);
    localbaub.jdField_a_of_type_JavaLangString = paramandn.jdField_a_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.c = paramandn.c;
    localbaub.e = 1;
    localbaub.jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
    paramandn.jdField_a_of_type_Baub = localbaub;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramandn);
        switch (bdin.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new andk(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramandn.b, (bazz)localObject1, localbaub, paramandn, paramandm);
          this.jdField_a_of_type_Bbaa.a(10065, "prd", paramandn.b, 0, paramandn.jdField_a_of_type_JavaLangString, localbaub.c, i, 0, false, (bazx)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramandn.b, paramandm);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramandn.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
      int i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andh
 * JD-Core Version:    0.7.0.1
 */