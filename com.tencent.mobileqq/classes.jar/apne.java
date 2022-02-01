import com.tencent.qphone.base.util.QLog;

class apne
  extends apgk
{
  private final aphg jdField_a_of_type_Aphg;
  
  public apne(apnc paramapnc, aphg paramaphg)
  {
    this.jdField_a_of_type_Aphg = paramaphg;
  }
  
  public void a()
  {
    apnc.a(this.jdField_a_of_type_Apnc, true);
    apnc.b(this.jdField_a_of_type_Apnc, false);
    boolean bool = this.jdField_a_of_type_Aphg.c();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    this.jdField_a_of_type_Apnc.a();
    this.jdField_a_of_type_Apnc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apne
 * JD-Core Version:    0.7.0.1
 */