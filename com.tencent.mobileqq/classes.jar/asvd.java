import com.tencent.qphone.base.util.QLog;

class asvd
  implements auna
{
  asvd(asuw paramasuw, asur paramasur) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Asur.a != null)
    {
      String str = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asur.a.a);
      asus localasus = this.jdField_a_of_type_Asuw.a(str);
      if ((localasus != null) && (!localasus.a))
      {
        localasus.c = (paramInt / 100);
        this.jdField_a_of_type_Asuw.a(str, localasus);
        asuw.a(this.jdField_a_of_type_Asuw, localasus, paramInt / 100);
      }
    }
  }
  
  public void a(aunb paramaunb)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramaunb != null)
    {
      k = paramaunb.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramaunb.jdField_a_of_type_Aunr != null)
      {
        i = paramaunb.jdField_a_of_type_Aunr.jdField_a_of_type_Int;
        str = paramaunb.jdField_a_of_type_Aunr.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asur, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvd
 * JD-Core Version:    0.7.0.1
 */