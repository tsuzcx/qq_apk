import com.tencent.qphone.base.util.QLog;

class bfug
  extends bhyn
{
  bfug(bfud parambfud, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + parambhyo.c + " code = " + parambhyo.jdField_a_of_type_Int);
    }
    boolean bool = bfud.a(this.jdField_a_of_type_Bfud, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    bfud.b(this.jdField_a_of_type_Bfud);
  }
  
  public void onProgress(bhyo parambhyo)
  {
    int i = (int)(parambhyo.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfug
 * JD-Core Version:    0.7.0.1
 */