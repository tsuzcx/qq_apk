import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arrp
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
      arrq localarrq = new arrq();
      localarrq.jdField_b_of_type_JavaLangString = paramString;
      localarrq.jdField_a_of_type_JavaLangString = paramString;
      if (localarrq.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        azqs.b((QQAppInterface)localObject, "CliOper", "", "", localarrq.jdField_a_of_type_JavaLangString, localarrq.jdField_b_of_type_JavaLangString, localarrq.jdField_a_of_type_Int, localarrq.jdField_b_of_type_Int, i, String.valueOf(localarrq.jdField_b_of_type_Long), localarrq.d, arrq.a(localarrq), localarrq.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, arrq paramarrq)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramarrq.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        azqs.b(paramString, "CliOper", "", "", paramarrq.jdField_a_of_type_JavaLangString, paramarrq.jdField_b_of_type_JavaLangString, paramarrq.jdField_a_of_type_Int, paramarrq.jdField_b_of_type_Int, i, String.valueOf(paramarrq.jdField_b_of_type_Long), paramarrq.d, arrq.a(paramarrq), paramarrq.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrp
 * JD-Core Version:    0.7.0.1
 */