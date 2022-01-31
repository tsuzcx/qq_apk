import com.tencent.qphone.base.util.QLog;

final class bkzt
  implements aysc
{
  bkzt(String paramString1, String paramString2, bkzu parambkzu) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bkzs.b(), 2, "onResp resultcode: " + paramaysz.c + " threadid=" + Thread.currentThread().getId());
    }
    if ((paramaysz.c == 200) && (bkzs.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_Bkzu != null) {
        this.jdField_a_of_type_Bkzu.a();
      }
    }
    while (this.jdField_a_of_type_Bkzu == null) {
      return;
    }
    this.jdField_a_of_type_Bkzu.b();
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bkzu != null) {
      this.jdField_a_of_type_Bkzu.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzt
 * JD-Core Version:    0.7.0.1
 */