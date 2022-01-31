import com.tencent.qphone.base.util.QLog;

final class bjir
  implements axrt
{
  bjir(String paramString1, String paramString2, bjis parambjis) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bjiq.b(), 2, "onResp resultcode: " + paramaxsq.c + " threadid=" + Thread.currentThread().getId());
    }
    if ((paramaxsq.c == 200) && (bjiq.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_Bjis != null) {
        this.jdField_a_of_type_Bjis.a();
      }
    }
    while (this.jdField_a_of_type_Bjis == null) {
      return;
    }
    this.jdField_a_of_type_Bjis.b();
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bjis != null) {
      this.jdField_a_of_type_Bjis.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjir
 * JD-Core Version:    0.7.0.1
 */