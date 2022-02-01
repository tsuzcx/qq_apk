import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aszr
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
      aszs localaszs = new aszs();
      localaszs.jdField_b_of_type_JavaLangString = paramString;
      localaszs.jdField_a_of_type_JavaLangString = paramString;
      if (localaszs.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bcef.b((QQAppInterface)localObject, "CliOper", "", "", localaszs.jdField_a_of_type_JavaLangString, localaszs.jdField_b_of_type_JavaLangString, localaszs.jdField_a_of_type_Int, localaszs.jdField_b_of_type_Int, i, String.valueOf(localaszs.jdField_b_of_type_Long), localaszs.d, aszs.a(localaszs), localaszs.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, aszs paramaszs)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramaszs.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        bcef.b(paramString, "CliOper", "", "", paramaszs.jdField_a_of_type_JavaLangString, paramaszs.jdField_b_of_type_JavaLangString, paramaszs.jdField_a_of_type_Int, paramaszs.jdField_b_of_type_Int, i, String.valueOf(paramaszs.jdField_b_of_type_Long), paramaszs.d, aszs.a(paramaszs), paramaszs.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszr
 * JD-Core Version:    0.7.0.1
 */