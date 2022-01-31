import com.tencent.qphone.base.util.QLog;

class auqo
  implements arqb
{
  auqo(auqc paramauqc, String paramString, aupx paramaupx) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aupx != null) && (this.jdField_a_of_type_Aupx.a != null))
    {
      String str = this.jdField_a_of_type_Aupx.a.a();
      aupy localaupy = this.jdField_a_of_type_Auqc.a(str);
      if ((localaupy != null) && (!localaupy.a))
      {
        localaupy.c = paramInt;
        this.jdField_a_of_type_Auqc.a(str, localaupy);
        auqc.a(this.jdField_a_of_type_Auqc, localaupy, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramBoolean);
    }
    auqc.a(this.jdField_a_of_type_Auqc, this.jdField_a_of_type_Aupx, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqo
 * JD-Core Version:    0.7.0.1
 */