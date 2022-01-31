import com.tencent.qphone.base.util.QLog;

class baav
  extends bbwt
{
  baav(baas parambaas, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + parambbwu.c + " code = " + parambbwu.jdField_a_of_type_Int);
    }
    boolean bool = baas.a(this.jdField_a_of_type_Baas, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    baas.b(this.jdField_a_of_type_Baas);
  }
  
  public void onProgress(bbwu parambbwu)
  {
    int i = (int)(parambbwu.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baav
 * JD-Core Version:    0.7.0.1
 */