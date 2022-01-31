import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class asbf
  implements Manager
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "data.json", "icon_close.png" };
  asbl jdField_a_of_type_Asbl;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public asbf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Asbl = new asbl();
  }
  
  public static asbf a(QQAppInterface paramQQAppInterface)
  {
    return (asbf)paramQQAppInterface.getManager(345);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return asbl.a(paramString1, paramString2) + "/";
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a(paramString1, paramString2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "checkDownloadCartoonResource download url:" + paramString1 + " md5:" + paramString2);
    }
    this.jdField_a_of_type_Asbl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10089, "prd", paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString, null);
  }
  
  public void a(String paramString1, String paramString2, asbq paramasbq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "prepareCartoonResources url:" + paramString1 + " md5:" + paramString2);
    }
    this.jdField_a_of_type_Asbl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10089, "prd", paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString, paramasbq);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = asbl.a(paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "isCartoonResourceReady url:" + paramString1 + " md5:" + paramString2 + " res:" + bool);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Asbl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asbf
 * JD-Core Version:    0.7.0.1
 */