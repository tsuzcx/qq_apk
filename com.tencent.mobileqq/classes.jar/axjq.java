import com.tencent.qphone.base.util.QLog;

class axjq
  implements azjj
{
  axjq(axjk paramaxjk, axjf paramaxjf) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    axjk.a(this.jdField_a_of_type_Axjk, this.jdField_a_of_type_Axjf, paramInt);
  }
  
  public void a(azjk paramazjk)
  {
    int j;
    int i;
    if (paramazjk != null)
    {
      j = paramazjk.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq result = " + j);
      }
      if (paramazjk.jdField_a_of_type_Azkb != null)
      {
        i = paramazjk.jdField_a_of_type_Azkb.jdField_a_of_type_Int;
        paramazjk = paramazjk.jdField_a_of_type_Azkb.b;
      }
    }
    for (;;)
    {
      axjk.a(this.jdField_a_of_type_Axjk, this.jdField_a_of_type_Axjf, j, i, paramazjk);
      return;
      i = 0;
      paramazjk = "";
      continue;
      j = 0;
      i = 0;
      paramazjk = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjq
 * JD-Core Version:    0.7.0.1
 */