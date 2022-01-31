import com.tencent.qphone.base.util.QLog;

class asvb
  implements aumy
{
  asvb(asuu paramasuu, asup paramasup) {}
  
  public void a(int paramInt, boolean paramBoolean)
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
  
  public void a(aumz paramaumz)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramaumz != null)
    {
      k = paramaumz.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramaumz.jdField_a_of_type_Aunp != null)
      {
        i = paramaumz.jdField_a_of_type_Aunp.jdField_a_of_type_Int;
        str = paramaumz.jdField_a_of_type_Aunp.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Asup, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvb
 * JD-Core Version:    0.7.0.1
 */