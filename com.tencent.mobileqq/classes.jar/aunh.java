import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aunh
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
      auni localauni = new auni();
      localauni.jdField_b_of_type_JavaLangString = paramString;
      localauni.jdField_a_of_type_JavaLangString = paramString;
      if (localauni.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bdll.b((QQAppInterface)localObject, "CliOper", "", "", localauni.jdField_a_of_type_JavaLangString, localauni.jdField_b_of_type_JavaLangString, localauni.jdField_a_of_type_Int, localauni.jdField_b_of_type_Int, i, String.valueOf(localauni.jdField_b_of_type_Long), localauni.d, auni.a(localauni), localauni.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, auni paramauni)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramauni.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bdll.b(paramString, "CliOper", "", "", paramauni.jdField_a_of_type_JavaLangString, paramauni.jdField_b_of_type_JavaLangString, paramauni.jdField_a_of_type_Int, paramauni.jdField_b_of_type_Int, i, String.valueOf(paramauni.jdField_b_of_type_Long), paramauni.d, auni.a(paramauni), paramauni.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunh
 * JD-Core Version:    0.7.0.1
 */