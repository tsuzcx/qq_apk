import com.tencent.mobileqq.app.QQAppInterface;

public class bcji
{
  public static bcji a;
  public alkl a;
  public QQAppInterface a;
  
  public bcji()
  {
    this.jdField_a_of_type_Alkl = new bcjj(this);
  }
  
  public static bcji a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bcji == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Bcji;
      if (jdField_a_of_type_Bcji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Bcji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          jdField_a_of_type_Bcji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Bcji.jdField_a_of_type_Alkl);
        }
        jdField_a_of_type_Bcji = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_Bcji != null) && (jdField_a_of_type_Bcji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bcji.jdField_a_of_type_Alkl);
      jdField_a_of_type_Bcji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bcji = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bcji = new bcji();
    jdField_a_of_type_Bcji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bcji.jdField_a_of_type_Alkl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcji
 * JD-Core Version:    0.7.0.1
 */