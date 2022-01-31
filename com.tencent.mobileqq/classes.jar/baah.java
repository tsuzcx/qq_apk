import com.tencent.qphone.base.util.QLog;

class baah
  extends bbwf
{
  baah(baae parambaae, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + parambbwg.c + " code = " + parambbwg.jdField_a_of_type_Int);
    }
    boolean bool = baae.a(this.jdField_a_of_type_Baae, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    baae.b(this.jdField_a_of_type_Baae);
  }
  
  public void onProgress(bbwg parambbwg)
  {
    int i = (int)(parambbwg.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baah
 * JD-Core Version:    0.7.0.1
 */