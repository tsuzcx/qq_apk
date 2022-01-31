import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class asxl
  implements Manager
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "data.json", "icon_close.png" };
  asxr jdField_a_of_type_Asxr;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public asxl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Asxr = new asxr();
  }
  
  public static asxl a(QQAppInterface paramQQAppInterface)
  {
    return (asxl)paramQQAppInterface.getManager(345);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return asxr.a(paramString1, paramString2) + "/";
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a(paramString1, paramString2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "checkDownloadCartoonResource download url:" + paramString1 + " md5:" + paramString2);
    }
    this.jdField_a_of_type_Asxr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10089, "prd", paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString, null);
  }
  
  public void a(String paramString1, String paramString2, asxw paramasxw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "prepareCartoonResources url:" + paramString1 + " md5:" + paramString2);
    }
    this.jdField_a_of_type_Asxr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10089, "prd", paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString, paramasxw);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = asxr.a(paramString1, paramString2, jdField_a_of_type_ArrayOfJavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "isCartoonResourceReady url:" + paramString1 + " md5:" + paramString2 + " res:" + bool);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Asxr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxl
 * JD-Core Version:    0.7.0.1
 */