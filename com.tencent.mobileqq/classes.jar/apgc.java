import com.tencent.qphone.base.util.QLog;

class apgc
  implements apmi
{
  apgc(apgb paramapgb, String paramString, apmi paramapmi) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Apmi != null) {
      this.jdField_a_of_type_Apmi.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Apmi != null) {
      this.jdField_a_of_type_Apmi.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, apmj paramapmj)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramapmj.d + ", filename = " + paramapmj.c + ", url = " + paramapmj.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!apgb.a(this.jdField_a_of_type_Apgb, paramapmj.c, paramapmj.b))
      {
        apgb.a(this.jdField_a_of_type_Apgb, paramapmj.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Apmi == null)
    {
      return;
      if ((!paramapmj.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Apgb.a(paramapmj.d, paramapmj.c, paramapmj.b) != 0)) {}
    }
    this.jdField_a_of_type_Apmi.a(paramBoolean, paramapmj);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apmi != null) {
      this.jdField_a_of_type_Apmi.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgc
 * JD-Core Version:    0.7.0.1
 */