import com.tencent.qphone.base.util.QLog;

class bibx
  implements nuw
{
  bibx(bibu parambibu, long paramLong1, String paramString1, long paramLong2, String paramString2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid loaded,code:" + paramInt + ",cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("280")) {
      this.jdField_a_of_type_Bibu.a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
    }
    if ((paramInt == 0) || (8 == paramInt) || (5 == paramInt)) {
      if (this.jdField_a_of_type_Bibu.a(2L, this.jdField_b_of_type_Long)) {
        this.jdField_a_of_type_Bibu.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long);
      }
    }
    while ((!this.jdField_a_of_type_Bibu.a(5L, this.jdField_b_of_type_Long)) || (this.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    this.jdField_a_of_type_Bibu.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid progress:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibx
 * JD-Core Version:    0.7.0.1
 */