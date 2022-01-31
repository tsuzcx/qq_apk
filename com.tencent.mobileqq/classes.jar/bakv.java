import com.tencent.mobileqq.app.QQAppInterface;

public class bakv
{
  public static bakv a;
  public ajsy a;
  public QQAppInterface a;
  
  public bakv()
  {
    this.jdField_a_of_type_Ajsy = new bakw(this);
  }
  
  public static bakv a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bakv == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Bakv;
      if (jdField_a_of_type_Bakv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Bakv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          jdField_a_of_type_Bakv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Bakv.jdField_a_of_type_Ajsy);
        }
        jdField_a_of_type_Bakv = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_Bakv != null) && (jdField_a_of_type_Bakv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bakv.jdField_a_of_type_Ajsy);
      jdField_a_of_type_Bakv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bakv = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bakv = new bakv();
    jdField_a_of_type_Bakv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bakv.jdField_a_of_type_Ajsy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bakv
 * JD-Core Version:    0.7.0.1
 */