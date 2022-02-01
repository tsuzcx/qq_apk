import com.tencent.qphone.base.util.QLog;

class awds
  extends bbrs
{
  awds(awdi paramawdi, String paramString, awdd paramawdd) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Awdd.a != null)
    {
      String str = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Awdd.a.a);
      awde localawde = this.jdField_a_of_type_Awdi.a(str);
      if ((localawde != null) && (!localawde.a))
      {
        localawde.c = (paramInt / 100);
        this.jdField_a_of_type_Awdi.a(str, localawde);
        awdi.a(this.jdField_a_of_type_Awdi, localawde, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, bbrl parambbrl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (parambbrl != null)
    {
      str1 = str2;
      i = j;
      if (parambbrl.a != null)
      {
        i = parambbrl.a.a;
        str1 = parambbrl.a.b;
      }
    }
    this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Awdd, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awds
 * JD-Core Version:    0.7.0.1
 */