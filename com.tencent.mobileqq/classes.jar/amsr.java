import com.tencent.qphone.base.util.QLog;

class amsr
  implements amzd
{
  amsr(amsq paramamsq, String paramString, amzd paramamzd) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Amzd != null) {
      this.jdField_a_of_type_Amzd.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Amzd != null) {
      this.jdField_a_of_type_Amzd.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, amze paramamze)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramamze.d + ", filename = " + paramamze.c + ", url = " + paramamze.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!amsq.a(this.jdField_a_of_type_Amsq, paramamze.c, paramamze.b))
      {
        amsq.a(this.jdField_a_of_type_Amsq, paramamze.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Amzd == null)
    {
      return;
      if ((!paramamze.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Amsq.a(paramamze.d, paramamze.c, paramamze.b) != 0)) {}
    }
    this.jdField_a_of_type_Amzd.a(paramBoolean, paramamze);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amzd != null) {
      this.jdField_a_of_type_Amzd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsr
 * JD-Core Version:    0.7.0.1
 */