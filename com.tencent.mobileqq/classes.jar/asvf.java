import com.tencent.qphone.base.util.QLog;

class asvf
  extends auoo
{
  asvf(asuw paramasuw, String paramString, asur paramasur) {}
  
  public void a(int paramInt, aunw paramaunw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramaunw != null)
    {
      str1 = str2;
      i = j;
      if (paramaunw.a != null)
      {
        i = paramaunw.a.a;
        str1 = paramaunw.a.b;
      }
    }
    asuw.a(this.jdField_a_of_type_Asuw, this.jdField_a_of_type_Asur, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    asuw.a(this.jdField_a_of_type_Asuw, this.jdField_a_of_type_Asur, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvf
 * JD-Core Version:    0.7.0.1
 */