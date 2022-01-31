import com.tencent.qphone.base.util.QLog;

final class bkzc
  implements aysa
{
  bkzc(String paramString1, String paramString2, bkzd parambkzd) {}
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bkzb.b(), 2, "onResp resultcode: " + paramaysx.c + " threadid=" + Thread.currentThread().getId());
    }
    if ((paramaysx.c == 200) && (bkzb.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_Bkzd != null) {
        this.jdField_a_of_type_Bkzd.a();
      }
    }
    while (this.jdField_a_of_type_Bkzd == null) {
      return;
    }
    this.jdField_a_of_type_Bkzd.b();
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bkzd != null) {
      this.jdField_a_of_type_Bkzd.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzc
 * JD-Core Version:    0.7.0.1
 */