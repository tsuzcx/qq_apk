import com.tencent.qphone.base.util.QLog;

class bcdn
  extends bead
{
  bcdn(bcdk parambcdk, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + parambeae.c + " code = " + parambeae.jdField_a_of_type_Int);
    }
    boolean bool = bcdk.a(this.jdField_a_of_type_Bcdk, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    bcdk.b(this.jdField_a_of_type_Bcdk);
  }
  
  public void onProgress(beae parambeae)
  {
    int i = (int)(parambeae.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdn
 * JD-Core Version:    0.7.0.1
 */