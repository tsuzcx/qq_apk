import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class appo
{
  protected static beup a;
  private beuo jdField_a_of_type_Beuo;
  private bezv jdField_a_of_type_Bezv;
  public QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<appu> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, appt> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_Beup = new apps();
  }
  
  public appo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Beuo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bezv = ((bezv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(appu paramappu, appt paramappt)
  {
    if ((paramappu == null) || (paramappt == null)) {
      return false;
    }
    Object localObject1 = new appp(this, paramappu);
    ??? = new appq(this);
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = ((beuq)???);
    localbeum.jdField_a_of_type_JavaLangString = paramappu.jdField_a_of_type_JavaLangString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = paramappu.c;
    localbeum.d = 1;
    localbeum.jdField_a_of_type_Beup = jdField_a_of_type_Beup;
    paramappu.jdField_a_of_type_Beum = localbeum;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramappu);
        switch (bhnv.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new appr(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramappu.b, (bezu)localObject1, localbeum, paramappu, paramappt);
          this.jdField_a_of_type_Bezv.a(10065, "prd", paramappu.b, 0, paramappu.jdField_a_of_type_JavaLangString, localbeum.c, i, 0, false, (bezs)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramappu.b, paramappt);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramappu.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     appo
 * JD-Core Version:    0.7.0.1
 */