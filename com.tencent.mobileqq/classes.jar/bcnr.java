import com.tencent.mobileqq.app.QQAppInterface;

public class bcnr
{
  public static bcnr a;
  public alpa a;
  public QQAppInterface a;
  
  public bcnr()
  {
    this.jdField_a_of_type_Alpa = new bcns(this);
  }
  
  public static bcnr a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bcnr == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Bcnr;
      if (jdField_a_of_type_Bcnr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Bcnr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          jdField_a_of_type_Bcnr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Bcnr.jdField_a_of_type_Alpa);
        }
        jdField_a_of_type_Bcnr = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_Bcnr != null) && (jdField_a_of_type_Bcnr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bcnr.jdField_a_of_type_Alpa);
      jdField_a_of_type_Bcnr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bcnr = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bcnr = new bcnr();
    jdField_a_of_type_Bcnr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bcnr.jdField_a_of_type_Alpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnr
 * JD-Core Version:    0.7.0.1
 */