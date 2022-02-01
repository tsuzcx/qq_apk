import com.tencent.mobileqq.app.QQAppInterface;

public class ausd
  extends atvf
{
  atpa jdField_a_of_type_Atpa = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public ausd(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    b();
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atpa != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_JavaLangString, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atpa = new ause(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausd
 * JD-Core Version:    0.7.0.1
 */