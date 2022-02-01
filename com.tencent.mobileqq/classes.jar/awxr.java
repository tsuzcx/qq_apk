import com.tencent.qphone.base.util.QLog;

class awxr
  extends ayyr
{
  awxr(awxi paramawxi, String paramString, awxd paramawxd) {}
  
  public void a(int paramInt, ayxy paramayxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramayxy != null)
    {
      str1 = str2;
      i = j;
      if (paramayxy.a != null)
      {
        i = paramayxy.a.a;
        str1 = paramayxy.a.b;
      }
    }
    awxi.a(this.jdField_a_of_type_Awxi, this.jdField_a_of_type_Awxd, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    awxi.a(this.jdField_a_of_type_Awxi, this.jdField_a_of_type_Awxd, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxr
 * JD-Core Version:    0.7.0.1
 */