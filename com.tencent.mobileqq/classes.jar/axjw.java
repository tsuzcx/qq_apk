import com.tencent.qphone.base.util.QLog;

class axjw
  implements auck
{
  axjw(axjk paramaxjk, String paramString, axjf paramaxjf) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Axjf != null) && (this.jdField_a_of_type_Axjf.a != null))
    {
      String str = this.jdField_a_of_type_Axjf.a.a();
      axjg localaxjg = this.jdField_a_of_type_Axjk.a(str);
      if ((localaxjg != null) && (!localaxjg.a))
      {
        localaxjg.c = paramInt;
        this.jdField_a_of_type_Axjk.a(str, localaxjg);
        axjk.a(this.jdField_a_of_type_Axjk, localaxjg, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramBoolean);
    }
    axjk.a(this.jdField_a_of_type_Axjk, this.jdField_a_of_type_Axjf, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjw
 * JD-Core Version:    0.7.0.1
 */