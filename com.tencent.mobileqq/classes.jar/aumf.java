import com.tencent.qphone.base.util.QLog;

class aumf
  implements arls
{
  aumf(ault paramault, String paramString, aulo paramaulo) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aulo != null) && (this.jdField_a_of_type_Aulo.a != null))
    {
      String str = this.jdField_a_of_type_Aulo.a.a();
      aulp localaulp = this.jdField_a_of_type_Ault.a(str);
      if ((localaulp != null) && (!localaulp.a))
      {
        localaulp.c = paramInt;
        this.jdField_a_of_type_Ault.a(str, localaulp);
        ault.a(this.jdField_a_of_type_Ault, localaulp, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramBoolean);
    }
    ault.a(this.jdField_a_of_type_Ault, this.jdField_a_of_type_Aulo, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aumf
 * JD-Core Version:    0.7.0.1
 */