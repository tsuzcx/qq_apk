import com.tencent.mobileqq.app.QQAppInterface;

public class apec
  extends aozw
{
  aoun jdField_a_of_type_Aoun = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public apec(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    a();
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aoun = new aped(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, this.b);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aoun != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aoun);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apec
 * JD-Core Version:    0.7.0.1
 */