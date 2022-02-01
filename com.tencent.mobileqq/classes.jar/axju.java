import com.tencent.qphone.base.util.QLog;

class axju
  extends bcym
{
  axju(axjk paramaxjk, String paramString, axjf paramaxjf) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Axjf.a != null)
    {
      String str = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjf.a.a);
      axjg localaxjg = this.jdField_a_of_type_Axjk.a(str);
      if ((localaxjg != null) && (!localaxjg.a))
      {
        localaxjg.c = (paramInt / 100);
        this.jdField_a_of_type_Axjk.a(str, localaxjg);
        axjk.a(this.jdField_a_of_type_Axjk, localaxjg, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, bcyf parambcyf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (parambcyf != null)
    {
      str1 = str2;
      i = j;
      if (parambcyf.a != null)
      {
        i = parambcyf.a.a;
        str1 = parambcyf.a.b;
      }
    }
    this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjf, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axju
 * JD-Core Version:    0.7.0.1
 */