import com.tencent.qphone.base.util.QLog;

class awdr
  extends ayem
{
  awdr(awdi paramawdi, String paramString, awdd paramawdd) {}
  
  public void a(int paramInt, aydt paramaydt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramaydt != null)
    {
      str1 = str2;
      i = j;
      if (paramaydt.a != null)
      {
        i = paramaydt.a.a;
        str1 = paramaydt.a.b;
      }
    }
    awdi.a(this.jdField_a_of_type_Awdi, this.jdField_a_of_type_Awdd, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    awdi.a(this.jdField_a_of_type_Awdi, this.jdField_a_of_type_Awdd, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdr
 * JD-Core Version:    0.7.0.1
 */