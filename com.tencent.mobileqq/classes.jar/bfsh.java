import com.tencent.mobileqq.app.QQAppInterface;

public class bfsh
{
  public static bfsh a;
  public anif a;
  public QQAppInterface a;
  
  public bfsh()
  {
    this.jdField_a_of_type_Anif = new bfsi(this);
  }
  
  public static bfsh a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bfsh == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Bfsh;
      if (jdField_a_of_type_Bfsh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Bfsh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          jdField_a_of_type_Bfsh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Bfsh.jdField_a_of_type_Anif);
          jdField_a_of_type_Bfsh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        }
        jdField_a_of_type_Bfsh = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_Bfsh != null) && (jdField_a_of_type_Bfsh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bfsh.jdField_a_of_type_Anif);
      jdField_a_of_type_Bfsh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bfsh = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bfsh = new bfsh();
    jdField_a_of_type_Bfsh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bfsh.jdField_a_of_type_Anif);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsh
 * JD-Core Version:    0.7.0.1
 */