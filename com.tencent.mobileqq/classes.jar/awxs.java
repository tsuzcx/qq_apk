import com.tencent.qphone.base.util.QLog;

class awxs
  extends bcfr
{
  awxs(awxi paramawxi, String paramString, awxd paramawxd) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Awxd.a != null)
    {
      String str = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Awxd.a.a);
      awxe localawxe = this.jdField_a_of_type_Awxi.a(str);
      if ((localawxe != null) && (!localawxe.a))
      {
        localawxe.c = (paramInt / 100);
        this.jdField_a_of_type_Awxi.a(str, localawxe);
        awxi.a(this.jdField_a_of_type_Awxi, localawxe, paramInt / 100);
      }
    }
  }
  
  public void a(int paramInt, bcfj parambcfj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (parambcfj != null)
    {
      str1 = str2;
      i = j;
      if (parambcfj.a != null)
      {
        i = parambcfj.a.a;
        str1 = parambcfj.a.b;
      }
    }
    this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Awxd, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxs
 * JD-Core Version:    0.7.0.1
 */