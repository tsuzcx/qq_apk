import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arng
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
      arnh localarnh = new arnh();
      localarnh.jdField_b_of_type_JavaLangString = paramString;
      localarnh.jdField_a_of_type_JavaLangString = paramString;
      if (localarnh.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        azmj.b((QQAppInterface)localObject, "CliOper", "", "", localarnh.jdField_a_of_type_JavaLangString, localarnh.jdField_b_of_type_JavaLangString, localarnh.jdField_a_of_type_Int, localarnh.jdField_b_of_type_Int, i, String.valueOf(localarnh.jdField_b_of_type_Long), localarnh.d, arnh.a(localarnh), localarnh.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, arnh paramarnh)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramarnh.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        azmj.b(paramString, "CliOper", "", "", paramarnh.jdField_a_of_type_JavaLangString, paramarnh.jdField_b_of_type_JavaLangString, paramarnh.jdField_a_of_type_Int, paramarnh.jdField_b_of_type_Int, i, String.valueOf(paramarnh.jdField_b_of_type_Long), paramarnh.d, arnh.a(paramarnh), paramarnh.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arng
 * JD-Core Version:    0.7.0.1
 */