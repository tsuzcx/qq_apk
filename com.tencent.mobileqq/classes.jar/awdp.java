import com.tencent.qphone.base.util.QLog;

class awdp
  implements aycx
{
  awdp(awdi paramawdi, awdd paramawdd) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Awdd.a != null)
    {
      String str = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Awdd.a.a);
      awde localawde = this.jdField_a_of_type_Awdi.a(str);
      if ((localawde != null) && (!localawde.a))
      {
        localawde.c = (paramInt / 100);
        this.jdField_a_of_type_Awdi.a(str, localawde);
        awdi.a(this.jdField_a_of_type_Awdi, localawde, paramInt / 100);
      }
    }
  }
  
  public void a(aycy paramaycy)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramaycy != null)
    {
      k = paramaycy.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramaycy.jdField_a_of_type_Aydp != null)
      {
        i = paramaycy.jdField_a_of_type_Aydp.jdField_a_of_type_Int;
        str = paramaycy.jdField_a_of_type_Aydp.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Awdd, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdp
 * JD-Core Version:    0.7.0.1
 */