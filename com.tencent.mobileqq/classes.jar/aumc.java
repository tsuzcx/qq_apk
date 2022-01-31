import com.tencent.qphone.base.util.QLog;

class aumc
  extends awfw
{
  aumc(ault paramault, String paramString, aulo paramaulo) {}
  
  public void a(int paramInt, awfd paramawfd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramawfd != null)
    {
      str1 = str2;
      i = j;
      if (paramawfd.a != null)
      {
        i = paramawfd.a.a;
        str1 = paramawfd.a.b;
      }
    }
    ault.a(this.jdField_a_of_type_Ault, this.jdField_a_of_type_Aulo, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    ault.a(this.jdField_a_of_type_Ault, this.jdField_a_of_type_Aulo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aumc
 * JD-Core Version:    0.7.0.1
 */