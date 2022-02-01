import com.tencent.qphone.base.util.QLog;

class axqh
  implements azpp
{
  axqh(axqb paramaxqb, axpw paramaxpw) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    axqb.a(this.jdField_a_of_type_Axqb, this.jdField_a_of_type_Axpw, paramInt);
  }
  
  public void a(azpq paramazpq)
  {
    int j;
    int i;
    if (paramazpq != null)
    {
      j = paramazpq.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq result = " + j);
      }
      if (paramazpq.jdField_a_of_type_Azqh != null)
      {
        i = paramazpq.jdField_a_of_type_Azqh.jdField_a_of_type_Int;
        paramazpq = paramazpq.jdField_a_of_type_Azqh.b;
      }
    }
    for (;;)
    {
      axqb.a(this.jdField_a_of_type_Axqb, this.jdField_a_of_type_Axpw, j, i, paramazpq);
      return;
      i = 0;
      paramazpq = "";
      continue;
      j = 0;
      i = 0;
      paramazpq = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqh
 * JD-Core Version:    0.7.0.1
 */