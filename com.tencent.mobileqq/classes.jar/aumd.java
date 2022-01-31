import com.tencent.qphone.base.util.QLog;

class aumd
  extends azai
{
  aumd(ault paramault, String paramString, aulo paramaulo) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aulo.a != null)
    {
      String str = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Aulo.a.a);
      aulp localaulp = this.jdField_a_of_type_Ault.a(str);
      if ((localaulp != null) && (!localaulp.a))
      {
        localaulp.c = (paramInt / 100);
        this.jdField_a_of_type_Ault.a(str, localaulp);
        ault.a(this.jdField_a_of_type_Ault, localaulp, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, azaa paramazaa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramazaa != null)
    {
      str1 = str2;
      i = j;
      if (paramazaa.a != null)
      {
        i = paramazaa.a.a;
        str1 = paramazaa.a.b;
      }
    }
    this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Aulo, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aumd
 * JD-Core Version:    0.7.0.1
 */