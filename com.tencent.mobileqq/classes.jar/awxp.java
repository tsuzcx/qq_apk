import com.tencent.qphone.base.util.QLog;

class awxp
  implements ayxc
{
  awxp(awxi paramawxi, awxd paramawxd) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Awxd.a != null)
    {
      String str = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Awxd.a.a);
      awxe localawxe = this.jdField_a_of_type_Awxi.a(str);
      if ((localawxe != null) && (!localawxe.a))
      {
        localawxe.c = (paramInt / 100);
        this.jdField_a_of_type_Awxi.a(str, localawxe);
        awxi.a(this.jdField_a_of_type_Awxi, localawxe, paramInt / 100);
      }
    }
  }
  
  public void a(ayxd paramayxd)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramayxd != null)
    {
      k = paramayxd.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramayxd.jdField_a_of_type_Ayxt != null)
      {
        i = paramayxd.jdField_a_of_type_Ayxt.jdField_a_of_type_Int;
        str = paramayxd.jdField_a_of_type_Ayxt.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Awxd, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxp
 * JD-Core Version:    0.7.0.1
 */