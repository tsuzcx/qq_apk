import com.tencent.qphone.base.util.QLog;

class axql
  extends bcyj
{
  axql(axqb paramaxqb, String paramString, axpw paramaxpw) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Axpw.a != null)
    {
      String str = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axpw.a.a);
      axpx localaxpx = this.jdField_a_of_type_Axqb.a(str);
      if ((localaxpx != null) && (!localaxpx.a))
      {
        localaxpx.c = (paramInt / 100);
        this.jdField_a_of_type_Axqb.a(str, localaxpx);
        axqb.a(this.jdField_a_of_type_Axqb, localaxpx, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, bcyb parambcyb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (parambcyb != null)
    {
      str1 = str2;
      i = j;
      if (parambcyb.a != null)
      {
        i = parambcyb.a.a;
        str1 = parambcyb.a.b;
      }
    }
    this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axpw, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axql
 * JD-Core Version:    0.7.0.1
 */