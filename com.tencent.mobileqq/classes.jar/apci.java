import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apci
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
      apcj localapcj = new apcj();
      localapcj.jdField_b_of_type_JavaLangString = paramString;
      localapcj.jdField_a_of_type_JavaLangString = paramString;
      if (localapcj.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        awqx.b((QQAppInterface)localObject, "CliOper", "", "", localapcj.jdField_a_of_type_JavaLangString, localapcj.jdField_b_of_type_JavaLangString, localapcj.jdField_a_of_type_Int, localapcj.jdField_b_of_type_Int, i, String.valueOf(localapcj.jdField_b_of_type_Long), localapcj.d, apcj.a(localapcj), localapcj.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, apcj paramapcj)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramapcj.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        awqx.b(paramString, "CliOper", "", "", paramapcj.jdField_a_of_type_JavaLangString, paramapcj.jdField_b_of_type_JavaLangString, paramapcj.jdField_a_of_type_Int, paramapcj.jdField_b_of_type_Int, i, String.valueOf(paramapcj.jdField_b_of_type_Long), paramapcj.d, apcj.a(paramapcj), paramapcj.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apci
 * JD-Core Version:    0.7.0.1
 */