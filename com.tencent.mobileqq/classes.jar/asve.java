import com.tencent.qphone.base.util.QLog;

class asve
  extends axfa
{
  asve(asuu paramasuu, String paramString, asup paramasup) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Asup.a != null)
    {
      String str = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Asup.a.a);
      asuq localasuq = this.jdField_a_of_type_Asuu.a(str);
      if ((localasuq != null) && (!localasuq.a))
      {
        localasuq.c = (paramInt / 100);
        this.jdField_a_of_type_Asuu.a(str, localasuq);
        asuu.a(this.jdField_a_of_type_Asuu, localasuq, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, axes paramaxes)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramaxes != null)
    {
      str1 = str2;
      i = j;
      if (paramaxes.a != null)
      {
        i = paramaxes.a.a;
        str1 = paramaxes.a.b;
      }
    }
    this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Asup, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asve
 * JD-Core Version:    0.7.0.1
 */