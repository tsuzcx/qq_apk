import com.tencent.qphone.base.util.QLog;

class auqm
  extends azer
{
  auqm(auqc paramauqc, String paramString, aupx paramaupx) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aupx.a != null)
    {
      String str = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Aupx.a.a);
      aupy localaupy = this.jdField_a_of_type_Auqc.a(str);
      if ((localaupy != null) && (!localaupy.a))
      {
        localaupy.c = (paramInt / 100);
        this.jdField_a_of_type_Auqc.a(str, localaupy);
        auqc.a(this.jdField_a_of_type_Auqc, localaupy, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, azej paramazej)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramazej != null)
    {
      str1 = str2;
      i = j;
      if (paramazej.a != null)
      {
        i = paramazej.a.a;
        str1 = paramazej.a.b;
      }
    }
    this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Aupx, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqm
 * JD-Core Version:    0.7.0.1
 */