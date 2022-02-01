import com.tencent.qphone.base.util.QLog;

class apjn
  implements appt
{
  apjn(apjm paramapjm, String paramString, appt paramappt) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Appt != null) {
      this.jdField_a_of_type_Appt.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Appt != null) {
      this.jdField_a_of_type_Appt.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, appu paramappu)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramappu.d + ", filename = " + paramappu.c + ", url = " + paramappu.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!apjm.a(this.jdField_a_of_type_Apjm, paramappu.c, paramappu.b))
      {
        apjm.a(this.jdField_a_of_type_Apjm, paramappu.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Appt == null)
    {
      return;
      if ((!paramappu.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Apjm.a(paramappu.d, paramappu.c, paramappu.b) != 0)) {}
    }
    this.jdField_a_of_type_Appt.a(paramBoolean, paramappu);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Appt != null) {
      this.jdField_a_of_type_Appt.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjn
 * JD-Core Version:    0.7.0.1
 */