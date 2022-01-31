import com.tencent.qphone.base.util.QLog;

class bbze
  extends bdvu
{
  bbze(bbzb parambbzb, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + parambdvv.c + " code = " + parambdvv.jdField_a_of_type_Int);
    }
    boolean bool = bbzb.a(this.jdField_a_of_type_Bbzb, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    bbzb.b(this.jdField_a_of_type_Bbzb);
  }
  
  public void onProgress(bdvv parambdvv)
  {
    int i = (int)(parambdvv.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbze
 * JD-Core Version:    0.7.0.1
 */