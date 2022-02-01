import com.tencent.qphone.base.util.QLog;

class bend
  extends bgod
{
  bend(bena parambena, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + parambgoe.c + " code = " + parambgoe.jdField_a_of_type_Int);
    }
    boolean bool = bena.a(this.jdField_a_of_type_Bena, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    bena.b(this.jdField_a_of_type_Bena);
  }
  
  public void onProgress(bgoe parambgoe)
  {
    int i = (int)(parambgoe.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bend
 * JD-Core Version:    0.7.0.1
 */