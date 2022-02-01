import com.tencent.qphone.base.util.QLog;

class axjt
  extends azky
{
  axjt(axjk paramaxjk, String paramString, axjf paramaxjf) {}
  
  public void a(int paramInt, azkf paramazkf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramazkf != null)
    {
      str1 = str2;
      i = j;
      if (paramazkf.a != null)
      {
        i = paramazkf.a.a;
        str1 = paramazkf.a.b;
      }
    }
    axjk.a(this.jdField_a_of_type_Axjk, this.jdField_a_of_type_Axjf, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    axjk.a(this.jdField_a_of_type_Axjk, this.jdField_a_of_type_Axjf, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjt
 * JD-Core Version:    0.7.0.1
 */