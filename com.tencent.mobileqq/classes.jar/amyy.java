import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class amyy
{
  protected static bapw a;
  private bapv jdField_a_of_type_Bapv;
  private bavr jdField_a_of_type_Bavr;
  public QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<amze> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, amzd> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_Bapw = new amzc();
  }
  
  public amyy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bapv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bavr = ((bavr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(amze paramamze, amzd paramamzd)
  {
    if ((paramamze == null) || (paramamzd == null)) {
      return false;
    }
    Object localObject1 = new amyz(this, paramamze);
    ??? = new amza(this);
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = ((bapx)???);
    localbaps.jdField_a_of_type_JavaLangString = paramamze.jdField_a_of_type_JavaLangString;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.c = paramamze.c;
    localbaps.e = 1;
    localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
    paramamze.jdField_a_of_type_Baps = localbaps;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramamze);
        switch (bdee.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new amzb(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramamze.b, (bavq)localObject1, localbaps, paramamze, paramamzd);
          this.jdField_a_of_type_Bavr.a(10065, "prd", paramamze.b, 0, paramamze.jdField_a_of_type_JavaLangString, localbaps.c, i, 0, false, (bavo)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramamze.b, paramamzd);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramamze.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     amyy
 * JD-Core Version:    0.7.0.1
 */