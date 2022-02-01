import com.tencent.qphone.base.util.QLog;

class apqq
  extends apjv
{
  private final apkr jdField_a_of_type_Apkr;
  
  public apqq(apqo paramapqo, apkr paramapkr)
  {
    this.jdField_a_of_type_Apkr = paramapkr;
  }
  
  public void a()
  {
    apqo.a(this.jdField_a_of_type_Apqo, true);
    apqo.b(this.jdField_a_of_type_Apqo, false);
    boolean bool = this.jdField_a_of_type_Apkr.c();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    this.jdField_a_of_type_Apqo.a();
    this.jdField_a_of_type_Apqo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqq
 * JD-Core Version:    0.7.0.1
 */