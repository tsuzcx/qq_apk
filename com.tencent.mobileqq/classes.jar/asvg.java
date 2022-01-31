import com.tencent.qphone.base.util.QLog;

class asvg
  extends axfc
{
  asvg(asuw paramasuw, String paramString, asur paramasur) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Asur.a != null)
    {
      String str = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asur.a.a);
      asus localasus = this.jdField_a_of_type_Asuw.a(str);
      if ((localasus != null) && (!localasus.a))
      {
        localasus.c = (paramInt / 100);
        this.jdField_a_of_type_Asuw.a(str, localasus);
        asuw.a(this.jdField_a_of_type_Asuw, localasus, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, axeu paramaxeu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramaxeu != null)
    {
      str1 = str2;
      i = j;
      if (paramaxeu.a != null)
      {
        i = paramaxeu.a.a;
        str1 = paramaxeu.a.b;
      }
    }
    this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asur, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvg
 * JD-Core Version:    0.7.0.1
 */