import com.tencent.qphone.base.util.QLog;

class aoda
  implements aojg
{
  aoda(aocz paramaocz, String paramString, aojg paramaojg) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Aojg != null) {
      this.jdField_a_of_type_Aojg.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Aojg != null) {
      this.jdField_a_of_type_Aojg.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, aojh paramaojh)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramaojh.d + ", filename = " + paramaojh.c + ", url = " + paramaojh.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!aocz.a(this.jdField_a_of_type_Aocz, paramaojh.c, paramaojh.b))
      {
        aocz.a(this.jdField_a_of_type_Aocz, paramaojh.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Aojg == null)
    {
      return;
      if ((!paramaojh.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Aocz.a(paramaojh.d, paramaojh.c, paramaojh.b) != 0)) {}
    }
    this.jdField_a_of_type_Aojg.a(paramBoolean, paramaojh);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aojg != null) {
      this.jdField_a_of_type_Aojg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoda
 * JD-Core Version:    0.7.0.1
 */