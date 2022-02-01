import com.tencent.qphone.base.util.QLog;

class axqk
  extends azre
{
  axqk(axqb paramaxqb, String paramString, axpw paramaxpw) {}
  
  public void a(int paramInt, azql paramazql)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramazql != null)
    {
      str1 = str2;
      i = j;
      if (paramazql.a != null)
      {
        i = paramazql.a.a;
        str1 = paramazql.a.b;
      }
    }
    axqb.a(this.jdField_a_of_type_Axqb, this.jdField_a_of_type_Axpw, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    axqb.a(this.jdField_a_of_type_Axqb, this.jdField_a_of_type_Axpw, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqk
 * JD-Core Version:    0.7.0.1
 */