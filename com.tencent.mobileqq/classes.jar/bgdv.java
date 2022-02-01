import com.tencent.qphone.base.util.QLog;

class bgdv
  extends biht
{
  bgdv(bgds parambgds, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + parambihu.c + " code = " + parambihu.jdField_a_of_type_Int);
    }
    boolean bool = bgds.a(this.jdField_a_of_type_Bgds, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    bgds.b(this.jdField_a_of_type_Bgds);
  }
  
  public void onProgress(bihu parambihu)
  {
    int i = (int)(parambihu.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdv
 * JD-Core Version:    0.7.0.1
 */