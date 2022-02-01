import com.tencent.qphone.base.util.QLog;

class axqn
  implements ault
{
  axqn(axqb paramaxqb, String paramString, axpw paramaxpw) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Axpw != null) && (this.jdField_a_of_type_Axpw.a != null))
    {
      String str = this.jdField_a_of_type_Axpw.a.a();
      axpx localaxpx = this.jdField_a_of_type_Axqb.a(str);
      if ((localaxpx != null) && (!localaxpx.a))
      {
        localaxpx.c = paramInt;
        this.jdField_a_of_type_Axqb.a(str, localaxpx);
        axqb.a(this.jdField_a_of_type_Axqb, localaxpx, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramBoolean);
    }
    axqb.a(this.jdField_a_of_type_Axqb, this.jdField_a_of_type_Axpw, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqn
 * JD-Core Version:    0.7.0.1
 */