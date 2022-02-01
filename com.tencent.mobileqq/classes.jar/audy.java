import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class audy
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
      audz localaudz = new audz();
      localaudz.jdField_b_of_type_JavaLangString = paramString;
      localaudz.jdField_a_of_type_JavaLangString = paramString;
      if (localaudz.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bdla.b((QQAppInterface)localObject, "CliOper", "", "", localaudz.jdField_a_of_type_JavaLangString, localaudz.jdField_b_of_type_JavaLangString, localaudz.jdField_a_of_type_Int, localaudz.jdField_b_of_type_Int, i, String.valueOf(localaudz.jdField_b_of_type_Long), localaudz.d, audz.a(localaudz), localaudz.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, audz paramaudz)
  {
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramaudz.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bdla.b(paramString, "CliOper", "", "", paramaudz.jdField_a_of_type_JavaLangString, paramaudz.jdField_b_of_type_JavaLangString, paramaudz.jdField_a_of_type_Int, paramaudz.jdField_b_of_type_Int, i, String.valueOf(paramaudz.jdField_b_of_type_Long), paramaudz.d, audz.a(paramaudz), paramaudz.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audy
 * JD-Core Version:    0.7.0.1
 */