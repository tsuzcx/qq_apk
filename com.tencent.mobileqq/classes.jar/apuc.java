import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apuc
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
      apud localapud = new apud();
      localapud.jdField_b_of_type_JavaLangString = paramString;
      localapud.jdField_a_of_type_JavaLangString = paramString;
      if (localapud.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        axqw.b((QQAppInterface)localObject, "CliOper", "", "", localapud.jdField_a_of_type_JavaLangString, localapud.jdField_b_of_type_JavaLangString, localapud.jdField_a_of_type_Int, localapud.jdField_b_of_type_Int, i, String.valueOf(localapud.jdField_b_of_type_Long), localapud.d, apud.a(localapud), localapud.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, apud paramapud)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramapud.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        axqw.b(paramString, "CliOper", "", "", paramapud.jdField_a_of_type_JavaLangString, paramapud.jdField_b_of_type_JavaLangString, paramapud.jdField_a_of_type_Int, paramapud.jdField_b_of_type_Int, i, String.valueOf(paramapud.jdField_b_of_type_Long), paramapud.d, apud.a(paramapud), paramapud.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apuc
 * JD-Core Version:    0.7.0.1
 */