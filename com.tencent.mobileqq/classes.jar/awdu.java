import com.tencent.qphone.base.util.QLog;

class awdu
  implements asyd
{
  awdu(awdi paramawdi, String paramString, awdd paramawdd) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Awdd != null) && (this.jdField_a_of_type_Awdd.a != null))
    {
      String str = this.jdField_a_of_type_Awdd.a.a();
      awde localawde = this.jdField_a_of_type_Awdi.a(str);
      if ((localawde != null) && (!localawde.a))
      {
        localawde.c = paramInt;
        this.jdField_a_of_type_Awdi.a(str, localawde);
        awdi.a(this.jdField_a_of_type_Awdi, localawde, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramBoolean);
    }
    awdi.a(this.jdField_a_of_type_Awdi, this.jdField_a_of_type_Awdd, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdu
 * JD-Core Version:    0.7.0.1
 */