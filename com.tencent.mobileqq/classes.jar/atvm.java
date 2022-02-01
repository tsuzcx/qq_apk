import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atvm
{
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      atvn localatvn = new atvn();
      localatvn.jdField_b_of_type_JavaLangString = paramString;
      localatvn.jdField_a_of_type_JavaLangString = paramString;
      if (localatvn.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bcst.b((QQAppInterface)localObject, "CliOper", "", "", localatvn.jdField_a_of_type_JavaLangString, localatvn.jdField_b_of_type_JavaLangString, localatvn.jdField_a_of_type_Int, localatvn.jdField_b_of_type_Int, i, String.valueOf(localatvn.jdField_b_of_type_Long), localatvn.d, atvn.a(localatvn), localatvn.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, atvn paramatvn)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramatvn.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bcst.b(paramString, "CliOper", "", "", paramatvn.jdField_a_of_type_JavaLangString, paramatvn.jdField_b_of_type_JavaLangString, paramatvn.jdField_a_of_type_Int, paramatvn.jdField_b_of_type_Int, i, String.valueOf(paramatvn.jdField_b_of_type_Long), paramatvn.d, atvn.a(paramatvn), paramatvn.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvm
 * JD-Core Version:    0.7.0.1
 */