import com.tencent.mobileqq.app.QQAppInterface;

public class bakh
{
  public static bakh a;
  public ajta a;
  public QQAppInterface a;
  
  public bakh()
  {
    this.jdField_a_of_type_Ajta = new baki(this);
  }
  
  public static bakh a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bakh == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Bakh;
      if (jdField_a_of_type_Bakh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Bakh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          jdField_a_of_type_Bakh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Bakh.jdField_a_of_type_Ajta);
        }
        jdField_a_of_type_Bakh = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_Bakh != null) && (jdField_a_of_type_Bakh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bakh.jdField_a_of_type_Ajta);
      jdField_a_of_type_Bakh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bakh = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bakh = new bakh();
    jdField_a_of_type_Bakh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bakh.jdField_a_of_type_Ajta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bakh
 * JD-Core Version:    0.7.0.1
 */