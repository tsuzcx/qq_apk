import com.tencent.qphone.base.util.QLog;

class awdo
  implements aycx
{
  awdo(awdi paramawdi, awdd paramawdd) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    awdi.a(this.jdField_a_of_type_Awdi, this.jdField_a_of_type_Awdd, paramInt);
  }
  
  public void a(aycy paramaycy)
  {
    int j;
    int i;
    if (paramaycy != null)
    {
      j = paramaycy.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq result = " + j);
      }
      if (paramaycy.jdField_a_of_type_Aydp != null)
      {
        i = paramaycy.jdField_a_of_type_Aydp.jdField_a_of_type_Int;
        paramaycy = paramaycy.jdField_a_of_type_Aydp.b;
      }
    }
    for (;;)
    {
      awdi.a(this.jdField_a_of_type_Awdi, this.jdField_a_of_type_Awdd, j, i, paramaycy);
      return;
      i = 0;
      paramaycy = "";
      continue;
      j = 0;
      i = 0;
      paramaycy = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdo
 * JD-Core Version:    0.7.0.1
 */