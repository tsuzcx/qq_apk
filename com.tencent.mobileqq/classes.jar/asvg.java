import com.tencent.qphone.base.util.QLog;

class asvg
  implements apsm
{
  asvg(asuu paramasuu, String paramString, asup paramasup) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Asup != null) && (this.jdField_a_of_type_Asup.a != null))
    {
      String str = this.jdField_a_of_type_Asup.a.a();
      asuq localasuq = this.jdField_a_of_type_Asuu.a(str);
      if ((localasuq != null) && (!localasuq.a))
      {
        localasuq.c = paramInt;
        this.jdField_a_of_type_Asuu.a(str, localasuq);
        asuu.a(this.jdField_a_of_type_Asuu, localasuq, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramBoolean);
    }
    asuu.a(this.jdField_a_of_type_Asuu, this.jdField_a_of_type_Asup, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvg
 * JD-Core Version:    0.7.0.1
 */