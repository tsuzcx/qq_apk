import com.tencent.qphone.base.util.QLog;

class apda
  extends aowf
{
  private final aoxb jdField_a_of_type_Aoxb;
  
  public apda(apcy paramapcy, aoxb paramaoxb)
  {
    this.jdField_a_of_type_Aoxb = paramaoxb;
  }
  
  public void a()
  {
    apcy.a(this.jdField_a_of_type_Apcy, true);
    apcy.b(this.jdField_a_of_type_Apcy, false);
    boolean bool = this.jdField_a_of_type_Aoxb.c();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    this.jdField_a_of_type_Apcy.a();
    this.jdField_a_of_type_Apcy.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apda
 * JD-Core Version:    0.7.0.1
 */