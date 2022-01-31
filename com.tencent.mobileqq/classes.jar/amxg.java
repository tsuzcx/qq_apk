import com.tencent.qphone.base.util.QLog;

class amxg
  implements andm
{
  amxg(amxf paramamxf, String paramString, andm paramandm) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Andm != null) {
      this.jdField_a_of_type_Andm.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Andm != null) {
      this.jdField_a_of_type_Andm.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, andn paramandn)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramandn.d + ", filename = " + paramandn.c + ", url = " + paramandn.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!amxf.a(this.jdField_a_of_type_Amxf, paramandn.c, paramandn.b))
      {
        amxf.a(this.jdField_a_of_type_Amxf, paramandn.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Andm == null)
    {
      return;
      if ((!paramandn.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Amxf.a(paramandn.d, paramandn.c, paramandn.b) != 0)) {}
    }
    this.jdField_a_of_type_Andm.a(paramBoolean, paramandn);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Andm != null) {
      this.jdField_a_of_type_Andm.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxg
 * JD-Core Version:    0.7.0.1
 */