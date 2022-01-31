import com.tencent.qphone.base.util.QLog;

class asvd
  extends auom
{
  asvd(asuu paramasuu, String paramString, asup paramasup) {}
  
  public void a(int paramInt, aunu paramaunu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramaunu != null)
    {
      str1 = str2;
      i = j;
      if (paramaunu.a != null)
      {
        i = paramaunu.a.a;
        str1 = paramaunu.a.b;
      }
    }
    asuu.a(this.jdField_a_of_type_Asuu, this.jdField_a_of_type_Asup, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    asuu.a(this.jdField_a_of_type_Asuu, this.jdField_a_of_type_Asup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvd
 * JD-Core Version:    0.7.0.1
 */