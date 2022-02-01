import com.tencent.qphone.base.util.QLog;

class awxo
  implements ayxc
{
  awxo(awxi paramawxi, awxd paramawxd) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    awxi.a(this.jdField_a_of_type_Awxi, this.jdField_a_of_type_Awxd, paramInt);
  }
  
  public void a(ayxd paramayxd)
  {
    int j;
    int i;
    if (paramayxd != null)
    {
      j = paramayxd.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq result = " + j);
      }
      if (paramayxd.jdField_a_of_type_Ayxt != null)
      {
        i = paramayxd.jdField_a_of_type_Ayxt.jdField_a_of_type_Int;
        paramayxd = paramayxd.jdField_a_of_type_Ayxt.b;
      }
    }
    for (;;)
    {
      awxi.a(this.jdField_a_of_type_Awxi, this.jdField_a_of_type_Awxd, j, i, paramayxd);
      return;
      i = 0;
      paramayxd = "";
      continue;
      j = 0;
      i = 0;
      paramayxd = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxo
 * JD-Core Version:    0.7.0.1
 */