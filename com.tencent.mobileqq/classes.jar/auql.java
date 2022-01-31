import com.tencent.qphone.base.util.QLog;

class auql
  extends awkf
{
  auql(auqc paramauqc, String paramString, aupx paramaupx) {}
  
  public void a(int paramInt, awjm paramawjm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramawjm != null)
    {
      str1 = str2;
      i = j;
      if (paramawjm.a != null)
      {
        i = paramawjm.a.a;
        str1 = paramawjm.a.b;
      }
    }
    auqc.a(this.jdField_a_of_type_Auqc, this.jdField_a_of_type_Aupx, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    auqc.a(this.jdField_a_of_type_Auqc, this.jdField_a_of_type_Aupx, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auql
 * JD-Core Version:    0.7.0.1
 */