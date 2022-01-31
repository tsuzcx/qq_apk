import com.tencent.qphone.base.util.QLog;

class asvc
  implements auna
{
  asvc(asuw paramasuw, asur paramasur) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    asuw.a(this.jdField_a_of_type_Asuw, this.jdField_a_of_type_Asur, paramInt);
  }
  
  public void a(aunb paramaunb)
  {
    int j;
    int i;
    if (paramaunb != null)
    {
      j = paramaunb.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq result = " + j);
      }
      if (paramaunb.jdField_a_of_type_Aunr != null)
      {
        i = paramaunb.jdField_a_of_type_Aunr.jdField_a_of_type_Int;
        paramaunb = paramaunb.jdField_a_of_type_Aunr.b;
      }
    }
    for (;;)
    {
      asuw.a(this.jdField_a_of_type_Asuw, this.jdField_a_of_type_Asur, j, i, paramaunb);
      return;
      i = 0;
      paramaunb = "";
      continue;
      j = 0;
      i = 0;
      paramaunb = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvc
 * JD-Core Version:    0.7.0.1
 */