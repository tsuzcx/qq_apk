import com.tencent.qphone.base.util.QLog;

class arza
  extends awfs
{
  arza(aryq paramaryq, String paramString, aryl paramaryl) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aryl.a != null)
    {
      String str = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryl.a.a);
      arym localarym = this.jdField_a_of_type_Aryq.a(str);
      if ((localarym != null) && (!localarym.a))
      {
        localarym.c = (paramInt / 100);
        this.jdField_a_of_type_Aryq.a(str, localarym);
        aryq.a(this.jdField_a_of_type_Aryq, localarym, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, awfk paramawfk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramawfk != null)
    {
      str1 = str2;
      i = j;
      if (paramawfk.a != null)
      {
        i = paramawfk.a.a;
        str1 = paramawfk.a.b;
      }
    }
    this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryl, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     arza
 * JD-Core Version:    0.7.0.1
 */