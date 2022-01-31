import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apue
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
      apuf localapuf = new apuf();
      localapuf.jdField_b_of_type_JavaLangString = paramString;
      localapuf.jdField_a_of_type_JavaLangString = paramString;
      if (localapuf.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        axqy.b((QQAppInterface)localObject, "CliOper", "", "", localapuf.jdField_a_of_type_JavaLangString, localapuf.jdField_b_of_type_JavaLangString, localapuf.jdField_a_of_type_Int, localapuf.jdField_b_of_type_Int, i, String.valueOf(localapuf.jdField_b_of_type_Long), localapuf.d, apuf.a(localapuf), localapuf.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, apuf paramapuf)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramapuf.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        axqy.b(paramString, "CliOper", "", "", paramapuf.jdField_a_of_type_JavaLangString, paramapuf.jdField_b_of_type_JavaLangString, paramapuf.jdField_a_of_type_Int, paramapuf.jdField_b_of_type_Int, i, String.valueOf(paramapuf.jdField_b_of_type_Long), paramapuf.d, apuf.a(paramapuf), paramapuf.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apue
 * JD-Core Version:    0.7.0.1
 */