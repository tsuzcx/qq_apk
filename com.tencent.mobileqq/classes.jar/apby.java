import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class apby
{
  protected static bdvv a;
  private bdvu jdField_a_of_type_Bdvu;
  private beaw jdField_a_of_type_Beaw;
  public QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<apce> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, apcd> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_Bdvv = new apcc();
  }
  
  public apby(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bdvu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Beaw = ((beaw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(apce paramapce, apcd paramapcd)
  {
    if ((paramapce == null) || (paramapcd == null)) {
      return false;
    }
    Object localObject1 = new apbz(this, paramapce);
    ??? = new apca(this);
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = ((bdvw)???);
    localbdvs.jdField_a_of_type_JavaLangString = paramapce.jdField_a_of_type_JavaLangString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = paramapce.c;
    localbdvs.d = 1;
    localbdvs.jdField_a_of_type_Bdvv = jdField_a_of_type_Bdvv;
    paramapce.jdField_a_of_type_Bdvs = localbdvs;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramapce);
        switch (bgnt.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new apcb(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramapce.b, (beav)localObject1, localbdvs, paramapce, paramapcd);
          this.jdField_a_of_type_Beaw.a(10065, "prd", paramapce.b, 0, paramapce.jdField_a_of_type_JavaLangString, localbdvs.c, i, 0, false, (beat)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramapce.b, paramapcd);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramapce.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     apby
 * JD-Core Version:    0.7.0.1
 */