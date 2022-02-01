import com.tencent.qphone.base.util.QLog;

final class bqgg
  implements bdvw
{
  bqgg(String paramString1, String paramString2, bqgh parambqgh) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bqgf.b(), 2, "onResp resultcode: " + parambdwt.c + " threadid=" + Thread.currentThread().getId());
    }
    if ((parambdwt.c == 200) && (bqgf.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_Bqgh != null) {
        this.jdField_a_of_type_Bqgh.a();
      }
    }
    while (this.jdField_a_of_type_Bqgh == null) {
      return;
    }
    this.jdField_a_of_type_Bqgh.b();
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bqgh != null) {
      this.jdField_a_of_type_Bqgh.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgg
 * JD-Core Version:    0.7.0.1
 */