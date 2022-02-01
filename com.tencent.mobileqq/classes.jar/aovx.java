import com.tencent.qphone.base.util.QLog;

class aovx
  implements apcd
{
  aovx(aovw paramaovw, String paramString, apcd paramapcd) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Apcd != null) {
      this.jdField_a_of_type_Apcd.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Apcd != null) {
      this.jdField_a_of_type_Apcd.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, apce paramapce)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramapce.d + ", filename = " + paramapce.c + ", url = " + paramapce.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!aovw.a(this.jdField_a_of_type_Aovw, paramapce.c, paramapce.b))
      {
        aovw.a(this.jdField_a_of_type_Aovw, paramapce.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Apcd == null)
    {
      return;
      if ((!paramapce.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Aovw.a(paramapce.d, paramapce.c, paramapce.b) != 0)) {}
    }
    this.jdField_a_of_type_Apcd.a(paramBoolean, paramapce);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apcd != null) {
      this.jdField_a_of_type_Apcd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovx
 * JD-Core Version:    0.7.0.1
 */