import com.tencent.qphone.base.util.QLog;

class aokd
  extends aodi
{
  private final aoee jdField_a_of_type_Aoee;
  
  public aokd(aokb paramaokb, aoee paramaoee)
  {
    this.jdField_a_of_type_Aoee = paramaoee;
  }
  
  public void a()
  {
    aokb.a(this.jdField_a_of_type_Aokb, true);
    aokb.b(this.jdField_a_of_type_Aokb, false);
    boolean bool = this.jdField_a_of_type_Aoee.c();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    this.jdField_a_of_type_Aokb.a();
    this.jdField_a_of_type_Aokb.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aokd
 * JD-Core Version:    0.7.0.1
 */