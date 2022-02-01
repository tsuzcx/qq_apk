import com.tencent.qphone.base.util.QLog;

class axqi
  implements azpp
{
  axqi(axqb paramaxqb, axpw paramaxpw) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axpw.a != null)
    {
      String str = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axpw.a.a);
      axpx localaxpx = this.jdField_a_of_type_Axqb.a(str);
      if ((localaxpx != null) && (!localaxpx.a))
      {
        localaxpx.c = (paramInt / 100);
        this.jdField_a_of_type_Axqb.a(str, localaxpx);
        axqb.a(this.jdField_a_of_type_Axqb, localaxpx, paramInt / 100);
      }
    }
  }
  
  public void a(azpq paramazpq)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramazpq != null)
    {
      k = paramazpq.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramazpq.jdField_a_of_type_Azqh != null)
      {
        i = paramazpq.jdField_a_of_type_Azqh.jdField_a_of_type_Int;
        str = paramazpq.jdField_a_of_type_Azqh.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axpw, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqi
 * JD-Core Version:    0.7.0.1
 */