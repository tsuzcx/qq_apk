import com.tencent.mobileqq.app.QQAppInterface;

public class bgsi
{
  public static bgsi a;
  public anua a;
  public QQAppInterface a;
  
  public bgsi()
  {
    this.jdField_a_of_type_Anua = new bgsj(this);
  }
  
  public static bgsi a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bgsi == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Bgsi;
      if (jdField_a_of_type_Bgsi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Bgsi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          jdField_a_of_type_Bgsi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Bgsi.jdField_a_of_type_Anua);
          jdField_a_of_type_Bgsi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        }
        jdField_a_of_type_Bgsi = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_Bgsi != null) && (jdField_a_of_type_Bgsi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bgsi.jdField_a_of_type_Anua);
      jdField_a_of_type_Bgsi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bgsi = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bgsi = new bgsi();
    jdField_a_of_type_Bgsi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bgsi.jdField_a_of_type_Anua);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgsi
 * JD-Core Version:    0.7.0.1
 */