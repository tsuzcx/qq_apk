import com.tencent.qphone.base.util.QLog;

final class bnld
  implements bapx
{
  bnld(String paramString1, String paramString2, bnle parambnle) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bnlc.b(), 2, "onResp resultcode: " + parambaqw.c + " threadid=" + Thread.currentThread().getId());
    }
    if ((parambaqw.c == 200) && (bnlc.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_Bnle != null) {
        this.jdField_a_of_type_Bnle.a();
      }
    }
    while (this.jdField_a_of_type_Bnle == null) {
      return;
    }
    this.jdField_a_of_type_Bnle.b();
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bnle != null) {
      this.jdField_a_of_type_Bnle.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnld
 * JD-Core Version:    0.7.0.1
 */