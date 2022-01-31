import com.tencent.mobileqq.app.QQAppInterface;

public class azje
{
  public static azje a;
  public ajey a;
  public QQAppInterface a;
  
  public azje()
  {
    this.jdField_a_of_type_Ajey = new azjf(this);
  }
  
  public static azje a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Azje == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Azje;
      if (jdField_a_of_type_Azje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Azje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          jdField_a_of_type_Azje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Azje.jdField_a_of_type_Ajey);
        }
        jdField_a_of_type_Azje = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_Azje != null) && (jdField_a_of_type_Azje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Azje.jdField_a_of_type_Ajey);
      jdField_a_of_type_Azje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Azje = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Azje = new azje();
    jdField_a_of_type_Azje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Azje.jdField_a_of_type_Ajey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azje
 * JD-Core Version:    0.7.0.1
 */