import com.tencent.mobileqq.app.QQAppInterface;

public class bfbw
{
  public static bfbw a;
  public amop a;
  public QQAppInterface a;
  
  public bfbw()
  {
    this.jdField_a_of_type_Amop = new bfbx(this);
  }
  
  public static bfbw a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bfbw == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_Bfbw;
      if (jdField_a_of_type_Bfbw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_Bfbw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          jdField_a_of_type_Bfbw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_Bfbw.jdField_a_of_type_Amop);
          jdField_a_of_type_Bfbw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        }
        jdField_a_of_type_Bfbw = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bfbw != null)
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bfbw.jdField_a_of_type_Amop);
      jdField_a_of_type_Bfbw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bfbw = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bfbw = new bfbw();
    jdField_a_of_type_Bfbw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bfbw.jdField_a_of_type_Amop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbw
 * JD-Core Version:    0.7.0.1
 */